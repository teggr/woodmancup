package com.woodmancup.tournaments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
public class AppearanceRepository implements InitializingBean {

	private List<Appearance> appearances = new ArrayList<Appearance>();

	@Override
	public void afterPropertiesSet() throws Exception {

		addAppearancesFor("tom", Appearance.newInstance("gash"),
				Appearance.newInstanceAsCaptain("scuzz"),
				Appearance.newInstance("chalice"),
				Appearance.newInstance("mutiny"),
				Appearance.newInstance("sinn"), Appearance.newInstance("top"),
				Appearance.newInstance("pink"));

		addAppearancesFor("sturds", Appearance.newInstanceAsCaptain("gash"),
				Appearance.newInstanceAsCaptain("team2"),
				Appearance.newInstance("neo"), Appearance.newInstance("hoo"),
				Appearance.newInstance("prince"),
				Appearance.newInstance("top"), Appearance.newInstance("bear"));

		addAppearancesFor("shifty", Appearance.newInstance("gash"));

		addAppearancesFor("kempo", Appearance.newInstance("gash"));

		addAppearancesFor("snakes", Appearance.newInstance("gash"),
				Appearance.newInstance("scuzz"),
				Appearance.newInstanceAsCaptain("chalice"),
				Appearance.newInstance("mutiny"),
				Appearance.newInstanceAsCaptain("prince"),
				Appearance.newInstance("dog"), Appearance.newInstance("pink"));

		addAppearancesFor("brad", Appearance.newInstance("gash"),
				Appearance.newInstance("team2"), Appearance.newInstance("neo"),
				Appearance.newInstance("hoo"),
				Appearance.newInstanceAsPuttOffWinner("sinn"),
				Appearance.newInstance("dog"),
				Appearance.newInstanceAsCaptain("bear"));

		addAppearancesFor("robin", Appearance.newInstance("panthers"),
				Appearance.newInstance("team2"),
				Appearance.newInstanceAsCaptain("neo"),
				Appearance.newInstanceAsCaptain("hoo"),
				Appearance.newInstance("prince"),
				Appearance.newInstance("dog"), Appearance.newInstance("bear"));

		addAppearancesFor("mitch", Appearance.newInstance("panthers"),
				Appearance.newInstance("team2"),
				Appearance.newInstance("chalice"),
				Appearance.newInstance("mutiny"),
				Appearance.newInstance("sinn"), Appearance.newInstance("top"));

		addAppearancesFor("mac", Appearance.newInstance("panthers"),
				Appearance.newInstance("team2"));

		addAppearancesFor("east", Appearance.newInstanceAsCaptain("panthers"),
				Appearance.newInstance("scuzz"),
				Appearance.newInstanceAsPuttOffWinner("chalice"),
				Appearance.newInstanceAsCaptainAndPuttOffWinner("mutiny"),
				Appearance.newInstance("sinn"), Appearance.newInstance("top"),
				Appearance.newInstance("bear"));

		addAppearancesFor("henso", Appearance.newInstance("panthers"),
				Appearance.newInstance("scuzz"),
				Appearance.newInstance("chalice"),
				Appearance.newInstance("hoo"),
				Appearance.newInstance("prince"),
				Appearance.newInstance("dog"), Appearance.newInstance("bear"));

		addAppearancesFor("unit", Appearance.newInstance("panthers"),
				Appearance.newInstance("scuzz"), Appearance.newInstance("neo"),
				Appearance.newInstance("mutiny"),
				Appearance.newInstance("sinn"), Appearance.newInstance("top"),
				Appearance.newInstance("pink"));

		addAppearancesFor("vien", Appearance.newInstance("scuzz"));

		addAppearancesFor("maddog", Appearance.newInstance("team2"),
				Appearance.newInstance("neo"), Appearance.newInstance("hoo"),
				Appearance.newInstance("prince"),
				Appearance.newInstanceAsCaptain("dog"),
				Appearance.newInstanceAsPuttOffWinner("bear"));

		addAppearancesFor("richg", Appearance.newInstance("mutiny"),
				Appearance.newInstance("sinn"), Appearance.newInstance("top"));

		addAppearancesFor("oshea", Appearance.newInstance("chalice"));

		addAppearancesFor("putt", Appearance.newInstanceAsPuttOffWinner("dog"),
				Appearance.newInstance("pink"));

		addAppearancesFor("coco", Appearance.newInstance("dog"));

		addAppearancesFor("nasher", Appearance.newInstance("neo"));

		addAppearancesFor("gav", Appearance.newInstance("chalice"),
				Appearance.newInstance("mutiny"),
				Appearance.newInstance("prince"),
				Appearance.newInstanceAsCaptain("top"),
				Appearance.newInstance("pink"));

		addAppearancesFor("damo", Appearance.newInstance("chalice"),
				Appearance.newInstance("hoo"));

		addAppearancesFor("denno",
				Appearance.newInstanceAsAlternativeWoodmanCupWinner("neo"),
				Appearance.newInstance("hoo"), Appearance.newInstance("top"));

		addAppearancesFor("ego", Appearance.newInstance("neo"),
				Appearance.newInstance("hoo"),
				Appearance.newInstanceAsCaptain("sinn"));

		addAppearancesFor("foist", Appearance.newInstance("mutiny"),
				Appearance.newInstance("prince"),
				Appearance.newInstance("dog"),
				Appearance.newInstanceAsCaptain("pink"));

	}

	private void addAppearancesFor(String memberId, Appearance... appearances) {
		for (Appearance appearance : appearances) {
			appearance.setMemberId(memberId);
			this.appearances.add(appearance);
		}
	}
	
	public List<Appearance> getAppearances() {
		return appearances;
	}

	public List<Appearance> getAppearancesByMember(String memberId) {
		List<Appearance> list = new ArrayList<Appearance>();
		for (Appearance appearance : appearances) {
			if (appearance.getMemberId().equals(memberId)) {
				list.add(appearance);
			}
		}
		return list;
	}

}
