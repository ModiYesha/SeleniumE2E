package org.inetBanking.testCases;

import org.inetBanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_01_LoginTest extends BaseClass {

    @Test
    public void LoginTest() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setTxtUsername(userName);
        lp.setTxtPassword(userPassword);
        lp.clickLogin();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Thread.sleep(1000);

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }

    }
}
