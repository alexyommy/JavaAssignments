<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our Product</title>
</head>
<body>
<nav>
	<h3><a href="/">Go Back</a></h3>
</nav>
<h1><c:out value="${product.name}"/></h1>
<p><c:out value="${product.description}"/></p>
<p><c:out value="${product.price}"/></p>

<hr/>

<h3>Categories</h3>


<c:forEach var="added" items="${product.categories}">
	<c:out value="${added.name}"/>
</c:forEach>

<hr/>
<form action="/product/addCategory" method="post">
<input type="hidden" name="product_id" value=${product.id}>
<h3>Add Category</h3>
<select name="category_id" class="form-control">
<c:forEach var="category" items="${uniqueCategories}">
	<option value=${category.id}>${category.name}</option>
</c:forEach>
</select>
<button>Add Category</button>
</form>
</body>
</html>