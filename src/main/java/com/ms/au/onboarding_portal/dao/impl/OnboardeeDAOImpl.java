package com.ms.au.onboarding_portal.dao.impl;

import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.ADD_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.DELETE_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.FETCH_ALL_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.UPDATE_ONBOARDEE;

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
public class OnboardeeDAOImpl implements OnboardeeDAO {

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
	 * Delete onboardee.
	 *
	 * @param uid the uid
	 */
	@Override
	public int deleteOnboardee(int uid) {
		jdbcTemplate.update(DELETE_ONBOARDEE, uid);
		return uid;
	}

	/**
	 * Update onboardee.
	 *
	 * @param onboardee the onboardee
	 */
	@Override
	public Onboardee updateOnboardee(Onboardee onboardee) {
		jdbcTemplate.update(UPDATE_ONBOARDEE, onboardee.getFirstName(), onboardee.getLastName(),
				onboardee.getWebLoginId(), onboardee.getStatus(), onboardee.getBackgroundCheckStatus(),
				onboardee.getEtaForOnboarding(), onboardee.getUid());
		return onboardee;
	}

	/**
	 * Adds the onboardee.
	 *
	 * @param onboardee the onboardee
	 */
	@Override
	public Onboardee addOnboardee(Onboardee onboardee) {
		jdbcTemplate.update(ADD_ONBOARDEE, getUid(), onboardee.getFirstName(), onboardee.getLastName(),
				onboardee.getWebLoginId(), listToString(onboardee.getSkillSet()), onboardee.getDemandId());
		return onboardee;
	}

	public String listToString(List<String> skills) {
		StringBuilder sb = new StringBuilder("[");

		for (String skill : skills) {
			sb.append("\"" + skill + "\",");
		}
		sb = new StringBuilder(sb.toString().substring(0, sb.length() - 1));
		sb.append("]");
		return sb.toString();
	}

	public int getUid() {
		return 200 + getAllOnboardee().size() + 1;
	}
}
