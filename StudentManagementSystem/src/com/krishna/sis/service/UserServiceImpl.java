package com.krishna.sis.service;

import java.util.List;

import com.krishna.sis.dao.UserDao;
import com.krishna.sis.dao.UserDaoImpl;
import com.krishna.sis.dto.UserDTO;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public boolean saveUser(UserDTO userDTO) {
		return userDao.saveUser(userDTO);
	}

	@Override
	public boolean updateUser(UserDTO userDTO) {
		return userDao.updateUser(userDTO);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public UserDTO getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);

	}

	@Override
	public UserDTO getUserByUserNameAndPassword(String username, String password) {
		return userDao.getUserByUserNameAndPassword(username, password);
	}

	@Override
	public UserDTO getPasswordByEmail(String email) {

		return userDao.getPasswordByEmail(email);
	}

	@Override
	public UserDTO getPasswordByPassword(String pwd) {

		return userDao.getPasswordByPassword(pwd);
	}

}
