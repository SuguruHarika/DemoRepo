package remaining_Topics;

import pageObject_And_Factorymodel.LoginPage;
import pageObject_And_Factorymodel.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class loginTestCasesForPage {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void registration() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("data.properties");
        prop.load(fis);
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.firstName().sendKeys("fName");
        registrationPage.lastName().sendKeys("lName");
        registrationPage.email().sendKeys("mail");
        registrationPage.telephone().sendKeys("phone");
        registrationPage.password().sendKeys("pwrd");
        registrationPage.confirmPassword().sendKeys("pwrd");
        registrationPage.agreeButton().click();
        registrationPage.continueButton().click();

    }
    @Test
    public void login(){
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.emailField().sendKeys("emailid");
        loginpage.passwordField().sendKeys("password");
        loginpage.loginButton().click();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();

    }
}
