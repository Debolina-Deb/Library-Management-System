<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function validateform(){  
	var p1=document.signUpForm.password.value;  
	var p2=document.signUpForm.repeatPassword.value;  
	  
	if (p1!=p2)
	{  
	  alert("Passwords do not match!!");  
	  return false;  
	}
	}  
</script>
<title>Insert title here</title>
<style>
#form {
    border-radius: 25px;
    border: 2px solid #73AD21;
    padding: 20px; 
    margin-right : 270px;
    margin-left : 250px;
}

th, td {
    padding: 8px;
    border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
	<h1 align="center">Welcome to Library Management System</h1>
	<hr>
	<div id="form">
		<form:form id="signUpForm" action="signUp.htm" modelAttribute="user" method="post" onsubmit="return validateform()">
			<table align="center">
				<tr>
					<td><form:label path="userName">User Name : </form:label></td>
					<td><form:input id="userName" path="userName" placeholder="Enter UserName" required="true"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="emailId">Email : </form:label></td>
					<td><form:input id="emailId" path="emailId" placeholder="Enter Email ID" required="true"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="password">Password : </form:label></td>
					<td><form:password id="password" path="password" placeholder="Enter Password" required="true"></form:password></td>
				</tr>
				<tr>
					<td><form:label path="repeatPassword">Repeat Password : </form:label></td>
					<td><form:password id="repeatPassword" path="repeatPassword" placeholder="Repeat Password" required="true"></form:password></td>
				</tr>
				<tr>
					<td><form:label path="librarian">Librarian(True/False) : </form:label>
					<td><form:select path="librarian" required="true">
						<form:options items="${librarian}"/>
					</form:select>
				</tr>
				<tr>
					<td colspan="2">By creating an account you agree to our <a href="">Terms & Privacy</a>.
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><form:button type="submit">Save</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>