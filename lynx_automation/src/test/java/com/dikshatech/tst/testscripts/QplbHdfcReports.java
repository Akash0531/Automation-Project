package com.dikshatech.tst.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class QplbHdfcReports extends TestBase {


	public void NonPayment_Reason() throws Exception {

		ObjectInitClass.qplbHDFC(driver);
		ObjectInitClass.QHR.objectrepository();
		ObjectInitClass.QHR.Click_Hdfc_button();
		ObjectInitClass.QHR.Enter_Nonpayment_Reason();
		ObjectInitClass.QHR.Enter_Nonpayment_Date();
		ObjectInitClass.QHR.Click_Nonpaymentreason_Savebutton();

	}

	@Test
	public void downloadHDFCReport_Pay() {
		ObjectInitClass.QHR.click_PerdiemReport_Row();
		ObjectInitClass.QHR.Click_Hdfc_button();
		ObjectInitClass.QHR.Select_Employeescheckbox();
		ObjectInitClass.QHR.DownloadHDFC_Bank_Report();
		ObjectInitClass.QHR.Pay_HDFCBANK();
	}

	@Test
	public void HDFC_Departmentwise_Reports(String Company_Name, String Region_Name, String Department_Name,
			String Category_Name) {
		ObjectInitClass.QHR.Select_Company(Company_Name);
		ObjectInitClass.QHR.Select_Region(Region_Name);
		ObjectInitClass.QHR.Select_Department(Department_Name);
		ObjectInitClass.QHR.Select_Category(Category_Name);

	}

}
