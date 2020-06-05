package com.ms.au.onboarding_portal.dao;

import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.ADD_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.DELETE_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.FETCH_ALL_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.OnboardeeQueries.UPDATE_ONBOARDEE;
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

import com.ms.au.onboarding_portal.dao.impl.OnboardeeDAOImpl;
import com.ms.au.onboarding_portal.model.Onboardee;
import com.ms.au.onboarding_portal.row_mapper.OnboardeeRowMapper;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OnbaordeeDAOTest {
	@InjectMocks
    OnboardeeDAOImpl dao;
     
    @Mock
    JdbcTemplate jdbcTemplate;
    
    @Test
	public void getAllOnboardee() {
		List<Onboardee> onboardees = new ArrayList<>();
		onboardees.add(getOnboardee());

		when(jdbcTemplate.query(FETCH_ALL_ONBOARDEE, new OnboardeeRowMapper())).thenReturn(onboardees);
		List<Onboardee> result = dao.getAllOnboardee();
		assertNotNull(result);
	}
    
    @Test
    public void updateOnboardee() {
    	Onboardee onboardee = getOnboardee();
    	when(jdbcTemplate.update(UPDATE_ONBOARDEE, onboardee.getFirstName(), onboardee.getLastName(),
				onboardee.getWebLoginId(), onboardee.getStatus(), onboardee.getBackgroundCheckStatus(),
				onboardee.getEtaForOnboarding(), onboardee.getExperience(), onboardee.getUid())).thenReturn(1);
    	
    	Onboardee result = dao.updateOnboardee(onboardee);
    	assertNotNull(result);
    }
    
    @Test
    public void addOnboardee() {
    	Onboardee onboardee = getOnboardee();
    	when(jdbcTemplate.update(ADD_ONBOARDEE, dao.getUid(), onboardee.getFirstName(), onboardee.getLastName(),
				onboardee.getWebLoginId(), dao.listToString(onboardee.getSkillSet()), onboardee.getDemandId(),
				onboardee.getStatus(), onboardee.getBackgroundCheckStatus(), onboardee.getEtaForOnboarding(),
				onboardee.getExperience())).thenReturn(1);
    	
    	Onboardee result = dao.addOnboardee(onboardee);
    	assertNotNull(result);
    }
    
    @Test
	public void deleteOnboardee() {
		when(jdbcTemplate.update(DELETE_ONBOARDEE, 1)).thenReturn(1);
		int result = dao.deleteOnboardee(1);
		assertNotNull(result);
	}
	
	@Test
	public void listToString() {
		List<String> skills = new ArrayList<>();
		skills.add("Java");
		String result = dao.listToString(skills);
		assertNotNull(result);
		assertTrue(result.equals("[\"Java\"]"));
	}
	
	@Test
	public void getUid() {
		int uid = dao.getUid();
		assertNotNull(uid);
		assertTrue(uid > 200);
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
