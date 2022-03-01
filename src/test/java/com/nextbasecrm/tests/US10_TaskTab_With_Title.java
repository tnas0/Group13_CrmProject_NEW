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

public class US10_TaskTab_With_Title {
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
    //first test case - Create Task with title and message with Hr User -POSITIVE SCENARIO
    @Test
    public void task_with_title_hrUser(){
        //step1-user go to homepage
        WebElement inputUserName=driver.findElement(By.xpath("//input[@class='login-inp']"));
        inputUserName.sendKeys("hr37@cydeo.com");

        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("UserUser");
        WebElement loginBtn= driver.findElement(By.xpath("//input[@class='login-btn']"));
        BrowserUtils.sleep(3);
        loginBtn.click();
        //step2-User click task button and system display task table
        WebElement TaskTAB=driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        TaskTAB.click();
        WebElement bodyTable= driver.findElement(By.xpath("//div[@id='fulloPostFormLHE_blogPostForm']"));

        System.out.println("bodyTable.isDisplayed() = " + bodyTable.isDisplayed());

        //step3-user provide title and message

        WebElement title= driver.findElement(By.xpath("//input[@data-bx-id='task-edit-title']"));
        title.sendKeys("task sample title");
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='bx-html-editor-iframe-cnt-lifefeed_task_form']//iframe")));
        WebElement message = driver.findElement(By.xpath("//*[@contenteditable='true']"));
        message.click();

        message.sendKeys("sample message");
        driver.switchTo().parentFrame();

    /*   WebElement message= driver.findElement(By.xpath("//div[@class='bxhtmled-dummy-target']"));
       message.sendKeys("Sample message");*/
        //user click send button and create task successfully
        WebElement sendBtn= driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendBtn.click();
        BrowserUtils.sleep(3);
        WebElement taskCreated= driver.findElement(By.xpath("//div[@class='feed-task-info-text-item']"));
        taskCreated.isDisplayed();


        // WebElement logout= driver.findElement(By.xpath("span=[@class='menu-popup-item-text']"));
        // logout.click();
    }
    // second test case - Create Task with title and message with helpdesk User -POSITIVE SCENARIO
    @Test
    public void task_with_title_helpdeskUser(){
        //step1-user go to homepage
        WebElement inputUserName=driver.findElement(By.xpath("//input[@class='login-inp']"));
        inputUserName.sendKeys("helpdesk37@cydeo.com");

        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("UserUser");
        WebElement loginBtn= driver.findElement(By.xpath("//input[@class='login-btn']"));
        BrowserUtils.sleep(3);
        loginBtn.click();
        //step2-User click task button and system display task table
        WebElement TaskTAB=driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        TaskTAB.click();
        WebElement bodyTable= driver.findElement(By.xpath("//div[@id='fulloPostFormLHE_blogPostForm']"));

        System.out.println("bodyTable.isDisplayed() = " + bodyTable.isDisplayed());

        //step3-user provide title and message

        WebElement title= driver.findElement(By.xpath("//input[@data-bx-id='task-edit-title']"));
        title.sendKeys("task sample title");
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='bx-html-editor-iframe-cnt-lifefeed_task_form']//iframe")));
        WebElement message = driver.findElement(By.xpath("//*[@contenteditable='true']"));
        message.click();

        message.sendKeys("sample message");
        driver.switchTo().parentFrame();

    /*   WebElement message= driver.findElement(By.xpath("//div[@class='bxhtmled-dummy-target']"));
       message.sendKeys("Sample message");*/
        //user click send button and create task successfully
        WebElement sendBtn= driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendBtn.click();
        BrowserUtils.sleep(3);
        WebElement taskCreated= driver.findElement(By.xpath("//div[@class='feed-task-info-text-item']"));
        taskCreated.isDisplayed();


        // WebElement logout= driver.findElement(By.xpath("span=[@class='menu-popup-item-text']"));
        // logout.click();
    }
    //third test case - Create Task with title and message with Marketing User -POSITIVE SCENARIO
    @Test
    public void task_with_title_marketingUser(){
        //step1-user go to homepage
        WebElement inputUserName=driver.findElement(By.xpath("//input[@class='login-inp']"));
        inputUserName.sendKeys("marketing37@cydeo.com");

        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("UserUser");
        WebElement loginBtn= driver.findElement(By.xpath("//input[@class='login-btn']"));
        BrowserUtils.sleep(3);
        loginBtn.click();
        //step2-User click task button and system display task table
        WebElement TaskTAB=driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        TaskTAB.click();
        WebElement bodyTable= driver.findElement(By.xpath("//div[@id='fulloPostFormLHE_blogPostForm']"));

        System.out.println("bodyTable.isDisplayed() = " + bodyTable.isDisplayed());

        //step3-user provide title and message

        WebElement title= driver.findElement(By.xpath("//input[@data-bx-id='task-edit-title']"));
        title.sendKeys("task sample title");
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='bx-html-editor-iframe-cnt-lifefeed_task_form']//iframe")));
        WebElement message = driver.findElement(By.xpath("//*[@contenteditable='true']"));
        message.click();

        message.sendKeys("sample message");
        driver.switchTo().parentFrame();

    /*   WebElement message= driver.findElement(By.xpath("//div[@class='bxhtmled-dummy-target']"));
       message.sendKeys("Sample message");*/
        //user click send button and create task successfully
        WebElement sendBtn= driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendBtn.click();
        BrowserUtils.sleep(3);
        WebElement taskCreated= driver.findElement(By.xpath("//div[@class='feed-task-info-text-item']"));
        taskCreated.isDisplayed();


        // WebElement logout= driver.findElement(By.xpath("span=[@class='menu-popup-item-text']"));
        // logout.click();
    }



}
