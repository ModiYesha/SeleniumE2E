package org.inetBanking.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver; //localDriver = RDriver
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="uid")
    WebElement txtUsername;
    @FindBy(name = "password")
    WebElement txtPassword;
    @FindBy(name = "btnLogin")
    WebElement btnLogin;
    @FindBy(name = "btnReset")
    WebElement btnReset;

    @FindBy(partialLinkText = "Log out")
    WebElement btnLogout;

    public void setTxtUsername(String uname) {
        txtUsername.sendKeys(uname);
    }
    public void setTxtPassword(String password) {
        txtPassword.sendKeys(password);
    }
    public void clickLogin() {
        btnLogin.click();
    }
    public void clickLogout(){
        btnLogout.click();
    }
}
