package com.ms.au.onboarding_portal.model;

import java.sql.Date;

import com.ms.au.onboarding_portal.enums.UserRolesEnum;

import lombok.Data;

/**
 * Instantiates a new user.
 * 
 * @author Rohan Pawar
 */
@Data
public class User{
	
	/** The uid. */
	private int uid;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The web login id. */
	private String webLoginId;
	
	/** The password. */
	private String password;
	
	/** The failed login attempt. */
	private int failedLoginAttempt;
	
	/** The last login at. */
	private Date lastLoginAt;
	
	/** The created at. */
	private Date createdAt;
	
	/** The update at. */
	private Date updateAt;
	
	/** The current office. */
	private int currentOffice;
	
	/** The role. */
	private UserRolesEnum role;
}
