package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US12_Announcements_Tab {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

// 1. Go to home page
        //we are getting the browserType dynamically from our configuration file
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://hr37@cydeo.com");

    }

       @Test

       public void Announcements(){

       }


        @AfterMethod
                public void teardownMethod(){
            driver.close();
        }


    }



