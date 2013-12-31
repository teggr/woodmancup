package com.woodmancup.tournaments;

import com.woodmancup.members.Member;

public class TeamMember {

	public static TeamMember newInstance(Member member, Appearance appearance) {
		TeamMember teamMember = new TeamMember();
		teamMember.member = member;
		teamMember.appearance = appearance;
		return teamMember;
	}
	
	private Member member;
	private Appearance appearance;
	
	public Appearance getAppearance() {
		return appearance;
	}
	
	public Member getMember() {
		return member;
	}

}
