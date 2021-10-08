$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/shopping.feature");
formatter.feature({
  "name": "Shopping Cart Automation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Entering Keyword and Selecting items",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is in the homePage",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_is_in_the_homePage()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Entering Keyword and Selecting items");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User enters keyword and selects items",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_enters_keyword_and_selects_items()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "Entering Keyword and Selecting items");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User checkout",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_checkout()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png", "Entering Keyword and Selecting items");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User is taken to Order Summary Page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_is_taken_to_Order_Summary_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png", "Entering Keyword and Selecting items");
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Apply coupon and place order",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is in the Order Summary page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_is_in_the_Order_Summary_page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded4.png", "Apply coupon and place order");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User Verifies the items and applies coupon code",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_Verifies_the_items_and_applies_coupon_code()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded5.png", "Apply coupon and place order");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User places the order",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_places_the_order()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded6.png", "Apply coupon and place order");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User is taken to final page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_is_taken_to_final_page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded7.png", "Apply coupon and place order");
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Agreeing Terms and Conditions and Confirm order",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is in Final page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_is_in_Final_page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded8.png", "Agreeing Terms and Conditions and Confirm order");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User Selects the country and Agrees to terms and conditions",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_Selects_the_country_and_Agrees_to_terms_and_conditions()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded9.png", "Agreeing Terms and Conditions and Confirm order");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User confirms the order",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_confirms_the_order()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded10.png", "Agreeing Terms and Conditions and Confirm order");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User receives a confirmation msg",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.addingSteps.user_receives_a_confirmation_msg()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded11.png", "Agreeing Terms and Conditions and Confirm order");
formatter.afterstep({
  "status": "passed"
});
});