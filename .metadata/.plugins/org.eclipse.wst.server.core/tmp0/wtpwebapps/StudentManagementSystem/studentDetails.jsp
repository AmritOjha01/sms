<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/styles.css">
<link rel="stylesheet" type="text/css" href="resources/css/me.css">
<%@ include file="header.jsp"%>
</head>
<body>
	<h1>Student Details</h1>
	<a href="StudentController?actions=add">Add New</a>
	<c:if test="${!empty students}">
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Student Name</th>
					<th>College Name</th>
					<th>Roll</th>
					<th>DOB</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Subject</th>
					<th>Departments</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<td><c:out value="${student.id }"></c:out></td>
						<td><c:out value="${student.studentName }"></c:out></td>
						<td><c:out value="${student.collegeName }"></c:out></td>
						<td><c:out value="${student.roll }"></c:out></td>
						<td><c:out value="${student.dob }"></c:out></td>
						<td><c:out value="${student.email }"></c:out></td>
						<td><c:out value="${student.gender }"></c:out></td>
						<td><c:out value="${student.subject }"></c:out></td>
						<td><c:out value="${student.departments}"></c:out></td>
						<td><img src="ImageDisplayServlet?id=${student.id}"
							height="50px" width="50px" alt="ProfilePic"></td>
						<td><a
							href="StudentController?actions=edit&id=<c:out value="${student.id }"/>">Edit</a>||
							<a
							href="StudentController?actions=delete&id=<c:out value="${student.id }"/>">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>
</body>
</html>