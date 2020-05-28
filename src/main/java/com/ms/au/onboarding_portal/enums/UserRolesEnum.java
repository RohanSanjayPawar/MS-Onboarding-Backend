package com.ms.au.onboarding_portal.enums;

/**
 * The Enum UserRolesEnum.
 * 
 * @author Rohan Pawar
 */
public enum UserRolesEnum {
	
	/** The admin. */
	ADMIN("ADMIN"),
	
	/** The manager. */
	MANAGER("MANAGER");
	
	/** The label. */
	public final String label;
	
    /**
     * Instantiates a new user roles enum.
     *
     * @param label the label
     */
    private UserRolesEnum(String label) {
        this.label = label;
    }
}
