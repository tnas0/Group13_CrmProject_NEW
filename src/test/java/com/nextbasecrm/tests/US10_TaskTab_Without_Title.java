package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US10_TaskTab_Without_Title {
    WebDriver driver;
    @BeforeMethod
    public void  setUp(){
        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        // driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //go to login page
        driver.get(ConfigurationReader.getProperty("env"));
        //  driver.get("https://login1.nextbasecrm.com");
        //driver.get("https://login2.nextbasecrm.com");

    }
    //fourth test case - Create Task without title and message with Hr User -Negative SCENARIO

    @Test
            public void task_without_title_hrUser(){
        // step1-user go to home page
    WebElement inputUserName=driver.findElement(By.xpath("//input[@class='login-inp']"));
            inputUserName.sendKeys("hr38@cydeo.com");

    WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
            inputPassword.sendKeys("UserUser");
    WebElement loginBtn= driver.findElement(By.xpath("//input[@class='login-btn']"));
            loginBtn.click();
    //step2-Click task button and see task table
    WebElement TaskTAB=driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
            TaskTAB.click();
            BrowserUtils.sleep(3);
    //system display Task Tab
    WebElement bodyTable= driver.findElement(By.xpath("//div[@id='fulloPostFormLHE_blogPostForm']"));
    //Assert.assertTrue(bodyTable.isDisplayed());
            System.out.println("bodyTable.isDisplayed() = " + bodyTable.isDisplayed());
    //click send button


    WebElement sendBtn= driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
            sendBtn.click();
            BrowserUtils.sleep(2);
    //step3-Verify error message
   WebElement SystemError= driver.findElement(By.xpath("//div[@id='feed-add-post-content-tasks-container']/div"));
    //System.out.println("SystemError.isDisplayed() = " + SystemError.isDisplayed());
          //  Assert.assertTrue(SystemError.isDisplayed());
    String expectedText="The task name is not specified.";
    String actualText=SystemError.getText();
    Assert.assertEquals(actualText,expectedText);

}
    @Test
    public void task_without_title_heplDeskUser(){
        // step1-user go to home page
        WebElement inputUserName=driver.findElement(By.xpath("//input[@class='login-inp']"));
        inputUserName.sendKeys("helpdesk38@cydeo.com");

        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("UserUser");
        WebElement loginBtn= driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        //step2-Click task button and see task table
        WebElement TaskTAB=driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        TaskTAB.click();
        BrowserUtils.sleep(3);
        //system display Task Tab
        WebElement bodyTable= driver.findElement(By.xpath("//div[@id='fulloPostFormLHE_blogPostForm']"));
        //Assert.assertTrue(bodyTable.isDisplayed());
        System.out.println("bodyTable.isDisplayed() = " + bodyTable.isDisplayed());
        //click send button


        WebElement sendBtn= driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendBtn.click();
        BrowserUtils.sleep(2);
        //step3-Verify error message
        WebElement SystemError= driver.findElement(By.xpath("//div[@id='feed-add-post-content-tasks-container']/div"));
        //System.out.println("SystemError.isDisplayed() = " + SystemError.isDisplayed());
        //  Assert.assertTrue(SystemError.isDisplayed());
        String expectedText="The task name is not specified.";
        String actualText=SystemError.getText();
        Assert.assertEquals(actualText,expectedText);

    }
}
