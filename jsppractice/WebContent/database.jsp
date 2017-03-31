<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<p>Today is weekend</p>
	<%@ page import="java.sql.*" session="false" errorPage="error.jsp"%>

	<%!PreparedStatement pst;
	Connection con;
	String sql;

	public void jspInit() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection(
					"jdbc:mysql://localhost/servlet_jsp_jdbc_crud", "root",
					"root");
			sql="select * from employee where name=? and pass=?";
			System.out.println("helllo"+sql);
			pst = con
					.prepareStatement(sql);
			
		} catch (Exception ex) {
			System.out.println("helllo");
		}
	}

	public void jspDestroy() {
		try {
			con.close();
		} catch (Exception ex) {

		}
	}%>
	<p>Today is weekend</p>
	<%
		String n = request.getParameter("name");
	    System.out.println("name "+n);
		out.println("Welcome ............" + n);
		String p = request.getParameter("pass");
		System.out.println("pass "+p);
		pst.setString(1, n);
		pst.setString(2, p);
		System.out.println("helllo"+sql);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
	%>
	<p>Today is weekend</p>
	<%
		} else {
			out.println("<font color=red>invalid</font>");
	%>
<%-- 	<%@ include file="index.html"%> --%>
	<%
		}
	%>
</body>
</html>