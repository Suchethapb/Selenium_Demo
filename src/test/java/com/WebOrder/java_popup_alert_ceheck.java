package com.WebOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class java_popup_alert_ceheck {
	WebDriver driver;

	@Test
	public void JS_Alert() {

		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		String Act_Text = driver.switchTo().alert().getText();
		String Exp_Text = "I am a JS Alert";
		Assert.assertEquals(Act_Text, Exp_Text);
		driver.switchTo().alert().accept();
	}

	@Test
	public void JS_Confirm() {

		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		String Act_Text = driver.switchTo().alert().getText();
		String Exp_Text = "I am a JS Confirm";
		Assert.assertEquals(Act_Text, Exp_Text);
		driver.switchTo().alert().dismiss();
	}

	@Test
	public void JS_Prompt() {

		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		driver.switchTo().alert().sendKeys("Abhi");
		driver.switchTo().alert().accept();
		String Act_Text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String Exp_Text = "You entered: Abhi";
		Assert.assertEquals(Act_Text, Exp_Text);

	}

	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}
}
