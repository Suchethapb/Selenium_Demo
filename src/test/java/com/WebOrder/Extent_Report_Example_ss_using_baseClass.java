package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report_Example_ss_using_baseClass {
	

	
	    WebDriver driver;
	    ExtentTest test;

	    @BeforeClass
	    public void startReport() {
	        BaseClass.CreateExtentReport("WebOrder_Regression_Report.html", "Firefox");
	    }

	    @BeforeTest
	    public void launchBrowser() {
	        driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
	    }

	    @Test(priority = 1)
	    public void webOrder_Login() throws Exception {
	        test = BaseClass.extent.createTest("Test Case 1", "Login to WebOrder");

	        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
	        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");
	        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$login_button']")).click();
	        driver.findElement(By.linkText("Logout")).isDisplayed();
	        String actListElementName = driver.findElement(By.xpath("//h2[normalize-space()='List of All Orders']")).getText();
	        String expListElementName = "List of All Orders";
	        Assert.assertEquals(expListElementName, actListElementName);
	        String actTitle = driver.getTitle();
	        String expTitle = "Web Orders";
	        Assert.assertEquals(expTitle, actTitle);
	        String actURL = driver.getCurrentUrl();
	        String expURL = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx";
	        Assert.assertEquals(expURL, actURL);
	    }

	    @Test(priority = 2)
	    public void createOrder_BaseClass() {
	        test = BaseClass.extent.createTest("Test Case 2", "Create Order");
	        driver.findElement(By.linkText("Order")).click();
	        Select product = new Select(driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct")));
	        product.selectByVisibleText("FamilyAlbum");
	        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys("5");
	        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("Dixit");
	        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("ABC");
	        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Redwood");
	        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("5");
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
	        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("123456789");
	        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("12/23");
	        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	        String expSuccessMsg = driver.findElement(By.xpath("//strong[normalize-space()='New order has been successfully added.']")).getText();
	        String actSuccessMsg = "New order has been successfully added";
	        Assert.assertEquals(expSuccessMsg, actSuccessMsg);
	        driver.findElement(By.linkText("View all Orders")).click();
	        String actUserName = driver.findElement(By.xpath("//td[text()='Dixit']")).getText();
	        String expUserName = "Dixit";
	        Assert.assertEquals(expUserName, actUserName);
	    }

	    @AfterMethod
	    public void captureScreenShot(ITestResult result) throws Exception {
	        if (ITestResult.FAILURE == result.getStatus()) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " = FAILED ", ExtentColor.RED));
	            test.fail(result.getThrowable());
	            String screenshotPath = BaseClass.getScreenshot(driver, result.getName());
	            test.addScreenCaptureFromPath(screenshotPath);
	        } else if (ITestResult.SUCCESS == result.getStatus()) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " = PASSED ", ExtentColor.GREEN));
	            String screenshotPath = BaseClass.getScreenshotSuccess(driver, result.getName());
	            test.addScreenCaptureFromPath(screenshotPath);
	        }
	    }

	    @AfterTest
	    public void closeBrowser() {
	        driver.quit();
	        BaseClass.extent.flush(); // Ensure ExtentReports is properly flushed
	    }
	}