package com.ms.au.onboarding_portal.dao.impl;

import static com.ms.au.onboarding_portal.queries.DemandQueries.ADD_DEMAND;
import static com.ms.au.onboarding_portal.queries.DemandQueries.ALL_DEMANDS;
import static com.ms.au.onboarding_portal.queries.DemandQueries.DELETE_DEMAND;
import static com.ms.au.onboarding_portal.queries.DemandQueries.FETCH_ALL_DEMANDS;
import static com.ms.au.onboarding_portal.queries.DemandQueries.UPDATE_DEMAND;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private List<Demand> demands = new ArrayList<>();
	
	/**
	 * Gets the demands.
	 *
	 * @return the demands
	 */
	@Override
	public List<Demand> getDemands() {
		return jdbcTemplate.query(ALL_DEMANDS, new DemandRowMapper());
	}
	
	/**
	 * Gets the all demand.
	 *
	 * @param uid the uid
	 * @return the all demand
	 */
	@Override
	public List<Demand> getAllDemand(int uid) {
		return jdbcTemplate.query(FETCH_ALL_DEMANDS+uid, new DemandRowMapper());
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
		this.demands = getDemands();
		return filterDemands(onboardee.getSkillSet(), onboardee.getExperience());
	}

	/**
	 * Adds the demand.
	 *
	 * @param demand the demand
	 */
	@Override
	public Demand addDemand(Demand demand) {
		jdbcTemplate.update(ADD_DEMAND, getUid(), demand.getLocation(), demand.getAddress(), listToString(demand.getRequirements()), demand.getExperience(), demand.getRole(), demand.getTotal(), demand.getInProcess());
		return demand;
	}
	
	/**
	 * Delete demand.
	 *
	 * @param uid the uid
	 * @return the int
	 */
	@Override
	public int deleteDemand(int uid) {
		jdbcTemplate.update(DELETE_DEMAND + uid);
		return uid;
	}
	
	/**
	 * Update demand.
	 *
	 * @param uid the uid
	 * @return the int
	 */
	@Override
	public int updateDemand(int uid) {
		jdbcTemplate.update(UPDATE_DEMAND+uid);
		return uid;
	}

	/**
	 * Filter demands.
	 *
	 * @param demands the demands
	 * @param skills the skills
	 * @return the list
	 */
	public List<Demand> filterDemands(List<String> skills, int experience) {
		List<Demand> filtered = new ArrayList<>();
		
		List<Demand> applicable = new ArrayList<>();
		
		for(Demand demand: this.demands) {
			if(demand.getTotal() > 0 && demand.getExperience() <= experience) {
				applicable.add(demand);
			}
		}
		
		for(Demand demand: applicable) {
			for(String skill: skills) {
				if(demand.getRequirements().contains(skill)) {
					filtered.add(demand);
					break;
				}
			}
		}
		
		return filtered;
	}
	
	/**
	 * List to string.
	 *
	 * @param skills the skills
	 * @return the string
	 */
	public String listToString(List<String> skills) {
		StringBuilder sb = new StringBuilder("[");
		
		for(String skill: skills) {
			sb.append("\"" + skill + "\",");
		}
		sb = new StringBuilder(sb.toString().substring(0, sb.length()-1));
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * Gets the uid.
	 *
	 * @return the uid
	 */
	public int getUid() {
		List<Demand> list = getDemands();
		return 101 + list.size();
	}
}
