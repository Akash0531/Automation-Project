package com.dikshatech.tst.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelWriteData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class InsuranceModule extends TestBase 
{
	
	

	@Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in HomePage*****")
	public void VerifyHomePage() throws Exception
	{
	
		Waitfor(3);
		/*//Home page object creation.
		Home_Page_Objects HP = PageFactory.initElements(driver, Home_Page_Objects.class);
		Login_Page_Objects LP = PageFactory.initElements(driver, Login_Page_Objects.class);
		IT_Support_Objects ITSprt = PageFactory.initElements(driver, IT_Support_Objects.class); 
		*/
		
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.Insurance(driver);
		Waitfor(1);
	
		// excelreaddata() Excel object creation to pass the sheet parameter.
	  	String username= excelreaddata().getData("Login_Credentials", 1, 0 ); //excelreaddata()ing Username from excel
	  	Waitfor(1);
	  	String password= excelreaddata().getData("Login_Credentials", 1, 1 ); //excelreaddata()ing Password from excel
	  	Waitfor(1);
	  				
	  
	 	String exp_url0 =   ConfigDataProvider.getProp().getProperty("url");
		String act_url0 = getCurrentUrl();
		AssertJUnit.assertEquals(act_url0, exp_url0);
		exlogger.log(LogStatus.PASS, "Application Url Verified");
		logger.info("Application Url is verified, Successfully logged-In");
		logger.info("The current Home Page URL is -: " + act_url0);
		ScreenshotCapture.GetScreenshot(driver, "perHome_Page");
		
	 	driver.manage().window().maximize();
	  	
	  	ObjectInitClass.LP.signIn(username, password);
		
		
	}

}
