package com.dikshatech.tst.testscripts;

import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.LogStatus;

public class SalaryReconciliationModule extends TestBase {

	String generatedreport_id = "";
	String empName =  excelreaddata().getData("SalaryRecon_Sheet", 6, 0); 
	
	/**
	Login to the Lynx application
	**/
	@Test(priority = 0, enabled = true, description = "**Login Page**")
	public void rmglogin() throws Exception {
		/**
		Repository object creation.
		**/
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.salaryRecon(driver);
		/**
		Read Excel object creation to pass the sheet parameter.
		**/
		String username = excelreaddata().getData("Login_Credentials", 14, 0); // Reading Username from excel
		Waitfor(1);
		String password = excelreaddata().getData("Login_Credentials", 14, 1); // Reading Password from excel
		Waitfor(1);
		/**
		Login with Lead RMG for initiating the Salary.
		**/
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(5);
	}

	@Test(priority = 1, enabled = true, description = "**Validation of Salary Initiation**")
	public void salaryinitiate() throws Exception {
		/**
		Scenario 1:Initiating Salary Recon from specialist RMG
		**/
		ObjectInitClass.SAL.salaryInitiate();
		exlogger.log(LogStatus.PASS, "Salary initiated & verified",
				exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "IT_Details")));
		generatedreport_id = ObjectInitClass.SAL.salary_reportstatus("Generated");
	}

	@Test(priority = 2, enabled = true, description = "Validation of Salary calculation")
	public void salarycalculation() {
		/**
		Scenario 2: Net Salary calculation for employees.
		**/
		Waitfor(2);
		ObjectInitClass.SAL.salary_generatedtable(empName);
		ObjectInitClass.SAL.salaryedit_button();
		ObjectInitClass.SAL.net_salaryearnings(2);
		exlogger.log(LogStatus.INFO, "Salary calculation has been verified",
				exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "Salary_calc")));
	}

	@Test(priority = 3, enabled = true, description = "Validation of Salary Edit Flow")
	public void salaryprocessflow() throws Exception {
		/**
		Scenario 3: Salary Edit popup comment validation
		**/
		ObjectInitClass.SAL.edit_Salarycomments("Modified with automated tool");
		Waitfor(2);
		ObjectInitClass.SAL.salaryedit_Save();
		Waitfor(3);
		
		/**
		Scenario 4: Verifying edited/modified record in generated table
		**/
		String gen_status = ObjectInitClass.SAL.salary_generatedtable(empName);
		if (!gen_status.equalsIgnoreCase("Not found")) {
			logger.info("The modified record still present in Generated Table ");
		} else
			logger.info("The modified record is not present in Generated Table ");
		
		/**
		Scenario 5:Verifying edited/modified record in Modified tab.
		**/
		String mod_status = ObjectInitClass.SAL.salary_modifiedtable(empName);
		if (mod_status.equalsIgnoreCase("")) {
			logger.info("The modified record is present in Modified Table ");
		} else
			logger.info("The modified record is not present in Modified Table ");
		
		/**
		Scenario 6: Salary on hold functionality from Generated tab
		**/
		ObjectInitClass.SAL.salary_generatedtable("Ranvijay Raina");
		ObjectInitClass.SAL.salary_hold();
		String holdtoast = ObjectInitClass.SAL.holdbutton();
		if (holdtoast.equalsIgnoreCase("Enter Comments...")) {
			logger.info("Hold Button is perfectly validated");
		} else
			logger.info("Hold button hasn't display any proper toast message");
		Waitfor(1);
		ObjectInitClass.SAL.hold_comments("Holding with Automated tool");
		ObjectInitClass.SAL.holdbuttonvalidation();
		Waitfor(1);
		
		/**
		Scenario 7: Verifying salary On-hold record in Generated tab
		**/
		String hold_status = ObjectInitClass.SAL.salary_generatedtable("Ranvijay Raina");
		if (!hold_status.equalsIgnoreCase("Not found")) {
			logger.info("The Hold record still present in Generated Table");
		} else
			logger.info("The Hold record is not present in Generated Table ");
		String holdtable_status = ObjectInitClass.SAL.salary_holdtable("Ranvijay Raina");
		if (holdtable_status.equalsIgnoreCase("")) {
			logger.info("The Hold record is present in Hold Table ");
		} else
			logger.info("The Hold record is not present in Hold Table ");
		
		/**
		Scenario 8: Salary on hold functionality from Generated tab.
		**/
		ObjectInitClass.SAL.salary_generatedtable("Revanth Kumar");
		ObjectInitClass.SAL.salary_hold();
		String holdtoast1 = ObjectInitClass.SAL.holdbutton();
		if (holdtoast1.equalsIgnoreCase("Enter Comments...")) {
			logger.info("Hold Button is perfectly validated");
		} else
			logger.info("Hold button hasn't display any proper toast message");
		Waitfor(1);
		ObjectInitClass.SAL.hold_comments("Holding with Automated tool");
		ObjectInitClass.SAL.holdbuttonvalidation();
		Waitfor(2);
		
		/**
		Scenario 9: Verifying salary On-hold record in Generated tab.
		**/
		String hold_status1 = ObjectInitClass.SAL.salary_generatedtable("Revanth Kumar");
		if (!hold_status1.equalsIgnoreCase("Not found")) {
			logger.info("The Hold record still present in Generated Table");
		} else
			logger.info("The Hold record is not present in Generated Table ");
		Waitfor(1);
		
		/**
		Scenario 10: Verifying On-hold record in Hold tab.
		**/
		String holdtable_status1 = ObjectInitClass.SAL.salary_holdtable("Revanth Kumar");
		if (holdtable_status1.equalsIgnoreCase("")) {
			logger.info("The Hold record is present in Hold Table ");
		} else
			logger.info("The Hold record is not present in Hold Table ");
		
		/**
		Scenario 11: Salary Reject functionality validation
		**/
		ObjectInitClass.SAL.rejecticon();
		String rejecttoastmsg = ObjectInitClass.SAL.rejectbutton();
		if (rejecttoastmsg.equalsIgnoreCase("Enter Comments...")) {
			logger.info("Reject button is perfectly validated");
		} else
			logger.info("Reject button hasn't display any proper toast message");
		ObjectInitClass.SAL.reject_comments("Rejected with automated tool");
		ObjectInitClass.SAL.rejectbuttonvalidation();
		Waitfor(2);
		
		/**
		Scenario 12: Salary report Approve functionality validation
		**/
		ObjectInitClass.SAL.salary_Approve_rmg();
		Waitfor(6);
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);

	}

	@Test(priority = 4, enabled = true, description = "Validation of Salary Approval Process Flow")
	public void salaryaproveprocessflow() throws Exception {
		/**
		Scenario 13:(RMG Manager Approve functionality)
		**/
		ObjectInitClass.SAL.salaryprocesslogin(3);
		Waitfor(2);
		ObjectInitClass.SAL.salary_reportstatus("Submitted");
		Waitfor(2);
		ObjectInitClass.SAL.salary_Approve();
		Waitfor(6);
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);
		
		/**
		Scenario 14:(Finance Analyst Approve functionality)
		**/
		ObjectInitClass.SAL.salaryprocesslogin(5);
		ObjectInitClass.SAL.salary_reportstatus("Submitted by RMG");
		ObjectInitClass.SAL.salary_Approve();
		Waitfor(6);
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);
		
		/**
		Scenario 15:(Finance Manager Approve functionality)
		**/
		ObjectInitClass.SAL.salaryprocesslogin(6);
		ObjectInitClass.SAL.salary_reportstatus("Submitted by Finance Analyst");
		ObjectInitClass.SAL.salary_Approve();
		Waitfor(6);
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);
		
		/**
		Scenario 16://(CEO Bharat Approve functionality)
		**/
		ObjectInitClass.SAL.salaryprocesslogin(7);
		ObjectInitClass.SAL.salary_reportstatus("Accepted");
		ObjectInitClass.SAL.salary_Approve();
		Waitfor(6);
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);
		
		/**
		Scenario 17://(Finance Manager Complete functionality)
		**/
		ObjectInitClass.SAL.salaryprocesslogin(6);
		ObjectInitClass.SAL.salary_reportstatus("Approved");
		ObjectInitClass.SAL.complete_Salary("Completing Salary Reconciliation Process");
		Waitfor(1);
	}

	@Test(priority = 5, enabled = true, description = "Validation of Salary Rejection Process Flow")
	public void hdfcsalaryreport() throws Exception {
		/**
		Scenario 18: HDFC bank report-Paid/Unpaid validation after completion
		**/
		ObjectInitClass.SAL.salary_completesalary("Completed");
		ObjectInitClass.SAL.hdfcbankicon();
		ObjectInitClass.SAL.hdfcbankreport("Diksha", "India", "Corp", "Bimal Cyriac V", "un paid");
		ObjectInitClass.SAL.hdfcselectAll();

		/**
		Scenario 19: HDFC bank report download functionality with validation
		**/
		ObjectInitClass.SAL.downloadHDFCreport();
		Waitfor(2);
		ObjectInitClass.SAL.uploadHDFCreport("Uploading the valid xls file");
		Waitfor(2);
		ObjectInitClass.SAL.downloadhdfc_Closebutton();
		
		/**
		Scenario 20: Other bank report-Paid/Unpaid validation after completion
		**/
		ObjectInitClass.SAL.salary_completesalary("Completed");
		Waitfor(2);
		ObjectInitClass.SAL.otherbankicon();
		Waitfor(2);
		ObjectInitClass.SAL.other_Bankreport("Diksha", "India", "Corp", "Pattem Sumalatha", "un paid");
		ObjectInitClass.SAL.otherbankselectAll();
		ObjectInitClass.SAL.downloadother_Bankreport();
		Waitfor(2);
		
		/**
		Scenario 21: Upload-downloaded Other Bank report document validation 
		**/
		ObjectInitClass.SAL.uploadother_Bankreport("Uploading the valid xls file");
		Waitfor(2);
		ObjectInitClass.SAL.downloadother_Bank_Closebutton();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
	}

	@Test(priority = 6, enabled = true, description = "Validation of Salary Rejection Process Flow")
	public void salaryrejectprocessflow() throws Exception {
		
		// ObjectInitClass.SAL.rmg_login();
		/**
		Scenario 22: Initiating Salary Recon by Specialist RMG for salary report Reject flow 
		**/
		ObjectInitClass.SAL.salaryInitiate();
		exlogger.log(LogStatus.PASS, "Salary initiated & verified",
				exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "IT_Details")));

		exlogger.log(LogStatus.PASS, "Salary initiated & verified",
				exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "IT_Details")));
		generatedreport_id = ObjectInitClass.SAL.salary_reportstatus("Generated");
		Waitfor(1);
		ObjectInitClass.SAL.salary_Approve_rmg();
		Waitfor(6);
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);

		/**
		 * Scenario 23: RMG Manager Reject functionality, once Salary report approved by Specialist RMG
		 **/
		ObjectInitClass.SAL.salaryprocesslogin(3);
		Waitfor(2);
		ObjectInitClass.SAL.salary_reportstatus("Submitted");
		Waitfor(2);
		ObjectInitClass.SAL.salary_Reject();
		Waitfor(6);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		/**
		Scenario 24:  Verifying the rejected record in the specialist RMG salary recon landing page.
		**/
		ObjectInitClass.SAL.salaryprocesslogin(14);
		Waitfor(2);
		ObjectInitClass.SAL.salary_reportstatus("Rejected");
		Waitfor(2);
	}

}

/*
 * END(Akash.Anand)
 */


