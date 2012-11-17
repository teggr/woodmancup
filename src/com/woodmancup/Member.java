package com.woodmancup;

import java.util.Arrays;
import java.util.List;

public class Member {

	public static Member newInstance(String id, String firstname,
			String surname, Appearance... appearances) {
		Member member = new Member();
		member.id = id;
		member.firstname = firstname;
		member.surname = surname;
		member.appearances = Arrays.asList(appearances);
		return member;
	}

	private List<Appearance> appearances;
	private String firstname;
	private String surname;
	private String id;

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public String getId() {
		return id;
	}

	public int getAppearanceCount() {
		return appearances.size();
	}
	
	public List<Appearance> getAppearances() {
		return appearances;
	}

	public boolean didAppearFor(String teamId) {
		for (Appearance appearance : appearances) {
			if (appearance.getTeamId().equals(teamId)) {
				return true;
			}
		}
		return false;
	}

	public Player createPlayer(String teamId) {
		for (Appearance appearance : appearances) {
			if (appearance.getTeamId().equals(teamId)) {
				return Player.newInstance(firstname, surname,
						appearance.isCaptain(), appearance.isPuttOffWinner(),
						appearance.isAlternativeWoodmanCupWinner(),
						appearance.getHandicap());
			}
		}
		return null;
	}

}
