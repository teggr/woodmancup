;
(function() {

	var Member = Backbone.Model.extend({
		url : "/members",
		didAppearFor : function(teamId) {
			var appearance = _.find(this.get("appearances"), function(
					appearance) {
				return appearance.teamId == teamId;
			});
			return appearance != null;
		}
	});

	Members = Backbone.Collection.extend({
		model : Member,
		findPlayersByTeamId : function(teamId) {
			return this.filter(function(member) {
				return member.didAppearFor(teamId);
			});
		}

	});

	var MemberTableRow = Backbone.View.extend({
		tagName : "tr",
		template : _.template($("#member-row-template").html()),
		initialize : function(options) {
			this.appearances = options.appearances;
		},
		render : function() {
			var model = this.model.toJSON();
			_.extend(model, {
				appearances : this.appearances
			});
			this.$el.html(this.template(model));
			return this;
		}
	});

	MembersTable = Backbone.View.extend({
		el : $("#members-table"),
		initialize : function(options) {
			this.appearances = options.appearances;
			this.render();
			this.collection.on("reset", this.onReset, this);
			this.collection.on("add", this.onReset, this);
		},
		render : function() {
			this.collection.each(function(member) {
				var row = new MemberTableRow({
					model : member,
					appearances : this.appearances
							.getAppearancesByMember(member.id)
				});
				this.$el.append(row.render().el);
			}, this);
		},
		onReset : function() {
			this.$el.html("");
			this.render();
		}
	});

})();