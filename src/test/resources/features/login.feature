Feature: Login
  Scenario: Only authorized users should be able to login to the application.

    Given User is on the login page
    When  User enters username "username" and password "password"
    Then  "Zero - Account Summary" page should be displayed


