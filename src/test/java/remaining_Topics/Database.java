package remaining_Topics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class Database {
    public static void main(String[] args) throws SQLException, InterruptedException {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "Dhaya";
        String dbUrl = url + dbName;
        String username = "root";
        String password = "admin";
        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        if (!connection.isClosed()) {
            System.out.println("database successfully connected");
            Statement statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery("select * from login_credentials where SNumber=1");
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://tutorialsninja.com/demo/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.linkText("My Account")).click();
            driver.findElement(By.linkText("Login")).click();
            while (resultSet1.next()){
                driver.findElement(By.id("input-email")).sendKeys(resultSet1.getString("Email_id"));
                Thread.sleep(2000);
                driver.findElement(By.id("input-password")).sendKeys(resultSet1.getString("Email_password"));
                Thread.sleep(2000);
            }
            driver.findElement(By.xpath("//input[@value='Login']")).click();
            Thread.sleep(2000);
            driver.close();

        }


    }

}
