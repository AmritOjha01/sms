package com.santosh.servlet.dispatcher;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.println("<html>");
			pw.println("<body bgcolor=yellow>");
			String n = request.getParameter("name");
			String p = request.getParameter("pass");
			if (n.equals("java") && p.equals("java")) {
				RequestDispatcher rd = request.getRequestDispatcher("welcome");
				rd.forward(request, response);
			} else {
				pw.println("<font color=red>Invalid username or password</font><br><br>");
				RequestDispatcher rd = request
						.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			pw.println("</body></html>");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			pw.close();
		}
	}

}
