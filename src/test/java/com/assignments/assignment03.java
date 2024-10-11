package com.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class assignment03 {
	WebDriver driver;
	@Test
	public void JS_Alert() {

		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		String Act_Text = driver.switchTo().alert().getText();
		String Exp_Text = "I am a JS Alert";
		Assert.assertEquals(Act_Text, Exp_Text);
		driver.switchTo().alert().accept();
	}

	@BeforeTest
	public void pre_condition() throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		Thread.sleep(5000);
		//driver.findElement(By.cssSelector("body > div:nth-child(3) > aside:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")).click();
		//driver.findElement(By.className("button-1 login-button")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary.login-btn")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@href='#']//p[contains(text(),'Customers')]")).click();

}
	@AfterTest
	public void post_condition() {
		//driver.findElement(By.linkText("Logout")).click();
		driver.close();
	} }
