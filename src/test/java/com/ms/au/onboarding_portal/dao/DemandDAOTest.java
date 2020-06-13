package com.ms.au.onboarding_portal.dao;

import static com.ms.au.onboarding_portal.queries.DemandQueries.ADD_DEMAND;
import static com.ms.au.onboarding_portal.queries.DemandQueries.ALL_DEMANDS;
import static com.ms.au.onboarding_portal.queries.DemandQueries.DELETE_DEMAND;
import static com.ms.au.onboarding_portal.queries.DemandQueries.DELETE_ONBOARDEE;
import static com.ms.au.onboarding_portal.queries.DemandQueries.FETCH_ALL_DEMANDS;
import static com.ms.au.onboarding_portal.queries.DemandQueries.UPDATE_DEMAND;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ms.au.onboarding_portal.dao.impl.DemandDAOImpl;
import com.ms.au.onboarding_portal.model.Demand;
import com.ms.au.onboarding_portal.model.Onboardee;
import com.ms.au.onboarding_portal.row_mapper.DemandRowMapper;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DemandDAOTest {
	@InjectMocks
    DemandDAOImpl dao;
     
    @Mock
    JdbcTemplate jdbcTemplate;
	
    @Test
	public void findAllDemands() {
		List<Demand> demands = new ArrayList<>();
		demands.add(getDemand());

		when(jdbcTemplate.query(ALL_DEMANDS, new DemandRowMapper())).thenReturn(demands);
		List<Demand> result = dao.getDemands();
		assertNotNull(result);
	}
    
    @Test
   	public void findAllDemandsWithUID() {
   		List<Demand> demands = new ArrayList<>();
   		demands.add(getDemand());

   		when(jdbcTemplate.query(FETCH_ALL_DEMANDS+1, new DemandRowMapper())).thenReturn(demands);
   		List<Demand> result = dao.getAllDemand(1);
   		assertNotNull(result);
   	}
    
    @Test
    public void filterDemand() {
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
		
		when(dao.filterDemands(list, 10)).thenReturn(demands);
		List<Demand> result = dao.getFilteredDemands(1, onboardee);
   		assertNotNull(result);
    }
    
    @Test
    public void addDemand() {
    	Demand demand = getDemand();
    	when(jdbcTemplate.update(ADD_DEMAND, dao.getUid(), demand.getLocation(), demand.getAddress(), dao.listToString(demand.getRequirements()), demand.getExperience(), demand.getRole(), demand.getTotal(), demand.getInProcess())).thenReturn(1);
    	
    	Demand result = dao.addDemand(demand);
    	assertNotNull(result);
    }
    
    @Test 
    public void deleteDemand() {
    	when(jdbcTemplate.update(DELETE_DEMAND + 1)).thenReturn(1);
    	
    	int result = dao.deleteDemand(1);
    	assertNotNull(result);
    }
    
    @Test 
    public void updateDemand() {
    	when(jdbcTemplate.update(UPDATE_DEMAND + 1)).thenReturn(1);
    	
    	int result = dao.updateDemand(1);
    	assertNotNull(result);
    }
    
    @Test 
    public void deleteOnboardee() {
    	when(jdbcTemplate.update(DELETE_ONBOARDEE + 1)).thenReturn(1);
    	
    	int result = dao.updateDemand(1);
    	assertNotNull(result);
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
