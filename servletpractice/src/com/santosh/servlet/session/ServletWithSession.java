package com.santosh.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(description = "session servlet", urlPatterns = { "/ServletWithSession" })
public class ServletWithSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	String str = "";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		if (name != null && name != "") {
//			str = name;
			session.setAttribute("nameFrmSession", name);
		}
		pw.println("From request parameter " + name);
		pw.println("<br>");
//		pw.println("From string " + str);
		pw.println("<br>");
		pw.println("From session parameter "
				+ (String) session.getAttribute("nameFrmSession"));

	}

}
