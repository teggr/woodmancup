package com.woodmancup.tournaments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhotosController {

	@RequestMapping(value = "/photos.html", method = RequestMethod.GET)
	public String photos(ModelMap modelMap) {
		return "photos";
	}

	@RequestMapping(value = "/album.html", method = RequestMethod.GET)
	public String album(@RequestParam(value = "album") String id, @RequestParam(value = "album_title") String title,
			ModelMap modelMap) {
		modelMap.addAttribute("id", id);
		modelMap.addAttribute("title", title);
		return "album";
	}

}
