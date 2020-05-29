package com.ms.au.onboarding_portal.queries;

/**
 * The Class UserQueries.
 * 
 * @author Rohan Pawar
 */
public class UserQueries {
	
	/** The Constant FETCH_USERS. */
	public static final String FETCH_USERS = "SELECT * FROM USER";
	
	/** The Constant FETCH_USER_WITH_UID. */
	public static final String FETCH_USER_WITH_UID = "SELECT * FROM USER u WHERE u.WEB_LOGIN_ID = ?";
	
	/** The Constant FETCH_USER_WITH_EMAIL. */
	public static final String VALIDATE_USER = "SELECT * FROM USER u WHERE u.WEB_LOGIN_ID = ? AND u.PASSWORD = ?";
	
	/** The Constant ADD_USER. */
	public static final String ADD_USER = "INSERT INTO USER(UID, FIRST_NAME, LAST_NAME, WEB_LOGIN_ID, PASSWORD, FAILED_LOGIN_ATTEMPT, CURRENT_OFFICE, ROLE) VALUES(?,?,?,?,?,?,?,?)";
	
	/**
	 * Instantiates a new user queries.
	 */
	private UserQueries() {}
}
