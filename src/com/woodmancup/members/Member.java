package com.woodmancup.members;


public class Member {

	public static Member newInstance(String id, String firstname,
			String surname) {
		Member member = new Member();
		member.id = id;
		member.firstname = firstname;
		member.surname = surname;
		return member;
	}

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

}
