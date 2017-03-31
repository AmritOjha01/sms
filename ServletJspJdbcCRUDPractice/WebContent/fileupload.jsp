<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<div class="container" style="margin-top: 9%">
		<div class="row">
			<div
				class="col-xs-12 col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 ">
				<div class="panel panel-default">
					<div class="panel-body">
						<form class="form-horizontal" role="form"
							action="FileUploadServlet" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<label class="control-label col-sm-3" for="pwd">Select
									File : </label>
								<div class="col-sm-9">
									<input type="file" class="form-control" id="password"
										placeholder="Please select files" name="fileName">
								</div>
							</div>
							<div class="form-group">
								<div cl ass="col-sm-offset-3 col-sm-9">
									<center>
										<button type="submit" class="btn btn-primary"
											style="font-weight: bold;">Upload</button>
									</center>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="container">
			<br>
			<div class="alert alert-success">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<center>
					<h3>
						<h2>${requestScope.message}</h2>
					</h3>
				</center>
			</div>
		</div>
	</div>
	<script src="resources/js/jquery-2.2.0.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>