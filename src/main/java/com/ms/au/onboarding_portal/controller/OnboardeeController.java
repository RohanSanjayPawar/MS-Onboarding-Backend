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

import com.ms.au.onboarding_portal.dao.impl.OnboardeeDAOImpl;
import com.ms.au.onboarding_portal.model.Onboardee;

/**
 * The Class OnboardeeController.
 * 
 * @author Rohan Pawar
 */
@RestController
@RequestMapping("/api/onboardee")
public class OnboardeeController {
	
	/** The dao. */
	@Autowired
	public OnboardeeDAOImpl onboardeeDAO;
	
	/**
	 * Gets the all onboardee.
	 *
	 * @return the all onboardee
	 */
	@GetMapping("/")
	public List<Onboardee> getAllOnboardee() {
		return onboardeeDAO.getAllOnboardee();
	}
	
	/**
	 * Delete onboardee.
	 *
	 * @param uid the uid
	 * @return the response entity
	 */
	@PutMapping("/delete/{uid}")
	public ResponseEntity<Void> deleteOnboardee(@PathVariable(name="uid") int uid) {
		onboardeeDAO.deleteOnboardee(uid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Update onboardee.
	 *
	 * @param uid the uid
	 * @param onboardee the onboardee
	 * @return the response entity
	 */
	@PutMapping("/update/{uid}")
	public ResponseEntity<Void>	updateOnboardee(@PathVariable(name="uid") int uid, @RequestBody Onboardee onboardee) {
		onboardeeDAO.updateOnboardee(onboardee);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Adds the onboardee.
	 *
	 * @param onboardee the onboardee
	 * @return the response entity
	 */
	@PutMapping("/add")
	public ResponseEntity<Void>	addOnboardee(@RequestBody Onboardee onboardee) {
		onboardeeDAO.addOnboardee(onboardee);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
