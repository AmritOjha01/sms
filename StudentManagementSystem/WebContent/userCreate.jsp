<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/styles.css">
<link rel="stylesheet" type="text/css" href="resources/css/me.css">
<%@ include file="header.jsp"%>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div
				class="col-xs-12 col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 ">
				<div class="panel panel-default">
					<div class="panel-body">
						<form class="form-horizontal" role="form" action="UserController"
							method="post">
							<div class="form-group">
								<label class="control-label col-sm-3">User ID : </label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="userid"
										name="userid" value="${user.userId}" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">First Name : </label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="userfirstname"
										name="firstName" value="${user.firstName}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="pwd">Last
									Name : </label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="lastname"
										name="lastName" value="${user.lastName}">
								</div>
							</div>
							<c:if test="${user.userId == null}">
								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd">Username
										: </label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="username"
											name="username" value="${user.username}">
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3">Password : </label>
									<div class="col-sm-9">
										<input type="password" class="form-control" id="password"
											name="password" value="${user.password}">
									</div>
								</div>
							</c:if>
							<div class="form-group">
								<label class="control-label col-sm-3">Email : </label>
								<div class="col-sm-9">
									<input type="email" class="form-control" id="email"
										name="email" value="${user.email}">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">Date Of Birth: </label>
								<div class="col-sm-9">
									<input type="date" class="form-control" id="dateofbiths"
										name="dob"
										value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<center>
										<button type="submit" class="btn btn-primary"
											style="font-weight: bold;">Submit</button>
										<button type="reset" class="btn btn-danger"
											style="font-weight: bold;">Reset</button>
									</center>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="resources/js/jquery-2.2.0.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>