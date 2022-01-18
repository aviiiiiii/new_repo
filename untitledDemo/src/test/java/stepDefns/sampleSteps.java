package stepDefns;

import Utilities.myJSONParser;
import io.cucumber.java.en.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.samplePage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class sampleSteps {
    samplePage samplePage;
    WebDriver driver;

    JSONObject jsonObject;
        private myJSONParser json;

    public sampleSteps() throws IOException, ParseException {
        json=new myJSONParser();
    }

    @Given("User is in the form filling page")
    public void user_is_in_the_form_filling_page() throws IOException, ParseException {
        System.setProperty("webdriver.chrome.driver", "I:\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        samplePage=new samplePage(driver);

        JSONParser jsonParser=new JSONParser();
        FileReader reader=new FileReader("src/test/resources/jsonFiles/sampleJSON.json");
        Object obj=jsonParser.parse(reader);
        jsonObject=(JSONObject) obj;

    }

    @When("User enters the details")
    public void user_enters_the_details() throws InterruptedException {
//        JSONObject accountObj=(JSONObject) jsonObject.get("account");
//        JSONObject contactObj=(JSONObject) jsonObject.get("contact");
//        String name=(String)accountObj.get("Name");
//        String email=(String)contactObj.get("email");
//        samplePage.enter_details(name,email);
        samplePage.enter_details(json.account("Name"),json.contact("email"));
    }

    @And("User clicks sumbit button")
    public void user_clicks_sumbit_button() throws InterruptedException {
        samplePage.click_submitButton();
    }

    @Then("User receives success msg")
    public void user_receives_success_msg() {
        samplePage.is_formSubmitted();
    }
}
