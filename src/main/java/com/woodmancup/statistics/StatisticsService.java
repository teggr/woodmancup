package com.woodmancup.statistics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woodmancup.members.Member;
import com.woodmancup.members.MemberRepository;
import com.woodmancup.members.MemberRepository.MemberSort;
import com.woodmancup.tournaments.Appearance;
import com.woodmancup.tournaments.AppearanceRepository;
import com.woodmancup.tournaments.Session;
import com.woodmancup.tournaments.SessionRepository;
import com.woodmancup.tournaments.Team;
import com.woodmancup.tournaments.Tournament;
import com.woodmancup.tournaments.TournamentRepository;

@Service
public class StatisticsService {

	private static final Comparator<HallOfFameEntry> POINT_SORT = new Comparator<HallOfFameEntry>() {
		@Override
		public int compare(HallOfFameEntry o1, HallOfFameEntry o2) {
			return o2.getPoints() - o1.getPoints();
		}
	};
	
	private static final Comparator<RecordEntry> Value_SORT = new Comparator<RecordEntry>() {
		@Override
		public int compare(RecordEntry o1, RecordEntry o2) {
			return o2.getValue() - o1.getValue();
		}
	};
	
	private MemberRepository memberRepository;
	
	private SessionRepository sessionRepository;
	
	private TournamentRepository tournamentRepository;
	
	private AppearanceRepository appearanceRepository;
	
	@Autowired
	public void setAppearanceRepository(
			AppearanceRepository appearanceRepository) {
		this.appearanceRepository = appearanceRepository;
	}

	@Autowired
	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Autowired
	public void setSessionRepository(SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}
	
	@Autowired
	public void setTournamentRepository(
			TournamentRepository tournamentRepository) {
		this.tournamentRepository = tournamentRepository;
	}

	public List<HallOfFameEntry> generateHallOfFameEntries() {
		List<HallOfFameEntry> list = new ArrayList<HallOfFameEntry>();
		List<Member> members = memberRepository.findAll(MemberSort.NONE);
		for (Member member : members) {
			HallOfFameEntry entry = generateEntry(member);
			list.add(entry);
		}
		Collections.sort(list, POINT_SORT);
		for (int i = 0; i < list.size(); i++) {
			HallOfFameEntry hallOfFameEntry = list.get(i);
			hallOfFameEntry.setPosition(i+1);
		}
		return list;
	}

	private HallOfFameEntry generateEntry(Member member) {
		int victories=0;
		int alternativeWoodmanCupWins=0;
		int puttOffWins=0;
		int wins=0;
		int draws=0;
		int losses=0;
		List<Appearance> appearances = appearanceRepository.getAppearancesByMember(member.getId());
		for (Appearance appearance : appearances) {
			String teamId = appearance.getTeamId();
			Tournament tournament = tournamentRepository.findByTeamId(teamId);
			Team team = tournament.getTeam(teamId);
			if(team.isWinner() ){
				victories++;
			}
			if(appearance.isPuttOffWinner()){
				puttOffWins++;
			}
			if(appearance.isAlternativeWoodmanCupWinner()) {
				alternativeWoodmanCupWins++;
			}
			List<Session> sessions = sessionRepository.findSessionsByTournamentId(tournament.getId());
			for (Session session : sessions) {
				int result = session.getResult(teamId,member.getId());
				if(result>0){
					wins++;
				}else if(result<0){
					losses++;
				}else {
					draws++;
				}
			}
		}
		HallOfFameEntry entry = HallOfFameEntry.newInstance(appearances.size(), victories,
				alternativeWoodmanCupWins, puttOffWins, wins, draws, losses, member);
		return entry;
	}

	public Records generateRecords() {
		Records fullRecords = new Records();
		List<Member> members = memberRepository.findAll(MemberSort.NONE);
		for (Member member : members) {
			addMembersRecords(member,fullRecords);
		}
		// filter only the top three
		return filteredAndSortedRecords(fullRecords);
	}

	private Records filteredAndSortedRecords(Records fullRecords) {
		Records records = new Records();
		records.getMostLikelyToWinTheWoodman().addAll(filterAndSort(fullRecords.getMostLikelyToWinTheWoodman())); 
		records.getMostLikelyToWin().addAll(filterAndSort(fullRecords.getMostLikelyToWin()));
		records.getMostLikelyToLose().addAll(filterAndSort(fullRecords.getMostLikelyToLose()));
		records.getMostLikelyToDraw().addAll(filterAndSort(fullRecords.getMostLikelyToDraw()));

		records.getLongestUnbeatenStreak().addAll(filterAndSort(fullRecords.getLongestUnbeatenStreak()));
		records.getLongestWinningStreak().addAll(filterAndSort(fullRecords.getLongestWinningStreak()));
		records.getLongestLosingStreak().addAll(filterAndSort(fullRecords.getLongestLosingStreak()));

		records.getBiggestBandits().addAll(filterAndSort(fullRecords.getBiggestBandits()));
		records.getBestPutters().addAll(filterAndSort(fullRecords.getBestPutters()));
		return records;
	}

	private Collection<RecordEntry> filterAndSort(
			List<RecordEntry> entries) {
		Collections.sort(entries, Value_SORT);
		return entries.subList(0, 3);
	}

	private void addMembersRecords(Member member, Records records) {
		int victories=0;
		int puttOffWins=0;
		int wins=0;
		int draws=0;
		int losses=0;
		
		Streak unbeaten = new Streak();
		Streak winning = new Streak();
		Streak losing = new Streak();
		
		List<Appearance> appearances = appearanceRepository.getAppearancesByMember(member.getId());
		for (Appearance appearance : appearances) {
			String teamId = appearance.getTeamId();
			Tournament tournament = tournamentRepository.findByTeamId(teamId);
			Team team = tournament.getTeam(teamId);
			if(team.isWinner() ){
				victories++;
			}
			if(appearance.isPuttOffWinner()){
				puttOffWins++;
			}
			List<Session> sessions = sessionRepository.findSessionsByTournamentId(tournament.getId());
			for (Session session : sessions) {
				int result = session.getResult(teamId,member.getId());
				if(result>0){
					wins++;
					unbeaten.addToCurrentStreak();
					winning.addToCurrentStreak();
					losing.resetStreak();
				}else if(result<0){
					losses++;
					unbeaten.resetStreak();
					winning.resetStreak();
					losing.addToCurrentStreak();
				}else {
					draws++;
					unbeaten.addToCurrentStreak();
					winning.resetStreak();
					losing.resetStreak();
				}
			}
		}
		
		addCalculatedRecords(records, member, appearances.size(), victories, wins, draws, losses, unbeaten, winning, losing, puttOffWins);
		
	}

	private void addCalculatedRecords(Records records, Member member, int appearances, int victories, int wins,
			int draws, int losses, Streak unbeaten, Streak winning,
			Streak losing, int puttOffWins) {
		
		records.getMostLikelyToWinTheWoodman().add(new RecordEntry(member, (int) Math.round( victories * appearances * 100.0 / appearances ) ));
		int matches = wins+draws+losses;
		records.getMostLikelyToWin().add(new RecordEntry(member, (int) Math.round(wins * appearances * 100.0 / matches  )));
		records.getMostLikelyToDraw().add(new RecordEntry(member, (int) Math.round(draws * appearances * 100.0 / matches)));
		records.getMostLikelyToLose().add(new RecordEntry(member, (int) Math.round(losses * appearances * 100.0 / matches)));
		
		records.getLongestUnbeatenStreak().add(new RecordEntry(member, unbeaten.getHighestStreak()));
		records.getLongestWinningStreak().add(new RecordEntry(member, winning.getHighestStreak()));
		records.getLongestLosingStreak().add(new RecordEntry(member, losing.getHighestStreak()));
		
		records.getBiggestBandits().add(new RecordEntry(member,(int) Math.round( (wins + draws) * appearances * 100.0 / matches )));
		records.getBestPutters().add(new RecordEntry(member, (int) Math.round(puttOffWins * appearances * 100.0 / appearances )));
		
	}

}
