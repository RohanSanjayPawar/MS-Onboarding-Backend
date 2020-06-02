package com.ms.au.onboarding_portal.dao.impl;

import static com.ms.au.onboarding_portal.queries.DemandQueries.ADD_DEMAND;
import static com.ms.au.onboarding_portal.queries.DemandQueries.ALL_DEMANDS;
import static com.ms.au.onboarding_portal.queries.DemandQueries.DELETE_DEMAND;
import static com.ms.au.onboarding_portal.queries.DemandQueries.FETCH_ALL_DEMANDS;

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
		jdbcTemplate.update(ADD_DEMAND, getUid(), demand.getLocation(), demand.getAddress(), listToString(demand.getRequirements()), demand.getExperience(), demand.getRole(), demand.getTotal(), demand.getInProcess());
	}
	
	@Override
	public void deleteDemand(int uid) {
		jdbcTemplate.update(DELETE_DEMAND + uid);
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
		List<Demand> list = getDemands();
		return 101 + list.size();
	}
}
