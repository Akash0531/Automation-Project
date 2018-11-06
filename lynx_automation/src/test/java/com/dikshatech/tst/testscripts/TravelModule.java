package com.dikshatech.tst.testscripts;

import org.openqa.selenium.WebDriver;
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

public class TravelModule extends TestBase

{
	 // Travel for Self 
	 String PurpsoeTravel= excelreaddata().getData("Travel", 1, 0 );
	 String Commentss= excelreaddata().getData("Travel", 1, 1 );
	 String SpouseName= excelreaddata().getData("Travel", 1, 2 );
	 String ChildnName= excelreaddata().getData("Travel", 1, 3 );
	 String ModeTravel= excelreaddata().getData("Travel", 1, 4 );
	 String FromPlace= excelreaddata().getData("Travel", 1, 5 );
	 String ToPlace= excelreaddata().getData("Travel", 1, 6 );
	 String TravelDate= excelreaddata().getData("Travel", 1, 7 );
	 
	 // Travel for others
	String Dept=excelreaddata().getData("Travel", 1, 8 );
	String Division=excelreaddata().getData("Travel", 1, 9 );
	String TravelerName=excelreaddata().getData("Travel", 1, 10 );
	
	@Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in Perdiem Reconciliation*****")
	public void VerifySpecialistRMZ() throws Exception
	{
		
		
		// Repository object creation.
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.TravelModule(driver);
		
		
		// Read Excel object creation to pass the sheet parameter.
				
		String username= excelreaddata().getData("Login_Credentials", 9, 0 ); //Reading Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 9, 1 ); //Reading Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);
				
	}
	
	@Test(priority=1, enabled=false)
	public void travelSelfRequest()
	{
		//SPOC Level Create and Raise a Request
		ObjectInitClass.Travel.My_Lynx();
		Waitfor(1);
		ObjectInitClass.Travel.travelModule();
		Waitfor(1);
		ObjectInitClass.Travel.newTravelRequest();
		Waitfor(2);
		ObjectInitClass.Travel.createSelfTravelRequest(PurpsoeTravel, Commentss, SpouseName, ChildnName, ModeTravel, FromPlace, ToPlace, TravelDate);
		Waitfor(2);
		//ObjectInitClass.Travel.saveRequest();
		ObjectInitClass.Travel.submitRequest();
		Waitfor(2);
		//ObjectInitClass.Travel.TravellerDetails();
		//ObjectInitClass.LP.Log_Out();
		
	}
	
	@Test(priority=2, enabled=true)
	public void travelOthersRequest()
	{
		ObjectInitClass.Travel.My_Lynx();
		Waitfor(1);
		ObjectInitClass.Travel.travelModule();
		Waitfor(1);
		ObjectInitClass.Travel.newTravelRequest();
		Waitfor(2);
		ObjectInitClass.Travel.createOthersTravelRequest(Dept, Division, TravelerName, PurpsoeTravel, Commentss, SpouseName, ChildnName, ModeTravel, FromPlace, ToPlace, TravelDate);
		Waitfor(2);
		ObjectInitClass.Travel.submitRequest();
		Waitfor(2);
		//ObjectInitClass.Travel.TravellerDetails();
		ObjectInitClass.LP.Log_Out();
		
		
		
	}
	
	
	@Test(priority=2, enabled=false)
	public void travelOthersRequests()
{
			//SPOC Level Create and save and delet Travel Request.
		ObjectInitClass.Travel.My_Lynx();
		Waitfor(1);
		ObjectInitClass.Travel.travelModule();
		Waitfor(3);
		ObjectInitClass.Travel.newTravelRequest();
		Waitfor(2);
		ObjectInitClass.Travel.createSelfTravelRequest(PurpsoeTravel, Commentss, SpouseName, ChildnName, ModeTravel, FromPlace, ToPlace, TravelDate);
		Waitfor(2);
		ObjectInitClass.Travel.saveRequest();
		Waitfor(2);
		ObjectInitClass.Travel.selectEmpAtSPOCLevel();
		ObjectInitClass.Travel.deleteRequest();
		
		//SPOC Level Create and Raise a Request
		Waitfor(1);
		ObjectInitClass.Travel.newTravelRequest();
		Waitfor(2);
		ObjectInitClass.Travel.createSelfTravelRequest(PurpsoeTravel, Commentss, SpouseName, ChildnName, ModeTravel, FromPlace, ToPlace, TravelDate);
		Waitfor(2);
		ObjectInitClass.Travel.submitRequest();
		ObjectInitClass.Travel.TravellerDetails();
		
		ObjectInitClass.LP.Log_Out();
		
		
		//RM Level lOGIN
		
		String usernameRM= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		Waitfor(1);
		String passwordRM= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(usernameRM, passwordRM);
		Waitfor(3);
		ObjectInitClass.Travel.My_Lynx();
		ObjectInitClass.Travel.travelModule();
		Waitfor(1);
		ObjectInitClass.Travel.clickToApproveTab();
		Waitfor(1);
		ObjectInitClass.Travel.selectEMPToApproveTab();
		Waitfor(1);
		ObjectInitClass.Travel.rejectFunction();
		Waitfor(1);
		ObjectInitClass.Travel.statusCheckRejected();
		Waitfor(1);
		ObjectInitClass.LP.Log_Out();
		
		
		//SPOC Level Login to Check Rejected Status//*[@id='ui-datepicker-div']/table/tbody
		/* TODO Waitfor(1);
	    ObjectInitClass.LP.signIn(username, password);
		Waitfor(2);
		ObjectInitClass.Travel.My_Lynx();
		ObjectInitClass.Travel.travelModule();
		ObjectInitClass.Travel.RejectedstatusatSPOCLevel();*/
		
		
		//SPOC  Create Self Travel Request 
		
		ObjectInitClass.Travel.newTravelRequest();
		Waitfor(2);
		ObjectInitClass.Travel.createSelfTravelRequest(PurpsoeTravel, Commentss, SpouseName, ChildnName, ModeTravel, FromPlace, ToPlace, TravelDate);
		Waitfor(2);
		ObjectInitClass.Travel.submitRequest();
		ObjectInitClass.Travel.TravellerDetails();
		ObjectInitClass.HP.Log_Out();
		
		
		// RM Level Assign and approv Functionality.
		Waitfor(1);
		ObjectInitClass.LP.signIn(usernameRM, passwordRM);
		Waitfor(3);
		ObjectInitClass.Travel.My_Lynx();
		ObjectInitClass.Travel.travelModule();
		Waitfor(1);
		ObjectInitClass.Travel.clickToApproveTab();
		Waitfor(1);
		ObjectInitClass.Travel.selectEMPToApproveTab();
		Waitfor(1);
		ObjectInitClass.Travel.assignFunction();
		
		// Approved Function By RM Level
		
		ObjectInitClass.Travel.selectEMPToApproveTab();
		Waitfor(1);
		ObjectInitClass.Travel.approveFunction();
		Waitfor(1);
		ObjectInitClass.Travel.statuscheckApproved();
		ObjectInitClass.HP.Log_Out();
		
		
		
		//lEAD RMG Assign Level Functionality
		
		String usernameRMG= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		Waitfor(1);
		String passwordRMG= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(usernameRMG, passwordRMG);
		Waitfor(3);
		ObjectInitClass.Travel.My_Lynx();
		ObjectInitClass.Travel.travelModule();
		Waitfor(1);
		ObjectInitClass.Travel.toHandleTab();
		Waitfor(1);
		ObjectInitClass.Travel.selectEMPToHandle();
		Waitfor(1);
		ObjectInitClass.Travel.assignClick();
		Waitfor(1);
		ObjectInitClass.Travel.assignFunctionRMG();
		Waitfor(1);
		ObjectInitClass.Travel.submitRMG();
		
		
		//lEAD RMG Approve Level Functionality
		ObjectInitClass.Travel.selectEMPToHandle();
		Waitfor(1);
		ObjectInitClass.Travel.assignClick();
		Waitfor(1);
		ObjectInitClass.Travel.processedFunctionRMG();
		Waitfor(1);
		ObjectInitClass.Travel.submitRMG();
		ObjectInitClass.LP.Log_Out();
		
		
		//TODO Others Travel Request
		
		/*Waitfor(1);
	  ObjectInitClass.LP.signIn(username, password);
		Waitfor(2);
		ObjectInitClass.Travel.My_Lynx();
		ObjectInitClass.Travel.travelModule();
		ObjectInitClass.Travel.newTravelRequest();
		Waitfor(1);
		ObjectInitClass.Travel.createOthersTravelRequest(Dept, Division, TravelerName, PurposeTravel, Comments, spouseName, ChildName, TravelMode, T_From, T_To, TravelDate);
		Waitfor(2);
		ObjectInitClass.Travel.submitRequest();
		Waitfor(2);
		ObjectInitClass.Travel.TravellerDetails();
		ObjectInitClass.LP.Log_Out();
		*/
		// Approve Functionality By RMG Manager
		
		Waitfor(2);
		ObjectInitClass.LP.signIn(usernameRMG, passwordRMG);
		Waitfor(3);
		ObjectInitClass.Travel.My_Lynx();
		ObjectInitClass.Travel.travelModule();
		Waitfor(1);
		ObjectInitClass.Travel.toHandleTab();
		Waitfor(1);
		ObjectInitClass.Travel.selectEMPToHandle();
		Waitfor(1);
		ObjectInitClass.Travel.assignClick();
		Waitfor(1);
		ObjectInitClass.Travel.assignFunctionRMG();
		Waitfor(1);
		ObjectInitClass.Travel.submitRMG();
		
		//lEAD RMG Approve Level Functionality
		ObjectInitClass.Travel.selectEMPToHandle();
		Waitfor(1);
		ObjectInitClass.Travel.assignClick();
		Waitfor(1);
		ObjectInitClass.Travel.processedFunctionRMG();
		Waitfor(1);
		ObjectInitClass.Travel.submitRMG();
		ObjectInitClass.LP.Log_Out();
	
}
	
}
