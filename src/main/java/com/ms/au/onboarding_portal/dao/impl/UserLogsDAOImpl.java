package com.ms.au.onboarding_portal.dao.impl;

import static com.ms.au.onboarding_portal.queries.UserLogsQueries.ADD_LOGS;
import static com.ms.au.onboarding_portal.queries.UserLogsQueries.FETCH_ALL_LOGS_FOR_USER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ms.au.onboarding_portal.dao.UserLogsDAO;
import com.ms.au.onboarding_portal.model.UserLogs;
import com.ms.au.onboarding_portal.row_mapper.UserLogsRowMapper;

/**
 * The Class UserLogsDAOImpl.
 * 
 * @author Rohan Pawar
 */
@Component
public class UserLogsDAOImpl implements UserLogsDAO {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Gets the all user logs.
	 *
	 * @param uid the uid
	 * @return the all user logs
	 */
	@Override
	public List<UserLogs> getAllUserLogs(int uid) {
		return jdbcTemplate.query(FETCH_ALL_LOGS_FOR_USER, new Object[] {uid}, new UserLogsRowMapper());
	}

	/**
	 * Insert log.
	 *
	 * @param userLog the user log
	 * @param uid the uid
	 * @return true, if successful
	 */
	@Override
	public boolean insertLog(UserLogs userLog, int uid) {
		Object[] params = new Object[] { userLog.getUid(), uid, userLog.getDescription(), userLog.getCreatedAt() };
		jdbcTemplate.update(ADD_LOGS, params);
		return true;
	}

}
