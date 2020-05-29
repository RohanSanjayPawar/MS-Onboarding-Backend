package com.ms.au.onboarding_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.au.onboarding_portal.dao.impl.OnboardeeDAOImpl;
import com.ms.au.onboarding_portal.model.Onboardee;

@RestController
@RequestMapping("/api/onboardee")
public class OnboardeeController {
	
	/** The dao. */
	@Autowired
	public OnboardeeDAOImpl onboardeeDAO;
	
	@GetMapping("/")
	public List<Onboardee> getAllOnboardee() {
		return onboardeeDAO.getAllOnboardee();
	}
	
	@GetMapping("/search")
	@ResponseBody()
	public List<Onboardee> searchOnboardee(@RequestParam(name = "field") String field, @RequestParam(name = "value") String value) {
		return onboardeeDAO.searchOnboardee(field, value);
	}
	
}
