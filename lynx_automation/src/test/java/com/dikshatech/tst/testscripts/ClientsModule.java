package com.dikshatech.tst.testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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

public class ClientsModule extends TestBase
{
 
	@Test(priority=0, enabled=true,description= "*****Validation of all the webelement and functionalities composed clients*****")
		public void clients() throws Exception
		{
			
			// Repository object creation.
			ObjectInitClass.homepage(driver);
			ObjectInitClass.loginpage(driver);
			ObjectInitClass.clientsobjects(driver);
		
			String username= excelreaddata().getData("Login_Credentials", 1, 0 ); //excelreaddata()ing Username from excel
			Waitfor(2);
			String password= excelreaddata().getData("Login_Credentials", 1, 1 ); //excelreaddata()ing Password from excel
			Waitfor(2);

			ObjectInitClass.LP.signIn(username, password);
			Waitfor(5);
		//Validating the Lynx Home page URL for successful login confirmation
		String exp_url0 =  ConfigDataProvider.getProp().getProperty("url");
		String act_url0 = getCurrentUrl();
		softassert().assertEquals(act_url0, exp_url0);
		exlogger.log(LogStatus.PASS, "Application Url Verified");
		logger.info("Application Url is verified, Successfully logged-In");
		logger.info("The current Home Page URL is -: " + act_url0);
		ScreenshotCapture.GetScreenshot(driver, "refera friend page");
			
			//validating the clients url

			
			String region=excelreaddata().getData("Clients_sheet", 1, 0 );
			String  department=excelreaddata().getData("Clients_sheet", 1,1);
			String cetegeory =excelreaddata().getData("Clients_sheet", 1, 2 );
		    String Description=excelreaddata().getData("Clients_sheet", 1,3);
		    String name=excelreaddata().getData("Clients_sheet",1,4 );
			

			//Scenario 1:create a new client 
			ObjectInitClass.Cl.clickon_clients_module();
			Waitfor(2);
			ObjectInitClass.Cl.clickon_new_clients();
			Waitfor(2);
			ObjectInitClass.Cl.clientdeatils(region,department,cetegeory,name,Description);
			Waitfor(2);
			//Scenario 2:edit a client 
			ObjectInitClass.Cl.editclient(region, department,cetegeory,name,Description);
			Waitfor(2);
			//Scenario 3:view a client 
			ObjectInitClass.Cl. viewpage(name);
			Waitfor(2);	
			
		}
		
		
}
			