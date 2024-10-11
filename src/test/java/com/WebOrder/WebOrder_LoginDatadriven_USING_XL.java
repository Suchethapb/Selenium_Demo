package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class WebOrder_LoginDatadriven_USING_XL extends weborder_TestData {
	WebDriver driver;// = new ChromeDriver();

	@Test(dataProvider = "LoginExcelData", priority = 1)
	public void login_toapp(String uname, String pass) throws InterruptedException {
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys(uname);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(pass);
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.linkText("Logout")).isDisplayed();
		driver.findElement(By.linkText("Logout")).click();
//		Thread.sleep(2000);

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();

	}

	@Beforetest
	public void openBrowser() {
		//WebDriverManager.firefoxdriver().setup();
		driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
		driver.manage().window().maximize();

	}

}
