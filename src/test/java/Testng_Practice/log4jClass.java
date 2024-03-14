package Testng_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class log4jClass {
    @Test
    public void logging(){
        Logger log = LogManager.getLogger(log4jClass.class.getName());
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        log.debug("chrome browser got launched");
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        log.debug("Navigated to the application");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("input-firstname")).sendKeys("Harika");
        log.debug("entered firstname");
        driver.findElement(By.id("input-lastname")).sendKeys("Dhaya");
        log.debug("entered lastname");
        driver.findElement(By.id("input-email")).sendKeys("harika2345@gmail.com");
        log.debug("entered email");
        driver.findElement(By.id("input-telephone")).sendKeys("256879423");
        log.debug("entered telephone num");
        driver.findElement(By.id("input-password")).sendKeys("harika0803");
        log.debug("entered password");
        driver.findElement(By.id("input-confirm")).sendKeys("harika0803");
        log.debug("entered confirmed password");
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        log.debug("clicked agree button");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        log.debug("clicked continue button and successfully registered ");
        //driver.findElement(By.id("content"))
        driver.close();
        log.debug("browser got closed");





    }

}
