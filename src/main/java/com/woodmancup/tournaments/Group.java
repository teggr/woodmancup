package com.woodmancup.tournaments;

import java.util.Arrays;
import java.util.List;

import com.woodmancup.members.Member;

public class Group {

	public static Group newInstance(String teamId, Member... members) {
		Group group = new Group();
		group.teamId = teamId;
		group.members = Arrays.asList(members);
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
