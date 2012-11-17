package com.woodmancup;

import java.util.Arrays;
import java.util.List;

public class Session {

	public static Session newInstance(String tournamentId,
			String sessionNumber, SessionFormat sessionFormat, Match... matches) {
		Session session = new Session();
		session.tournamentId = tournamentId;
		session.sessionNumber = sessionNumber;
		session.sessionFormat = sessionFormat;
		session.matches = Arrays.asList(matches);
		return session;
	}

	private String tournamentId;
	private String sessionNumber;
	private SessionFormat sessionFormat;
	private List<Match> matches;

	public SessionFormat getSessionFormat() {
		return sessionFormat;
	}

	public String getSessionNumber() {
		return sessionNumber;
	}

	public String getTournamentId() {
		return tournamentId;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public int getResult(String teamId, String memberId) {
		for (Match match : matches) {
			if (match.containsMember(memberId)) {
				if (match.getWinningTeamId().equals(teamId)) {
					return 1;
				} else if (match.getWinningTeamId().equals(Match.DRAW)) {
					return 0;
				}
			}
		}
		return -1;
	}

	public double getTeamPoints(String teamId) {
		double points = 0.0;
		for (Match match : matches) {
			if (match.getWinningTeamId().equals(teamId)) {
				points = points + 1.0;
			} else if (match.getWinningTeamId().equals(Match.DRAW)) {
				points = points + 0.5;
			}
		}
		return points;
	}
}
