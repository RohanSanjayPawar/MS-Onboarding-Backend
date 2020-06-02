package com.ms.au.onboarding_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.au.onboarding_portal.dao.impl.UserDAOImpl;
import com.ms.au.onboarding_portal.model.User;

/**
 * The Class UserController.
 * 
 * @author Rohan Pawar
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	/** The dao. */
	@Autowired
	public UserDAOImpl userDAO;

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@GetMapping("/")
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	
	/**
	 * Gets the user with uid.
	 *
	 * @param uid the uid
	 * @return the user with uid
	 */
	@GetMapping("/{email}")
	public List<User> getUserWithUid(@PathVariable(name="email") String email) {
		return userDAO.getUserForEmail(email);
	}
	
	/**
	 * Validate user.
	 *
	 * @param authorizationHeader the authorization header
	 * @return the list
	 */
	@GetMapping("/login")
	public List<User> validateUser(@RequestHeader(value="Authorization") String authorizationHeader) {
		return userDAO.loginUser(authorizationHeader);
	}
	
	@PutMapping("/add")
	public User addUser(@RequestBody User user) {
		List<User> list = getAllUsers();
		int n = list.size();
		user.setUid(n+1);
		
		userDAO.addUser(user);
		return user;
	}
	
	@PutMapping("/delete/{uid}")
	public ResponseEntity<Void> deleteUser(@PathVariable(name="uid") int uid) {
		userDAO.deleteUser(uid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
