package com.woodmancup.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/stats.html")
public class StatisticsController {

	private StatisticsService statisticsService;

	@Autowired
	public StatisticsController(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String records(ModelMap modelMap) {
		Records records = statisticsService.generateRecords();
		modelMap.addAttribute("records", records);
		return "stats";
	}

}
