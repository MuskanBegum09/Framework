package com.learautomation.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class TestCasewithoutframework {
	WebDriver driver;
	@Test
	public void test1()
	
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\muskan.begum\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver= new ChromeDriver();
		
		
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\muskan.begum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	   // driver = new InternetExplorerDriver();
	    driver.get("http://10.82.180.36/Common/Login.aspx");
	
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
	    driver.findElement(By.name("ctl00$body$txtPassword")).sendKeys("don@123");
	    
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	}

}
