'use strict';

/* Directives */


var directives = angular.module('myApp.directives', []);

directives.directive( 'scrollIf', function() {
	var scrollToElement = function(selector, time,
			verticalOffset) {
		time = typeof (time) != 'undefined' ? time : 0;
		verticalOffset = typeof (verticalOffset) != 'undefined' ? verticalOffset
				: 0;
		var element = $(selector);
		var offset = element.offset();
		var offsetTop = offset.top + verticalOffset;
		$('html, body').animate({
			scrollTop : offsetTop
		}, time);
	};
	return function(scope, element, attr) {
		scope.$watch(attr.scrollIf, function ngShowWatchAction(
				value) {
			if (value) {
				scrollToElement(element, 0, -60);
			}
		});
	};
});

directives.directive('menuButton', function() {
    return function(scope, element, attrs) {
        $(element).click(function(event) {
        	var $collapse = $(element).closest('.nav-collapse');
            $collapse.collapse('toggle');
        });
    };
});
