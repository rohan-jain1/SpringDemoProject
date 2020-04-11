<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateUser</title>
</head>
<body>


<h2> UpdateUser </h2>

<h2 > ${message}</h2>

<form:form modelAttribute="user" method="POST" action="updateusercontroller">
	<table>
		<tr>
			<td>
				<form:label path="name">Name</form:label>
			</td>
			<td>
				<form:input path="name"/>
			</td>
		</tr>
	
		<tr>
			<td>
				<form:label path="email">Email</form:label>
			</td>
			<td>
				<form:input path="email"/>
			</td>
		</tr>

		<tr>			
			<td>
				<form:label path="age">Age</form:label>
			</td>
			<td>
				<form:input path="age"/>
			</td>
		</tr>

		<tr>			
			<td>
				<form:label path="gender">gender</form:label>
			</td>
			<td>
				Male<form:radiobutton path="gender" value="Male"/> &nbsp
				Female<form:radiobutton path="gender" value="Female"/> &nbsp
				Custom<form:radiobutton path="gender" value="Custom"/> &nbsp
				
			</td>
		</tr>

		<tr>			
			<td>
				<form:label path="phoneno">Phoneno</form:label>
			</td>
			<td>
				<form:input path="phoneno"/>
			</td>
		</tr>

		<tr>			
			<td>
				<form:label type="password" path="password">Password</form:label>
			</td>
			<td>
				<form:input type="password" path="password"/>
			</td>
		</tr>
		<tr>			
			<td>
				<input type="submit"/>
			</td>
			
		</tr>
	</table>
</form:form>

</body>
</html>