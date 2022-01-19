Feature: Login

  Background: Login step
    Given User is on the login page

  @positive
  Scenario: Only authorized users should be able to login to the application.
    When  User enters username "username" and password "password"
    Then  "Zero - Account Summary" page should be displayed



