package com.woodmancup.tournaments;

public class Appearance {

	public static Appearance newInstance(String teamId) {
		Appearance appearance = new Appearance();
		appearance.teamId = teamId;
		return appearance;
	}

	public static Appearance newInstanceAsPuttOffWinner(String teamId) {
		Appearance appearance = new Appearance();
		appearance.teamId = teamId;
		appearance.puttOffWinner = true;
		return appearance;
	}

	public static Appearance newInstanceAsAlternativeWoodmanCupWinner(
			String teamId) {
		Appearance appearance = new Appearance();
		appearance.teamId = teamId;
		appearance.alternativeWoodmanCupWinner = true;
		return appearance;
	}

	public static Appearance newInstanceAsCaptain(String teamId) {
		Appearance appearance = new Appearance();
		appearance.teamId = teamId;
		appearance.captain = true;
		return appearance;
	}


	public static Appearance newInstanceAsCaptainAndPuttOffWinner(String teamId) {
		Appearance appearance = new Appearance();
		appearance.teamId = teamId;
		appearance.captain = true;
		appearance.puttOffWinner = true;
		return appearance;
	}
	
	private boolean captain = false;

	private String teamId;

	private boolean puttOffWinner = false;

	private boolean alternativeWoodmanCupWinner = false;

	private String memberId;

	public String getTeamId() {
		return teamId;
	}

	public boolean isCaptain() {
		return captain;
	}

	public boolean isPuttOffWinner() {
		return puttOffWinner;
	}

	public boolean isAlternativeWoodmanCupWinner() {
		return alternativeWoodmanCupWinner;
	}

	public int getHandicap() {
		return 0;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberId() {
		return memberId;
	}

}
