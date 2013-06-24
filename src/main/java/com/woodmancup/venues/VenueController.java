package com.woodmancup.venues;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woodmancup.venues.VenueRepository.VenueSort;

@Controller
@RequestMapping("/venues.html")
public class VenueController {

	private VenueRepository venueRepository;

	@Autowired
	public VenueController(VenueRepository venueRepository) {
		this.venueRepository = venueRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String venues(ModelMap modelMap) {
		List<Venue> venues = venueRepository.findAll(VenueSort.NAME);
		modelMap.addAttribute("venues", venues);
		return "venues";
	}
	
}
