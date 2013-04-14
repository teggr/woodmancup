package com.woodmancup.statistics;

import com.woodmancup.members.Member;

public class HallOfFameEntry {
	
	public static HallOfFameEntry newInstance(int appearances, int victories,
			int alternativeWoodmanCupWins, int puttOffWins, int wins,
			int draws, int losses, Member member) {
		return new HallOfFameEntry(appearances, victories, alternativeWoodmanCupWins,
				puttOffWins, wins, draws, losses, member);
	}

	private int victories = 0;
	private int alternativeWoodmanCupWins = 0;
	private int puttOffWins = 0;
	private int wins = 0;
	private int draws =0;
	private int losses = 0;
	private Member member;
	private int position;
	private int appearances = 0;
	
	private HallOfFameEntry(int appearances, int victories, int alternativeWoodmanCupWins,
			int puttOffWins, int wins, int draws, int losses, Member member) {
		super();
		this.appearances  = appearances;
		this.victories = victories;
		this.alternativeWoodmanCupWins = alternativeWoodmanCupWins;
		this.puttOffWins = puttOffWins;
		this.wins = wins;
		this.draws = draws;
		this.losses = losses;
		this.member = member;
	}

	public Member getMember() {
		return member;
	}
	
	public int getVictories() {
		return victories;
	}
	
	public int getAlternativeWoodmanCupWins() {
		return alternativeWoodmanCupWins;
	}
	
	public int getPuttOffWins() {
		return puttOffWins;
	}
	
	public int getWins() {
		return wins;
	}
	
	public int getDraws() {
		return draws;
	}
	
	public int getLosses() {
		return losses;
	}

	public int getPoints() {
		int total = 0;
		total += victories * 5;
		total += alternativeWoodmanCupWins * 4;
		total += puttOffWins * 4;
		total += wins * 3;
		total += draws * 1;
		return total;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getPosition() {
		return position;
	}
	
	public int getAppearances() {
		return appearances;
	}

}
