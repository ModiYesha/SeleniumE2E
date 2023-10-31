package org.inetBanking.testCases;

import org.apache.log4j.PropertyConfigurator;
import org.inetBanking.Utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public String userName = readConfig.getUsername();
    public String userPassword = readConfig.getPassword();
    public  static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        logger= Logger.getLogger("eBanking");
        PropertyConfigurator.configure("Log4j.properties");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

