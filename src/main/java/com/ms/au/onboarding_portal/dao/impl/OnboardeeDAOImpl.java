package com.ms.au.onboarding_portal.dao.impl;

import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.FETCH_ALL_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.SEARCH_ONBOARDEE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ms.au.onboarding_portal.dao.OnboardeeDAO;
import com.ms.au.onboarding_portal.model.Onboardee;
import com.ms.au.onboarding_portal.row_mapper.OnboardeeRowMapper;

/**
 * The Class OnboardeeDAOImpl.
 * 
 * @author Rohan Pawar
 */
@Component
public class OnboardeeDAOImpl implements OnboardeeDAO{
	
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
	 * @param fieldValueMapping the field value mapping
	 * @return the list
	 */
	@Override
	public List<Onboardee> searchOnboardee(String field, String value) {
		try {
			String query = SEARCH_ONBOARDEE + " AND o1." + field + "='" + value + "'"; 
			return jdbcTemplate.query(query, new OnboardeeRowMapper());
		} catch(Exception e) {
			return new ArrayList<>();
		}
	}
}
