package com.woodmancup;

public class Player {


	public static Player newInstance(String firstname, String surname,
			boolean captain, boolean puttOffWinner, boolean alternativeWoodmanCupWinner, int handicap) {
		Player player = new Player();
		player.puttOffWinner = puttOffWinner;
		player.alternativeWoodmanCupWinner = alternativeWoodmanCupWinner;
		player.handicap = handicap;
		player.firstname = firstname;
		player.surname = surname;
		player.captain = captain;
		return player;
	}

	private String firstname;
	private String surname;
	private boolean captain;
	private  boolean puttOffWinner;
	private  boolean alternativeWoodmanCupWinner;
	private  int handicap;

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public boolean isCaptain() {
		return captain;
	}
	
	public boolean isAlternativeWoodmanCupWinner() {
		return alternativeWoodmanCupWinner;
	}
	
	public boolean isPuttOffWinner() {
		return puttOffWinner;
	}
	
	public int getHandicap() {
		return handicap;
	}
	
}
