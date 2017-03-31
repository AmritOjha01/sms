package com.santosh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.santosh.dto.UserDTO;
import com.santosh.service.UserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LOGIN = "/login.jsp";
	private static String HOME = "/home.jsp";
	private UserService userService;

	public LoginController() {
		super();
		userService = new UserService();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		//getting user name and password from login.jsp page
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		//getting user name and password from database
		UserDTO user = userService.getUserByUserNameAndPassword(uname, pass);
		if (uname.equals(user.getUsername()) && pass.equals(user.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			forward = HOME;
		} else {
			forward = LOGIN;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

}
