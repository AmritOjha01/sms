<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Using JavaBeans in JSP</title>
</head>
<body>
	<center>
		<h2>Using JavaBeans in JSP</h2>
		<jsp:useBean id="test" class="action.TestBean" />
		<p>Got message....</p>
		<jsp:getProperty name="test"   property="message" /><br>
		<jsp:setProperty name="test" property="message" value="hiiiiiiii"/>
		<jsp:getProperty name="test" property="message" />
	</center>
</body>
</html>