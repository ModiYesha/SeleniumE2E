package org.inetBanking.testCases;

import org.apache.log4j.PropertyConfigurator;
import org.inetBanking.Utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.logging.Logger;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public String userName = readConfig.getUsername();
    public String userPassword = readConfig.getPassword();
    public  static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser){
        logger= Logger.getLogger("eBanking");
        PropertyConfigurator.configure("Log4j.properties");
        if(browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        }
        else if (browser.equals("safari")){
            driver= new SafariDriver();
        }
        driver.get(baseURL);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

