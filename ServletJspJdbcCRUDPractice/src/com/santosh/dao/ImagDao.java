package com.santosh.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.santosh.dto.ImageDTO;
import com.santosh.utils.DatabaseConnectionUtil;

public class ImagDao {
	private Connection conn;
	private PreparedStatement statement;

	public String uploadImage(InputStream inputStream, ImageDTO imageDTO) {
		String message = null; // message will be sent back to client
		try {
			conn = DatabaseConnectionUtil.getConnection();
			String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, imageDTO.getFirstName());
			statement.setString(2, imageDTO.getLastName());

			if (inputStream != null) {
				// fetches input stream of the upload file for the blob column
				statement.setBlob(3, inputStream);
			}

			int row = statement.executeUpdate();
			if (row > 0) {
				message = "Image is uploaded successfully into the Database";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			message = "ERROR: " + ex.getMessage();
			ex.printStackTrace();
		}
		return message;
	}

	public List<ImageDTO> getImageList() {
		List<ImageDTO> imageList = new ArrayList<>();
		try {
			conn = DatabaseConnectionUtil.getConnection();
			String sql = "select * from contacts";
			statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ImageDTO imageDTO = new ImageDTO();
				imageDTO.setContactId(rs.getInt("contact_id"));
				imageDTO.setFirstName(rs.getString("first_name"));
				imageDTO.setLastName(rs.getString("last_name"));
				imageDTO.setPhoto(rs.getBlob("photo"));
				imageList.add(imageDTO);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return imageList;
	}
}
