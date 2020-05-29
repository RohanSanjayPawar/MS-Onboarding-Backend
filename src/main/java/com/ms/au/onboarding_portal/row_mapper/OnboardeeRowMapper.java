package com.ms.au.onboarding_portal.row_mapper;

import static com.ms.au.onboarding_portal.constants.OfficeConstants.OFFICE_LOCATION;
import static com.ms.au.onboarding_portal.constants.OnboardeeConstants.BG_STATUS;
import static com.ms.au.onboarding_portal.constants.OnboardeeConstants.ETA_FOR_ONBOARDING;
import static com.ms.au.onboarding_portal.constants.OnboardeeConstants.FIRST_NAME;
import static com.ms.au.onboarding_portal.constants.OnboardeeConstants.LAST_NAME;
import static com.ms.au.onboarding_portal.constants.OnboardeeConstants.SKILLS;
import static com.ms.au.onboarding_portal.constants.OnboardeeConstants.STATUS;
import static com.ms.au.onboarding_portal.constants.OnboardeeConstants.UID;
import static com.ms.au.onboarding_portal.constants.OnboardeeConstants.WEB_LOGIN_ID;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.au.onboarding_portal.model.Onboardee;

/**
 * The Class OnboardeeRowMapper.
 * 
 * @author Rohan Pawar
 */
public class OnboardeeRowMapper implements RowMapper<Onboardee> {
	
	/** The Constant objectMapper. */
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * Map row.
	 *
	 * @param row the row
	 * @param i the i
	 * @return the onboardee
	 * @throws SQLException the SQL exception
	 */
	public Onboardee mapRow(ResultSet row, int i) throws SQLException {
		Onboardee onboardee = new Onboardee();
		
		onboardee.setBackgroundCheckStatus(row.getString(BG_STATUS));
		onboardee.setEtaForOnboarding(row.getInt(ETA_FOR_ONBOARDING));
		onboardee.setFirstName(row.getString(FIRST_NAME));
		onboardee.setHiringManager(row.getString(15) + " " + row.getString(16));
		onboardee.setJoiningLocation(row.getString(OFFICE_LOCATION));
		onboardee.setLastName(row.getString(LAST_NAME));
        onboardee.setStatus(row.getString(STATUS));
        onboardee.setUid(row.getInt(UID));
        onboardee.setWebLoginId(row.getString(WEB_LOGIN_ID));
        
        String[] skills;
		try {
			skills = objectMapper.readValue(row.getString(SKILLS), String[].class);
		} catch (JsonProcessingException | SQLException e) {
			skills = new String[0];
		}
		
		onboardee.setSkillSet(Arrays.asList(skills));
		
        return onboardee;
	}
}
