Feature: Shopping cart
   Background: Login
     Given User is in the login page
     When User enters the name and password
     Then User is taken to the home page

  Scenario: Searching and Adding items
    Given User is in the home page
    When User enters keyword and Select the items
    And User adds the item and proceed to cart
    Then User is taken to Checkout page

  Scenario: Verifying the order
    Given User is in Checkout page
    When  User selects address
    And User selects payment mode
   Then User is given a Order Summary
