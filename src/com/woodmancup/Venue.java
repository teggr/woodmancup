package com.woodmancup;

public class Venue {

	public static Venue newInstance(String id, String name, String postcode,
			String website) {
		Venue venue = new Venue();
		venue.id = id;
		venue.name = name;
		venue.postcode = postcode;
		venue.website = website;
		return venue;
	}

	private String id;
	private String name;
	private String postcode;
	private String website;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getWebsite() {
		return website;
	}

}
