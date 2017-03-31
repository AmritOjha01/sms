package com.santosh.servlet.context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/next")
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		try {
			ServletConfig cfg = this.getServletConfig();
			ServletContext ctx = cfg.getServletContext();
			String st = ctx.getInitParameter("color");
			String av = (String) ctx.getAttribute("att");
			pw = response.getWriter();
			pw.println("<html>");
			pw.println("<body bgcolor = " + st + ">");
			pw.println("This is context servlet......");
			pw.println("<br>");
			pw.println("Config of ContextServlet: " + cfg);
			pw.println("<br>");
			pw.println("Context of ContextServlet: " + ctx);
			pw.println("<br>");
			pw.println("Context from ContextServlet: " + av);
			pw.println("</body></html>");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			pw.close();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
