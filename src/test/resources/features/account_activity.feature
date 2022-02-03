Feature: Account Activity functions

  Background: Login Step
    Given User is on the login page
    And User enters username "username" and password "password"

  @activity @smoke
  Scenario: Account activity features
    And the user navigates to Account Activity page
    Then the "Zero - Account Activity" page should be displayed
    And Account drop down should have "Savings" selected
    Then Account drop down should have the following options
      | Credit Card |
      | Savings     |
      | Loan        |
      | Checking    |
      | Brokerage   |
    And Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |







