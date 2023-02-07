package org.redbus;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.pojo.SigninPojo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utility.BaseClass;

public class RedbusProject extends BaseClass {

	@BeforeMethod
	private void startDate() {
		launchBrowser();
		maxi();
		Date d=new Date();
		System.out.println(d);
	}
	
	@Test
	private void tc1() throws IOException {
		launchUrl("https://www.redbus.in/");
		System.out.println("test case 1");
	
		SigninPojo s=new SigninPojo();
	
		WebElement c=s.getBtntxt();
		btnclick(c);

		WebElement sin=s.getStxt();
		btnclick(sin);
		
		driver.switchTo().frame(1);
		
		FluentWait<WebDriver> f1=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10)).ignoring(Exception.class);
		f1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter your mobile number']")));
		
		WebElement e=s.getSignTxt();
		
		sendKeys(excelRead("Sheet1",0,1),e);
		
		//passtext(e, excelRead("Sheet1",0,1));
		
		
		
	}
	
	
	@AfterMethod
	private void endDate() {
		Date d=new Date();
		System.out.println(d);
		
	}
}
