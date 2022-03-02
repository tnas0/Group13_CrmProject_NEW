package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US12_Messages_Announcements {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 1- Login
        driver.get("https://login2.nextbasecrm.com");


    }

    @Test
    public void send_message() throws InterruptedException {
        // 2- Enter username for login
        WebElement userName = driver.findElement(By.name("USER_LOGIN"));
        userName.sendKeys("hr60@cydeo.com");
        // 3- Enter password for login
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser");
        // 4- Press Login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
        WebElement moreBtn = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreBtn.click();

        WebElement clickAnnouncementTab =
                driver.findElement(By.xpath("//div[@id='popup-window-content-menu-popup-feed-add-post-form-popup']/div/div/span[3]/span[2]"));

        clickAnnouncementTab.click();


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        Thread.sleep(3000);

        WebElement textMessage = driver.findElement(By.xpath("//body"));
        textMessage.sendKeys("Testing 12");

        driver.switchTo().parentFrame();
        WebElement header = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        //WebElement sendButton=driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        //sendButton.click();

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();


    }

    @Test
    public void send_empty_message() throws InterruptedException {
        //Enter username and password for login
        CRM_Utilities.crm_login(driver, "helpdesk37@cydeo.com", "UserUser");
        //click More button
        WebElement moreBtn = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreBtn.click();
        //click Announcement
        WebElement clickAnnouncementTab =
                driver.findElement(By.xpath("//div[@id='popup-window-content-menu-popup-feed-add-post-form-popup']/div/div/span[3]/span[2]"));

        clickAnnouncementTab.click();


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        Thread.sleep(3000);

        WebElement textMessage = driver.findElement(By.xpath("//body"));
        textMessage.sendKeys(" ");
        driver.switchTo().parentFrame();

        WebElement empty = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        empty.click();

        WebElement warningMessage = driver.findElement(By.xpath("//span[.='The message title is not specified']"));
        Assert.assertEquals(warningMessage.getText(), "The message title is not specified", "The title doesn't match");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}




//    As a user, I should be able to Make Announcements using the Announcements tab.
//        Acceptance Criteria:
//        1. Users should be able to write messages in and send announcements by clicking the SEND button.
//        2. When users attempt to make announcements without a message, there should be a working message “The message title is not specified”.
//        scenarios :
//        1. Verify users (HR, marketing, Helpdesk) send announcements successfully
//        2. Verify users get working a message without a message body.

