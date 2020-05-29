package com.ms.au.onboarding_portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ms.au.onboarding_portal.model.UserLogs;

/**
 * The Interface UserLogsDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface UserLogsDAO {
	
	/**
	 * Gets the all user logs.
	 *
	 * @param uid the uid
	 * @return the all user logs
	 */
	public List<UserLogs> getAllUserLogs(int uid);
	
	
	/**
	 * Insert log.
	 *
	 * @param userLog the user log
	 */
	public void insertLog(UserLogs userlog, int uid);
}
