<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey</title>
</head>
<body>
	<h1>Dojo Survey</h1>
	<hr />
	<form action="/survey" method="post">
		<div class="form-group">
			<label for = "name">Your Name</label>
			<input type = "text" name="name" id="name" />
		</div>
		<div class="form-group">
			<label for = "location">Dojo location</label>
			<select name = "location" id = "location">
			<c:forEach items="${ locations }" var="loc">
				<option value="<c:out value='${ loc }'/>"><c:out value='${ loc }'/></option>
			</c:forEach>
			</select>
		</div>
		<div class = "form-group">
			<label for = "languages">Dojo location</label>
			<select name = "language" id = "language">
			<c:forEach items="${ languages }" var="lang">
				<option value="<c:out value='${ lang }'/>"><c:out value='${ lang }'/></option>
			</c:forEach>
			</select>
		</div>
		<div class = "form-group">
			<label for = "comment">Comment</label>
			<textarea name="comment" id="id" rows="10" cols="30"></textarea>
		</div>
		<button>Submit</button>
	</form>
</body>
</html>