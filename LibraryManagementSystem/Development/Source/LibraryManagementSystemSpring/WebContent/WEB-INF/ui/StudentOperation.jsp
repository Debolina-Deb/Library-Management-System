<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css?family=Inconsolata|Indie+Flower|Open+Sans|Oswald|Spectral+SC|Titillium+Web|Vollkorn+SC"
	rel="stylesheet">
<style>

* {
	font-family: 'Open Sans', sans-serif;
	font-family: 'Vollkorn SC', serif;
	font-family: 'Oswald', sans-serif;
	font-family: 'Spectral SC', serif;
	font-family: 'Titillium Web', sans-serif;
	font-family: 'Indie Flower', cursive;
	font-family: 'Inconsolata', monospace;
}

#form {
	border-radius: 25px;
	border: 2px solid #73AD21;
	padding: 20px;
	horizontal-align: center;
	margin-right: 20%;
	margin-left: 30%;

}
</style>
</head>
<body>
	<h1 align="center">Welcome to Library Management System</h1>
	<hr>
	<h4 align="right">Welcome ${userName }</h4>
	<div id="form" align="center">
		<h4>
			<a href="searchByName.htm">Search Book by Name</a>
		</h4>
		<h4>
			<a href="searchByAuthor.htm">Search Book by Author</a>
		</h4>
		<h4>
			<a href="showAll.htm">Show all Books</a>
		</h4>
	</div>
	<h4>
		<a href="">Home</a>
	</h4>
	<h4 align="right">
		<a href="">Logout</a>
	</h4>
</body>
</html>