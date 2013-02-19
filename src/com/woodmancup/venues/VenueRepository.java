package com.woodmancup.venues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
public class VenueRepository implements InitializingBean {

	public enum VenueSort implements Comparator<Venue> {
		NAME;
		@Override
		public int compare(Venue o1, Venue o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

	private final List<Venue> venues = new ArrayList<Venue>();

	@Override
	public void afterPropertiesSet() throws Exception {
		venues.add(Venue.newInstance("bidford", "Bidford Grange", "B50 4LY",
				"http://www.bidfordgrange.com/"));
		venues.add(Venue.newInstance("dorset",
				"The Dorset Golf And Country Club", "BH20 7NT",
				"http://www.dorsetgolfresort.com/"));
		venues.add(Venue.newInstance("abbot", "Abbotsley Golf Hotel",
				"PE19 6XN", "http://www.abbotsley.com/pages.php/index.html"));
		venues.add(Venue.newInstance("hastings", "Sedlescombe Golf Club",
				"TN33 0SD", "http://www.sedlescombegolfclub.co.uk/"));
		venues.add(Venue.newInstance("donnington",
				"Donnington Grove Country Club", "RG14 2LA",
				"http://www.donnington-grove.com/"));
		venues.add(Venue.newInstance("oldthorns", "Old Thorns Manor Hotel",
				"GU30 7PE", "http://www.oldthorns.com/"));
		venues.add(Venue
				.newInstance("staverton", "Staverton Park Golf Course",
						"NN11 6JT",
						"http://www.devere.co.uk/our-locations/staverton-park/golf.html"));

	}

	public List<Venue> findAll(VenueSort sort) {
		List<Venue> allVenues = new ArrayList<Venue>();
		allVenues.addAll(venues);
		Collections.sort(allVenues, sort);
		return allVenues;
	}

	public Venue findById(String id) {
		for (Venue venue : venues) {
			if (venue.getId().equals(id)) {
				return venue;
			}
		}
		return null;
	}

}
