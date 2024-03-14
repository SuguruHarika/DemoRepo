package selenium_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DifferantBrowser {
    public static void main(String[] args) throws InterruptedException {
        String browser = "Chrome";
        WebDriver driver;
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://omayo.blogspot.com/");
            driver.manage().window().maximize();
            driver.findElement(By.name("q")).sendKeys("Suguru Harika");
            System.out.println("code is excuted in chrome browser");
            Thread.sleep(2000);
            driver.close();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get("https://omayo.blogspot.com/");
            driver.manage().window().maximize();
            driver.findElement(By.name("q")).sendKeys("Suguru Harika");
            System.out.println("code is excuted in firefox browser");
            Thread.sleep(2000);
            driver.close();
        } else if (browser.equalsIgnoreCase("edgebrowser")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.get("https://omayo.blogspot.com/");
            driver.manage().window().maximize();
            driver.findElement(By.name("q")).sendKeys("Suguru Harika");
            System.out.println("code is excuted in edgebrowser");
            Thread.sleep(2000);
            driver.close();

        }
    }
}
