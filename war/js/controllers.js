'use strict';

/* Controllers */

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
	$http.get('api/statistics').success(function(data) {
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
