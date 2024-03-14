package selenium_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
public class TakingScreenShotAndCalendar {
    //static WebDriver driver = null;
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        driver.findElement(By.id("first_date_picker")).click();
        String requiredDate = "October 2024";
        String day = "20";
        String currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
        while (!currentDate.equals(requiredDate)){
            driver.findElement(By.linkText("Next")).click();
            currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
        }
        driver.findElement(By.xpath("//td[@class=' ui-datepicker-week-end ']/a[text()="+day+"]")).click();
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(file,new File("Screenshots\\screenshot1.png"));
        driver.findElement(By.id("second_date_picker")).click();
        driver.findElement(By.className("ui-datepicker-title")).getText();


    }


}
