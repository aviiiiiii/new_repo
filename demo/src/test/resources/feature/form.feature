Feature: Form
  Scenario: Filling the form
    Given User is in the protoCommerce page
    When User enters the all the details
    And User clicks the Submit button
    Then User receives a success message
