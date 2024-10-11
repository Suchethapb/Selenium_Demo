package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webOrder_HeadlessBrowsers {
	WebDriver driver;

	@Test
	public void Firefox_Headless() {

		// WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		// FirefoxOptions options = new FirefoxOptions();
		FirefoxOptions options = new FirefoxOptions();

		options.addArguments("-headless=new");
		// options.addArguments("incognito");
		driver = new FirefoxDriver(options);
		// driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.linkText("Logout")).isDisplayed();
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.name("ctl00$MainContent$login_button")).isDisplayed();
		driver.quit();
	}

}
