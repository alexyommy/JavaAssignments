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
<title>Products and Categories</title>
</head>
<body>
<div class="container">
	<nav>
		<h3><a href="/products/new">Add New Product</a></h3>
		<h3><a href="/categories/new">Add New Category</a></h3>
	</nav>
	<h2>Products</h2>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${products}" var="product" varStatus="loop">
			<tr>
				<td><a href="/product/${product.id}">${product.name}</a></td>
				<td>${product.description}</td>
				<td>$ ${product.price}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<hr/>
	<h2>Categories</h2>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Category ID</th>
				<th>Category Name</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${categories}" var="category" varStatus="loop">
			<tr>
				<td><a href="/category/${category.id}">${category.id}</a></td>
				<td>${category.name}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>