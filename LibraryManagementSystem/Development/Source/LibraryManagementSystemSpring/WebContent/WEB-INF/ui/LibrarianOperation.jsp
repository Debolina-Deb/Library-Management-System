<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/WEB-INF/ui/fragments/loggedInHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LibrarianHome</title>
</head>
<body>
	<h1 align="center">Welcome to Library Management System -
		Librarian Home</h1>
	<hr>
	<h4 align="right">Welcome ${userName }</h4>
	<div id="formOperation" align="center">
		<h3>
			<a href="display.htm?userName=${userName} ">Display All Books</a>
		</h3>
		<h3>
			<a href="addUpdate.htm">Add/Update Book</a>
		</h3>
		<h3>
			<a href="pendingRequest.htm">View Pending Issue Requests</a>
		</h3>
		<h3>
			<a href="issuedRequest.htm">Return Book</a>
		</h3>
	</div>
	<h3>${message }</h3>
	<h4>
		<a id="home" href="librarianHome.htm">Home</a> <a id="logout" href="">Logout</a>
	</h4>
</body>
</html>