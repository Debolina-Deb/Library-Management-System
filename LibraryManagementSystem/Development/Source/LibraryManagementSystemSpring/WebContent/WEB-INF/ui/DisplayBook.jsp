<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/ui/fragments/loggedInHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Book</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville"
	rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
</head>
<body>
	<div id="form" align="center" class="table-responsive"
		style="width: 95%; margin-top: 100px; margin-bottom: 100px; margin-right: 100px; margin-left: 30px;">
		<h2 style="color: grey;" align="center">BOOK LIST</h2>
		<hr class="colorgraph">
		<table class="table table-bordered table-hover"
			style="text-align: center">
			<tr class="info">
				<th>Book Id
				<th>Book Name
				<th>Author
				<th>Publisher
				<th>Year of Publication
				<th>Quantity
				<th>Action
			</tr>
			<c:forEach items="${books }" var="book">
				<tr class="success">
					<td>${book.bookId}
					<td>${book.bookName}
					<td>${book.author}
					<td>${book.publisher}
					<td>${book.yearOfPublication}
					<td>${book.noOfBooks}
					<td><a href="delete.htm?bookId=${book.bookId}">Delete</a>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="/WEB-INF/ui/fragments/footer.jsp" />

</body>
</html>