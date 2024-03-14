package pageObject_And_Factorymodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;
    public RegistrationPage( WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="input-firstname")
    private WebElement firstName;
    @FindBy(id="input-lastname")
    private WebElement lastName;
    @FindBy(id="input-email")
    private WebElement email;
    @FindBy(id="input-telephone")
    private WebElement telephone;
    @FindBy(id="input-password")
    private WebElement password;
    @FindBy(id="input-confirm")
    private WebElement confirmPassword;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement agreeButton;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;
    public WebElement firstName(){
        return firstName;
    }
    public WebElement lastName(){
        return lastName;
    }
    public WebElement email(){
        return email;
    }
    public WebElement telephone(){
        return telephone;
    }
    public WebElement password(){
        return password;
    }
    public WebElement confirmPassword(){
        return confirmPassword;
    }
    public WebElement agreeButton(){
        return agreeButton;
    }
    public WebElement continueButton(){
        return continueButton;
    }
}
