;
(function() {

	$(function() {

		var menuItems = new MenuItems([ {
			link : "#",
			name : "Home",
			active : true
		}, {
			link : "#!/members",
			name : "Members"
		}, {
			link : "#!/venues",
			name : "Venues"
		}, {
			link : "#!/tournaments",
			name : "Tournaments"
		}, {
			link : "#!/tournaments/2011",
			name : "2011"
		}, {
			link : "#!/tournaments/2010",
			name : "2010"
		}, {
			link : "#!/tournaments/2009",
			name : "2009"
		}, {
			link : "#!/tournaments/2008",
			name : "2008"
		}, {
			link : "#!/tournaments/2007",
			name : "2007"
		}, {
			link : "#!/tournaments/2006",
			name : "2006"
		}, {
			link : "#!/tournaments/2005",
			name : "2005"
		} ]);

		var members = new Members;
		var venues = new Venues;
		var tournaments = new Tournaments;
		var appearances = new Appearances;
		
		members.fetch({success:function(){
			venues.fetch({success:function() {				
				tournaments.fetch({success:function(){					
					appearances.fetch();					
				}});				
			}});			
		}});

		var tournamentViewModel = new TournamentViewModel;

		new MenuBar({
			collection : menuItems
		});
		new MembersTable({
			collection : members,
			appearances : appearances
		});
		new VenuesTable({
			collection : venues
		});
		new TournamentsTable({
			collection : tournaments
		});
		new TournamentView({
			model : tournamentViewModel,
			members : members,
			appearances : appearances
		});
		new AdminHome({
			tournaments : tournaments,
			members : members,
			appearances : appearances,
			venues : venues
		});

		var Router = Backbone.Router.extend({
			routes : {
				"" : "home",
				"!/members" : "listMembers",
				"!/venues" : "listVenues",
				"!/tournaments" : "listTournaments",
				"!/tournaments/:id" : "showTournament"
			},
			home : function() {
				menuItems.activateMenuItem("#");
				this.activateView("home");
			},
			listMembers : function() {
				menuItems.activateMenuItem("#!/members");
				this.activateView("members");
			},
			listVenues : function() {
				menuItems.activateMenuItem("#!/venues");
				this.activateView("venues");
			},
			listTournaments : function() {
				menuItems.activateMenuItem("#!/tournaments");
				this.activateView("tournaments");
			},
			showTournament : function(id) {
				tournamentViewModel.show(tournaments.get(id));
				menuItems.activateMenuItem("#!/tournaments/" + id);
				this.activateView("tournament");
			},
			activateView : function(viewId) {
				$(".page").hide();
				$("#" + viewId).show();
			}
		});

		new Router;

		Backbone.history.start();

	});

})();