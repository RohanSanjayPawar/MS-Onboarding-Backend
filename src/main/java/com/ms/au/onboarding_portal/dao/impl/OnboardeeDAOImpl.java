package com.ms.au.onboarding_portal.dao.impl;

import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.ADD_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.DELETE_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.FETCH_ALL_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.SEARCH_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.UPDATE_ONBOARDEE;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ms.au.onboarding_portal.controller.UserLogsController;
import com.ms.au.onboarding_portal.dao.OnboardeeDAO;
import com.ms.au.onboarding_portal.model.Onboardee;
import com.ms.au.onboarding_portal.row_mapper.OnboardeeRowMapper;

/**
 * The Class OnboardeeDAOImpl.
 * 
 * @author Rohan Pawar
 */
@Component
public class OnboardeeDAOImpl implements OnboardeeDAO {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(UserLogsController.class.getName());

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Gets the all onboardee.
	 *
	 * @return the all onboardee
	 */
	@Override
	public List<Onboardee> getAllOnboardee() {
		return jdbcTemplate.query(FETCH_ALL_ONBOARDEE, new OnboardeeRowMapper());
	}

	/**
	 * Search onboardee.
	 *
	 * @param field the field
	 * @param value the value
	 * @return the list
	 */
	@Override
	public List<Onboardee> searchOnboardee(String field, String value) {
		try {
			String query = SEARCH_ONBOARDEE + " AND o1." + field + "='" + value + "'";
			return jdbcTemplate.query(query, new OnboardeeRowMapper());
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	/**
	 * Delete onboardee.
	 *
	 * @param uid the uid
	 */
	@Override
	public void deleteOnboardee(int uid) {
		try {
			jdbcTemplate.update(DELETE_ONBOARDEE, uid);
		} catch (DataAccessException e) {
			logger.info("Error while deleting onboardee:" + e);
		}
	}

	/**
	 * Update onboardee.
	 *
	 * @param onboardee the onboardee
	 */
	@Override
	public void updateOnboardee(Onboardee onboardee) {
		try {
			jdbcTemplate.update(UPDATE_ONBOARDEE, onboardee.getFirstName(), onboardee.getLastName(),
					onboardee.getWebLoginId(), onboardee.getStatus(), onboardee.getBackgroundCheckStatus(),
					onboardee.getEtaForOnboarding(), onboardee.getUid());
		} catch (DataAccessException e) {
			logger.info("Error while updating onboardee:" + e);
		}
	}

	/**
	 * Adds the onboardee.
	 *
	 * @param onboardee the onboardee
	 */
	@Override
	public void addOnboardee(Onboardee onboardee) {
		try {
			jdbcTemplate.update(ADD_ONBOARDEE, getUid(), onboardee.getFirstName(), onboardee.getLastName(),
					onboardee.getWebLoginId(), listToString(onboardee.getSkillSet()), onboardee.getDemandId());
		} catch (DataAccessException e) {
			logger.info("Error while updating onboardee:" + e);
		}
	}
	
	public String listToString(List<String> skills) {
		StringBuilder sb = new StringBuilder("[");
		
		for(String skill: skills) {
			sb.append("\"" + skill + "\",");
		}
		sb = new StringBuilder(sb.toString().substring(0, sb.length()-1));
		sb.append("]");
		return sb.toString();
	}
	
	public int getUid() {
		return 200 + getAllOnboardee().size() + 1;
	}
}
