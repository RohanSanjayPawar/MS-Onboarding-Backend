package com.ms.au.onboarding_portal.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * Instantiates a new user logs.
 * 
 * @author Rohan Pawar
 */
@Getter
@Setter
public class UserLogs {
	
	/** The uid. */
	private int uid;
	
	/** The user name. */
	private String userName;
	
	/** The description. */
	private String description;
	
	/** The created at. */
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date createdAt;
}
