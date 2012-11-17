package com.woodmancup;

public class HallOfFameEntry {
	
	public static HallOfFameEntry newInstance(int victories,
			int alternativeWoodmanCupWins, int puttOffWins, int wins,
			int draws, int losses, Member member) {
		return new HallOfFameEntry(victories, alternativeWoodmanCupWins,
				puttOffWins, wins, draws, losses, member);
	}

	private int victories = 0;
	private int alternativeWoodmanCupWins = 0;
	private int puttOffWins = 0;
	private int wins = 0;
	private int draws =0;
	private int losses = 0;
	private Member member;
	
	private HallOfFameEntry(int victories, int alternativeWoodmanCupWins,
			int puttOffWins, int wins, int draws, int losses, Member member) {
		super();
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

}
