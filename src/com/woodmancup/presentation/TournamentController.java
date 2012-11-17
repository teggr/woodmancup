package com.woodmancup.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woodmancup.MemberRepository;
import com.woodmancup.MemberRepository.PlayerSort;
import com.woodmancup.Player;
import com.woodmancup.Tournament;
import com.woodmancup.TournamentRepository;
import com.woodmancup.TournamentRepository.TournamentSort;

@Controller
@RequestMapping("/tournament")
public class TournamentController {

	private TournamentRepository tournamentRepository;

	private MemberRepository memberRepository;

	@Autowired
	public void setTournamentRepository(
			TournamentRepository tournamentRepository) {
		this.tournamentRepository = tournamentRepository;
	}

	@Autowired
	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		List<Tournament> tournaments = tournamentRepository
				.findAll(TournamentSort.DATE_REVERSE);
		modelMap.addAttribute(tournaments);
		return "tournaments";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable String id, ModelMap modelMap) {
		Tournament tournament = tournamentRepository.findById(id);
		List<Player> team1 = memberRepository.findPlayersByTeamId(tournament
				.getTeam1().getId(), PlayerSort.SURNAME);
		List<Player> team2 = memberRepository.findPlayersByTeamId(tournament
				.getTeam2().getId(), PlayerSort.SURNAME);
		List<Player> allPlayers = new ArrayList<Player>();
		allPlayers.addAll(team1);
		allPlayers.addAll(team2);
		modelMap.addAttribute(tournament);
		modelMap.addAttribute("team1List", team1);
		modelMap.addAttribute("team2List", team2);
		modelMap.addAttribute("puttOffWinner", findPuttOffWinner(allPlayers));
		modelMap.addAttribute("alternativeWoodmanCupWinner",
				findAlternativeWoodmanCupWinner(allPlayers));
		return "tournament";
	}

	private Player findPuttOffWinner(List<Player> players) {
		for (Player player : players) {
			if (player.isPuttOffWinner()) {
				return player;
			}
		}
		return null;
	}

	private Player findAlternativeWoodmanCupWinner(List<Player> players) {
		for (Player player : players) {
			if (player.isAlternativeWoodmanCupWinner()) {
				return player;
			}
		}
		return null;
	}
}
