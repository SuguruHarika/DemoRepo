package cucumber_BDD;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TutorialNinjaStepDefinitions {
    @Before
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
    }
    WebDriver driver;
    @Given("^Navigate to the homepage of tutorial ninja application$")
    public void navigate_to_the_homepage_of_tutorial_ninja_application(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^navigate to the login page$")
    public void navigate_to_the_login_page(){
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @Then("^enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void entered_email_address_as_something_and_password_as_something_into_the_fields(String username,String password) throws InterruptedException {
        driver.findElement(By.id("input-email")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.id("input-password")).sendKeys(password);
        Thread.sleep(2000);
    }

    @And("click on login button")
    public void click_on_login_button(){
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Then("^user should be able to login based on My Account login status$")
    public void user_should_be_able_to_login_based_on_My_Account_login_status(){
        System.out.println(driver.findElement(By.linkText("My Account")).isDisplayed());

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
