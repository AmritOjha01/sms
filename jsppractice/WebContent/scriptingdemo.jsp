<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<!-- This is declaration -->
	<%!int i = 10;%>
	<!-- This is Scriptlet -->
	<%
		out.println("i is: " + i);
	%>
	<br>
	<%-- This is expression --%>
	Value of I:
	<input type="text" value="<%=i%>">
	<p>
		Today's date:
		<%=(new java.util.Date()).toLocaleString()%>
	</p>
</body>
</html>