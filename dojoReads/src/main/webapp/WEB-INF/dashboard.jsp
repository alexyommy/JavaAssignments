<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
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
	<div class="card">
	<form:form action="/add" method="post" modelAttribute="review">
		<!--  Don't forget hidden input type for form:form -->
		<form:input type="hidden" path="reviewer" value="${user.id}"/>
		<div class="form-group">
			<form:label path="name">Book Title</form:label>
			<form:errors path="name"/>
			<form:input class="form-control" path="name"/>
		</div>
		<div class="form-group">
			<form:label path="author">Author</form:label>
			<form:errors path="author"/>
			<form:input class="form-control" path="author"/>
		</div>
		<div class="form-group">
			<form:label path="description">Review</form:label>
			<form:errors path="description"/>
			<form:input class="form-control" path="description"/>
		</div>
		<div class="form-group">
			<form:label path="rating">Rating: </form:label>
			<form:errors path="rating"/>
			<form:select path="rating">
				<option value='1'>1</option>
				<option value='2'>2</option>
				<option value='3'>3</option>
				<option value='4'>4</option>
				<option value='5'>5</option>
			</form:select>
		</div>
		<button class="btn btn-primary">Add Book and Review</button>
	</form:form>
	</div>
	<div class="card">
		<h2>In State Events</h2>
		<table class="table table-dark table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Author</th>
					<th>Review</th>
					<th>Rating</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${reviews}" var="review" varStatus="loop">
				<tr>
					<td><a href="review/${review.id}">${review.name}</a></td>
					<td>${review.author}</td>
					<td>${review.description}</td>
					<td>${review.rating}</td>
					<c:choose>
						<c:when test="${review.reviewer.equals(user)}">
							<td>
							<a href="/reviews/${review.id}/edit">Edit</a> 
							<form action ="/reviews/${review.id}/delete" method ="POST">
							<input class="btn btn-link" type="submit" value="Delete">
							</form>
							</td>	
						</c:when>
						<c:otherwise>
							<c:if test="${review.critics.contains(user)}">
								<td>
								<form action ="/events/${event.id}/remove" method ="POST">
								<input class="btn btn-link" type="submit" value="Remove Rating">
								</form>
								</td>
							</c:if>
							<c:if test="${!review.critics.contains(user)}">
								<td>
								<form action ="/events/${event.id}/addrating" method ="POST">
								<input class="btn btn-link" type="submit" value="Add Rating">
								</form>
								</td>
							</c:if>
						</c:otherwise>
					</c:choose> 
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>	
</body>
</html>