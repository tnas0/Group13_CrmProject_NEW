package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class US2_RememberLogIn{

    WebDriver driver;
    String url = "https://login2.nextbasecrm.com/";
    String pass = "UserUser";

    @BeforeTest
    public void setup(){
        System.out.println("Setting up");
        driver = WebDriverFactory.getDriver("chrome");
        driver.get(url);
    }

    //HR Credentials

    @Test(priority=1)
    public void saveCredentialsTestHR(){


        WebElement userField = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement passField = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        WebElement checkBox = driver.findElement(By.id("USER_REMEMBER"));
        WebElement logInButton = driver.findElement(By.xpath("//input[@type='submit']"));

        userField.sendKeys("hr37@cydeo.com");
        passField.sendKeys(pass);
        checkBox.click();
        logInButton.click();


        String expHomePageTitle = "Portal";

        Assert.assertEquals(driver.getTitle(), expHomePageTitle);

        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"user-block\"]"));
        dropDown.click();

        WebElement logOut = driver.findElement(By.xpath("//*[@id=\"popup-window-content-menu-popup-user-menu\"]/div/div/a[3]/span[2]"));
        logOut.click();

        WebElement userFieldClear = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userFieldClear.clear();

    }

    //HelpDesk Credentials

        @Test(priority=2)
        public void saveCredentialsTestHelpDesk(){


            WebElement userField2 = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
            WebElement passField2 = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
            WebElement checkBox2 = driver.findElement(By.id("USER_REMEMBER"));
            WebElement logInButton2 = driver.findElement(By.xpath("//input[@type='submit']"));

            userField2.sendKeys("helpdesk37@cydeo.com");
            passField2.sendKeys(pass);
            checkBox2.click();
            logInButton2.click();


            String expHomePageTitle2 = "Portal";

            Assert.assertEquals(driver.getTitle(), expHomePageTitle2);

            WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"user-block\"]"));
            dropDown.click();

            WebElement logOut = driver.findElement(By.xpath("//*[@id=\"popup-window-content-menu-popup-user-menu\"]/div/div/a[3]/span[2]"));
            logOut.click();

            WebElement userFieldClear2 = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
            userFieldClear2.clear();

    }

    //Marketing credentials

    @Test(priority=3)
    public void saveCredentialsTestMarketing(){


        WebElement userField3 = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement passField3 = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        WebElement checkBox3 = driver.findElement(By.id("USER_REMEMBER"));
        WebElement logInButton3 = driver.findElement(By.xpath("//input[@type='submit']"));

        userField3.sendKeys("marketing37@cydeo.com");
        passField3.sendKeys(pass);
        checkBox3.click();
        logInButton3.click();


        String expHomePageTitle3 = "Portal";

        Assert.assertEquals(driver.getTitle(), expHomePageTitle3);

        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"user-block\"]"));
        dropDown.click();

        WebElement logOut = driver.findElement(By.xpath("//*[@id=\"popup-window-content-menu-popup-user-menu\"]/div/div/a[3]/span[2]"));
        logOut.click();

    }

}
