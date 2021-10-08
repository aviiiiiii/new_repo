$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/form.feature");
formatter.feature({
  "name": "Form",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Filling the form",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is in the protoCommerce page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.formSteps.user_is_in_the_protoCommerce_page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Filling the form");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User enters the all the details",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.formSteps.user_enters_the_all_the_details()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "Filling the form");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User clicks the Submit button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.formSteps.user_clicks_the_Submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png", "Filling the form");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User receives a success message",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.formSteps.user_receives_a_success_message()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png", "Filling the form");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});