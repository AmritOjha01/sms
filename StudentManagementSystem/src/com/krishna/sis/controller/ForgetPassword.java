package com.krishna.sis.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krishna.sis.dto.UserDTO;
import com.krishna.sis.service.UserService;
import com.krishna.sis.service.UserServiceImpl;
import com.krishna.sis.util.EmailUtility;
import com.krishna.sis.util.ProjectUtil;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int randomInt;
	private static String passowrd;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgetPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService userService = new UserServiceImpl();
		UserDTO userDTO = userService.getPasswordByEmail(request.getParameter("email"));
		if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty()) {
			System.out.println("email not found");

		} else {
			passowrd = ProjectUtil.newPassword();
			userDTO.setPassword(passowrd);
			System.out.println(userDTO.getPassword());
			userService.updateUser(userDTO);
			EmailUtility.sendNewPassword(userDTO.getEmail(), passowrd);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}

	}

}
