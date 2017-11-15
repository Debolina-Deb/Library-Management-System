<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/ui/fragments/loggedInHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville"
	rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
</head>
<body>
	<c:choose>
		<c:when test="${input ne null}">
			<div class="container">
				<div class="row" style="margin-top: 60px">
					<div
						class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
						<form role="form" action="authorSearch.htm" method="post">
							<fieldset>
								<h2 style="color: grey;">Enter the Author Name</h2>
								<hr class="colorgraph">
								<div class="form-group">
									<input type="text" name="authorName" class="form-control input-lg"
										placeholder="Author Name" required />
								</div>
								<hr class="colorgraph">
								<div class="row">
									<div class="col-xs-6 col-sm-6 col-md-6">
										<input class="btn btn-lg btn-success btn-block" type="submit"
											value="Search" />
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>

			</div>
		</c:when>
		<c:otherwise>

			<div class="container">
				<div class="row" style="margin-top: 60px">
					<div
						class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
						<form role="form" action="bookSearch.htm" method="post">
							<fieldset>
								<h2 style="color: grey;">Enter the Book Name</h2>
								<hr class="colorgraph">
								<div class="form-group">
									<input type="text" name="bookName"
										class="form-control input-lg" placeholder="Book Name" required />
								</div>
								<hr class="colorgraph">
								<div class="row">
									<div class="col-xs-6 col-sm-6 col-md-6">
										<input class="btn btn-lg btn-success btn-block" type="submit"
											value="Search" />
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>

			</div>
		</c:otherwise>
	</c:choose>
	<jsp:include page="/WEB-INF/ui/fragments/footer.jsp" />

</body>
</html>