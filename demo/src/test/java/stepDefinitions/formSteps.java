package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import appHooks.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.formPage;


public class formSteps {

    static WebDriver driver=null;
    formPage form;


    @Given("User is in the protoCommerce page")
    public void user_is_in_the_protoCommerce_page() {
        driver = hooks.getWebDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        Assert.assertEquals(driver.getTitle(), "ProtoCommerce");
        System.out.println("User is in the ProtoCommerce Page");
    }
    @When("User enters the all the details")
    public void user_enters_the_all_the_details() {
        form =new formPage(driver);
        form.enter_name("Avinash V");
        form.enter_email("avi@gmail.com");
        form.enter_password("12345");
        form.select_gender(1);
        form.select_Employed();
        form.enter_dob("13111999");
        System.out.println("Data has been successfully entered");
    }

    @And("User clicks the Submit button")
    public void user_clicks_the_Submit_button() {
        form.submit();
        System.out.println("Form Submitted");
    }

    @Then("User receives a success message")
    public void user_receives_a_success_message() {

        System.out.println(form.getTexT());


    }
}
