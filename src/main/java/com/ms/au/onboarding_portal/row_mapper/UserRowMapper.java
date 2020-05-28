package com.ms.au.onboarding_portal.row_mapper;

import static com.ms.au.onboarding_portal.constants.UserConstants.CREATED_AT;
import static com.ms.au.onboarding_portal.constants.UserConstants.CURRENT_OFFICE;
import static com.ms.au.onboarding_portal.constants.UserConstants.FAILED_LOGIN_ATTEMPT;
import static com.ms.au.onboarding_portal.constants.UserConstants.FIRST_NAME;
import static com.ms.au.onboarding_portal.constants.UserConstants.LAST_LOGIN_AT;
import static com.ms.au.onboarding_portal.constants.UserConstants.LAST_NAME;
import static com.ms.au.onboarding_portal.constants.UserConstants.PASSWORD;
import static com.ms.au.onboarding_portal.constants.UserConstants.ROLE;
import static com.ms.au.onboarding_portal.constants.UserConstants.UID;
import static com.ms.au.onboarding_portal.constants.UserConstants.UPDATED_AT;
import static com.ms.au.onboarding_portal.constants.UserConstants.WEB_LOGIN_ID;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ms.au.onboarding_portal.enums.UserRolesEnum;
import com.ms.au.onboarding_portal.model.User;

/**
 * The Class UserRowMapper.
 * 
 * @author Rohan Pawar
 */
public class UserRowMapper implements RowMapper<User>  {
	
	/**
	 * Map row.
	 *
	 * @param row the resultset
	 * @param i the index
	 * @return the user
	 * @throws SQLException the SQL exception
	 */
	public User mapRow(ResultSet row, int i) throws SQLException {
		User user = new User();
		user.setCreatedAt(row.getDate(CREATED_AT));
		user.setCurrentOffice(row.getInt(CURRENT_OFFICE));
		user.setFailedLoginAttempt(row.getInt(FAILED_LOGIN_ATTEMPT));
		user.setFirstName(row.getString(FIRST_NAME));
		user.setLastLoginAt(row.getDate(LAST_LOGIN_AT));
		user.setLastName(row.getString(LAST_NAME));
		user.setPassword(row.getString(PASSWORD));
		
		if(row.getString(ROLE).equals("ADMIN"))
			user.setRole(UserRolesEnum.ADMIN);
		else
			user.setRole(UserRolesEnum.MANAGER);
		
		user.setUid(row.getInt(UID));
		user.setUpdateAt(row.getDate(UPDATED_AT));
		user.setWebLoginId(row.getString(WEB_LOGIN_ID));
        
        return user;
	}
}
