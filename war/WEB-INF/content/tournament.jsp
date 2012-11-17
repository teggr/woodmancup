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
				</a> <a class="brand" href="/">Woodman Cup</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li><a href="/">Home</a></li>
						<li><a href="/member/list">Members</a></li>
						<li><a href="/venue/list">Venues</a></li>
						<li><a href="/tournament/list">Tournaments</a></li>
						<c:choose>
							<c:when test="${tournament.id == '2011'}">
								<li class="active"><a href="/tournament/2011">2011</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/tournament/2011">2011</a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${tournament.id == '2010'}">
								<li class="active"><a href="/tournament/2010">2010</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/tournament/2010">2010</a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${tournament.id == '2009'}">
								<li class="active"><a href="/tournament/2009">2009</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/tournament/2009">2009</a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${tournament.id == '2008'}">
								<li class="active"><a href="/tournament/2008">2008</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/tournament/2008">2008</a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${tournament.id == '2007'}">
								<li class="active"><a href="/tournament/2007">2007</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/tournament/2007">2007</a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${tournament.id == '2006'}">
								<li class="active"><a href="/tournament/2006">2006</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/tournament/2006">2006</a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${tournament.id == '2005'}">
								<li class="active"><a href="/tournament/2005">2005</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/tournament/2005">2005</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<h1>
			${tournament.venue.name}
			<fmt:formatDate value="${tournament.date}" pattern="yyyy" />
		</h1>

		<h2>${tournament.team1.name} [${tournament.team1Points}] vs
			${tournament.team2.name} [${tournament.team2Points}]</h2>

		<table>
			<tbody>
				<tr>
					<td>
						<table class="table table-bordered">
							<c:forEach var="player" items="${team1List}">
								<tr>
									<td>${player.firstname} ${player.surname}</td>
									<td><c:if test="${player.captain}">(C)</c:if></td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td></td>
					<td>
						<table class="table table-bordered">
							<c:forEach var="player" items="${team2List}">
								<tr>
									<td>${player.firstname} ${player.surname}</td>
									<td><c:if test="${player.captain}">(C)</c:if></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</tbody>
		</table>

		<c:if test="${puttOffWinner != null}">
			<h2>Putt Off Winner</h2>
			${puttOffWinner.firstname} ${puttOffWinner.surname}
		</c:if>

		<c:if test="${alternativeWoodmanCupWinner !=null}">
			<h2>Alternative Woodman Cup Winner</h2>
			${alternativeWoodmanCupWinner.firstname} ${alternativeWoodmanCupWinner.surname}
		</c:if>

		<h2>Results</h2>

		<table class="table">
			<c:forEach var="session" items="${tournament.sessions}">
				<tr class="info">
					<td colspan="7">
						<h3>Session ${session.sessionNumber} -
							${session.sessionFormat}</h3>
					</td>
				</tr>
				<c:forEach var="match" items="${session.matches}">
					<tr>
						<td><c:if
								test="${match.winningTeamId == tournament.team1.id}">W</c:if> <c:if
								test="${match.winningTeamId == 'draw'}">D</c:if></td>
						<c:forEach var="group" items="${match.groups}">
							<c:if test="${group.teamId == tournament.team1.id}">
								<c:choose>
									<c:when test="${group.memberCount>1}">
										<c:forEach var="member" items="${group.members}">
											<td>${member.surname}</td>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach var="member" items="${group.members}">
											<td>${member.surname}</td>
										</c:forEach>
										<td></td>
									</c:otherwise>
								</c:choose>
							</c:if>
						</c:forEach>
						<td>vs</td>
						<c:forEach var="group" items="${match.groups}">
							<c:if test="${group.teamId == tournament.team2.id}">
								<c:choose>
									<c:when test="${group.memberCount>1}">
										<c:forEach var="member" items="${group.members}">
											<td>${member.surname}</td>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach var="member" items="${group.members}">
											<td>${member.surname}</td>
										</c:forEach>
										<td></td>
									</c:otherwise>
								</c:choose>
							</c:if>
						</c:forEach>
						<td><c:if
								test="${match.winningTeamId == tournament.team2.id}">W</c:if> <c:if
								test="${match.winningTeamId == 'draw'}">D</c:if></td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>

	</div>
	<!-- /container -->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!--     <script src="../static/js/jquery.js"></script> -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
		<script src="../static/js/bootstrap.min.js"></script>

</body>
</html>
