Feature: Verify login function completely

Scenario: Login function with valid data
Given Openbrowser and enter url
When User enter valid username
When User enter valid password
When User click on login button
Then It should navigate to dashboard page




