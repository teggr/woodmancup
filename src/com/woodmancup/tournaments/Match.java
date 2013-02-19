package com.woodmancup.tournaments;

import java.util.Arrays;
import java.util.List;

public class Match {

	public static final String DRAW = "draw";

	public static Match newInstance(String winningTeamId, Group ... groups) {
		Match match = new Match();
		match.winningTeamId = winningTeamId;
		match.groups = Arrays.asList(groups);
		return match ;
	}
	
	private List<Group> groups;
	private  String winningTeamId;

	public List<Group> getGroups() {
		return groups;
	}
	
	public String getWinningTeamId() {
		return winningTeamId;
	}

	public boolean containsMember(String memberId) {
		for (Group group : groups) {
			if(group.containsMember(memberId)) {
				return true;
			}
		}
		return false;
	}
	

}
