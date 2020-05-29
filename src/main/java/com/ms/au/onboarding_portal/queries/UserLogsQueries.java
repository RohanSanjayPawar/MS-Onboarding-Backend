package com.ms.au.onboarding_portal.queries;

/**
 * The Class UserLogsQueries.
 * 
 * @author Rohan Pawar
 */
public class UserLogsQueries {
	
	/** The Constant FETCH_ALL_LOGS_FOR_USER. */
	public static final String FETCH_ALL_LOGS_FOR_USER = "SELECT * FROM USER_LOGS o1 JOIN USER o2 ON o1.USER_UID=o2.UID AND o1.USER_UID = ?";
	
	public static final String ADD_LOGS = "INSERT INTO USER_LOGS(UID, USER_UID, DESCRIPTION, CREATED_AT) VALUES(?, ?, ?, ?)";
	
	/**
	 * Instantiates a new user logs queries.
	 */
	private UserLogsQueries() { }
}
