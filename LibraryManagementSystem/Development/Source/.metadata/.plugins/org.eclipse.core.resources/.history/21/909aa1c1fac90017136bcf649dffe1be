<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/ui/fragments/loggedInHeader.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue/return</title>
<link href="css/form.css" rel="stylesheet">
</head>
<body>
	<div id="form" align="center" class="table-responsive"
		style="width: 95%; margin-top: 100px; margin-bottom: 100px; margin-right: 100px; margin-left: 30px;">
		<c:if test="${pendingRequests ne null}">
			<table class="table table-bordered table-hover"
				style="text-align: center">
				<tr class="info">
					<th>Registration Id</th>
					<th>Book Id</th>
					<th>User Id</th>
					<th>Registration Date</th>
					<th>Status</th>
					<th>Action
				</tr>
				<c:forEach items="${pendingRequests}" var="req">
					<tr class="success">
						<td>${req.registrationId}</td>
						<td>${req.bookId}</td>
						<td>${req.userId}</td>
						<td>${req.registrationDate}</td>
						<td>${req.status}</td>
						<td><a href="issue.htm?registrationId=${req.registrationId}">Issue</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<jsp:include page="/WEB-INF/ui/fragments/footer.jsp" />

</body>
</html>