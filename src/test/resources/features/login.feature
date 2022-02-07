Feature: Login

  Background: Login step
    Given User is on the login page

  @positive   @regression
  Scenario: Only authorized users should be able to login to the application.
    When  User enters username "username" and password "password"
    Then  "Zero - Account Summary" page should be displayed

  @negative @regression
  Scenario Outline: Unauthorized users should NOT be able to login to the application.
    When  User enters username "<username_column>" and password "<password_column>"
    Then  error message "Login and/or password are wrong." should be displayed
    Examples:
      | username_column | password_column |
      | username        | wrong           |
      | wrong           | password        |
      | username        |                 |
      |                 | password        |




