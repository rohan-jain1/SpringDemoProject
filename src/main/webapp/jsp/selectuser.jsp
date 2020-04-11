<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>SelectUser</title>
<script type="text/javascript" src="webjars/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<h2> Choose UserId for Update </h2>
 
<form method="POST" action="updateuser">
	<label for="id">id:</label>
	<input type="text" name="id">
	<br><br>
	<input type="submit"/>
</form>

<div id="message" ></div>

</body>
</html>