@Login
Feature: Login Module API automation

  Scenario: Get User logtoken form login endpoint
    Given User add header
    And User add basic authentication for login
    When User Send "POST" request for login endpoint
    Then User verify the status code is 200
    And User verify the login response body firstname present as "Logapriya" and get the logtoken saved
