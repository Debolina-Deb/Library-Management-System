<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/ui/fragments/loggedInHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Update Book</title>
</head>
<body>
	<c:if test="${bookId eq null }">
		<div class="container">
			<div class="row" style="margin-top: 60px">
				<div
					class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
					<form role="form" action="checkBook.htm" method="post">
						<fieldset>
							<h2 style="color: grey;">ADD OR UPDATE BOOK</h2>
							<hr class="colorgraph">
							<div class="form-group">
								<input type="text" name="bookId" id="bookId"
									class="form-control input-lg" placeholder="Book ID"
									required="required">
							</div>
							<hr class="colorgraph">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<input class="btn btn-lg btn-success btn-block" type="submit"
										value="Add" />
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>

		</div>
	</c:if>

	<c:if test="${book ne null}">
		<div class="container">
			<div class="row" style="margin-top: 60px">
				<div
					class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
					<form:form id="bookForm" action="onAdd.htm" modelAttribute="book"
						method="post">
						<fieldset>
							<h2>UPDATE BOOK</h2>
							<hr class="colorgraph">
							<div class="form-group">
								<form:input path="bookId" pattern="[0-9]{4}"
									title="Book Id should be of 4 digits (1111 or 9999)"
									value="${bookId}" required="true" placeholder="Enter Book Id"
									cssClass="form-control input-lg" />
								<form:errors path="bookId" cssStyle="color:red" />
							</div>
							<div class="form-group">
								<form:input path="bookName" cssClass="form-control input-lg"
									value="${book.bookName}" required="true"
									placeholder="Enter Book Name" />
								<form:errors path="bookName" cssStyle="color:red" />
							</div>
							<div class="form-group">
								<form:input path="author" value="${book.author}" required="true"
									cssClass="form-control input-lg"
									placeholder="Enter Author Name" />
								<form:errors path="author" cssStyle="color:red" />
							</div>
							<div class="form-group">
								<form:input path="publisher" value="${book.publisher}"
									required="true" cssClass="form-control input-lg"
									placeholder="Enter Publisher Name" />
								<form:errors path="publisher" cssStyle="color:red" />
							</div>
							<div class="form-group">
								<form:input path="yearOfPublication" pattern="[0-9]{4}"
									title="YOP should be in format YYYY"
									value="${book.yearOfPublication}" required="true"
									cssClass="form-control input-lg"
									placeholder="Enter year of Publication" />
								<form:errors path="yearOfPublication" cssStyle="color:red" />
							</div>

							<div class="form-group">
								<form:input path="noOfBooks" value="${book.noOfBooks}"
									required="true" cssClass="form-control input-lg"
									placeholder="Enter Number Of Books" />
								<form:errors path="noOfBooks" cssStyle="color:red" />
							</div>
							<hr class="colorgraph">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<input type="submit" class="btn btn-lg btn-success btn-block"
										value="Update Book">
								</div>

							</div>
						</fieldset>
					</form:form>
				</div>
			</div>
		</div>
	</c:if>
	<jsp:include page="/WEB-INF/ui/fragments/footer.jsp" />

</body>
</html>