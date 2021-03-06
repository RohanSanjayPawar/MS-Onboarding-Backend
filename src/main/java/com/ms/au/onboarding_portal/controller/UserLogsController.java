package com.ms.au.onboarding_portal.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.au.onboarding_portal.dao.impl.UserLogsDAOImpl;
import com.ms.au.onboarding_portal.model.UserLogs;

/**
 * The Class UserLogsController.
 * 
 * @author Rohan Pawar
 */
@RestController
@RequestMapping("/api/user-logs")
public class UserLogsController {
	
	private static final Logger logger = Logger.getLogger(UserLogsController.class.getName());
	
	/** The user logs DAO. */
	@Autowired
	public UserLogsDAOImpl userLogsDAO;
	
	/**
	 * Gets the user logs.
	 *
	 * @param uid the uid
	 * @return the user logs
	 */
	@GetMapping("/{uid}")
	public List<UserLogs> getUserLogs(@PathVariable(name="uid") int uid) {
		return userLogsDAO.getAllUserLogs(uid);
	}
	
	/**
	 * Adds the logs.
	 *
	 * @param uid the uid
	 * @param userLog the user log
	 * @return the response entity
	 */
	@PutMapping("/add/{uid}")
	public ResponseEntity<Void> addLogs(@PathVariable(name="uid") int uid, @RequestBody UserLogs userLog) {
		List<UserLogs> list = getUserLogs(uid);
		int n = list.size();
		userLog.setUid(uid*1000 + n+1);
		StringBuilder sb = new StringBuilder("User Log to be added: ");
		sb.append(userLog);
		String log = sb.toString();
		logger.info(log);
		userLogsDAO.insertLog(userLog, uid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
