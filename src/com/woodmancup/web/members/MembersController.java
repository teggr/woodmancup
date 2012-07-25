package com.woodmancup.web.members;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author robin
 * 
 */
@Controller
@RequestMapping(value = "/members")
public class MembersController {

	private static final Logger log = LoggerFactory
			.getLogger(MembersController.class);

	private static final String MEMBERS_VIEW = "members/members";

	private static final String MEMBER_EDIT_VIEW = "members/member-edit";

	private static final String DEFAULT_PROFILE_PIC_URL = "/img/profile.jpg";

	private final MembersDao membersDao;

	public MembersController(MembersDao membersDao) {
		this.membersDao = membersDao;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		modelMap.addAttribute(new Member());
		return MEMBER_EDIT_VIEW;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Member member, ModelMap modelMap) {
		log.debug("Creating {}", member);
		List<Member> members = membersDao.getAll();
		modelMap.addAttribute(members);
		return MEMBERS_VIEW;
	}

	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	public String get(@PathVariable String key, ModelMap modelMap) {
		Member member = membersDao.get(key);
		modelMap.addAttribute(member);
		return MEMBER_EDIT_VIEW;
	}

	@RequestMapping(value = "/edit/{key}", method = RequestMethod.GET)
	public String edit(@PathVariable String key, ModelMap modelMap) {
		Member member = membersDao.get(key);
		modelMap.addAttribute(member);
		return MEMBER_EDIT_VIEW;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String add(Member member, ModelMap modelMap) {
		log.debug("Creating {}", member);
		return update(null, member, modelMap);
	}

	@RequestMapping(value = "/{key}", method = RequestMethod.POST)
	public String update(@PathVariable String key, Member member,
			ModelMap modelMap) {
		log.debug("Updating {}", member);
		addDefaults(member);
		member.setKey(key);
		member = membersDao.saveMember(member);
		return "redirect:/members";
	}

	@RequestMapping(value = "/delete/{key}", method = RequestMethod.GET)
	public String remove(@PathVariable String key) {
		membersDao.delete(key);
		return "redirect:/members";
	}

	private void addDefaults(Member member) {
		if (StringUtils.isBlank(member.getProfilePictureUrl())) {
			member.setProfilePictureUrl(DEFAULT_PROFILE_PIC_URL);
		}
		System.out.println("Createing" + member);
	}

}
