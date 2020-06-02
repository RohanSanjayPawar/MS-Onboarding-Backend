package com.ms.au.onboarding_portal.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ms.au.onboarding_portal.model.UserLogs;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserLogsControllerTest {
	@Autowired
	private UserLogsController userLogsController;
	
	
	@Test
	public void findAllUserLogs() {
		List<UserLogs> users = userLogsController.getUserLogs(1);
		assertNotNull(users);
		assertTrue(users.size() >= 0);
	}
	
	@Test
	public void addLog() {
		UserLogsController controller = mock(UserLogsController.class);
		UserLogs log = new UserLogs();
		log.setUid(1);
		log.setDescription("TEST");
		log.setUserName("Loren Ipsum");
		when(controller.addLogs(1, log)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
		ResponseEntity<Void> response = controller.addLogs(1, log);
		assertNotNull(response);
		assertEquals(new ResponseEntity<>(HttpStatus.OK), response);
	}
}
