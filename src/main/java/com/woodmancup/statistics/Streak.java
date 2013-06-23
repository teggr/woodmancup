package com.woodmancup.statistics;

public class Streak {
	public int currentStreak = 0;
	public int highestStreak = 0;
	
	public void resetStreak() {
		if(currentStreak>highestStreak) {
			highestStreak = currentStreak;
		}
		currentStreak = 0;
	}
	
	public void addToCurrentStreak() {
		currentStreak++;
	}
	
	public int getHighestStreak() {
		return highestStreak;
	}
}
