<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LibrarianHome</title>
<style>
#form {
    border-radius: 25px;
    border: 2px solid #73AD21;
    padding: 20px; 
    position:absolute;
    margin-right : 270px;
    margin-left : 250px;
}
</style>
</head>
<body>
	<h1 align="center">Welcome to Library Management System</h1>
	<hr>
	<h4 align="right">Welcome ${userName }</h4>
	<div id="form">
		<h3><a href="display.htm?userName=${userName} ">Display All Books</a></h3>
		<h3><a href="addUpdate.htm">Add/Update Book</a></h3>
		<h3><a href="">View Pending Issue Requests</a></h3>
		<h3><a href="">Return Book</a>	</h3>
		<h3>${message }</h3>
		<h4 align="right">
			<a href="">Logout</a>
		</h4>
	</div>
</body>
</html>