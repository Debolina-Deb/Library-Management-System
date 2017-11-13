<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LibrarianHome</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville" rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
</head>
<body>
	<h1 align="center">Welcome to Library Management System - Librarian Home</h1>
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
		<a id="home" href="librarianHome.htm">Home</a>
		<a id="logout" href="">Logout</a>
	</h4>
</body>
</html>