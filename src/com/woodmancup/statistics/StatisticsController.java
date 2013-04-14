package com.woodmancup.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/stats")
public class StatisticsController {

	private StatisticsService statisticsService;

	@Autowired
	public StatisticsController(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}

	@RequestMapping(value = "/halloffame", method = RequestMethod.GET)
	@ResponseBody
	public List<HallOfFameEntry> getHallOfFameEntries() {
		return statisticsService.generateHallOfFameEntries();
	}
	
	@RequestMapping(value = "/records", method = RequestMethod.GET)
	@ResponseBody
	public Records getRecords() {
		return statisticsService.generateRecords();
	}

}
