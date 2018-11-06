package com.dikshatech.tst.testscripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.LogStatus;


@Listeners(com.dikshatech.tst.utilitylibrary.TestNGListeners.class)
public class PerdiemReconciliation extends TestBase{

	
 
	//Login the Lynx application
	@Test(priority=0, enabled=true,description= "**Login Page**")
	public void rmglogin() throws Exception
	{
		// Repository object creation.
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.perdiempage(driver);

		// Read Excel object creation to pass the sheet parameter.
		String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		Waitfor(1);
		
		//Login with Lead RMG for initiating the Salary.
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(2);
	} 
	
	@Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in Perdiem Reconciliation*****")
	public void VerifySpecialistRMZ() throws Exception
	{
		//ObjectInitClass.per.totaldeductions_calculation(1);
		//Scenario 1(Specialist RMZ Approve functionality)
		
		Waitfor(5);
		ObjectInitClass.HP.My_Lynx();
		ObjectInitClass.per.perdiemsubmodule();
		
		Waitfor(1);
		String exp_url = ConfigDataProvider.getProp().getProperty("url");
		String act_url = getCurrentUrl();
	//	logger.log(LogStatus.PASS, "Perdiem Url Verified");
		softassert().assertTrue(act_url.contains(exp_url), "Couldn't able to redirect to Perdiem Home Page");
		logger.info("Perdiem Home page Url is verified");
		logger.info("The current Perdiem home Page URL is -: " + act_url);
		ScreenshotCapture.GetScreenshot(driver, "Perdiem_Page");
		Waitfor(3);
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);
		//Scenario 2:Initiating perdiem from Specialist RMZ
		ObjectInitClass.per.specialist_RMZ_Initiate();
		Waitfor(2);
	    ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);
		
		//Scenario 3:(Lead RMZ Approve functionality)
		
		ObjectInitClass.per.Lead_RMZ();
		 Waitfor(2);
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);
	
		//Scenario 4:(Finance Analyst Approve functionality)
		
		ObjectInitClass.per.Finance_Analyst();
		Waitfor(2);
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(4);
		ObjectInitClass.HP.Log_Out();	
		Waitfor(2);
	
		//Scenario 5:(Finance Manager Approve functionality)

		ObjectInitClass.per.Finance_Manager();
		Waitfor(2);
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(4);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		
		//Scenario 6://(CEO Bharat Approve functionality)
		
		ObjectInitClass.per.CEO();
		Waitfor(2);
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(4);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		

		//Scenario 7://(Finance Manager Complete functionality)
		
		ObjectInitClass.per.Finance_Manager_complete();
		Waitfor(2);
		ObjectInitClass.per.complete_perdiem("Compelting Perdiem");
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Completed");
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 8://Specialist RMZ perdiem completion cross verifcation 
		ObjectInitClass.per.specialist_rmz_login();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Completed");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		

}
	@Test(priority=2, enabled=false,description= "***Validation Of Reject Functionality***")
	public void VerifyLeadRMZ() throws Exception
	{	
		//Scenario 10://Specialist RMZ approve and Reject functionality along with the status
		
		ObjectInitClass.per.specialist_RMZ_Initiate();
		Waitfor(2);
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);
		
		//Scenario 11://(Lead RMZ Reject functionality)
		
		ObjectInitClass.per.Lead_RMZ();
		Waitfor(2);
		ObjectInitClass.per.perdiem_Reject();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Rejected");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 12://Specialist RMZ approve and Reject functionality along with the status
		
		ObjectInitClass.per.specialist_rmz_login();
		ObjectInitClass.per.statuscheck("IN-MR-114", "Rejected");
		Waitfor(1);
		ObjectInitClass.per.specialist_RMZ_Initiate();
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		
		//Scenario 13://(Lead RMZ Reject functionality)
		
		ObjectInitClass.per.Lead_RMZ();		
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Approved");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 14://(Finance Analyst Reject functionality)
		
		ObjectInitClass.per.Finance_Analyst();
		Waitfor(2);
		ObjectInitClass.per.perdiem_Reject();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Rejected");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 15://Login with Speacilalist RMZ for initiating the Perdiem.
		
		ObjectInitClass.per.specialist_rmz_login();
		ObjectInitClass.per.statuscheck("IN-MR-114", "Rejected");
		Waitfor(1);
		ObjectInitClass.per.specialist_RMZ_Initiate();
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(4);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 16://(Lead RMZ Reject functionality)
		
		ObjectInitClass.per.Lead_RMZ();		
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Approved");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 17://(Finance Analyst Reject functionality)
		ObjectInitClass.per.Finance_Analyst();
		ObjectInitClass.per.perdiem_Approve();
		ObjectInitClass.per.statuscheck("IN-MR-114", "Approved");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 18://(Finance Manager Approve functionality)
		
		ObjectInitClass.per.Finance_Manager();
		ObjectInitClass.per.perdiem_Reject();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Rejected");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 19://Login with Speacilalist RMZ for initiating the Perdiem.
		
		ObjectInitClass.per.specialist_rmz_login();
		ObjectInitClass.per.statuscheck("IN-MR-114", "Rejected");
		Waitfor(1);
		ObjectInitClass.per.specialist_RMZ_Initiate();
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 20://(Lead RMZ Reject functionality)
		
		ObjectInitClass.per.Lead_RMZ();		
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Approved");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 21://(Finance Analyst Reject functionality)
		ObjectInitClass.per.Finance_Analyst();
		ObjectInitClass.per.perdiem_Approve();
		ObjectInitClass.per.statuscheck("IN-MR-114", "Approved");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		////Scenario 22:(Finance Manager Approve functionality)
		
		ObjectInitClass.per.Finance_Manager();
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Approved");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		
		
		//Scenario 23:(CEO Bharat Approve functionality)
		
		ObjectInitClass.per.CEO();
		ObjectInitClass.per.perdiem_Reject();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Rejected");
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);

		//Scenario 24:Login with Speacilalist RMZ for initiating the Perdiem.
		
		ObjectInitClass.per.specialist_rmz_login();
		ObjectInitClass.per.statuscheck("IN-MR-114", "Rejected");
		Waitfor(1);
		ObjectInitClass.per.specialist_RMZ_Initiate();
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 25:(Lead RMZ Reject functionality)

		ObjectInitClass.per.Lead_RMZ();		
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Approved");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 26://(Finance Analyst Reject functionality)
		ObjectInitClass.per.Finance_Analyst();
		ObjectInitClass.per.perdiem_Approve();
		ObjectInitClass.per.statuscheck("IN-MR-114", "Approved");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 27://(Finance Manager Approve functionality)
		
		ObjectInitClass.per.Finance_Manager();
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("perdiem", "Approved");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 28://(CEO Bharat Approve functionality)
		
		ObjectInitClass.per.CEO();
		ObjectInitClass.per.perdiem_Approve();
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Approved");
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 29://(Finance Manager Complete functionality)

		ObjectInitClass.per.Finance_Manager();
		ObjectInitClass.per.complete_perdiem("Compelting Perdiem");
		Waitfor(2);
		ObjectInitClass.per.statuscheck("IN-MR-114", "Completed");
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		//Scenario 30:Specialist RMZ perdiem completion cross verifcation 
		ObjectInitClass.per.specialist_rmz_login();
		ObjectInitClass.per.statuscheck("IN-MR-114", "Completed");
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
}
	
	@Test(priority=3, enabled=false,description= "*****Validation of all the webelement and functionalities composed & Defined under for Lead RMZ*****")
	public void VerifyFinanceAnalyst() throws Exception
	{
		//Scenario 31://Perdiem calculation from view page
		ObjectInitClass.per.specialist_RMZ_Initiate();
		Waitfor(2);
		ObjectInitClass.per.view_perdiemcalculation("Abhinesh Vijayakumar");
		ObjectInitClass.per.view_close();
		Waitfor(1);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);	
	}
}