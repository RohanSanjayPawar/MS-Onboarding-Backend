package com.ms.au.onboarding_portal.row_mapper;

import static com.ms.au.onboarding_portal.constants.DemandConstants.DEMAND_PROFILE;
import static com.ms.au.onboarding_portal.constants.DemandConstants.DEMAND_UID;
import static com.ms.au.onboarding_portal.constants.DemandConstants.EXPERIENCE;
import static com.ms.au.onboarding_portal.constants.DemandConstants.IN_PROCESS;
import static com.ms.au.onboarding_portal.constants.DemandConstants.OFFICE_ADDRESS;
import static com.ms.au.onboarding_portal.constants.DemandConstants.OFFICE_LOCATION;
import static com.ms.au.onboarding_portal.constants.DemandConstants.REQUIREMENTS;
import static com.ms.au.onboarding_portal.constants.DemandConstants.TOTAL_DEMAND;
import static com.ms.au.onboarding_portal.constants.DemandConstants.UID;
import static com.ms.au.onboarding_portal.constants.UserConstants.FIRST_NAME;
import static com.ms.au.onboarding_portal.constants.UserConstants.LAST_NAME;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.au.onboarding_portal.model.Demand;

/**
 * The Class DemandRowMapper.
 * 
 * @author Rohan Pawar
 */
public class DemandRowMapper implements RowMapper<Demand> {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(DemandRowMapper.class.getName());
	
	/** The Constant objectMapper. */
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * Map row.
	 *
	 * @param row the row
	 * @param i the i
	 * @return the demand
	 * @throws SQLException the SQL exception
	 */
	public Demand mapRow(ResultSet row, int i) throws SQLException {
		Demand demand = new Demand();
		
		demand.setAddress(row.getString(OFFICE_ADDRESS));
		demand.setExperience(row.getInt(EXPERIENCE));
		demand.setInProcess(row.getInt(IN_PROCESS));
		demand.setLocation(row.getString(OFFICE_LOCATION));
		demand.setRole(row.getString(DEMAND_PROFILE));
		demand.setTotal(row.getInt(TOTAL_DEMAND));
		
		String name = "";
		try {
			name = row.getString(FIRST_NAME) + " " + row.getString(LAST_NAME);
		} catch(SQLException e) {
			StringBuilder error = new StringBuilder("Error occured while row mapping: ");
			error.append(e);
			logger.info(error.toString());
		}
		demand.setHiringManager(name);
			
		demand.setDemandUid(row.getInt(DEMAND_UID));
		demand.setUid(row.getInt(UID));
		
        String[] requirements;
		try {
			requirements = objectMapper.readValue(row.getString(REQUIREMENTS), String[].class);
		} catch (JsonProcessingException | SQLException e) {
			requirements = new String[0];
		}
		
		demand.setRequirements(Arrays.asList(requirements));
		
        return demand;
	}
}
