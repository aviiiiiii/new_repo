package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features",
        glue={"StepDefinitions","AppHooks"},
        plugin= {"pretty",
                "html:target/reports/html",
                "json:target/reports/json/report.json"},
        monochrome=true

)

public class testRunner {
}
