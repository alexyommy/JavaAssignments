<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<title>Dashboard</title>
</head>
<body>
<div class="container">
	<div class="card">
		<h1>Success!</h1>
		<nav>
			<h3><a href="/link1">Link1</a></h3>
			<h3><a href="/link2">Link2</a></h3>
			<h3><a href="/logout">Log Out</a></h3>
		</nav>
	</div>
	<div class="card">
		<h2>Welcome <c:out value="${user.firstName}"/></h2>
		<h5><c:out value="${user.id}"/></h5>
	</div>
	
</div>	
</body>
</html>