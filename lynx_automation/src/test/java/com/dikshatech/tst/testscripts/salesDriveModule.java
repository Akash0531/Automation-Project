package com.dikshatech.tst.testscripts;

import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;

public class salesDriveModule extends TestBase {
	String	personName			= "Vijay";
	String	organizationName	= "Infosys";
	String	DealTitle			= "sales dealss";
	String	dealVaule			= "15,00,000";
	String	expDate				= "07/05/2018";

	@Test(priority = 0, enabled = true, description = "*****Validation of all the webelement and functionalities composed in HomePage*****")
	public void VerifyHomePage() throws Exception {
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.IT_Support(driver);
		Waitfor(1);

		// Read Excel object creation to pass the sheet parameter.
		String username = excelreaddata().getData("Login_Credentials", 3, 0); //Reading Username from excel
		Waitfor(1);
		String password = excelreaddata().getData("Login_Credentials", 3, 1); //Reading Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);

	}

	@Test(priority = 1, enabled = true)
	public void employeeLevel() {

		Waitfor(2);

		Waitfor(1);

	}

}
