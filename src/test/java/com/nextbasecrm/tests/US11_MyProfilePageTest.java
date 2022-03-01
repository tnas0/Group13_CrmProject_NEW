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

public class US11_MyProfilePageTest {

    WebDriver driver;


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
    @Test(priority=1)
    public void profilePageDisplayHR(){

        CRM_Utilities.crm_login( driver,"hr39@cydeo.com","UserUser");

        WebElement profileButton = driver.findElement(By.xpath("//div//span[@class='user-name']"));
        profileButton.click();

        WebElement myProfileOption = driver.findElement(By.linkText("My Profile"));
        myProfileOption.click();

        String displayedTab1 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[1]")).getText();
        String expectedTan1 = "General";
        Assert.assertEquals(displayedTab1,expectedTan1,"'My Profile' page 'General' tab verification FAILED! ");

        String displayedTab2 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[2]")).getText();
        String expectedTan2 = "Drive";
        Assert.assertEquals(displayedTab2,expectedTan2,"'My Profile' page 'Drive' tab verification FAILED! ");

        String displayedTab3 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[3]")).getText();
        String expectedTan3 = "Tasks";
        Assert.assertEquals(displayedTab3,expectedTan3,"'My Profile' page 'Tasks' tab verification FAILED! ");

        String displayedTab4 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[4]")).getText();
        String expectedTan4 = "Calendar";
        Assert.assertEquals(displayedTab4,expectedTan4,"'My Profile' page 'Calendar' tab verification FAILED! ");

        String displayedTab5 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[5]")).getText();
        String expectedTan5 = "conversations";
        Assert.assertEquals(displayedTab5,expectedTan5,"'My Profile' page 'conversations' tab verification FAILED! ");


    }

    //-------------------------------- Test with HelpDesk Credential-----------------------------------

    @Test(priority=2)
    public void profilePageDisplayHelpDesk(){
        CRM_Utilities.crm_login( driver,"helpdesk39@cydeo.com","UserUser");

        WebElement profileButton = driver.findElement(By.xpath("//div//span[@class='user-name']"));
        profileButton.click();

        WebElement myProfileOption = driver.findElement(By.linkText("My Profile"));
        myProfileOption.click();

        String displayedTab1 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[1]")).getText();
        String expectedTan1 = "General";
        Assert.assertEquals(displayedTab1,expectedTan1,"'My Profile' page 'General' tab verification FAILED! ");

        String displayedTab2 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[2]")).getText();
        String expectedTan2 = "Drive";
        Assert.assertEquals(displayedTab2,expectedTan2,"'My Profile' page 'Drive' tab verification FAILED! ");

        String displayedTab3 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[3]")).getText();
        String expectedTan3 = "Tasks";
        Assert.assertEquals(displayedTab3,expectedTan3,"'My Profile' page 'Tasks' tab verification FAILED! ");

        String displayedTab4 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[4]")).getText();
        String expectedTan4 = "Calendar";
        Assert.assertEquals(displayedTab4,expectedTan4,"'My Profile' page 'Calendar' tab verification FAILED! ");

        String displayedTab5 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[5]")).getText();
        String expectedTan5 = "conversations";
        Assert.assertEquals(displayedTab5,expectedTan5,"'My Profile' page 'conversations' tab verification FAILED! ");

    }

    //-------------------------------- Test with Marketing Credential-----------------------------------

    @Test(priority=3)
    public void profilePageDisplayMarketing(){
        CRM_Utilities.crm_login( driver,"marketing39@cydeo.com","UserUser");

        WebElement profileButton = driver.findElement(By.xpath("//div//span[@class='user-name']"));
        profileButton.click();

        WebElement myProfileOption = driver.findElement(By.linkText("My Profile"));
        myProfileOption.click();

        String displayedTab1 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[1]")).getText();
        String expectedTan1 = "General";
        Assert.assertEquals(displayedTab1,expectedTan1,"'My Profile' page 'General' tab verification FAILED! ");

        String displayedTab2 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[2]")).getText();
        String expectedTan2 = "Drive";
        Assert.assertEquals(displayedTab2,expectedTan2,"'My Profile' page 'Drive' tab verification FAILED! ");

        String displayedTab3 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[3]")).getText();
        String expectedTan3 = "Tasks";
        Assert.assertEquals(displayedTab3,expectedTan3,"'My Profile' page 'Tasks' tab verification FAILED! ");

        String displayedTab4 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[4]")).getText();
        String expectedTan4 = "Calendar";
        Assert.assertEquals(displayedTab4,expectedTan4,"'My Profile' page 'Calendar' tab verification FAILED! ");

        String displayedTab5 = driver.findElement(By.xpath("(//div//*[@class=\"menu-item-link-text\"])[5]")).getText();
        String expectedTan5 = "conversations";
        Assert.assertEquals(displayedTab5,expectedTan5,"'My Profile' page 'conversations' tab verification FAILED! ");

    }
}

