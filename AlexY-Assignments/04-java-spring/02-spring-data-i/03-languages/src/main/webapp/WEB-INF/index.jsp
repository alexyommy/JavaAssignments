<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Welcome to Languages</h1>
	<p>We got this! We're gonna do great and be the best software engineer!</p>
	<table class="table table-dark">
	<thead>
	<td>ID</td>
	<td>Name</td>
	<td>Creator</td>
	<td>Version</td>
	</thead>	
	<tbody>
	<c:forEach items="${languages}" var="language">
	<tr>
	<td>${language.id}</td>
	<td>${language.name}</td>
	<td>${language.creator}</td>
	<td>${language.version}</td>
	</tr>
	</c:forEach>
	
	</tbody>
	</table>
</div>
</body>
</html>