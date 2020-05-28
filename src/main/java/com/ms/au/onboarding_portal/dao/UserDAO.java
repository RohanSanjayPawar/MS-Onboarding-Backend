package com.ms.au.onboarding_portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ms.au.onboarding_portal.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface UserDAO {
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	public List<User> getAllUsers();
	
	/**
	 * Gets the user for id.
	 *
	 * @param uid the uid
	 * @return the user for id
	 */
	public List<User> getUserForId(int uid);
	
	
	/**
	 * Login user.
	 *
	 * @param authorizationHeader the authorization header
	 * @return the user
	 */
	public List<User> loginUser(String authorizationHeader);
}
