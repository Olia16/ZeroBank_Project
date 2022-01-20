
  Feature: Pay Bills
    Background: Login step
      Given User is on the login page
      When  User enters username "username" and password "password"
    @paybills
    Scenario: User should be able to pay bills when all the required bills are fill accurately
      Given User is on the pay bills page
      And the "Zero - Pay Bills" title is displayed
      When User click on payee box and select "Bank of America"
      And User clicks on account box and selects "Checking"
      And User clicks on amount box and enters "1000"
      And User click on date box and enters "2022-01-20"
      And User clicks on description box and enters "Hey "
      When User clicks on Pay button
      Then "The payment was successfully submitted." should be displayed