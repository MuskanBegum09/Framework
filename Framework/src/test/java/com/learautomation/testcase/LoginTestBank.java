package com.learautomation.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learautomation.pages.BaseClass;
import com.learautomation.pages.LoginPage;
import com.learautomation.utility.BrowserFactory;
import com.learautomation.utility.ExceldataProvider;
import com.learautomation.utility.Helper;

public class LoginTestBank extends BaseClass {

	
	@Test(priority = 1)
	public void loginApp()
	{
		logger=report.createTest("Login to bank");
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		//loginPage.loginToBank("donhere", "don@123"); //for direct data
	    
		logger.info("Starting application");
		
		loginPage.loginToBank(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));// by excel sheet
		
	    logger.pass("Login success");
	}
	
	/*@Test(priority = 2)
	public void loginApp1()
	{
		logger=report.createTest("Logout");
		logger.fail("Logout failed");
	}*/
	
}
