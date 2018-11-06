package com.dikshatech.tst.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
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

public class FBPModule extends TestBase 

{
  	String LTAAmount= excelreaddata().getData("FBP", 1, 2 ); //Reading  from excel
  	String TPAAmount= excelreaddata().getData("FBP", 2, 2 ); //Reading from excel
  	String MAAmount= excelreaddata().getData("FBP", 3, 2 ); //Reading from excel
  	String CEAAmount= excelreaddata().getData("FBP", 4, 2 ); //Reading from excel
  	String MVAmount= excelreaddata().getData("FBP", 5, 2 ); //Reading from excel
  	String TRAAmount= excelreaddata().getData("FBP", 6, 2 ); //Reading from excel
  	String CommenstDuringsubmit= excelreaddata().getData("FBP", 1, 3 ); //Reading from excel
  	String CancelCommentss= excelreaddata().getData("FBP", 1, 4 ); //Reading from excel
  	
	@Test(priority=0, enabled=true,description= "*****Validation of all the webelement and functionalities composed in HomePage*****")
	public void VerifyHomePage() throws Exception
	{
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.FlexiBenefitsPlan(driver);
	
	  	
	}
	 
	@Test(priority=1, enabled=true)
	public void createFBP()
	{

		// Read Excel object creation to pass the sheet parameter.
	  	String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //Reading Username from excel
	  	Waitfor(1);
	  	String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //Reading Password from excel
	  	Waitfor(1);	
	  	ObjectInitClass.LP.signIn(username, password);
	  //Scenario1: To Create and Cancel FBP
	  	 ObjectInitClass.FBP.myFinacialTab();
	  	Waitfor(2);
	  	 ObjectInitClass.FBP.flexiBenefitsPlan();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.clickNewFBP();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.createFBPLevel2Emp(MAAmount,MVAmount,CommenstDuringsubmit);
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.clickSubmitEmp();
        Waitfor(1);
	  	 ObjectInitClass.FBP.status();
	  	//Scenario2: FBP Cancel Functionality
	  	 ObjectInitClass.FBP.selectRequestEMP();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.cancelFBP(CancelCommentss);
	  	Waitfor(1);
	 	 ObjectInitClass.FBP.status();
	  	//Scenario3: To Create FBP
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.clickNewFBP();
	  	Waitfor(2);
	  	 ObjectInitClass.FBP.createFBPLevel2Emp(MAAmount,MVAmount,CommenstDuringsubmit);
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.clickSubmitEmp();
	  	Waitfor(3);
		 ObjectInitClass.FBP.status();
		Waitfor(1);
		 ObjectInitClass.FBP.selectRequestEMP();
		Waitfor(2);
		 ObjectInitClass.FBP.viewFunctionEmp();
		Waitfor(2);
	  	 ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
		
	}
		
	@Test(priority=2, enabled=true)
	public void finacelevel()
	{
		
	  	// Read Excel object creation to pass the sheet parameter.
	  	String usn= excelreaddata().getData("Login_Credentials", 6, 0 ); //Reading Username from excel
	  	Waitfor(1);
	  	String pwd= excelreaddata().getData("Login_Credentials", 6, 1 ); //Reading Password from excel
	  	Waitfor(1);
	  	ObjectInitClass.LP.signIn(usn, pwd);
		Waitfor(3);
	  	 ObjectInitClass.FBP.myFinacialTab();
	  	Waitfor(2);
	  	 ObjectInitClass.FBP.flexiBenefitsPlan();
	  	Waitfor(1);
	  	
	  	// Scenario 4: Assign Process At Finance Manager Level
	  	 ObjectInitClass.FBP.toHandle();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.selectFBPToHandle();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.clickAssign();
	  	Waitfor(2);
	 // Scenario 5:RemarkAtAssign
	  	String RemarkAtAssign= excelreaddata().getData("FBP", 1, 5 ); //Reading from excel
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.assigenFunctionality(RemarkAtAssign);
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.submitClick();
	  	Waitfor(1);
	  
	  	
	 // Scenario 6: In-Progress Process At Finance Manager Level 	
	  	 ObjectInitClass.FBP.toHandle();
	  	Waitfor(1);
		 ObjectInitClass.FBP.statusFinaceLevel();
		Waitfor(1);
	  	 ObjectInitClass.FBP.selectFBPToHandle();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.clickAssign();
	  	Waitfor(2);
	  	String RemarkAtInProgress= excelreaddata().getData("FBP", 1, 6 ); //Reading from excel
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.inProgressFunctionality(RemarkAtInProgress);
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.submitClick();
	  	Waitfor(1);
		
	 // Scenario 7:Processed Process At Finace Manager Level
	  	 ObjectInitClass.FBP.toHandle();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.statusFinaceLevel();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.selectFBPToHandle();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.clickAssign();
	  	Waitfor(2);
	  	String RemarkatProcess= excelreaddata().getData("FBP", 1, 7 ); //Reading from excel
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.processed(RemarkatProcess);
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.submitClick();
	  	Waitfor(4);
		 ObjectInitClass.HP.Log_Out();
		Waitfor(3);
	  	
	}
	
	
	@Test(priority=3, enabled=true)//This is For Level4 and Level 5 Employees's FBP.....!!!!
	public void level4FBPEmp()
	{
		// Read Excel object creation to pass the sheet parameter.
	  	String usernameL2Emp= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
	  	Waitfor(1);
	  	String pwdl2Emp= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
	  	Waitfor(1);
	 // Scenario 8: Level4 and Level 5 Employees's FBP.
	  	ObjectInitClass.LP.signIn(usernameL2Emp, pwdl2Emp);
	  	Waitfor(5);
	  	 ObjectInitClass.FBP.myFinacialTab();
	  	Waitfor(2);
	  	 ObjectInitClass.FBP.flexiBenefitsPlan();
	  	Waitfor(2);
	  	 ObjectInitClass.FBP.clickNewFBP();  
	  	Waitfor(2);
	  	 ObjectInitClass.FBP.createFBPLevel4Emp(LTAAmount,TPAAmount ,MAAmount , CEAAmount ,MVAmount ,TRAAmount, CommenstDuringsubmit);
		Waitfor(2);
	  	 ObjectInitClass.FBP.clickSubmitEmp();
	  	Waitfor(2);
	  	 ObjectInitClass.FBP.status();
	  	Waitfor(2);
	  	 ObjectInitClass.FBP.selectRequestEMP();
	  	Waitfor(2);
	  	 // Scenario 8:view
		 ObjectInitClass.FBP.viewFunctionEmp();
		Waitfor(2);
	  	 ObjectInitClass.HP.Log_Out();
	  	Waitfor(3);
	  	
	}
	
	
	
	@Test(priority=4, enabled=true)
	public void finacelevelForLevel4()
	{
		 // Scenario 9:finacelevel
	  	// Read Excel object creation to pass the sheet parameter.
	  	String usn= excelreaddata().getData("Login_Credentials", 6, 0 ); //Reading Username from excel
	  	Waitfor(1);
	  	String pwd= excelreaddata().getData("Login_Credentials", 6, 1 ); //Reading Password from excel
	  	Waitfor(1);
	  	ObjectInitClass.LP.signIn(usn, pwd);
		Waitfor(4);
	  	 ObjectInitClass.FBP.myFinacialTab();
	  	Waitfor(2);
	  	 ObjectInitClass.FBP.flexiBenefitsPlan();
	  	Waitfor(1);
	 // Scenario 10: Assign Process At Finance Manager Level
	  	 ObjectInitClass.FBP.toHandle();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.selectFBPToHandle();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.clickAssign();
	  	Waitfor(2);
	  	String RemarkAtAssign= excelreaddata().getData("FBP", 1, 5 ); //Reading from excel
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.assigenFunctionality(RemarkAtAssign);
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.submitClick();
	  	Waitfor(1);
	  
	  	
	  	 // Scenario 11:	//  In-Progress Process At Finance Manager Level 	
	  	 ObjectInitClass.FBP.toHandle();
	  	Waitfor(1);
		 ObjectInitClass.FBP.statusFinaceLevel();
		Waitfor(1);
	  	 ObjectInitClass.FBP.selectFBPToHandle();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.clickAssign();
	  	Waitfor(2);
	  	String RemarkAtInProgress= excelreaddata().getData("FBP", 1, 6 ); //Reading from excel
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.inProgressFunctionality(RemarkAtInProgress);
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.submitClick();
	  	Waitfor(1);
		
	  	 // Scenario 12: // Processed Process At Finace Manager Level
	  	 ObjectInitClass.FBP.toHandle();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.statusFinaceLevel();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.selectFBPToHandle();
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.clickAssign();
	  	Waitfor(2);
	  	String RemarkatProcess= excelreaddata().getData("FBP", 1, 7 ); //Reading from excel
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.processed(RemarkatProcess);
	  	Waitfor(1);
	  	 ObjectInitClass.FBP.submitClick();
	  	Waitfor(4);
		 ObjectInitClass.HP.Log_Out();
		Waitfor(2);
	  	
	}	
}
