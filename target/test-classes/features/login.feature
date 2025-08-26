Feature: Login Functionality

  Scenario: Verify Login successful
    Given Launch the Browser
    And Navigate to the URL
    When Enter the username and password
    And Click on Login Button
    Then Login should be successful
    And verify dashboard
    Then Close the Browser

  Scenario: Verify Login unsuccessful
    Given Launch the Browser
    And Navigate to the URL
    When Enter the invalid username and password
    And Click on Login Button
    Then Login should be unsuccessful
    And verify dashboard
    Then Close the Browser