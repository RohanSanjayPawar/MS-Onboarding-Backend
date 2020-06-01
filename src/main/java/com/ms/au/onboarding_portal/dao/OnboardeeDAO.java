package com.ms.au.onboarding_portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ms.au.onboarding_portal.model.Onboardee;

/**
 * The Interface OnboardeeDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface OnboardeeDAO {
	
	/**
	 * Gets the all onboardee.
	 *
	 * @return the all onboardee
	 */
	public List<Onboardee> getAllOnboardee();
	
	/**
	 * Search onboardee.
	 *
	 * @param fieldValueMapping the field value mapping
	 * @return the list
	 */
	public List<Onboardee> searchOnboardee(String field, String value);
	
	/**
	 * Delete onboardee.
	 *
	 * @param uid the uid
	 */
	public void deleteOnboardee(int uid);
	
	/**
	 * Update onboardee.
	 *
	 * @param onboardee the onboardee
	 */
	public void updateOnboardee(Onboardee onboardee);
	
	
	/**
	 * Adds the onboardee.
	 *
	 * @param onboardee the onboardee
	 */
	public void addOnboardee(Onboardee onboardee);
}
