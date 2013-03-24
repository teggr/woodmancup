package com.woodmancup.members;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woodmancup.tournaments.AppearanceRepository;

@Controller
@RequestMapping("/members")
public class MemberController {

	private MemberRepository memberRepository;

	private AppearanceRepository appearanceRepository;

	@Autowired
	public MemberController(MemberRepository memberRepository,
			AppearanceRepository appearanceRepository) {
		this.memberRepository = memberRepository;
		this.appearanceRepository = appearanceRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Member> list() {
		List<Member> members = memberRepository.getMembers();
		for (Member member : members) {
			member.setAppearances(appearanceRepository
					.getAppearancesByMember(member.getId()));
		}
		return members;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Member create(@RequestBody Member member) {
		return memberRepository.create(member);
	}

}
