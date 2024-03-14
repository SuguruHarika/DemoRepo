package Testng_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestClass1 {
    WebDriver driver;

    @BeforeMethod
    public void BeforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void hyrTestCase1(){
        WebElement dropDown = driver.findElement(By.id("course"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Java");
    }
    @Test
    public void hyrTestCase2() throws InterruptedException {
        WebElement multiSelection = driver.findElement(By.id("course"));
        Thread.sleep(2000);
        Select select = new Select(multiSelection);
        select.selectByIndex(0);
        select.selectByIndex(1);
        Thread.sleep(2000);

    }
    @AfterMethod
    public void AfterMethod(){
        driver.close();
    //first commit

    }

    }


