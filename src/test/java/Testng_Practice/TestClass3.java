package Testng_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestClass3 {
    WebDriver driver;
    @Parameters({"URL3"})
    @Test
    public void applicationHyr(String URL3) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL3);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("textboxn")).sendKeys("Harika");

    }

    @Test(dataProvider = "getData")
    public void loginDetails(String username, String password){
        driver.findElement(By.name("userid")).sendKeys(username);
        driver.findElement(By.name("pswrd")).sendKeys(password);

        driver.close();
    }
    @DataProvider
    public <object> Object[][] getData(){
        Object[][] data = {{"SuguruHarika", "123456"}};
        return data;

    }
}
