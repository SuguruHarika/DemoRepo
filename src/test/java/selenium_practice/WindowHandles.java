package selenium_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.salesforce.com/in/");
        String parentWindow = driver.getWindowHandle();
        System.out.println("parent window id - " + parentWindow);
        driver.findElement(By.linkText("Start free trial")).click();
        Thread.sleep(2000);
        Set<String> childWindow = driver.getWindowHandles();
        Iterator<String> itr = childWindow.iterator();
        String pWindow = itr.next();
        String cWindow = itr.next();
        driver.switchTo().window(cWindow);
        driver.manage().window().maximize();
        driver.findElement(By.name("UserFirstName")).sendKeys("Suguru");
        driver.findElement(By.name("UserLastName")).sendKeys("Harika");
        driver.findElement(By.name("UserEmail")).sendKeys("harikaaa2000@gmail.com");
        WebElement dropDown1 = driver.findElement(By.name("UserTitle"));
        Select select = new Select(dropDown1);
        select.selectByVisibleText("Sales Manager");
        driver.findElement(By.name("CompanyName")).sendKeys("TCS");
        WebElement dropDown2 = driver.findElement(By.name("CompanyEmployees"));
        Select select2 = new Select(dropDown2);
        select2.selectByVisibleText("1 - 25 employees");
        driver.findElement(By.name("UserPhone")).sendKeys("258369741");
        driver.switchTo().window(pWindow);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.quit();
    }

}




