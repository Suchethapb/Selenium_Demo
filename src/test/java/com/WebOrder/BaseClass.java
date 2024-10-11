package com.WebOrder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class BaseClass {
	static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

	public static WebDriver crossBrowserTesting(String browser) throws Exception {
		 if(browser.equalsIgnoreCase("firefox")){
	            driver = new FirefoxDriver();
	        } else if(browser.equalsIgnoreCase("chrome")){
	            driver = new ChromeDriver();
	        } else if(browser.equalsIgnoreCase("edge")){
	            driver = new EdgeDriver();
	        } else {
	            driver = new ChromeDriver();
	        }
	        return driver;
	    }

	    public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
	        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String destination = System.getProperty("user.dir") + "/Screenshot_Failure/" + screenshotName + dateName + ".png";
	        File finalDestination = new File(destination);
	        FileUtils.copyFile(source, finalDestination);
	        System.out.println("Screenshot saved at: " + destination);  // Log the path
	        return destination;
	    }

	    public static String getScreenshotSuccess(WebDriver driver, String screenshotName) throws Exception {
	        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String destination = System.getProperty("user.dir") + "/Screenshot_Success/" + screenshotName + dateName + ".png";
	        File finalDestination = new File(destination);
	        FileUtils.copyFile(source, finalDestination);
	        System.out.println("Screenshot saved at: " + destination);  // Log the path
	        return destination;
	    }

	    static ExtentSparkReporter htmlreporter;

	    public static void CreateExtentReport(String ReportName, String Browser){
	        String reportDirectory = "./ExtentReport/";
	        File reportDir = new File(reportDirectory);
	        if (!reportDir.exists()) {
	            reportDir.mkdir();
	            System.out.println("Created directory: " + reportDirectory);
	        }

	        String reportPath = reportDirectory + ReportName;
	        htmlreporter = new ExtentSparkReporter(reportPath);
	        extent = new ExtentReports();
	        extent.attachReporter(htmlreporter);

	        extent.setSystemInfo("OS", System.getProperty("os.name"));
	        extent.setSystemInfo("Browser", Browser);

	        htmlreporter.config().setDocumentTitle("Regression Test");
	        htmlreporter.config().setReportName(ReportName);
	        htmlreporter.config().setTheme(Theme.DARK);
	        htmlreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	        System.out.println("Extent Report created at: " + reportPath);
	    }
}
