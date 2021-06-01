<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	<!--  Navigation Bar -->
	<div class="card">
		<h1>Dashboard</h1>
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
	
	<!--  Add Event -->
	<div class="card">
	<form:form action="/add" method="post" modelAttribute="event">
		<!--  Don't forget hidden input type for form:form -->
		<form:input type="hidden" path="planner" value="${user.id}"/>
		<div class="form-group">
			<form:label path="name">Event Name</form:label>
			<form:errors path="name"/>
			<form:input class="form-control" path="name"/>
		</div>
		<div class="form-group">
			<form:label path="eventDate">Date</form:label>
			<form:errors path="eventDate"/>
			<form:input type="date" class="form-control" path="eventDate"/>
		</div>
		<div class="form-group">
			<form:label path="city">City</form:label>
			<form:errors path="city"/>
			<form:input class="form-control" path="city"/>
		</div>
		<div class="form-group">
			<form:label path="state">State</form:label>
			<form:errors path="state"/>
			<form:select path="state">
				<c:forEach items="${ states }" var="state">
					<option value="${ state }">${ state }</option>
				</c:forEach>
			</form:select>
		</div>
		<button class="btn btn-primary">Create Event</button>
	</form:form>
	</div>
	
	<!--  Table of In State Events --> 
	<div class="card">
		<h2>In State Events</h2>
		<table class="table table-dark table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${InState}" var="event" varStatus="loop">
				<tr>
					<td><a href="events/${event.id}">${event.name}</a></td>
					<td><fmt:formatDate type="date" value="${event.eventDate}"/></td>
					<td>${event.city}</td>
					<td>${event.planner.firstName} ${event.planner.lastName}</td>
					<c:choose>
						<c:when test="${event.planner.equals(user)}">
							<td>
							<a href="/events/${event.id}/edit">Edit</a> 
							<form action ="/events/${event.id}/delete" method ="POST">
							<input class="btn btn-link" type="submit" value="Delete">
							</form>
							</td>	
						</c:when>
						<c:otherwise>
							<c:if test="${event.attendees.contains(user)}">
								<td>
								<form action ="/events/${event.id}/remove" method ="POST">
								<input class="btn btn-link" type="submit" value="Leave">
								</form>
								</td>
							</c:if>
							<c:if test="${!event.attendees.contains(user)}">
								<td>
								<form action ="/events/${event.id}/join" method ="POST">
								<input class="btn btn-link" type="submit" value="Join">
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
	
	<!--  Table of Out of State Events -->
	<div class="card">
		<h2>Out of State Events</h2>
		<table class="table table-dark table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>City</th>
					<th>State</th>
					<th>Host</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${OutState}" var="event" varStatus="loop">
				<tr>
					<td><a href="events/${event.id}">${event.name}</a></td>
					<td><fmt:formatDate type="date" value="${event.eventDate}"/></td>
					<td>${event.city}</td>
					<td>${event.state}</td>
					<td>${event.planner.firstName} ${event.planner.lastName}</td>
					<c:choose>
						<c:when test="${event.planner.equals(user)}">
							<td>
							<a href="/events/${event.id}/edit">Edit</a> 
							<form action ="/events/${event.id}/delete" method ="POST">
							<input class="btn btn-link" type="submit" value="Delete">
							</form>
							</td>	
						</c:when>
						<c:otherwise>
							<c:if test="${event.attendees.contains(user)}">
								<td>
								<form action ="/events/${event.id}/remove" method ="POST">
								<input class="btn btn-link" type="submit" value="Leave">
								</form>
								</td>
							</c:if>
							<c:if test="${!event.attendees.contains(user)}">
								<td>
								<form action ="/events/${event.id}/join" method ="POST">
								<input class="btn btn-link" type="submit" value="Join">
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