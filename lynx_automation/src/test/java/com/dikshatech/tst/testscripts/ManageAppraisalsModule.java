package com.dikshatech.tst.testscripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

public class ManageAppraisalsModule extends TestBase {
	
	
	
	int row=1;
	String Year= excelreaddata().getData("ManageAppraisal_sheet", row, 0 );
	String Term= excelreaddata().getData("ManageAppraisal_sheet", row, 1 );
	String Handler= excelreaddata().getData("ManageAppraisal_sheet",row,2);
	String Company= excelreaddata().getData("ManageAppraisal_sheet", row,3);
	String Region= excelreaddata().getData("ManageAppraisal_sheet", row,4);
	String Department= excelreaddata().getData("ManageAppraisal_sheet", row,5);
	String Category= excelreaddata().getData("ManageAppraisal_sheet", row,8);
	String T_Date= excelreaddata().getData("ManageAppraisal_sheet", row,7);
	String Appriaser= excelreaddata().getData("ManageAppraisal_sheet", row,6);
	String candname="852";
	String  term1="November";
	
	
	
	@Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in HomePage*****")
	public void manageappraisal_rmg() throws Exception
	{
		//Home page object creation
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.manageappraisal(driver);
		ObjectInitClass.Appraisalpage(driver);
	
		// Read Excel object creation to pass the sheet parameter.
	  	String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
	  	Waitfor(1);
	  	String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
	  	Waitfor(1);
	 
	  	ObjectInitClass.LP.signIn(username, password);
	  	Waitfor(3);
	  //Scenario1  : Adding appraisal as a rmg
	  	ObjectInitClass.MA.rmg_module();
	  	Waitfor(2);
	  	ObjectInitClass.MA.click_ManageAppraisal_submenu();
	 	Waitfor(2);
		ObjectInitClass.MA.addingnewAppraises(Year,Term,Handler,Company,Region,Department,29,29,29,Appriaser,candname);
		Waitfor(2);
		//Scenario2 :uploading the projects and billable days
		ObjectInitClass.MA.EditingApprisals(Term);
		Waitfor(2);
		ObjectInitClass.MA.projectsupload();
		Waitfor(2);
		ObjectInitClass.MA.billabledaysupload();
		Waitfor(3);
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);
		//Scenario3 : login as a employee and checking appraiasal form
		ObjectInitClass.AP.Employee_login();
		Waitfor(2);
		ObjectInitClass.AP.filling_myappraisal_form("January","PAF Available");
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2); 
		ObjectInitClass.LP.signIn(username, password);
	  	Waitfor(2);
	  //Scenario4 : Delete appraisal form
	  	ObjectInitClass.MA.rmg_module();
	  	Waitfor(2);
	  	ObjectInitClass.MA.click_ManageAppraisal_submenu();
	 	Waitfor(2);
	 	ObjectInitClass.MA.EditingApprisals(Term);       
		Waitfor(2);
		ObjectInitClass.MA.click_on_update_button();
		Waitfor(2);
		//Scenario5 : Downlaod all the reports
		
//		ObjectInitClass.MA.download_RMGFeedback();
//		Waitfor(2);
//		ObjectInitClass.MA.view_RMGFeedback();
//		Waitfor(2);
//		ObjectInitClass.MA.download_RMGReport();
//		Waitfor(2);
//		ObjectInitClass.MA.view_RMGReport();
//		Waitfor(2);
	    ObjectInitClass.MA.EditingApprisals(term1);
		Waitfor(2);
     	ObjectInitClass.MA.deleteAppraisals();
		Waitfor(2);
	}
		

}