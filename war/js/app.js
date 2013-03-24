'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', ['myApp.filters', 'myApp.services', 'myApp.directives']).
  config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/admin', {templateUrl: 'partials/admin.html', controller: AdminCtrl});
	$routeProvider.when('/admin/:section', {templateUrl: 'partials/admin.html', controller: AdminCtrl});
    $routeProvider.when('/members', {templateUrl: 'partials/members.html', controller: MembersCtrl});
    $routeProvider.when('/venues', {templateUrl: 'partials/venues.html', controller: VenuesCtrl});
    $routeProvider.when('/tournaments', {templateUrl: 'partials/tournaments.html', controller: TournamentsCtrl});
    $routeProvider.when('/tournaments/:id', {templateUrl: 'partials/tournament.html', controller: TournamentCtrl});
    $routeProvider.when('/hall-of-fame', {templateUrl: 'partials/halloffame.html', controller: HallOfFameCtrl});
    $routeProvider.otherwise({redirectTo: '/hall-of-fame'});
  }]);
