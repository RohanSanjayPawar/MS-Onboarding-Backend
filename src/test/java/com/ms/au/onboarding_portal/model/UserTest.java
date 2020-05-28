package com.ms.au.onboarding_portal.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {
	
	public User getUser() {
		User user = new User();
		user.setFirstName("ABC");
		user.setLastName("XYZ");
		
		return user;
	}	
	
	@Test
	public void checkUserType1() {
		User user = getUser();
		assertEquals("ABC", user.getFirstName());
		assertEquals("XYZ", user.getLastName());
	}
	
}
