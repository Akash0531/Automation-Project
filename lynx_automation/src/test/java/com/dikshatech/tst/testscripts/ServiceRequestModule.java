package com.dikshatech.tst.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
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

public class ServiceRequestModule extends TestBase
{
	@Test(priority=0, enabled=true,description= "*****Validation of all the webelement and functionalities composed in service Request...*****")
	public void VerifyHomePage() throws Exception
	{
		
		//Home page object creation.
		
		
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.Service_Request(driver);
		
	  
	}
	
	@Test(priority=1, enabled=true)
	public void createandCancelRequest()
	{
		// Read Excel object creation to pass the sheet parameter.
	  	String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //Reading Username from excel

	  	String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //Reading Password from excel
	  
	  	ObjectInitClass.LP.signIn(username, password);
	  	Waitfor(2);
	  	
		String issuename= excelreaddata().getData("ServiceRequest", 1, 0 ); //Reading issuename from excel
		String sumry= excelreaddata().getData("ServiceRequest", 1, 1 ); //Reading sumry from excel
		String description= excelreaddata().getData("ServiceRequest", 1, 2 ); //Reading description from excel
		String depandant= excelreaddata().getData("ServiceRequest", 1, 3 ); //Reading depandant from excel
		Waitfor(2);
		//Create and Cancel Request from employee
		ObjectInitClass.SerRequest.myrequestTab();
		Waitfor(2);
		ObjectInitClass.SerRequest.servicerequestSubTab();
		Waitfor(2);
		ObjectInitClass.SerRequest.newRequest();
		Waitfor(1);
		ObjectInitClass.SerRequest.createRequest(issuename, sumry, description, depandant);
		Waitfor(2);
		ObjectInitClass.SerRequest.clickSubmitEmp();
		Waitfor(2); 	
		ObjectInitClass.SerRequest.statusAtEmp();
		Waitfor(2);
		ObjectInitClass.SerRequest.selectEmpMyRequestPage();
		Waitfor(1);
		ObjectInitClass.SerRequest.cancelFunction();
		Waitfor(2);
		ObjectInitClass.SerRequest.statusAtEmp();
		Waitfor(2);
		// Create Request From Employee
		Waitfor(2);
		ObjectInitClass.SerRequest.newRequest();
		Waitfor(2);
		ObjectInitClass.SerRequest.createRequest(issuename, sumry, description, depandant);
		Waitfor(2);
		ObjectInitClass.SerRequest.clickSubmitEmp();
		Waitfor(2); 	
		ObjectInitClass.SerRequest.statusAtEmp();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
 	
 	
		
	}
	
	
	@Test(priority=2, enabled=true)
	public void assignLevel()
	{

	 	// SPOC Level To Assign Functionality
		String usn= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
	  	Waitfor(1);
	  	String pwd= excelreaddata().getData("Login_Credentials", 3, 1 ); //readdataing Password from excel
	  	Waitfor(1);
	  	driver.manage().window().maximize();
	  	ObjectInitClass.LP.signIn(usn, pwd);
	  	Waitfor(3);
	  	ObjectInitClass.SerRequest.myrequestTab();
		Waitfor(2);          
		ObjectInitClass.SerRequest.servicerequestSubTab();
		Waitfor(2);
		ObjectInitClass.SerRequest.toHandle();
		Waitfor(2);
		ObjectInitClass.SerRequest.selectEmpToHandlePage();
		Waitfor(2);
		ObjectInitClass.SerRequest.toClickAssign();
		Waitfor(2);
	  	String RemarkDuringassign= excelreaddata().getData("ServiceRequest", 1, 5 ); //Reading sumry from excel
		ObjectInitClass.SerRequest.assignTo(RemarkDuringassign);// Assign Name and Remarks during assign level
		
		
	}
	
	@Test(priority=3, enabled=true)
	public void resolveLevel()
	{
		Waitfor(3);
	  	ObjectInitClass.SerRequest.toHandle();
	  	Waitfor(2);
	  	ObjectInitClass.SerRequest.selectEmpToHandlePage();
	  	Waitfor(2);
	  	ObjectInitClass.SerRequest.toClickAssignIcon();
	  	Waitfor(2);
	  	// Give Assign name , Status and Comments 
	  	String ResolveDate= excelreaddata().getData("ServiceRequest", 1, 7 ); //Reading date from excel
	  	String RemarkatInProgress= excelreaddata().getData("ServiceRequest", 1, 8 ); //Reading remark from excel
	  	ObjectInitClass.SerRequest.SPOCInprogressLevel( ResolveDate ,RemarkatInProgress);
		Waitfor(3);
		//SPOC Resolve Level
		ObjectInitClass.SerRequest.toHandle();
		Waitfor(2);
	  	ObjectInitClass.SerRequest.selectEmpToHandlePage();
	  	Waitfor(2);
	  	ObjectInitClass.SerRequest.toClickAssignIcon();
	  	Waitfor(2);
		String RemarkatResolve= excelreaddata().getData("ServiceRequest", 1, 10 ); //Reading remark from excel
		ObjectInitClass.SerRequest.SPOCResolveLevel(RemarkatResolve);
		Waitfor(2);
		ObjectInitClass.SerRequest.toHandle();
		Waitfor(2);
		ObjectInitClass.SerRequest.statusAtSpoc();
	    Waitfor(5);
	 	ObjectInitClass.HP.Log_Out();
	 	Waitfor(2);
		
	}
	
	
	@Test(priority=4, enabled=true)
	public void closeRequest()
	{
		String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //Reading Username from excel
	  	Waitfor(1);
	  	String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //Reading Password from excel
	  	Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
	  	Waitfor(3);
	  	ObjectInitClass.SerRequest.myrequestTab();
		Waitfor(2);
	  	ObjectInitClass.SerRequest.servicerequestSubTab();
		Waitfor(2);
		ObjectInitClass.SerRequest.statusAtEmp();
		Waitfor(2);
	  	ObjectInitClass.SerRequest.selectEmpMyRequestPage();
		Waitfor(2);
		ObjectInitClass.SerRequest.closeFunction();
		Waitfor(3);
		ObjectInitClass.SerRequest.statusAtEmp();
		Waitfor(3);
	}
	
	@Test(priority=5, enabled=true)
	public void reopenRequest()
	{
		//ReOpen Functionality From Employee
		ObjectInitClass.SerRequest.selectEmpMyRequestPage();
		Waitfor(2);
	  	ObjectInitClass.SerRequest.reOpenFunction();
		Waitfor(3);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
	}

}
