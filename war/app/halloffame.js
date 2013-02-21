;
(function() {

	var HallOfFameEntry = Backbone.Model.extend({
		defaults : {
			position : 0,
			victories : 0,
			alternativeWoodmanCupWins : 0,
			puttOffWins : 0,
			wins : 0,
			draws : 0,
			losses : 0,
			member : ""
		}
	});

	HallOfFameEntries = Backbone.Collection.extend({
		url : BASE_URL + "/api/statistics",
		model : HallOfFameEntry
	});

	var HallOfFameTableRow = Backbone.View.extend({
		tagName : "tr",
		template : _.template($("#hall-of-fame-row-template").html()),
		initialize : function(options) {
			this.position = options.position;
		},
		render : function() {
			var model = this.model.toJSON();
			_.extend(model, {
				position : this.position
			});
			this.$el.html(this.template(model));
			return this;
		}
	});

	HallOfFameTable = Backbone.View.extend({
		el : $("#hall-of-fame-table"),
		initialize : function() {
			this.render();
			this.collection.on("reset", this.onReset, this);
		},
		render : function() {
			var count = 1;
			this.collection.each(_.bind(function(entry) {
				var row = new HallOfFameTableRow({
					model : entry,
					position : count
				});
				this.$el.append(row.render().el);
				count++;
			}, this));
		},
		onReset : function() {
			this.$el.find("tbody").html("");
			this.render();
		}
	});

})();