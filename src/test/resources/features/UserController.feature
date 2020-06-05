Feature: Test User Features  	
  
  Scenario: View all the user logs
    Given No user logs present
    When Client goes to "/api/user/" userAPI
    Then Client gets "list of users"
    
  Scenario: View all the users based on email
    Given No users present
    When Client goes to "/api/user/random@example.com" userAPI with "random.example.com" email
    Then Client gets "list of users"
    
  Scenario: Add user to the portal
  	Given No users present
  	When Client goes to "/api/user/add" userAPI to add user
  	Then Client gets "a user"
