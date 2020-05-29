package com.ms.au.onboarding_portal.row_mapper;

import static com.ms.au.onboarding_portal.constants.UserLogsConstants.CREATED_AT;
import static com.ms.au.onboarding_portal.constants.UserLogsConstants.DESCRIPTION;
import static com.ms.au.onboarding_portal.constants.UserLogsConstants.UID;
import static com.ms.au.onboarding_portal.constants.UserLogsConstants.FIRST_NAME;
import static com.ms.au.onboarding_portal.constants.UserLogsConstants.LAST_NAME;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ms.au.onboarding_portal.model.UserLogs;

public class UserLogsRowMapper implements RowMapper<UserLogs> {
	public UserLogs mapRow(ResultSet row, int i) throws SQLException {
		UserLogs userLogs = new UserLogs();
		userLogs.setUid(row.getInt(UID));
		userLogs.setDescription(row.getString(DESCRIPTION));
		userLogs.setCreatedAt(row.getDate(CREATED_AT));
		userLogs.setUserName(row.getString(FIRST_NAME) + " " + row.getString(LAST_NAME));
		
        return userLogs;
	}
}
