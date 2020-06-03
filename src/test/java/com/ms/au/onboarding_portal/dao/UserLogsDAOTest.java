package com.ms.au.onboarding_portal.dao;

import static com.ms.au.onboarding_portal.queries.UserLogsQueries.ADD_LOGS;
import static com.ms.au.onboarding_portal.queries.UserLogsQueries.FETCH_ALL_LOGS_FOR_USER;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ms.au.onboarding_portal.dao.impl.UserLogsDAOImpl;
import com.ms.au.onboarding_portal.model.UserLogs;
import com.ms.au.onboarding_portal.row_mapper.UserLogsRowMapper;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserLogsDAOTest {
	@InjectMocks
    UserLogsDAOImpl dao;
     
    @Mock
    JdbcTemplate jdbcTemplate;
	
	@Test
	public void findAllUserLogs() {
		UserLogs log = new UserLogs();
		log.setUid(1);
		log.setDescription("TEST");
		log.setUserName("Loren Ipsum");
		List<UserLogs> logs = new ArrayList<>();
		logs.add(log);
		
		when(jdbcTemplate.query(FETCH_ALL_LOGS_FOR_USER, new Object[] {1}, new UserLogsRowMapper())).thenReturn(logs);
		List<UserLogs> userLogs = dao.getAllUserLogs(1);
		assertNotNull(userLogs);
		assertTrue(userLogs.size() >= 0);
	}
	
	@Test
	public void addLog() {
		UserLogs userLog = new UserLogs();
		userLog.setUid(1);
		userLog.setDescription("TEST");
		userLog.setUserName("Loren Ipsum");
		
		Object[] params = new Object[] { userLog.getUid(), 1, userLog.getDescription(), userLog.getCreatedAt() };
		when(jdbcTemplate.update(ADD_LOGS, params)).thenReturn(1);
		boolean result = dao.insertLog(userLog, 1);
		assertNotNull(result);
	}
}
