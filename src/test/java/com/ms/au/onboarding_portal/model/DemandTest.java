package com.ms.au.onboarding_portal.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ms.au.onboarding_portal.PojoTestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemandTest {
	@Test
    public void testAccesors_shouldAccessProperField() {
        PojoTestUtil.validateAccessors(Demand.class);
    }
}
