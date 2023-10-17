package com.learautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;

import freemarker.template.SimpleDate;

public class Helper {

	public static String captureScreenshots(WebDriver driver)
	{
		File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = "C:\\Users\\muskan.begum\\Downloads\\Workspace_for_framework\\Framework\\Screenshots\\" +getCurrentDateTime() +".png";
		
		try {
			
			//Files.copy(src, new File("C:\\Users\\muskan.begum\\Downloads\\Workspace_for_framework\\Framework\\Screenshots\\" +getCurrentDateTime() +".png"));
			Files.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot "+e.getMessage());
		}
		return screenshotPath;
	}
	
	public static  String getCurrentDateTime()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate= new Date();
		
		return customformat.format(currentDate);
	}
}
