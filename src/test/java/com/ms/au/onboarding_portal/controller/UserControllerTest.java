package com.ms.au.onboarding_portal.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ms.au.onboarding_portal.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {
	@Autowired
	private UserController userController;
	
	@Test
	public void findAllUsers() {
		List<User> users = userController.getAllUsers();
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}

	@Test
	public void findUserById() {
		List<User> users = userController.getUserWithUid("rohan.sanjaypawar@accoliteindia.com");
		assertNotNull(users);
		assertTrue(users.size() == 1);
	}
	
	@Test
	public void loginUser() {
		List<User> users = userController.validateUser("somerandom text");
		assertEquals(users, new ArrayList<User>());
		assertTrue(users.size() == 0);
	}
}
