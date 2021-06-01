<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<title>Ninjas</title>
</head>
<body>
<div class="container">
	<h1>Dojos & Ninjas</h1>
	<nav>
		<h3><a href="/dojos">Dojos</a></h3>
		<h3><a href="/ninjas/new">Add Ninja</a></h3>
	</nav>
	<h2>All Ninjas</h2>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Dojo</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ninjas}" var="ninja">
			<tr>
				<td>${ninja.firstName} ${ninja.lastName}</td>
				<td>${ninja.age}</td>
				<td>${ninja.dojo.name}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>