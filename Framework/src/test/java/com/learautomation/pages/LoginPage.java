package com.learautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
// constructor	
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(name="ctl00$body$txtUserID") WebElement uname;//uname is a variable
	@FindBy(name="ctl00$body$txtPassword") WebElement pass;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbutton;
	
	public void loginToBank(String usernameapp , String passwordapp)
	{
		try {
		Thread.sleep(2000);
		} catch(InterruptedException e)
		{
			
		}
		
		uname.sendKeys(usernameapp);
		pass.sendKeys(passwordapp);
		loginbutton.click();
	
	}
}
