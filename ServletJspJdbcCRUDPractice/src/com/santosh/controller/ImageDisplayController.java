package com.santosh.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.santosh.utils.DatabaseConnectionUtil;

@WebServlet("/DisplayServlet")
public class ImageDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String imageId = request.getParameter("id");
		System.out.println(imageId);
		InputStream sImage;
		// Check if ID is supplied to the request.
		if (imageId == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
			return;
		}

		try {
			conn = DatabaseConnectionUtil.getConnection();
			stmt = conn
					.prepareStatement("select * from contacts where contact_id="
							+ imageId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("Inside RS");
				byte[] bytearray = new byte[1048576];
				int size = 0;
				sImage = rs.getBinaryStream(4);
				response.reset();
				response.setContentType("image/jpeg");
				while ((size = sImage.read(bytearray)) != -1) {
					response.getOutputStream().write(bytearray, 0, size);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
