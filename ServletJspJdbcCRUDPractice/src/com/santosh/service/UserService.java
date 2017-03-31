package com.santosh.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.santosh.dao.UserDao;
import com.santosh.dto.UserDTO;
import com.santosh.utils.DatabaseConnectionUtil;

/**
 * Service class for user domain.
 * 
 * @author Santosh
 * 
 */
public class UserService {
	private UserDao userDao = new UserDao();

	public boolean saveUser(UserDTO userDTO) {
		return userDao.saveUser(userDTO);
	}

	public boolean updateUser(UserDTO userDTO) {
		return userDao.updateUser(userDTO);
	}

	public List<UserDTO> getAllUsers() {
		return userDao.getAllUsers();
	}

	public UserDTO getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
	}

	public UserDTO getUserByUserNameAndPassword(String username, String password) {
		return userDao.getUserByUserNameAndPassword(username, password);
	}
}
