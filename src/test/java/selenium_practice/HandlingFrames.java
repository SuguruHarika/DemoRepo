package selenium_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HandlingFrames {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("name")).sendKeys("harika");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("Screenshots//screenshot2.png"));
        WebElement frame1 = driver.findElement(By.id("frm1"));
        driver.switchTo().frame(frame1);
        WebElement dropDown1 = driver.findElement(By.id("selectnav1"));
        Select select = new Select(dropDown1);
        Thread.sleep(2000);
        select.selectByIndex(1);
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("name")).clear();
        WebElement frame2 = driver.findElement(By.id("frm2"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.id("firstName")).sendKeys("suguru");
        driver.findElement(By.id("lastName")).sendKeys("harika");
        driver.findElement(By.id("femalerb")).click();
        driver.findElement(By.id("englishchbx")).click();
        driver.findElement(By.id("email")).sendKeys("suguru1234@gmail.com");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("name")).sendKeys("Dhaya");
        driver.close();


    }


}
