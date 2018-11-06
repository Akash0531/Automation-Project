package com.dikshatech.tst.testscripts;

import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.LogStatus;

public class EmployeeOnboardModule extends TestBase
{
	String rmg_name= "";
	String rep_time= "9:30";
	String candid = "1092";
	String candStatus="Documents Submitted";
	String employeeID="";

	int row=1;
	//Candidate Department and EMployee Details
	// Reading all the fields data from excel
	String Company_Name= excelreaddata().getData("EOB", row, 0 );
	//String Employe_ID= excelreaddata().getData("Employees", row, 1 ); 
	String Region_Name= excelreaddata().getData("EOB", row, 1 ); 
	String Location_Name= excelreaddata().getData("EOB", row, 2 ); 
	String Department_Name= excelreaddata().getData("EOB", row, 3 ); 
	String Category_Name= excelreaddata().getData("EOB", row, 4 ); 
	String Level_Name= excelreaddata().getData("EOB", row, 5 ); 
	String Designation= excelreaddata().getData("EOB", row, 6 ); 
	String Reporting_ManagerName= excelreaddata().getData("EOB", row, 7 ); 
	String SPOC_name= excelreaddata().getData("EOB", row, 8 ); 	
	String Project_Name= excelreaddata().getData("EOB", row, 9 ); 
	String CandFirst_Name= excelreaddata().getData("EOB", row, 10 ); 
	String CandLast_Name= excelreaddata().getData("EOB", row, 11 ); 
	//String Dateof_Birth= excelreaddata().getData("EOB", row, 12 ); 
	String CandidateMail_ID= excelreaddata().getData("EOB", row, 15 ); 
	//String Dateof_Joining= excelreaddata().getData("EOB", row, 16 ); 
	String NoticePeriod= excelreaddata().getData("EOB", row, 17 ); 
	//String Employment_Type= excelreaddata().getData("EOB", row, 18 ); 
	String Role= excelreaddata().getData("EOB", row, 19 ); 
	String CTC_Current= excelreaddata().getData("EOB", row, 20 ); 
	String QPLB_Amount= excelreaddata().getData("EOB", row, 21 ); 
	String Per_qplb= excelreaddata().getData("EOB", row, 22 ); 
	String Per_aplb= excelreaddata().getData("EOB", row, 23 ); 
	String Primary_BankName= excelreaddata().getData("EOB", row, 24 ); 
	String Primary_Account= excelreaddata().getData("EOB", row, 25 ); 
	String IFSCCODE= excelreaddata().getData("EOB", row, 26 ); 
	String username= excelreaddata().getData("EOB", row, 27 );
	String Emp_Firstname= excelreaddata().getData("EOB", row, 28 );
	String domain_name= excelreaddata().getData("EOB", row, 29 );
	String Cand_PerAddress= excelreaddata().getData("EOB", row, 30 ); 
	String Cand_PerCity= excelreaddata().getData("EOB", row, 31 ); 
	String Cand_PerPincode= excelreaddata().getData("EOB", row, 32 ); 
	String Cand_Perstate= excelreaddata().getData("EOB", row, 33 ); 
	String Cand_PermanaentCountry= excelreaddata().getData("EOB", row, 34 ); 
	String Cand_CurAddress= excelreaddata().getData("EOB", row, 35 ); 
	String Cand_CurCity= excelreaddata().getData("EOB", row,36 ); 
	String Cand_CurPincode= excelreaddata().getData("EOB", row, 37 ); 
	String Cand_Curstate= excelreaddata().getData("EOB", row, 38 ); 
	String Cand_CurrentCountry= excelreaddata().getData("EOB", row, 39 );
	String Cand_Mothername= excelreaddata().getData("EOB", row, 40 ); 
	String Cand_Fathername= excelreaddata().getData("EOB", row, 41 ); 			
	String Cand_PrimaryPhNo= excelreaddata().getData("EOB", row, 42 ); 
	String Cand_SeconPhNo= excelreaddata().getData("EOB", row, 43 ); 
	String Cand_Mailid= excelreaddata().getData("EOB", row, 44 ); 
	String Cand_AltMailId= excelreaddata().getData("EOB", row, 45 ); 
	String Cand_Emrgcontactname= excelreaddata().getData("EOB", row, 46 ); 
	String Cand_EmRelation= excelreaddata().getData("EOB", row, 47 ); 
	String Cand_EmrgPhonenum= excelreaddata().getData("EOB", row, 48 ); 
	String Cand_blodgroup =excelreaddata().getData("EOB", row, 49 ); 	
	String PerCon_Name= excelreaddata().getData("EOB", row, 50 ); 
	String Percon_Rel= excelreaddata().getData("EOB", row, 51 ); 
	String Per_PhNo= excelreaddata().getData("EOB", row, 52 ); 
	String Per_emailid= excelreaddata().getData("EOB", row, 53 ); 
	String Prof_Contname= excelreaddata().getData("EOB", row, 54 ); 
	String Prof_Desig= excelreaddata().getData("EOB", row, 55 ); 
	String Prof_Phnum= excelreaddata().getData("EOB", row, 56 );
	String Prof_mailid= excelreaddata().getData("EOB", row, 57 );
	String Nom_Name= excelreaddata().getData("EOB", row, 58 ); 
	String Nom_Relation= excelreaddata().getData("EOB", row, 59 ); 
	String Nom_Contactno= excelreaddata().getData("EOB", row, 60 ); 
	String NomDepadantname= excelreaddata().getData("EOB", row, 61 ); 
	String NomDepRelation= excelreaddata().getData("EOB", row, 62 );	
	String PF= excelreaddata().getData("EOB", row, 63 );
	String Aadhar= excelreaddata().getData("EOB", row, 64 );
	String PAN= excelreaddata().getData("EOB", row, 65 );
	String UAN= excelreaddata().getData("EOB", row, 66 );
	String PBankName= excelreaddata().getData("EOB", row, 67 );
	String Primary_acno= excelreaddata().getData("EOB", row, 68 );
	String Primay_IFSC= excelreaddata().getData("EOB", row, 69 );
	String GivenName= excelreaddata().getData("EOB", row, 70 ); 
	String Surname= excelreaddata().getData("EOB", row, 71 ); 
	String PassportNo= excelreaddata().getData("EOB", row, 72 ); 
	String Placeofissue= excelreaddata().getData("EOB", row, 73 ); 
	String Placeofbirth= excelreaddata().getData("EOB", row, 74 ); 
	String Visatype= excelreaddata().getData("EOB", row, 75 ); 
	String VisaCountry= excelreaddata().getData("EOB", row, 76 );
	String Degreename= excelreaddata().getData("EOB", row, 77 ); 
	String Majorsubject= excelreaddata().getData("EOB", row, 78 ); 
	String PassingYear= excelreaddata().getData("EOB", row, 79 ); 
	String StudentId= excelreaddata().getData("EOB", row, 80 ); 
	String CollegeName= excelreaddata().getData("EOB", row, 81 ); 
	String Percentage= excelreaddata().getData("EOB", row, 82 ); 
	String Degreetype= excelreaddata().getData("EOB", row, 83 ); 
	String Edu_Gap= excelreaddata().getData("EOB", row, 84 ); 
	String GapReason= excelreaddata().getData("EOB", row, 85 ); 
	String Training_instname= excelreaddata().getData("EOB", row, 86 ); 
	String coursename= excelreaddata().getData("EOB", row, 87 ); 
	String Rank= excelreaddata().getData("EOB", row, 88 ); 
	String TrainingYear= excelreaddata().getData("EOB", row, 89 );	
	String Company= excelreaddata().getData("EOB", row, 90 ); 
	String Exp_Designation= excelreaddata().getData("EOB", row, 91 ); 
	String DOL= excelreaddata().getData("EOB", row, 92 ); 
	String EMPID= excelreaddata().getData("EOB", row, 93 ); 
	String Reportedto= excelreaddata().getData("EOB", row, 94 ); 
	String Leavingreason= excelreaddata().getData("EOB", row, 95 ); 
	String HRname= excelreaddata().getData("EOB", row, 96 ); 	
	String Gapreason= excelreaddata().getData("EOB", row, 97 ); 
	String Skill= excelreaddata().getData("EOB", row, 98 ); 
	String searchEmployeeName= CandFirst_Name+" "+CandLast_Name;
	String usnLynx="";
    

	//Login the Lynx application
	@Test(priority=0, enabled=true,description= "*****Validation of all the webelement and functionalities composed in HomePage*****")
	public void rmglogin() throws Exception
	{
		// Repository object creation.
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.employeeonboardingobjects(driver);

		// Read Excel object creation to pass the sheet parameter.
		String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		Waitfor(1);

		ObjectInitClass.LP.signIn(username, password);
		Waitfor(5);
		rmg_name= ObjectInitClass.EOB.get_acc_Hldr_Name();	
	}
	
	//RMG submit the candidate without financial info
	@Test(priority=1,enabled=true)
	public void rmgSubmit_NewCandidate() throws Exception
	{
		ObjectInitClass.EOB.Click_MylynxTab();
		Waitfor(2);
		ObjectInitClass.EOB.Click_CandidateTab();
		Waitfor(3);
		ObjectInitClass.EOB.ClickNewCand_Button();
		Waitfor(1);
		ObjectInitClass.EOB.EnterCand_Details(Company_Name, Region_Name, Location_Name, Department_Name, Category_Name, Level_Name, Reporting_ManagerName, SPOC_name,Project_Name, CandFirst_Name, CandLast_Name,1, CandidateMail_ID, 25,NoticePeriod, Role);
		Waitfor(2);
		ObjectInitClass.EOB.Submit_Candidate();
		Waitfor(2);
		candid= ObjectInitClass.EOB.getcandidate_ID(searchEmployeeName, "SUBMITTED");
	}
	
	//candidate will save all the tabs information
	@Test(priority=2,enabled=true)		
	public void candidate_Submit_WithProgress() throws Exception
	{
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		String cand_link= ObjectInitClass.EOB.welcome_mail_validation(username, Emp_Firstname, domain_name);
		Waitfor(10);
		driver.get(cand_link);
		Waitfor(2);
		ObjectInitClass.EOB. candidate_submit_button();	
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_PermanantAddress(Cand_PerAddress, Cand_PerCity, Cand_PerPincode, Cand_Perstate, Cand_PermanaentCountry);
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_CurrentAddress(Cand_CurAddress, Cand_CurCity, Cand_CurPincode, Cand_Curstate, Cand_CurrentCountry, Cand_Mothername,1, Cand_Fathername,2);
		Waitfor(4);		
		ObjectInitClass.EOB.Cand_ContactNumbers(Cand_PrimaryPhNo, Cand_SeconPhNo, Cand_Mailid, Cand_AltMailId,"suma", "suma", Cand_EmrgPhonenum,Cand_blodgroup);
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_Genralinfo(PerCon_Name, Percon_Rel, Per_PhNo, Per_emailid, Prof_Contname, Prof_Desig, Prof_Phnum, Prof_mailid);
		Waitfor(2);	
		ObjectInitClass.EOB. Scroll_down();
		Waitfor(2);	
		ObjectInitClass.EOB.personal_info_tab_captrue();
		Waitfor(2);	
		ObjectInitClass.EOB.Scroll_Up();
		
	    //nominee tab
	    Waitfor(2);	
		ObjectInitClass.EOB.Click_candNomineeinfotab();
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_NomineeInfoDetails(Nom_Name, Nom_Relation, Nom_Contactno, NomDepadantname, NomDepRelation);
		Waitfor(2);		
		ObjectInitClass.EOB. Scroll_down();
		Waitfor(2);	
	    ObjectInitClass.EOB. nominee_info_tab_captrue();
	    Waitfor(2);	 
	    
		//financial tab
		Waitfor(2);	
		ObjectInitClass.EOB.click_Candfinanceinfotab();
		Waitfor(2);	
		ObjectInitClass.EOB.candfill_financeinfo(PF, Aadhar, PAN, UAN, PBankName, Primary_acno, Primay_IFSC);
		Waitfor(2);	
		ObjectInitClass.EOB. Scroll_down();
		Waitfor(2);
		ObjectInitClass.EOB.financial_info_tab_captrue();
		
	    //passport info      
	    Waitfor(2);
	    ObjectInitClass.EOB.click_candpassportinfotab();
	    Waitfor(2);	
	    ObjectInitClass.EOB.Cand_PassportDetails(GivenName, Surname, PassportNo,4,6, Placeofissue, Placeofbirth, "abcd",11,12, VisaCountry);
	    Waitfor(2);	
	    ObjectInitClass.EOB. passport_info_tab_captrue();
	    Waitfor(2);
	     
	    //edu	
	    
		ObjectInitClass.EOB.click_candeducationalinfotab();
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_Educationalinfo_Tab("Degree or Equivalent",  "Anything", "2014",  "245622",  "Diksha College", 5,  1, "A");
		Waitfor(2);	
		ObjectInitClass.EOB. Scroll_down();
		ObjectInitClass.EOB. Scroll_down();
		Waitfor(2);	
		ObjectInitClass.EOB. educational_info_tab_captrue();
		Waitfor(3);	
		
		//exp	
		
		ObjectInitClass.EOB.click_candexperienceinfotab();
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_Experienceinfo(Company, Exp_Designation, DOL, EMPID, Reportedto, Leavingreason, HRname, 9, 11, 21, 30, Gapreason);
		Waitfor(2);	
		ObjectInitClass.EOB. Scroll_down();
		Waitfor(2);
		ObjectInitClass.EOB. experience_info_tab_captrue();
		Waitfor(2);
		
		//skil
		ObjectInitClass.EOB.Click_candskillinfotab();
		Waitfor(3);	
		ObjectInitClass.EOB.Cand_Skillsinfo();
		Waitfor(2);	
		ObjectInitClass.EOB. Scroll_down();
		Waitfor(2);	
		ObjectInitClass.EOB. skill_info_tab_captrue();

	}

	@Test(priority=3, enabled=true)
	public void rm_reportingdetailsvalidation()
	{
		ObjectInitClass.EOB.rm_reporting_details(candid,candStatus, rmg_name, rep_time);
		exlogger.log(LogStatus.INFO, "RM Reporting details captured data has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "RM_Reporting_Details")));
		ObjectInitClass.EOB.rm_reportingdetails_submit_validation();
		
	}
	
	@Test(priority=4, enabled=true)
	public void rm_itrequirementvalidation()
	{
	
		Waitfor(1);
		ObjectInitClass.EOB.it_requirementtab();
		Waitfor(1);
		ObjectInitClass.EOB.itHardwarefield_submitvalidation(1);
		exlogger.log(LogStatus.INFO, "IT req mandatory field has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "IT_Details")));

		Waitfor(2);
		ObjectInitClass.EOB.rm_it_requirements(candid, candStatus, 1);
		exlogger.log(LogStatus.INFO, "RM IT Requirements has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "RM_ITRequirements")));
		ObjectInitClass.EOB.rm_IT_finalSave();
	
		ObjectInitClass.EOB.it_saveddata_validation(1);
		exlogger.log(LogStatus.INFO, "IT Req Saved data has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "IT_Savevalidation")));

		Waitfor(2);
		ObjectInitClass.EOB.rm_ITsubmit();
		exlogger.log(LogStatus.INFO, "IT Req Submit data has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "IT_Submitvalidation")));
		Waitfor(1);
		
		ObjectInitClass.EOB.it_submitdataValidation(1);
		
	}	
		
	@Test(priority=5, enabled=true)
	public void rmg_reportingdetailsvalidation()
	{
		ObjectInitClass.EOB.rmg_reporting_details(candid, candStatus, rmg_name, rep_time);
		exlogger.log(LogStatus.INFO, "RMG Reporting details captured data with Edit Time field has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "RMG_Reporting_Details")));
		ObjectInitClass.EOB.rmg_reportingdetails_time(rep_time);
		exlogger.log(LogStatus.INFO, "RMG Reporting details Edit Time field has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "RMG_Reportingdetails_Timefield")));
		ObjectInitClass.EOB.rmg_reportingdetails_submit_validation();
		exlogger.log(LogStatus.INFO, "RMG Submit data has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "RMGReporting_Submit")));
		ObjectInitClass.EOB.rmg_reportingdetails_time(rep_time);
		exlogger.log(LogStatus.INFO, "RMG Reporting details Time field non-editable has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "RMGReporting_Timenoneditable")));
	}	

	@Test(priority=6, enabled=true)
	public void admin_itreqrejectvalidation()
	{
		ObjectInitClass.EOB.adf_formreject(candid , "");
		Waitfor(3);
		ObjectInitClass.EOB.rm_itrejectedrequirements(candid, candStatus);
		
	}
	
	@Test(priority=7, enabled=true)
	public void admin_itreqacceptvalidation()
	{
		ObjectInitClass.EOB.adf_formaccept(candid, "", 1);
		exlogger.log(LogStatus.INFO, "Admin ADF with related functionality has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "Admin_ADF")));

		ObjectInitClass.EOB.adfsubmit_validation();

	}
	
	@Test(priority=8, enabled=true)
	public void rm_clientreportingdetailsvalidation()
	{
		ObjectInitClass.EOB.rm_client_reportingdetails(candid, candStatus, 6);
		Waitfor(2);
		exlogger.log(LogStatus.INFO, "RM Client Reporting has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "RM_ClientRepo")));
		ObjectInitClass.EOB.client_RMsave();
		
		//ObjectInitClass.EOB.rmg_client_reportingvalidationcandmodule(candid, candStatus, Reporting_ManagerName); 
		//Waitfor(2);
		// This is for Validating the RM saved data with RMG saved data
		//ObjectInitClass.EOB.rm_client_Saved_reportingdetails(candid, candStatus, 6, Reporting_ManagerName);
		Waitfor(2);
		ObjectInitClass.EOB.rm_ClientFinalsubmit();
	}

	//RMG will validates the candidate informaiton and documents
	@Test(priority=9,enabled=true)
	public void RMGvalidates_candidateinfo()
	{
		ObjectInitClass.HP.Log_Out();
		Waitfor(1);
		ObjectInitClass.EOB.rmg_login();
		Waitfor(1);
		ObjectInitClass.EOB.candidate_statusbar_login(candid, "DOCUMENTS SUBMITTED" );
		Waitfor(1);
		ObjectInitClass.EOB.Edit_Candidate();
		Waitfor(2);	
		ObjectInitClass.EOB.click_Candfinanceinfotab();
		Waitfor(2);	
		ObjectInitClass.EOB.RMG_fillFinance_data(CTC_Current, QPLB_Amount);
		Waitfor(2);	
		ObjectInitClass.EOB.ClickFinanceSave_Button();
		Waitfor(2);	
		ObjectInitClass.EOB.click_backgroundverificationinfotab();
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_BGVinfo();
		Waitfor(2);	
		ObjectInitClass.EOB.RMGaccept_alldocs();
		Waitfor(2);	
//		ObjectInitClass.EOB.click_candeducationalinfotab();
//		Waitfor(2);	
//		ObjectInitClass.EOB.decresed_percentage();
				

	}
	@Test(priority=10, enabled=false)
	public void markasEmployee() throws Exception
	{	
		ObjectInitClass.EOB.candidate_statusbar_login(candid, "DOCUMENTS VERIFIED" );
		Waitfor(2);
		ObjectInitClass.EOB.markAsEmployee_button();
		Waitfor(2);
		ObjectInitClass.EOB.selectmailandConfirm();
		Waitfor(2);
		usnLynx=ObjectInitClass.EOB.LynxUserName();
		Waitfor(2);
		ObjectInitClass.EOB.rmgmodule();
		employeeID=ObjectInitClass.EOB.getemp_ID();
		Waitfor(2);
		ObjectInitClass.EOB.generateofferletter(employeeID);
		Waitfor(2);
		ObjectInitClass.EOB.approveTabMGR();
		Waitfor(2);
		ObjectInitClass.EOB.rejectRMGManagerLevel(employeeID);
		Waitfor(3);
		ObjectInitClass.EOB.generateofferletter(employeeID);
		Waitfor(3);
		ObjectInitClass.EOB.approveTabMGR();
		Waitfor(2);
		ObjectInitClass.EOB.approveRMGManagerLevel(employeeID);
		Waitfor(3);
		ObjectInitClass.HP.Log_Out();
		
	}
	
	@Test(priority=12, enabled=true)
	public void newEmployeeLogin() throws Exception
	{
	
		usnLynx=ObjectInitClass.EOB.LynxUserName();
		String pwdLynx="Lynx";
		Waitfor(1);
		ObjectInitClass.LP.signIn(usnLynx, pwdLynx);
		Waitfor(2);
		ObjectInitClass.EOB.acceptOfferLetter();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
	}
	
	@Test(priority=13, enabled=true)
	public void rejectUploadedOfl()
	{
		
		String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(2);
		ObjectInitClass.EOB.rmgmodule();
		Waitfor(1);
		ObjectInitClass.EOB.approveTabMGR();
		Waitfor(2);
		ObjectInitClass.EOB.rejectUploadedOfl(employeeID);
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
	}
	
	@Test(priority=14, enabled=true)
	public void uploadOfferletter()
	{
		
		Waitfor(2);
		usnLynx=ObjectInitClass.EOB.LynxUserName();
		String pwdLynx="Lynx";
		Waitfor(2);
		ObjectInitClass.LP.signIn(usnLynx, pwdLynx);
		Waitfor(2);
		ObjectInitClass.EOB.uploadOflEmp();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
	}
	
	@Test(priority=15, enabled=true)
	public void acceptUplodedOfl()
	{
		
		String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		Waitfor(1);
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(2);
		ObjectInitClass.EOB.rmgmodule();
		Waitfor(1);
		ObjectInitClass.EOB.approveTabMGR();
		Waitfor(2);
	    ObjectInitClass.EOB.acceptUplodedOfl(employeeID);
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
	}
	

	@Test(priority=16,enabled=false)
	public void orientatioan() throws Exception
	{
		Waitfor(2);
		String pwdLynx="Lynx";
		Waitfor(2);
		ObjectInitClass.LP.signIn(usnLynx, pwdLynx);
		Waitfor(2);
		//ObjectInitClass.EOB.orientation_login();
		//ObjectInitClass.EOB.orientation_tab_verify();
		Waitfor(3);
		ObjectInitClass.EOB.orientationlink();
		Waitfor(2);
		ObjectInitClass.EOB.orientationppt_view();
		Waitfor(2);
	    ObjectInitClass.EOB.answer_questionnarie();
		Waitfor(2);
		ObjectInitClass.EOB. clickon_missing_question_question();
		Waitfor(1);
		ObjectInitClass.EOB.check_result();
		Waitfor(3);
		ObjectInitClass.EOB.failure_again_test();
		Waitfor(2);
		ObjectInitClass.EOB.enable_left_menu_tabs();
		Waitfor(3);
	    //ObjectInitClass.EOB.video_disable_capture();
		Waitfor(2);
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
	}
	@Test(priority=17, enabled=false,description= "*****Validation of all the webelement and functionalities composed in HomePage*****")
	public void orientation_history_RMG() throws Exception
	{
		ObjectInitClass.HP.Log_Out();
		Waitfor(2);
		ObjectInitClass.EOB.rmg_login();
		Waitfor(3);
		ObjectInitClass.EOB.candidate_orientation_under_RMG(employeeID,"Orientation Completed");
		Waitfor(2);
	    ObjectInitClass.EOB.candidate_Attempts();
	    Waitfor(2);
		ObjectInitClass.HP.Log_Out();
	
	}
	
	@Test(priority=18,enabled=true)
	public void profile_status_under_rmg() throws Exception
	{
		ObjectInitClass.EOB.rmg_login();
		Waitfor(2);
		ObjectInitClass.EOB.candidate_statusbar_login("1073","SUBMITTED");
		Waitfor(2);	
	    ObjectInitClass.EOB.Scroll_Up();
	    Waitfor(2);	
	    ObjectInitClass.EOB.editbutton();
	    Waitfor(5);
	    ObjectInitClass.EOB.percentage_capture();
		Waitfor(2);	
		
//		//personal info tab
		ObjectInitClass.EOB. Scroll_down();
		ObjectInitClass.EOB. Save_Cand_Generalinfo();
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_PermanantAddress(Cand_PerAddress, Cand_PerCity, Cand_PerPincode, Cand_Perstate, Cand_PermanaentCountry);
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_CurrentAddress(Cand_CurAddress, Cand_CurCity, Cand_CurPincode, Cand_Curstate, Cand_CurrentCountry, Cand_Mothername,1, Cand_Fathername,2);
		Waitfor(4);		
		ObjectInitClass.EOB.Cand_ContactNumbers(Cand_PrimaryPhNo, Cand_SeconPhNo, Cand_Mailid, Cand_AltMailId," suma", "suma", Cand_EmrgPhonenum,Cand_blodgroup);
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_Genralinfo(PerCon_Name, Percon_Rel, Per_PhNo, Per_emailid, Prof_Contname, Prof_Desig, Prof_Phnum, Prof_mailid);
		Waitfor(2);	
		ObjectInitClass.EOB. Scroll_down();
		Waitfor(2);	
		ObjectInitClass.EOB.personal_info_tab_captrue();
		Waitfor(2);	
		ObjectInitClass.EOB.Scroll_Up();
		
		//	nominee tab	 
		ObjectInitClass.EOB.Click_candNomineeinfotab();
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_NomineeInfoDetails(Nom_Name, Nom_Relation, Nom_Contactno, NomDepadantname, NomDepRelation);
		Waitfor(2);	
		ObjectInitClass.EOB. Scroll_down();
		Waitfor(2);	
		ObjectInitClass.EOB. nominee_info_tab_captrue();
		Waitfor(2);	
//		
//		//financial tab
		Waitfor(2);	
		ObjectInitClass.EOB.click_Candfinanceinfotab();
		Waitfor(2);	
		ObjectInitClass.EOB.Add_Financeinfo_tab(CTC_Current, Primary_BankName, Primary_Account, IFSCCODE);
		Waitfor(4);	
		ObjectInitClass.EOB. Scroll_down();
		Waitfor(2);	
		ObjectInitClass.EOB.financial_info_tab_captrue();
		
		//passport info 
		Waitfor(2);
		ObjectInitClass.EOB.click_candpassportinfotab();
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_PassportDetails(GivenName, Surname, PassportNo,4,6, Placeofissue, Placeofbirth, "abcd",11,12, VisaCountry);
		Waitfor(2);	
		ObjectInitClass.EOB. Scroll_down();
		Waitfor(2);	
		ObjectInitClass.EOB. passport_info_tab_captrue();
		Waitfor(2);	
		
	    //edu
		ObjectInitClass.EOB.click_candeducationalinfotab();
		Waitfor(3);	
		ObjectInitClass.EOB.Cand_Educationalinfo_Tab("Degree or Equivalent",  "Anything", "2014",  "245622",  "Diksha College", 5,  1, "A");
		Waitfor(2);	
		ObjectInitClass.EOB. Scroll_down();
		ObjectInitClass.EOB. educational_info_tab_captrue();
		Waitfor(2);	
		
		//exp
		ObjectInitClass.EOB.click_candexperienceinfotab();
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_Experienceinfo(Company, Exp_Designation, DOL, EMPID, Reportedto, Leavingreason, HRname, 9, 11, 21, 30, Gapreason);
		Waitfor(2);	
		ObjectInitClass.EOB. Scroll_down();
		ObjectInitClass.EOB. experience_info_tab_captrue();
		Waitfor(2);	
		
		//skill
		ObjectInitClass.EOB.Click_candskillinfotab();
		Waitfor(2);	
		ObjectInitClass.EOB.Cand_Skillsinfo();
		Waitfor(2);	
		ObjectInitClass.EOB. Scroll_down();
		Waitfor(2);	
		ObjectInitClass.EOB.skill_info_tab_captrue_rmg();
		Waitfor(2);	
	    ObjectInitClass.HP.Log_Out();	
	}

	@Test(priority=11 , enabled=true)
	public void rmg_clientreportingdetailsvalidation()
	{
		ObjectInitClass.EOB.rmg_client_reportingvalidationempmodule("2020", "Orientation Completed"); // This is for Validating the RM Submitted data with RMG display data
		Waitfor(2);
		exlogger.log(LogStatus.INFO, "RM Client Reporting has been verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "RMGClientReportingDetails")));
		ObjectInitClass.EOB.rmg_ClientFinalsubmit();
	}	

	@Test(priority=2, enabled=false)
	public void cand_adfviewvalidation()
	{
		Waitfor(2);
		ObjectInitClass.EOB.cand_adfview();
	}	
		
	@Test(priority=7, enabled=true)
	public void rmg_backoutvalidation()
	{
		ObjectInitClass.EOB.cand_backout("1085", "Back Out");
	}
	
	//ObjectInitClass.EOB.adf_viewvalidation(candid, "Orientation Completed");
	
	


	
	
	
	
	 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
