<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/form.css">
<script type="text/javascript" src="js/form.js"></script>
</head>
<body>
	<header class="bs-docs-nav navbar navbar-static-top" id="top">
		<div class="container">
			<div class="navbar-header">
				<button aria-controls="bs-navbar" aria-expanded="false"
					class="navbar-toggle collapsed" data-target="#bs-navbar"
					data-toggle="collapse" type="button">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<c:if test="${null eq status}">
					<a class="navbar-brand" href="librarianHome.htm">LIBRARY
						MANAGEMENT SYSTEM</a>
				</c:if>
				<c:if test="${status eq 0}">
					<a class="navbar-brand" href="studentHome.htm">LIBRARY
						MANAGEMENT SYSTEM</a>
				</c:if>

			</div>
			<nav class="navbar-collapse collapse" id="bs-navbar"
				aria-expanded="false" style="height: 1px;">
				<ul class="nav navbar-nav navbar-right">
					<li><a> <strong>${userName}</strong> <span
							class="glyphicon glyphicon-user"></span>
					</a></li>
					<li><a href="https://github.com/paragpatidar/lms.git" class="">
							<span class="glyphicon glyphicon-cloud"></span>GitHub Link
					</a></li>
					<li><a href="logout.htm">Logout</a></li>
				</ul>
			</nav>
		</div>
	</header>
</body>
</html>