'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', ['myApp.filters', 'myApp.services', 'myApp.directives', 'myApp.controllers']).
  config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/stats', {templateUrl: 'partials/stats.html', controller: "StatsCtrl"});
	  $routeProvider.when('/photos/:id', {templateUrl: 'partials/album.html', controller: "AlbumCtrl"});
	  $routeProvider.when('/photos', {templateUrl: 'partials/photos.html', controller: "PhotosCtrl"});
	  $routeProvider.when('/admin/:section', {templateUrl: 'partials/admin.html', controller: AdminCtrl});
	  $routeProvider.when('/admin', {templateUrl: 'partials/admin.html', controller: AdminCtrl});
	  $routeProvider.when('/members', {templateUrl: 'partials/members.html', controller: MembersCtrl});
	  $routeProvider.when('/venues', {templateUrl: 'partials/venues.html', controller: VenuesCtrl});
	  $routeProvider.when('/tournaments', {templateUrl: 'partials/tournaments.html', controller: TournamentsCtrl});
	  $routeProvider.when('/tournaments/:id', {templateUrl: 'partials/tournament.html', controller: TournamentCtrl});
	  $routeProvider.when('/hall-of-fame', {templateUrl: 'partials/halloffame.html', controller: HallOfFameCtrl});
	  $routeProvider.otherwise({redirectTo: '/hall-of-fame'});
  }]);
