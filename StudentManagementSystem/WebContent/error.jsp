<%@ page isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>ServerError</title>
<%@ include file="header.jsp"%>
</head>
<body bgcolor="white">
	<ul>
		<li>Exception: <c:out
				value="${requestScope['javax.servlet.error.exception']}" /></li>
		<li>Request URI: <c:out
				value="${requestScope['javax.servlet.error.request_uri']}" /></li>
		<li>Servlet name: <c:out
				value="${requestScope['javax.servlet.error.servlet_name']}" /></li>
		<li>Status code: <c:out
				value="${requestScope['javax.servlet.error.status_code']}" /></li>
	</ul>
</body>
</html>