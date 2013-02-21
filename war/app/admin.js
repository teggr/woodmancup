;
(function() {

	var AddNewMemberForm = Backbone.View.extend({
		el : $("#new-member"),
		events : {
			"submit .new-member-form" : "onSubmit"
		},
		initialize : function() {
			this.$firstname = this.$el.find("#firstname");
			this.$surname = this.$el.find("#surname");
		},
		onSubmit : function() {
			this.collection.create({
				firstname : this.$firstname.val(),
				surname : this.$surname.val()
			});
			this.$firstname.val("");
			this.$surname.val("");
			return false;
		}
	});
	
	var AddNewVenueForm = Backbone.View.extend({
		el : $("#new-venue"),
		events : {
			"submit .new-venue-form" : "onSubmit"
		},
		initialize : function() {
			this.$name = this.$el.find("#name");
			this.$postcode = this.$el.find("#postcode");
			this.$website = this.$el.find("#website");
		},
		onSubmit : function() {
			this.collection.create({
				name : this.$name.val(),
				postcode : this.$postcode.val(),
				website : this.$website.val()
			});
			this.$name.val("");
			this.$postcode.val("");
			this.$website.val("");
			return false;
		}
	});

	AdminHome = Backbone.View.extend({
		initialize : function(options) {
			this.tournaments = options.tournaments;
			this.members = options.members;
			this.appearances = options.appearances;
			this.venues = options.venues;
			this.addNewMemberForm = new AddNewMemberForm({
				collection : this.members
			});
			this.addNewVenueForm = new AddNewVenueForm({
				collection : this.venues
			});
		}
	});

})();