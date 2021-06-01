<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Details</title>
</head>
<body>
<nav>
	<h3><a href="/">Go Back</a></h3>
</nav>
<h1>${category.name}</h1>
<c:if test="${empty products}">
	No products have been added
</c:if>
<c:if test="${not empty products}">
	<c:forEach var="added" items="${products}">
		<c:out value="${added.name}"/>
		<c:out value="${added.description}"/>
		<c:out value="${added.price}"/>
	</c:forEach>
</c:if>
<hr/>
<form action="/category/addProduct" method="post">
<input type="hidden" name="category_id" value=${category.id}>
<h3>Add Product</h3>
<select name="product_id" class="form-control">
<c:forEach var="product" items="${unAdded }">
	<option value=${product.id}>${product.name}</option>
</c:forEach>
</select>
<button>Add Product</button>
</form>

</body>
</html>