package com.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class assignment01 {
	

	
		WebDriver driver;
		@BeforeTest
		public void pre_condition() {
			//WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
			driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
			driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");
			driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']")).click();
		}
		@AfterTest
		public void post_condition() {
			
			driver.findElement(By.linkText("Logout")).click();
			driver.close();
		}
		
		@Test(dataProvider="product",dataProviderClass=assignments01_testcase.class)
		public void Create_Order(String select) {
			driver.findElement(By.linkText("View all products")).click();
			String expValue = driver.findElement(By.xpath("//td[normalize-space()='"+select+"']/following-sibling::td[1]")).getText();
			expValue = expValue.substring(1);
			driver.findElement(By.linkText("Order")).click();
			Select se = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
			se.selectByValue(select);
			String actValue = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']")).getAttribute("value");	
			Assert.assertEquals(expValue, actValue);
		}
	}
	


