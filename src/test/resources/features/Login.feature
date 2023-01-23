@Login
Feature: Login to the OrangeHRM App
  Scenario: Login with correct credentials
    Given I open the OrangeHRM login page
    When I enter "Admin" as username and "admin123" as password
    And I click on the Login button
    Then I can access to the admin page