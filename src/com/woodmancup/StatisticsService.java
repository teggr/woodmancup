package com.woodmancup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.woodmancup.MemberRepository.MemberSort;

public class StatisticsService {

	private static final Comparator<HallOfFameEntry> POINT_SORT = new Comparator<HallOfFameEntry>() {
		@Override
		public int compare(HallOfFameEntry o1, HallOfFameEntry o2) {
			return o2.getPoints() - o1.getPoints();
		}
	};
	private MemberRepository memberRepository;
	
	private SessionRepository sessionRepository;
	
	private TournamentRepository tournamentRepository;

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
		return list;
	}

	private HallOfFameEntry generateEntry(Member member) {
		int victories=0;
		int alternativeWoodmanCupWins=0;
		int puttOffWins=0;
		int wins=0;
		int draws=0;
		int losses=0;
		List<Appearance> appearances = member.getAppearances();
		for (Appearance appearance : appearances) {
			String teamId = appearance.getTeamId();
			Tournament tournament = tournamentRepository.findByTeamId(teamId);
			Team team = tournament.getTeam(teamId);
			if(team.isWinner() ){
				victories++;
			}
			Player player = member.createPlayer(teamId);
			if(player.isPuttOffWinner()){
				puttOffWins++;
			}
			if(player.isAlternativeWoodmanCupWinner()) {
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
		HallOfFameEntry entry = HallOfFameEntry.newInstance(victories,
				alternativeWoodmanCupWins, puttOffWins, wins, draws, losses, member);
		return entry;
	}

}
