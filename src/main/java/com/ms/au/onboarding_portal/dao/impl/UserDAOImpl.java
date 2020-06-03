package com.ms.au.onboarding_portal.dao.impl;

import static com.ms.au.onboarding_portal.queries.UserQueries.ADD_USER;
import static com.ms.au.onboarding_portal.queries.UserQueries.DELETE_USER;
import static com.ms.au.onboarding_portal.queries.UserQueries.FETCH_USERS;
import static com.ms.au.onboarding_portal.queries.UserQueries.FETCH_USER_WITH_UID;
import static com.ms.au.onboarding_portal.queries.UserQueries.VALIDATE_USER;

import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ms.au.onboarding_portal.dao.UserDAO;
import com.ms.au.onboarding_portal.model.User;
import com.ms.au.onboarding_portal.row_mapper.UserRowMapper;

/**
 * The Class UserDAOImpl.
 * 
 * @author Rohan Pawar
 */
@Component
public class UserDAOImpl implements UserDAO {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@Override
	public List<User> getAllUsers() {
		return jdbcTemplate.query(FETCH_USERS, new UserRowMapper());
	}

	/**
	 * Gets the user for id.
	 *
	 * @param uid the uid
	 * @return the user for id
	 */
	@Override
	public List<User> getUserForEmail(String email) {
		return jdbcTemplate.query(FETCH_USER_WITH_UID, new Object[] {email}, new UserRowMapper());
	}

	@Override
	public List<User> loginUser(String authorizationHeader) {
		String encoded = authorizationHeader.split(" ")[1];
		byte[] decodedBytes = Base64.decodeBase64(encoded.getBytes());
		final String pair = new String(decodedBytes);
		final String[] userDetails = pair.split(":", 2);
		return jdbcTemplate.query(VALIDATE_USER, new Object[] {userDetails[0], userDetails[1]}, new UserRowMapper());
	}

	@Override
	public User addUser(User user) {
		Object[] params = new Object[] {user.getUid(), user.getFirstName(), user.getLastName(), user.getWebLoginId(), user.getPassword(), user.getFailedLoginAttempt(), user.getCurrentOffice(), user.getRole().label };
		jdbcTemplate.update(ADD_USER, params);
		return user;
	}

	@Override
	public int deleteUser(int uid) {
		jdbcTemplate.update(DELETE_USER+uid);
		return uid;
	}
}
