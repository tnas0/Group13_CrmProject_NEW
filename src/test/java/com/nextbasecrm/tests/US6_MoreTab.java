package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US6_MoreTab {


    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //User navigate to Authorization page https://login2.nextbasecrm.com/
        //driver.get("https://login2.nextbasecrm.com/");
        driver.get(ConfigurationReader.getProperty("env"));

    }

    @Test  // Test with helpdesk39 credentials

    public void nextBaseCrm_test1_helpdesk39() {
        //Enter user credentials  as helpdesk39 user and click log in button
        WebElement hrUserLogin = driver.findElement(By.xpath("//input[@placeholder='Login']"));
        hrUserLogin.sendKeys("helpdesk39@cydeo.com");

        //Enter password UserUser
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("UserUser");

        // Navigate to logInButton and click
        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();

        // Navigate to MoreTab and click
        WebElement MoreTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        MoreTab.click();

        WebElement moreTabContains = driver.findElement(By.className("menu-popup-items"));
        System.out.println("moreTabContains.getText() = " + moreTabContains.getText());

        //Four options should be displayed under the MORE tab:
        //File
        //Appreciation
        //Announcement
        //Workflow
     /*   if (moreTabContains.getText().contains("File\n" +
                "Appreciation\n" +
                "Announcement\n" +
                "Workflow")){
            System.out.println("More tab contains all options, verification Passed!");
        }else {
            System.out.println("More Tab contains all options, verification Failed!");
        }

      */
        String expectedResult = "File\n" +
                "Appreciation\n" +
                "Announcement\n" +
                "Workflow";

        String actualResult = moreTabContains.getText();

        Assert.assertEquals(actualResult, expectedResult, "Verification Failed");

        driver.close();
    }


    @Test // Test with marketing38 credentials

    public void nextBaseCrm_test2_marketing38() {
        //Enter user credentials  as marketing38 user and click log in button
        WebElement hrUserLogin = driver.findElement(By.xpath("//input[@placeholder='Login']"));
        hrUserLogin.sendKeys("marketing38@cydeo.com");

        //Enter password UserUser
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("UserUser");

        // Navigate to logInButton and click
        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();

        // Navigate to MoreTab and click
        WebElement MoreTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        MoreTab.click();

        WebElement moreTabContains = driver.findElement(By.className("menu-popup-items"));
        System.out.println("moreTabContains.getText() = " + moreTabContains.getText());

        //Four options should be displayed under the MORE tab:
        //File
        //Appreciation
        //Announcement
        //Workflow
     /*   if (moreTabContains.getText().contains("File\n" +
                "Appreciation\n" +
                "Announcement\n" +
                "Workflow")){
            System.out.println("More tab contains all options, verification Passed!");
        }else {
            System.out.println("More Tab contains all options, verification Failed!");
        }

      */
        String expectedResult = "File\n" +
                "Appreciation\n" +
                "Announcement\n" +
                "Workflow";

        String actualResult = moreTabContains.getText();

        Assert.assertEquals(actualResult, expectedResult, "Verification Failed");

        driver.close();

    }

}
