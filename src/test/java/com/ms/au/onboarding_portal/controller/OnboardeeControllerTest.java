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

import com.ms.au.onboarding_portal.model.Onboardee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OnboardeeControllerTest {
	@Autowired
	private OnboardeeController onboardeeController;
	
	@Test
	public void getAllOnboardee() {
		List<Onboardee> onboardees = onboardeeController.getAllOnboardee();
		assertNotNull(onboardees);
		assertTrue(onboardees.size() >= 0);
	}
	
	@Test
	public void onboardeeTest() {
		Onboardee onboardee = getOnboardee();
		List<Onboardee> list = onboardeeController.getAllOnboardee();
		int uid = 201 + list.size();
		onboardee.setUid(uid);
		
		ResponseEntity<Void> response = onboardeeController.addOnboardee(onboardee);
		assertNotNull(response);
		assertEquals(new ResponseEntity<>(HttpStatus.OK), response);
		ResponseEntity<Void> response2 = onboardeeController.updateOnboardee(1, onboardee);
		assertNotNull(response2);
		assertEquals(new ResponseEntity<>(HttpStatus.OK), response2);
		ResponseEntity<Void> response3 = onboardeeController.deleteOnboardee(uid);
		assertNotNull(response);
		assertEquals(new ResponseEntity<>(HttpStatus.OK), response3);
		
	}
	
	public Onboardee getOnboardee() {
		Onboardee onboardee = new Onboardee();
		List<String> list = new ArrayList<>();
		list.add("Java");
		
		onboardee.setBackgroundCheckStatus("A");
		onboardee.setDemandId(1);
		onboardee.setEtaForOnboarding(10);
		onboardee.setExperience(10);
		onboardee.setFirstName("Loren");
		onboardee.setHiringManager("C");
		onboardee.setJoiningLocation("H");
		onboardee.setLastName("Ipsum");
		onboardee.setSkillSet(list);
		onboardee.setStatus("D");
		onboardee.setUid(1);
		onboardee.setWebLoginId("A");
		
		return onboardee;
	}
}
