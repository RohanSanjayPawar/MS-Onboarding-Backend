package com.ms.au.onboarding_portal.queries;

/**
 * The Class DemandQueries.
 * 
 * @author Rohan Pawar
 */
public class DemandQueries {
	
	/** The Constant DEMANDS. */
	public static final String ALL_DEMANDS = "SELECT * FROM USER_DEMAND u JOIN DEMAND d ON d.UID = u.DEMAND_UID JOIN USER o ON u.USER_UID=o.UID";
	
	/** The Constant FETCH_ALL_DEMANDS. */
	public static final String FETCH_ALL_DEMANDS = "SELECT * FROM USER_DEMAND u JOIN DEMAND d ON d.UID = u.DEMAND_UID JOIN USER o ON u.USER_UID=o.UID AND u.USER_UID=";
	
	/** The Constant ADD_DEMAND. */
	public static final String ADD_DEMAND = "INSERT INTO DEMAND(UID, OFFICE_LOCATION, OFFICE_ADDRESS, REQUIREMENTS, EXPERIENCE, DEMAND_PROFILE, TOTAL_DEMAND, IN_PROCESS) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	/** The Constant ADD_USER_DEMAND. */
	public static final String ADD_USER_DEMAND = "INSERT INTO USER_DEMAND(UID, USER_UID, DEMAND_UID) VALUES(?, ?, ?)";
	
	/** The Constant DELETE_DEMAND. */
	public static final String DELETE_DEMAND = "DELETE FROM DEMAND WHERE UID = ";
	
	/** The Constant UPDATE_DEMAND. */
	public static final String UPDATE_DEMAND = "UPDATE DEMAND SET TOTAL_DEMAND = TOTAL_DEMAND - 1 WHERE TOTAL_DEMAND > 0 AND UID=";
	
	/** The Constant DELETE_ONBOARDEE. */
	public static final String DELETE_ONBOARDEE = "UPDATE DEMAND SET TOTAL_DEMAND = TOTAL_DEMAND + 1 WHERE TOTAL_DEMAND > 0 AND UID=";
	
	/**
	 * Instantiates a new demand queries.
	 */
	private DemandQueries() {}
}
