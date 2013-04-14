package com.woodmancup.statistics;

import java.util.ArrayList;
import java.util.List;

public class Records {
	
	List<RecordEntry> mostLikelyToWinTheWoodman = new ArrayList<RecordEntry>();
	List<RecordEntry> mostLikelyToWin = new ArrayList<RecordEntry>();
	List<RecordEntry> mostLikelyToLose = new ArrayList<RecordEntry>();
	List<RecordEntry> mostLikelyToDraw = new ArrayList<RecordEntry>();

	List<RecordEntry> longestUnbeatenStreak = new ArrayList<RecordEntry>();
	List<RecordEntry> longestWinningStreak = new ArrayList<RecordEntry>();
	List<RecordEntry> longestLosingStreak = new ArrayList<RecordEntry>();

	List<RecordEntry> biggestBandits = new ArrayList<RecordEntry>();
	List<RecordEntry> bestPutters = new ArrayList<RecordEntry>();

	public List<RecordEntry> getMostLikelyToWin() {
		return mostLikelyToWin;
	}

	public List<RecordEntry> getMostLikelyToLose() {
		return mostLikelyToLose;
	}

	public List<RecordEntry> getMostLikelyToDraw() {
		return mostLikelyToDraw;
	}

	public List<RecordEntry> getLongestUnbeatenStreak() {
		return longestUnbeatenStreak;
	}

	public List<RecordEntry> getLongestWinningStreak() {
		return longestWinningStreak;
	}

	public List<RecordEntry> getLongestLosingStreak() {
		return longestLosingStreak;
	}

	public List<RecordEntry> getBiggestBandits() {
		return biggestBandits;
	}

	public List<RecordEntry> getBestPutters() {
		return bestPutters;
	}
	
	public List<RecordEntry> getMostLikelyToWinTheWoodman() {
		return mostLikelyToWinTheWoodman;
	}

}
