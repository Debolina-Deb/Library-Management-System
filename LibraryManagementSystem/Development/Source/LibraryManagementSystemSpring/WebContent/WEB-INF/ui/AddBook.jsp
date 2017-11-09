<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Library Management System(Add Book)</h1>
	<br>
	<hr>
	<h3 align="right">
		<%-- ${username } --%>
		Librarian Name
	</h3>
	<form action="checkBook.htm">
		Enter book Id:<input type="text" name="bookId" /> <input type="submit"
			value="Add/update" />
	</form>
	<c:if test="${book ne null}">
		<form:form action="onAdd.htm" modelAttribute="book" method="post">
			<form:label path="bookId">Book Id:</form:label>
			<form:input path="bookId" value="${book.bookId}" required="true"/>
			<br/>
			<form:label path="bookName">Book Name:</form:label>
			<form:input path="bookName" value="${book.bookName}" required="true" />
			<br />
			<form:label path="author">Author 2:</form:label>
			<form:input path="author" value="${book.author}" required="true" />
			<br />

			<form:label path="publisher">Publisher:</form:label>
			<form:input path="publisher" value="${book.publisher}"
				required="true" />
			<br />

			<form:label path="yearOfPublication">Year of Publication:</form:label>
			<form:input path="yearOfPublication"
				value="${book.yearOfPublication}" required="true" />
			<br />

			<form:label path="noOfBooks">No. Of Books:</form:label>
			<form:input path="noOfBooks" value="${book.noOfBooks}"
				required="true" />
			<br />
			<button type="submit">Add Book</button>

		</form:form>

	</c:if>
	<h4>
		<a href="">Home</a>
	</h4>
	<h4 align="right">
		<a href="">Logout</a>
	</h4>
</body>
</html>