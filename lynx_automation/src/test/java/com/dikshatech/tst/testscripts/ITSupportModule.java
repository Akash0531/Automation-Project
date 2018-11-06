package com.dikshatech.tst.testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelWriteData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ITSupportModule extends TestBase
{
	
	 String Requestid="";
	
	
	@Test(priority=0, enabled=true,description= "*****Validation of all the webelement and functionalities composed in HomePage*****")
	public void VerifyHomePage() throws Exception
	{
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.IT_Support(driver);
		Waitfor(1);
	
		// excelreaddata() Excel object creation to pass the sheet parameter.
	  	String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //excelreaddata()ing Username from excel
	  	Waitfor(1);
	  	String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //excelreaddata()ing Password from excel
	  	Waitfor(1);
	  	ObjectInitClass.LP.signIn(username, password);		
	  /*
	  	String exp_url0 =   ConfigDataProvider.prop.getProperty("url");
	  	String act_url0 = get_Current_Url();
	  	soft_assert.assertEquals(act_url0, exp_url0);
	  	logger.log(LogStatus.INFO, "Application Url Verified");
	  	logger.info("Application Url is verified, Successfully logged-In");
		logger.info("The current Home Page URL is -: " + act_url0);
		Screenshot_Capture.GetScreenshot(driver, "ITSupportHome_Page");
	  	Waitfor(3);
			*/
	}
	
	@Test(priority=1, enabled=true)
	public void employeeLevel()
	{
		Waitfor(2);
		ObjectInitClass.ITSprt.clickMyRequest();
		Waitfor(2);
	  	ObjectInitClass.ITSprt.itSupport();
	  	Waitfor(2);
	  	
	 // Create Request save Request,  Edit Request and Delete Request 
	    ObjectInitClass.ITSprt.newRequest();
	   	Waitfor(1);
	  	String ITRequestName= excelreaddata().getData("ITSuport", 2, 0 ); //excelreaddata()ing Request from excel
	  	Waitfor(1);
	  	String Summary= excelreaddata().getData("ITSuport", 2, 1 ); //excelreaddata()ing Summary from excel
	  	Waitfor(1);
	  	String Description= excelreaddata().getData("ITSuport", 2, 2 ); //excelreaddata()ing Description from excel
	  	Waitfor(1);
	  	String Coments= excelreaddata().getData("ITSuport", 2, 3 ); //excelreaddata()ing Comments from excel
	  	Waitfor(1);
	  	
	   ObjectInitClass.ITSprt.raise_Request(ITRequestName, Summary, Description, Coments);
	   Waitfor(2);
	   ObjectInitClass.ITSprt.saveRequest();
	   Waitfor(2);
	   //ObjectInitClass.ITSprt.searchfield("IN-IS-2321");
	   ObjectInitClass.ITSprt.selectEmpHomePage();
	   Waitfor(1);
	 //Scenario 2:Edit Request  as a employee
	   ObjectInitClass.ITSprt.editRequest();
	   Waitfor(1);
	   ObjectInitClass.ITSprt.selectEmpHomePage();
	   Waitfor(2);
	 //Scenario 3: Delete Request  as a employee
	   ObjectInitClass.ITSprt.deleteRequest();
	   Waitfor(2);
	 
	   
	   // Scenario 4 :Create and Cancel Request
	   ObjectInitClass.ITSprt.newRequest();
	   Waitfor(2);
	   ObjectInitClass.ITSprt.raise_Request(ITRequestName, Summary, Description, Coments);
	   Waitfor(2);
	   ObjectInitClass.ITSprt.submit();
	   Waitfor(2);
	   ObjectInitClass.ITSprt.selectEmpHomePage();
	   Waitfor(2);
	   // Scenario 5 : Cancel Request
	   ObjectInitClass.ITSprt.cancelFunction();
	   Waitfor(2);
	  // ObjectInitClass.ITSprt.checkStatusByEmp();
	   Waitfor(2);
	   
	  	// Create a New Request
	  	String ITRequestName1= excelreaddata().getData("ITSuport", 2, 0 ); //excelreaddata()ing Request from excel
	  	Waitfor(1);
	  	String Summary1= excelreaddata().getData("ITSuport", 2, 1 ); //excelreaddata()ing Summary from excel
	  	Waitfor(1);
	  	String Description1= excelreaddata().getData("ITSuport", 2, 2 ); //excelreaddata()ing Description from excel
	  	Waitfor(1);
	  	String Coments1= excelreaddata().getData("ITSuport", 2, 3 ); //excelreaddata()ing Comments from excel
	  	Waitfor(1);
	  	
	   ObjectInitClass.ITSprt.newRequest();
	   Waitfor(1);
	   ObjectInitClass.ITSprt.raise_Request(ITRequestName1, Summary1, Description1, Coments1);
	   Waitfor(1);
	   ObjectInitClass.ITSprt.submit();
	   Waitfor(2);
	   // Scenario 6 :status checking 
	   ObjectInitClass.ITSprt.checkStatusByEmp();
	   Waitfor(3);
	   Requestid=ObjectInitClass.ITSprt.requestID();
	   Waitfor(2);
	   ObjectInitClass.HP.Log_Out();
	   Waitfor(3);
			
	}
	
	@Test(priority=2, enabled=true)
	public void adminLevelResolve()
	{
		/// Scenario 7: Admin level Assign Functionality
		
		// Object_InitClass.HP.Log_Out();
	  	String username1= excelreaddata().getData("Login_Credentials", 2, 0 ); //excelreaddata()ing Username from excel
	  	Waitfor(1);
	  	String password1= excelreaddata().getData("Login_Credentials", 2, 1 ); //excelreaddata()ing Password from excel
	  	Waitfor(1);
	  	ObjectInitClass.LP.signIn(username1, password1);
	  	Waitfor(3);
	  	ObjectInitClass.ITSprt.clickMyRequest();
		Waitfor(2);
	  	ObjectInitClass.ITSprt.itSupport();
	  	Waitfor(15);
	    ObjectInitClass.ITSprt.requestTab();
	  	Waitfor(3);
	  	ObjectInitClass.ITSprt.searchmethod(Requestid);
	  	Waitfor(1);
	  	ObjectInitClass.ITSprt.selectEmployeeRequestTab();
	  	//ObjectInitClass.ITSprt.Pagination();
	 // Scenario 8 :assign functionality 
	  	Waitfor(1);
	  	ObjectInitClass.ITSprt.clickAssign();
	  	Waitfor(2);
	    ObjectInitClass.ITSprt.adminAssignLevel();
		Waitfor(1);
		ObjectInitClass.ITSprt.submitDuringAssign();
		Waitfor(10);
		
		// Scenario 9: Admin To Close or In-progress and Resolved 
		ObjectInitClass.ITSprt.requestTab();
		Waitfor(2);
		ObjectInitClass.ITSprt.searchmethod(Requestid);
		Waitfor(1);
		ObjectInitClass.ITSprt.selectEmployeeRequestTab();
		Waitfor(1);
		//ObjectInitClass.ITSprt.Pagination();
	  	ObjectInitClass.ITSprt.clickAssign();
	  	Waitfor(1);
	  	
		String Status= excelreaddata().getData("ITSuport", 1, 5 ); //excelreaddata()ing Status During Assigned from excel
	  	Waitfor(1);
	  	String Remark= excelreaddata().getData("ITSuport", 1, 6 ); //excelreaddata()ing Remarks During Assigned from excel
	  	Waitfor(1);
	    ObjectInitClass.ITSprt.adminLevel(Status, Remark);
	    Waitfor(1);
		ObjectInitClass.ITSprt.submitatResolveLevel();
		Waitfor(15);
		ObjectInitClass.ITSprt.requestTab();
		Waitfor(2);
		ObjectInitClass.ITSprt.searchmethod(Requestid);
		Waitfor(1);
		ObjectInitClass.ITSprt.checkStatusAtAdmin();
		Waitfor(3);
		ObjectInitClass.HP.Log_Out();
	    Waitfor(3);
	
		
	}
	
	@Test(priority=3, enabled=true)
	public void empLevelreOpen()
	{
		 // Scenario 10:Reopen request functionality
		String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //excelreaddata()ing Username from excel
	  	Waitfor(1);
	  	String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //excelreaddata()ing Password from excel
	  	Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
	  	Waitfor(3);
	  	ObjectInitClass.ITSprt.clickMyRequest();
		Waitfor(2);
	  	ObjectInitClass.ITSprt.itSupport();
	  	Waitfor(2);
	  	ObjectInitClass.ITSprt.checkStatusByEmp();
		Waitfor(2);
		ObjectInitClass.ITSprt.selectEmpHomePage();
		Waitfor(2);
		 // Scenario 11 :Close functionality
		ObjectInitClass.ITSprt.closeFunction();
		Waitfor(2);
		ObjectInitClass.ITSprt.checkStatusByEmp();
		Waitfor(2);
		ObjectInitClass.ITSprt.selectEmpHomePage();
		Waitfor(2);
	  	ObjectInitClass.ITSprt.reopenIcon();
		Waitfor(1);
		 // Scenario 12:Reopen functionality
	  	ObjectInitClass.ITSprt.reopenRequest();
	  	Waitfor(2);
	  	ObjectInitClass.ITSprt.checkStatusByEmp();
	  	Waitfor(2);
	  	//ObjectInitClass.HP.Log_Out();
	  	Waitfor(2);
 
	}
		
}
