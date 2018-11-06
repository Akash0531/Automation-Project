package com.dikshatech.tst.testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;

public class ReimbursementModule extends TestBase{
	
	 String report_id= "";
	
	@Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in Perdiem Reconciliation*****")
	public void verifynew_Reimbursement() throws Exception
	{
		// Repository object creation.
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.reimbursement(driver);

		// Read Excel object creation to pass the sheet parameter.
		String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		Waitfor(1);
		
		//Login with Lead RMG for initiating the Salary.
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(2);		
		
	}
}
