package com.woodmancup.tournaments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/tournaments.html", method = RequestMethod.GET)
	public String tournaments(ModelMap modelMap) {
		 List<Tournament> tournaments = tournamentRepository.findAll(TournamentSort.DATE_REVERSE);
		 modelMap.addAttribute("tournaments", tournaments);
		 return "tournaments";
	}
	
	@RequestMapping(value = "/tournament.html", method = RequestMethod.GET)
	public String tournament(@RequestParam(value="tournament") String id, ModelMap modelMap) {
		Tournament tournament = tournamentRepository.findById(id);
		tournament.setTeam1Members(getTeamMembers(tournament.getTeam1().getId()));
		tournament.setTeam2Members(getTeamMembers(tournament.getTeam2().getId()));
		modelMap.addAttribute("tournament", tournament);
		return "tournament";
	}

	private List<TeamMember> getTeamMembers(String teamId) {
		List<Appearance> team1Appearances = appearanceRepository.getAppearancesByTeam(teamId);
		List<TeamMember> list = new ArrayList<TeamMember>();
		for (Appearance appearance : team1Appearances) {
			Member member = memberRepository.findById(appearance.getMemberId());
			list .add( TeamMember.newInstance( member, appearance ) );
		}
		return list;
	}

}
