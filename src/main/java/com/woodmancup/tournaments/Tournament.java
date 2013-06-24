package com.woodmancup.tournaments;

import java.util.Date;
import java.util.List;

import com.woodmancup.members.Member;
import com.woodmancup.venues.Venue;

public class Tournament {

	public static Tournament newInstance(String id, Venue venue, Date date,
			Team team1, Team team2, List<Session> sessions) {
		Tournament tournament = new Tournament();
		tournament.team1 = team1;
		tournament.team2 = team2;
		tournament.id = id;
		tournament.date = date;
		tournament.venue = venue;
		tournament.sessions = sessions;
		return tournament;
	}

	private String id;
	private Date date;
	private Venue venue;
	private Team team1;
	private Team team2;
	private List<Session> sessions;
	private List<TeamMember> team1Members;
	private List<TeamMember> team2Members;

	public Venue getVenue() {
		return venue;
	}

	public String getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public Team getTeam1() {
		return team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public boolean hasTeam(String teamId) {
		if (team1.getId().equals(teamId)) {
			return true;
		} else if (team2.getId().equals(teamId)) {
			return true;
		}
		return false;
	}

	public Team getTeam(String teamId) {
		if (team1.getId().equals(teamId)) {
			return team1;
		} else if (team2.getId().equals(teamId)) {
			return team2;
		}
		return null;
	}

	public double getTeam1Points() {
		return getTeamPoints(team1);
	}

	public double getTeam2Points() {
		return getTeamPoints(team2);
	}

	private double getTeamPoints(Team team) {
		double points = 0;
		for (Session session : sessions) {
			points += session.getTeamPoints(team.getId());
		}
		return points;
	}

	public void setTeam1Members(List<TeamMember> team1Members) {
		this.team1Members = team1Members;
	}

	public List<TeamMember> getTeam1Members() {
		return team1Members;
	}

	public void setTeam2Members(List<TeamMember> team2Members) {
		this.team2Members = team2Members;
	}

	public List<TeamMember> getTeam2Members() {
		return team2Members;
	}
}
