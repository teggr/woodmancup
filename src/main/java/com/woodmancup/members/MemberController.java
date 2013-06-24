package com.woodmancup.members;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woodmancup.tournaments.AppearanceRepository;

@Controller
@RequestMapping("/members.html")
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
	public String members(ModelMap modelMap) {
		List<Member> members = memberRepository.getMembers();
		for (Member member : members) {
			member.setAppearances(appearanceRepository
					.getAppearancesByMember(member.getId()));
		}
		Collections.sort(members, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				return o2.getAppearances().size() - o1.getAppearances().size();
			}
		});
		modelMap.addAttribute("members", members);
		return "members";
	}

}
