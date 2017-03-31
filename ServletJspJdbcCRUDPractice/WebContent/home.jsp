<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("uname")%></title>
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
	<div class="row">
		<div class="container">
			<br>
			<div class="alert alert-success" style="width: 49.8%; float: left;">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<h3>Login successful !!!</h3>
			</div>
			<div class="alert alert-warning" style="width: 49.8%; float: right;">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<h3>
					Welcome
					<%=session.getAttribute("uname")%>
					!!!
				</h3>
			</div>
		</div>
	</div>
	<script src="resources/js/jquery-2.2.0.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>