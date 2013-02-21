;
(function() {

	var Venue = Backbone.Model.extend({
	});

	Venues = Backbone.Collection.extend({
		url : "/api/venues",
		model : Venue
	});

	var VenueTableRow = Backbone.View.extend({
		tagName : "tr",
		template : _.template($("#venue-row-template").html()),
		render : function() {
			this.$el.html(this.template(this.model.toJSON()));
			return this;
		}
	});

	VenuesTable = Backbone.View.extend({
		el : $("#venues-table"),
		initialize : function() {
			this.render();
			this.collection.on("reset",this.onReset,this);
			this.collection.on("add",this.onReset,this);
		},
		render : function() {
			this.collection.each(_.bind(function(venue) {
				var row = new VenueTableRow({
					model : venue
				});
				this.$el.append(row.render().el);
			}, this));
		},
		onReset : function() {
			this.$el.find("tbody").html("");
			this.render();
		}
	});

})();