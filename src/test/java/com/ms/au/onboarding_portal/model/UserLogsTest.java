package com.ms.au.onboarding_portal.model;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ms.au.onboarding_portal.PojoTestUtil;
import com.ms.au.onboarding_portal.controller.UserLogsController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserLogsTest {
	@Autowired
	UserLogsController controller;
	
	@Test
    public void testAccesors_shouldAccessProperField() {
        PojoTestUtil.validateAccessors(UserLogs.class);
    }
	
	@Test
	public void rowMapperTest() {
		List<UserLogs> result = controller.getUserLogs(1);
		assertNotNull(result);
	}
}
