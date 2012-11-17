package com.woodmancup.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woodmancup.Member;
import com.woodmancup.MemberRepository;
import com.woodmancup.MemberRepository.MemberSort;

@Controller
@RequestMapping("/member")
public class MemberController {

	private MemberRepository memberRepository;

	@Autowired
	public MemberController(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		List<Member> members = memberRepository.findAll(MemberSort.SURNAME);
		modelMap.addAttribute(members);
		return "members";
	}

}
