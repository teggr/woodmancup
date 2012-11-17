package com.woodmancup.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woodmancup.Venue;
import com.woodmancup.VenueRepository;
import com.woodmancup.VenueRepository.VenueSort;


@Controller
@RequestMapping("/venue")
public class VenueController {

	private VenueRepository venueRepository;

	@Autowired
	public void setVenueRepository(VenueRepository venueRepository) {
		this.venueRepository = venueRepository;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		List<Venue> venues = venueRepository.findAll(VenueSort.NAME);
		modelMap.addAttribute(venues);
		return "venues";
	}

}
