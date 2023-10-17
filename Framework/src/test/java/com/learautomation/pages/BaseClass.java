package com.learautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learautomation.utility.BrowserFactory;
import com.learautomation.utility.ConfigDataProvider;
import com.learautomation.utility.ExceldataProvider;
import com.learautomation.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExceldataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports  report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up reports and test is getting ready" , true);
		
		excel= new ExceldataProvider();
		config = new ConfigDataProvider();
	 														//I removed the  setproperty("user.dir")
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File("C:\\Users\\muskan.begum\\Downloads\\Workspace_for_framework\\Framework\\Reports\\"+ Helper.getCurrentDateTime() +".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting done test can be started" , true);
	
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start browser and getting read application" , true);
		//driver=BrowserFactory.startapplication(driver, "Chrome", "http://10.82.180.36/Common/Login.aspx");
		driver=BrowserFactory.startapplication(driver,config.getBrowser(),config.getStringURL());
		System.out.println(driver.getTitle());
		
		Reporter.log("browse and application is up and running" , true);
	}
	
	@AfterClass
	public void tearDown()
	{	
	    BrowserFactory.quitBrowser(driver);
		
	}
	@AfterMethod // run at every test case
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end" , true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.captureScreenshots(driver);
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed" , MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		
		report.flush();
		
		Reporter.log("Test completed >>> Reports generated" , true);
	}
	
	
}
