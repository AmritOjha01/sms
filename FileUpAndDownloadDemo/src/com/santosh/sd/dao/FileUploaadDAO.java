package com.santosh.sd.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.santosh.sd.dto.FileDTO;
import com.santosh.sd.util.DatabaseConnectionUtil;

public class FileUploaadDAO {

	public void saveFileInfo(FileDTO fileDto) {
		PreparedStatement ps = null;
		try {
			String sql = "insert into file_info(file_path,file_name)values(?,?)";
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setString(1, fileDto.getFilePath());
			ps.setString(2, fileDto.getFileName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<FileDTO> listFile() {
		List<FileDTO> list = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			String sql = "select * from file_info";
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FileDTO fileDTO = new FileDTO();
				fileDTO.setId(rs.getInt("id"));
				fileDTO.setFileName(rs.getString("file_name"));
				fileDTO.setFilePath(rs.getString("file_path"));
				list.add(fileDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public FileDTO getFileInfoById(int id) {
		FileDTO fileDTO = new FileDTO();
		PreparedStatement ps = null;
		try {
			String sql = "select * from file_info where id=?";
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fileDTO.setId(rs.getInt("id"));
				fileDTO.setFileName(rs.getString("file_name"));
				fileDTO.setFilePath(rs.getString("file_path"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fileDTO;
	}
}
