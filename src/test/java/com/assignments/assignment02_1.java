package com.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class assignment02_1 {
	WebDriver driver;
	@Test(priority=1)
	
	
	@BeforeTest
	public void pre_condition() throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector("body > div:nth-child(3) > aside:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")).click();
		//driver.findElement(By.className("button-1 login-button")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[@href='#']//p[contains(text(),'Customers')]")).click();
	}

}
