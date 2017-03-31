<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
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
	<h3><%=request.getAttribute("Message")%></h3>
	<img src="DisplayServlet?id=1" height="150px" width="150px"
		alt="ProfilePic">
	<c:if test="${!empty images}">
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Photo</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${images}" var="image">
								<tr>
									<td><c:out value="${image.contactId }" /></td>
									<td><c:out value="${image.firstName }" /></td>
									<td><c:out value="${image.lastName }" /></td>
									<td><c:out value="${image.photo}" /></td>
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