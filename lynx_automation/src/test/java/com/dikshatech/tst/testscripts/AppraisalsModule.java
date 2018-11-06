package com.dikshatech.tst.testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelWriteData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AppraisalsModule extends TestBase
{

	int row=1;
	String Functional_area        =          excelreaddata().getData("Appraisal_sheet", row,0); 
	String Project_Type           =          excelreaddata().getData("Appraisal_sheet", row,1); 
	String Tasks_Performed        =          excelreaddata().getData("Appraisal_sheet", row,2); 
	String achievements_past_year =          excelreaddata().getData("Appraisal_sheet", row,3); 
	String listof_future_activities=         excelreaddata().getData("Appraisal_sheet", row,5);
	String specific_steps          =         excelreaddata().getData("Appraisal_sheet", row,6);
	String listof_smart_goals=               excelreaddata().getData("Appraisal_sheet", row,7);
	String objectives=                       excelreaddata().getData("Appraisal_sheet", row,8); 
	String Effected_from=                    excelreaddata().getData("Appraisal_sheet", row,13);
	String reviced_ctc=                      excelreaddata().getData("Appraisal_sheet", row,14);
	String Competency_Level_dropdown=        excelreaddata().getData("Appraisal_sheet", row,4);
	String viz_dropdown=                     excelreaddata().getData("Appraisal_sheet", row,4);
	String latest_technologies_dropdown=     excelreaddata().getData("Appraisal_sheet", row,4);
	String improve_skill=                    excelreaddata().getData("Appraisal_sheet", row,4);
	String Documentation_dropdown=           excelreaddata().getData("Appraisal_sheet", row,4);
	String business_dropdown=                excelreaddata().getData("Appraisal_sheet", row,4);
	String Demonstrates_skill=               excelreaddata().getData("Appraisal_sheet", row,4);
	String support_coworkers_skill=          excelreaddata().getData("Appraisal_sheet", row,4);
	String selfimprovement_skill=            excelreaddata().getData("Appraisal_sheet", row,4);
	String area_of_expertise_skill=          excelreaddata().getData("Appraisal_sheet", row,4);
	String work_in_team__skill=              excelreaddata().getData("Appraisal_sheet", row,4);
    String improve_promote =                 excelreaddata().getData("Appraisal_sheet", row,4);
    String organisations_skill=              excelreaddata().getData("Appraisal_sheet", row,4);
    String Coordination_skill=               excelreaddata().getData("Appraisal_sheet", row,4);
    String learning_activities_skill =       excelreaddata().getData("Appraisal_sheet", row,4);
    String organisation_rating =             excelreaddata().getData("Appraisal_sheet", row,4);
    String company_morale=                   excelreaddata().getData("Appraisal_sheet", row,4);
	String enter_final=                      excelreaddata().getData("Appraisal_sheet", row,5);
    String rm_concernes=                     excelreaddata().getData("Appraisal_sheet",row,6 );	
    String emp_ID="";
    String status="";
	
		@Test(priority=0, enabled=true,description= "*****Validation of all the webelement and functionalities composed in Appraisal****")
		public void appraisals() throws Exception
		{
			
			// excelreaddata() Excel object creation to pass the sheet parameter.
			ObjectInitClass.homepage(driver);
			ObjectInitClass.loginpage(driver);
			ObjectInitClass.Appraisalpage(driver);

			// excelreaddata() Excel object creation to pass the sheet parameter.
			String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //excelreaddata()ing Username from excel
			Waitfor(1);
			String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //excelreaddata()ing Password from excel
			Waitfor(1);
			ObjectInitClass.LP.signIn(username, password);
 		   //Validating the Lynx Home page URL for successful login confirmation
			String exp_url0 = ConfigDataProvider.getUrl();
			String act_url0 = getCurrentUrl();
			softassert().assertEquals(act_url0, exp_url0);
			logger.info("Application Url is verified, Successfully logged-In");
			logger.info("The current Home Page URL is -: " + act_url0);
			driver.manage().window().maximize();
			ScreenshotCapture.GetScreenshot(driver, "AprHome_Page");
			ObjectInitClass.AP.My_Lynx();
			Waitfor(2);
			ObjectInitClass.AP.Appraisals();	
			Waitfor(2);
			ObjectInitClass.HP.Log_Out();
			Waitfor(3);	
		}
		@Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in Appraisal****")
		public void Employee_appraisal_form() throws Exception
		{
			
			//Scenario 1:filling the appraisal as a employee
			ObjectInitClass.AP.Employee_login();
			Waitfor(2);
			ObjectInitClass.AP.filling_myappraisal_form("January","PAF Available");
			Waitfor(2);
			ObjectInitClass.AP.appraiseal_minuae();
			Waitfor(2);
			//Scenario 2:filling the rating as a employee
			ObjectInitClass.AP.New_Appraisals_Form(Functional_area, Project_Type);
			Waitfor(2);
			ObjectInitClass.AP.details_task(Tasks_Performed,achievements_past_year);
			Waitfor(2);
			ObjectInitClass.AP.skill_rating_detail(Competency_Level_dropdown, viz_dropdown, latest_technologies_dropdown ,business_dropdown, improve_skill, Documentation_dropdown);
			Waitfor(2);
			ObjectInitClass.AP.Behavioral_Attitude_Skills(Demonstrates_skill, support_coworkers_skill, selfimprovement_skill,area_of_expertise_skill, work_in_team__skill, improve_promote);
			Waitfor(2);
			ObjectInitClass.AP.rating_Contribution_Organizational_Goals( organisations_skill,Coordination_skill, learning_activities_skill, organisation_rating,company_morale);
			Waitfor(2);
			ObjectInitClass.AP.Scroll_down();
			Waitfor(2);
			ObjectInitClass.AP.clickon_continue_button();
			Waitfor(2);
			//Scenario 3:Save as a employee
			ObjectInitClass.AP.list_of_actvities_form(listof_future_activities, specific_steps,  listof_smart_goals ,objectives);
			Waitfor(2);
			ObjectInitClass.AP.filling_myappraisal_form("January","PAF Available");
			Waitfor(2);
			ObjectInitClass.AP.appraiseal_minuae();
			Waitfor(2);
			ObjectInitClass.AP.Scroll_down();
			Waitfor(2);
			ObjectInitClass.AP.clickon_continue_button();
			Waitfor(2);
			//Scenario 4:submit as a employee
            ObjectInitClass.AP.click_submit_button();
        	Waitfor(5);
			ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			//Scenario 5: RM APPROVE
			ObjectInitClass.AP.RM_login();
			Waitfor(2);
			ObjectInitClass.AP.RM_toapprove_button();
			Waitfor(2);
			ObjectInitClass.AP. myappraisal_form_RM("January","PAF Submitted");
			Waitfor(2);
			//Scenario 6: RM save
			ObjectInitClass.AP.RM_accepting();
			Waitfor(2);
			ObjectInitClass.AP.click_on_accept_button();
			Waitfor(2);
			ObjectInitClass.AP. myappraisal_form_RM("January","In-progress");
			Waitfor(2);
			ObjectInitClass.AP.RM_continue();
			Waitfor(2);
			ObjectInitClass.AP.skill_rating_detail(Competency_Level_dropdown, viz_dropdown, latest_technologies_dropdown ,business_dropdown, improve_skill, Documentation_dropdown);
			Waitfor(2);
			ObjectInitClass.AP.Behavioral_Attitude_Skills(Demonstrates_skill, support_coworkers_skill, selfimprovement_skill,area_of_expertise_skill, work_in_team__skill, improve_promote);
			Waitfor(2);
			ObjectInitClass.AP.rating_Contribution_Organizational_Goals( organisations_skill,Coordination_skill, learning_activities_skill, organisation_rating,company_morale);
			Waitfor(2);
			ObjectInitClass.AP.clickon_continue_button();
			Waitfor(2);	
			//Scenario 7: RM submit
			ObjectInitClass.AP.RM_submit_button(enter_final,rm_concernes);
			Waitfor(5);
			ObjectInitClass.HP.Log_Out();
			Waitfor(1);	
            //Scenario 8:RMG rejecting functionality
			ObjectInitClass.AP.RMG_login();
			Waitfor(2);
			ObjectInitClass.AP.RMG_tohandle_button();
			Waitfor(2);
			ObjectInitClass.AP.myappraisal_form_RMG("January","Pending - RMG");
			Waitfor(2);
			ObjectInitClass.AP.RMG_action_appraisal_form();
			Waitfor(2);
			ObjectInitClass.AP.RM_accepting();
	        Waitfor(2);
			ObjectInitClass.AP. rmg_reject();
			Waitfor(5);
			ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			////Scenario 9:rm rejecting functionality
			ObjectInitClass.AP.RM_login();
			Waitfor(2);
			ObjectInitClass.AP.RM_toapprove_button();
			Waitfor(2);
			ObjectInitClass.AP. myappraisal_form_RM("January","Rejected By RMG");
			Waitfor(2);
			ObjectInitClass.AP.RM_accepting();
			Waitfor(2);
			ObjectInitClass.AP.Scroll_down();
			Waitfor(2);
			ObjectInitClass.AP.click_reject_button();
			Waitfor(5);
			ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			
		}
		@Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in Appraisal****")
		public void Employee_complete_form() throws Exception
		{
			//Scenario 10:rmg approve appraisal form
			ObjectInitClass.AP.Employee_login();
			Waitfor(2);
			ObjectInitClass.AP.filling_myappraisal_form("January","Rejected By Appraiser");
			Waitfor(2);
			ObjectInitClass.AP.appraiseal_minuae();
			Waitfor(2);
			ObjectInitClass.AP.Scroll_down();
			Waitfor(2);
			ObjectInitClass.AP.clickon_continue_button();
			Waitfor(2);
			Waitfor(2);
            ObjectInitClass.AP.click_submit_button();
        	Waitfor(5);
			ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			//Scenario 11:rm approve appraisal form
			ObjectInitClass.AP.RM_login();
			Waitfor(2);
			ObjectInitClass.AP.RM_toapprove_button();
			Waitfor(2);
			ObjectInitClass.AP.myappraisal_form_RM("January","PAF Submitted");
			Waitfor(2);
			ObjectInitClass.AP.RM_accepting();
			Waitfor(2);
			ObjectInitClass.AP.click_on_accept_button();
			Waitfor(2);
			ObjectInitClass.AP. myappraisal_form_RM("January","In-progress");
			Waitfor(2);
			ObjectInitClass.AP.RM_continue();
			Waitfor(2);
			ObjectInitClass.AP.clickon_continue_button();
			Waitfor(2);		
			ObjectInitClass.AP.RM_submit_button(enter_final,rm_concernes);
			Waitfor(5);
			ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			//Scenario 12:rmg approve appraisal form
			ObjectInitClass.AP.RMG_login();
			Waitfor(2);
			ObjectInitClass.AP.RMG_tohandle_button();
			Waitfor(2);
			ObjectInitClass.AP.myappraisal_form_RMG("January","Pending - RMG");
			Waitfor(2);
			ObjectInitClass.AP.RMG_action_appraisal_form();
			Waitfor(2);
			ObjectInitClass.AP.RM_accepting();
	        Waitfor(2);
			ObjectInitClass.AP.RMG_approve_button();
			Waitfor(2);
			ObjectInitClass.AP.RMG_tohandle_button();
			Waitfor(2);
			ObjectInitClass.AP.myappraisal_form_RMG("January","Completed");
			Waitfor(2);
			ObjectInitClass.AP.	RMG_sendmail_appraisal_form(Effected_from,reviced_ctc,row);
			Waitfor(2);
			//Scenario 13:rmg sendmail form
			ObjectInitClass.AP.	send_mail_toemployee();
			Waitfor(5);
			ObjectInitClass.HP.Log_Out();
			Waitfor(1);
					
		}

}


