package com.woodmancup.tournaments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woodmancup.tournaments.TournamentRepository.TournamentSort;

@Controller
public class TournamentController {

	private TournamentRepository tournamentRepository;

	private AppearanceRepository appearanceRepository;

	@Autowired
	public TournamentController(TournamentRepository tournamentRepository,
			AppearanceRepository appearanceRepository) {
		this.tournamentRepository = tournamentRepository;
		this.appearanceRepository = appearanceRepository;
	}

	@RequestMapping(value = "/tournaments", method = RequestMethod.GET)
	@ResponseBody
	public List<Tournament> listTournaments() {
		return tournamentRepository.findAll(TournamentSort.DATE_REVERSE);
	}

	@RequestMapping(value = "/appearances", method = RequestMethod.GET)
	@ResponseBody
	public List<Appearance> listAppearances() {
		return appearanceRepository.getAppearances();
	}

}
