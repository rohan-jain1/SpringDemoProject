<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>DeleteUser</title>
<script>
function sendDelete() {
	var userid=parseInt(document.getElementById("deleteinput").value);
	console.log("delete:: " + userid);

	$.ajax({
		url: 'deleteuser',
		method: 'delete',
		data : {
			id : userid
		},
		success: function() {
			console.log("deleted!");
			$('#message').html("successfully deleted user: " + userid);
		}
	});

	
}

</script>
<script type="text/javascript" src="webjars/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<h2> AddUser </h2>

<!-- 
<form:form method="DELETE" action="user">
	<table>
		<tr>
			<label for="id">id:</label>
			<input type="text" name="id">
		</tr>
	

		<tr>			
			<td>
				<input type="submit"/>
			</td>
			
		</tr>
	</table>
</form:form>

<br><br><br>

<form method="DELETE" action="user">
	<label for="id">id:</label>
	<input type="text" name="id">
	<br><br>
	<input type="submit" value="delete"/>
</form>

 -->


<input type="number" id="deleteinput" type="text" />
<button onclick="sendDelete()">SendDelete</button>

<div id="message" >hi</div>

</body>
</html>