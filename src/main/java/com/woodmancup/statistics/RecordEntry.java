package com.woodmancup.statistics;

import com.woodmancup.members.Member;

public class RecordEntry {
	private Member member;
	private int value;

	public RecordEntry(Member member, int value) {
		super();
		this.member = member;
		this.value = value;
	}

	public Member getMember() {
		return member;
	}

	public int getValue() {
		return value;
	}
}
