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

import com.ms.au.onboarding_portal.dao.impl.DemandDAOImpl;
import com.ms.au.onboarding_portal.model.Demand;
import com.ms.au.onboarding_portal.model.Onboardee;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DemandController.class)
public class DemandControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DemandDAOImpl dao;

	@Test
	public void findAllDemands() throws Exception {
		List<Demand> demands = new ArrayList<>();
		demands.add(getDemand());

		when(dao.getDemands()).thenReturn(demands);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/demand/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void findAllDemandsWithUID() throws Exception {
		List<Demand> demands = new ArrayList<>();
		demands.add(getDemand());

		when(dao.getAllDemand(1)).thenReturn(demands);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/demand/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void filterDemands() throws Exception {
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

		List<Demand> demands = new ArrayList<>();
		demands.add(getDemand());

		String json = "{\"uid\": 1,\"firstName\": \"Loren\",\"lastName\": \"Ipsum\",\"webLoginId\": \"A\",\"joiningLocation\": \"H\",\"skillSet\": [\"Java\", \"Spring\"],\"experience\": 10, \"hiringManager\": \"C\",\"demandId\": 1, \"status\": \"D\", \"backgroundCheckStatus\": \"A\",\"etaForOnboarding\": 10}";

		when(dao.getFilteredDemands(1, onboardee)).thenReturn(demands);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/demand/1").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void addDemand() throws Exception {
		Demand demand = getDemand();

		when(dao.addDemand(demand)).thenReturn(demand);

		String json = "{\"uid\": 1,\"location\": \"Mumbai\",\"address\": \"Athenm, Goregaon\",\"role\": \"Full Stack Developer\", \"requirements\": [\"Java\", \"Spring\" ],\"experience\": 4, \"total\": 16,\"inProcess\": 0}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/demand/add").accept(MediaType.APPLICATION_JSON)
				.content(json).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void deleteDemnad() throws Exception {
		String json = "";

		when(dao.deleteDemand(1)).thenReturn(1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/demand/delete/1")
				.accept(MediaType.APPLICATION_JSON).content(json).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}
	
	@Test
	public void updateDemnad() throws Exception {
		String json = "";

		when(dao.updateDemand(1)).thenReturn(1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/demand/update/1")
				.accept(MediaType.APPLICATION_JSON).content(json).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}
	
	@Test
	public void deleteOnboardee() throws Exception {
		String json = "";

		when(dao.deleteOnboardee(1)).thenReturn(1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/demand/delete-onboardee/1")
				.accept(MediaType.APPLICATION_JSON).content(json).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
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
}
