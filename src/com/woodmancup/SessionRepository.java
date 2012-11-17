package com.woodmancup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionRepository implements InitializingBean {

	private static final Comparator<Session> ORDER_SORT = new Comparator<Session>() {
		@Override
		public int compare(Session o1, Session o2) {
			return o1.getSessionNumber().compareTo(o2.getSessionNumber());
		}
	};

	private List<Session> sessions = new ArrayList<Session>();

	private MemberRepository memberRepository;

	@Autowired
	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		create2005();
		create2006();
		create2007();
		create2008();
		create2009();
		create2010();
		create2011();
	}

	private Group createGroup(String teamId, String... members) {
		List<Member> list = new ArrayList<Member>();
		for (String memberId : members) {
			Member member = memberRepository.findById(memberId);
			list.add(member);
		}
		return Group.newInstance(teamId, list.toArray(new Member[0]));
	}

	private void create2011() {
		Match d23 = Match.newInstance("pink",
				createGroup("pink", "snakes", "tom"),
				createGroup("bear", "brad", "maddog"));
		Match d24 = Match.newInstance("bear",
				createGroup("pink", "gav", "putt"),
				createGroup("bear", "sturds", "henso"));
		Match d25 = Match.newInstance(Match.DRAW, createGroup("pink", "foist"),
				createGroup("bear", "robin", "east"));

		sessions.add(Session.newInstance("2011", "1", SessionFormat.PAIRS, d23,
				d24, d25));

		Match sc23 = Match.newInstance("pink",
				createGroup("pink", "tom", "snakes"),
				createGroup("bear", "brad", "east"));

		Match sc24 = Match.newInstance("bear",
				createGroup("pink", "putt", "unit"),
				createGroup("bear", "robin", "henso"));

		Match sc25 = Match.newInstance("bear",
				createGroup("pink", "foist", "snakes"),
				createGroup("bear", "sturds", "maddog"));

		sessions.add(Session.newInstance("2011", "2", SessionFormat.PAIRS,
				sc23, sc24, sc25));

		Match s42 = Match.newInstance(Match.DRAW, createGroup("pink", "foist"),
				createGroup("bear", "sturds", "east"));
		Match s43 = Match.newInstance("pink", createGroup("pink", "tom"),
				createGroup("bear", "robin"));
		Match s44 = Match.newInstance("pink", createGroup("pink", "unit"),
				createGroup("bear", "henso"));
		Match s45 = Match.newInstance("bear", createGroup("pink", "snakes"),
				createGroup("bear", "brad"));
		Match s46 = Match.newInstance(Match.DRAW, createGroup("pink", "gav"),
				createGroup("bear", "maddog"));

		sessions.add(Session.newInstance("2011", "3", SessionFormat.SINGLES,
				s42, s43, s44, s45, s46));
	}

	private void create2010() {
		Match d19 = Match.newInstance("top", createGroup("top", "gav", "tom"),
				createGroup("dog", "brad", "snakes"));
		Match d20 = Match.newInstance("top",
				createGroup("top", "east", "richg"),
				createGroup("dog", "coco", "putt"));
		Match d21 = Match.newInstance("dog",
				createGroup("top", "sturds", "denno"),
				createGroup("dog", "henso", "foist"));
		Match d22 = Match.newInstance("dog",
				createGroup("top", "unit", "mitch"),
				createGroup("dog", "maddog", "robin"));

		sessions.add(Session.newInstance("2010", "1", SessionFormat.PAIRS, d19,
				d20, d21, d22));

		Match sc19 = Match.newInstance("top",
				createGroup("top", "east", "gav"),
				createGroup("dog", "snakes", "maddog"));

		Match sc20 = Match.newInstance("top",
				createGroup("top", "tom", "mitch"),
				createGroup("dog", "putt", "foist"));

		Match sc21 = Match.newInstance("dog",
				createGroup("top", "unit", "denno"),
				createGroup("dog", "coco", "brad"));

		Match sc22 = Match.newInstance("dog",
				createGroup("top", "sturds", "richg"),
				createGroup("dog", "robin", "henso"));

		sessions.add(Session.newInstance("2010", "2", SessionFormat.PAIRS,
				sc19, sc20, sc21, sc22));

		Match s35 = Match.newInstance(Match.DRAW,
				createGroup("top", "gav", "sturds"),
				createGroup("dog", "robin", "snakes"));

		Match s36 = Match.newInstance("top", createGroup("top", "east"),
				createGroup("dog", "foist"));
		Match s37 = Match.newInstance("top", createGroup("top", "unit"),
				createGroup("dog", "putt"));
		Match s38 = Match.newInstance("top", createGroup("top", "richg"),
				createGroup("dog", "henso"));
		Match s39 = Match.newInstance("dog", createGroup("top", "denno"),
				createGroup("dog", "maddog"));
		Match s40 = Match.newInstance("dog", createGroup("top", "tom"),
				createGroup("dog", "brad"));
		Match s41 = Match.newInstance("dog", createGroup("top", "mitch"),
				createGroup("dog", "coco"));

		sessions.add(Session.newInstance("2010", "3", SessionFormat.SINGLES,
				s35, s36, s37, s38, s39, s40, s41));
	}

	private void create2009() {
		Match d15 = Match.newInstance("sinn", createGroup("sinn", "east"),
				createGroup("prince", "robin"));
		Match d16 = Match.newInstance("sinn",
				createGroup("sinn", "tom", "unit"),
				createGroup("prince", "gav", "snakes"));
		Match d17 = Match.newInstance("sinn",
				createGroup("sinn", "brad", "ego"),
				createGroup("prince", "henso", "foist"));
		Match d18 = Match.newInstance("prince",
				createGroup("sinn", "sturds", "maddog"),
				createGroup("prince", "mitch", "richg"));

		sessions.add(Session.newInstance("2009", "1", SessionFormat.PAIRS, d15,
				d16, d17, d18));

		Match sc15 = Match.newInstance("prince", createGroup("sinn", "tom"),
				createGroup("prince", "foist"));
		Match sc16 = Match.newInstance("sinn",
				createGroup("sinn", "mitch", "east"),
				createGroup("prince", "sturds", "henso"));
		Match sc17 = Match.newInstance("sinn",
				createGroup("sinn", "unit", "ego"),
				createGroup("prince", "snakes", "robin"));
		Match sc18 = Match.newInstance("sinn",
				createGroup("sinn", "richg", "brad"),
				createGroup("prince", "gav", "maddog"));

		sessions.add(Session.newInstance("2009", "2", SessionFormat.PAIRS,
				sc15, sc16, sc17, sc18));

		Match s29 = Match.newInstance("prince", createGroup("sinn", "ego"),
				createGroup("prince", "snakes"));
		Match s30 = Match.newInstance("prince", createGroup("sinn", "brad"),
				createGroup("prince", "gav"));
		Match s31 = Match.newInstance("prince", createGroup("sinn", "unit"),
				createGroup("prince", "sturds"));
		Match s32 = Match.newInstance("sinn", createGroup("sinn", "mitch"),
				createGroup("prince", "henso"));
		Match s33 = Match.newInstance("sinn", createGroup("sinn", "richg"),
				createGroup("prince", "maddog"));
		Match s34 = Match.newInstance("sinn",
				createGroup("sinn", "tom", "east"),
				createGroup("prince", "foist", "robin"));

		sessions.add(Session.newInstance("2009", "3", SessionFormat.SINGLES,
				s29, s30, s31, s32, s33, s34));
	}

	private void create2008() {
		Match d11 = Match.newInstance("mutiny",
				createGroup("hoo", "brad", "maddog"),
				createGroup("mutiny", "gav", "tom"));
		Match d12 = Match.newInstance("hoo",
				createGroup("hoo", "robin", "henso"),
				createGroup("mutiny", "east", "snakes"));
		Match d13 = Match.newInstance("hoo",
				createGroup("hoo", "denno", "ego"),
				createGroup("mutiny", "unit", "richg"));
		Match d14 = Match.newInstance("hoo",
				createGroup("hoo", "foist", "sturds"),
				createGroup("mutiny", "damo", "mitch"));

		sessions.add(Session.newInstance("2008", "1", SessionFormat.PAIRS, d11,
				d12, d13, d14));

		Match sc11 = Match.newInstance("mutiny",
				createGroup("hoo", "robin", "denno"),
				createGroup("mutiny", "foist", "unit"));
		Match sc12 = Match.newInstance("hoo",
				createGroup("hoo", "sturds", "maddog"),
				createGroup("mutiny", "snakes", "gav"));
		Match sc13 = Match.newInstance("hoo",
				createGroup("hoo", "brad", "damo"),
				createGroup("mutiny", "mitch", "east"));
		Match sc14 = Match.newInstance("mutiny",
				createGroup("hoo", "henso", "ego"),
				createGroup("mutiny", "tom", "richg"));

		sessions.add(Session.newInstance("2008", "2", SessionFormat.PAIRS,
				sc11, sc12, sc13, sc14));

		Match s21 = Match.newInstance("hoo", createGroup("hoo", "ego"),
				createGroup("mutiny", "richg"));
		Match s22 = Match.newInstance("mutiny", createGroup("hoo", "henso"),
				createGroup("mutiny", "snakes"));
		Match s23 = Match.newInstance("hoo", createGroup("hoo", "maddog"),
				createGroup("mutiny", "mitch"));
		Match s24 = Match.newInstance("hoo", createGroup("hoo", "robin"),
				createGroup("mutiny", "east"));
		Match s25 = Match.newInstance("hoo", createGroup("hoo", "damo"),
				createGroup("mutiny", "gav"));
		Match s26 = Match.newInstance("mutiny", createGroup("hoo", "foist"),
				createGroup("mutiny", "sturds"));
		Match s27 = Match.newInstance("mutiny", createGroup("hoo", "brad"),
				createGroup("mutiny", "tom"));
		Match s28 = Match.newInstance("mutiny", createGroup("hoo", "denno"),
				createGroup("mutiny", "unit"));

		sessions.add(Session.newInstance("2008", "3", SessionFormat.SINGLES,
				s21, s22, s23, s24, s25, s26, s27, s28));
	}

	private void create2007() {
		Match d7 = Match.newInstance("neo",
				createGroup("neo", "robin", "unit"),
				createGroup("chalice", "oshea", "henso"));
		Match d8 = Match.newInstance("neo",
				createGroup("neo", "brad", "nasher"),
				createGroup("chalice", "east", "mitch"));
		Match d9 = Match.newInstance("chalice",
				createGroup("neo", "denno", "sturds"),
				createGroup("chalice", "damo", "gav"));
		Match d10 = Match.newInstance("chalice",
				createGroup("neo", "maddog", "ego"),
				createGroup("chalice", "tom", "snakes"));

		sessions.add(Session.newInstance("2007", "1", SessionFormat.PAIRS, d7,
				d8, d9, d10));

		Match sc7 = Match.newInstance("neo",
				createGroup("neo", "robin", "denno"),
				createGroup("chalice", "east", "snakes"));
		Match sc8 = Match.newInstance("chalice",
				createGroup("neo", "sturds", "ego"),
				createGroup("chalice", "henso", "damo"));
		Match sc9 = Match.newInstance("neo",
				createGroup("neo", "maddog", "brad"),
				createGroup("chalice", "tom", "gav"));
		Match sc10 = Match.newInstance("neo",
				createGroup("neo", "nasher", "unit"),
				createGroup("chalice", "oshea", "mitch"));

		sessions.add(Session.newInstance("2007", "2", SessionFormat.PAIRS, sc7,
				sc8, sc9, sc10));

		Match s13 = Match.newInstance("neo", createGroup("neo", "robin"),
				createGroup("chalice", "oshea"));
		Match s14 = Match.newInstance("neo", createGroup("neo", "nasher"),
				createGroup("chalice", "east"));
		Match s15 = Match.newInstance("chalice", createGroup("neo", "sturds"),
				createGroup("chalice", "damo"));
		Match s16 = Match.newInstance("chalice", createGroup("neo", "maddog"),
				createGroup("chalice", "henso"));
		Match s17 = Match.newInstance("neo", createGroup("neo", "ego"),
				createGroup("chalice", "tom"));
		Match s18 = Match.newInstance("neo", createGroup("neo", "unit"),
				createGroup("chalice", "mitch"));
		Match s19 = Match.newInstance("neo", createGroup("neo", "brad"),
				createGroup("chalice", "snakes"));
		Match s20 = Match.newInstance("chalice", createGroup("neo", "denno"),
				createGroup("chalice", "gav"));

		sessions.add(Session.newInstance("2007", "3", SessionFormat.SINGLES,
				s13, s14, s15, s16, s17, s18, s19, s20));
	}

	private void create2006() {
		Match d4 = Match.newInstance("team2",
				createGroup("scuzz", "snakes", "tom"),
				createGroup("team2", "robin", "mitch"));
		Match d5 = Match.newInstance("scuzz",
				createGroup("scuzz", "east", "henso"),
				createGroup("team2", "brad", "maddog"));
		Match d6 = Match.newInstance("team2",
				createGroup("scuzz", "vien", "unit"),
				createGroup("team2", "sturds", "mac"));

		sessions.add(Session.newInstance("2006", "1", SessionFormat.PAIRS, d4,
				d5, d6));

		Match sc4 = Match.newInstance(Match.DRAW,
				createGroup("scuzz", "tom", "vien"),
				createGroup("team2", "robin", "maddog"));
		Match sc5 = Match.newInstance("scuzz",
				createGroup("scuzz", "east", "snakes"),
				createGroup("team2", "mac", "brad"));
		Match sc6 = Match.newInstance("team2",
				createGroup("scuzz", "henso", "unit"),
				createGroup("team2", "sturds", "mitch"));

		sessions.add(Session.newInstance("2006", "2", SessionFormat.PAIRS, sc4,
				sc5, sc6));

		Match s7 = Match.newInstance("team2", createGroup("scuzz", "vien"),
				createGroup("team2", "robin"));
		Match s8 = Match.newInstance("team2", createGroup("scuzz", "snakes"),
				createGroup("team2", "sturds"));
		Match s9 = Match.newInstance("scuzz", createGroup("scuzz", "east"),
				createGroup("team2", "maddog"));
		Match s10 = Match.newInstance("team2", createGroup("scuzz", "tom"),
				createGroup("team2", "mac"));
		Match s11 = Match.newInstance(Match.DRAW,
				createGroup("scuzz", "mitch"), createGroup("team2", "henso"));
		Match s12 = Match.newInstance("team2", createGroup("scuzz", "unit"),
				createGroup("team2", "brad"));

		sessions.add(Session.newInstance("2006", "3", SessionFormat.SINGLES,
				s7, s8, s9, s10, s11, s12));
	}

	private void create2005() {
		Match d1 = Match.newInstance("gash",
				createGroup("gash", "sturds", "tom"),
				createGroup("panthers", "robin", "mitch"));
		Match d2 = Match.newInstance("panthers",
				createGroup("gash", "shifty", "kempo"),
				createGroup("panthers", "east", "henso"));
		Match d3 = Match.newInstance("gash",
				createGroup("gash", "brad", "snakes"),
				createGroup("panthers", "unit", "mac"));

		sessions.add(Session.newInstance("2005", "1", SessionFormat.PAIRS, d1,
				d2, d3));

		Match sc1 = Match.newInstance("gash",
				createGroup("gash", "tom", "kempo"),
				createGroup("panthers", "robin", "unit"));
		Match sc2 = Match.newInstance("panthers",
				createGroup("gash", "shifty", "brad"),
				createGroup("panthers", "east", "mitch"));
		Match sc3 = Match.newInstance("panthers",
				createGroup("gash", "sturds", "snakes"),
				createGroup("panthers", "henso", "mac"));

		sessions.add(Session.newInstance("2005", "2", SessionFormat.PAIRS, sc1,
				sc2, sc3));

		Match s1 = Match.newInstance("gash", createGroup("gash", "tom"),
				createGroup("panthers", "mitch"));

		Match s2 = Match.newInstance("gash", createGroup("gash", "sturds"),
				createGroup("panthers", "mac"));

		Match s3 = Match.newInstance("panthers", createGroup("gash", "shifty"),
				createGroup("panthers", "east"));

		Match s4 = Match.newInstance("panthers", createGroup("gash", "kempo"),
				createGroup("panthers", "henso"));

		Match s5 = Match.newInstance("gash", createGroup("gash", "snakes"),
				createGroup("panthers", "unit"));

		Match s6 = Match.newInstance(Match.DRAW, createGroup("gash", "brad"),
				createGroup("panthers", "robin"));

		sessions.add(Session.newInstance("2005", "3", SessionFormat.SINGLES,
				s1, s2, s3, s4, s5, s6));
	}

	public List<Session> findSessionsByTournamentId(String tournamentId) {
		List<Session> list = new ArrayList<Session>();
		for (Session session : sessions) {
			if (session.getTournamentId().equals(tournamentId)) {
				list.add(session);
			}
		}
		Collections.sort(list, ORDER_SORT);
		return list;
	}

}
