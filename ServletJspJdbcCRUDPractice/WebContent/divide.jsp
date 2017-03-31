<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="error.jsp"%>
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
	<br><br><br><br>
	<div class="row">
		<div class="container">
			<br>
			<div class="alert alert-success">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<center><h3>
				<%
					String num1 = request.getParameter("n1");
					String num2 = request.getParameter("n2");
			
					int a = Integer.parseInt(num1);
					int b = Integer.parseInt(num2);
					int c = a / b;
					out.print("division of numbers is: " + c);
				%>
				</h3></center>
			</div>
		</div>
	</div>	
	<script src="resources/js/jquery-2.2.0.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>