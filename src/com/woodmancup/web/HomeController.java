package com.woodmancup.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author robin
 * 
 */
@Controller
public class HomeController {

	private static final Logger log = LoggerFactory
			.getLogger(HomeController.class);

	private static final String HOME_VIEW = "home";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String show() {
		log.debug("Inside HomeController show()");
		return HOME_VIEW;
	}
}
