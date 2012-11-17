package com.woodmancup;

import java.util.Arrays;
import java.util.List;

public class Group {

	public static Group newInstance(String teamId, Member... members) {
		Group group = new Group();
		group.teamId = teamId;
		group.members = Arrays.asList(members);
		System.out.println(teamId + " " + group.members);
		return group;
	}

	private String teamId;
	private List<Member> members;

	public List<Member> getMembers() {
		return members;
	}

	public String getTeamId() {
		return teamId;
	}

	public int getMemberCount() {
		return members.size();
	}

	public boolean containsMember(String memberId) {
		for (Member member : members) {
			if (member.getId().equals(memberId)) {
				return true;
			}
		}
		return false;
	}
	
}
