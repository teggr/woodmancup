package com.woodmancup.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping({"/index.html","/halloffame.html"})
public class HallOfFameController {

	private StatisticsService statisticsService;

	@Autowired
	public HallOfFameController(StatisticsService statisticsService) {
		super();
		this.statisticsService = statisticsService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) { 
		map.addAttribute("hallOfFameEntries",
				 statisticsService.generateHallOfFameEntries());
		return "halloffame";
	}

}
