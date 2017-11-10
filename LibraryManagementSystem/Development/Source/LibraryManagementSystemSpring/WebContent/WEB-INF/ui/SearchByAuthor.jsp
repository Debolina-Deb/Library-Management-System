<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

* {
	font-family: 'Spectral SC', serif;
}
#form {
	border-radius: 25px;
	border: 2px solid #73AD21;
	padding: 20px;
	horizontal-align: center;
	margin-right: 10%;
	margin-left: 10%;
	
}

th, td {
	padding: 8px;
	border-bottom: 1px solid #ddd;
	text-align: center;
}
</style>
</head>
<body>
	<h1 align="center">Welcome to Library Management System</h1>
	<hr>
	<div id="form" align="center">
		<form action="authorSearch.htm" method="post">
			<table>
				<tr>
					<td>Enter the Author Name -</td>
					<td><input type="text" name="author" required /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="submit"
						value="Search"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>