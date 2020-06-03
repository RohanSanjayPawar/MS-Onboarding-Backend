package com.ms.au.onboarding_portal.dao;

import static com.ms.au.onboarding_portal.queries.UserQueries.ADD_USER;
import static com.ms.au.onboarding_portal.queries.UserQueries.DELETE_USER;
import static com.ms.au.onboarding_portal.queries.UserQueries.FETCH_USERS;
import static com.ms.au.onboarding_portal.queries.UserQueries.FETCH_USER_WITH_UID;
import static com.ms.au.onboarding_portal.queries.UserQueries.VALIDATE_USER;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ms.au.onboarding_portal.dao.impl.UserDAOImpl;
import com.ms.au.onboarding_portal.enums.UserRolesEnum;
import com.ms.au.onboarding_portal.model.User;
import com.ms.au.onboarding_portal.row_mapper.UserRowMapper;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserDAOTest {
	
	@InjectMocks
    UserDAOImpl dao;
     
    @Mock
    JdbcTemplate jdbcTemplate;

	@Test
	public void findAllUsers() {
		User user = getUser();
		List<User> users = new ArrayList<>();
		users.add(user);
		
		when(jdbcTemplate.query(FETCH_USERS, new UserRowMapper())).thenReturn(users);
		List<User> result = dao.getAllUsers();
		assertNotNull(result);
	}
	
	@Test
	public void loginUser() {
		User user = getUser();
		List<User> users = new ArrayList<>();
		users.add(user);
		
		String plain = "example.com:pass";
		String encoded = "random " + Base64.encodeBase64String(plain.getBytes());
		
		when(jdbcTemplate.query(VALIDATE_USER, new Object[] {"example1", "pass"}, new UserRowMapper())).thenReturn(users);
		List<User> result = dao.loginUser(encoded);
		assertNotNull(result);
	}

	@Test
	public void findUserById() {
		User user = getUser();
		List<User> users = new ArrayList<>();
		users.add(user);
		
		when(jdbcTemplate.query(FETCH_USER_WITH_UID, new Object[] {"random@example.com"}, new UserRowMapper())).thenReturn(users);
		List<User> result = dao.getUserForEmail("random@example.com");
		assertNotNull(result);
	}
	
	@Test
	public void addUser() {
		User user = getUser();
		Object[] params = new Object[] {user.getUid(), user.getFirstName(), user.getLastName(), user.getWebLoginId(), user.getPassword(), user.getFailedLoginAttempt(), user.getCurrentOffice(), user.getRole().label };
	
		when(jdbcTemplate.update(ADD_USER, params)).thenReturn(1);
		User result = dao.addUser(user);
		assertNotNull(result);
	}
	
	@Test
	public void deleteUser() {
		when(jdbcTemplate.update(DELETE_USER+1)).thenReturn(1);
		int result = dao.deleteUser(1);
		assertNotNull(result);
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
