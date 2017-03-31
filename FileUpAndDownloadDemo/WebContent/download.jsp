<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FileUploadServlet" method="post"
		enctype="multipart/form-data">
		<label>Select File : </label>
		<div class="col-sm-9">
			<input type="file"  name="fileName">
		</div>
		<button type="submit" style="font-weight: bold;">Upload</button>
	</form>
	<br><br>
	<c:if test="${!empty fileList}">
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>File Name</th>
					<th>File Path</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${fileList}" var="file">
					<tr>
						<td><c:out value="${file.id }" /></td>
						<td><c:out value="${file.fileName }" /> <c:out
								value="${file.filePath }" /></td>
						<td style="width: 175px;"><a
							href="/FileUpAndDownloadDemo/DownLoadServlet?fileName=<c:out value="${file.id}"/>">Download</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>