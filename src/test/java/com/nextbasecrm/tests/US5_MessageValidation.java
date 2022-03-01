package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US5_MessageValidation {
    WebDriver driver;
    String hrUser = "hr37@cydeo.com",
                helpDaskUser = "helpdesk37@cydeo.com",
                mktUser = "marketing39@cydeo.com",
                password = "UserUser";
    String feed = "test123";

    @BeforeMethod
    public void setUpDriver(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
    }

    // ============AC1- Send Simple Text Message  =============
    public void simpleTaskSend() throws InterruptedException {

        WebElement messageTab = driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']//span[text()='Message']"));
        messageTab.click();
        Thread.sleep(3000);

        // The message box is inside the iframe, so we need to switch to frame
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement messageBodyBox = driver.findElement(By.xpath("//body[@contenteditable='true']"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(messageBodyBox));

        messageBodyBox.click();
        messageBodyBox.sendKeys(feed);
        // We need to switch the frame focus back
        driver.switchTo().parentFrame();

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        Thread.sleep(3000);

        String actual = driver.findElement(By.xpath("(//div[@class='feed-post-text-block-inner-inner'])[1]")).getText();
        Assert.assertEquals(actual, feed);

    }
    // Test for each 3 Group of User :
    @Test(priority = 1)
    public void hrSendMassage() throws InterruptedException {
        CRM_Utilities.crm_login(driver,hrUser,password);
        simpleTaskSend();
    }

    @Test(priority = 2)
    public void helpDaskSendMassage() throws InterruptedException {
        CRM_Utilities.crm_login(driver,helpDaskUser,password);
        simpleTaskSend();
    }

    @Test(priority = 3)
    public void mktSendMassage() throws InterruptedException {
        CRM_Utilities.crm_login(driver,mktUser,password);
        simpleTaskSend();
    }



    //=========AC2---Warning Massage(Negative )=== ==========
    public void warningMessage() throws InterruptedException {

        WebElement messageTab = driver.findElement(By.xpath("//span[text()='Message']"));
        messageTab.click();
        Thread.sleep(3000);

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        Thread.sleep(3000);

        WebElement warningMessage = driver.findElement(By.xpath("//span[text()='The message title is not specified']"));
        Assert.assertTrue(warningMessage.isDisplayed(), "The warning message is displayed");


    }
    // Test for each 3 Group of User :
    @Test(priority = 4)
    public void hrWarning() throws InterruptedException {
        CRM_Utilities.crm_login(driver,hrUser,password);
        warningMessage();
    }

    @Test(priority = 5)
    public void helpDaskWarning() throws InterruptedException {
        CRM_Utilities.crm_login(driver,helpDaskUser,password);
        warningMessage();
    }

    @Test(priority = 6)
    public void mktWarning() throws InterruptedException {
        CRM_Utilities.crm_login(driver,mktUser,password);
        warningMessage();
    }



    @AfterMethod
    public void teardown() {
        driver.close();
    }
















}
