package com.santosh.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.santosh.dao.ImagDao;
import com.santosh.dto.ImageDTO;

@WebServlet("/imageUpload")
@MultipartConfig(maxFileSize = 16177215)
// upload file up to 16MB
public class ImageUploadController extends HttpServlet {
	private static final long serialVersionUID = -1623656324694499109L;
	ImagDao imageDao = new ImagDao();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		InputStream inputStream = null;
		ImageDTO imageDTO = null;

		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("photo");
		if (filePart != null) {
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
		}
		imageDTO = new ImageDTO();
		imageDTO.setFirstName(request.getParameter("firstName"));
		imageDTO.setLastName(request.getParameter("lastName"));
		String message = imageDao.uploadImage(inputStream, imageDTO);
		// sets the message in request scope
		request.setAttribute("Message", message);
		request.setAttribute("images", imageDao.getImageList());

		// forwards to the message page
		getServletContext().getRequestDispatcher("/imagesubmit.jsp").forward(
				request, response);
	}
}
