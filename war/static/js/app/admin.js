;
(function() {

	var AddNewMemberForm = Backbone.View.extend({
		el : $("#new-member"),
		events : {
			"submit .new-member-form" : "onSubmit"
		},
		onSubmit : function() {
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
		}
	});

})();