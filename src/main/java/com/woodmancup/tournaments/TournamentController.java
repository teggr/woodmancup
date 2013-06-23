package com.woodmancup.tournaments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woodmancup.members.Member;
import com.woodmancup.members.MemberRepository;
import com.woodmancup.tournaments.TournamentRepository.TournamentSort;

@Controller
public class TournamentController {

	private TournamentRepository tournamentRepository;

	private AppearanceRepository appearanceRepository;
	
	private MemberRepository memberRepository;

	@Autowired
	public TournamentController(TournamentRepository tournamentRepository,
			AppearanceRepository appearanceRepository, MemberRepository memberRepository) {
		this.tournamentRepository = tournamentRepository;
		this.appearanceRepository = appearanceRepository;
		this.memberRepository = memberRepository;
	}

	@RequestMapping(value = "/tournaments", method = RequestMethod.GET)
	@ResponseBody
	public List<Tournament> listTournaments() {
		return tournamentRepository.findAll(TournamentSort.DATE_REVERSE);
	}
	
	@RequestMapping(value = "/tournaments/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Tournament getTournament(@PathVariable String id) {
		Tournament tournament = tournamentRepository.findById(id);
		tournament.setTeam1Members(getTeamMembers(tournament.getTeam1().getId()));
		tournament.setTeam2Members(getTeamMembers(tournament.getTeam2().getId()));
		return tournament;
	}

	private List<Member> getTeamMembers(String teamId) {
		List<Appearance> team1Appearances = appearanceRepository.getAppearancesByTeam(teamId);
		List<Member> list = new ArrayList<Member>();
		for (Appearance appearance : team1Appearances) {
			Member member = memberRepository.findById(appearance.getMemberId());
			list .add(member);
		}
		return list;
	}

	@RequestMapping(value = "/appearances", method = RequestMethod.GET)
	@ResponseBody
	public List<Appearance> listAppearances() {
		return appearanceRepository.getAppearances();
	}

}
