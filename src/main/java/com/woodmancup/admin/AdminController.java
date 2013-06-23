package com.woodmancup.admin;

import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woodmancup.members.MemberRepository;
import com.woodmancup.members.MemberRepository.MemberSort;
import com.woodmancup.statistics.StatisticsService;
import com.woodmancup.tournaments.AppearanceRepository;
import com.woodmancup.tournaments.TournamentRepository;
import com.woodmancup.tournaments.TournamentRepository.TournamentSort;
import com.woodmancup.venues.VenueRepository;
import com.woodmancup.venues.VenueRepository.VenueSort;

@Controller
public class AdminController {

	private MemberRepository memberRepository;

	private VenueRepository venueRepository;

	private TournamentRepository tournamentRepository;

	private AppearanceRepository appearanceRepository;

	@Autowired
	public AdminController(StatisticsService statisticsService,
			MemberRepository memberRepository, VenueRepository venueRepository,
			TournamentRepository tournamentRepository,
			AppearanceRepository appearanceRepository) {
		this.memberRepository = memberRepository;
		this.venueRepository = venueRepository;
		this.tournamentRepository = tournamentRepository;
		this.appearanceRepository = appearanceRepository;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getMessage(ModelMap modelMap) throws JsonGenerationException,
			JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		StringWriter members = new StringWriter();
		mapper.writeValue(members, memberRepository.findAll(MemberSort.SURNAME));

		StringWriter venues = new StringWriter();
		mapper.writeValue(venues, venueRepository.findAll(VenueSort.NAME));

		StringWriter tournaments = new StringWriter();
		mapper.writeValue(tournaments,
				tournamentRepository.findAll(TournamentSort.DATE_REVERSE));

		StringWriter appearances = new StringWriter();
		mapper.writeValue(appearances, appearanceRepository.getAppearances());

		modelMap.addAttribute("members", members);
		modelMap.addAttribute("venues", venues);
		modelMap.addAttribute("tournaments", tournaments);
		modelMap.addAttribute("appearances", appearances);

		return "admin";
	}

}
