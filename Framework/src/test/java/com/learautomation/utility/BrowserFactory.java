package com.learautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver startapplication(WebDriver driver, String browserName,String appURL)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\muskan.begum\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}/*
		else if(browserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "URL");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "URL");
			driver = new InternetExplorerDriver();
		}*/
		else
		{
			System.out.println("wedo notsupport this browser ");
		}
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

		 driver.manage().window().maximize();
		driver.get(appURL);;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		//return;
	
	}
	
	public static void quitBrowser(WebDriver driver) 
	{
		driver.quit();;
	}

}
