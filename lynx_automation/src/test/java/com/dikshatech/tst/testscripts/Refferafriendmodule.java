package com.dikshatech.tst.testscripts;
	
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.dataprovider.ExcelWriteData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;


	public class Refferafriendmodule  extends TestBase
	
	{
	
		@Test(priority=1, enabled=true,description= "*****Validation of Refer a friend*****")
		public void Verifyreferafriend() throws Exception
		{
			
				// Repository object creation.
				ObjectInitClass.homepage(driver);
				ObjectInitClass.loginpage(driver);
				ObjectInitClass.refferAFriendPage(driver);

				// Read Excel object creation to pass the sheet parameter.
				String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
				Waitfor(1);
				String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
				Waitfor(1);

				ObjectInitClass.LP.signIn(username, password);
			
			//Validating the Lynx Home page URL for successful login confirmation
			String exp_url0 =  ConfigDataProvider.getProp().getProperty("url");
			String act_url0 = getCurrentUrl();
			softassert().assertEquals(act_url0, exp_url0);
			exlogger.log(LogStatus.PASS, "Application Url Verified");
			logger.info("Application Url is verified, Successfully logged-In");
			logger.info("The current Home Page URL is -: " + act_url0);
			ScreenshotCapture.GetScreenshot(driver, "refera friend page");
		
	
			ObjectInitClass.Rf.my_reference_tab();
			Waitfor(2);
			ObjectInitClass.Rf. Referee_module();
			
			String name=excelreaddata().getData("Referafriend_sheet", 1,0);
			Waitfor(1);
			
			String departments=excelreaddata().getData("Referafriend_sheet", 1, 1);
			Waitfor(1);
			String experiencelevel = excelreaddata().getData("Referafriend_sheet",1,2);
			Waitfor(1);
		
			String Job_Title=excelreaddata().getData("Referafriend_sheet", 1,3);
			Waitfor(1);
			
			String comments=excelreaddata().getData("Referafriend_sheet", 1,4);
			Waitfor(1);
			
			String file_description=excelreaddata().getData("Referafriend_sheet", 1,5);
			Waitfor(1);
			
			ObjectInitClass.Rf.referee_enter_details(name, departments, experiencelevel,Job_Title, comments);
			Waitfor(1);
			
			ObjectInitClass.Rf.uploadprofile("file_description");
			Waitfor(1);
			
			ObjectInitClass.Rf.referfriend_submit_button();
			Waitfor(2);
		}		
		


}
