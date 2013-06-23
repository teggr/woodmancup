'use strict';

/* Controllers */

var controllers = angular.module('myApp.controllers', []);

controllers.controller("StatsCtrl", [ '$scope', '$http', function($scope, $http) {
	$http.get('api/stats/records').success(function(data) {
		$scope.records = data;
	});
} ]);

controllers.controller("PhotosCtrl", [ '$scope', '$http', function($scope, $http) {
	$http.jsonp('https://picasaweb.google.com/data/feed/api/user/111339627865632981527?alt=json&callback=JSON_CALLBACK', {
		headers : {
			"GData-Version": 2
		}
	}).success(function(data,status,headers,config) {
		$scope.albums = [];
		angular.forEach(data.feed.entry, function(entry){
			if(entry.gphoto$name && entry.gphoto$name.$t && entry.gphoto$name.$t.indexOf("WoodmanCup") != -1 ) {
				//console.log(entry);
				this.push({
					title: entry.title.$t,
					thumbnail : entry.media$group.media$thumbnail[0],
					id : entry.gphoto$id.$t
				});
			}
		}, $scope.albums);
	}).error(function(data,status,headers,config) {
		console.log(data);
	});
} ]);

controllers.controller("AlbumCtrl", [ '$scope', '$http', '$routeParams', function($scope, $http, $routeParams) {
	
	$scope.photoUrl = null;
	
	$http.jsonp('https://picasaweb.google.com/data/feed/api/user/111339627865632981527/albumid/'+$routeParams.id+'?alt=json&callback=JSON_CALLBACK', {
		headers : {
			"GData-Version": 2
		}
	}).success(function(data,status,headers,config) {
		$scope.album = {
			title : data.feed.title.$t
		};
		
		$scope.photos = [];
		console.log(data);
		angular.forEach(data.feed.entry, function(entry){
			this.push({
				title: entry.title.$t,
				thumbnail : entry.media$group.media$thumbnail[1],
				url : entry.content.src
			});
		}, $scope.photos);
		
	}).error(function(data,status,headers,config) {
		console.log(data);
	});
	
	$scope.showPhoto = function($event,photo) {
		angular.forEach($scope.photos, function(photo){
			photo.lastViewed = false;
		});
		photo.lastViewed = true;
		$scope.photoUrl = photo.url;
		$event.preventDefault();
		return false;
	};
	
	$scope.closePhoto = function($event) {
		if($scope.photoUrl) {
			$scope.photoUrl = null;
		}
		$event.preventDefault();
		return false;
	};
} ]);

function MenuCtrl($scope, $location) {
	$scope.isActive = function(route) {
		return $location.path() ==  ("/" + route);
	}
}
MenuCtrl.$inject = [ '$scope', '$location' ];

function AdminCtrl($scope, $location) {
	$scope.isActive = function(route) {
		var path = $location.path()
		if(path=="/admin" && route=="members") {
			return true;
		} 
		return path ==  ("/admin/" + route);
	}
}
AdminCtrl.$inject = [ '$scope', '$location' ];

function NewMemberCtrl($scope, $http) {
	$scope.member = {};
	
	$scope.createMember = function() {
		console.log("creating member", $scope.member);
		$http.post('api/members', $scope.member).success(function(data) {
			$scope.member.firstname="";
			$scope.member.surname="";
		});
		return false;
	};
}
NewMemberCtrl.$inject = [ '$scope', '$http' ];

function NewVenueCtrl($scope, $http) {
	$scope.venue = {};
	$scope.createVenue = function() {
		console.log("creating venue", $scope.venue);
		$http.post('api/venues', $scope.venue).success(function(data) {
			$scope.venue.name="";
			$scope.venue.postcode="";
			$scope.venue.website="";
		});
		return false;
	};
}
NewVenueCtrl.$inject = [ '$scope', '$http' ];

function MembersCtrl($scope, $http) {
	$scope.memberSort = function(member){
		return -(member.appearances.length);
	};
	$http.get('api/members').success(function(data) {
		$scope.members = data;
	});
}
MembersCtrl.$inject = [ '$scope', '$http' ];

function VenuesCtrl($scope, $http) {
	$http.get('api/venues').success(function(data) {
		$scope.venues = data;
	});
}
VenuesCtrl.$inject = [ '$scope', '$http' ];

function TournamentsCtrl($scope, $http) {
	$http.get('api/tournaments').success(function(data) {
		$scope.tournaments = data;
	});
}
TournamentsCtrl.$inject = [ '$scope', '$http' ];

function TournamentCtrl($scope, $http, $routeParams) {
	$http.get('api/tournaments/' + $routeParams.id).success(function(data) {
		$scope.tournament = data;
	});
}
TournamentCtrl.$inject = [ '$scope', '$http', '$routeParams' ];

function HallOfFameCtrl($scope, $http) {
	$http.get('api/stats/halloffame').success(function(data) {
		$scope.halloffameentries = data;
	});
}
HallOfFameCtrl.$inject = [ '$scope', '$http' ];

function MatchCtrl($scope) {
	var findMembers = function(groups,teamId){
		var members = [];
		angular.forEach(groups, function(group){
			if (group.teamId == teamId) {
				angular.forEach(group.members, function(member){
					this.push(member);
				}, this);
			}
		}, members);
		return members;
	}
	
	$scope.team1Members = findMembers($scope.match.groups,$scope.tournament.team1.id);
	$scope.team2Members = findMembers($scope.match.groups,$scope.tournament.team2.id);
	
	$scope.matchResultAsString = function(winningTeamId, teamId) {
		if( winningTeamId == "draw" ) {
			return "D";
		} else if ( winningTeamId == teamId ) {
			return "W";
		}
	}
}
MatchCtrl.$inject = [ '$scope' ];
