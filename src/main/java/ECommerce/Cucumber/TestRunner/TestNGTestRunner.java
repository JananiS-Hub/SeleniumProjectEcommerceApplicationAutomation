package ECommerce.Cucumber.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/main/java/ECommerce/Cucumber/Feature",glue="ECommerce.Cucumber.StepDefinitions",monochrome=true,plugin=("html:target/cucumberreport.html"))

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
