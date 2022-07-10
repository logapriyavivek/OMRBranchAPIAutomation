@ChangeProfilePic
Feature: ChangeProfilePic Module API automation

  Scenario: Verify to ChangeProfilePic to the application through API
    Given User add headers and bearer authorization and multipart/form-data for accessing ChangeProfilePic endpoints
    When User send "POST" request for ChangeProfilePic
    Then User verify the status code is 200
    And User verify the ChangeProfilePic response message matches with "Profile updated Successfully"