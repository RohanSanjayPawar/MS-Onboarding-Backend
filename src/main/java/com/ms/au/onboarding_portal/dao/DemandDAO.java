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
	 * Gets the demands.
	 *
	 * @return the demands
	 */
	public List<Demand> getDemands();
	
	/**
	 * Gets the all demand.
	 *
	 * @param uid the uid
	 * @return the all demand
	 */
	public List<Demand> getAllDemand(int uid);
	
	/**
	 * Gets the filtered demands.
	 *
	 * @param uid the uid
	 * @param onboardee the onboardee
	 * @return the filtered demands
	 */
	public List<Demand> getFilteredDemands(int uid, Onboardee onboardee);
	
	/**
	 * Adds the demand.
	 *
	 * @param demand the demand
	 */
	public Demand addDemand(Demand demand);
	
	/**
	 * Delete demand.
	 *
	 * @param uid the uid
	 */
	public int deleteDemand(int uid);
}
