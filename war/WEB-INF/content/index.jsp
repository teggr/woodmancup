<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				</a> <a class="brand" href="/">Woodman Cup</a>
				<div class="nav-collapse collapse">
					<ul id="menu-bar" class="nav">
						
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div id="hall-of-fame" class="container">

		<h1>Woodman Cup Hall Of Fame</h1>

		<table class="table  table-condensed  table-striped table-bordered">
			<thead>
				<tr>
					<td>Pos</td>
					<td>+/-</td>
					<td>Player</td>
					<td>Victories</td>
					<td>AWC</td>
					<td>Putt</td>
					<td>W</td>
					<td>D</td>
					<td>L</td>
					<td>Total</td>
				</tr>
			</thead>
			<tbody>
<%-- 				<c:forEach var="entry" items="${hallOfFameEntryList}" varStatus="status"> --%>
					<tr>
						<td>${status.count}</td>
						<td></td>
						<td>${entry.member.firstname} ${entry.member.surname}</td>
						<td>${entry.victories}</td>
						<td>${entry.alternativeWoodmanCupWins}</td>
						<td>${entry.puttOffWins}</td>
						<td>${entry.wins}</td>
						<td>${entry.draws}</td>
						<td>${entry.losses}</td>
						<td>${entry.points}</td>
					</tr>
<%-- 				</c:forEach> --%>
			</tbody>
		</table>

		<div>

			<table class="table table-condensed table-striped table-bordered">
				<tbody>

					<tr>
						<td>Woodman Cup Victory</td>
						<td>5 pts</td>
					</tr>
					<tr>
						<td>Alternative Woodman Cup Win</td>
						<td>4 pts</td>
					</tr>
					<tr>
						<td>Putt Off Win</td>
						<td>4 pts</td>
					</tr>
					<tr>
						<td>Win</td>
						<td>3 pts</td>
					</tr>
					<tr>
						<td>Draw</td>
						<td>1 pts</td>
					</tr>
					<tr>
						<td>Loss</td>
						<td>0 pts</td>
					</tr>
				</tbody>
			</table>

		</div>

	</div>
	<!-- /container -->
	
	<div id="members" class="container">

		<h1>Members</h1>
		<table  class="table  table-condensed  table-striped ">
			<thead>
				<tr>
					<td>Name</td>
					<td>Appearances</td>
				</tr>
			</thead>
			<tbody>
<%-- 				<c:forEach var="member" items="${memberList}"> --%>
					<tr>
						<td>${member.firstname} ${member.surname}</td>
						<td>${member.appearanceCount}</td>
					</tr>
<%-- 				</c:forEach> --%>
			</tbody>
		</table>

	</div>
	<!-- /container -->
	
	<div id="tournament" class="container">

		<h1>
			${tournament.venue.name}
<%-- 			<fmt:formatDate value="${tournament.date}" pattern="yyyy" /> --%>
		</h1>

		<h2>${tournament.team1.name} [${tournament.team1Points}] vs
			${tournament.team2.name} [${tournament.team2Points}]</h2>

		<table>
			<tbody>
				<tr>
					<td>
						<table class="table table-bordered">
<%-- 							<c:forEach var="player" items="${team1List}"> --%>
								<tr>
									<td>${player.firstname} ${player.surname}</td>
<%-- 									<td><c:if test="${player.captain}">(C)</c:if></td> --%>
								</tr>
<%-- 							</c:forEach> --%>
						</table>
					</td>
					<td></td>
					<td>
						<table class="table table-bordered">
<%-- 							<c:forEach var="player" items="${team2List}"> --%>
								<tr>
									<td>${player.firstname} ${player.surname}</td>
<%-- 									<td><c:if test="${player.captain}">(C)</c:if></td> --%>
								</tr>
<%-- 							</c:forEach> --%>
						</table>
					</td>
				</tr>
			</tbody>
		</table>

<%-- 		<c:if test="${puttOffWinner != null}"> --%>
			<h2>Putt Off Winner</h2>
			${puttOffWinner.firstname} ${puttOffWinner.surname}
<%-- 		</c:if> --%>

<%-- 		<c:if test="${alternativeWoodmanCupWinner !=null}"> --%>
			<h2>Alternative Woodman Cup Winner</h2>
			${alternativeWoodmanCupWinner.firstname} ${alternativeWoodmanCupWinner.surname}
<%-- 		</c:if> --%>

		<h2>Results</h2>

		<table class="table">
<%-- 			<c:forEach var="session" items="${tournament.sessions}"> --%>
				<tr class="info">
					<td colspan="7">
						<h3>Session ${session.sessionNumber} -
							${session.sessionFormat}</h3>
					</td>
				</tr>
<%-- 				<c:forEach var="match" items="${session.matches}"> --%>
					<tr>
						<td>
<%-- 						<c:if test="${match.winningTeamId == tournament.team1.id}">W</c:if>  --%>
<%-- 						<c:if test="${match.winningTeamId == 'draw'}">D</c:if> --%>
								</td>
<%-- 						<c:forEach var="group" items="${match.groups}"> --%>
<%-- 							<c:if test="${group.teamId == tournament.team1.id}"> --%>
<%-- 								<c:choose> --%>
<%-- 									<c:when test="${group.memberCount>1}"> --%>
<%-- 										<c:forEach var="member" items="${group.members}"> --%>
											<td>${member.surname}</td>
<%-- 										</c:forEach> --%>
<%-- 									</c:when> --%>
<%-- 									<c:otherwise> --%>
<%-- 										<c:forEach var="member" items="${group.members}"> --%>
											<td>${member.surname}</td>
<%-- 										</c:forEach> --%>
										<td></td>
<%-- 									</c:otherwise> --%>
<%-- 								</c:choose> --%>
<%-- 							</c:if> --%>
<%-- 						</c:forEach> --%>
						<td>vs</td>
<%-- 						<c:forEach var="group" items="${match.groups}"> --%>
<%-- 							<c:if test="${group.teamId == tournament.team2.id}"> --%>
<%-- 								<c:choose> --%>
<%-- 									<c:when test="${group.memberCount>1}"> --%>
<%-- 										<c:forEach var="member" items="${group.members}"> --%>
											<td>${member.surname}</td>
<%-- 										</c:forEach> --%>
<%-- 									</c:when> --%>
<%-- 									<c:otherwise> --%>
<%-- 										<c:forEach var="member" items="${group.members}"> --%>
											<td>${member.surname}</td>
<%-- 										</c:forEach> --%>
<!-- 										<td></td> -->
<%-- 									</c:otherwise> --%>
<%-- 								</c:choose> --%>
<%-- 							</c:if> --%>
<%-- 						</c:forEach> --%>
						<td>
<%-- 						<c:if --%>
<%-- 								test="${match.winningTeamId == tournament.team2.id}">W</c:if> <c:if --%>
<%-- 								test="${match.winningTeamId == 'draw'}">D</c:if> --%>
								</td>
					</tr>
<%-- 				</c:forEach> --%>
<%-- 			</c:forEach> --%>
		</table>

	</div>
	<!-- /container -->
	
	<div id="tournaments" class="container">

		<h1>Tournaments</h1>
		<table class="table">
			<thead>
				<tr>
					<td>Date</td>
					<td>Venue</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
<%-- 				<c:forEach var="tournament" items="${tournamentList}"> --%>
					<tr>
<%-- 						<td><fmt:formatDate value="${tournament.date}" pattern="yyyy" /></td> --%>
						<td>${tournament.venue.name}</td>
						<td><a class="btn btn-primary " href="/tournament/${tournament.id}">View The Results <i class="icon-circle-arrow-right icon-white"></i></a></td>
					</tr>
<%-- 				</c:forEach> --%>
			</tbody>
		</table>

	</div>
	<!-- /container -->
	
	<div id="venues" class="container">

		<h1>Venues</h1>
		<table class="table">
			<thead>
				<tr>
					<td>Name</td>
					<td>Postcode</td>
					<td>Website</td>
				</tr>
			</thead>
			<tbody>
<%-- 				<c:forEach var="venue" items="${venueList}"> --%>
					<tr>
						<td>${venue.name}</td>
						<td>${venue.postcode}</td>
						<td><a href="${venue.website}">${venue.website}</a></td>
					</tr>
<%-- 				</c:forEach> --%>
			</tbody>
		</table>

	</div>
	<!-- /container -->
	
	<!-- templates -->
	<script type="text/templates" id="menu-bar-item-template">
		<a href="{{ link }}">{{ name }}</a>
	</script>

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
	<script src="../static/js/bootstrap.min.js"></script>
	<script src="../static/js/underscore.js"></script>
	<script src="../static/js/backbone.js"></script>
	
	<script src="../static/js/main.js"></script>
		
</body>
</html>
