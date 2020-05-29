package com.ms.au.onboarding_portal.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date lastLoginAt;
	
	/** The created at. */
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date createdAt;
	
	/** The update at. */
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date updateAt;
	
	/** The current office. */
	private String currentOffice;
	
	/** The role. */
	private UserRolesEnum role;
}
