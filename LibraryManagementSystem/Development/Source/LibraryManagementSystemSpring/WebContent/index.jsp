<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/WEB-INF/ui/fragments/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" href="css/form.css">
<script type="text/javascript" src="js/form.js"></script>
</head>
<body>
	<div class="container">

		<div class="row" style="margin-top: 60px">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form role="form" action="login.htm" method="post">
					<fieldset>
						<h2 style="color: grey;">Please Sign In</h2>
						<hr class="colorgraph">
						<div class="form-group">
							<input type="text" name="userName" id="userName"
								class="form-control input-lg" placeholder="Username"
								required="required">
						</div>
						<div class="form-group">
							<input type="password" name="password" id="password"
								class="form-control input-lg" placeholder="Password"
								required="required">
						</div>
						<span class="button-checkbox">
							<button type="button" class="btn" data-color="info">Remember
								Me</button> <input type="checkbox" name="remember_me" id="remember_me"
							checked="checked" class="hidden"> <a href=""
							class="btn btn-link pull-right">Forgot Password?</a>
						</span>
						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input type="submit" class="btn btn-lg btn-success btn-block"
									value="Sign In">
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<a href="signUp.htm" class="btn btn-lg btn-primary btn-block">Register</a>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>

	</div>
	<h3>${message }</h3>
	<jsp:include page="/WEB-INF/ui/fragments/footer.jsp" />

</body>
</body>

</html>