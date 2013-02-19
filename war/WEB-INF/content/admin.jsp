<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Woodman Cup</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="../static/css/bootstrap.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="../static/css/bootstrap-responsive.css" rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="../static/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../static/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../static/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../static/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../static/ico/apple-touch-icon-57-precomposed.png">
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">Woodman Cup Admin</a>
				<div class="nav-collapse collapse">
					<ul id="menu-bar" class="nav">

					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div id="home" class="container page">
		<div id="new-member" class="well">
			<h2>Add a new member</h2>
			<form class="form-horizontal new-member-form">
				<div class="control-group">
					<label class="control-label" for="memberId">Id</label>
					<div class="controls">
						<input type="text" id="memberId" placeholder="Unique id">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="firstname">First Name</label>
					<div class="controls">
						<input type="text" id="firstname">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="surname">Surname</label>
					<div class="controls">
						<input type="text" id="surname">
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button type="submit" class="btn">Create</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div id="members" class="container page">

		<h1>Members</h1>
		<table id="members-table"
			class="table  table-condensed  table-striped ">
			<thead>
				<tr>
					<td>Name</td>
					<td>Appearances</td>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>

	</div>
	<!-- /container -->

	<div id="tournament" class="container page"></div>
	<!-- /container -->

	<div id="tournaments" class="container page">

		<h1>Tournaments</h1>
		<table id="tournaments-table" class="table">
			<thead>
				<tr>
					<td>Date</td>
					<td>Venue</td>
					<td></td>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>

	</div>
	<!-- /container -->

	<div id="venues" class="container page">

		<h1>Venues</h1>
		<table id="venues-table" class="table">
			<thead>
				<tr>
					<td>Name</td>
					<td>Postcode</td>
					<td>Website</td>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>

	</div>
	<!-- /container -->

	<!-- templates -->
	<script type="text/template" id="menu-bar-item-template">
		<a href="<@= link @>"><@= name @></a>
	</script>

	<script type="text/template" id="member-row-template">
		<td><@= firstname @> <@= surname @></td>
		<td><@= appearances.length @></td>
	</script>

	<script type="text/template" id="venue-row-template">
		<td><@= name @></td>
		<td><@= postcode @></td>
		<td><a href="<@= website @>"><@= website @></a></td>
	</script>

	<script type="text/template" id="tournament-row-template">
		<td><@= date @></td>
		<td><@= venue.name @></td>
		<td><a class="btn btn-primary "
			href="#!/tournaments/<@= id @>">View The Results <i
				class="icon-circle-arrow-right icon-white"></i></a></td>
	</script>

	<script type="text/template" id="tournament-template">

		<h1>
			<@= venue.name @> <@= date @>
		</h1>

		<h2><@= team1.name @> [<@= team1Points @>] vs
			<@= team2.name @> [<@= team2Points @>]</h2>

		<table>
			<tbody>
				<tr>
					<td>
						<table class="table table-bordered">
							<@ _.each( team1List, function( player ) { @>
							<tr>
								<td><@= player.firstname @> <@= player.surname @></td>
								<@ if( player.captain ) { @>
									<td>(C)</td>
								<@ } else { @>
									<td></td>
								<@ }  @>
							</tr>
							<@ }); @>
						</table>
					</td>
					<td></td>
					<td>
						<table class="table table-bordered">
							<@ _.each( team2List, function( player ) { @>
							<tr>
								<td><@= player.firstname @> <@= player.surname @></td>
								<@ if( player.captain ) { @>
									<td>(C)</td>
								<@ } else { @>
									<td></td>
								<@ } @>
							</tr>
							<@ }); @>
						</table>
					</td>
				</tr>
			</tbody>
		</table>


		<h2>Results</h2>

		<table class="table">
			<@ _.each(sessions, function(session) { @>
			<tr class="info">
				<td colspan="7">
					<h3>Session <@= session.sessionNumber @> -
						<@= session.sessionFormat @></h3>
				</td>
			</tr>
			<@ _.each(session.matches, function(match) { @>
			<tr>
				<td>
					<@ if(match.winningTeamId == team1.id) { @>W<@ } @>
					<@ if(match.winningTeamId == 'draw') { @>D<@ } @>
				</td>
				<@ _.each(match.groups,function(group) { @>
					<@ if (group.teamId == team1.id) { @>
						<@ _.each(group.members, function(member) { @>
							<td><@= member.surname @></td>
						<@ }); @>
						<@ if(group.memberCount == 1) { @>
							<td></td>
						<@ }@>
					<@ } @>
				<@ }); @>
				<td>vs</td>
				<@ _.each(match.groups,function(group) { @>
					<@ if (group.teamId == team2.id) { @>
						<@ _.each(group.members, function(member) { @>
							<td><@= member.surname @></td>
						<@ }); @>
						<@ if(group.memberCount == 1) { @>
							<td></td>
						<@ }@>
					<@ } @>
				<@ }); @>
				<td>
					<@ if(match.winningTeamId == team2.id) { @>W<@ } @>
					<@ if(match.winningTeamId == 'draw') { @>D<@ } @>	
				</td>
			</tr>
			<@ }); @>
			<@ }); @>
		</table>

	</script>

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
	<script src="../static/js/vendor/bootstrap.min.js"></script>
	<script src="../static/js/vendor/underscore.js"></script>
	<script src="../static/js/vendor/backbone.js"></script>

	<script src="../static/js/config.js"></script>

	<script src="../static/js/app/appearances.js"></script>
	<script src="../static/js/app/members.js"></script>
	<script src="../static/js/app/venues.js"></script>
	<script src="../static/js/app/tournaments.js"></script>
	<script src="../static/js/app/menu.js"></script>
	<script src="../static/js/app/admin.js"></script>

	<script type="text/javascript">
		StaticData = {};
		StaticData.members = <c:out value="${members}" escapeXml="false" />;
		StaticData.venues = <c:out value="${venues}" escapeXml="false" />;
		StaticData.tournaments = <c:out value="${tournaments}" escapeXml="false" />;
		StaticData.appearances = <c:out value="${appearances}" escapeXml="false" />;
	</script>


	<script src="../static/js/main-admin.js"></script>

</body>
</html>