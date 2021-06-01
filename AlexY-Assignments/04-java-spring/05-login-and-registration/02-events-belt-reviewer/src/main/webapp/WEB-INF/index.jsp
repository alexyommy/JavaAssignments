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
<title>Register | Login</title>
</head>
<body>
<div class="container">
	<div class="card">
	<form:form method="POST" action="/register"	modelAttribute="user">
		<h1>Register</h1>
		<p>
			<form:errors path="user.*" />
		</p>
		<table>
			<tr>
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:errors path="firstName"></form:errors></td>
				<td><form:input path="firstName" class="input" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name:</form:label></td>
				<td><form:errors path="lastName"></form:errors></td>
				<td><form:input path="lastName" class="input" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td><form:errors path="email"></form:errors></td>
				<td><form:input path="email" class="input" /></td>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
			    <td><form:errors path="city"/></td>
			    <td><form:input class="input" path="city" /></td>
		    </tr>
			<tr>
			    <td><form:label path="state">State</form:label></td>
			    <td><form:errors path="state"/></td>
				<td><form:select path="state">
				<c:forEach items="${ states }" var="state">
					<option value="${ state }">${ state }</option>
				</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:errors path="password"></form:errors></td>
				<td><form:input path="password"	type="password" class="input" /></td>
			</tr>
			<tr>
				<td><form:label path="passwordConfirmation">Confirm Password:</form:label></td>
				<td><form:errors path="passwordConfirmation"></form:errors></td>
				<td><form:input	path="passwordConfirmation" type="password" class="input" /></td>
			</tr>
		</table>
		<input type="submit" value="Register"/>
	</form:form>
	<div class="card">
		<h1>Login</h1>
		<p>
			<c:out value="${loginError}" />
		</p>
		<form method="post" action="/login">
			<table>
				<tr>
					<td><label for="lemail">Email</label></td>
					<td><input type="text" name="lemail" class="input" /></td>
				</tr>
				<tr>
					<td><label for="lpassword">Password</label></td>
					<td><input type="password" name="lpassword" class="input" /></td>
				</tr>
			</table>
			<input type="submit" value="Login"/>
		</form>
	</div>
	</div>
</div>
</body>
</html>