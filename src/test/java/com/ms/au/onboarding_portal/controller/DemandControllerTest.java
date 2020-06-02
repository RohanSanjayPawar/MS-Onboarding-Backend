package com.ms.au.onboarding_portal.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ms.au.onboarding_portal.model.Demand;
import com.ms.au.onboarding_portal.model.Onboardee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemandControllerTest {
	@Autowired
	private DemandController demandController;
	
	@Test
	public void findAllDemands() {
		List<Demand> demands = demandController.getDemands();
		assertNotNull(demands);
		assertTrue(demands.size() >= 0);
	}
	
	@Test
	public void findAllDemandsWithUID() {
		List<Demand> demands = demandController.getAllDemands(1);
		assertNotNull(demands);
		assertTrue(demands.size() > 0);
	}
	
	@Test
	public void filterDemands() {
		Onboardee onboardee = new Onboardee();
		onboardee.setExperience(10);
		List<String> skills = new ArrayList<>();
		skills.add("Java");
		skills.add("Angular");
		onboardee.setSkillSet(skills);
		List<Demand> demands = demandController.filterDemands(1, onboardee);
		assertNotNull(demands);
		assertTrue(demands.size() >= 0);
	}
	
	@Test
	public void addDemand() {
		List<Demand> demands = demandController.getDemands();
		int uid = 101 + demands.size();
	
		Demand demand = new Demand();
		demand.setUid(uid);
		demand.setAddress("A");
		demand.setExperience(10);
		demand.setInProcess(0);
		demand.setLocation("B");
		List<String> list = new ArrayList<>();
		list.add("Java");
		demand.setRequirements(list);
		demand.setRole("C");
		demand.setTotal(20);
		
		ResponseEntity<Void> response = demandController.addDemand(demand);
		assertNotNull(response);
		assertEquals(response, new ResponseEntity<>(HttpStatus.OK));
		
		ResponseEntity<Void> response2 = demandController.deleteDemand(uid);
		assertNotNull(response2);
		assertEquals(response2, new ResponseEntity<>(HttpStatus.OK));
	}
}
