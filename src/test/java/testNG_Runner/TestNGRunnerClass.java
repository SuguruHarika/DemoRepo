package testNG_Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        plugin = {"html:target/cucumber_html_report.html"},
        features ={"src/test/java/features/registration.feature"},glue = {"cucumber_BDD"})
public class TestNGRunnerClass extends AbstractTestNGCucumberTests {

}
