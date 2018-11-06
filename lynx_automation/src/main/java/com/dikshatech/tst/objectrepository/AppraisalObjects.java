package com.dikshatech.tst.objectrepository;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class AppraisalObjects  extends TestBase 
{

	

	@Test
	
	public  AppraisalObjects(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//appriasal module//
	
	@FindBy(xpath="//span[contains(.,'My Lynx')]")                    WebElement  MYLYNX;
	@FindBy(xpath="//span[contains(.,'Appraisals')]")                 WebElement  Appraisals_Submodule;
	@FindBy(xpath="//section[@id='tabs']/h3")                         WebElement Appraisals_Background;
	@FindBy(xpath="//i[@title='Appraisals']")                         WebElement Appraisals_icon;
	@FindBy(xpath="//select[@name='appraisal_view_length']")          WebElement Entries_Count_Dropdown_apprailsals;
	@FindBy(xpath="//input[@type='search']")                          WebElement Search_Input_Box_Appraisals;
	@FindBy(xpath="//input[@aria-controls='appraisal_toApprove']")    WebElement Search_Input_Box_Appraisals_rm;
	@FindBy(xpath=".//*[@id='appraisal_view_wrapper']")               WebElement Table_Info_Appraisals;
	@FindBy(xpath="//a[@id='appraisal_view_previou']")                WebElement Previous_Button_Appraisals;
	@FindBy(xpath="//a[@id='appraisal_view_next']")                   WebElement Next_Appraisals;
	@FindBy(xpath="//td[contains(.,'PAF Available')]")                WebElement employee_checkbox;
	@FindBy(xpath="//button[@id='addappraisel']")                     WebElement Fill_form;
	
	//employee filling appraisal form
	
	@FindBy(xpath="//a[@href='#billing']")                               WebElement appraiseal_minuae;
	@FindBy(xpath="//a[@href='#shipping']")                              WebElement Project_details;
	@FindBy(xpath="//a[@href='#review']")                                WebElement individual_dev_plan;
	@FindBy(xpath="//span[@id='appraisal_emp_id']")                      WebElement EMPid;
	@FindBy(xpath="//button[@onclick='continueFill()']")                 WebElement countinue;
	@FindBy(xpath="//div[@id='shipping']/div[5]/div/button[2]")          WebElement countinue1;
	@FindBy(xpath="//div[@id='shipping']/div[5]/div/button[2]")          WebElement countinue2;
	@FindBy(xpath="//div[@id='billing']/div[2]/div/button")              WebElement countinue_rm;
	@FindBy(xpath="//select[@id='appraisal_functionArea_dropDown_0']")   WebElement Functional_Area_dropdown;
	@FindBy(xpath="//select[@id='appraisal_projectType_dropDown_0']")    WebElement Project_Type_dropdown;
	@FindBy(xpath="//textarea[@id='appraisal_detailsOfTask_0']")         WebElement Details_Task_Performed;
	@FindBy(xpath="//textarea[@id='appraisal_whatDoYouConsider']")       WebElement Input_achievements_past_year;
	@FindBy(xpath="//p[contains(.,'Appraisee')]")                        WebElement Appraisee_rating;
	@FindBy(xpath="//select[@id='appraisal_select_rating_2']")           WebElement Core_Competency_Level;
	@FindBy(xpath="//select[@id='appraisal_select_rating_10']")          WebElement undertaken_improve_them ;
	@FindBy(xpath="//select[@id='appraisal_select_rating_3']")           WebElement viz_finish_earlier;
	@FindBy(xpath="//select[@id='appraisal_select_rating_9']")           WebElement latest_technologies_trends;
	@FindBy(xpath="//select[@id='appraisal_select_rating_1']")           WebElement business_and_goals;
	@FindBy(xpath="//select[@id='appraisal_select_rating_4']")           WebElement Implementation_Documentation ;
	@FindBy(xpath="//select[@id='appraisal_select_rating_5']")           WebElement testing_Implementation_Documentation;
	@FindBy(xpath="//select[@id='appraisal_select_rating_6']")           WebElement Customer_KPISLAs;
	@FindBy(xpath="//select[@id='appraisal_select_rating_7']")           WebElement provide_solution ;
	@FindBy(xpath="//select[@id='appraisal_select_rating_8']")           WebElement Design_innovation;
	@FindBy(xpath="//p[contains(.,'Behavioral/Attitude Skills')]")       WebElement Behaviour_skill_rating;
	@FindBy(xpath="//select[@id='appraisal_select_rating_15']")          WebElement improve_promote_quality ;
	@FindBy(xpath="//select[@id='appraisal_select_rating_18']")          WebElement Demonstrates_Accountability;
	@FindBy(xpath="//select[@id='appraisal_select_rating_17']")          WebElement support_coworkers;
	@FindBy(xpath="//select[@id='appraisal_select_rating_11']")          WebElement selfimprovement;
	@FindBy(xpath="//select[@id='appraisal_select_rating_16']")          WebElement work_in_team;
	@FindBy(xpath="//select[@id='appraisal_select_rating_12']")          WebElement area_of_expertise ;
	@FindBy(xpath="//select[@id='appraisal_select_rating_14']")          WebElement work_client_location ;
	@FindBy(xpath="//select[@id='appraisal_select_rating_13']")          WebElement relationship_with_clients;
	@FindBy(xpath="//p[contains(.,'Contribution to OrganizationalGoals and Positive Influence')]") WebElement Organizational_Goals_rating ;
	@FindBy(xpath="//select[@id='appraisal_select_rating_20']")          WebElement organisations_interests_mind;
	@FindBy(xpath="//select[@id='appraisal_select_rating_19']")          WebElement Coordination_with_SPOCS;
	@FindBy(xpath="//select[@id='appraisal_select_rating_21']")          WebElement organizational_learning_activities ;
	@FindBy(xpath="//select[@id='appraisal_select_rating_22']")          WebElement about_the_organisation ;
	@FindBy(xpath="//select[@id='appraisal_select_rating_23']")          WebElement company_morale_spirit ;
	@FindBy(xpath="//textarea[@id='appraisal_listFutureAct_add']")       WebElement enter_future_activities;
	@FindBy(xpath="//textarea[@id='appraisal_listOutSmartGoles_add']")   WebElement enter_smart_goals;
	@FindBy(xpath="//input[@id='objective1']")                           WebElement enter_performance_objectives;
	@FindBy(xpath="//input[@id='objective2']")                           WebElement enter_specific_steps;
	@FindBy(xpath="//input[@id='objective3']")                           WebElement enter_specific_steps3;
	@FindBy(xpath="//input[@id='objective4']")                           WebElement enter_specific_steps4;
	@FindBy(xpath="//input[@id='objective5']")                           WebElement enter_specific_steps5;
	@FindBy(xpath="//input[@id='objective6']")                           WebElement enter_specific_steps6;
	@FindBy(xpath="//input[@id='objective7']")                           WebElement enter_specific_steps7;
	@FindBy(xpath="//input[@id='objective8']")                           WebElement enter_specific_steps8;
	@FindBy(xpath="//button[contains(.,'GoBack')]")                      WebElement GO_Bback_Button;
	@FindBy(xpath="//button[@onclick='backButtonClickAppraisal();']")    WebElement Appraisal_back_button;
	@FindBy(xpath="//button[@onclick='submitAppraisal();']")             WebElement Submit_button;
	@FindBy(xpath="//button[@onclick='saveAppraisal();']")               WebElement Save_Button;
	@FindBy(xpath="//div[contains(.,'XAppraisal Saved successfully')]")  WebElement Save_sucessfully_msg;
	@FindBy(xpath="//button[@onclick='backButtonClickAppraisal();']")    WebElement close_Button;
	@FindBy(xpath="//span[contains(.,'Appraisal Submitted successfully')]") WebElement msg_Appraisal_Submitted_Successfully;	
	//reporting manager approve apparaisals
	
	@FindBy(xpath="//a[@id='rmg_approve']")                               WebElement rm_to_approveButton;
	@FindBy(xpath="//select[@id='appraisal_periodsRM']")                  WebElement appraisal_period;
	@FindBy(xpath="//button[@onclick='acceptAppraisal()']")               WebElement accept_button;
	@FindBy(xpath=".//*[@id='approveRejectRM']/button[3]")                WebElement reject_Button;
	@FindBy(xpath="//select[@id='rating']")                               WebElement Appraiser_rating;
	@FindBy(xpath="//textarea[@id='appraisal_final_objective']")          WebElement enter_final_objectives;
	@FindBy(xpath="//textarea[@id='appraisal_issues']")                   WebElement enter_rm_concernes;
	@FindBy(xpath="//button[@onclick='submitAppraisalRM();']")            WebElement click_rm_submit;
	@FindBy(xpath="//span[@id='appraisal_emp_id']")                       WebElement View_employeeID;
	@FindBy(xpath="//div[@class='toast-message hide show']")              WebElement confirmatrion_popup;
	@FindBy(xpath="//form[@id='defaultForm_new']/div[2]/div/button[3]")   WebElement yes__Button;
	@FindBy(xpath="//form[@id='defaultForm_new']/div[2]/div/button[3]")   WebElement no__Button;
	
	// RMG approve appraisal
	
	@FindBy(xpath="//a[@id='rmg_handle']")                                WebElement Rmg_to_handle;
	@FindBy(xpath="////select[@id='appraisal_periodsRMG']")               WebElement select_period_dropdown;
	@FindBy(xpath="//button[@id='RMGAction']")                            WebElement Rmg_to_action;
	@FindBy(xpath="//button[@onclick='approveAppraisalRMG()']")           WebElement Rmg_to_approve;
	@FindBy(xpath="//td[@style='color: green;']")                         WebElement Appraisal_complted;
	@FindBy(xpath="//button[@id='sendMail']")                             WebElement Rmg_send_mail;
	@FindBy(xpath="//input[@id='datetimepicker']")                        WebElement Appraisal_date_Effect_from;
	@FindBy(xpath="//input[@id='revisedCTC']")                            WebElement Revised_ctc_per_annum;
	@FindBy(xpath="//input[@id='appName']")                               WebElement name_of_employee;
	@FindBy(xpath="//input[@id='appDesignation']")                        WebElement employee_designation;
	@FindBy(xpath="//button[@id='rmgSendMailPopup']")                     WebElement subject_of_email;
	@FindBy(xpath="//button[@id='rmgSendMailPopup']")                     WebElement send_mail_employee;
	@FindBy(xpath=".//*[@id='genericModal-buttons']/button[2]")           WebElement close_mail;
	
	// REJECTING FUNCTIONALITY
	
	@FindBy(xpath="//button[@onclick='rejectAppraisalRMG()']")            WebElement RMG_REJECT;
	@FindBy(xpath="//textarea[@id='appraisal_rejectComment']")            WebElement REJECT_COMMENTS;
	@FindBy(xpath="//button[@id='rejectAppraisalRMGAjaxCall']")           WebElement RMG_REJECT_BUTTON;
	@FindBy(xpath="//td[contains(.,'Rejected By RMG')]")                  WebElement REJECTED_BY_RMG;
	@FindBy(xpath="//button[@id='rejectAppraisalAjaxCall']")              WebElement RM_REJECT_BUTTON;
	@FindBy(xpath="//td[contains(.,'Rejected By Appraiser')]")            WebElement Rejected_By_Appraiser;
	
	
	/**
	 * Navigating To My Lynx
	 **/

	public void My_Lynx()
    {
		WebElement lynx= driver.findElement(By.xpath("//a[contains(.,'My Lynx')]"));
    	lynx.click();
    	Waitfor(2);
    }
	/**
	 * Navigating To Appraisal module Lynx
	 **/
	public void  Appraisals()
	{
		Appraisals_Submodule.click();
	}
	
	public String Appraisals_Bkg()
	{
		String color = Appraisals_Background.getCssValue("color");
	    logger.info("Heading RGBA colour: "+color);
	    String hex= Color.fromString(color).asHex();
	    logger.info(hex);
		return hex;
	}
	public boolean Appraisals_icon()
	{
		boolean b= Appraisals_icon.isDisplayed();
		logger.info("Icon is diplaying "+b);
		return b;
	}
	/**
	 * validating To  Appraisal Entries dropdown 
	 **/
	public void Entries_Count_Dropdown(String Count)
	{
		Select Dropdown = new Select(driver.findElement(By.name("Appraisals_all_length")));
		Dropdown.selectByVisibleText(Count);
		logger.info("The Entered Count is "+Count);
		
		List<WebElement> length = Dropdown.getOptions();
		int size= length.size();
		logger.info("Total No. of Dropdown values are : "+size);
		
		String value=null;
		StringBuffer sb=new StringBuffer();
		//for(int i=0; i<size; i++)
		for (WebElement string : length) 
		{
			value = string.getText();
			
            sb = sb.append(value).append(",");
		}	
	    logger.info(sb.toString());
	}
	public String Count_Selected()
	{
		String count= Entries_Count_Dropdown_apprailsals.getText();
		return count;
	}
	/**
	 * Search box in  Appraisal 
	 **/
	public void SearchBox(String text)
	{
		Search_Input_Box_Appraisals.sendKeys(Keys.chord(Keys.CONTROL, "a"),text);
	}
	public void Count_Entry_Display()
	{
	   String text= Table_Info_Appraisals.getText();
	   logger.info(text);
	}
	/**
	 *Next table pagination in  Appraisal 
	 **/
	public void Next_Table()
	{
		boolean status = Next_Appraisals.isEnabled();
		if(status==true)
		{
			Next_Appraisals.click();
		}
		else
		{
			logger.info("Next button is not enabled");
		}
	}
	/**
	 *previous table pagination in  Appraisal 
	 **/
	public void Previous_Table()
	{
		boolean status = Previous_Button_Appraisals.isEnabled();
		if(status==true)
		{
			Previous_Button_Appraisals.click();
		}
		else
		{
			logger.info("Previous button is not enabled");
		}
	}
	
	public void Pagination() {
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiem_home_paginate']/span/a"));
		String text1;
		String text2;
		if (page.size() > 0) {
			for (int i = 0; i < page.size(); i++) {
				text1 = "//div[@id='perdiem_home_paginate']/span/a[";
				text2 = "";
				driver.findElement(By.xpath("//div[@id='perdiem_home_paginate']/span/a[" + (i + 1) + "]")).click();
				Waitfor(2);
			}
			for (int j = page.size(); j >= 0; j--) 
			{
				driver.findElement(By.xpath("//div[@id='perdiem_home_paginate']/span/a[" + (j) + "]")).click();
				Waitfor(2);
			}
			
		} else {
			logger.info("There is no Pagination number present");
		}
	}
	/**
	 *employee filling appraisal form 
	 **/
	public String filling_myappraisal_form(String period, String status)
	{
		
		Search_Input_Box_Appraisals.sendKeys(Keys.chord(Keys.CONTROL, "a"),period);
			Waitfor(1);
		
			Actions action = new Actions(driver);
			int count = 0;
			String fail= "";
			String col_text = "Period";
			List<WebElement> page = driver.findElements(By.xpath("//div[@id='appraisal_view_paginate']/span/a"));
			if (page.size() > 0) {
			for (int i = 1; i <=page.size(); i++) 
			{
				if(i>1)
				{	
				driver.findElement(By.xpath("//div[@id='appraisal_view_paginate']/span/a[" + (i) + "]")).click();
				Waitfor(1);
				}
			WebElement table = driver.findElement(By.xpath("//table[@id='appraisal_view']/thead/tr"));
			List<WebElement> heading = table.findElements(By.tagName("th"));
			for (int h = 0; h < heading.size(); h++) {
				String text = heading.get(h).getText();
				if (col_text.equalsIgnoreCase(text)) {
					int col = h;
					WebElement row_table = driver.findElement(By.xpath("//table[@id='appraisal_view']/tbody"));
					List<WebElement> rows = row_table.findElements(By.tagName("tr"));
					logger.info(rows.size());
					for (int c = 1; c <= rows.size(); c++) {
						
						String cell_Value = driver
								.findElement(By.xpath("//table[@id='appraisal_view']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
								.getText();
						Waitfor(2);
						String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
						
						if (cell_Value.equalsIgnoreCase(period)) {
							
							WebElement report= driver.findElement(By.xpath("//table[@id='appraisal_view']/tbody/tr[" + c + "]/td[1]"));
							action.click(report).build().perform();
							Waitfor(2);
							String  s= driver.findElement(By.xpath("//table[@id='appraisal_view']/tbody/tr[" + c + "]/td[4]")).getText();
							if(s.equalsIgnoreCase(status))
							{
							logger.info("Status is matching with the passed status & Status is "+s);
							action.click(report).build().perform();
							Waitfor(2);
				// Edit button validation
				boolean editbutton= Fill_form.isDisplayed();
				if (editbutton == true) 
				{
			
				logger.info(" Fill button is displayed under employee page and status is :" + editbutton);
				Waitfor(2);						
				}
				else
				{
				logger.info("Fill button is not present in Employee page and status is :" + editbutton);
				}
				logger.info("The Candidate status is "+status);
				count++;
				break;
				}
				else 
				{
				logger.info("Status passed is not matching & the status is : "+s);
				}
				}
				else 
				{
				logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
			   fail = "No Match found";	
				}

				}
			    }
				if(count>0)
				{
			    break;
				}
				}
				if(count>0)
				{
				 break;
				}
				}
				}
				return fail;
				}
		
	/**
	 *validating Appraisal form
	 **/
	
	public void appraiseal_minuae()
	{
		Fill_form.click();
		Waitfor(2);
		String empid="852";
		String id=View_employeeID.getText();
		logger.info("employee id is "+id);
		
		if(empid.equalsIgnoreCase(id))
		{
			logger.info("EMPLOYEE ID IS CORRECT");
			Waitfor(2);
          countinue.click(); 
		}
		else
		{
			logger.info("appraiseal_minuae is not enabled");
		}
		
	}
	
	
/**
 *validating Appraisal form
 **/
	public void New_Appraisals_Form(String Functional_area, String Project_Type )
	{
		
		Waitfor(2);
		Select Dropdown = new Select(Functional_Area_dropdown);
		logger.info("The Entered Functional area is "+Functional_area);
		List<WebElement> length = Dropdown.getOptions();
		int size= length.size();
		logger.info("Total No. of Dropdown values are : "+size);
		String Text=null;
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<size; i++)
		{   
			//length.get(i).click();
		    Text = length.get(i).getText();
		    sb = sb.append(Text).append(",");
		    Waitfor(1);
		}
		logger.info("The Functionalarea are -: "+sb.toString());
		Dropdown.selectByVisibleText(Functional_area);
		
		Select project_type_Dropdown = new Select(Project_Type_dropdown);

		logger.info("The Entered Project type is "+Project_Type);
		
		List<WebElement> list = Dropdown.getOptions();
		int DD_size= list.size();
		logger.info("Total No. of Dropdown values are : "+size);
		String currency=null;
		StringBuffer stringb=new StringBuffer();
		for(int i=0; i<DD_size; i++)
		{   //list.get(i).click();
		    currency = list.get(i).getText();
		    stringb = stringb.append(currency).append(",");
		    Waitfor(1);
		}
		logger.info("The Projects type are -: "+stringb.toString());
		
		project_type_Dropdown.selectByVisibleText(Project_Type);
		
}
	
/**
 *validating Appraisal form
 **/
	public void details_task(String Details_Tasks_Performed,String achievements_past_year)
	{
		boolean status = Details_Task_Performed.isDisplayed();
		if(status==true)
		{
			Details_Task_Performed.sendKeys(Keys.chord(Keys.CONTROL, "a"),Details_Tasks_Performed);
		}
		boolean status2 = Input_achievements_past_year.isDisplayed();
		if(status2==true)
		{
			Input_achievements_past_year.sendKeys(Keys.chord(Keys.CONTROL, "a"),achievements_past_year);
		}
		else
		{
			logger.info("details of task is not displayed");
		}
	}

	
/**
 *entering the skill in Appraisal form
 **/
public void skill_rating_detail(String Competency_Level_dropdown,String  viz_dropdown,String latest_technologies_dropdown,String business_dropdown,String improve_skill,String Documentation_dropdown)
{

	
	Select rating = new Select(Core_Competency_Level);
	logger.info("The Entered Functional area is "+ Competency_Level_dropdown);
	
	List<WebElement> length = rating.getOptions();
	int size= length.size();
	logger.info("The rating of the appraise : "+size);
	String Text=null;
	StringBuffer sb=new StringBuffer();
	for(int i=0; i<size; i++)
	{   
		//length.get(i).click();
	    Text = length.get(i).getText();
	    sb = sb.append(Text).append(",");
	    Waitfor(1);
	}
	
	rating.selectByVisibleText(Competency_Level_dropdown);
	Waitfor(2);
	Select viz_dropdown_skill = new Select(viz_finish_earlier);
	logger.info("selected rating is  " + viz_dropdown);
	Waitfor(2);
	viz_dropdown_skill .selectByVisibleText(viz_dropdown);

	Select latest_technologies_skill = new Select(latest_technologies_trends);
	logger.info("selected rating is  " + latest_technologies_dropdown);
	Waitfor(2);
	latest_technologies_skill .selectByVisibleText(latest_technologies_dropdown);
	
	
	Select business_dropdown_skill = new Select(business_and_goals);
	logger.info("selected rating is  " + business_dropdown);
	Waitfor(2);
	business_dropdown_skill .selectByVisibleText(business_dropdown);
	
	Select Improve_dropdown_skill = new Select(undertaken_improve_them);
	
	logger.info("selected rating is  " + improve_skill);
	Waitfor(2);
	Improve_dropdown_skill .selectByVisibleText(improve_skill);
	  
	Select Documentation_dropdown_skill = new Select(Implementation_Documentation);
	logger.info("selected rating is  " + Documentation_dropdown);
	Waitfor(2);
	Documentation_dropdown_skill.selectByVisibleText(Documentation_dropdown);
	
	
}

public void Behavioral_Attitude_Skills(String Demonstrates_skill,String support_coworkers_skill,String selfimprovement_skill,String area_of_expertise_skill,String  work_in_team__skill,String improve_promote )
{

	Select Demonstrates_dropdown = new Select( Demonstrates_Accountability);
	logger.info("selected rating is  " + Demonstrates_skill);
	Waitfor(2);
	Demonstrates_dropdown .selectByVisibleText(Demonstrates_skill);

	Select support_dropdown = new Select(support_coworkers);
	logger.info("selected rating is  " + support_coworkers_skill);
	Waitfor(2);
	support_dropdown.selectByVisibleText(support_coworkers_skill);

	Select selfimprovement_dropdown = new Select(selfimprovement);
	logger.info("selected rating is  " + selfimprovement_skill);
	Waitfor(2);
	selfimprovement_dropdown .selectByVisibleText(selfimprovement_skill);
	
	Select area_of_expertise_dropdown = new Select(area_of_expertise );
	
	logger.info("selected rating is  " + area_of_expertise_skill);
	Waitfor(2);
	area_of_expertise_dropdown.selectByVisibleText(area_of_expertise_skill);
	  
	Select  work_in_team__drpdown = new Select(work_in_team);
	logger.info("selected rating is  " +  work_in_team__skill);
	Waitfor(2);
	work_in_team__drpdown.selectByVisibleText( work_in_team__skill);
	 
		Select improve_promote_dropdown = new Select(improve_promote_quality);
		logger.info("selected rating is  " +  improve_promote );
		Waitfor(2);
		improve_promote_dropdown.selectByVisibleText( improve_promote);
	}

public void rating_Contribution_Organizational_Goals(String organisations_skill,String  Coordination_skill,String learning_activities_skill, String organisation_rating,String company_morale)
{
	Select organisations_dropdown = new Select( organisations_interests_mind);
	logger.info("selected rating is  " + organisations_skill);
	organisations_dropdown .selectByVisibleText(organisations_skill);
	Waitfor(2);
	Select Coordination_dropdown = new Select( Coordination_with_SPOCS);
	logger.info("selected rating is  " + Coordination_skill);
	Coordination_dropdown .selectByVisibleText(Coordination_skill);
	Waitfor(2);
	Select learning_dropdown = new Select( organizational_learning_activities);
	logger.info("selected rating is  " + learning_activities_skill);
	learning_dropdown .selectByVisibleText(learning_activities_skill);
	Waitfor(2);
	Select organisation_dropdown = new Select( about_the_organisation);
	logger.info("selected rating is  " + organisation_rating);
	Waitfor(2);
	organisation_dropdown .selectByVisibleText(organisation_rating);
	Waitfor(2);
	Select company_dropdown = new Select( company_morale_spirit);
	logger.info("selected rating is  " + company_morale);
	Waitfor(2);
	company_dropdown .selectByVisibleText(company_morale);
		
} 

public void individual_dev_plan_objectpage()
{
	countinue.click();
	Waitfor(1);
	boolean status = individual_dev_plan.isDisplayed();
	if(status==true)
	{
		ScreenshotCapture.GetScreenshot(driver, "appraisal_page");
		
	}
	else
	{
		logger.info("individual dev plan is are not vissible");
	}
	
}

/**
*Entering the steps in Appraisal form
**/
public void list_of_actvities_form(String listof_future_activities,String specific_steps,String  listof_smart_goals,String objectives)
{
	
	enter_future_activities.sendKeys(Keys.chord(Keys.CONTROL, "a"), listof_future_activities);

	Waitfor(2);
	
	enter_smart_goals.sendKeys(Keys.chord(Keys.CONTROL, "a"),listof_smart_goals);
	Waitfor(2);
	enter_performance_objectives.sendKeys(Keys.chord(Keys.CONTROL, "a"),objectives);
	Waitfor(2);
	enter_specific_steps.sendKeys(Keys.chord(Keys.CONTROL, "a"),specific_steps);
	Waitfor(2);
	enter_specific_steps3.sendKeys(Keys.chord(Keys.CONTROL, "a"),specific_steps);
	Waitfor(2);
	enter_specific_steps4.sendKeys(Keys.chord(Keys.CONTROL, "a"),specific_steps);
	Waitfor(2);
	enter_specific_steps5.sendKeys(Keys.chord(Keys.CONTROL, "a"),specific_steps);
	Waitfor(2);
	enter_specific_steps6.sendKeys(Keys.chord(Keys.CONTROL, "a"),specific_steps);
	Waitfor(2);
	enter_specific_steps7.sendKeys(Keys.chord(Keys.CONTROL, "a"),specific_steps);
	Waitfor(2);
	enter_specific_steps8.sendKeys(Keys.chord(Keys.CONTROL, "a"),specific_steps);
	Waitfor(2);
	Save_Button.click();
	Waitfor(2);
	String msg=Save_sucessfully_msg.getText();
	logger.info(msg);
}
public void click_on_backbutton()
{
	GO_Bback_Button.click();
}

/**
*save button Appraisal form
**/
public void click_save_button()
{
	Save_Button.click();
}

/**
* submit button in Appraisal form
**/
public void click_submit_button()
{
	Submit_button.click();
	String msg2=msg_Appraisal_Submitted_Successfully.getText();
	logger.info(msg2);
}
/**
* Status checking button in Appraisal form
**/
public void statuscheck(String report_ID, String Status)
{
	Actions action = new Actions(driver);
	int count = 0;
	String id=null;
	String col_text = "Status";
	List<WebElement> page = driver.findElements(By.xpath("//div[@id='Appraisals_home_paginate']/span/a"));
	if (page.size() > 0) {
	for (int i = 1; i < page.size(); i++) 
	{
	if(i>1)
	{	
	driver.findElement(By.xpath("//div[@id='Appraisals_home_paginate']/span/a[" + (i+1) + "]")).click();
	Waitfor(1);
	}
	WebElement table = driver.findElement(By.xpath("//table[@id='Appraisals_home']/thead/tr"));
	List<WebElement> heading = table.findElements(By.tagName("th"));
	for (int h = 1; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (col_text.equalsIgnoreCase(text)) {
			int col = h;
			WebElement row_table = driver.findElement(By.xpath("//table[@id='Appraisals_home']/tbody"));
			List<WebElement> rows = row_table.findElements(By.tagName("tr"));
			logger.info(rows.size());
			for (int c = 1; c < rows.size(); c++) {
				
				String cell_Value = driver
						.findElement(By.xpath("//table[@id='Appraisals_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]"))
						.getText();
				Waitfor(2);
				String array[] = { "Report Generated", "Approved", "Rejected", "Completed", "Submitted" };
				
				if (cell_Value.equalsIgnoreCase(report_ID)) {
					
					WebElement report= driver.findElement(By.xpath("//table[@id='Appraisals_home']/tbody/tr[" + c + "]/th[1]"));
					action.click(report).build().perform();
					Waitfor(2);
					String  s= driver.findElement(By.xpath("//table[@id='Appraisals_home']/tbody/tr[" + c + "]/th[7]")).getText();
					if(s.equalsIgnoreCase(Status))
					{
					logger.info("Status is matching with the passed status & Status is "+s);
					action.doubleClick(report).build().perform();
					Waitfor(2);
					}
}}}}}}}


public void clickon_continue_button()
{
 
	Waitfor(2);
	countinue1.click();
}
/**
*Rm click on accepting on appraisal  
**/
public void click_on_accept_button()
{

	accept_button.click();
	Waitfor(2);
	Alert a= driver.switchTo().alert();
	a.dismiss();
	Waitfor(2);
	
}
/**
*Rm click on not accepting on appraisal  
**/
public void click_no_button()
{
	no__Button.click();
}

/**
*Rm to approve  button 
**/
public void RM_toapprove_button()
{
	Waitfor(2);	
rm_to_approveButton.click();

}
/**
*Rm submit button 
**/
public void RM_submit_button(String enter_final,String rm_concernes)
{
 enter_final_objectives.sendKeys(enter_final);
enter_rm_concernes.sendKeys(rm_concernes);
Waitfor(2);
	click_rm_submit.click();
}

public  void Scroll_down()
{
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("scroll(0,600)");
}

/**
*Rmg to handle button
**/
public void RMG_tohandle_button()
{
	Rmg_to_handle.click();
}
/**
*Rmg validating appraisal form
**/
public void RMG_action_appraisal_form()
{
		
boolean status = Rmg_to_action.isDisplayed();
if (status == true) 
{
	Rmg_to_action.click();
	}
else
{
	logger.info("action_Button is not displayed");
}
}
/**
*Rmg to approve button
**/
public void RMG_approve_button()
{
	Rmg_to_approve.click();
	
}
/**
*Rmg validating the send mail page
**/
public void RMG_sendmail_appraisal_form(String Effected_from,String reviced_ctc,int row)
{
	
boolean status = Rmg_send_mail.isDisplayed();
if (status == true) 
{
	Rmg_send_mail.click();
	logger.info("SEND MAIL BUTTON IS DISPLAYED");
	}
else
{
	logger.info("RMG_sendmail is not displayed");
}

String name =excelreaddata().getData("Appraisal_sheet", row, 10);
softassert().assertEquals(name, name_of_employee.getText());
logger.info(name);
String Designation=excelreaddata().getData("Appraisal_sheet", row, 11);
softassert().assertEquals(name, employee_designation.getText());
logger.info(Designation);
String  Subject =excelreaddata().getData("Appraisal_sheet", row, 12);
softassert().assertEquals(name, subject_of_email.getText());
logger.info(Subject);
Revised_ctc_per_annum.clear();
Revised_ctc_per_annum.sendKeys(reviced_ctc);
logger.info(reviced_ctc);

Appraisal_date_Effect_from.click();
List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

int total_nodes = dates.size();
logger.info("Calendar Date size is : " + total_nodes);
for (int i = 0; i < total_nodes; i++) {
	String date = dates.get(i).getText();
	if (date.equals((Effected_from))) {
		dates.get(i).click();
		logger.info("Selected date is: " + date);
		break;
	}
}
}/**
*Rmg send mail to employee 
**/
		public void send_mail_toemployee()
		{
			send_mail_employee.click();
		}
	
		/**
		*Rm rejecected employee appraisal form
		**/
		public void click_reject_button()
		{
			
			reject_Button.click();
			Waitfor(2);
			REJECT_COMMENTS.sendKeys(Keys.chord(Keys.CONTROL, "a"),"comments");
			Waitfor(2);
			RM_REJECT_BUTTON.click();
			
			
			
		}
		/**
		*Rmg rejecected employee appraisal form
		**/
public void rmg_reject()
{
	RMG_REJECT.click();
	Waitfor(2);
	REJECT_COMMENTS.sendKeys(Keys.chord(Keys.CONTROL, "a"),"comments");
	Waitfor(2);
	RMG_REJECT_BUTTON.click();
	
	
}/**
*Rmg rejecected status  employee appraisal form and view page
**/
public void RMG_REJECTED_TO_RM()
{
	boolean status = REJECTED_BY_RMG.isDisplayed();
	if(status==true)
	{
		Actions a=new Actions(driver);
		a.doubleClick(REJECTED_BY_RMG).perform();		
	}
	else
	{
		logger.info("not rejected by rmg");
	}
	
}
/**
*Rm rejecected  status employee appraisal form and view page
**/
public void RM_REJECTED_TO_employee()
{
	boolean status = Rejected_By_Appraiser.isDisplayed();
	if(status==true)
	{
		Actions a=new Actions(driver);
		a.doubleClick(Rejected_By_Appraiser).perform();	 	
	}
	else
	{
		logger.info("not rejected by rmg");
	}
	

}
/**
*Validating the status under RM
**/
public String myappraisal_form_RM(String period, String status)
{
	
	Search_Input_Box_Appraisals_rm.sendKeys(Keys.chord(Keys.CONTROL, "a"),period);
		Waitfor(1);
	
		Actions action = new Actions(driver);
		int count = 0;
		String fail= "";
		String col_text = "Period";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='appraisal_toApprove_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='appraisal_toApprove_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='appraisal_toApprove']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='appraisal_toApprove']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='appraisal_toApprove']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(2);
					String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
					
					if (cell_Value.equalsIgnoreCase(period)) {
						
						WebElement report= driver.findElement(By.xpath("//table[@id='appraisal_toApprove']/tbody/tr[" + c + "]/td[1]"));
						action.click(report).build().perform();
						Waitfor(2);
						String  s= driver.findElement(By.xpath("//table[@id='appraisal_toApprove']/tbody/tr[" + c + "]/td[4]")).getText();
						if(s.equalsIgnoreCase(status))
						{
						logger.info("Status is matching with the passed status & Status is "+s);
						action.doubleClick(report).build().perform();
						Waitfor(2);
			// Edit button validation
			boolean countinue= countinue_rm.isDisplayed();
			if (countinue == true) 
			{
		
			logger.info(" countinue button is displayed under RM page and status is :" );
			Waitfor(2);						
			}
			else
			{
			logger.info("countinue button is not present in candidate page and status is :" );
			}
			logger.info("The Candidate status is "+status);
			count++;
			break;
			}
			else 
			{
			logger.info("Status passed is not matching & the status is : "+s);
			}
			}
			else 
			{
			logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
		   fail = "No Match found";	
			}

			}
		    }
			if(count>0)
			{
		    break;
			}
			}
			if(count>0)
			{
			 break;
			}
			}
			}
			return fail;
			}
/**
* Rm accepting the employee appraisal form
**/
public void RM_accepting()
{
	countinue_rm.click();
	Waitfor(2);		
	countinue2.click();
	
}
/**
*Countinue button under rm
**/
public void RM_continue()
{
	countinue_rm.click();
	Waitfor(2);
	
	
}
/**
* VALIDATING THE  TO HANDLE PAGE AND STATUS 
**/
public String myappraisal_form_RMG(String period, String status)
{
//	Waitfor(2);	
//	Select period_dropdown = new Select(select_period_dropdown);
//	logger.info("selected rating is  " + period_dropdown);
//	period_dropdown.selectByVisibleText("2018_January");
	Waitfor(2);	
	driver.findElement(By.xpath("//input[@aria-controls='appraisal_toHandle']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),period);
		Waitfor(1);
	
		Actions action = new Actions(driver);
		int count = 0;
		String fail= "";
		String col_text = "Period";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='appraisal_toHandle_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='appraisal_toHandle_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='appraisal_toHandle']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='appraisal_toHandle']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='appraisal_toHandle']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(2);
					String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
					
					if (cell_Value.equalsIgnoreCase(period)) {
						
						WebElement report= driver.findElement(By.xpath("//table[@id='appraisal_toHandle']/tbody/tr[" + c + "]/td[1]"));
						action.click(report).build().perform();
						Waitfor(2);
						String  s= driver.findElement(By.xpath("//table[@id='appraisal_toHandle']/tbody/tr[" + c + "]/td[4]")).getText();
						if(s.equalsIgnoreCase(status))
						{
						logger.info("Status is matching with the passed status & Status is "+s);
						//action.doubleClick(report).build().perform();
						Waitfor(2);
			// Edit button validation
			boolean countinue= Rmg_to_action.isDisplayed();
			if (countinue == true) 
			{
		
			logger.info(" ACTION  button is displayed under RMG page and status is :" );
			Waitfor(2);						
			}
			else
			{
			logger.info("action button is not present in RMG page and status is :" );
			}
			logger.info("The Candidate status is "+status);
			count++;
			break;
			}
			else 
			{
			logger.info("Status passed is not matching & the status is : "+s);
			}
			}
			else 
			{
			logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
		   fail = "No Match found";	
			}

			}
		    }
			if(count>0)
			{
		    break;
			}
			}
			if(count>0)
			{
			 break;
			}
			}
			}
			return fail;
			}
/**
* VALIDATING THE SEND MAIL BUTTON  ENABLING
**/
public String Mail_form_RMG(String period, String status)
{
//	Waitfor(2);	
//	Select period_dropdown = new Select(select_period_dropdown);
//	logger.info("selected rating is  " + period_dropdown);
//	period_dropdown.selectByVisibleText("2018_January");
	Waitfor(2);	
	driver.findElement(By.xpath("//input[@aria-controls='appraisal_toHandle']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),period);
		Waitfor(1);
	
		Actions action = new Actions(driver);
		int count = 0;
		String fail= "";
		String col_text = "Period";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='appraisal_toHandle_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='appraisal_toHandle_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='appraisal_toHandle']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='appraisal_toHandle']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='appraisal_toHandle']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(2);
					String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
					
					if (cell_Value.equalsIgnoreCase(period)) {
						
						WebElement report= driver.findElement(By.xpath("//table[@id='appraisal_toHandle']/tbody/tr[" + c + "]/td[1]"));
						action.click(report).build().perform();
						Waitfor(2);
						String  s= driver.findElement(By.xpath("//table[@id='appraisal_toHandle']/tbody/tr[" + c + "]/td[4]")).getText();
						if(s.equalsIgnoreCase(status))
						{
						logger.info("Status is matching with the passed status & Status is "+s);
						//action.doubleClick(report).build().perform();
						Waitfor(2);
			// Edit button validation
			boolean countinue= Rmg_send_mail.isDisplayed();
			if (countinue == true) 
			{
		
			logger.info(" send mail button is displayed under employee page and status is :" );
			Waitfor(2);						
			}
			else
			{
			logger.info(" send mail button is not present in candidate page and status is :" );
			}
			logger.info("The Candidate status is "+status);
			count++;
			break;
			}
			else 
			{
			logger.info("Status passed is not matching & the status is : "+s);
			}
			}
			else 
			{
			logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
		   fail = "No Match found";	
			}

			}
		    }
			if(count>0)
			{
		    break;
			}
			}
			if(count>0)
			{
			 break;
			}
			}
			}
			return fail;
			}
/**
* EMPLOYEE LOGIN 
**/
public void Employee_login()
{
String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //Reading Username from excel
Waitfor(1);
String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //Reading Password from excel
Waitfor(2);
ObjectInitClass.LP.signIn(username, password);
Waitfor(3);
My_Lynx();
Waitfor(2);
Appraisals();
Waitfor(2);

}
/**
* RM LOGIN 
**/
public void RM_login()
{
	String username= excelreaddata().getData("Login_Credentials", 1, 0 ); //Reading Username from excel
	Waitfor(1);
	String password= excelreaddata().getData("Login_Credentials", 1, 1 ); //Reading Password from excel
	Waitfor(1);
	ObjectInitClass.LP.signIn(username, password);
	Waitfor(3);
	My_Lynx();
	Waitfor(2);
	Appraisals();
	Waitfor(2);
}
/**
* RMG LOGIN 
**/
public void RMG_login()
{
	String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
	Waitfor(2);
	String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
	Waitfor(2);
	ObjectInitClass.LP.signIn(username, password);
	Waitfor(3);
	My_Lynx();
	Waitfor(2);
	Appraisals();
	Waitfor(2);

}
}







