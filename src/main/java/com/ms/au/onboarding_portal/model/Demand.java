package com.ms.au.onboarding_portal.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Instantiates a new demand.
 * 
 * @author Rohan Pawar
 */
@Getter
@Setter
public class Demand {
	
	/** The uid. */
	private int uid;
	
	/** The location. */
	private String location;
	
	/** The address. */
	private String address;
	
	/** The role. */
	private String role;
	
	/** The requirements. */
	private List<String> requirements;
	
	/** The experience. */
	private int experience;
	
	/** The total. */
	private int total;
	
	/** The in process. */
	private int inProcess;
}
