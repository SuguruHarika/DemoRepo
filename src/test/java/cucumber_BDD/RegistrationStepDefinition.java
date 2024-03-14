package cucumber_BDD;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RegistrationStepDefinition {
    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Given("i navigate to register application")
    public void i_navigate_to_register_application() throws InterruptedException {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        Thread.sleep(2000);
    }
    @When("i enter below details for filling the fields")
    public void i_enter_below_details_for_filling_the_fields(DataTable data) {
        Map<String, String> dataMap = data.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
    }
    @Then("i click on the agree button")
    public void i_click_on_the_agree_button() {
        driver.findElement(By.xpath("//input[@name='agree']")).click();
    }
    @Then("i click on the continue button")
    public void i_click_on_the_continue_button() {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }
    @Then("i registered successfully and able to see Your Account Has Been Created!")
    public void i_registered_successfully_and_able_to_see_your_account_has_been_created() {
        System.out.println(driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).isDisplayed());
        //Assert.assertEquals(actual,"Your Account Has Been Created!");
    }
    @After
    public void closer(){
        driver.close();
    }
}
