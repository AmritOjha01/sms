package com.krishna.sis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.krishna.sis.dto.UserDTO;
import com.krishna.sis.service.UserService;
import com.krishna.sis.service.UserServiceImpl;
import com.krishna.sis.util.EmailUtility;
import com.krishna.sis.util.ProjectUtil;

/**
 * Servlet implementation class ResetUserPassword
 */
@WebServlet("/ResetUserPasswordController")
public class ResetUserPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	UserDTO userDTO = new UserDTO();
//	private static String passowrd1;
//	private static String passowrd2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetUserPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("pwd");
		userDTO = userService.getPasswordByPassword(password);
		if (userDTO.getPassword() != null) {

			RequestDispatcher rd = request.getRequestDispatcher("setNewUserPwd.jsp");
			rd.forward(request, response);
		} else {
			 request.setAttribute("errorMessage", "Invalid password....try again");
			RequestDispatcher rd = request.getRequestDispatcher("previousUserPassword.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService userService = new UserServiceImpl();
		 String password1 = request.getParameter("p1");
		String password2 = request.getParameter("p2");
		
		if (password1.equals(password2)) {

			userDTO.setPassword(password1);
			System.out.printf("password set");
			userService.updateUser(userDTO);
			System.out.println("passwrd updated");
			EmailUtility.sendNewPassword(userDTO.getEmail(), password1);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.include(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("setNewUserPwd.jsp");
			rd.include(request, response);
			System.out.println("passwrd not confirmed");
		}
	}

}
