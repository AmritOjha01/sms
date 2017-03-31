package com.santosh.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String n = request.getParameter("name");
		String p = request.getParameter("pass");
		pw.println("Welcome " + n);
		Cookie ck1 = new Cookie("ck1", n);
		Cookie ck2 = new Cookie("ck2", p);
		ck1.setMaxAge(100);
		ck2.setMaxAge(100);
		response.addCookie(ck1);
		response.addCookie(ck2);
		response.setContentType("text/html");
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<a href=CookieNextServlet> Next</a>");
		pw.println("</body></html>");
	}
}
