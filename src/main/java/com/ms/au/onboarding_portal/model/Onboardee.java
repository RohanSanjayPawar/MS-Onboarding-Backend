package com.ms.au.onboarding_portal.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Instantiates a new onboardee.
 * 
 * @author Rohan Pawar
 */
@Getter
@Setter
public class Onboardee {
	
	/** The uid. */
	private int uid;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The web login id. */
	private String webLoginId;
	
	/** The joining location. */
	private String joiningLocation;
	
	/** The skill set. */
	private List<String> skillSet;
	
	/** The experience. */
	private int experience;
	
	/** The hiring manager. */
	private String hiringManager;
	
	/** The demand id. */
	private int demandId;
	
	/** The status. */
	private String status;
	
	/** The backgorund check status. */
	private String backgroundCheckStatus;
	
	/** The eta for onboarding. */
	private int etaForOnboarding;
}
