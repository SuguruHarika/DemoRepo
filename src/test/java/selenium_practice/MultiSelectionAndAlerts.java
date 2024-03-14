package selenium_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MultiSelectionAndAlerts {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.linkText("Selenium Practice")).click();
        WebElement multiSelectionBox = driver.findElement(By.linkText("Selenium Practice"));
        Actions action = new Actions(driver);
        action.moveToElement(multiSelectionBox).perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Alerts")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("dismiss-button")).click();
        driver.findElement(By.id("alertBox")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println(driver.findElement(By.id("output")).getText());
        //driver.close();

    }
}
