package Testng_Practice;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ExtentReports {

    WebDriver driver;
    com.aventstack.extentreports.ExtentReports extent;
    @BeforeMethod
    public void configuration(){
     String reportPath = System.getProperty("user.dir")+"\\reports\\reportIndex.html";
     ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("ninja Application");
        reporter.config().setDocumentTitle("Tutorial ninja title");
        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("opearting system","Windows10");
        extent.setSystemInfo("Tested by","Suguru Harika");
    }
    @Test
    public void extentReportMethod() throws IOException {
        ExtentTest extentTest = extent.createTest("extentReportMethod");
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("data.properties");
        prop.load(fis);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        extentTest.info("chrome browser launched");
        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL1"));
        extentTest.info("Navigated to the ninja application");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("emailid"));
        extentTest.info("entered email address");
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
        extentTest.info("entered password");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        extentTest.info("successfully logged to login page");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        extent.flush();


    }
}
