<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue/return</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville" rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
</head>
<body>
	<h1 align="center">Welcome to Library Management System - Issue Book Requests</h1>
	<hr>
	<div id="form" align="center">
	<c:if test="${pendingRequests ne null}">
		<table align="center">
			<tr>
				<th>Registration Id</th>
				<th>Book Id</th>
				<th>User Id</th>
				<th>Registration Date</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${pendingRequests }" var="request">
				<tr>
					<td>${request.registrationId}</td>
					<td>${request.bookId}</td>
					<td>${request.userId}</td>
					<td>${request.registrationDate}</td>
					<td>${request.status}</td>
					<td><a href="issue.htm?registrationId=${request.registrationId}">Issue</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
	<h4>
		<a href="">Home</a>
	</h4>
	<h4 align="right">
		<a href="">Logout</a>
	</h4>

</body>
</html>