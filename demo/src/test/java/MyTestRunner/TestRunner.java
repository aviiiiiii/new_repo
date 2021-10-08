package MyTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/feature",
        glue= {"stepDefinitions","appHooks"},
        plugin= {"pretty",
                "html:target/reports/html",
                "json:target/reports/json/report.json"},
        monochrome=true

)

public class TestRunner {

}
