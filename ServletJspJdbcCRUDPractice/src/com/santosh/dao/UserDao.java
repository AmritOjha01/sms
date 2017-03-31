package com.santosh.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.santosh.dto.UserDTO;
import com.santosh.utils.DatabaseConnectionUtil;

/**
 * This is a data access object class for user domain.
 * 
 * @author Santosh
 * 
 */
public class UserDao {

	public boolean saveUser(UserDTO userDTO) {
		String query = "INSERT INTO users (first_name,last_name, email, dob, username, password) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		int savedUser = 0;
		try {
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(query);
			// ps.setNull(1, java.sql.Types.INTEGER);
			ps.setString(1, userDTO.getFirstName());
			ps.setString(2, userDTO.getLastName());
			ps.setString(3, userDTO.getEmail());
			ps.setDate(4, new java.sql.Date(userDTO.getDob().getTime()));
			ps.setString(5, userDTO.getUsername());
			ps.setString(6, userDTO.getPassword());
			savedUser = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DatabaseConnectionUtil.closeAll(ps);
		}
		if (savedUser >= 1) {
			return true;
		}
		return false;
	}

	public boolean updateUser(UserDTO userDTO) {
		String updateQuery = "UPDATE users SET first_name=?,last_name=?,email=?, dob=? where user_id=?";
		PreparedStatement ps = null;
		int uUpdated = 0;
		try {
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(
					updateQuery);
			ps.setString(1, userDTO.getFirstName());
			ps.setString(2, userDTO.getLastName());
			ps.setString(3, userDTO.getEmail());
			ps.setDate(4, new java.sql.Date(userDTO.getDob().getTime()));
			ps.setInt(5, userDTO.getUserId());
			uUpdated = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DatabaseConnectionUtil.closeAll(ps);
		}
		if (uUpdated >= 1) {
			return true;
		}
		return false;
	}

	public List<UserDTO> getAllUsers() {
		List<UserDTO> users = new ArrayList<UserDTO>();
		String listQuery = "SELECT * from users";
		PreparedStatement ps = null;
		try {
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(
					listQuery);
			ResultSet rs = ps.executeQuery(listQuery);
			while (rs.next()) {
				UserDTO userDTO = new UserDTO();
				userDTO.setUserId(rs.getInt("user_id"));
				userDTO.setFirstName(rs.getString("first_name"));
				userDTO.setLastName(rs.getString("last_name"));
				userDTO.setDob(rs.getDate("dob"));
				userDTO.setEmail(rs.getString("email"));
				userDTO.setUsername(rs.getString("username"));
				users.add(userDTO);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DatabaseConnectionUtil.closeAll(ps);
		}

		return users;
	}

	public UserDTO getUserById(int userId) {
		UserDTO user = new UserDTO();
		String getByIdQuery = "select * from users where user_id=?";
		PreparedStatement ps = null;
		try {
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(
					getByIdQuery);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DatabaseConnectionUtil.closeAll(ps);
		}
		return user;
	}

	public void deleteUser(int userId) {
		String deleteQuery = "DELETE from users where user_id=?";
		PreparedStatement ps = null;
		try {
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(
					deleteQuery);
			ps.setInt(1, userId);
			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DatabaseConnectionUtil.closeAll(ps);
		}
	}

	public UserDTO getUserByUserNameAndPassword(String username, String password) {
		UserDTO user = new UserDTO();
		String getByIdQuery = "select username, password from users where username=? and password=?";
		PreparedStatement ps = null;
		try {
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(
					getByIdQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DatabaseConnectionUtil.closeAll(ps);
		}
		return user;
	}
}
