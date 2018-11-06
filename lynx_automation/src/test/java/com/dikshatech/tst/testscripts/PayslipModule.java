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

public class PayslipModule extends TestBase

{

	@Test(priority = 0, enabled = true, description = "*****Validation of all the webelement and functionalities composed in Leaves Home Page*****")
	public void VerifyHomePage() throws Exception {
	
		// Repository object creation.
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.payslipModule(driver);	
	}
	
	@Test(priority = 1, enabled = true)
	public void financeManagerLevel()
	{
		//Validating Login URL
		String username= excelreaddata().getData("Login_Credentials", 6, 0 ); //Reading Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 6, 1 ); //Reading Password from excel
		Waitfor(1);
		  //Scenario 1: login as financial 
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(4);	
		ObjectInitClass.payslip.myFinanceTab();
		Waitfor(2);
		ObjectInitClass.payslip.payslipModule();
		Waitfor(2);
		ObjectInitClass.payslip.managePayslip();
		Waitfor(2);
		  //Scenario 2: uploading payslips
		ObjectInitClass.payslip.uploadPayslip();
		Waitfor(2);
		ObjectInitClass.payslip.selectYearsearchPayslip("2017", "November");//Pass Year
		Waitfor(2);
		ObjectInitClass.payslip.payslipTab();
		Waitfor(2);
		ObjectInitClass.payslip.SearchpayslipOnMonth("2017", "November");
		Waitfor(2);
		ObjectInitClass.payslip.selectPayslip();
		Waitfor(2);
		  //Scenario 3: download the payslip
		ObjectInitClass.payslip.downloadPayslip();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
	
	
	}
	
	@Test(priority = 2, enabled = true)
	public void employeeLevel()
	{
		  //Scenario 4:login as employee 
		String username= excelreaddata().getData("Login_Credentials", 6, 0 ); //Reading Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 6, 1 ); //Reading Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(2);	
		ObjectInitClass.payslip.myFinanceTab();
		Waitfor(2);
		ObjectInitClass.payslip.payslipModule();
		Waitfor(2);
		ObjectInitClass.payslip.SearchpayslipOnMonth("2017", "November");
		Waitfor(2);
		ObjectInitClass.payslip.selectPayslip();
		Waitfor(2);
		  //Scenario 5: download payslip as a employee
		ObjectInitClass.payslip.downloadPayslip();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		
	}
	
	
}
