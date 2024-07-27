package com.bluebricks.crudbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebricks.crudbackend.exception.UserNotFoundException;
import com.bluebricks.crudbackend.model.User;
import com.bluebricks.crudbackend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userDao;

	@Override
	public User addUser(User user) {
	 User savedUser = userDao.save(user);
		return savedUser;
	}

	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUser(Long userId) throws UserNotFoundException {
      return userDao.findById(userId).orElseThrow(()->new UserNotFoundException("No User data for ID " + userId + ". Please Enter Correct id"));
	}

	
	@Override
	public User updateUser(User newUser, Long id) throws UserNotFoundException {
		User user = getUser(id);
		user.setName(newUser.getName());
		user.setUsername(newUser.getUsername());
		user.setEmail(newUser.getEmail());
		user.setPhone(newUser.getPhone());
		userDao.save(user);
		return user;
	}

	@Override
	public String deleteUser(Long userId) throws UserNotFoundException {
		User user = getUser(userId);
		userDao.delete(user);
		return "User with ID: " + userId + " deleted Successfully";
	}

	@Override
	public User getUserByEmailAndPhone(String email, String phone) throws UserNotFoundException {
		Optional<User> optionalUser = userDao.findByEmailAndPhone(email, phone);
		 if(optionalUser.isPresent()) {
			  return  optionalUser.get();
		 }else {
			   throw new UserNotFoundException("User not found for email " + email + " and phone " + phone);
		 }
	}
	
	
	
}
