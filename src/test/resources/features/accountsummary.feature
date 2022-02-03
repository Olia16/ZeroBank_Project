
Feature: Account Summary

  Background: Login step
    Given User is on the login page
    And User enters username "username" and password "password"
  @smoke
  Scenario: Verifying Account Summary Tab
    Then Account summary page should be displayed and have the title "Zero - Account Summary"
    And Account summary page should have following account types:
      |Cash Accounts|
      |Investment Accounts|
      |Credit Accounts|
      |Loan Accounts|
    And Credit Accounts table must have following columns:
      | Account     |
      | Credit Card |
      | Balance     |
