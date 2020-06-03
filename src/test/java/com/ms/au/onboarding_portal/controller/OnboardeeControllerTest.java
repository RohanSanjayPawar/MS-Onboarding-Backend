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

import com.ms.au.onboarding_portal.dao.impl.OnboardeeDAOImpl;
import com.ms.au.onboarding_portal.model.Onboardee;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OnboardeeController.class)
public class OnboardeeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OnboardeeDAOImpl dao;

	@Test
	public void getAllOnboardee() throws Exception {
		List<Onboardee> onboardees = new ArrayList<>();
		onboardees.add(getOnboardee());

		when(dao.getAllOnboardee()).thenReturn(onboardees);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/onboardee/")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void addOnboardee() throws Exception {
		Onboardee onboardee = getOnboardee();

		when(dao.addOnboardee(onboardee)).thenReturn(onboardee);

		String json = "{\"uid\": 1,\"firstName\": \"Loren\",\"lastName\": \"Ipsum\",\"webLoginId\": \"A\",\"joiningLocation\": \"H\",\"skillSet\": [\"Java\", \"Spring\"],\"experience\": 10, \"hiringManager\": \"C\",\"demandId\": 1, \"status\": \"D\", \"backgroundCheckStatus\": \"A\",\"etaForOnboarding\": 10}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/onboardee/add")
				.accept(MediaType.APPLICATION_JSON).content(json).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void updateOnboardee() throws Exception {
		Onboardee onboardee = getOnboardee();

		when(dao.updateOnboardee(onboardee)).thenReturn(onboardee);

		String json = "{\"uid\": 1,\"firstName\": \"Loren\",\"lastName\": \"Ipsum\",\"webLoginId\": \"A\",\"joiningLocation\": \"H\",\"skillSet\": [\"Java\", \"Spring\"],\"experience\": 10, \"hiringManager\": \"C\",\"demandId\": 1, \"status\": \"D\", \"backgroundCheckStatus\": \"A\",\"etaForOnboarding\": 10}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/onboardee/update/1")
				.accept(MediaType.APPLICATION_JSON).content(json).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}
	
	@Test
	public void deleteOnboardee() throws Exception {
		String json = "";

		when(dao.deleteOnboardee(1)).thenReturn(1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/onboardee/delete/1")
				.accept(MediaType.APPLICATION_JSON).content(json).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
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

//{
//    "uid": 205,
//    "firstName": "Loren",
//    "lastName": "Ipsum",
//    "webLoginId": "loren@accoliteindia.com",
//    "joiningLocation": "Mumbai",
//    "skillSet": [
//        "Java",
//        "Spring"
//    ],
//    "hiringManager": "Ruchi Pawar",
//    "demandId": 2,
//    "status": "Not Started",
//    "backgroundCheckStatus": "Not Started",
//    "etaForOnboarding": 10
//}
