<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Application</title>
		<link rel="stylesheet" href="resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="resources/css/styles.css">
		<link rel="stylesheet" type="resources/text/css" href="css/me.css">
	</head>
<body>
		<div class="container" style="margin-top:9%">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 ">
					<div class="panel panel-default">
						<div class="panel-body">
						<div>
							<center>
								<img src="resources/image/download.png">
								<h2 style="text-shadow: 3px 2.5px 2.5px #FF8C00;color:#00008B;font-weight: bold;">Admin <font style="color: green;">Login</font></h2><br>
								<p style="color: red;font-weight: bold;">
								</p>
							</center>
						</div>
							<form class="form-horizontal" role="form" action="LoginController" method="post">
							  <div class="form-group">
							    <label class="control-label col-sm-3" for="username">Username : </label>
							    <div class="col-sm-9">
							      <input type="text" class="form-control" id="username" placeholder="Enter Username" name="uname">
							    </div>
							  </div>
							  <div class="form-group">
							    <label class="control-label col-sm-3" for="pwd">Password : </label>
							    <div class="col-sm-9"> 
							      <input type="password" class="form-control" id="password" placeholder="Enter password" name="pass">
							    </div>
							  </div>
							  <div class="form-group"> 
							    <div cl	ass="col-sm-offset-3 col-sm-9">
							      <center><button type="submit" class="btn btn-primary" style="font-weight: bold;">Login</button></center>
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