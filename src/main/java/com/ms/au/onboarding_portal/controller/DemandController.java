package com.ms.au.onboarding_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.au.onboarding_portal.dao.impl.DemandDAOImpl;
import com.ms.au.onboarding_portal.model.Demand;
import com.ms.au.onboarding_portal.model.Onboardee;

/**
 * The Class DemandController.
 * 
 * @author Rohan Pawar
 */
@RestController
@RequestMapping("/api/demand")
public class DemandController {
	
	/** The demand DAO. */
	@Autowired
	public DemandDAOImpl demandDAO;
	
	/**
	 * Gets the all demands.
	 *
	 * @param uid the uid
	 * @return the all demands
	 */
	@GetMapping("/{uid}")
	public List<Demand> getAllDemands(@PathVariable(name="uid") int uid) {
		return demandDAO.getAllDemand(uid);
	}
	
	/**
	 * Filter demands.
	 *
	 * @param uid the uid
	 * @param skills the skills
	 * @return the list
	 */
	@PutMapping("/{uid}")
	public List<Demand> filterDemands(@PathVariable(name="uid") int uid, @RequestBody Onboardee onboardee) {
		return demandDAO.getFilteredDemands(uid, onboardee);
	}
	
	/**
	 * Adds the demand.
	 *
	 * @param demand the demand
	 * @return the response entity
	 */
	@PutMapping("/add")
	public ResponseEntity<Void> addDemand(@RequestBody Demand demand) {
		demandDAO.addDemand(demand);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}