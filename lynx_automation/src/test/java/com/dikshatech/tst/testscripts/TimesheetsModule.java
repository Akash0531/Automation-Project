package com.dikshatech.tst.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
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

public class TimesheetsModule extends TestBase {
    
		 String timeDates="";
		 String empName="";
	
		 int rownum1=1;
		 
		 String selectDate=excelreaddata().getData("Timesheet", rownum1, 0 );
		 String projectName=excelreaddata().getData("Timesheet", rownum1, 1 );
		 String taskName=excelreaddata().getData("Timesheet", rownum1, 2 );
		 String monTime=excelreaddata().getData("Timesheet", rownum1, 3 );
		 String tueTime=excelreaddata().getData("Timesheet", rownum1, 4 );
		 String wedTime=excelreaddata().getData("Timesheet", rownum1, 5 );
		 String thursTime=excelreaddata().getData("Timesheet", rownum1, 6 );
		 String friTime=excelreaddata().getData("Timesheet", rownum1, 7 );
		 String satTime=excelreaddata().getData("Timesheet", rownum1, 8 );
		 
		 String MonTask=excelreaddata().getData("Timesheet", rownum1, 9 );
		 String TueTask=excelreaddata().getData("Timesheet", rownum1, 10 );
		 String WedTask=excelreaddata().getData("Timesheet", rownum1, 11 );
		 String ThuTask=excelreaddata().getData("Timesheet", rownum1, 12 );
		 String FriTask=excelreaddata().getData("Timesheet", rownum1, 13 );
		 String SatTask=excelreaddata().getData("Timesheet", rownum1, 14 );
		 
		 
		 int rownum2=10;
		 
		 String editProject=excelreaddata().getData("Timesheet", rownum2, 0 );
		 String EditTask=excelreaddata().getData("Timesheet", rownum2, 1 );
	     String editMonTime=excelreaddata().getData("Timesheet", rownum2, 2 );
	     String editTueTime=excelreaddata().getData("Timesheet", rownum2, 3 );
	     String editWedTime=excelreaddata().getData("Timesheet", rownum2, 4 );
	     String editThuTime=excelreaddata().getData("Timesheet", rownum2, 5 );
	     String editFriTime=excelreaddata().getData("Timesheet", rownum2, 6 );
	     String editSatTime=excelreaddata().getData("Timesheet", rownum2, 7 );
	     
	     String SearchMonthToDownload=excelreaddata().getData("Timesheet", rownum2, 9 );
	     String SearchYearToDownload=excelreaddata().getData("Timesheet", rownum2, 10 );
	     
	    	
		@Test(priority=0, enabled=true,description= "*****Validation of all the webelement and functionalities composed in HomePage*****")
		public void VerifyHomePage() throws Exception
		{
			ObjectInitClass.homepage(driver);
			ObjectInitClass.loginpage(driver);
			ObjectInitClass.timesheet(driver);

			// Read Excel object creation to pass the sheet parameter.
			String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //Reading Username from excel
			Waitfor(1);
			String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //Reading Password from excel
			Waitfor(1);

			ObjectInitClass.LP.signIn(username, password);
			Waitfor(3);
		}
		
		@Test(priority=1, enabled=true )
		public void saveTimesheet()
		{
			  //Scenario 1: filling the time sheet as employee
			Waitfor(3);
			ObjectInitClass.TS.myLynx();
			Waitfor(2);
			ObjectInitClass.TS.newTimesheet(selectDate, projectName, taskName, monTime, tueTime, wedTime, thursTime, friTime, satTime, MonTask, TueTask, WedTask,ThuTask, FriTask,SatTask);
		    Waitfor(2);
		    //Scenario 2: save the time sheet as employee
			ObjectInitClass.TS.saveTimesheet();
			Waitfor(2);
			timeDates=ObjectInitClass.TS.timesheetPeriod();
			ObjectInitClass.TS.searchEmpTimesheet(timeDates);
			Waitfor(2);
			ObjectInitClass.TS.status();
		}

		@Test(priority=2, enabled=true )
		public void editSubmitTimesheet()
		{
		    //Scenario 3: edit the time sheet as employee
			Waitfor(2);
			ObjectInitClass.TS.selectTimesheet();
			Waitfor(2);
			ObjectInitClass.TS.editTimesheet(editProject, EditTask, editMonTime, editTueTime, editWedTime, editFriTime, editThuTime, editSatTime);
			Waitfor(2);
			ObjectInitClass.TS.updateTimesheet();
			Waitfor(2);
			ObjectInitClass.TS.searchEmpTimesheet(timeDates);
			Waitfor(1);
			ObjectInitClass.TS.status();
			Waitfor(1);
			ObjectInitClass.TS.selectTimesheet();
			Waitfor(1);
		    //Scenario 4: submit the time sheet as employee
			ObjectInitClass.TS.submitTimesheet();
			Waitfor(1);
			ObjectInitClass.TS.searchEmpTimesheet(timeDates);
			Waitfor(1);
			ObjectInitClass.TS.status();
			Waitfor(1);
		    //Scenario 5: view the time sheet as employee
			ObjectInitClass.TS.viewTimesheet();
			Waitfor(3);
			empName=ObjectInitClass.TS.viewTimesheet();
			Waitfor(1);
			ObjectInitClass.HP.Log_Out();
			Waitfor(2);
		}
		
		@Test(priority=3, enabled=true )
		public void rmRejectLevel()
		{
		    //Scenario 6: RM approve the time sheet 
			Waitfor(1);
			String username= excelreaddata().getData("Login_Credentials", 1, 0 ); //Reading Username from excel
			Waitfor(1);
			String password= excelreaddata().getData("Login_Credentials", 1, 1 ); //Reading Password from excel
			Waitfor(1);
			ObjectInitClass.LP.signIn(username, password);
			Waitfor(3);
			ObjectInitClass.TS.myLynx();
			Waitfor(2);
			ObjectInitClass.TS.toApproveTab();
			Waitfor(1);
			ObjectInitClass.TS.searchToApproveTab(empName);
			Waitfor(1);
			ObjectInitClass.TS.statusrmLevel();
			Waitfor(1);
			ObjectInitClass.TS.selectEmpToApprove();
			Waitfor(1);
			  //Scenario 7: RM assign the time sheet 
			ObjectInitClass.TS.assignrmLevel();
			Waitfor(1);
			ObjectInitClass.TS.searchToApproveTab(empName);
			Waitfor(1);
			ObjectInitClass.TS.statusrmLevel();
			Waitfor(1);
			ObjectInitClass.TS.selectEmpToApprove();
			Waitfor(2);
			 //Scenario 7: RM hold the time sheet 
			ObjectInitClass.TS.holdFunction();
			Waitfor(2);
			ObjectInitClass.TS.searchToApproveTab(empName);
			Waitfor(1);
			ObjectInitClass.TS.statusrmLevel();
			Waitfor(2);
		    ObjectInitClass.TS.selectEmpToApprove();
		    Waitfor(2);
		    ObjectInitClass.TS.rejectrmLevel();
			Waitfor(2);
		    ObjectInitClass.HP.Log_Out();
			Waitfor(2);
		}
		
		
		// Scenario : Employee Resubmit timesheet
		@Test(priority=4, enabled=true )
		public void resubmitTimesheet()
		{
			// Read Excel object creation to pass the sheet parameter.
			String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //Reading Username from excel
			Waitfor(1);
			String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //Reading Password from excel
			Waitfor(1);
			ObjectInitClass.LP.signIn(username, password);
			Waitfor(3);
			ObjectInitClass.TS.myLynx();
			Waitfor(2);
			ObjectInitClass.TS.searchEmpTimesheet(timeDates);
			Waitfor(2);
			ObjectInitClass.TS.status();
			Waitfor(2);
			ObjectInitClass.TS.selectTimesheet();
			Waitfor(2);
			ObjectInitClass.TS.resubmitTimesheet();
			Waitfor(2);
			ObjectInitClass.TS.status();
			Waitfor(2);
			ObjectInitClass.HP.Log_Out();
			Waitfor(2);
		}
		
		@Test(priority=5, enabled=true )
		public void rmApproveTimesheet()
		{
			//Scenario 6: RM approve the time sheet 
			Waitfor(1);
			String username= excelreaddata().getData("Login_Credentials", 1, 0 ); //Reading Username from excel
			Waitfor(1);
			String password= excelreaddata().getData("Login_Credentials", 1, 1 ); //Reading Password from excel
			Waitfor(1);
			ObjectInitClass.LP.signIn(username, password);
			Waitfor(3);
			ObjectInitClass.TS.myLynx();
			Waitfor(2);
			ObjectInitClass.TS.toApproveTab();
			Waitfor(1);
			ObjectInitClass.TS.searchToApproveTab(empName);
			Waitfor(1);
			ObjectInitClass.TS.statusrmLevel();
			Waitfor(1);
			ObjectInitClass.TS.selectEmpToApprove();
			Waitfor(1);
			  //Scenario 7: RM assign the time sheet 
			ObjectInitClass.TS.assignrmLevel();
			Waitfor(1);
			ObjectInitClass.TS.searchToApproveTab(empName);
			Waitfor(1);
			ObjectInitClass.TS.statusrmLevel();
			Waitfor(1);
			ObjectInitClass.TS.selectEmpToApprove();
			Waitfor(2);
			 //Scenario 7: RM hold the time sheet 
			ObjectInitClass.TS.holdFunction();
			Waitfor(2);
			ObjectInitClass.TS.searchToApproveTab(empName);
			Waitfor(1);
			ObjectInitClass.TS.statusrmLevel();
			Waitfor(2);
		    ObjectInitClass.TS.selectEmpToApprove();
		    Waitfor(2);
		    //Scenario 8: RM reject the time sheet 
		    ObjectInitClass.TS.approvermLevel();
			Waitfor(2);
		    ObjectInitClass.HP.Log_Out();
			Waitfor(2);
			
		}
		
		
		@Test(priority=6, enabled=true )
		public void spocApproveLevel()
		{
			  //Scenario 9: RMG approve the time sheet 
			Waitfor(1);
			String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
			Waitfor(1);
			String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
			Waitfor(1);
			ObjectInitClass.LP.signIn(username, password);
			Waitfor(3);
			ObjectInitClass.TS.myTask();
			Waitfor(2);
			ObjectInitClass.TS.searchMyTask(empName);
			Waitfor(2);
			  //Scenario 10: RMg assign the time sheet 
			ObjectInitClass.TS.assignspocLevel();
			Waitfor(2);
			ObjectInitClass.TS.searchMyTask(empName);
			Waitfor(2);
			ObjectInitClass.TS.statusinSpocLevel();
			Waitfor(2);
			  //Scenario 11: RMg hold the time sheet 
			ObjectInitClass.TS.holdspocLevel();
			Waitfor(2);
			ObjectInitClass.TS.searchMyTask(empName);
			Waitfor(2);
			ObjectInitClass.TS.statusinSpocLevel();
			Waitfor(2);
			ObjectInitClass.TS.approvespocLevel();
			Waitfor(2);
			ObjectInitClass.HP.Log_Out();
			Waitfor(2);
			
		}
		
		@Test(priority=7, enabled=true )
		public void verifyStatus()
		{
			  //Scenario 12: checking status as a employee
			String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //Reading Username from excel
			Waitfor(1);
			String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //Reading Password from excel
			Waitfor(1);
			ObjectInitClass.LP.signIn(username, password);
			Waitfor(3);
			ObjectInitClass.TS.myLynx();
			Waitfor(2);
			ObjectInitClass.TS.status();
			Waitfor(2);
			ObjectInitClass.HP.Log_Out();
		}
		
		
}	