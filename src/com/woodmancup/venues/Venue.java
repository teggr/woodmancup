package com.woodmancup.venues;

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

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWebsite() {
		return website;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", postcode=" + postcode
				+ ", website=" + website + "]";
	}

}
