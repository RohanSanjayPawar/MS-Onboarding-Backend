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

import com.ms.au.onboarding_portal.dao.impl.UserDAOImpl;
import com.ms.au.onboarding_portal.enums.UserRolesEnum;
import com.ms.au.onboarding_portal.model.User;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserDAOImpl dao;

	@Test
	public void findAllUsers() throws Exception {
		User user = getUser();
		List<User> users = new ArrayList<>();
		users.add(user);

		when(dao.getAllUsers()).thenReturn(users);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void findUserById() throws Exception {
		User user = getUser();
		List<User> users = new ArrayList<>();
		users.add(user);

		when(dao.getUserForEmail("random@email.com")).thenReturn(users);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/random@example.com")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void loginUser() throws Exception {
		User user = getUser();
		List<User> users = new ArrayList<>();
		users.add(user);

		when(dao.loginUser("some random text")).thenReturn(users);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/login")
				.header("Authorization", "some random text").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void addUser() throws Exception {
		User user = getUser();

		String json = "{\"uid\": 1, \"firstName\": \"Ruchi\", \"lastName\": \"Pawar\", \"webLoginId\": \"ruchi.sanjaypawar@accoliteindia.com\", \"password\": \"abc@123\", \"failedLoginAttempt\": 0, \"lastLoginAt\": null, \"createdAt\": null, \"updateAt\": null, \"currentOffice\": \"Mumbai\", \"role\": \"MANAGER\" }";

		when(dao.addUser(user)).thenReturn(user);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/add").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}
	
	@Test
	public void deleteUser() throws Exception {
		String json = "";

		when(dao.deleteUser(1)).thenReturn(1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/delete/1").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
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
