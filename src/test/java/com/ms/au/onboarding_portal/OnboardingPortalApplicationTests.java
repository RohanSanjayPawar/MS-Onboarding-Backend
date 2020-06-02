package com.ms.au.onboarding_portal;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnboardingPortalApplicationTests {

	@Test
	void contextLoads() {
		boolean result = 2*3 == 2;
		assertEquals(false, result);
	}

}
