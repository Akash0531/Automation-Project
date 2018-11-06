package com.dikshatech.tst.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelWriteData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ITAssetsModule extends TestBase  

{
	//Login the Lynx application
	@Test(priority=0, enabled=true,description= "*****Validation of all the webelement and functionalities composed in HomePage*****")
	public void VerifyHomePage() throws Exception
	{
		// Repository object creation.
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.ITAssetsObjects(driver);

		// excelreaddata() Excel object creation to pass the sheet parameter.
		String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //excelreaddata()ing Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //excelreaddata()ing Password from excel
		Waitfor(1);

		ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);
		
	}	
}
