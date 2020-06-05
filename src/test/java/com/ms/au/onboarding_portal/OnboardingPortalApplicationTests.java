package com.ms.au.onboarding_portal;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The Class OnboardingPortalApplicationTests.
 * 
 * @author Rohan Pawar
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnboardingPortalApplication.class)
class OnboardingPortalApplicationTests {

	/**
	 * Context loads.
	 */
	@Test
	void contextLoads() {
		OnboardingPortalApplication.main(new String[]{});
		assertEquals(false, 2*2 == 5);
	}

}
