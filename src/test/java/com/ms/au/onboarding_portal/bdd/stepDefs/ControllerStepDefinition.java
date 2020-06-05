package com.ms.au.onboarding_portal.bdd.stepDefs;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ms.au.onboarding_portal.enums.UserRolesEnum;
import com.ms.au.onboarding_portal.model.Demand;
import com.ms.au.onboarding_portal.model.Onboardee;
import com.ms.au.onboarding_portal.model.User;
import com.ms.au.onboarding_portal.model.UserLogs;

import io.cucumber.java8.En;
import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
@CucumberContextConfiguration
public class ControllerStepDefinition implements En {
	
	@Autowired
	private MockMvc mockMvc;
	
	List<User> users;
	List<UserLogs> userLogs;
	List<Demand> demands;
	List<Onboardee> onboardees;
	String response;
	MvcResult result;
	
	public ControllerStepDefinition() {
		Given("No users present", () -> {
			users = new ArrayList<>();
			users.add(getUser());
		});
		
		Given("No user logs present", () -> {
			userLogs = new ArrayList<>();
			userLogs.add(getUserLogs());
		});
		
		Given("No demands present", () -> {
			demands = new ArrayList<>();
			demands.add(getDemand());
		});
		
		Given("No onboardees present", () -> {
		    onboardees = new ArrayList<>();
		    onboardees.add(getOnboardee());
		});
		
		When("Client goes to {string} userAPI", (String string) -> {
			result = mockMvc.perform(get(string))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn();
		});
		
		When("Client goes to {string} userAPI with {string} email", (String api, String email) -> {
			result = mockMvc.perform(get(api))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn();
		});
		
		When("Client goes to {string} userAPI to add user", (String api) -> {
			String json = "{\"uid\": 1, \"firstName\": \"Ruchi\", \"lastName\": \"Pawar\", \"webLoginId\": \"ruchi.sanjaypawar@accoliteindia.com\", \"password\": \"abc@123\", \"failedLoginAttempt\": 0, \"lastLoginAt\": null, \"createdAt\": null, \"updateAt\": null, \"currentOffice\": \"Mumbai\", \"role\": \"MANAGER\" }";
			result = mockMvc.perform(put(api).accept(MediaType.APPLICATION_JSON).content(json))
            .andReturn();
		});
		
		When("Client goes to {string} userLogsAPI", (String string) -> {
			result = mockMvc.perform(get(string))
            .andReturn();
		});
		
		
		When("Client goes to {string} userAPI to add user-log", (String api) -> {
			String json = "{\"uid\": 1,\"userName\": \"ABC\", \"description\": \"Added Onboardee!\", \"createdAt\": \"2020-05-04T12:34:21\"}";
			result = mockMvc.perform(put(api).accept(MediaType.APPLICATION_JSON).content(json))
            .andReturn();
		});
		
		When("Client goes to {string} demandAPI for a user", (String string) -> {
			result = mockMvc.perform(get(string))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn();
		});
		
		When("Client goes to {string} demandAPI", (String string) -> {
			result = mockMvc.perform(get(string))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn();
		});
		
		When("Client goes to {string} demandAPI to add a demand", (String api) -> {
			String json = "{\"uid\": 1,\"location\": \"Mumbai\",\"address\": \"Athenm, Goregaon\",\"role\": \"Full Stack Developer\", \"requirements\": [\"Java\", \"Spring\" ],\"experience\": 4, \"total\": 16,\"inProcess\": 0}";
			result = mockMvc.perform(put(api).accept(MediaType.APPLICATION_JSON).content(json))
            .andReturn();
		});
		
		When("Client goes to {string} onboardeeAPI", (String string) -> {
			result = mockMvc.perform(get(string))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn();
		});
		
		When("Client goes to {string} onboardeeAPI to add an onboardee", (String api) -> {
			String json = "{\"uid\": 1,\"firstName\": \"Loren\",\"lastName\": \"Ipsum\",\"webLoginId\": \"A\",\"joiningLocation\": \"H\",\"skillSet\": [\"Java\", \"Spring\"],\"experience\": 10, \"hiringManager\": \"C\",\"demandId\": 1, \"status\": \"D\", \"backgroundCheckStatus\": \"A\",\"etaForOnboarding\": 10}";
			result = mockMvc.perform(put(api).accept(MediaType.APPLICATION_JSON).content(json))
            .andReturn();
		});
		
		Then("Client gets {string}", (String string)-> {
			assertNotNull(result.getResponse().getContentAsString());
		});
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
	
	public UserLogs getUserLogs() {
		UserLogs log = new UserLogs();
		log.setUid(1);
		log.setDescription("TEST");
		log.setUserName("Loren Ipsum");

		return log;
	}
	
	public Demand getDemand() {
		Demand demand = new Demand();
		demand.setUid(1);
		demand.setAddress("A");
		demand.setExperience(10);
		demand.setInProcess(0);
		demand.setLocation("B");
		List<String> list = new ArrayList<>();
		list.add("Java");
		demand.setRequirements(list);
		demand.setRole("C");
		demand.setTotal(20);

		return demand;
	}
	
	public Onboardee getOnboardee() {
		Onboardee onboardee = new Onboardee();
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("Spring");

		onboardee.setBackgroundCheckStatus("A");
		onboardee.setDemandId(1);
		onboardee.setEtaForOnboarding(10);
		onboardee.setExperience(10);
		onboardee.setFirstName("Loren");
		onboardee.setHiringManager("C");
		onboardee.setJoiningLocation("H");
		onboardee.setLastName("Ipsum");
		onboardee.setSkillSet(list);
		onboardee.setStatus("D");
		onboardee.setUid(1);
		onboardee.setWebLoginId("A");

		return onboardee;
	}
}
