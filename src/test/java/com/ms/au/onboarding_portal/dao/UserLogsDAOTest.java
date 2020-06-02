package com.ms.au.onboarding_portal.dao;

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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ms.au.onboarding_portal.dao.impl.UserLogsDAOImpl;
import com.ms.au.onboarding_portal.model.UserLogs;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserLogsDAOTest {
	@Autowired
	private UserLogsDAOImpl userLogsDAO;
	
	@Test
	public void findAllUserLogs() {
		List<UserLogs> userLogs = userLogsDAO.getAllUserLogs(1);
		assertNotNull(userLogs);
		assertTrue(userLogs.size() >= 0);
	}
	
	@Test
	public void addLog() {
		UserLogsDAOImpl dao = mock(UserLogsDAOImpl.class);
		UserLogs log = new UserLogs();
		log.setUid(1);
		log.setDescription("TEST");
		log.setUserName("Loren Ipsum");
		when(dao.insertLog(log, 1)).thenReturn(true);
		boolean result = dao.insertLog(log, 1);
		assertNotNull(result);
		assertEquals(true, result);
	}
}
