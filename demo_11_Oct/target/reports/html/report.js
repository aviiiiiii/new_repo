$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/shopping.feature");
formatter.feature({
  "name": "Shopping cart",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Login",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is in the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.steps.user_is_in_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Verifying the order");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User enters the name and password",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.steps.user_enters_the_name_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "Verifying the order");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User is taken to the home page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.steps.user_is_taken_to_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png", "Verifying the order");
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Verifying the order",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is in Checkout page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.steps.user_is_in_Checkout_page()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png", "Verifying the order");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User selects address",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.steps.user_selects_address()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded4.png", "Verifying the order");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User selects payment mode",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.steps.user_selects_payment_mode()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//input[@id\u003d\u0027pp-MuS32i-102\u0027]\"}\n  (Session info: chrome\u003d94.0.4606.71)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027AVI\u0027, ip: \u0027192.168.0.93\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002715.0.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 94.0.4606.71, chrome: {chromedriverVersion: 94.0.4606.41 (333e85df3c9b6..., userDataDir: C:\\Users\\Avinash\\AppData\\Lo...}, goog:chromeOptions: {debuggerAddress: localhost:64819}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: f7aae693b44cad0a27629c83e394a0b5\n*** Element info: {Using\u003dxpath, value\u003d//input[@id\u003d\u0027pp-MuS32i-102\u0027]}\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:64)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy20.isDisplayed(Unknown Source)\r\n\tat pages.checkoutPage.select_bank(checkoutPage.java:40)\r\n\tat StepDefinitions.steps.user_selects_payment_mode(steps.java:93)\r\n\tat ✽.User selects payment mode(file:///I:/IntelliJ%20Projects/demo_11_Oct/src/test/resources/Features/shopping.feature:16)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded5.png", "Verifying the order");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});