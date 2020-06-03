package com.ms.au.onboarding_portal.model;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ms.au.onboarding_portal.PojoTestUtil;
import com.ms.au.onboarding_portal.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {
	@Autowired
	UserController controller;
	
	@Test
    public void testAccesors_shouldAccessProperField() {
        PojoTestUtil.validateAccessors(User.class);
    }
	
	@Test
	public void rowMapperTest() {
		List<User> result = controller.getAllUsers();
		assertNotNull(result);
	}
	
}
