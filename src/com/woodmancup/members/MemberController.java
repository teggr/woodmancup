package com.woodmancup.members;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	private MemberRepository memberRepository;
	
	@Autowired
	public MemberController(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@RequestMapping(value = "/members", method = RequestMethod.GET)
	@ResponseBody
	public List<Member> list()  {
		return memberRepository.getMembers();
	}
	
	@RequestMapping(value = "/members", method = RequestMethod.POST)
	@ResponseBody
	public Member create(Member member)  {
		return memberRepository.create(member);
	}

}
