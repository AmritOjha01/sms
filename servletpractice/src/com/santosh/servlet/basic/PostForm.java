package com.santosh.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/postform")
public class PostForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PostForm() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + request.getParameter("fName") + "</h1>");
		out.println("<h1>" + request.getParameter("lName") + "</h1>");
		out.println("<h1>" + request.getParameter("dob") + "</h1>");
		out.println("<h1>" + request.getParameter("age") + "</h1>");
		out.println("<h1>" + request.getParameter("gender") + "</h1>");
		out.println("<h1>" + request.getParameter("deparments") + "</h1>");
		out.println("<h1>" + request.getParameter("sCombo") + "</h1>");
	}

}
