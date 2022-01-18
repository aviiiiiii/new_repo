Feature: filling form
  Scenario: filling form
    Given User is in the form filling page
    When User enters the details
    And User clicks sumbit button
    Then User receives success msg