package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class assignment01 extends assignment_testdata {
	ChromeDriver driver;
	

	@Test(dataProvider = "Login")
	public void login(String value) throws InterruptedException {
		driver.findElement(By.linkText("View all products")).click();
//		String expvalueMyMoney = driver.findElement(By.xpath("//td[normalize-space()='$100']")).getText();
//		System.out.println(expvalueMyMoney);
//		String expvalueFamAlb = driver.findElement(By.xpath("//td[normalize-space()='$80']")).getText();
//		String expvaluScreen = driver.findElement(By.xpath("//td[normalize-space()='$20']")).getText();
		// driver.findElement(By.xpath("//a[normalize-space()='View all
		// products']")).click();
		// String expValue =
		String expval= driver.findElement(By.xpath("//td[normalize-space()='"+value+"']/following-sibling::td[1]")).getText();
		expval=expval.substring(1);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[normalize-space()='Order']")).click();
		// Select dropdown = new
		// Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
		// dropdown.selectByValue(value);
		String actValue = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']")).getAttribute("value");	
		Assert.assertEquals(expval, actValue);
		// Assert.assertTrue(expValue.contains(actValue));
		// System.out.println("done for: "+name+" Actual value: "+ actValue+", exp
		// Value: "+expValue);
	}

	@AfterTest
	public void cloasbrowser() {
		driver.quit();
	}

	@Beforetest
	public void openBrowser() {
		// WebDriverManager.firefoxdriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$login_button']")).click();
		

	}

}
