package org.inetBanking.testCases;

import org.inetBanking.pageObjects.LoginPage;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class TC_01_LoginTest extends BaseClass {

    @Test
    public void LoginTest() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setTxtUsername(userName);
        lp.setTxtPassword(userPassword);
        lp.clickLogin();

        if (isAlertPresent()==true){
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            fail();
            logger.warning("Login failed");
        }
        else {
            assertTrue(true);
            lp.clickLogout();
            driver.switchTo().alert().accept(); //Closes alert
            driver.switchTo().defaultContent();
        }
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Thread.sleep(1000);

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            assertTrue(true);
        }
        else {
            assertTrue(false);
        }

    }

    public boolean isAlertPresent() { // user defined method to check alert.
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e){
            return false;
        }
    }
}
