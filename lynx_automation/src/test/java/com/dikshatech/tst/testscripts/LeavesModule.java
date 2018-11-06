package com.dikshatech.tst.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

	public class LeavesModule extends TestBase {
		
		String rmg_name= "";
		String candStatus="Request Raised";
		String Leave_ID="IN-LV-15";
		String Leave_ID1="IN-LV-16";
		String Leave_ID2="IN-LV-17";
		
		int row=1;	
		String projectname= excelreaddata().getData("Leaves_Sheet",row,0);
	    String chargecode= excelreaddata().getData("Leaves_Sheet",row,1);
		String leavetype=  excelreaddata().getData("Leaves_Sheet", row,2);
		String Reason_Text= excelreaddata().getData("Leaves_Sheet",row,5);
		String Contact_Number= excelreaddata().getData("Leaves_Sheet",row,3);
		int row1=2;
		String Edit_projectname= excelreaddata().getData("Leaves_Sheet",row1,0);
		String Edit_chargecode= excelreaddata().getData("Leaves_Sheet",row1,1);
		String Edit_leavetype  = excelreaddata().getData("Leaves_Sheet",row1,2);
		String Edit_Reason_Text= excelreaddata().getData("Leaves_Sheet",row1,5);
		String Edit_Contact_Number = excelreaddata().getData("Leaves_Sheet",row1,3);
			

	@Test(priority = 0, enabled = true, description = "*****Validation of all the webelement and functionalities composed in Leaves Home Page*****")
	public void VerifyHomePage() throws Exception {
		

			// Repository object creation.
			ObjectInitClass.homepage(driver);
			ObjectInitClass.loginpage(driver);
			ObjectInitClass.leaves(driver);
					
		//Scenario 1: Validating Login URL
		
			String username= excelreaddata().getData("Login_Credentials", 12, 0 ); //Reading Username from excel
			Waitfor(1);
			String password= excelreaddata().getData("Login_Credentials", 12, 1 ); //Reading Password from excel
			Waitfor(1);
			//Login with EMPLOYEE TO RAISE A LEAVE
			ObjectInitClass.LP.signIn(username, password);
			Waitfor(2);
			// Scenario 2 : Validating the Lynx Home page URL for successful login confirmation
			
			String exp_url0 = ConfigDataProvider.getProp().getProperty("url");
			String act_url0 = getCurrentUrl();
			softassert().assertEquals(act_url0, exp_url0);
			logger.info("Application Url is verified, Successfully logged-In");
			logger.info("The current Home Page URL is -: " + act_url0);
			ScreenshotCapture.GetScreenshot(driver, "Leave_Page");
			
			Waitfor(2);
			ObjectInitClass.HP.Log_Out();
			Waitfor(2);	
	}
		// Scenario 3: RAISING LEAVE AS A EMPLOYEE//
			@Test(priority = 1, enabled = true, description = "*****Validation of all the webelement and functionalities composed in Leaves Home Page*****")
			public void Apply_leave() throws Exception {
	    ObjectInitClass.L.Employee_login();
		Waitfor(2);
	    ObjectInitClass.L.Leaves_Calculation();
		Waitfor(2); 
	    ObjectInitClass.L.Applyleave();
	    Waitfor(2);
		ObjectInitClass.L.Leavesform_Calculation() ;
		Waitfor(2);
		ObjectInitClass.L.Leave_Form(projectname,chargecode,leavetype, Reason_Text,Contact_Number, 8,12);
		Waitfor(1);
		ObjectInitClass.L.Message_Ok();
		Waitfor(2);
		ObjectInitClass.L.uploadedfie_checking();
		Waitfor(2);
		//Scenario 4: edit the leave
		ObjectInitClass.L.editleave(candStatus);
		Waitfor(2);
		ObjectInitClass.L.LeaveHP_Validation(); 
		Waitfor(2); 
//		ObjectInitClass.L.UPDATE_LEAVE(Edit_projectname,Edit_chargecode,Edit_leavetype, Edit_Reason_Text,Edit_Contact_Number, 9,10);
//		Waitfor(1);
//       ObjectInitClass.L.updted_sucessfullymsg();
	     Waitfor(5);
		ObjectInitClass.HP.Log_Out();
	    Waitfor(2);	
	    //Scenario 5: RM approve//	
	  	ObjectInitClass.L.rm_login();
	  	Waitfor(2);		
	  	ObjectInitClass.L.rm_approve();
	  	Waitfor(2);
		ObjectInitClass.L.uploadedfie_checking_rm();
	 	Waitfor(2);
	  	ObjectInitClass.L.RM_to_approve_leave(Leave_ID,candStatus);
	  	Waitfor(3);
	  	ObjectInitClass.L.approve();
	  	Waitfor(2);
	  	ObjectInitClass.L.Enter_comments();
	  	Waitfor(2);
	  	ObjectInitClass.L.submit_comments();
	  	Waitfor(5);
	  	ObjectInitClass.HP.Log_Out();
	  	Waitfor(2);		
	    //Scenario 6: RMG approve//
	    ObjectInitClass.L.rmg_login();
	    Waitfor(2);
		ObjectInitClass.L.rm_approve();
		Waitfor(2);
		ObjectInitClass.L.uploadedfie_checking_rm();
	 	Waitfor(2);
		ObjectInitClass.L.RM_to_approve_leave(Leave_ID,candStatus);
		Waitfor(2);
		ObjectInitClass.L.approve();
		Waitfor(2);
		ObjectInitClass.L.Enter_comments();
		Waitfor(2);
		ObjectInitClass.L.submit_comments();
		Waitfor(6);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		//Scenario 7: Fm approve
		ObjectInitClass.L.Fm_login();
		Waitfor(4);
	
			}
	    @Test(priority =2, enabled = false, description = "*****Validation of all the webelement and functionalities composed in Leaves Home Page*****")
		public void cancel_leave() throws Exception {
      //Scenario 8 : Raise a leave 
       ObjectInitClass.L.Employee_login();
	    Waitfor(2);
		ObjectInitClass.L.Applyleave();
		Waitfor(2);
		ObjectInitClass.L.Leave_Form(projectname,chargecode,leavetype, Reason_Text,Contact_Number, 8,12);
		Waitfor(1);
		ObjectInitClass.L.Message_Ok();
		Waitfor(2);
		ObjectInitClass.L. Cancel_Page();
		Waitfor(2);
		//Scenario 9 : cancel a leave 
		ObjectInitClass.L. CancelRequest();
		Waitfor(2);
		ObjectInitClass.L.Cancel_Button();
		Waitfor(2);
		ObjectInitClass.L. CancelSuccessmsg();
		Waitfor(3); 
		ObjectInitClass.L.Leaves_Status("Cancelled") ;
		Waitfor(2); 
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
	    }
		@Test(priority = 3, enabled = true, description = "*****Validation of all the webelement and functionalities composed in Leaves Home Page*****")
		public void rejecting_leave() throws Exception {
		//Scenario 10 : rm rejecting functionality
		ObjectInitClass.L.Employee_login();
		 Waitfor(2);
        ObjectInitClass.L.Applyleave();
        Waitfor(2);
        ObjectInitClass.L.Leave_Form(projectname,chargecode,leavetype, Reason_Text,Contact_Number, 8,12);
		Waitfor(1);
		ObjectInitClass.L.Message_Ok();
		Waitfor(5);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		ObjectInitClass.L.rm_login();
		Waitfor(2);	
		ObjectInitClass.L.rm_approve();
		Waitfor(2);
		//Scenario 11: rm assin
//		ObjectInitClass.L.RM_to_approve_leave(Leave_ID,candStatus);
//		Waitfor(2);
//		ObjectInitClass.L.assign_leave();
//		Waitfor(2);
//		ObjectInitClass.L.assigned_to_comments();
//		Waitfor(2);
//		ObjectInitClass.L.submit_comments();
//		Waitfor(2);
		ObjectInitClass.L.RM_to_approve_leave(Leave_ID1,candStatus);
		Waitfor(2);
		ObjectInitClass.L.Reject_leave();
		Waitfor(2);
		ObjectInitClass.L.Enter_comments();
		Waitfor(2);
		ObjectInitClass.L.submit_comments();
		Waitfor(5);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		//Scenario : 12 rmg reject functionlity
		ObjectInitClass.L.Employee_login();
		 Waitfor(2);
		 ObjectInitClass.L.Leaves_Status("Rejected") ;
		 Waitfor(2);
        ObjectInitClass.L.Applyleave();
        Waitfor(2);
        ObjectInitClass.L.Leave_Form(projectname,chargecode,leavetype, Reason_Text,Contact_Number, 8,12);
		Waitfor(5);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		ObjectInitClass.L.rm_login();
		Waitfor(2);		
		ObjectInitClass.L.rm_approve();
		Waitfor(2);
		ObjectInitClass.L.RM_to_approve_leave(Leave_ID2,candStatus);
		Waitfor(2);
		ObjectInitClass.L.approve();
		Waitfor(2);
		ObjectInitClass.L.Enter_comments();
		Waitfor(2);
		ObjectInitClass.L.submit_comments();
		Waitfor(5);
		ObjectInitClass.HP.Log_Out();
		Waitfor(3);		
		ObjectInitClass.L.rmg_login();
	    Waitfor(2);
		ObjectInitClass.L.rm_approve();
		Waitfor(2);
		ObjectInitClass.L.RM_to_approve_leave(Leave_ID2,candStatus);
		Waitfor(2);
//		//Scenario 13: rmg assign
//		ObjectInitClass.L.assign_leave();
//		Waitfor(2);
//		ObjectInitClass.L.assigned_to_comments();
//		Waitfor(2);
//		ObjectInitClass.L.submit_comments();
//		Waitfor(2);
//		ObjectInitClass.L.RM_to_approve_leave(Leave_ID2,candStatus);
//		Waitfor(2);
		//Scenario 14: RMG Rejecting the leave
		ObjectInitClass.L.Reject_leave();
		Waitfor(2);
		ObjectInitClass.L.Enter_comments();
		Waitfor(2);
		ObjectInitClass.L.submit_comments();
		Waitfor(5);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		ObjectInitClass.L.Employee_login();
		Waitfor(2);
		ObjectInitClass.L.Leaves_Status("Rejected") ;
		Waitfor(2);
		
		}		
}