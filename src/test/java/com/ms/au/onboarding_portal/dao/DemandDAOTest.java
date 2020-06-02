package com.ms.au.onboarding_portal.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ms.au.onboarding_portal.dao.impl.DemandDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemandDAOTest {
	@Autowired
	private DemandDAOImpl demandDao;
	
	@Test
	public void listToString() {
		List<String> skills = new ArrayList<>();
		skills.add("Java");
		String result = demandDao.listToString(skills);
		System.out.println(result);
		assertNotNull(result);
		assertTrue(result.equals("[\"Java\"]"));
	}
}
