package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver; //ldriver means localDriver


    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver; //rdriver means remoteDriver
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(name = "email")
    @CacheLookup
    WebElement email;

    @FindBy(name = "pass")
    @CacheLookup
    WebElement password;

    @FindBy(name = "login")
    @CacheLookup
    WebElement Login;

    @FindBy(xpath = "//*[contains(text(),'Log Out')]")
    @CacheLookup
    WebElement lnkLogout;

    public void setEmail(String emailP) {
        email.sendKeys(emailP);
    }

    public void setPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickSubmit() {
        Login.click();
    }
    public void clickLogout()
    {
        lnkLogout.click();
    }
}
