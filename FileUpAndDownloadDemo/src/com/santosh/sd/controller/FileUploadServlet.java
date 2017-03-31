package com.santosh.sd.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.santosh.sd.dao.FileUploaadDAO;
import com.santosh.sd.dto.FileDTO;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
maxFileSize = 1024 * 1024 * 50, // 50 MB
maxRequestSize = 1024 * 1024 * 100)
// 100 MB
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileUploaadDAO fileUploaadDAO = new FileUploaadDAO();

	/**
	 * Directory where uploaded files will be saved, its relative to the web
	 * application directory.
	 */
	private static final String UPLOAD_DIR = "fileupload";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// gets absolute path of the web application
		String applicationPath = "C:/Users/user/Desktop/stuff/";
		// constructs path of the directory to save uploaded file
		System.out.println("The file upload path is: " + applicationPath);
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

		// creates the save directory if it does not exists
		File fileSaveDir = new File(uploadFilePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
		String fileName = null;
		// Get all the parts from request and write it to the file on server
		for (Part part : request.getParts()) {
			fileName = getFileName(part);
			part.write(uploadFilePath + File.separator + fileName);
		}
		System.out.println("the path is: " + uploadFilePath);
		System.out.println("the file name is: " + fileName);
		FileDTO fileDto = new FileDTO();
		fileDto.setFileName(fileName);
		fileDto.setFilePath(uploadFilePath);
		fileUploaadDAO.saveFileInfo(fileDto);
		request.setAttribute("fileList", fileUploaadDAO.listFile());
		getServletContext().getRequestDispatcher("/download.jsp").forward(request, response);
	}

	/**
	 * Utility method to get file name from HTTP header content-disposition
	 */
	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}

}
