package runner_Package;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber_html_report.html"},
        monochrome = true,
        features ={"src/test/java/features/registration.feature"},glue = {"cucumber_BDD"})


public class RunnerClass {

}
