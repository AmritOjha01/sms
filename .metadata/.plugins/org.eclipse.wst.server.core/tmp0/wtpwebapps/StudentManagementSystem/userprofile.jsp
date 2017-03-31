<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/styles.css">
 <link rel="stylesheet" type="text/css"
	href="resources/customcss/demo.css">
	<%@ include file="header.jsp"%>
</head>
<body>
<div class = "baskg">
	<div class = "text"><h1>
		<b>User Profile</b>
	</h1></div>
	
	<div class="tbl">
		<table class="table table-striped">
			<tr>
				<td><h2>Id</h2></td>
				<td><c:out value="${user.userId }" /></td>
			</tr>
			<tr>
				<td><h2>First Name</h2></td>
				<td><c:out value="${user.firstName }" /></td>
			</tr>
			<tr>
				<td><h2>Last name</h2></td>
				<td><c:out value="${user.lastName }" /></td>
			</tr>

			<tr>
				<td><h2>Username</h2></td>
				<td><c:out value="${user.username}" /></td>
			</tr>

			<tr>
				<td><h2>DOB</h2></td>
				<td><c:out value="${user.dob }" /></td>
			</tr>
			<tr>
				<td><h2>Email</h2></td>
				<td><c:out value="${user.email }" /></td>
			</tr>

		</table>
	</div>

</div>
</body>
</html>