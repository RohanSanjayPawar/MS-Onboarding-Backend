package com.ms.au.onboarding_portal.dao;

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
public class UserDAOTest {
	@Autowired
	private UserDAOImpl userDao;

	@Test
	public void findAllUsers() {
		List<User> users = userDao.getAllUsers();
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}

	@Test
	public void findUserById() {
		List<User> users = userDao.getUserForId(1);
		assertNotNull(users);
		assertTrue(users.size() == 1);
	}
	
	@Test
	public void loginUser() {
		List<User> users = userDao.loginUser("somerandom text");
		assertEquals(users, new ArrayList<User>());
		assertTrue(users.size() == 0);
	}
}
