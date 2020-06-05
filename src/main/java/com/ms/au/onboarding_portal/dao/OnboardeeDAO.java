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
	 * Delete onboardee.
	 *
	 * @param uid the uid
	 */
	public int deleteOnboardee(int uid);
	
	/**
	 * Update onboardee.
	 *
	 * @param onboardee the onboardee
	 */
	public Onboardee updateOnboardee(Onboardee onboardee);
	
	
	/**
	 * Adds the onboardee.
	 *
	 * @param onboardee the onboardee
	 */
	public Onboardee addOnboardee(Onboardee onboardee);
	
	/**
	 * All onboardees.
	 *
	 * @return the list
	 */
	public List<Onboardee> allOnboardees();
}
