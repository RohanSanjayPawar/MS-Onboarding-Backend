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

import com.ms.au.onboarding_portal.dao.impl.OnboardeeDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OnbaordeeDAOTest {
	@Autowired
	private OnboardeeDAOImpl onboardeeDao;
	
	@Test
	public void listToString() {
		List<String> skills = new ArrayList<>();
		skills.add("Java");
		String result = onboardeeDao.listToString(skills);
		assertNotNull(result);
		assertTrue(result.equals("[\"Java\"]"));
	}
	
	@Test
	public void getUid() {
		int uid = onboardeeDao.getUid();
		assertNotNull(uid);
		assertTrue(uid > 200);
	}
}
