<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Home</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville" rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
</head>
<body>
	<h1 align="center">Welcome to Library Management System - Student Home</h1>
	<hr>
	<h4 align="right">Welcome ${userName }</h4>
	<div id="formOperation" align="center">
		<h3>
			<a href="searchByName.htm">Search Book by Name</a>
		</h3>
		<h3>
			<a href="searchByAuthor.htm">Search Book by Author</a>
		</h3>
		<h3>
			<a href="showAll.htm">Show all Books</a>
		</h3>
	</div>
	<h4>
		<a id="home" href="studentHome.htm">Home</a>
		<a id="logout" href="">Logout</a>
	</h4>
</body>
</html>