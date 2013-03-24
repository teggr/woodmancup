package com.woodmancup.members;

import java.util.List;

import com.woodmancup.tournaments.Appearance;

public class Member {

	public static Member newInstance(String id, String firstname, String surname) {
		Member member = new Member();
		member.id = id;
		member.firstname = firstname;
		member.surname = surname;
		return member;
	}

	private String firstname;
	private String surname;
	private String id;
	private List<Appearance> appearances;

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return surname;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Member [firstname=" + firstname + ", surname=" + surname
				+ ", id=" + id + "]";
	}

	public void setAppearances(List<Appearance> appearances) {
		this.appearances = appearances;
	}
	
	public List<Appearance> getAppearances() {
		return appearances;
	}

}
