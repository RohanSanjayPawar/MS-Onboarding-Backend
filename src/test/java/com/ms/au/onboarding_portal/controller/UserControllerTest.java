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

import com.ms.au.onboarding_portal.enums.UserRolesEnum;
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
		assertTrue(users.size() >= 0);
	}

	@Test
	public void findUserById() {
		List<User> users = userController.getUserWithUid("rohan.sanjaypawar@accoliteindia.com");
		assertNotNull(users);
		assertTrue(users.size() >= 0);
	}
	
	@Test
	public void loginUser() {
		List<User> users = userController.validateUser("somerandom text");
		assertEquals(users, new ArrayList<User>());
		assertTrue(users.size() >= 0);
	}
	
	@Test
	public void userTest() {
		User user = getUser();
		List<User> users = userController.getAllUsers();
		user.setUid(1 + users.size());
		
		User newUser = userController.addUser(user);
		assertEquals(user.getFirstName(), newUser.getFirstName());

		ResponseEntity<Void> response = userController.deleteUser(1 + users.size());
		assertNotNull(response);
		assertEquals(response, new ResponseEntity<>(HttpStatus.OK));
	}
	
	public User getUser() {
		User user = new User();
		
		user.setCreatedAt(null);
		user.setCurrentOffice("A");
		user.setFailedLoginAttempt(0);
		user.setFirstName("A");
		user.setLastLoginAt(null);
		user.setLastName("B");
		user.setPassword("pass");
		user.setRole(UserRolesEnum.ADMIN);
		user.setUid(0);
		user.setUpdateAt(null);
		user.setWebLoginId("abc");
		
		return user;
	}
}
