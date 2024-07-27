package com.bluebricks.crudbackend.services;

import java.util.List;

import com.bluebricks.crudbackend.exception.UserNotFoundException;
import com.bluebricks.crudbackend.model.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public User addUser(User user);

	public User getUser(Long userId) throws UserNotFoundException;

	public User updateUser(User user, Long id) throws UserNotFoundException;

	public String deleteUser(Long userId) throws UserNotFoundException;
	
	public User getUserByEmailAndPhone(String email, String phone) throws UserNotFoundException ;
}
