Feature: Test User Logs Features

	Scenario: View all the users
    Given No user logs present
    When Client goes to "/api/user-logs/" userLogsAPI
    Then Client gets "list of user logs"
    
  Scenario: Add user log to the portal
  	Given No user logs present
  	When Client goes to "/api/user-logs/add" userAPI to add user-log
  	Then Client gets "added user log"
