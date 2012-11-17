package com.woodmancup;

public class Team {

	public static Team newInstance(String id, String name, String colour) {
		Team team = new Team();
		team.id = id;
		team.name = name;
		team.colour = colour;
		return team;
	}
	
	public static Team newInstanceAsWinner(String id, String name, String colour) {
		Team team = new Team();
		team.id = id;
		team.name = name;
		team.colour = colour;
		team.isWinner = true;
		return team;
	}

	private String id;
	private String name;
	private String colour;
	private boolean isWinner = false;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getColour() {
		return colour;
	}

	public boolean isWinner() {
		return isWinner ;
	}

}
