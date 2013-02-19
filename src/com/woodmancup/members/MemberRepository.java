package com.woodmancup.members;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository implements InitializingBean {

	public enum MemberSort implements Comparator<Member> {
		SURNAME, NONE;
		@Override
		public int compare(Member o1, Member o2) {
			return o1.getSurname().compareTo(o2.getSurname());
		}
	}

	private List<Member> members = new ArrayList<Member>();

	@Override
	public void afterPropertiesSet() throws Exception {

		members.add(Member.newInstance("tom", "Tom", "Apperley"));
		members.add(Member.newInstance("sturds", "Richard", "Sturdy"));
		members.add(Member.newInstance("shifty", "Shifty", "Shifty"));
		members.add(Member.newInstance("kempo", "Nick", "Kemp"));
		members.add(Member.newInstance("snakes", "David", "Tryhorn"));
		members.add(Member.newInstance("brad", "Bradley", "Le Riche"));
		members.add(Member.newInstance("robin", "Robin", "Tegg"));
		members.add(Member.newInstance("mitch", "Andrew", "Mitchell"));
		members.add(Member.newInstance("mac", "Ian", "McDonald"));
		members.add(Member.newInstance("east", "Andrew", "Easter"));
		members.add(Member.newInstance("henso", "Jon", "Henson"));
		members.add(Member.newInstance("unit", "Greg", "Williams"));
		members.add(Member.newInstance("vien", "Vien", "Phan"));
		members.add(Member.newInstance("maddog", "Andrew", "Stevens"));
		members.add(Member.newInstance("richg", "Richard", "Goulden"));
		members.add(Member.newInstance("oshea", "Tim", "O'Shea"));
		members.add(Member.newInstance("putt", "Alisdair", "Putt"));
		members.add(Member.newInstance("coco", "Michael", "Coe"));
		members.add(Member.newInstance("nasher", "Harry", "Bridge"));
		members.add(Member.newInstance("gav", "Gavin", "Reid"));
		members.add(Member.newInstance("damo", "Damien", "Kiernander"));
		members.add(Member.newInstance("denno", "Christian", "Dennison"));
		members.add(Member.newInstance("ego", "Bryan", "Egan"));
		members.add(Member.newInstance("foist", "Richard", "Foister"));

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

	public Member findById(String id) {
		for (Member member : members) {
			if (member.getId().equals(id)) {
				return member;
			}
		}
		return null;
	}

	public List<Member> getMembers() {
		return members;
	}

	public Member create(Member member) {
		members.add(member);
		return member;
	}

}
