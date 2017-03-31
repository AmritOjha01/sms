package com.santosh.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieNextServlet")
public class CookieNextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Cookie[] ck = request.getCookies();
		if (ck.length == 0) {
			pw.println("No cookies was found.....");
		} else {
			for (int i = 0; i < ck.length; i++) {
				pw.println("Cookie Name= " + ck[i].getName());
				pw.println("Value= " + ck[i].getValue());
				pw.println("<br>");
			}
		}

	}

}
