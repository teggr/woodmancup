package com.woodmancup.venues;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woodmancup.venues.VenueRepository.VenueSort;

@Controller
public class VenueController {

	private VenueRepository venueRepository;

	@Autowired
	public VenueController(VenueRepository venueRepository) {
		this.venueRepository = venueRepository;
	}

	@RequestMapping(value = "/venues", method = RequestMethod.GET)
	@ResponseBody
	public List<Venue> list() {
		return venueRepository.findAll(VenueSort.NAME);
	}

}
