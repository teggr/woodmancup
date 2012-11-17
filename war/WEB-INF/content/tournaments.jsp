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
						<li class="active"><a href="/tournament/list">Tournaments</a></li>
						<li><a href="/tournament/2011">2011</a></li>
						<li><a href="/tournament/2010">2010</a></li>
						<li><a href="/tournament/2009">2009</a></li>
						<li><a href="/tournament/2008">2008</a></li>
						<li><a href="/tournament/2007">2007</a></li>
						<li><a href="/tournament/2006">2006</a></li>
						<li><a href="/tournament/2007">2005</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

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
				<c:forEach var="tournament" items="${tournamentList}">
					<tr>
						<td><fmt:formatDate value="${tournament.date}" pattern="yyyy" /></td>
						<td>${tournament.venue.name}</td>
						<td><a class="btn btn-primary " href="/tournament/${tournament.id}">View The Results <i class="icon-circle-arrow-right icon-white"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
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
