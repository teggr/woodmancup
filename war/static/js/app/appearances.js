;
(function() {

	var Appearance = Backbone.Model.extend({
		defaults : {
			captain : false,
			teamId : "",
			puttOffWinner : false,
			alternativeWoodmanCupWinner : false,
			memberId : ""
		}
	});

	Appearances = Backbone.Collection.extend({
		model : Appearance,
		getAppearancesByMember : function(memberId) {
			return this.filter(function(appearance) {
				return appearance.get("memberId") == memberId;
			});
		},
		getAppearancesByTeam : function(teamId) {
			return this.filter(function(appearance) {
				return appearance.get("teamId") == teamId;
			});
		}
	});

})();