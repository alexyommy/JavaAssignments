<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<title>Add New Ninja</title>
</head>
<body>
<div class="container">
	<h2>Add a New Ninja</h2>
	<hr />
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
		<div class="form-group">
			<form:label path="dojo">Dojo Name</form:label>
			<form:errors path="dojo"/>
			<form:select class="form-control" path="dojo">
			<c:forEach items="${ dojos }" var="dojo">
				<option value="${dojo.id }">${dojo.name }</option>
			</c:forEach>c:forEach>
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="firstName">First Name</form:label>
			<form:errors path="firstName"/>
			<form:input class="form-control" path="firstName"/>
		</div>
		<div class="form-group">
			<form:label path="lastName">Last Name</form:label>
			<form:errors path="lastName"/>
			<form:input class="form-control" path="lastName"/>
		</div>
		<div class="form-group">
			<form:label path="age">Age</form:label>
			<form:errors path="age"/>
			<form:input class="form-control" path="age"/>
		</div>
		<button>Add Ninja</button>
	</form:form>
</div>
</body>
</html>