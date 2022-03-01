package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US9_correctTittle {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");
        CRM_Utilities.crm_login(driver, "hr37@cydeo.com", "UserUser");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_HrUserNavigationToActivityModule() {

        WebElement ActivityStream = driver.findElement(By.xpath("//a[@title='Activity Stream']"));
        ActivityStream.click();
        BrowserUtils.verifyTitle(driver, "Portal");

    }

    @Test
    public void test_HrUserNavigationToTaskModule() {

        WebElement TasksModule = driver.findElement(By.xpath("//a[@title='Tasks']"));
        TasksModule.click();
        BrowserUtils.verifyTitle(driver, "Site map");
    }

    @Test
    public void test_HrUserNavigationToChatAndCallsModule() {


        WebElement ChatAndCalls = driver.findElement(By.xpath("//a[@title='Chat and Calls']"));
        ChatAndCalls.click();
        BrowserUtils.verifyTitle(driver, "Chat and Calls");
    }

    @Test
    public void test_HrUserNavigationToWorkgroupsModule() {


        WebElement Workgroups = driver.findElement(By.xpath("//a[@title='Workgroups']"));
        Workgroups.click();
        BrowserUtils.verifyTitle(driver, "Workgroups and projects");
    }

    @Test
    public void test_HrUserNavigationToDriveModule() {


        WebElement DriveModule = driver.findElement(By.xpath("//a[@title='Drive']"));
        DriveModule.click();
        BrowserUtils.verifyTitle(driver, "Site map");
    }

    @Test
    public void test_HrUserNavigationToCalendarModule() {


        WebElement CalendarModule = driver.findElement(By.xpath("//a[@title='Calendar']"));
        CalendarModule.click();
        BrowserUtils.verifyTitle(driver, "Site map");
    }

    @Test
    public void test_HrUserNavigationToContactCenterModule() {

        WebElement ContactCenterModule = driver.findElement(By.xpath("//a[@title='Contact Center']"));
        ContactCenterModule.click();
        BrowserUtils.verifyTitle(driver, "Contact Center");
    }

    @Test
    public void test_HrUserNavigationToTimeAndReportsModule() {

        WebElement TimeAndReportsModule = driver.findElement(By.xpath("//a[@title='Time and Reports']"));
        TimeAndReportsModule.click();
        BrowserUtils.verifyTitle(driver, "Absence Chart");
    }

    @Test
    public void test_HrUserNavigationToEmployeesModule() {

        WebElement EmployeesModule = driver.findElement(By.xpath("//a[@title='Employees']"));
        EmployeesModule.click();
        BrowserUtils.verifyTitle(driver, "Company Structure");
    }

    @Test
    public void test_HrUserNavigationToServicesModule() {

        WebElement ServicesModule = driver.findElement(By.xpath("//a[@title='Services']"));
        ServicesModule.click();
        BrowserUtils.verifyTitle(driver, "Meeting Rooms");
    }

    @Test
    public void test_HrUserNavigationToCompanyModule() {

        WebElement CompanyModule = driver.findElement(By.xpath("//a[@title='Company']"));
        CompanyModule.click();
        BrowserUtils.verifyTitle(driver, "Company");
    }
}


