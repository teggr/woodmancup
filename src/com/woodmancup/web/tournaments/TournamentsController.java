package com.woodmancup.web.tournaments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author robin
 *
 */
@Controller("tournaments")
public class TournamentsController {

	private static final String TOURNAMENT_EDIT = "tournaments/tournament-edit";

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit() {

		return TOURNAMENT_EDIT;
	}
}
