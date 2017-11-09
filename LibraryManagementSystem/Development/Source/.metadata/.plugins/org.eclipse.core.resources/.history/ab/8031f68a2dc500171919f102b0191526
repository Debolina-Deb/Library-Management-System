<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue/return</title>
</head>
<body>
<c:if test="${reqPList ne null}">
			<table border="1">
				<tr>
					<th>Registration Id</th>
					<th>Book Id</th>
					<th>User Id</th>
					<th>Registration Date</th>
					<th>Status</th>
				</tr>
				<c:forEach items="${reqPList}" var="req">
					<tr>
						<td>${req.registrationId}</td>
						<td>${req.bookId}</td>
						<td>${req.userId}</td>
						<td>${req.registrationDate}</td>
						<td>${req.status}</td>
						<td><a href="">Issue</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
<h4><a href="">Home</a></h4>
<h4 align="right"><a href="">Logout</a></h4>		
		
</body>
</html>