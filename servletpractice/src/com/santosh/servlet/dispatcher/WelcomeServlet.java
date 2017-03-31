package com.santosh.servlet.dispatcher;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.println("<html>");
			pw.println("<body bgcolor=yellow>");
			String n = request.getParameter("name");
			pw.println("<body bgcolor=yellow>");
			pw.println("Welcome: " + n);
			pw.println("<br>");
			pw.println("site is under construction......");
			pw.println("</body></html>");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			pw.close();
		}
	}
}
