<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Category</title>
</head>
<body>
<nav>
	<h3><a href="/">Go Back</a></h3>
</nav>
<h1>Create New Category</h1>
<form:form action="/categories/new" method="post" modelAttribute="category">
	<p>
	<form:label path="name">Category Name</form:label>
	<form:errors path="name"/>
	<form:input path="name" type="text"/>
	</p>
	
	<input type="submit" value="Create"/>
</form:form>
</body>
</html>