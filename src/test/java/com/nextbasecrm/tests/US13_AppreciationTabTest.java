package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US13_AppreciationTabTest {

    WebDriver driver;
    String appreciationMessage = "Appreciation Letter: great!";
    String warningMessage = "The message title is not specified";

    @BeforeMethod
    public void setDriver(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    //-------------------------------- Test with HR Credential-----------------------------------

    @Test(priority = 1)
    public void hrAppreciationTabTest1WithText() throws InterruptedException {

        CRM_Utilities.crm_login( driver,"hr38@cydeo.com","UserUser");

        WebElement moreButton = driver.findElement(By.id("feed-add-post-form-link-text"));
        moreButton.click();

        WebElement appreciationButton = driver.findElement(By.xpath("//div[@class='menu-popup']//span[2]/span[2]"));
        appreciationButton.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement AppreciationTextBox = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        AppreciationTextBox.sendKeys(appreciationMessage);

        driver.switchTo().parentFrame();
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        Thread.sleep(3000);


        String expectedDisplay = appreciationMessage;
        String actualDisplay = driver.findElement(By.xpath("(//div[@class='feed-post-text-block-inner-inner'])[1]")).getText();

        Assert.assertEquals(actualDisplay,expectedDisplay);

    }

    @Test(priority = 2)
    public void hrAppreciationTabTest2WithoutText() throws InterruptedException {

        CRM_Utilities.crm_login( driver,"hr38@cydeo.com","UserUser");

        WebElement moreButton = driver.findElement(By.id("feed-add-post-form-link-text"));
        moreButton.click();

        WebElement appreciationButton = driver.findElement(By.xpath("//div[@class='menu-popup']//span[2]/span[2]"));
        appreciationButton.click();

        driver.switchTo().parentFrame();
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        Thread.sleep(3000);

        String expectedWarningMessage = warningMessage;
        String actualWarningMessage = driver.findElement(By.xpath("//div//span[@class='feed-add-info-text']")).getText();
        Assert.assertEquals(actualWarningMessage,expectedWarningMessage);

    }

    //-------------------------------- Test with HelpDesk Credential-----------------------------------

    @Test(priority = 3)
    public void helpdeskAppreciationTabTest1WithText() throws InterruptedException {

        CRM_Utilities.crm_login( driver,"helpdesk38@cydeo.com","UserUser");

        WebElement moreButton = driver.findElement(By.id("feed-add-post-form-link-text"));
        moreButton.click();

        WebElement appreciationButton = driver.findElement(By.xpath("//div[@class='menu-popup']//span[2]/span[2]"));
        appreciationButton.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement AppreciationTextBox = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        AppreciationTextBox.sendKeys(appreciationMessage);

        driver.switchTo().parentFrame();
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        Thread.sleep(3000);


        String expectedDisplay = appreciationMessage;
        String actualDisplay = driver.findElement(By.xpath("(//div[@class='feed-post-text-block-inner-inner'])[1]")).getText();

        Assert.assertEquals(actualDisplay,expectedDisplay);


    }

    @Test(priority=4)
    public void helpdeskAppreciationTabTest2WithoutText() throws InterruptedException {

        CRM_Utilities.crm_login( driver,"helpdesk38@cydeo.com","UserUser");

        WebElement moreButton = driver.findElement(By.id("feed-add-post-form-link-text"));
        moreButton.click();

        WebElement appreciationButton = driver.findElement(By.xpath("//div[@class='menu-popup']//span[2]/span[2]"));
        appreciationButton.click();

        driver.switchTo().parentFrame();
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        Thread.sleep(3000);

        String expectedWarningMessage = warningMessage;
        String actualWarningMessage = driver.findElement(By.xpath("//div//span[@class='feed-add-info-text']")).getText();
        Assert.assertEquals(actualWarningMessage,expectedWarningMessage);

    }


    //-------------------------------- Test with Marketing Credential-----------------------------------

    @Test(priority=5)
    public void marketingAppreciationTabTest1WithText() throws InterruptedException {

        CRM_Utilities.crm_login( driver,"marketing38@cydeo.com","UserUser");

        WebElement moreButton = driver.findElement(By.id("feed-add-post-form-link-text"));
        moreButton.click();

        WebElement appreciationButton = driver.findElement(By.xpath("//div[@class='menu-popup']//span[2]/span[2]"));
        appreciationButton.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        WebElement AppreciationTextBox = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        AppreciationTextBox.sendKeys(appreciationMessage);

        driver.switchTo().parentFrame();
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        Thread.sleep(3000);

        String expectedDisplay = appreciationMessage;
        String actualDisplay = driver.findElement(By.xpath("(//div[@class='feed-post-text-block-inner-inner'])[1]")).getText();

        Assert.assertEquals(actualDisplay,expectedDisplay);


    }

    @Test(priority=6)
    public void marketingAppreciationTabTest2WithoutText() throws InterruptedException {

        CRM_Utilities.crm_login( driver,"marketing38@cydeo.com","UserUser");

        WebElement moreButton = driver.findElement(By.id("feed-add-post-form-link-text"));
        moreButton.click();

        WebElement appreciationButton = driver.findElement(By.xpath("//div[@class='menu-popup']//span[2]/span[2]"));
        appreciationButton.click();

        driver.switchTo().parentFrame();
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        Thread.sleep(3000);

        String expectedWarningMessage = warningMessage;
        String actualWarningMessage = driver.findElement(By.xpath("//div//span[@class='feed-add-info-text']")).getText();
        Assert.assertEquals(actualWarningMessage,expectedWarningMessage);


    }
}

