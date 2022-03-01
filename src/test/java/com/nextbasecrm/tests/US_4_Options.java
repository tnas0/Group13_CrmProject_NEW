package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US_4_Options {
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to : https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");
    }

    //First test case with hr37 credential
    @Test
    public void crm_login_test() {

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("hr37@cybertekschool.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Click on the user profile name to display the options
        WebElement userName = driver.findElement(By.xpath("//span[@id='user-name']"));
        userName.click();

        WebElement popUpOptions = driver.findElement(By.xpath("//div[@class='menu-popup']"));

        //Verify all options are displayed as expected:
        System.out.println("popUpOptions.isDisplayed() = " + popUpOptions.isDisplayed());


        String expectedResult = "My Profile\n" +
                "Edit Profile Settings\n" +
                "Themes\n" +
                "Configure notifications\n" +
                "Log out";

        String actualResult = popUpOptions.getText();


        Assert.assertEquals(actualResult, expectedResult);


        driver.close();
    }

    //Second test case with helpdesk37 credential
    @Test
    public void crm_login_test2() {

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk37@cybertekschool.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Click on the user profile name to display the options
        WebElement userName = driver.findElement(By.xpath("//span[@id='user-name']"));
        userName.click();

        WebElement popUpOptions = driver.findElement(By.xpath("//div[@class='menu-popup']"));

        //Verify all options are displayed as expected:
        System.out.println("popUpOptions.isDisplayed() = " + popUpOptions.isDisplayed());


        String expectedResult = "My Profile\n" +
                "Edit Profile Settings\n" +
                "Themes\n" +
                "Configure notifications\n" +
                "Log out";

        String actualResult = popUpOptions.getText();


        Assert.assertEquals(actualResult, expectedResult);
        driver.close();

    }

    //Third test case with marketing credentials
    @Test
    public void crm_login_test3() {

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("marketing37@cybertekschool.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Click on the user profile name to display the options
        WebElement userName = driver.findElement(By.xpath("//span[@id='user-name']"));
        userName.click();

        WebElement popUpOptions = driver.findElement(By.xpath("//div[@class='menu-popup']"));

        //Verify all options are displayed as expected:
        System.out.println("popUpOptions.isDisplayed() = " + popUpOptions.isDisplayed());


        String expectedResult = "My Profile\n" +
                "Edit Profile Settings\n" +
                "Themes\n" +
                "Configure notifications\n" +
                "Log out";

        String actualResult = popUpOptions.getText();


        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }
}
