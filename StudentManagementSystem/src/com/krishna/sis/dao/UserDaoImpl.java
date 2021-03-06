package com.krishna.sis.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.krishna.sis.dto.UserDTO;
import com.krishna.sis.util.DbUtil;
import com.krishna.sis.util.QueryUtil;

public class UserDaoImpl implements UserDao {
	public boolean saveUser(UserDTO userDTO) {
		PreparedStatement ps = null;
		int savedUser = 0;
		try {
			ps = DbUtil.getConnection().prepareStatement(QueryUtil.CREATE_USER);
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
			DbUtil.closeAll(ps);
		}
		if (savedUser >= 1) {
			return true;
		}
		return false;
	}

	public boolean updateUser(UserDTO userDTO) {
		PreparedStatement ps = null;
		int uUpdated = 0;
		try {
			ps = DbUtil.getConnection().prepareStatement(QueryUtil.UPDATE_USER);
			ps.setString(1, userDTO.getFirstName());
			ps.setString(2, userDTO.getLastName());
			ps.setString(3, userDTO.getEmail());
			ps.setDate(4, new java.sql.Date(userDTO.getDob().getTime()));
			ps.setString(5, userDTO.getPassword());
			ps.setInt(6, userDTO.getUserId());
			uUpdated = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DbUtil.closeAll(ps);
		}
		if (uUpdated >= 1) {
			return true;
		}
		return false;
	}

	public List<UserDTO> getAllUsers() {
		List<UserDTO> users = new ArrayList<UserDTO>();
		PreparedStatement ps = null;
		try {
			ps = DbUtil.getConnection().prepareStatement(QueryUtil.GET_ALL_USER);
			ResultSet rs = ps.executeQuery();
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
			DbUtil.closeAll(ps);
		}

		return users;
	}

	public UserDTO getUserById(int userId) {
		UserDTO user = new UserDTO();
		PreparedStatement ps = null;
		try {
			ps = DbUtil.getConnection().prepareStatement(QueryUtil.GET_USER_BY_ID);
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
			DbUtil.closeAll(ps);
		}
		return user;
	}

	public void deleteUser(int userId) {
		PreparedStatement ps = null;
		try {
			ps = DbUtil.getConnection().prepareStatement(QueryUtil.DELETE_USER);
			ps.setInt(1, userId);
			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DbUtil.closeAll(ps);
		}
	}

	public UserDTO getUserByUserNameAndPassword(String username, String password) {
		UserDTO user = new UserDTO();
		PreparedStatement ps = null;
		try {
			ps = DbUtil.getConnection().prepareStatement(QueryUtil.GET_USER_BY_USERNAME_AND_PASSWORD);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DbUtil.closeAll(ps);
		}
		return user;
	}

	@Override
	public UserDTO getPasswordByEmail(String email) {
		UserDTO user = new UserDTO();
		PreparedStatement ps = null;
		try {
			ps = DbUtil.getConnection().prepareStatement(QueryUtil.GET_BY_EMAIL);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DbUtil.closeAll(ps);
		}
		return user;
	}

	@Override
	public UserDTO getPasswordByPassword(String pwd) {

		UserDTO user = new UserDTO();
		PreparedStatement ps = null;
		try {
			ps = DbUtil.getConnection().prepareStatement(QueryUtil.GET_PASSWORD_BY_PASSWORD);
			ps.setString(1, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DbUtil.closeAll(ps);
		}
		return user;
	}
}
