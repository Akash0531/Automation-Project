package com.dikshatech.tst.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Strings;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class RollOnModule extends TestBase{
	   
	 // This Roll on To Department of Consulting Excel Data
	 int rowone=1;
	 String empID=excelreaddata().getData("RollOn_Sheet", rowone, 0 );

	 // Project Name Information Tab
	 String selectProject=excelreaddata().getData("RollOn_Sheet", rowone, 1 );
	 String selectDept=excelreaddata().getData("RollOn_Sheet", rowone, 2 );
	 String selectCategory= excelreaddata().getData("RollOn_Sheet", rowone, 3 );
	 String selectLevel=excelreaddata().getData("RollOn_Sheet", rowone, 4 );
	 String rollonComments=excelreaddata().getData("RollOn_Sheet", rowone, 5 );
	 // Selecting Project Location
	 String selectProjectLoction=excelreaddata().getData("RollOn_Sheet", rowone, 6 );
	 // Reporting Mananger Contact Info Tab
	 String rmName=excelreaddata().getData("RollOn_Sheet", rowone, 7 );
	 String details= excelreaddata().getData("RollOn_Sheet", rowone, 8 );
	 String rmemailID= excelreaddata().getData("RollOn_Sheet", rowone, 9 );
	 String rmPhNum=excelreaddata().getData("RollOn_Sheet", rowone, 10 );
	 //Other Information Tab
	 String selectStartDate =excelreaddata().getData("RollOn_Sheet", rowone, 11 );
	 String selectstartMonth =excelreaddata().getData("RollOn_Sheet", rowone, 12 );
	 String selectStartYear =excelreaddata().getData("RollOn_Sheet", rowone, 13 );
	 String selectendDate =excelreaddata().getData("RollOn_Sheet", rowone, 14 );
	 String selectEndMonth =excelreaddata().getData("RollOn_Sheet", rowone, 15 );
	 String selectendYear =excelreaddata().getData("RollOn_Sheet", rowone, 16 );
	 String selectreportdate =excelreaddata().getData("RollOn_Sheet", rowone, 17 );
	 String selectReportMonth =excelreaddata().getData("RollOn_Sheet", rowone, 18 );
	 String selectreportYear =excelreaddata().getData("RollOn_Sheet", rowone, 19 );
	 String reportingTime =excelreaddata().getData("RollOn_Sheet", rowone, 20 );
	 String perdiemAmount =excelreaddata().getData("RollOn_Sheet", rowone, 21 );
	 String notisfermailname=excelreaddata().getData("RollOn_Sheet", rowone, 22 );
	 
	 
	 // This Roll on To Department of Consulting Department Excel Data
	 int rowtwo=16;
	 String empIDc=excelreaddata().getData("RollOn_Sheet", rowtwo, 0 );
	 // Project Name Information Tab
	 String selectProjectc=excelreaddata().getData("RollOn_Sheet", rowtwo, 1 );
	 String selectDeptc=excelreaddata().getData("RollOn_Sheet", rowtwo, 2 );
	 String selectCategoryc= excelreaddata().getData("RollOn_Sheet", rowtwo, 3 );
	 String selectLevelc=excelreaddata().getData("RollOn_Sheet", rowtwo, 4 );
	 String rollonCommentsc=excelreaddata().getData("RollOn_Sheet", rowtwo, 5 );
	 // Selecting Project Location
	 String selectProjectLoctionc=excelreaddata().getData("RollOn_Sheet", rowtwo, 6 );
	 // Reporting Mananger Contact Info Tab
	 String rmNamec=excelreaddata().getData("RollOn_Sheet", rowtwo, 7 );
	 String detailsc= excelreaddata().getData("RollOn_Sheet", rowtwo, 8 );
	 String rmemailIDc= excelreaddata().getData("RollOn_Sheet", rowtwo, 9 );
	 String rmPhNumc=excelreaddata().getData("RollOn_Sheet", rowtwo, 10 );
	 //Other Information Tab
	 String selectStartDatec =excelreaddata().getData("RollOn_Sheet", rowtwo, 11 );
	 String selectstartMonthc =excelreaddata().getData("RollOn_Sheet", rowtwo, 12 );
	 String selectStartYearc =excelreaddata().getData("RollOn_Sheet", rowtwo, 13 );
	 String selectendDatec =excelreaddata().getData("RollOn_Sheet", rowtwo, 14 );
	 String selectEndMonthc =excelreaddata().getData("RollOn_Sheet", rowtwo, 15 );
	 String selectendYearc =excelreaddata().getData("RollOn_Sheet", rowtwo, 16 );
	 String selectreportdatec =excelreaddata().getData("RollOn_Sheet", rowtwo, 17 );
	 String selectReportMonthc =excelreaddata().getData("RollOn_Sheet", rowtwo, 18 );
	 String selectreportYearc =excelreaddata().getData("RollOn_Sheet", rowtwo, 19 );
	 String reportingTimec =excelreaddata().getData("RollOn_Sheet", rowtwo, 20 );
	 String perdiemAmountc =excelreaddata().getData("RollOn_Sheet", rowtwo, 21 );
	 String notisfermailnamec=excelreaddata().getData("RollOn_Sheet", rowtwo, 22 );
	 
	 
	 
	 // This Roll on To Department of Service delivery Department Excel Data
     int rowthree=33;
	 String empIDs=excelreaddata().getData("RollOn_Sheet", rowthree, 0 );
	 // Project Name Information Tab
	 String selectProjects=excelreaddata().getData("RollOn_Sheet", rowthree, 1 );
	 String selectDepts=excelreaddata().getData("RollOn_Sheet", rowthree, 2 );
	 String selectCategorys= excelreaddata().getData("RollOn_Sheet", rowthree, 3 );
	 String selectLevels=excelreaddata().getData("RollOn_Sheet", rowthree, 4 );
	 String rollonCommentss=excelreaddata().getData("RollOn_Sheet", rowthree, 5 );
	 // Selecting Project Location
	 String selectProjectLoctions=excelreaddata().getData("RollOn_Sheet", rowthree, 6 );
	 // Reporting Mananger Contact Info Tab
	 String rmNames=excelreaddata().getData("RollOn_Sheet", rowthree, 7 );
	 String detailss= excelreaddata().getData("RollOn_Sheet", rowthree, 8 );
	 String rmemailIDs= excelreaddata().getData("RollOn_Sheet", rowthree, 9 );
	 String rmPhNums=excelreaddata().getData("RollOn_Sheet", rowthree, 10 );
	 //Other Information Tab
	 String selectStartDates =excelreaddata().getData("RollOn_Sheet", rowthree, 11 );
	 String selectstartMonths =excelreaddata().getData("RollOn_Sheet", rowthree, 12 );
	 String selectStartYears =excelreaddata().getData("RollOn_Sheet", rowthree, 13 );
	 String selectendDates =excelreaddata().getData("RollOn_Sheet", rowthree, 14 );
	 String selectEndMonths =excelreaddata().getData("RollOn_Sheet", rowthree, 15 );
	 String selectendYears =excelreaddata().getData("RollOn_Sheet", rowthree, 16 );
	 String selectreportdates =excelreaddata().getData("RollOn_Sheet", rowthree, 17 );
	 String selectReportMonths =excelreaddata().getData("RollOn_Sheet", rowthree, 18 );
	 String selectreportYears =excelreaddata().getData("RollOn_Sheet", rowthree, 19 );
	 String reportingTimes =excelreaddata().getData("RollOn_Sheet", rowthree, 20 );
	 String perdiemAmounts =excelreaddata().getData("RollOn_Sheet", rowthree, 21 );
	 String notisfermailnames=excelreaddata().getData("RollOn_Sheet", rowthree, 22 );
	 
	 
	 // Bench Report For  weekly Graph
	 String selStartDateWeekly=excelreaddata().getData("RollOn_Sheet", 49, 0 );
	 String selstartMonthWeekly=excelreaddata().getData("RollOn_Sheet", 49, 1 );
	 String selStartYearWeekly=excelreaddata().getData("RollOn_Sheet", 49, 2 );
	 
	 String selEndDateWeekly= excelreaddata().getData("RollOn_Sheet", 49, 3 );
	 String selEndMonthWeekly=excelreaddata().getData("RollOn_Sheet", 49, 4 );
	 String selEndYearWeekly=excelreaddata().getData("RollOn_Sheet", 49, 5 );
	 
	// Bench Report For  Monthly Graph
	 
	 String selStartDateMonthly=excelreaddata().getData("RollOn_Sheet", 53, 0 );
	 String selstartMonthMonthly=excelreaddata().getData("RollOn_Sheet", 53, 1 ); 
	 String selStartYearMonthly=excelreaddata().getData("RollOn_Sheet", 53, 2 );
	 
	 String selEndDatemonthly=excelreaddata().getData("RollOn_Sheet", 53, 3 );
	 String selEndMonthmonthly=excelreaddata().getData("RollOn_Sheet", 53, 4 ); 
	 String selEndYearmonthly=excelreaddata().getData("RollOn_Sheet", 53, 5 );
	 
	 
	 
	@Test(priority=0, enabled=true,description= "*****Validation of all the webelement and functionalities composed in Roll-On*****")
	public void VerifySpecialistRMZ() throws Exception{
		// Repository Object_InitClassect creation.
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.roll_On(driver);
	}

	
    /**********************************************************************/
	
	//  Roll on Module with Rollon Employee for Different Department and Different Projects
	
	/*********************************************************************/
	
	// Scenarion 01: Roll on For Project Belongs to Agile Lab Department
	@Test(priority=1, enabled=false)
	public void rollonEmployeeAgileLabDept(){
		
    /******* Login with the Agile Lab Manager Login User Name and Password**********/ 
		
		String username= excelreaddata().getData("Login_Credentials", 1, 0 ); //excelreaddata()ing Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials",1, 1 ); //excelreaddata()ing Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);
		
		
		ObjectInitClass.roll_ON.rollonModule();
		Waitfor(2);
		//Scenario-02 : Searching the Employee Based on Employee id in Roll on Module
		ObjectInitClass.roll_ON.searchBox(empID);
		Waitfor(2);
		ObjectInitClass.roll_ON.selectEmp();
		Waitfor(2);
		ObjectInitClass.roll_ON.rollonFunction();
		Waitfor(2);
		//Scenario-03 : Rollon View Project details Tab filling  
		ObjectInitClass.roll_ON.projectDetailsTab(selectProject, selectDept, selectCategory, selectLevel, rollonComments);
	    Waitfor(2);
		//Scenario-04 : Rollon View Project Location Selection 
	    ObjectInitClass.roll_ON.projectLocationTab(selectProjectLoction); // Rollon View Select Project Location details Tab 
	    Waitfor(2);
	    //Scenario-05 : Rollon View RM Contacts information filling  
	    ObjectInitClass.roll_ON.contactInfoTab(rmName, details, rmemailID, rmPhNum);// Rollon View Reporting Manager details Tab 
	    Waitfor(2);
	    //Scenario-06 : Rollon View Project others Informations Tab filling 
	    ObjectInitClass.roll_ON.otherInfoTab(selectStartDate, selectstartMonth, selectStartYear, selectendYear, selectEndMonth, selectendDate, selectreportdate, selectReportMonth, selectreportYear, reportingTime, perdiemAmount, notisfermailname);
	    Waitfor(2);
	    ObjectInitClass.roll_ON.currentInfoTab();// Contact Information
	    Waitfor(2);
	    //Scenario-07 : Rollon View Submit scenario 
	    ObjectInitClass.roll_ON.clickRollOn(); // Rollon Button
	    Waitfor(4);
	    ObjectInitClass.roll_ON.searchBox(empID);
	    Waitfor(2);
	    //Scenario-08 : Rollon View validation Using Rollon Project Name. 
	    ObjectInitClass.roll_ON.validateRollOn(selectProject);// Validate After Rollon using Project Name.
	    Waitfor(2);
	    ObjectInitClass.HP.Log_Out();
	    Waitfor(2);
	}
	
	

  // Scenario 09: Roll on For Project Belongs to Consulting Department(Same as Above Priority 01 for rollon)
	@Test(priority=3, enabled=false)
	public void rollonEmployeeConsultingDept(){
		
	    /******* Login with the Consulting Department Manager with User Name and Password**********/ 
		
		String username= excelreaddata().getData("Login_Credentials", 16, 0 ); //excelreaddata()ing Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials",16, 1 ); //excelreaddata()ing Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);
		ObjectInitClass.roll_ON.rollonModule();
		Waitfor(2);
		ObjectInitClass.roll_ON.searchBox(empIDc);
		Waitfor(2);
		ObjectInitClass.roll_ON.selectEmp();
		Waitfor(2);
		ObjectInitClass.roll_ON.rollonFunction();
		Waitfor(2);
		ObjectInitClass.roll_ON.projectDetailsTab(selectProjectc, selectDeptc, selectCategoryc, selectLevelc, rollonCommentsc);
	    Waitfor(2);
	    ObjectInitClass.roll_ON.projectLocationTab(selectProjectLoctionc);
	    Waitfor(2);
	    ObjectInitClass.roll_ON.contactInfoTab(rmNamec, detailsc, rmemailIDc, rmPhNumc);
	    Waitfor(2);
	    ObjectInitClass.roll_ON.otherInfoTab(selectStartDatec, selectstartMonthc, selectStartYearc, selectendYearc, selectEndMonthc, selectendDatec, selectreportdatec, selectReportMonthc, selectreportYearc, reportingTimec, perdiemAmountc, notisfermailnamec);
	    Waitfor(2);
	    ObjectInitClass.roll_ON.currentInfoTab();
	    Waitfor(2);
	    ObjectInitClass.roll_ON.clickRollOn();
	    Waitfor(4);
	    ObjectInitClass.roll_ON.searchBox(empIDc);
	    Waitfor(2);
	    ObjectInitClass.roll_ON.validateRollOn(selectProjectc);
	    Waitfor(2);
	    ObjectInitClass.HP.Log_Out();	
	    Waitfor(2);
	    
	}
	
	

	//Scenario 10: Roll on For Project Belongs to Service Delivery Department(Same as Above Priority 01 for rollon)
	@Test(priority=5, enabled=false)
	public void rollonEmployeeServiceDeliveryDept(){
		
	    /******* Login with the Service Delivery Department Manager with User Name and Password**********/ 		
		
		String username= excelreaddata().getData("Login_Credentials", 17, 0 ); //excelreaddata()ing Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials",17, 1 ); //excelreaddata()ing Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);
		ObjectInitClass.roll_ON.rollonModule();
		Waitfor(2);
		ObjectInitClass.roll_ON.searchBox(empIDs);
		Waitfor(2);
		ObjectInitClass.roll_ON.selectEmp();
		Waitfor(2);
		ObjectInitClass.roll_ON.rollonFunction();
		Waitfor(2);
		ObjectInitClass.roll_ON.projectDetailsTab(selectProjects, selectDepts, selectCategorys, selectLevels, rollonCommentss);
	    Waitfor(2);
	    ObjectInitClass.roll_ON.projectLocationTab(selectProjectLoctions);
	    Waitfor(2);
	    ObjectInitClass.roll_ON.contactInfoTab(rmNames, detailss, rmemailIDs, rmPhNums);
	    Waitfor(2);
	    ObjectInitClass.roll_ON.otherInfoTab(selectStartDates, selectstartMonths, selectStartYears, selectendYears, selectEndMonths, selectendDates, selectreportdates, selectReportMonths, selectreportYears, reportingTimes, perdiemAmounts, notisfermailnames);
	    Waitfor(2);
	    ObjectInitClass.roll_ON.currentInfoTab();
	    Waitfor(2);
	    ObjectInitClass.roll_ON.clickRollOn();
	    Waitfor(4);
	    ObjectInitClass.roll_ON.searchBox(empIDs);
	    Waitfor(2);
	    ObjectInitClass.roll_ON.validateRollOn(selectProjects);
	    Waitfor(2);
	    ObjectInitClass.HP.Log_Out();	
	    Waitfor(2);
	    
	}	
	/**********************************************************************/
	
	  // Roll on Module End Here....!!!
	
	/*********************************************************************/

	
	
	
	/**********************************************************************/
	
	// Bench Report Module Related Test Cases with Respect to Roll on Module
	
	/*********************************************************************/
	
	
   // Scenario 01(Bench Report Module):Rollon belongs to Agile Labs Bench and Softlock Report Module
	@Test(priority=2, enabled=true)
	public void agileDepartment(){
		
		 /******* Login with the Agile Lab Manager with User Name and Password**********/
		
		String username= excelreaddata().getData("Login_Credentials", 1, 0 ); //excelreaddata()ing Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials",1, 1 ); //excelreaddata()ing Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);
		//Scenario 02(Bench Report Module): Click Functionality on Bench Report Module
		ObjectInitClass.roll_ON.benchReportModule();
		Waitfor(3);
		
		//Scenario 03(Bench Report Module): Weekly Graph Functionality on Bench Report Module
		ObjectInitClass.roll_ON.reportsGraphicalweekly(selStartYearWeekly,selstartMonthWeekly,selStartDateWeekly, selEndYearWeekly, selEndMonthWeekly,selEndDateWeekly );
		Waitfor(3);
        ObjectInitClass.roll_ON.agileWeeklyEmpBenchDays();
		Waitfor(2);
		ObjectInitClass.roll_ON.agileWeeklyEmpMostCTC();
		Waitfor(3);
		//Scenario 04(Bench Report Module): Monthly Graph Functionality on Bench Report Module
		// Bench Cost for Employee, Number of Days Validation
		ObjectInitClass.roll_ON.reportsGraphicalMonthly(selStartYearMonthly,selstartMonthMonthly,selStartDateMonthly, selEndYearmonthly, selEndMonthmonthly,selEndDatemonthly );
		Waitfor(3);
		ObjectInitClass.roll_ON.agileMonthlyEmpBenchDays();
		Waitfor(2);
		ObjectInitClass.roll_ON.agileMonthlyEmpMostCTC();
		Waitfor(2);
		
		//Scenario 05(Bench Report Module): Search Functionality on Agile Lab Bench Report Module
		ObjectInitClass.roll_ON.serchFieldBench(empID);
		Waitfor(2);
		ObjectInitClass.roll_ON.globalBenchTabAll();
		Waitfor(2);
		//Scenario 06(Bench report module): Search Functionality on Global Bench 
		ObjectInitClass.roll_ON.serchFieldGlobalBench(empID);
		Waitfor(2);
		ObjectInitClass.roll_ON.allTabView();
		Waitfor(2);
		//Scenario 07(Bench report module): Search Functionality on OverAll Tab
		ObjectInitClass.roll_ON.serchFieldOverAllTab(empID);
		Waitfor(2);
		//Scenario 08(Bench report Module): Download Internal Report for Selected Reports Only
		ObjectInitClass.roll_ON.downloadreport();
		Waitfor(3);
		ObjectInitClass.HP.Log_Out();	
		Waitfor(2);
	}
	

    // Scenario 09(Bench Report Module):Rollon belongs to Consulting Bench and Softlock Bench Report Module
	@Test(priority=4, enabled=true)
	public void consultingDepartment(){
		
		 /******* Login with the Consulting Manager with User Name and Password**********/
		
		String username= excelreaddata().getData("Login_Credentials", 15, 0 ); //excelreaddata()ing Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials",15, 1 ); //excelreaddata()ing Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);
		ObjectInitClass.roll_ON.benchReportModule();
		Waitfor(2);
	    ObjectInitClass.roll_ON.reportsGraphicalweekly(selStartYearWeekly,selstartMonthWeekly,selStartDateWeekly, selEndYearWeekly, selEndMonthWeekly,selEndDateWeekly );
		Waitfor(3);
		ObjectInitClass.roll_ON.conWeeklyEmpBenchDays();
		Waitfor(2);
		ObjectInitClass.roll_ON.conWeeklyEmpMostCTC();
		Waitfor(3);
		ObjectInitClass.roll_ON.reportsGraphicalMonthly(selStartYearMonthly,selstartMonthMonthly,selStartDateMonthly, selEndYearmonthly, selEndMonthmonthly,selEndDatemonthly );
		Waitfor(3);
		ObjectInitClass.roll_ON.conMonthlyEmpBenchDays();
		Waitfor(5);
		ObjectInitClass.roll_ON.conMonthlyEmpMostCTC();
		Waitfor(2);
		 
		//Scenario 10: Search Function in Consulting bench Tab
		ObjectInitClass.roll_ON.serchFieldConBench(empIDc);
		Waitfor(2);
		ObjectInitClass.roll_ON.globalBenchTabAll();
		Waitfor(2);
		ObjectInitClass.roll_ON.serchFieldGlobalBench(empIDc);
		Waitfor(2);
		ObjectInitClass.roll_ON.allTabView();
		Waitfor(2);
		ObjectInitClass.roll_ON.serchFieldOverAllTab(empIDc);
		Waitfor(2);
		//Scenario 11: Download Internal Report Function using Select all Check Box in Consulting bench Tab
		ObjectInitClass.roll_ON.allReportDownload();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
	}
	
	
	// Scenario 12(Bench Report Module): Rollon belongs to the Service Delivery Bench Report Module
	@Test(priority=6, enabled=true)
	public void serviceDeliveryDept(){
		
		 /******* Login with the Service Delivery Manager with User Name and Password**********/
		String username= excelreaddata().getData("Login_Credentials", 16, 0 ); //excelreaddata()ing Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials",16, 1 ); //excelreaddata()ing Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);
		ObjectInitClass.roll_ON.benchReportModule();
		Waitfor(2);
		ObjectInitClass.roll_ON.reportsGraphicalweekly(selStartYearWeekly,selstartMonthWeekly,selStartDateWeekly, selEndYearWeekly, selEndMonthWeekly,selEndDateWeekly );
		Waitfor(3);
		ObjectInitClass.roll_ON.sdWeeklyEmpBenchDays();
		Waitfor(2);
		ObjectInitClass.roll_ON.sdWeeklyEmpMostCTC();
		Waitfor(3);
		ObjectInitClass.roll_ON.reportsGraphicalMonthly(selStartYearMonthly,selstartMonthMonthly,selStartDateMonthly, selEndYearmonthly, selEndMonthmonthly,selEndDatemonthly );
		Waitfor(3);
		ObjectInitClass.roll_ON.sdMonthlyEmpBenchDays();
		Waitfor(2);
		ObjectInitClass.roll_ON.sdMonthlyEmpMostCTC();
		Waitfor(2);
		//Scenario 13:Search Function in Service Delivery Department bench Tab
		ObjectInitClass.roll_ON.serchFieldsdBench(empIDs);
		Waitfor(2);
		ObjectInitClass.roll_ON.globalBenchTabAll();
		Waitfor(2);
		ObjectInitClass.roll_ON.serchFieldGlobalBench(empIDs);
		Waitfor(2);
		ObjectInitClass.roll_ON.allTabView();
		Waitfor(2);
		ObjectInitClass.roll_ON.serchFieldOverAllTab(empIDs);
		Waitfor(2);
		//Scenario 14: Download the Internal Report using select all Check box Internal Report
		ObjectInitClass.roll_ON.allReportDownload();
		Waitfor(3);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
	}  

	
	//Scenario 15: Bench Report Module This Method for RMG Manager,CEO and Bench Mananager Level
	
	@Test(priority=7, enabled=true)
	public void overAllReport(){
		
		 /******* Login with the RMG Manager,CEO, Bench Manager with User Name and Password**********/
		
		String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //excelreaddata()ing Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials",3, 1 ); //excelreaddata()ing Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);
		ObjectInitClass.roll_ON.benchReportModule();
		Waitfor(2);
		
	    //Scenario 16:Search Function in Service Delivery Bench Tab For SD Department
		ObjectInitClass.roll_ON.serchFieldGlobalBench(empID);
		Waitfor(2);
		
		ObjectInitClass.roll_ON.agileLabTab();
		Waitfor(2);
		ObjectInitClass.roll_ON.reportsGraphicalweekly(selStartYearWeekly,selstartMonthWeekly,selStartDateWeekly, selEndYearWeekly, selEndMonthWeekly,selEndDateWeekly );
		Waitfor(3);
        ObjectInitClass.roll_ON.agileWeeklyEmpBenchDays();
		Waitfor(2);
		ObjectInitClass.roll_ON.agileWeeklyEmpMostCTC();
		Waitfor(3);
		ObjectInitClass.roll_ON.reportsGraphicalMonthly(selStartYearMonthly,selstartMonthMonthly,selStartDateMonthly, selEndYearmonthly, selEndMonthmonthly,selEndDatemonthly );
		Waitfor(3);
		ObjectInitClass.roll_ON.agileMonthlyEmpBenchDays();
		Waitfor(2);
		ObjectInitClass.roll_ON.agileMonthlyEmpMostCTC();
		Waitfor(2);
		
		//Scenario 17:Search Function in Agile Bench with respect Agile Tab
		ObjectInitClass.roll_ON.serchFieldAgileTab(empID);
		Waitfor(2);
	
		ObjectInitClass.roll_ON.consultingBenchTab();
		//Scenario 18:Search Function in Consulting Bench with respect to Consulting Department
		Waitfor(2);
		ObjectInitClass.roll_ON.serchFieldConTab(empIDc);
	    Waitfor(2);
	    
		//Scenario 19:Search Function in Global Bench with respect to SD Tab
	    ObjectInitClass.roll_ON.serviceDeliveryTab();
	    Waitfor(2);
	    ObjectInitClass.roll_ON.servicedeliveryserchField(empIDs);
		Waitfor(2);
		
		//Scenario 20:Search Function in Over all with respect to Agile Tab
		ObjectInitClass.roll_ON.allTabView();
		Waitfor(2);
		ObjectInitClass.roll_ON.serchFieldOverAllTab(empID);
		Waitfor(2);
		
		//Scenario 21:Download Internal Report using select all Check box.
		ObjectInitClass.roll_ON.allReportDownload();
		Waitfor(3);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		
	} 

}


