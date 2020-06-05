Feature: Test MS Onboardees Features

	Scenario: View all the onboardees
    Given No onboardees present
    When Client goes to "/api/onboardee/" onboardeeAPI
    Then Client gets "list of onboardees"
  	
  Scenario: Add an onboardee for a manager
  	Given No onboardees present
  	When Client goes to "/api/onboardee/add" onboardeeAPI to add an onboardee
  	Then Client gets "a onboardee"
