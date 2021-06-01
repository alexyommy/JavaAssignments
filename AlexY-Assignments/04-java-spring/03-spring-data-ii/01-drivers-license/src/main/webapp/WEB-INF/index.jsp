<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>DMV App</title>
</head>
<body>
	<div class="container">
		<nav>
			<h2><a href="/new">Add Person</a> | <a href="/licenses/new">Add License</a></h2>
		</nav>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>License #</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ persons }" var="person">
				<tr>
					<td><a href="${person.id}">${person.id}</a></td>
					<td>${ person.firstName } ${ person.lastName }</td>
					<td>${ person.license.getNumberAsString() }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>	
	</div>
</body>
</html>