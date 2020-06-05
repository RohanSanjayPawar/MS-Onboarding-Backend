package com.ms.au.onboarding_portal.queries;

/**
 * The Class OnboardeeQueries.
 * 
 * @author Rohan Pawar
 */
public class OnboardeeQueries {
	
	/** The Constant FETCH_ALL_ONBOARDEE. */
	public static final String FETCH_ALL_ONBOARDEE = "SELECT * FROM ONBOARDEE o1 JOIN USER_DEMAND o2 ON o1.DEMAND = o2.UID JOIN USER o3 ON o2.USER_UID = o3.UID JOIN DEMAND o4 ON o4.UID = o2.DEMAND_UID AND o1.DELETED = FALSE";
	
	/** The Constant ALL_ONBOARDEE. */
	public static final String ALL_ONBOARDEE = "SELECT * FROM ONBOARDEE o1 JOIN USER_DEMAND o2 ON o1.DEMAND = o2.UID JOIN USER o3 ON o2.USER_UID = o3.UID JOIN DEMAND o4 ON o4.UID = o2.DEMAND_UID";
	
	/** The Constant SEARCH_ONBOARDEE. */
	public static final String SEARCH_ONBOARDEE = "SELECT * FROM ONBOARDEE o1 JOIN USER_DEMAND o2 ON o1.DEMAND = o2.UID JOIN USER o3 ON o2.USER_UID = o3.UID JOIN DEMAND o4 ON o4.UID = o2.DEMAND_UID AND o1.DELETE = FALSE"; 
	
	/** The Constant DELETE_ONBOARDEE. */
	public static final String DELETE_ONBOARDEE = "UPDATE ONBOARDEE o SET o.DELETED = b'1' WHERE `UID` = ?";
	
	/** The Constant UPDATE_ONBOARDEE. */
	public static final String UPDATE_ONBOARDEE = "UPDATE ONBOARDEE o SET o.FIRST_NAME=?, o.LAST_NAME=?, o.WEB_LOGIN_ID=?, o.STATUS=?, o.BG_STATUS=?, o.ETA_FOR_ONBOARDING=?, o.EXPERIENCE=? WHERE o.UID=?";
	
	/** The Constant ADD_ONBOARDEE. */
	public static final String ADD_ONBOARDEE = "INSERT INTO ONBOARDEE(UID, FIRST_NAME, LAST_NAME, WEB_LOGIN_ID, SKILLS, DEMAND, STATUS, BG_STATUS, ETA_FOR_ONBOARDING, EXPERIENCE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	/**
	 * Instantiates a new onboardee queries.
	 */
	private OnboardeeQueries() { }
}
