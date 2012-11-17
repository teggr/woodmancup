package com.woodmancup.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woodmancup.StatisticsService;

@Controller
public class IndexController {
	
	private StatisticsService statisticsService;

	@Autowired
	public void setStatisticsService(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMessage(ModelMap modelMap) {
		modelMap.addAttribute("hallOfFameEntryList", statisticsService.generateHallOfFameEntries());
		return "index";
	}

}
