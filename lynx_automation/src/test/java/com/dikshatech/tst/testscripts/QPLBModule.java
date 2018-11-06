package com.dikshatech.tst.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

@Test
public class QPLBModule  extends TestBase
{
	
	 String report_id= null;
	 

	@Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in Perdiem Reconciliation*****")
	public void VerifySpecialistRMZ() throws Exception
	{
		
		//(rm Approve functionality)
		// Repository object creation.
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.leaves(driver);
		ObjectInitClass.reimbursement(driver);
		ObjectInitClass.timesheet(driver);
		ObjectInitClass.QPLB_OBJECT(driver);
		
		// Read Excel object creation to pass the sheet parameter.
		String username=excelreaddata().getData("Login_Credentials", 2, 0 ); //Reading Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 2, 1 ); //Reading Password from excel
		Waitfor(1);
		
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);
		
		//Validating the Lynx Home page URL for successful login confirmation
		String exp_url0 = ConfigDataProvider.getProp().getProperty("homepageURL");
		String act_url0 = getCurrentUrl();
		softassert().assertEquals(act_url0, exp_url0);
		exlogger.log(LogStatus.PASS, "Application Url Verified");
		logger.info("Application Url is verified, Successfully logged-In");
		logger.info("The current Home Page URL is -: " + act_url0);
		ScreenshotCapture.GetScreenshot(driver, "perHome_Page");
		
		// Validating QPLB URL
		
		ObjectInitClass.qplb.My_Lynx();		
		ObjectInitClass.qplb.RM_userlogin();
		
		   Waitfor(1);
			String exp_url = ConfigDataProvider.getProp().getProperty("perdiemURL");
			String act_url = getCurrentUrl();
			exlogger.log(LogStatus.PASS, "Perdiem Url Verified");
			softassert().assertTrue(act_url.contains(exp_url), "Couldn't able to redirect to Perdiem Home Page");
			logger.info("Perdiem Home page Url is verified");
			logger.info("The current Perdiem home Page URL is -: " + act_url);
			ScreenshotCapture.GetScreenshot(driver, "Perdiem_Page");
			Waitfor(1);
			ObjectInitClass.HP.Log_Out();
			Waitfor(2);
	}

			@Test
			public void RM_Verification() throws Exception
			{
			ObjectInitClass.qplb.My_Lynx();		
			ObjectInitClass.qplb.RM_userlogin();	
			
			ObjectInitClass.qplb.Bonus_Reconciliation_homepage();
			
			ObjectInitClass.qplb.status_check ("IN-MR-46", "report generated");
			ObjectInitClass.qplb.QPLB_Amount_capturing();
			ObjectInitClass.qplb.Pagination();
			Waitfor(2);
			ObjectInitClass.qplb.enter_percentage_rm("50");
			ObjectInitClass.qplb.enter_comments_rm("good");
			ObjectInitClass.qplb. RM_status("approved") ;
			ObjectInitClass.qplb.save_details_rm();
			ObjectInitClass.HP.Log_Out();
			Waitfor(2);
			
					}
			
		@Test		
		public void SpecialRMG_Verification() throws Exception
		{
			
			ObjectInitClass.qplb.SPECIALISTRMG_login();
			Waitfor(2);
ObjectInitClass.qplb.Bonus_Reconciliation_homepage();
			
			ObjectInitClass.qplb.qplb_table1(report_id, report_id);
		
			
			ObjectInitClass.qplb.status_check ("IN-MR-46", "Approved");
			ObjectInitClass.qplb.QPLB_Amount_capturing();
			ObjectInitClass.qplb.Pagination();
			Waitfor(2);
			ObjectInitClass.qplb.enter_percentage_rm("50%");
			ObjectInitClass.qplb.enter_comments_rm("good");
			ObjectInitClass.qplb. RM_status("approved") ;
			ObjectInitClass.qplb.save_details_rm();
			ObjectInitClass.HP.Log_Out();
			Waitfor(2);
			ObjectInitClass.qplb.RM_name_RMGVIEW();
		
			ObjectInitClass.HP.Log_Out();
			Waitfor(2);
		}
		
		@Test
		public void CEO_Verification() throws Exception
		{
			ObjectInitClass.qplb.CEO_userlogin();
			
			Waitfor(2);
ObjectInitClass.qplb.Bonus_Reconciliation_homepage();
			
		
		
			ObjectInitClass.qplb.status_check ("IN-MR-46", "completed");
			ObjectInitClass.qplb.QPLB_Amount_capturing();
			ObjectInitClass.qplb.Pagination();
			Waitfor(2);
			ObjectInitClass.qplb. RM_status("approved") ;
			ObjectInitClass.qplb.save_details_rm();
			ObjectInitClass.HP.Log_Out();
			Waitfor(2);
			ObjectInitClass.qplb.RM_name_RMGVIEW();
			ObjectInitClass.HP.Log_Out();
			Waitfor(2);
				
		}
		


		@Test
		
		public void InitiateQplb() throws Exception
		{
			Waitfor(1);
			ObjectInitClass.qplb.validate_Report(30,25,25); // pass payment date, expected_holiday, actual holiday
			Waitfor(2);
			ObjectInitClass.qplb.Complteduration();
			Waitfor(2);
			ObjectInitClass.qplb.EmpDetails("1192"); //pass empid,Ename, Designation, qplbamount, percentage etc
			Waitfor(2);
			ObjectInitClass.qplb.QPLBFinacial();
			Waitfor(2);
			//ObjectInitClass.QPLB.LWP(11,9000,15);
			ObjectInitClass.qplb.QPLB_NoDays();
			Waitfor(2);
			ObjectInitClass.qplb.EditQPLB();
			ObjectInitClass.qplb.ModifyQPLB();
			ObjectInitClass.qplb.HoldQPLB();
			ObjectInitClass.qplb.DeleteQPLB();
			Waitfor(1);
			ObjectInitClass.qplb.ValidateAprrove();
			Waitfor(1);
			//ObjectInitClass.qplb.Corp_Validation();
			//ObjectInitClass.qplb.Consulting_Validation();
			//Waitfor(1);
			//ObjectInitClass.qplb.ServiceDelivery();
			//Waitfor(1);
			//ObjectInitClass.qplb.BusinValidation();
			Waitfor(1);
			//ObjectInitClass.qplb.BenchValidation();
			//Waitfor(1);
			//ObjectInitClass.qplb.ResignedValidation();
			
		}
		
		}

			