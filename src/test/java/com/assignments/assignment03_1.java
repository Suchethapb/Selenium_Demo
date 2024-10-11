package com.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class assignment03_1 {
	//package com.assignment;


	//public class Assignment_3 {
		WebDriver driver;
		@Test(priority=1,enabled=false)//this will enable the class and will not be executed
		public void empty_login() throws InterruptedException {
			driver.switchTo().frame("login_page");
			driver.findElement(By.linkText("CONTINUE")).click();
			Thread.sleep(5000);
			String Act_Text = driver.switchTo().alert().getText();
			String Exp_Text = "Customer ID  cannot be left blank.";
			Assert.assertEquals(Act_Text, Exp_Text);
			driver.switchTo().alert().accept();
			
		}
		@Test(priority=2)
		public void pass_check() throws InterruptedException {
			//driver.findElement(By.name("fldLoginUserId")).clear();
			Thread.sleep(5000);
			driver.switchTo().frame("login_page");
			//driver.switchTo().frame(0);
			driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("1000");
			//driver.findElementByXPath("//img[@alt='continue']").click();
			//driver.findElement(By.xpath(""));
			driver.findElement(By.xpath("//a[normalize-space()='CONTINUE']")).click();
			driver.switchTo().defaultContent();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//label[text()='Password/IPIN']")).isDisplayed();
			//driver.switchTo().frame(1);
			//driver.findElement(By.xpath("Terms and Conditions")).click();
			
		}
		
		@BeforeTest
		public void launcher() {
			driver = new ChromeDriver();
			driver.get("https://netbanking.hdfcbank.com/netbanking/");
			driver.manage().window().maximize();
			
		}
		@AfterTest
		public void close() {
			driver.quit();
		}

	}



