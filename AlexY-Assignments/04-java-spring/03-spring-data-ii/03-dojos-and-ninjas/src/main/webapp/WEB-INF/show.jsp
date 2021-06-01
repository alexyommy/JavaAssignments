<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<nav>
		<h3><a href="/dojas">Dojos</a></h3>
	</nav>
	<h1>${ dojo.name } Dojo Ninjas</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${dojo.ninjas }" var="ninja">
			<tr>
				<td>${ninja.firstName } ${ninja.lastName }</td>
				<td>${ninja.age }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<p><a href="/">Go back</a></p>
</div>
</body>
</html>