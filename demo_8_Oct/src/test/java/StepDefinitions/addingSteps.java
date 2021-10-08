package StepDefinitions;

import AppHooks.hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.finalPage;
import pages.homePage;
import pages.orderSummaryPage;

import java.util.List;


public class addingSteps {
    static WebDriver driver = null;
    homePage home;
    orderSummaryPage orderSummary;
    finalPage finalpage;
    List<String> items1,items2;

    public static WebDriver getDriver(){
        return driver;
    }

    //Scenario 1 : Entering Keyword and Selecting items

    @Given("User is in the homePage")
    public void user_is_in_the_homePage() {
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Assert.assertEquals("GreenKart - veg and fruits kart",driver.getTitle());
        System.out.println("INFO : User is present in the Homepage");
    }

    @When("User enters keyword and selects items")
    public void user_enters_keyword_and_selects_items() throws InterruptedException {
        home=new homePage(driver);
        home.enter_keyword("po");
        Thread.sleep(1000);
        items1=home.select_items();
        System.out.println(items1);
        System.out.println("INFO : User entered keyword and selected items");

    }


    @And("User checkout")
    public void user_checkout() {
        home.checkout();
        System.out.println("INFO : User checkout to next page");
    }

    @Then("User is taken to Order Summary Page")
    public void user_is_taken_to_Order_Summary_Page() throws InterruptedException {
        Thread.sleep(1000);
        orderSummary=new orderSummaryPage(driver);
        orderSummary.in_orderSummaryPage();
        System.out.println("INFO : User is now in Order Summary Page");

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Scenario 2 : Apply coupon and place order
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("User is in the Order Summary page")
    public void user_is_in_the_Order_Summary_page() {
        orderSummary=new orderSummaryPage(driver);
        orderSummary.in_orderSummaryPage();
        System.out.println("INFO : User is now in Order Summary Page");

    }

    @When("User Verifies the items and applies coupon code")
    public void user_Verifies_the_items_and_applies_coupon_code() throws InterruptedException {
        System.out.println(orderSummary.verify_items());
        System.out.println("INFO : Items verified");
        orderSummary.apply_promoCode("rahulshettyacademy");
        System.out.println("INFO : Coupon Applied");
        System.out.println("INFO : Final Price is "+orderSummary.get_finalPrice());

    }
    @And("User places the order")
    public void user_places_the_order() {
        orderSummary.place_order();
        System.out.println("INFO : Order Placed");
    }

    @Then("User is taken to final page")
    public void user_is_taken_to_final_page() {
        finalpage=new finalPage(driver);
        finalpage.user_in_finalPage();
        System.out.println("INFO : User confirms he is in final page");
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Scenario 3 : Agreeing Terms and Conditions and Confirm order
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   @Given("User is in Final page")
    public void user_is_in_Final_page() {
        finalpage=new finalPage(driver);
        finalpage.user_in_finalPage();
        System.out.println("INFO : User confirms he is in final page");


    }

    @When("User Selects the country and Agrees to terms and conditions")
    public void user_Selects_the_country_and_Agrees_to_terms_and_conditions() {
        finalpage.select_country("India");
        finalpage.agree_to_TandC();
        System.out.println("INFO : User Selected and Agreed to T&C");
    }
    @And("User confirms the order")
    public void user_confirms_the_order() {
        finalpage.confirm_order();
        System.out.println("INFO : User CONFIRMED the order");

    }
    @Then("User receives a confirmation msg")
    public void user_receives_a_confirmation_msg() throws InterruptedException {
        finalpage.checkMsg("your order has been placed successfully");
        System.out.println("INFO : Order placed SUCCESSFULLY");
    }

}

