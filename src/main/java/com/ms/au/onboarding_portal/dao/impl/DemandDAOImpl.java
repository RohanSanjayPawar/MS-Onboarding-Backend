package com.ms.au.onboarding_portal.dao.impl;

import static com.ms.au.onboarding_portal.queries.DemandQueries.ADD_DEMAND;
import static com.ms.au.onboarding_portal.queries.DemandQueries.FETCH_ALL_DEMANDS;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ms.au.onboarding_portal.controller.UserLogsController;
import com.ms.au.onboarding_portal.dao.DemandDAO;
import com.ms.au.onboarding_portal.model.Demand;
import com.ms.au.onboarding_portal.model.Onboardee;
import com.ms.au.onboarding_portal.row_mapper.DemandRowMapper;

/**
 * The Class DemandDAOImpl.
 * 
 * @author Rohan Pawar
 */
@Component
public class DemandDAOImpl implements DemandDAO {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(UserLogsController.class.getName());

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Gets the all demand.
	 *
	 * @param uid the uid
	 * @return the all demand
	 */
	@Override
	public List<Demand> getAllDemand(int uid) {
		try {
			return jdbcTemplate.query(FETCH_ALL_DEMANDS+uid, new DemandRowMapper());
		} catch(Exception e) {
			logger.info("Error occured while fetching demands: "+e);
			return new ArrayList<>();
		}
	}

	/**
	 * Gets the filtered demands.
	 *
	 * @param uid the uid
	 * @param skills the skills
	 * @return the filtered demands
	 */
	@Override
	public List<Demand> getFilteredDemands(int uid, Onboardee onboardee) {
		List<Demand> demands = getAllDemand(uid);
		return filterDemands(demands, onboardee.getSkillSet(), onboardee.getExperience());
	}

	/**
	 * Adds the demand.
	 *
	 * @param demand the demand
	 */
	@Override
	public void addDemand(Demand demand) {
		jdbcTemplate.update(ADD_DEMAND, demand.getUid(), demand.getLocation(), demand.getAddress(), demand.getRequirements(), demand.getExperience());
	}
	
	/**
	 * Filter demands.
	 *
	 * @param demands the demands
	 * @param skills the skills
	 * @return the list
	 */
	public List<Demand> filterDemands(List<Demand> demands, List<String> skills, int experience) {
		List<Demand> filtered = new ArrayList<>();
		
		for(Demand demand: demands) {
			for(String skill: skills) {
				if(demand.getExperience() > experience)
					break;
				if(demand.getRequirements().contains(skill)) {
					filtered.add(demand);
					break;
				}
			}
		}
		
		return filtered;
	}
}
