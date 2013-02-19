package com.woodmancup.app;

import java.io.IOException;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.repackaged.org.codehaus.jackson.JsonGenerationException;
import com.google.appengine.repackaged.org.codehaus.jackson.map.JsonMappingException;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ObjectMapper;
import com.woodmancup.members.MemberController;
import com.woodmancup.statistics.StatisticsController;
import com.woodmancup.tournaments.TournamentController;
import com.woodmancup.venues.VenueController;

@Controller
public class IndexController {

	private StatisticsController statisticsController;

	private MemberController memberController;

	private VenueController venueController;

	private TournamentController tournamentController;

	@Autowired
	public IndexController(StatisticsController statisticsController,
			MemberController memberController, VenueController venueController,
			TournamentController tournamentController) {
		super();
		this.statisticsController = statisticsController;
		this.memberController = memberController;
		this.venueController = venueController;
		this.tournamentController = tournamentController;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMessage(ModelMap modelMap) throws JsonGenerationException,
			JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		StringWriter hallOfFameEntries = new StringWriter();
		mapper.writeValue(hallOfFameEntries, statisticsController.list());

		StringWriter members = new StringWriter();
		mapper.writeValue(members, memberController.list());

		StringWriter venues = new StringWriter();
		mapper.writeValue(venues, venueController.list());

		StringWriter tournaments = new StringWriter();
		mapper.writeValue(tournaments, tournamentController.listTournaments());

		StringWriter appearances = new StringWriter();
		mapper.writeValue(appearances, tournamentController.listAppearances());

		modelMap.addAttribute("hallOfFameEntries", hallOfFameEntries);
		modelMap.addAttribute("members", members);
		modelMap.addAttribute("venues", venues);
		modelMap.addAttribute("tournaments", tournaments);
		modelMap.addAttribute("appearances", appearances);

		return "index";
	}

}
