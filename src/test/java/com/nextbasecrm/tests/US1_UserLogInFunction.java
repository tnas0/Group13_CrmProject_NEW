package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.module.Configuration;
import java.util.concurrent.TimeUnit;

public class US1_UserLogInFunction {

    //1TC for Login
    /**
     * 1- Enter login page
     * 2- Input Username
     * 3- Input password
     * 4- click login button
     */
    /*WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1. Enter login page
        driver.get(ConfigurationReader.getProperty("env"));
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }

    //Positive scenario
    @Test
    public void login_with_valid_credentials_with_login_btn() {
        //2. Input Username
        WebElement userName = driver.findElement(By.xpath("//input[@class='login-inp'][1]"));
        userName.sendKeys(ConfigurationReader.getProperty("hr37@cydeo.com"));
        //3. Input password
        WebElement password = driver.findElement(By.xpath("//input[@class='login-inp'][2]"));
        password.sendKeys(ConfigurationReader.getProperty("UserUser"));
        //4. click login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit"));
        BrowserUtils.sleep(3);
        loginBtn.click();
        //5. Verify title
        String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void login_with_valid_credentials_with_Enter_btn() {
        //2. Input Username
        WebElement userName = driver.findElement(By.xpath("//input[@class='login-inp'][1]"));
        userName.sendKeys(ConfigurationReader.getProperty("hr39@cydeo.com"));
        //3. Input password
        WebElement password = driver.findElement(By.xpath("//input[@class='login-inp'][2]"));
        password.sendKeys(ConfigurationReader.getProperty("UserUser") + Keys.ENTER);
        //4. click login button
        //5. Verify title
        String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //Negative Scenario
    //valid username invalid password
    @Test
    public void login_with_valid_username_invalid_password() {
        //2. Input Username
        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys(ConfigurationReader.getProperty("hr39@cydeo.com"));
        //3. Input invalid password
        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys(("abcdeteyttjh"));
        //4. click login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type= 'submit']"));
        BrowserUtils.sleep(3);
        loginBtn.click();
        //5. Verify title
        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);


        }
    }*/
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1. Enter login page
        driver.get(ConfigurationReader.getProperty("env"));


    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }

        @Test
        public void login_with_valid_credentials_with_login_btn() {
        //2. Input Username

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk37@cydeo.com");


        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");

    }
        @Test
        public void login_with_valid_credentials_with_Enter_btn() {

        //2. Input Username
        WebElement userName = driver.findElement(By.xpath("//input[@class='login-inp'][1]"));
        userName.sendKeys("hr39@cydeo.com");
        //3. Input password
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser" + Keys.ENTER);//Click Enter button

        //5. Verify title
        /*String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);*/
            BrowserUtils.verifyTitle(driver, "Portal");
}
        @Test
        public void login_with_valid_username_invalid_password() {

        //2. Input Username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("incorrect");


        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("incorrect");

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //5. Verify title
        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);


    }
}