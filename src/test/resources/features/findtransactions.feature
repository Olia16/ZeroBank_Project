Feature: Find Transactions in Account Activity

  Background: Login and navigate to Account Activity Page
    Given User is on the login page
    And User enters username "username" and password "password"
    And the user navigates to Account Activity page

  Scenario: Search date range
    Given the user accesses the Find Transactions tab
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"

  Scenario Outline: Search description
    Given the user accesses the Find Transactions tab
    When the user enters description "<input>"
    And clicks search
    Then results table should only show descriptions containing "<correct description>"
    But results table should not show descriptions containing "<wrong description>"
    Examples:
      | input  | correct description | wrong description |
      | online | ONLINE              | office            |
      | office | OFFICE              | online            |

  Scenario Outline: Type
    Given the user accesses the Find Transactions tab
    And clicks search
    Then results table should show at least one result under "<type>" and "<other type>"
    When user selects type "<type>"
    And clicks search
    Then results table should show at least one result under "<type>"
    But results table should show no result under "<other type>"
    Examples:
      | type       | other type |
      | Deposit    | Withdrawal |
      | Withdrawal | Deposit    |

