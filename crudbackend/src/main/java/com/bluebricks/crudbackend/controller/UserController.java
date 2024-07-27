package com.bluebricks.crudbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebricks.crudbackend.exception.UserNotFoundException;
import com.bluebricks.crudbackend.model.User;
import com.bluebricks.crudbackend.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService ;

	@Value("${server.port}")
	private String portNumber ;

	@GetMapping("/test")
	public String hello(){
		return "Welcome to Spring boot CRUD App running on Port " + portNumber ;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = userService.getUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
    
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User savedUser = userService.addUser(user) ;
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable  String userId) throws UserNotFoundException, NumberFormatException {
		User user = userService.getUser(stringToLong(userId)) ;
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<User>  updateUser(@RequestBody User user,@PathVariable String userId) throws NumberFormatException, UserNotFoundException {
	  User newUser = userService.updateUser(user,stringToLong(userId)) ;
	  return new ResponseEntity<>(newUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId) throws NumberFormatException, UserNotFoundException {
		String message = userService.deleteUser(stringToLong(userId));
		return new ResponseEntity<>(message,HttpStatus.OK);
	} 
	
	@GetMapping("/user/{email}/{phone}")
	public ResponseEntity<User> getUserByEmailAndPhone(@PathVariable String email, @PathVariable String phone) throws UserNotFoundException{
		return new ResponseEntity<>( userService.getUserByEmailAndPhone(email,phone),HttpStatus.OK); 
	}
	
	public Long stringToLong(String userId) throws NumberFormatException {
	    try {
	        return Long.parseLong(userId);
	    } catch (NumberFormatException e) {
	        throw new NumberFormatException("Invalid user ID format: " + userId);
	    }
	}
	
	
}
