<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddUser</title>
</head>
<body>

<h2> Crud </h2>

<a style="color:white;" href="/adduser">
	<button>AddUser</button>&nbsp
</a>

<button>getUser</button>

<sec:authorize access="hasRole('ADMIN')">
	<a style="color:white;" href="/adduser">
		<button>UpdateUser</button>&nbsp
	</a>
</sec:authorize>

<a href="/deleteuser">
	<sec:authorize access="hasRole('ADMIN')">
		<button>DeleteUser</button>&nbsp
	</sec:authorize>
</a>

<br><br>

</body>
</html>