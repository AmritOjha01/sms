<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Using POST Method to Send Form Data</title>
</head>
<body>
	<form action="postformread.jsp" method="POST">
		First Name: <input type="text" name="first_name"> <br> <br>
		Last Name: <input type="text" name="last_name" /> <br> <br>
		<input type="checkbox" name="maths" checked="checked" /> Maths <br>
		<br> <input type="checkbox" name="physics" /> Physics <br>
		<br> <input type="checkbox" name="chemistry" checked="checked" />Chemistry<br>
		<br> <input type="submit" value="Submit" />
	</form>
</body>
</html>