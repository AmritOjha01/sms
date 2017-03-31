<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/styles.css">
<link rel="stylesheet" type="text/css" href="resources/css/me.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<br>
	<br>
	<br>
	<br>
	<c:if test="${!empty users}">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-md-6 col-md-offset-3">
					<center>
						<h2
							style="text-shadow: 3px 2.5px 2.5px #FF8C00; color: #00008B; font-weight: bold;">Users
							List</h2>
					</center>
				</div>
				<a href="UserController?action=insert">
						<button class="btn btn-info navbar-btn" style="margin-left: 90%;">Add
							User</button>
					</a>
			</div>
		</div>
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>User id</th>
								<th>User Name</th>
								<th>Username</th>
								<th>DOB</th>
								<th>Email</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${users}" var="user">
								<tr>
									<td><c:out value="${user.userId }" /></td>
									<td><c:out value="${user.firstName }" /> <c:out
											value="${user.lastName }" /></td>
									<td><c:out value="${user.username}" /></td>
									<td><c:out value="${user.dob }" /></td>
									<td><c:out value="${user.email }" /></td>
									<td style="width: 175px;"><a
										href="UserController?action=edit&userid=<c:out value="${user.userId}"/>"
										class="btn btn-warning navbar-btn">Update</a> <a
										href="UserController?action=delete&userid=<c:out value="${user.userId}"/>"
										class="btn btn-danger navbar-btn">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</c:if>
	<script src="resources/js/jquery-2.2.0.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>