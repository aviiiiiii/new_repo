Feature: Shopping Cart Automation



  Scenario: Entering Keyword and Selecting items
    Given User is in the homePage
    When User enters keyword and selects items
    And User checkout
    Then User is taken to Order Summary Page

  Scenario: Apply coupon and place order
    Given User is in the Order Summary page
    When User Verifies the items and applies coupon code
    And User places the order
    Then User is taken to final page

  Scenario: Agreeing Terms and Conditions and Confirm order
    Given User is in Final page
    When User Selects the country and Agrees to terms and conditions
    And User confirms the order
    Then User receives a confirmation msg
