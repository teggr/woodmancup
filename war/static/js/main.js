;
(function() {

	$(function() {

		_.templateSettings = {
			interpolate : /\{\{(.+?)\}\}/g
		};

		var MenuItem = Backbone.Model.extend({
			defaults : {
				name : "",
				link : "",
				active : false
			}
		});

		var MenuItems = Backbone.Collection.extend({
			model : MenuItem,
			activateMenuItem : function(link) {
				this.forEach(function(menuItem) {
					menuItem.set("active", link == menuItem.get("link"));
				});
			}
		});

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
			link : "#!/tournaments/2007",
			name : "2005"
		} ]);

		var MenuBarItem = Backbone.View.extend({
			tagName : "li",
			template : _.template($("#menu-bar-item-template").html()),
			initialize : function() {
				this.render();
				this.model.on("change:active", this.onModelChange, this);
			},
			render : function() {
				this.$el.html(this.template(this.model.toJSON()));
				this.onModelChange();
				return this;
			},
			onModelChange : function(menuItem) {
				if (this.model.get("active")) {
					if (!this.$el.hasClass("active")) {
						this.$el.addClass("active");
					}
				} else {
					this.$el.removeClass("active");
				}
			}
		});

		var MenuBar = Backbone.View.extend({
			el : $("#menu-bar"),
			initialize : function() {
				this.render();
			},
			render : function() {
				this.collection.each(_.bind(function(menuItem) {
					var item = new MenuBarItem({
						model : menuItem
					});
					this.$el.append(item.render().el);
				}, this));
			}
		});

		new MenuBar({
			collection : menuItems
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
			},
			listMembers : function() {
				menuItems.activateMenuItem("#!/members");
			},
			listVenues : function() {
				menuItems.activateMenuItem("#!/venues");
			},
			listTournaments : function() {
				menuItems.activateMenuItem("#!/tournaments");
			},
			showTournament : function(id) {
				menuItems.activateMenuItem("#!/tournaments/" + id);
			}
		});
		
		new Router;

		Backbone.history.start({
			silent : true
		});

	});

})();