package Testng_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestClass4Properties {
    @Test
    public void applicationHyrFrames() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("data.properties");
        prop.load(fis);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement frame1 = driver.findElement(By.id("frm2"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.id("firstName")).sendKeys(prop.getProperty("firstname"));
        driver.findElement(By.id("lastName")).sendKeys(prop.getProperty("lastname"));
        driver.findElement(By.id("femalerb")).click();
        driver.findElement(By.id("englishchbx")).click();
        driver.findElement(By.id("email")).sendKeys(prop.getProperty("email"));
        System.out.println("Test got Executed Successfully");
        driver.close();

    }

}
