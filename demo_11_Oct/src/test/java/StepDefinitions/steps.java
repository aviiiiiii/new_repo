package StepDefinitions;

import AppHooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.checkoutPage;
import pages.homePage;
import pages.loginPage;
import pages.productPage;

import java.util.concurrent.TimeUnit;

public class steps {

    WebDriver driver;
    loginPage login;
    homePage home;
    productPage product;
    checkoutPage checkout;


    String prodName;



    @Given("User is in the login page")
    public void user_is_in_the_login_page() throws InterruptedException {
        driver= Hooks.getWebDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
        System.out.println("INFO : User is present in the "+driver.getTitle()+" page");
    }

    @When("User enters the name and password")
    public void user_enters_the_name_and_password() throws InterruptedException {
        login=new loginPage(driver);
        login.enter_phoneNo("+918122432677");
        login.enter_pwd("qweqweqwe@123");
        System.out.println("INFO : User entered login details");
    }

    @Then("User is taken to the home page")
    public void user_is_taken_to_the_home_page() throws InterruptedException {
        login.in_homePage();
        System.out.println("INFO : User is taken to the homePage");
    }

    @Given("User is in the home page")
    public void user_is_in_the_home_page() throws InterruptedException {
        home=new homePage(driver);
        home.in_homePage();
        System.out.println("INFO : User is in the home page");
    }

    @When("User enters keyword and Select the items")
    public void user_enters_keyword_and_Select_the_items() {
        home.enter_keyword("Mobiles");
        driver=home.select_item();
        prodName=home.get_prodName();

    }

    @When("User adds the item and proceed to cart")
    public void user_adds_the_item_and_proceed_to_cart() throws InterruptedException {
        product=new productPage(driver);
        product.add_to_cart();

    }

    @Then("User is taken to Checkout page")
    public void user_is_taken_to_Checkout_page() {
        product.in_checkoutPage();
        System.out.println("INFO : User taken to Checkout Page");
    }

    @Given("User is in Checkout page")
    public void user_is_in_Checkout_page() {
        checkout=new checkoutPage(driver);
        checkout.go_to_cart();
        checkout.proceed_to_buy();


    }

    @When("User selects address")
    public void user_selects_address() {
        checkout.select_address();

    }

    @When("User selects payment mode")
    public void user_selects_payment_mode() throws InterruptedException {
        checkout.select_bank("ICI DIRECT");

    }

    @Then("User is given a Order Summary")
    public void user_is_given_a_Order_Summary() {

    }


}
