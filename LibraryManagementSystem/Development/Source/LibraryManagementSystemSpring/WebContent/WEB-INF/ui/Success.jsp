<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="/WEB-INF/ui/fragments/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville"
	rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
<title>Success</title>
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: 60px">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form:form role="form">
					<fieldset>
						<h2>REGISTRATION SUCCESSFUL</h2>
						<h3>${message }</h3>
						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<a href="signUp.htm" class="btn btn-lg btn-primary btn-block">Register
									Another User</a>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<a href="index.jsp" class="btn btn-lg btn-primary btn-block">Return
									To Home</a>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/ui/fragments/footer.jsp" />

</body>
</html>