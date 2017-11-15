<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/ui/fragments/loggedInHeader.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book List</title>
<link href="css/form.css" rel="stylesheet">
</head>
<body>
	<div id="form" align="center" class="table-responsive"
		style="width: 95%; margin-top: 100px; margin-bottom: 100px; margin-right: 100px; margin-left: 30px;">
		<h2 align="center">Book List</h2>
		<c:if test="${books ne null }">
			<table class="table table-bordered table-hover"
				style="text-align: center">
				<tr class="info">
					<th>Book ID</th>
					<th>Book Name</th>
					<th>Book Author</th>
					<th>Publisher</th>
					<th>YOP</th>
					<th>No of Books</th>
					<th>Action
				</tr>

				<c:forEach items="${books}" var="book">
					<tr class="success">
						<td>${book.bookId }
						<td>${book.bookName }
						<td>${book.author }
						<td>${book.publisher }
						<td>${book.yearOfPublication }
						<td>${book.noOfBooks }
						<td><a href="requestBook.htm?bookId=${book.bookId}">Request
								Book</a>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<jsp:include page="/WEB-INF/ui/fragments/footer.jsp" />

</body>
</html>