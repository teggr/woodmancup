;
(function() {

	var MenuItem = Backbone.Model.extend({
		defaults : {
			name : "",
			link : "",
			active : false
		}
	});

	MenuItems = Backbone.Collection.extend({
		model : MenuItem,
		activateMenuItem : function(link) {
			this.forEach(function(menuItem) {
				menuItem.set("active", link == menuItem.get("link"));
			});
		}
	});

	var MenuBarItem = Backbone.View.extend({
		tagName : "li",
		template : _.template($("#menu-bar-item-template").html()),
		initialize : function() {
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

	MenuBar = Backbone.View.extend({
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

})();