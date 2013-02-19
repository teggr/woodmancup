;
(function() {

	var Tournament = Backbone.Model.extend({
		parse : function(data) {
			if (data.date) {
				var date = new Date(data.date);
				data.date = date.getFullYear();
			}
			return data;
		}
	});

	Tournaments = Backbone.Collection.extend({
		model : Tournament
	});

	TournamentViewModel = Backbone.Model.extend({
		show : function(tournament) {
			this.set("tournament", tournament);
		}
	});

	TournamentView = Backbone.View.extend({
		el : $("#tournament"),
		template : _.template($("#tournament-template").html()),
		initialize : function(options) {
			this.model.on("change:tournament", this.onTournamentChange, this);
			this.members = options.members;
			this.appearances = options.appearances;
		},
		render : function() {
			var tournament = this.model.get("tournament");

			var team1 = this.appearances.getAppearancesByTeam(tournament
					.get("team1").id);
			var team2 = this.appearances.getAppearancesByTeam(tournament
					.get("team2").id);

			var model = _.extend({}, tournament.toJSON(), {
				team1List : team1.map(function(appearance) {
					var mod = this.members.get(appearance.get("memberId"))
							.toJSON();
					_.extend(mod, appearance.toJSON());
					return mod;
				}, this),
				team2List : team2.map(function(appearance) {
					var mod = this.members.get(appearance.get("memberId"))
							.toJSON();
					_.extend(mod, appearance.toJSON());
					return mod;
				}, this),
				puttOffWinner : null,
				alternativeWoodmanCupWinner : null
			});

			this.$el.html(this.template(model));
		},
		onTournamentChange : function() {
			this.$el.html("");
			this.render();
		}
	});

	var TournamentTableRow = Backbone.View.extend({
		tagName : "tr",
		template : _.template($("#tournament-row-template").html()),
		render : function() {
			this.$el.html(this.template(this.model.toJSON()));
			return this;
		}
	});

	TournamentsTable = Backbone.View.extend({
		el : $("#tournaments-table"),
		initialize : function() {
			this.render();
		},
		render : function() {
			this.collection.each(_.bind(function(member) {
				var row = new TournamentTableRow({
					model : member
				});
				this.$el.append(row.render().el);
			}, this));
		}
	});

})();