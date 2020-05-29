package com.ms.au.onboarding_portal.queries;

/**
 * The Class OnboardeeQueries.
 * 
 * @author Rohan Pawar
 */
public class OnboardeeQueries {
	
	/** The Constant FETCH_ALL_ONBOARDEE. */
	public static final String FETCH_ALL_ONBOARDEE = "SELECT * FROM ONBOARDEE o1 JOIN USER_DEMAND o2 ON o1.DEMAND = o2.UID JOIN USER o3 ON o2.USER_UID = o3.UID JOIN DEMAND o4 ON o4.UID = o2.DEMAND_UID";
	
	/** The Constant SEARCH_ONBOARDEE. */
	public static final String SEARCH_ONBOARDEE = "SELECT * FROM ONBOARDEE o1 JOIN USER_DEMAND o2 ON o1.DEMAND = o2.UID JOIN USER o3 ON o2.USER_UID = o3.UID JOIN DEMAND o4 ON o4.UID = o2.DEMAND_UID"; 
	
	/**
	 * Instantiates a new onboardee queries.
	 */
	private OnboardeeQueries() { }
}
