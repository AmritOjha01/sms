package com.krishna.sis.service;

import java.util.List;

import com.krishna.sis.dto.UserDTO;

public interface UserService {
	public boolean saveUser(UserDTO userDTO);

	public boolean updateUser(UserDTO userDTO);

	public List<UserDTO> getAllUsers();

	public UserDTO getUserById(int userId);

	public void deleteUser(int userId);

	public UserDTO getUserByUserNameAndPassword(String username, String password);
	
	public UserDTO getPasswordByEmail(String email);
	
	public UserDTO getPasswordByPassword(String pwd);
}
