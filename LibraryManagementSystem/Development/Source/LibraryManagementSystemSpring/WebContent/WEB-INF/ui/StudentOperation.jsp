<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/WEB-INF/ui/fragments/loggedInHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Home</title>
<link rel="stylesheet" href="css/imageEffect.css">
</head>
<body>
	<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
		<div class="hovereffect">
			<img class="img-responsive"
				src="https://cdn4.iconfinder.com/data/icons/project-management-5-3/65/236-512.png"
				alt="">
			<div class="overlay">
				<a class="info" href="searchByName.htm "><h2>Search Book by
						Name</h2></a>
			</div>
		</div>
	</div>
	<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
		<div class="hovereffect">
			<img class="img-responsive"
				src="http://clipart-library.com/img/1434690.png" alt="">
			<div class="overlay">
				<a class="info" href="searchByAuthor.htm"><h2>Search Book
						by Author</h2></a>
			</div>
		</div>
	</div>
	<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
		<div class="hovereffect">
			<img class="img-responsive"
				src="http://www.jumpstarttutoring.com/wp-content/uploads/2017/01/book-stack-png-16.png"
				alt="">
			<div class="overlay">
				<a class="info" href="showAll.htm"><h2>Show all Books</h2></a>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/ui/fragments/footer.jsp" />

</body>
</html>