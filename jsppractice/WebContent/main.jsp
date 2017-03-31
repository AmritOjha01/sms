<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The include Action Example</title>
</head>
<body>
	<center>
		<h2>The include action Example</h2>
		<jsp:include page="date.jsp" flush="true" />
		<%-- <jsp:forward page="date.jsp" /> --%>
	</center>
</body>
</html>