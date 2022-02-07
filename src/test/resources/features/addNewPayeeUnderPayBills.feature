Feature: Add new payee under bills

  Background: Login Step
    Given User is on the login page
    And User enters username "username" and password "password"

    @wip @regression
  Scenario: Add a new payee

    Given User is on the pay bills page
    And Add New Payee tab
    And creates new payee using following information:
    |Payee name |The law Offices of Hyde, Price & Scharks|
    |Payee Address   |100 Same st, Anytown, USA, 10001|
    |Account         |Checking                        |
    |Payee details   | XYZ account                    |
    Then message "The new payee The law Offices of Hyde, Price & Scharks was successfully created." should be displayed


