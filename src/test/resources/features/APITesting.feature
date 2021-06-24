Feature: API Testing - GET & DELETE Request Test

Scenario Outline: Verify User Able To Get Employee Details Successfully By Using GET Request

	Given I Form API Request for Employee Details with ID as 2 and "<Endpoints>" as Endpoints For Test Execution
	Then I Verify Success Code from Server Successfully

@APITest
Examples:
| Endpoints | 
| employee  |

Scenario Outline: Verify User Able To Delete Employee From Server Successfully By Using DELETE Request

	Given I Form API Request to Delete an Employee with ID as 2 and "<Endpoints>" as Endpoints For Test Execution
	Then I Verify Employee Details Removed from Server Successfully

@APITest
Examples:
| Endpoints | 
| delete    |  