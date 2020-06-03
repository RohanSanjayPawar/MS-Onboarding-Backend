package com.ms.au.onboarding_portal.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ms.au.onboarding_portal.dao.impl.UserLogsDAOImpl;
import com.ms.au.onboarding_portal.model.UserLogs;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserLogsController.class)
public class UserLogsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserLogsDAOImpl dao;

	@Test
	public void getAllLogs() throws Exception {
		UserLogs log = new UserLogs();
		log.setUid(1);
		log.setDescription("TEST");
		log.setUserName("Loren Ipsum");
		List<UserLogs> logs = new ArrayList<>();
		logs.add(log);

		when(dao.getAllUserLogs(1)).thenReturn(logs);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user-logs/1")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void addLog() throws Exception {
		UserLogs log = new UserLogs();
		log.setUid(1);
		log.setDescription("TEST");
		log.setUserName("Loren Ipsum");
		when(dao.insertLog(log, 1)).thenReturn(true);
		
		String json = "{\"uid\": 1,\"userName\": \"ABC\", \"description\": \"Added Onboardee!\", \"createdAt\": \"2020-05-04T12:34:21\"}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user-logs/add/1")
				.accept(MediaType.APPLICATION_JSON).content(json).contentType(MediaType.APPLICATION_JSON);
;
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}
}
