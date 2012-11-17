package com.woodmancup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;

public class MemberRepository implements InitializingBean {

	public enum MemberSort implements Comparator<Member> {
		SURNAME, NONE;
		@Override
		public int compare(Member o1, Member o2) {
			return o1.getSurname().compareTo(o2.getSurname());
		}
	}

	public enum PlayerSort implements Comparator<Player> {
		SURNAME;
		@Override
		public int compare(Player o1, Player o2) {
			if (o1.isCaptain()) {
				return -1;
			} else if (o2.isCaptain()) {
				return 1;
			}
			return o1.getSurname().compareTo(o2.getSurname());
		}
	}

	private List<Member> members = new ArrayList<Member>();

	@Override
	public void afterPropertiesSet() throws Exception {

		members.add(Member.newInstance("tom", "Tom", "Apperley",
				Appearance.newInstance("gash"),
				Appearance.newInstanceAsCaptain("scuzz"),
				Appearance.newInstance("chalice"),
				Appearance.newInstance("mutiny"),
				Appearance.newInstance("sinn"), Appearance.newInstance("top"),
				Appearance.newInstance("pink")));

		members.add(Member.newInstance("sturds", "Richard", "Sturdy",
				Appearance.newInstanceAsCaptain("gash"),
				Appearance.newInstanceAsCaptain("team2"),
				Appearance.newInstance("neo"), Appearance.newInstance("hoo"),
				Appearance.newInstance("prince"),
				Appearance.newInstance("top"), Appearance.newInstance("bear")));

		members.add(Member.newInstance("shifty", "Shifty", "Shifty",
				Appearance.newInstance("gash")));

		members.add(Member.newInstance("kempo", "Nick", "Kemp",
				Appearance.newInstance("gash")));

		members.add(Member.newInstance("snakes", "David", "Tryhorn",
				Appearance.newInstance("gash"),
				Appearance.newInstance("scuzz"),
				Appearance.newInstanceAsCaptain("chalice"),
				Appearance.newInstance("mutiny"),
				Appearance.newInstanceAsCaptain("prince"),
				Appearance.newInstance("dog"), Appearance.newInstance("pink")));

		members.add(Member.newInstance("brad", "Bradley", "Le Riche",
				Appearance.newInstance("gash"),
				Appearance.newInstance("team2"), Appearance.newInstance("neo"),
				Appearance.newInstance("hoo"),
				Appearance.newInstanceAsPuttOffWinner("sinn"),
				Appearance.newInstance("dog"),
				Appearance.newInstanceAsCaptain("bear")));

		members.add(Member.newInstance("robin", "Robin", "Tegg",
				Appearance.newInstance("panthers"),
				Appearance.newInstance("team2"),
				Appearance.newInstanceAsCaptain("neo"),
				Appearance.newInstanceAsCaptain("hoo"),
				Appearance.newInstance("prince"),
				Appearance.newInstance("dog"), Appearance.newInstance("bear")));

		members.add(Member.newInstance("mitch", "Andrew", "Mitchell",
				Appearance.newInstance("panthers"),
				Appearance.newInstance("team2"),
				Appearance.newInstance("chalice"),
				Appearance.newInstance("mutiny"),
				Appearance.newInstance("sinn"), Appearance.newInstance("top")));

		members.add(Member.newInstance("mac", "Ian", "McDonald",
				Appearance.newInstance("panthers"),
				Appearance.newInstance("team2")));

		members.add(Member.newInstance("east", "Andrew", "Easter",
				Appearance.newInstanceAsCaptain("panthers"),
				Appearance.newInstance("scuzz"),
				Appearance.newInstanceAsPuttOffWinner("chalice"),
				Appearance.newInstanceAsCaptainAndPuttOffWinner("mutiny"),
				Appearance.newInstance("sinn"), Appearance.newInstance("top"),
				Appearance.newInstance("bear")));

		members.add(Member.newInstance("henso", "Jon", "Henson",
				Appearance.newInstance("panthers"),
				Appearance.newInstance("scuzz"),
				Appearance.newInstance("chalice"),
				Appearance.newInstance("hoo"),
				Appearance.newInstance("prince"),
				Appearance.newInstance("dog"), Appearance.newInstance("bear")));

		members.add(Member.newInstance("unit", "Greg", "Williams",
				Appearance.newInstance("panthers"),
				Appearance.newInstance("scuzz"), Appearance.newInstance("neo"),
				Appearance.newInstance("mutiny"),
				Appearance.newInstance("sinn"), Appearance.newInstance("top"),
				Appearance.newInstance("pink")));

		members.add(Member.newInstance("vien", "Vien", "Phan",
				Appearance.newInstance("scuzz")));

		members.add(Member.newInstance("maddog", "Andrew", "Stevens",
				Appearance.newInstance("team2"), Appearance.newInstance("neo"),
				Appearance.newInstance("hoo"),
				Appearance.newInstance("prince"),
				Appearance.newInstanceAsCaptain("dog"),
				Appearance.newInstanceAsPuttOffWinner("bear")));

		members.add(Member.newInstance("richg", "Richard", "Goulden",
				Appearance.newInstance("mutiny"),
				Appearance.newInstance("sinn"), Appearance.newInstance("top")));

		members.add(Member.newInstance("oshea", "Tim", "O'Shea",
				Appearance.newInstance("chalice")));

		members.add(Member.newInstance("putt", "Alisdair", "Putt",
				Appearance.newInstanceAsPuttOffWinner("dog"),
				Appearance.newInstance("pink")));

		members.add(Member.newInstance("coco", "Michael", "Coe",
				Appearance.newInstance("dog")));

		members.add(Member.newInstance("nasher", "Harry", "Bridge",
				Appearance.newInstance("neo")));

		members.add(Member.newInstance("gav", "Gavin", "Reid",
				Appearance.newInstance("chalice"),
				Appearance.newInstance("mutiny"),
				Appearance.newInstance("prince"),
				Appearance.newInstanceAsCaptain("top"),
				Appearance.newInstance("pink")));

		members.add(Member.newInstance("damo", "Damien", "Kiernander",
				Appearance.newInstance("chalice"),
				Appearance.newInstance("hoo")));

		members.add(Member.newInstance("denno", "Christian", "Dennison",
				Appearance.newInstanceAsAlternativeWoodmanCupWinner("neo"),
				Appearance.newInstance("hoo"), Appearance.newInstance("top")));

		members.add(Member.newInstance("ego", "Bryan", "Egan",
				Appearance.newInstance("neo"), Appearance.newInstance("hoo"),
				Appearance.newInstanceAsCaptain("sinn")));

		members.add(Member.newInstance("foist", "Richard", "Foister",
				Appearance.newInstance("mutiny"),
				Appearance.newInstance("prince"),
				Appearance.newInstance("dog"),
				Appearance.newInstanceAsCaptain("pink")));

	}

	public List<Member> findAll(MemberSort sort) {
		List<Member> allMembers = new ArrayList<Member>();
		allMembers.addAll(members);
		sort(sort, allMembers);
		return allMembers;
	}

	private void sort(MemberSort sort, List<Member> allMembers) {
		if (sort != MemberSort.NONE) {
			Collections.sort(allMembers, sort);
		}
	}

	public List<Member> findByTeamId(String teamId, MemberSort sort) {
		List<Member> list = new ArrayList<Member>();
		for (Member member : members) {
			if (member.didAppearFor(teamId)) {
				list.add(member);
			}
		}
		sort(sort, list);
		return list;
	}

	public List<Player> findPlayersByTeamId(String teamId, PlayerSort sort) {
		List<Player> list = new ArrayList<Player>();
		for (Member member : members) {
			if (member.didAppearFor(teamId)) {
				list.add(member.createPlayer(teamId));
			}
		}
		Collections.sort(list, sort);
		return list;
	}

	public Member findById(String id) {
		for (Member member : members) {
			if (member.getId().equals(id)) {
				return member;
			}
		}
		return null;
	}

}
