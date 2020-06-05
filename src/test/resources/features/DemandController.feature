Feature: Test MS Demand Features

	Scenario: View all the demands
    Given No demands present
    When Client goes to "/api/demand/" demandAPI
    Then Client gets "list of demands"
    
  Scenario: View all the demands for a manager
  	Given No demands present
  	When Client goes to "/api/demand/1" demandAPI for a user
  	Then Client gets "list of demands"
  	
  Scenario: Add a demand for a manager
  	Given No demands present
  	When Client goes to "/api/demand/add" demandAPI to add a demand
  	Then Client gets "a demand"
