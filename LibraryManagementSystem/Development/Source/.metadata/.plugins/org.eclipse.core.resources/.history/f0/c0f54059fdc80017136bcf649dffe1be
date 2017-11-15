<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/ui/fragments/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Slabo+27px"
	rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
<script type="text/javascript" src="js/userForm.js"></script>
<title>Sign Up</title>
</head>
<body>
	<hr>
	<div class="container">
		<div class="row" style="margin-top: 60px">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form:form role="form" action="signUp.htm" modelAttribute="user"
					method="post">
					<fieldset>
						<h2>Sign Up</h2>
						<hr class="colorgraph">
						<div class="form-group">
							<form:input path="userName" name="userName" id="userName"
								cssClass="form-control input-lg" placeholder="Enter Username"
								required="true"></form:input>
							<form:errors path="userName" cssStyle="color:red" />

						</div>
						<div class="form-group">
							<form:input id="emailId" path="emailId"
								cssClass="form-control input-lg" placeholder="Enter Email ID"
								required="true"></form:input>
							<form:errors path="emailId" cssStyle="color:red" />
						</div>
						<div class="form-group">
							<form:password path="password" name="password" id="password"
								cssClass="form-control input-lg" placeholder="Password"
								required="true"></form:password>
							<form:errors path="password" cssStyle="color:red" />
							<font id="passwordError" style="color: red;">${passwordError}
							</font>
						</div>
						<div class="form-group">
							<form:password path="repeatPassword" name="repeatPassword"
								id="repeatPassword" cssClass="form-control input-lg"
								placeholder="Repeat Password" required="true"></form:password>
							<form:errors path="password" cssStyle="color:red" />
							<font id="confirmPasswordError" style="color: red;">${passwordError}
							</font>
						</div>
						<div class="form-group">
							<form:select path="librarian" cssClass="form-control input-lg"
								required="true">
								<form:options items="${librarian}" />
							</form:select>
						</div>
						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input type="submit" onclick="return validateform()"
									class="btn btn-lg btn-success btn-block" value="Sign Up">
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
</body>
</html>