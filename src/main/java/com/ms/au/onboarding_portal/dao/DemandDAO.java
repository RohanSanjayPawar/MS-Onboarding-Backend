package com.ms.au.onboarding_portal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ms.au.onboarding_portal.model.Demand;
import com.ms.au.onboarding_portal.model.Onboardee;

/**
 * The Interface DemandDAO.
 * 
 * @author Rohan Pawar
 */
@Repository
public interface DemandDAO {
	
	/**
	 * Gets the all demand.
	 *
	 * @return the all demand
	 */
	public List<Demand> getAllDemand(int uid);
	
	/**
	 * Gets the filtered demands.
	 *
	 * @param skills the skills
	 * @return the filtered demands
	 */
	public List<Demand> getFilteredDemands(int uid, Onboardee onboardee);
	
	/**
	 * Adds the demand.
	 *
	 * @param demand the demand
	 */
	public void addDemand(Demand demand);
}
