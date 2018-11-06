package com.dikshatech.tst.objectrepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;


public class Rollonpageobjects extends TestBase {
	
    
    String previousproject="";
    boolean bTrue=true;
    boolean bFalse=false;

  
    @Test
	public Rollonpageobjects(WebDriver driver){
		this.driver = driver;
	}
    
	//Roll-On Landing page elements repository.
    @FindBy(xpath="//*[@id='rmg-menu']/a") 						WebElement rmgModule;
	@FindBy(xpath="//*[@id='rollon-menu']") 					WebElement rollonSubmodule;
	@FindBy(xpath="//section[@id='tabs']/h3") 					WebElement rollonBackground;
	@FindBy(xpath="//*[@id='my_Roll_on']") 						WebElement rollonicon;
	@FindBy(xpath="//*[@id='rollOn_MyResourcesAnch']") 			WebElement rollonMyResourceTab;
	@FindBy(xpath="//*[@id='rollOn_MyProjects']") 				WebElement rollonMyprojectsTab;
	@FindBy(xpath="//*[@id='rollOn_Bench']") 					WebElement rollonBenchTab;
	@FindBy(xpath="//button[@id='rollon']") 					WebElement rollonNewButton;
	@FindBy(xpath="//*[@id='edit_roll']") 						WebElement rollonEditButton;
	@FindBy(xpath="//*[@id='add_roll']") 						WebElement rollonUpdate;
	@FindBy(xpath="//select[@name='roll_on_view_length']") 		WebElement entriesCountDropdownRollon;
	@FindBy(xpath="//*[@id='roll_on_view_filter']/label/input") WebElement searchInputBoxRollon;
	@FindBy(xpath="//*[@id='roll_on_view']/tbody/tr[1]") 		WebElement selectrollonMyResource;
	@FindBy(xpath="//*[@id='roll_on_myProject_view']/tbody/tr[1]") WebElement selectRollonMyPro;
	@FindBy(xpath="//*[@id='roll_on_myResources_view']/tbody/tr[1]") WebElement selectrollonBench;
	@FindBy(xpath="//*[@id='submitRollOn']") 					WebElement rollonButton;
	
			
	//View Roll-On form
	@FindBy(xpath="//span[@id='rollOn_empName']") 				WebElement viewRollonEmployeeName;
	@FindBy(xpath="//span[@id='new_rollOn_empId']") 			WebElement viewRollonEmployeeID;
	@FindBy(xpath="//span[@id='new_rollOn_empName']") 			WebElement viewRollonEmpName;
	@FindBy(xpath="//span[@id='new_rollOn_empDept']") 			WebElement viewRollonDepartment;
	@FindBy(xpath="//span[@id='new_rollOn_des']") 				WebElement viewRollonDesignation;
	
	
	// View Rollon Projects Details Tab
	@FindBy(xpath="//a[@href='#home']") 						WebElement rollonProjectDetailsTab;
	@FindBy(xpath="//select[@id='new_rollOn_project']") 		WebElement rollonProjDetailsProject;
	@FindBy(xpath="//span[@id='new_rollOn_projectId']")			WebElement rollonProjDetailsProjID;
	@FindBy(xpath="//span[@id='new_rollOn_region']") 			WebElement rollonProjDetailsRegion;
	@FindBy(xpath="//span[@id='new_rollOn_assClient']")			WebElement rollonProjDetailsClient;
	@FindBy(xpath="//select[@id='new_rollOn_chargeCode']")      WebElement rollonProjDetailsChargeCode;
	@FindBy(xpath="//select[@id='new_rollOn_projType']")        WebElement rollonProjDetailsProjectCatgry;
	@FindBy(xpath="//textarea[@id='new_rollOn_project_comments']") WebElement rollonProjDetailsComments;
	@FindBy(xpath="//*[@id='new_rollOn_department']")           WebElement rollonProjDetailsProjectDept;
	@FindBy(xpath="//*[@id='new_rollOn_level']") 				WebElement rollonProjectLevel;
	
	//view Project Location tab
	@FindBy(xpath="//a[@id='added']") 							WebElement viewRollonProjectLocationTab;
	@FindBy(xpath="//*[@id='new_rollOn_projLoc']") 				WebElement viewRollonProjLocationProjlocation;
	@FindBy(xpath="//span[@id='new_rollOn_off_country']")		WebElement viewRollonProjLocationCountry;
	@FindBy(xpath="//span[@id='new_rollOn_off_state']") 		WebElement viewRollonProjLocationState;
	@FindBy(xpath="//span[@id='new_rollOn_off_city']") 			WebElement viewRollonProjLocationCity;
	@FindBy(xpath="//span[@id='new_rollOn_off_zip']") 			WebElement viewRollonProjLocationZipCOde;
	@FindBy(xpath="//span[@id='new_rollOn_off_tel']") 			WebElement viewRollonProjLocationTelephone;
	@FindBy(xpath="//span[@id='new_rollOn_off_fax']") 			WebElement viewRollonProjLocationFaxno;
	@FindBy(xpath="//*[@id='new_rollOn_off_address']") 			WebElement viewRollonProjLocationAddress;

	// view Contcat Information 
	@FindBy(xpath="//a[@id='modified']") 						WebElement viewRollonContactInfoTab;
	@FindBy(xpath="//input[@id='new_rollOn_cont_name']") 		WebElement viewRollonContactInfoName;
	@FindBy(xpath="//textarea[@id='new_rollOn_cont_details']")  WebElement viewRollonContactInfoDetails;
	@FindBy(xpath="//input[@id='new_rollOn_cont_email']") 		WebElement viewRollonContactInfoEmailID;
	@FindBy(xpath="//input[@id='new_rollOn_cont_phoneNo']")		WebElement viewRollonContactInfoPhoneno;
	@FindBy(xpath="//input[@id='new_contInfo_onSite_name']")   	WebElement viewRollonContactInfoManagerName;
	@FindBy(xpath="//textarea[@id='new_contInfo_onSite_details']") WebElement viewRollonContactInfoManagerDetails;
	
	// view other Contact Information
	@FindBy(xpath="//*[@id='holded']") 							WebElement viewRollonOtherInfoTab;
	@FindBy(xpath="//*[@id='datetimepicker_roll_other']") 		WebElement viewRollonOtherInfoStartDate;
	@FindBy(xpath="//input[@id='datetimepicker_roll_otherEnd']")WebElement viewRollonOtherInfoEndDate;
	@FindBy(xpath="//input[@id='datetimepicker_roll_dor']") 	WebElement viewRollonOtherInfoReportingDate;	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div/div/select[2]") WebElement yearDropdown;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div/div/select[1]") WebElement monthDropDown;
	@FindBy(xpath="//input[@id='new_rollOn_otherInfo_repoTime']") WebElement viewRollonOtherInfoReportingTime;
	@FindBy(xpath="//input[@id='new_rollOn_otherInfo_perDiem']") WebElement viewRollonOtherInfoPerdiem;
	@FindBy(xpath="//select[@id='new_rollOn_otherInfo_currency']") WebElement viewRollonOtherInfoCurrType;
	@FindBy(xpath="//input[@id='new_rollOn_otherInfo_travelReq']") WebElement viewRollonOtherInfoTravelReq;
	@FindBy(xpath="//input[@id='new_rollOn_otherInfo_notifiers']") WebElement viewRollonOtherInfoNotifiersNames;
	
	@FindBy(xpath="//*[@id='deleted']") 						WebElement viewRollonCurrentStatusTab;
	@FindBy(xpath="//span[@id='new_rollOn_currPro']")           WebElement viewRollonCurrentStatusName;
	@FindBy(xpath="//span[@id='new_rollOn_currProLoc']") 		WebElement viewRollonCurrentStatusLocation;
	@FindBy(xpath="//*[@id='roll_on_view']/tbody/tr[1]/td[9]") 	WebElement validateProjectName;

	
	// Bench Report Related Locators
	// Agile Bench Related Locators
	@FindBy(xpath="//*[@id='benchReports-link']/a") 					WebElement bechReportModule;
	@FindBy(xpath="//*[@id='benchRepBench']")		 					WebElement benchTaball;
	@FindBy(xpath="//*[@id='benchRepSoftlock']")		 				WebElement softLockTaball;
	@FindBy(xpath="//*[@id='anchorGlobalBench']") 						WebElement globalBench;
	@FindBy(xpath="//*[@id='anchorOverAll']")							WebElement allReportTab;
	@FindBy(xpath="//*[@id='sd_internalDownload']")						WebElement internalReport;
	@FindBy(xpath="//*[@id='genericModal-title']")						WebElement validatedownloadpopup;
	@FindBy(xpath="//input[@name='checkboxBR1']") 						WebElement selectAllCheckBox;
	@FindBy(xpath="//*[@id='secondEle']/td/div[2]/input") 				WebElement agileBenchReport;
	@FindBy(xpath="//*[@id='selectAgilelabsSoftlockReport']") 			WebElement agileSoftLockReport;
	@FindBy(xpath="//*[@id='tbodyForDownLoadReport']/tr[3]/td/div[2]/input") WebElement globalbenchReport;
	@FindBy(xpath="//*[@id='downloadSDBenchReports']")					WebElement downloadButton;
	@FindBy(xpath="//*[@id='main_Content']/div/div[2]/div[2]/div/div/span/button") 	WebElement reports;
	@FindBy(xpath="//a[text()='Weekly']")								WebElement weeklyReport;
	@FindBy(xpath="//a[text()='Monthly']")								WebElement monthlyReport;
	@FindBy(xpath="//*[@id='AgileLabs_view_filter']/label/input") 	    WebElement searchFieldBench;
	@FindBy(xpath="//*[@id='softlock_report_view_filter']/label/input")	WebElement searchFieldSoftLock;
	@FindBy(xpath="//*[@id='GlobalBench_view_filter']/label/input") 	WebElement searchFieldglobalBench;
	@FindBy(xpath="//*[@id='OverAll_view_filter']/label/input") 	    WebElement searchFieldoverall;
	@FindBy(xpath="//*[@id='bench_report_view']/tbody/tr[1]/td[1]") 	WebElement empNameBench;
	@FindBy(xpath="//*[@id='softlock_report_view']/tbody/tr[1]/td[1]") 	WebElement empNameSoftLock;
	@FindBy(xpath="//*[@id='GlobalBenchReportHeaders_view']/tbody/tr/td[1]")WebElement empNameGlobalBench;
	@FindBy(xpath="//*[@id='weeklyDatePicker']")						WebElement weeklyStartDate;
	@FindBy(xpath="//*[@id='weeklyDateEndPicker']")						WebElement weeklyEndDate;
	@FindBy(xpath="//*[@id='Monthly_report_totalbenchcost_div']/div/label")	WebElement benchCostmonthly;
	@FindBy(xpath=" //*[@id='Weekly_report_totalbenchcost_div']/div/label")	WebElement benchCostweekly;
	@FindBy(xpath="//*[@id='genericModal-buttons']/button")				WebElement closeButton;
	@FindBy(xpath="//*[@id='monthlyDatePicker']")						WebElement monthlyStartDate;
	@FindBy(xpath="//*[@id='monthlyDateEndPicker']")					WebElement monthlyEndDate;
	
	
	
	
	//Consulting Related Locators
	@FindBy(xpath="//*[@id='Consulting_view_filter']/label/input")		WebElement searchFieldconBench;
	@FindBy(xpath="//*[@id='benchRepBench']")		 					WebElement consultingBenchTab;
	@FindBy(xpath="//*[@id='benchRepSoftlock']")		 				WebElement consultingSoftLockTab;
	@FindBy(xpath="//*[@id='roll_on_view']/tbody/tr[1]/td[9]") 			WebElement employeeNameConsultingLab;
	@FindBy(xpath="//*[@id='roll_on_view']/tbody/tr[1]/td[9]") 			WebElement employeeNameConsultingSoftLock;
	
	// SD Related Locators
	@FindBy(xpath="//*[@id='ServiceDelivery_view_filter']/label/input")	WebElement searchFieldSd;
	@FindBy(xpath="//*[@id='roll_on_view']/tbody/tr[1]/td[9]") 			WebElement employeeNamesdSoftLock;
	
	
	// Manager, CEO Levels
	@FindBy(xpath="//*[@id='anchorConsulting']")		 			   	WebElement consultingTab;
	@FindBy(xpath="//*[@id='anchorAgileLabs']")		 					WebElement agileLabsTab;
	@FindBy(xpath="//*[@id='anchorServiceDelivery']") 					WebElement serviceDeliveryTab;
	@FindBy(xpath="//*[@id='roll_on_view']/tbody/tr[1]/td[9]") 			WebElement globalBenchtab;
	@FindBy(xpath="//*[@id='Consulting_view_filter']/label/input")		WebElement consultingBenchSearch ;
	@FindBy(xpath="//*[@id='AgileLabs_view_filter']/label/input")		WebElement agileTabSearchField;
	@FindBy(xpath="//*[@id='allReport']")		 						WebElement overAllTab;
	@FindBy(xpath="//*[@id='all_report_view_filter']/label/input")		WebElement overallSearchField;
	@FindBy(xpath="//*[@id='ServiceDelivery_view_filter']/label/input") WebElement sdserchField;

	
	

	
	//Rollon Module Tab 
	public void rollonModule(){
		Waitfor(2);
		rmgModule.click();
		Waitfor(2);
		rollonSubmodule.click();
		Waitfor(6);
	}
	
	// Search field for My Resource tab
	public void searchBox(String empID){
		Waitfor(4);
		searchInputBoxRollon.sendKeys(Keys.chord(Keys.CONTROL, "a"),empID);
		Waitfor(2);
	}
	
	//Tr Click
	public void selectEmp(){
		Waitfor(2);
	    previousproject=validateProjectName.getText();
		Waitfor(1);
		selectrollonMyResource.click();
		Waitfor(2);
	}
	
	public String previousProject(){
		return previousproject;
	}
	
	public void rollonFunction(){
		Waitfor(2);
		boolean bln=rollonNewButton.isEnabled();
		if (bln==bTrue) 
		{
			try {
				
				Waitfor(2);
				rollonNewButton.click();
				Waitfor(3);
				 logger.info("The Add-Rollon Button is enabled and Clicked succeefully..!!");
				boolean namests=viewRollonEmployeeName.isDisplayed(); 
				if (namests==bTrue) 
				{
				  String empName=viewRollonEmployeeName.getText();
				   logger.info("The Rollon Employee Name is : "+empName);
                  boolean empid=viewRollonEmployeeID.isDisplayed();
				  if (empid==bTrue) 
				  {
					Waitfor(1);
					String empID=viewRollonEmployeeID.getText();
					 logger.info("The Rollon Employee ID is :"+empID);
				  } else {
                     logger.info("The employee id is not displayed.!!!");
				  }
                  
				} else {
				   logger.info("The employee Name is not displayed..!!");
				}
			 
			} catch (Exception e) {
				logger.info("The employee Name is not displayed..!!"+e);
			}
			
		} else 
		
		{
		      logger.info("The Add-Rollon Button is Diasabled..!!!");	
		}
		Waitfor(2);
	}
	
	// Roll on View page Other info Tab Details
	public void projectDetailsTab(String selectProject, String selectDept, String selectCategory, String selectLevel, String rollonComments){
		try {
			
			Waitfor(2);
			Select osel=new Select(rollonProjDetailsProject);
			osel.selectByVisibleText(selectProject);
	        Waitfor(2);
	         logger.info("The Employee Roll On To Project is :"+selectProject);
	        
	        boolean proID=rollonProjDetailsProjID.isDisplayed();
	        if (proID==bTrue) {
				String projectId=rollonProjDetailsProjID.getText();
				 logger.info("The Project ID is : "+projectId);
			
			boolean region=rollonProjDetailsRegion.isDisplayed();
			if (region==bTrue) {
				
				String regionis=rollonProjDetailsRegion.getText();
				 logger.info("The Region is : "+regionis);
				Waitfor(2);
				Select sel=new Select(rollonProjDetailsProjectDept);
				sel.selectByVisibleText(selectDept);
				 logger.info("The Roll On Emplyoee to the Department is :"+selectDept);
				Waitfor(2);
				Select selCatgary=new Select(rollonProjDetailsProjectCatgry);
				selCatgary.selectByVisibleText(selectCategory);
				 logger.info("The Employee Category is :"+selectCategory);
				Waitfor(2);
				Select selLevel=new Select(rollonProjectLevel);
				selLevel.selectByVisibleText(selectLevel);
				 logger.info("The Employee Level is :"+selectLevel);
				Waitfor(2);
				rollonProjDetailsComments.sendKeys(rollonComments);
				Waitfor(2);
			} else {
                 logger.info("The Region is Not displayed..!!");
			}
				
			} else {
                  logger.info("The Project id is Not displayed.!!"); 
			}
	        
		} catch (Exception e) {
			 logger.info("Failed in the stages of project Details Tab Info In View Rollon..!!");
		}
		
	}

// Roll on View page Project Location info Tan Details
public void projectLocationTab(String selectProjectLoction){
	try {
		
		Waitfor(2);
		viewRollonProjectLocationTab.click();
		Waitfor(2);
		Select oselect=new Select(viewRollonProjLocationProjlocation);
		oselect.selectByVisibleText(selectProjectLoction);
		Waitfor(2);
		String projectaddres=viewRollonProjLocationAddress.getText();   
		 logger.info("The Rollon Employee Project Location Address is :"+projectaddres);
		Waitfor(1);
		String projectLocCity=viewRollonProjLocationCity.getText();
		 logger.info("The Rollon Employee Project Location City is :"+projectLocCity);
		Waitfor(1);
		String projectLocState=viewRollonProjLocationState.getText();
		 logger.info("The Rollon Employee Project Location State is :"+projectLocState);
		Waitfor(1);
		String proCountry=viewRollonProjLocationCountry.getText(); 
		 logger.info("The Rollon Employee Project Location Country is :"+proCountry);
		Waitfor(2);
		
	} catch (Exception e) {
		 logger.info("Failed in the stages of Project Loction tab in View Rollon ");
	}
		
	}
	
	
// Roll on View page Contact  info Tan Details
 public void contactInfoTab(String rmName, String details, String rmemailID, String rmPhNum ){
	try{
			Waitfor(1);
			viewRollonContactInfoTab.click();
			Waitfor(2);
			viewRollonContactInfoName.sendKeys(rmName);
			Waitfor(2);
			 logger.info("The Reporting Manager Name is : "+rmName);
			Waitfor(1);
			viewRollonContactInfoDetails.sendKeys(details);
			Waitfor(2);
			viewRollonContactInfoEmailID.sendKeys(rmemailID);
			Waitfor(2);
			viewRollonContactInfoPhoneno.sendKeys(rmPhNum);
			Waitfor(2);
			viewRollonContactInfoManagerName.sendKeys("Reporting Manager");
			Waitfor(2);
			viewRollonContactInfoManagerDetails.sendKeys("Roll-On To Projects..!!!!!");
			Waitfor(1);	
			
	  } catch (Exception e) {
		
		 logger.info("Failed in the stages of Contact Info tab in View Rollon ");
	}
}
	
// Roll on View page Other info Tan Details
	
 public void otherInfoTab(String selectStartDate, String selectstartMonth, String selectStartYear, String selectendYear, String selectEndMonth, String selectendDate, String selectreportdate, String selectReportMonth, String selectreportYear, String reportingTime, String perdiemAmount, String notisfermailname){
	 try{
			Waitfor(2);
			viewRollonOtherInfoTab.click();
			Waitfor(1);
			//Start Date for Project
			viewRollonOtherInfoStartDate.click();
			Waitfor(2);
			Select osel=new Select(yearDropdown);
			osel.selectByValue(selectStartYear);
			Waitfor(2);
			Select oselect=new Select(monthDropDown);
			oselect.selectByVisibleText(selectstartMonth);
			Waitfor(2);
			List<WebElement> dates1 = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td"));
			int totalnodes1 = dates1.size();
			for (int i = 0; i < totalnodes1; i++){
			String date1 = dates1.get(i).getText();
			int abc=Integer.parseInt(selectStartDate);
			
			if (date1.equals(Integer.toString(abc))){
			dates1.get(i).click();
			 logger.info("Selected Start date month and Year For Rollon is: "+ selectStartDate+":"+selectstartMonth+":"+selectStartYear);
			break;
		     }
			}
			
			// End Date For Project.
			viewRollonOtherInfoEndDate.click();
			Waitfor(2);
			Select osel1=new Select(yearDropdown);
			osel1.selectByValue(selectendYear);
			Waitfor(2);
			Select oselect1=new Select(monthDropDown);
			oselect1.selectByVisibleText(selectEndMonth);
			Waitfor(2);
			List<WebElement> dates11 = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td"));
			int totalnodes11 = dates11.size();
			for (int i = 0; i < totalnodes11; i++){
			String date11 = dates11.get(i).getText();
			int abcd=Integer.parseInt(selectendDate);
			if (date11.equals(Integer.toString(abcd))){
			dates11.get(i).click();
			 logger.info("Selected End date month and Year For Rollon is: "+ selectendDate+":"+selectEndMonth+":"+selectendYear);
			break;
			   }
			}
			
			// Date of Reporting 
			Waitfor(2);
			viewRollonOtherInfoReportingDate.click();
			Waitfor(2);
			Waitfor(2);
			Select osel12=new Select(yearDropdown);
			osel12.selectByValue(selectreportYear);
			Waitfor(2);
			Select oselect12=new Select(monthDropDown);
			oselect12.selectByVisibleText(selectReportMonth);
			Waitfor(2);
			List<WebElement> dates12 = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td"));
			int totalnodes112 = dates12.size();
			for (int i = 0; i < totalnodes112; i++){
			String date12 = dates12.get(i).getText();
			int abcde=Integer.parseInt(selectreportdate);
			
			if (date12.equals(Integer.toString(abcde))){
			dates12.get(i).click();
			 logger.info("Selected Reporting date month and Year For Rollon is: "+ selectreportdate+":"+selectReportMonth+":"+selectreportYear);
			break;
			  }
			}
			
			Waitfor(2);
			viewRollonOtherInfoReportingTime.sendKeys(reportingTime);
			Waitfor(2);
			viewRollonOtherInfoPerdiem.sendKeys(perdiemAmount);   
			Waitfor(2);
			viewRollonOtherInfoNotifiersNames.sendKeys(notisfermailname);
			Waitfor(2);
				
		} catch (Exception e) {
			 logger.info("Failed in the stages of Other Info tab in View Rollon ");
		}
	}
	
  public void currentInfoTab(){
		Waitfor(2);
		viewRollonCurrentStatusTab.click();
		Waitfor(2);
	}
	
  public void clickRollOn(){
		Waitfor(2);
		rollonButton.click();
		Waitfor(5);
		 logger.info("The Roll on for Employee is Successfully...!!!!");
		Waitfor(2);
	}
	
 public void validateRollOn(String selectProjectName){
	
		boolean status=validateProjectName.isDisplayed();
		if (status==bTrue) 
		{
			String project=validateProjectName.getText();
			
			if (project.equalsIgnoreCase(selectProjectName)) 
			{
				 logger.info("Before RollOn The Employee Previous Propject is :"+previousproject);
				Waitfor(2);
				 logger.info("The Employee is Rollon to :"+selectProjectName+" Project successfully");
				
			} else {

				 logger.info("The Project name is not displayed in the RollOn Data Table..!!");
			}
		   
		} else {
			 logger.info("The Project name is not displayed in the RollOn Data Table..!!");
		}
				
	}
	
	

	// Bench Report Module...!!!
	
	// Bench Report For Agile Lab
 public void benchReportModule(){
		Waitfor(2);
		bechReportModule.click();
		Waitfor(2);
	}

public void benchTaball(){
		Waitfor(2);
		benchTaball.click();
		Waitfor(2);
	}
	
public void globalBenchTabAll(){
		Waitfor(1);
		globalBench.click();
		Waitfor(2);
	}

public String serchFieldBench(String empname){
	Waitfor(2);
	searchFieldBench.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
	Waitfor(1);
	String fail="";
	Actions action = new Actions(driver);
	int count = 0;
	String coltext ="Name";
	List<WebElement> page = driver.findElements(By.xpath("//*[@id='AgileLabs_view_paginate']/span/a"));
	if (page.size()> 0) {
	for (int i = 1; i <=page.size(); i++) 
	{
		if(i>=1)
		{	
		driver.findElement(By.xpath("//div[@id='AgileLabs_view_paginate']/span/a[" + (i) + "]")).click();
		Waitfor(1);
		}
	 WebElement table = driver.findElement(By.xpath("//table[@id='AgileLabs_view']/thead/tr"));
	 List<WebElement> heading = table.findElements(By.tagName("th"));
	 for (int h = 0; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (coltext.equalsIgnoreCase(text)) {
			int col = h;
			WebElement rowtable = driver.findElement(By.xpath("//table[@id='AgileLabs_view']/tbody"));
			List<WebElement> rows = rowtable.findElements(By.tagName("tr"));

			for(int c = 1; c <= rows.size(); c++) {
				
				String cellValue = driver
						.findElement(By.xpath("//table[@id='AgileLabs_view']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
						.getText();
				Waitfor(1);
				
				if (cellValue.equalsIgnoreCase(empname)) {
					
					WebElement employee= driver.findElement(By.xpath("//table[@id='AgileLabs_view']/tbody/tr[" + c + "]/td[2]"));
					action.click(employee).build().perform();
					 logger.info(empname+": record found in Agile Labs Bench Tab in Bench Report Module..!!" );
				    WebElement projectName=driver.findElement(By.xpath("//*[@id='AgileLabs_view']/tbody/tr[1]/td[10]"));
				    String proName=projectName.getText();
					 logger.info(empname+": The Employee is Rollon to the Project of "+proName);
					
					
					String rollonDate=driver.findElement(By.xpath("//*[@id='AgileLabs_view']/tbody/tr[1]/td[8]")).getText();
					String[] parts = rollonDate.split("-");
				    String year = parts[0]; 
				    String month = parts[1]; 
				    String date=parts[2];
					String previousDate=date+"-"+month+"-"+year;
					logger.info("The Employee RollOn Date is :"+previousDate);
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date datea = new Date();
					String curentDates=dateFormat.format(datea);
					 logger.info("The Current Date Month Year is :"+curentDates);
					LocalDate d1 = LocalDate.parse(previousDate, DateTimeFormatter.ISO_LOCAL_DATE);
					LocalDate d2 = LocalDate.parse(curentDates, DateTimeFormatter.ISO_LOCAL_DATE);
					Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
					long diffDays = diff.toDays();
				    long totalDays=diffDays+1;
				    logger.info("The Calculated Number of Bench Days is :"+totalDays);
					
				    //Total Number of Bench Days Validation.
				    String benchDaysLan=driver.findElement(By.xpath("//*[@id='AgileLabs_view']/tbody/tr[1]/td[11]")).getText();
				    long benchDays= Integer.parseInt(benchDaysLan);
				    if (totalDays==benchDays) {
						
				    	logger.info("The Calculated Bench Days :"+totalDays+" is Equal to the Landing page Captured Bench Days: "+benchDays);
					} else {
				    	logger.info("The Calculated Bench Days :"+totalDays+" is NOT Equal to the Landing page Captured Bench Days: "+benchDays);
					}
				    
				    
				    String monthlyctcVar=driver.findElement(By.xpath("//*[@id='AgileLabs_view']/tbody/tr[1]/td[5]")).getText();
				    String ctc[]=monthlyctcVar.split("₹", 0);
				    String actualctc[]=ctc[1].split(",",0);
				    double monthlyCTC= Integer.parseInt(actualctc[0]+actualctc[1]);
				    logger.info("MonthlyCTC for the employee is :"+monthlyCTC);
				    double calBenchCost=(monthlyCTC/30)*(benchDays);
				    
				     logger.info("The Calculated Bench Cost for the employee is :"+calBenchCost);
				    
				    //Bench Cost In Landing page
				    String benchCost=driver.findElement(By.xpath("//*[@id='AgileLabs_view']/tbody/tr/td[6]")).getText();
				    String benchCotsis[]=benchCost.split("₹", 0);
				    String calbenchCost[]=benchCotsis[1].split(",",0);
				    double totalBenchCost= Integer.parseInt(calbenchCost[0]+calbenchCost[1]);
				    
				    if(calBenchCost==totalBenchCost)
				    {
				    	 logger.info("The Calculated Bench Cost is :"+calBenchCost+" equal to the Actual Bench Cost is :"+totalBenchCost);
				    }else
				    {
				    	 logger.info("The Calculated Bench Cost is :"+calBenchCost+" NOT equal to the Actual Bench Cost is :"+totalBenchCost);
				    }
				    
					count++;
					break;
				}
				else 
				{
				fail= "Not found";
				}
			  if(count>0)
			  {
				break;
			  }
			}
			
		}
		if(count>0)
		{
		break;
		}
	   }		
		
	 }
			
	}
	else
	{
		 logger.info(empname+": record not found in   Agile Labs Bench Tab in Bench Report Module...!!" );
		fail= "Not found";
	}	
	return fail;
}

public String serchFieldConBench(String empname){
	Waitfor(2);
	searchFieldconBench.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
	Waitfor(1);
	String fail="";
	Actions action = new Actions(driver);
	int count = 0;
	String coltext ="Name";
	List<WebElement> page = driver.findElements(By.xpath("//*[@id='Consulting_view_paginate']/span/a"));
	if (page.size()> 0) {
	for (int i = 1; i <=page.size(); i++) 
	{
		if(i>=1)
		{	
		driver.findElement(By.xpath("//div[@id='Consulting_view_paginate']/span/a[" + (i) + "]")).click();
		Waitfor(1);
		}
	WebElement table = driver.findElement(By.xpath("//table[@id='Consulting_view']/thead/tr"));
	List<WebElement> heading = table.findElements(By.tagName("th"));
	for (int h = 0; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (coltext.equalsIgnoreCase(text)) {
			int col = h;
			WebElement rowtable = driver.findElement(By.xpath("//table[@id='Consulting_view']/tbody"));
			List<WebElement> rows = rowtable.findElements(By.tagName("tr"));

			for(int c = 1; c <= rows.size(); c++) {
				
				String cellValue = driver
						.findElement(By.xpath("//table[@id='Consulting_view']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
						.getText();
				Waitfor(1);
				
				if (cellValue.equalsIgnoreCase(empname)) {
					
					WebElement employee= driver.findElement(By.xpath("//table[@id='Consulting_view']/tbody/tr[" + c + "]/td[2]"));
					action.click(employee).build().perform();
					 logger.info(empname+": record found in Consulting Bench Tab in Bench Report Module..!!" );
					String curProject=driver.findElement(By.xpath("//*[@id='Consulting_view']/tbody/tr[1]/td[10]")).getText();
					 logger.info(empname+": the employee's Current project is :"+curProject);
					
					String rollonDate=driver.findElement(By.xpath("//*[@id='Consulting_view']/tbody/tr[1]/td[8]")).getText();
					String[] parts = rollonDate.split("-");
				    String year = parts[0]; 
				    String month = parts[1]; 
				    String date=parts[2];
					String previousDate=date+"-"+month+"-"+year;
					logger.info("The Employee RollOn Date is :"+previousDate);
					
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date datea = new Date();
					String curentDates=dateFormat.format(datea);
					 logger.info("The Current Date Month Year is "+curentDates);
					LocalDate d1 = LocalDate.parse(previousDate, DateTimeFormatter.ISO_LOCAL_DATE);
					LocalDate d2 = LocalDate.parse(curentDates, DateTimeFormatter.ISO_LOCAL_DATE);
					Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
					long diffDays = diff.toDays();
				    long totalDays=diffDays+1;
				    logger.info("The Calculated Number of Bench Days is :"+totalDays);
					
				    
				    //Total Number of Bench Days Validation.
				    String benchDaysLan=driver.findElement(By.xpath("//*[@id='Consulting_view']/tbody/tr[1]/td[11]")).getText();
				    long benchDays= Integer.parseInt(benchDaysLan);
				    if (totalDays==benchDays) {
						
				    	logger.info("The Calculated Bench Days :"+totalDays+" is Equal to the Landing page Captured Bench Days: "+benchDays);
					} else {
				    	logger.info("The Calculated Bench Days :"+totalDays+" is NOT Equal to the Landing page Captured Bench Days: "+benchDays);
					}
				    
				    
				    String monthlyctcVar=driver.findElement(By.xpath("//*[@id='Consulting_view']/tbody/tr[1]/td[5]")).getText();
				    String ctc[]=monthlyctcVar.split("₹", 0);
				    String actualctc[]=ctc[1].split(",",0);
				    double monthlyCTC= Integer.parseInt(actualctc[0]+actualctc[1]);
				     logger.info("MonthlyCTC for the employee is :"+monthlyCTC);
				     double calBenchCost=(monthlyCTC/30)*totalDays;
				     logger.info("The Calculated Bench Cost for the employee is :"+calBenchCost);
				    
				    //Bench Cost In Landing page
				    String benchCost=driver.findElement(By.xpath("//*[@id='Consulting_view']/tbody/tr/td[6]")).getText();
				    String benchCotsis[]=benchCost.split("₹", 0);
				    String calbenchCost[]=benchCotsis[1].split(",",0);
				    double totalBenchCost= Integer.parseInt(calbenchCost[0]+calbenchCost[1]);
				    
				    if(calBenchCost==totalBenchCost)
				    {
				    	 logger.info("The Calculated Bench Cost is :"+calBenchCost+" equal to the Actual Bench Cost is :"+totalBenchCost);
				    }else
				    {
				    	 logger.info("The Calculated Bench Cost is :"+calBenchCost+" NOT equal to the Actual Bench Cost is :"+totalBenchCost);
				    }
					count++;
	
					break;
				}
				else 
				{
				fail= "Not found";
				}
			  if(count>0)
			  {
				break;
			  }
			}
			
		}
		if(count>0)
		{
		break;
		}
	   }		
		
	 }
			
	}
	else
	{
		 logger.info(empname+": record not found in Consulting Bench Tab in Bench Report Module...!!" );
		fail= "Not found";
	}	
	return fail;
}




public String serchFieldsdBench(String empname){
	
	Waitfor(2);
	searchFieldSd.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
	Waitfor(1);
	
	String fail="";
	Actions action = new Actions(driver);
	int count = 0;
	String coltext = "Name";
	List<WebElement> page = driver.findElements(By.xpath("//*[@id='ServiceDelivery_view_paginate']/span/a"));
	if (page.size()>0) {
	for (int i = 1; i <=page.size(); i++) 
	{
		if(i>=1)
		{	
		driver.findElement(By.xpath("//div[@id='ServiceDelivery_view_paginate']/span/a[" + (i) + "]")).click();
		Waitfor(1);
		}  
	WebElement table = driver.findElement(By.xpath("//table[@id='ServiceDelivery_view']/thead/tr"));
	List<WebElement> heading = table.findElements(By.tagName("th"));
	for (int h = 0; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (coltext.equalsIgnoreCase(text)) {
			int col = h;
			WebElement rowtable = driver.findElement(By.xpath("//table[@id='ServiceDelivery_view']/tbody"));
			List<WebElement> rows = rowtable.findElements(By.tagName("tr"));

			for(int c = 1; c <= rows.size(); c++) {
				
				String cellValue = driver
						.findElement(By.xpath("//table[@id='ServiceDelivery_view']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
						.getText();
				Waitfor(1);
				
				if (cellValue.equalsIgnoreCase(empname)) {
					
					WebElement employee= driver.findElement(By.xpath("//table[@id='ServiceDelivery_view']/tbody/tr[" + c + "]/td[2]"));
					action.click(employee).build().perform();
					 logger.info(empname+": record found in Service Delivery Tab in Bench Report Module...!!" );
				
					String rollonDate=driver.findElement(By.xpath("//*[@id='ServiceDelivery_view']/tbody/tr[1]/td[8]")).getText();
					String[] parts = rollonDate.split("-");
				    String year = parts[0]; 
				    String month = parts[1]; 
				    String date=parts[2];
					String previousDate=date+"-"+month+"-"+year;
					 logger.info("The Employee RollOn Date is :"+previousDate);
					
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date datea = new Date();
					String curentDates=dateFormat.format(datea);
					 logger.info("The Current Date Month Year is "+curentDates);
					LocalDate d1 = LocalDate.parse(previousDate, DateTimeFormatter.ISO_LOCAL_DATE);
					LocalDate d2 = LocalDate.parse(curentDates, DateTimeFormatter.ISO_LOCAL_DATE);
					Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
					long diffDays = diff.toDays();
				    long totalDays=diffDays+1;
				    logger.info("The Calculated Number of Bench Days is :"+totalDays);
					
				    
				    //Total Number of Bench Days Validation.
				    String benchDaysLan=driver.findElement(By.xpath("//*[@id='ServiceDelivery_view']/tbody/tr[1]/td[11]")).getText();
				    long benchDays= Integer.parseInt(benchDaysLan);
				    if (totalDays==benchDays) {
						
				    	logger.info("The Calculated Bench Days :"+totalDays+" is Equal to the Landing page Captured Bench Days: "+benchDays);
					} else {
				    	logger.info("The Calculated Bench Days :"+totalDays+" is NOT Equal to the Landing page Captured Bench Days: "+benchDays);
					} 
				    String monthlyctcVar=driver.findElement(By.xpath("//*[@id='ServiceDelivery_view']/tbody/tr[1]/td[5]")).getText();
				    String ctc[]=monthlyctcVar.split("₹", 0);
				    String actualctc[]=ctc[1].split(",",0);
				    double monthlyCTC= Integer.parseInt(actualctc[0]+actualctc[1]);
				     logger.info("MonthlyCTC for the employee is :"+monthlyCTC);
				     double calBenchCost=(monthlyCTC/30)*totalDays;
				     logger.info("The Calculated Bench Cost for the employee is :"+calBenchCost);
				    
				    //Bench Cost In Landing page
				    String benchCost=driver.findElement(By.xpath("//*[@id='ServiceDelivery_view']/tbody/tr/td[6]")).getText();
				    String benchCotsis[]=benchCost.split("₹", 0);
				    String calbenchCost[]=benchCotsis[1].split(",",0);
				    double totalBenchCost= Integer.parseInt(calbenchCost[0]+calbenchCost[1]);
				    
				    if(calBenchCost==totalBenchCost)
				    {
				    	 logger.info("The Calculated Bench Cost is :"+calBenchCost+" equal to the Actual Bench Cost is :"+totalBenchCost);
				    }else
				    {
				    	 logger.info("The Calculated Bench Cost is :"+calBenchCost+" NOT equal to the Actual Bench Cost is :"+totalBenchCost);
				    }
					
					count++;
	
					break;
				}
				else 
				{
				fail= "Not found";
				}
			  if(count>0)
			  {
				break;
			  }
			}
			
		}
		if(count>0)
		{
		break;
		}
	   }		
		
	 }
			
	}
	else
	{
		 logger.info(empname+": record not found in Service Delivery Tab in Bench Report Module...!!" );
		fail= "Not found";
	}	
	return fail;
}




public String serchFieldGlobalBench(String empname){
	
	Waitfor(2);
	searchFieldglobalBench.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
	Waitfor(2);
	
	String fail="";
	Actions action = new Actions(driver);
	int count = 0;
	String coltext = "Name";
	List<WebElement> page = driver.findElements(By.xpath("//div[@id='GlobalBench_view_paginate']/span/a"));
	if (page.size() > 0) {
	for (int i = 1; i <=page.size(); i++) 
	{
		if(i>=1)
		{	
		driver.findElement(By.xpath("//div[@id='GlobalBench_view_paginate']/span/a[" + (i) + "]")).click();
		Waitfor(1);
		}  
	WebElement table = driver.findElement(By.xpath("//table[@id='GlobalBench_view']/thead/tr"));
	List<WebElement> heading = table.findElements(By.tagName("th"));
	for (int h = 0; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (coltext.equalsIgnoreCase(text)) {
			int col = h;
			WebElement rowtable = driver.findElement(By.xpath("//table[@id='GlobalBench_view']/tbody"));
			List<WebElement> rows = rowtable.findElements(By.tagName("tr"));

			for (int c = 1; c <= rows.size(); c++) {
				
				String cellValue = driver
						.findElement(By.xpath("//table[@id='GlobalBench_view']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
						.getText();
				Waitfor(1);
				
				if (cellValue.equalsIgnoreCase(empname)) {
					
					WebElement employee= driver.findElement(By.xpath("//table[@id='GlobalBench_view']/tbody/tr[" + c + "]/td[2]"));
					action.click(employee).build().perform();
					 logger.info(empname+": record found in Global Bench Tab in Bench Report Module...!!" );
					count++;
					break;
				}
				else 
				{
				fail= "Not found";
				}
			  if(count>0)
			  {
				break;
			  }
			}
			
		}
		if(count>0)
		{
		break;
		}
	   }		
		
	 }
			
	}
	else
	{
		 logger.info(empname+": record not found in Global Bench Tab in Bench Report Module...!!" );
		fail= "Not found";
	}	
	return fail;
}


public String serchFieldOverAllTab(String empname){
	Waitfor(2);
	searchFieldoverall.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
	Waitfor(2);
	
	String fail="";
	Actions action = new Actions(driver);
	int count = 0;
	String coltext = "Name";
	List<WebElement> page = driver.findElements(By.xpath("//*[@id='OverAll_view_paginate']/span/a"));
	if (page.size()>0) {
	for (int i = 1; i <=page.size(); i++) 
	{
	   if(i>=1){	
	   driver.findElement(By.xpath("//div[@id='OverAll_view_paginate']/span/a[" + (i) + "]")).click();
	   Waitfor(1);
		}  
	WebElement table = driver.findElement(By.xpath("//table[@id='OverAll_view']/thead/tr"));
	List<WebElement> heading = table.findElements(By.tagName("th"));
	for (int h = 0; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (coltext.equalsIgnoreCase(text)) {
			int col = h;
			WebElement rowtable = driver.findElement(By.xpath("//table[@id='OverAll_view']/tbody"));
			List<WebElement> rows = rowtable.findElements(By.tagName("tr"));

			for (int c = 1; c <= rows.size(); c++) {
				String cellValue = driver.findElement(By.xpath("//table[@id='OverAll_view']/tbody/tr[" + c + "]/td[" + (col+1) + "]")).getText();
				Waitfor(1);
				if (cellValue.equalsIgnoreCase(empname)) {
					WebElement employee= driver.findElement(By.xpath("//table[@id='OverAll_view']/tbody/tr[" + c + "]/td[2]"));
					action.click(employee).build().perform();
					logger.info(empname+": record found in Consolidated report Tab in Bench Report Module...!!" );
					String projectName=driver.findElement(By.xpath("//*[@id='OverAll_view']/tbody/tr[1]/td[10]")).getText();
					logger.info(empname+":The Employee's Current Project in Consolidated Report Tab is:"+projectName);
					count++;
					break;
				}
				else 
				{
				fail= "Not found";
				}
			  if(count>0)
			  {
				break;
			  }
			}
			
		}
		if(count>0)
		{
		break;
		}
	   }		
		
	 }
			
	}
	else
	{
		 logger.info(empname+": record not found in Overall Tab in Bench Report Module...!!" );
		fail= "Not found";
	}	
	return fail;
}	

public String serchFieldConTab(String empname){
	
	Waitfor(2);
	consultingBenchSearch.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
	Waitfor(1);
	
	String fail="";
	Actions action = new Actions(driver);
	int count = 0;
	String coltext = "Name";							
	List<WebElement> page = driver.findElements(By.xpath("//*[@id='Consulting_view_paginate']/span/a"));
	if (page.size() > 0) {
	for (int i = 1; i <=page.size(); i++) 
	{
		if(i>=1)
		{	
		driver.findElement(By.xpath("//div[@id='Consulting_view_paginate']/span/a[" + (i) + "]")).click();
		Waitfor(1);
		}  
	WebElement table = driver.findElement(By.xpath("//table[@id='Consulting_view']/thead/tr"));
	List<WebElement> heading = table.findElements(By.tagName("th"));
	for (int h = 0; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (coltext.equalsIgnoreCase(text)) {
			int col = h;
			WebElement rowtable = driver.findElement(By.xpath("//table[@id='Consulting_view']/tbody"));
			List<WebElement> rows = rowtable.findElements(By.tagName("tr"));

			for (int c = 1; c <= rows.size(); c++) {
				
				String cellValue = driver
						.findElement(By.xpath("//table[@id='Consulting_view']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
						.getText();
				Waitfor(1);
				
				if (cellValue.equalsIgnoreCase(empname)) {
					
					WebElement employee= driver.findElement(By.xpath("//table[@id='Consulting_view']/tbody/tr[" + c + "]/td[2]"));
					action.click(employee).build().perform();
					String proName=driver.findElement(By.xpath("//*[@id='Consulting_view']/tbody/tr[1]/td[10]")).getText();
					 logger.info(empname+": record found in Consulting Bench Tab in Bench Report Module and Employee Current Project is :"+proName );
				
					 
					 String rollonDate=driver.findElement(By.xpath("//*[@id='Consulting_view']/tbody/tr[1]/td[8]")).getText();
						String[] parts = rollonDate.split("-");
					    String year = parts[0]; 
					    String month = parts[1]; 
					    String date=parts[2];
						String previousDate=date+"-"+month+"-"+year;
						logger.info("In Consutling Department The Employee RollOn Date is :"+previousDate);
						
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date datea = new Date();
						String curentDates=dateFormat.format(datea);
						 logger.info("The Current Date Month Year is "+curentDates);
						LocalDate d1 = LocalDate.parse(previousDate, DateTimeFormatter.ISO_LOCAL_DATE);
						LocalDate d2 = LocalDate.parse(curentDates, DateTimeFormatter.ISO_LOCAL_DATE);
						Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
						long diffDays = diff.toDays();
					    long totalDays=diffDays+1;
					    logger.info("In Consutling Department The Calculated Number of Bench Days is :"+totalDays);
						
					    
					    //Total Number of Bench Days Validation.
					    String benchDaysLan=driver.findElement(By.xpath("//*[@id='Consulting_view']/tbody/tr[1]/td[11]")).getText();
					    long benchDays= Integer.parseInt(benchDaysLan);
					    if (totalDays==benchDays) {
							
					    	logger.info("In Consutling Department The Calculated Bench Days :"+totalDays+" is Equal to the Landing page Captured Bench Days: "+benchDays);
						} else {
					    	logger.info("In Consutling Department The Calculated Bench Days :"+totalDays+" is NOT Equal to the Landing page Captured Bench Days: "+benchDays);
						}
					    
					    
					    String monthlyctcVar=driver.findElement(By.xpath("//*[@id='Consulting_view']/tbody/tr[1]/td[5]")).getText();
					    String ctc[]=monthlyctcVar.split("₹", 0);
					    String actualctc[]=ctc[1].split(",",0);
					    long monthlyCTC= Integer.parseInt(actualctc[0]+actualctc[1]);
					     logger.info("In Consutling Department MonthlyCTC for the employee is :"+monthlyCTC);
					    long calBenchCost=(monthlyCTC/30)*totalDays;
					     logger.info("In Consutling Department The Calculated Bench Cost for the employee is :"+calBenchCost);
					    
					    //Bench Cost In Landing page
					    String benchCost=driver.findElement(By.xpath("//*[@id='Consulting_view']/tbody/tr/td[6]")).getText();
					    String benchCotsis[]=benchCost.split("₹", 0);
					    String calbenchCost[]=benchCotsis[1].split(",",0);
					    long totalBenchCost= Integer.parseInt(calbenchCost[0]+calbenchCost[1]);
					    
					    if(calBenchCost==totalBenchCost)
					    {
					    	 logger.info("In Consutling Department The Calculated Bench Cost is :"+calBenchCost+" equal to the Actual Bench Cost is :"+totalBenchCost);
					    }else
					    {
					    	 logger.info("In Consutling Department The Calculated Bench Cost is :"+calBenchCost+" NOT equal to the Actual Bench Cost is :"+totalBenchCost);
					    }
					 
					 
					 
					 count++;
	
					break;
				}
				else 
				{
				fail= "Not found";
				}
			  if(count>0)
			  {
				break;
			  }
			}
			
		}
		if(count>0)
		{
		break;
		}
	   }		
		
	 }
			
	}
	else
	{
		 logger.info(empname+": record not found in Consulting Bench Tab in Bench Report Module...!!" );
		fail= "Not found";
	}	
	return fail;
}



public String serchFieldAgileTab(String empname){	
	
	Waitfor(2);
	agileTabSearchField.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
	Waitfor(1);
	String fail="";
	Actions action = new Actions(driver);
	int count = 0;
	String coltext = "Name";							 
	List<WebElement> page = driver.findElements(By.xpath("//*[@id='AgileLabs_view_paginate']/span/a"));
	if (page.size() > 0) {
	for (int i = 1; i <=page.size(); i++) 
	{
		if(i>=1)
		{	
		driver.findElement(By.xpath("//div[@id='AgileLabs_view_paginate']/span/a[" + (i) + "]")).click();
		Waitfor(1);
		}  
	WebElement table = driver.findElement(By.xpath("//table[@id='AgileLabs_view']/thead/tr"));
	List<WebElement> heading = table.findElements(By.tagName("th"));
	for (int h = 0; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (coltext.equalsIgnoreCase(text)) {
			int col = h;
			WebElement rowtable = driver.findElement(By.xpath("//table[@id='AgileLabs_view']/tbody"));
			List<WebElement> rows = rowtable.findElements(By.tagName("tr"));

			for(int c = 1; c <= rows.size(); c++) {
				
				String cellValue = driver
						.findElement(By.xpath("//table[@id='AgileLabs_view']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
						.getText();
				Waitfor(1);
				
				if (cellValue.equalsIgnoreCase(empname)) {
					
					WebElement employee= driver.findElement(By.xpath("//table[@id='AgileLabs_view']/tbody/tr[" + c + "]/td[2]"));
					action.click(employee).build().perform();
					String curProject=driver.findElement(By.xpath("//*[@id='AgileLabs_view']/tbody/tr[1]/td[10]")).getText();
					 logger.info(empname+": record found in AgileLabs Bench Tab in Bench Report Module and employee's Current Project :"+curProject);
					
					 	String rollonDate=driver.findElement(By.xpath("//*[@id='AgileLabs_view']/tbody/tr[1]/td[8]")).getText();
						String[] parts = rollonDate.split("-");
					    String year = parts[0]; 
					    String month = parts[1]; 
					    String date=parts[2];
						String previousDate=date+"-"+month+"-"+year;
						logger.info("In Agile Lab Depatment The Employee RollOn Date is :"+previousDate);
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date datea = new Date();
						String curentDates=dateFormat.format(datea);
						 logger.info("The Current Date Month Year is :"+curentDates);
						LocalDate d1 = LocalDate.parse(previousDate, DateTimeFormatter.ISO_LOCAL_DATE);
						LocalDate d2 = LocalDate.parse(curentDates, DateTimeFormatter.ISO_LOCAL_DATE);
						Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
						long diffDays = diff.toDays();
					    long totalDays=diffDays+1;
					    logger.info("In Agile Lab Depatment The Calculated Number of Bench Days is :"+totalDays);
						
					    //Total Number of Bench Days Validation.
					    String benchDaysLan=driver.findElement(By.xpath("//*[@id='AgileLabs_view']/tbody/tr[1]/td[11]")).getText();
					    long benchDays= Integer.parseInt(benchDaysLan);
					    if (totalDays==benchDays) {
							
					    	logger.info("In Agile Lab Depatment The Calculated Bench Days :"+totalDays+" is Equal to the Landing page Captured Bench Days: "+benchDays);
						} else {
					    	logger.info("In Agile Lab Depatment The Calculated Bench Days :"+totalDays+" is NOT Equal to the Landing page Captured Bench Days: "+benchDays);
						}
					    
					    
					    String monthlyctcVar=driver.findElement(By.xpath("//*[@id='AgileLabs_view']/tbody/tr[1]/td[5]")).getText();
					    String ctc[]=monthlyctcVar.split("₹", 0);
					    String actualctc[]=ctc[1].split(",",0);
					    long monthlyCTC= Integer.parseInt(actualctc[0]+actualctc[1]);
					     logger.info("In Agile Lab Depatment MonthlyCTC for the employee is :"+monthlyCTC);
					    long calBenchCost=(monthlyCTC/30)*totalDays;
					     logger.info("In Agile Lab Depatment The Calculated Bench Cost for the employee is :"+calBenchCost);
					    
					    //Bench Cost In Landing page
					    String benchCost=driver.findElement(By.xpath("//*[@id='AgileLabs_view']/tbody/tr/td[6]")).getText();
					    String benchCotsis[]=benchCost.split("₹", 0);
					    String calbenchCost[]=benchCotsis[1].split(",",0);
					    long totalBenchCost= Integer.parseInt(calbenchCost[0]+calbenchCost[1]);
					    
					    if(calBenchCost==totalBenchCost)
					    {
					    	 logger.info("In Agile Lab Depatment The Calculated Bench Cost is :"+calBenchCost+" equal to the Actual Bench Cost is :"+totalBenchCost);
					    }else
					    {
					    	 logger.info("In Agile Lab Depatment The Calculated Bench Cost is :"+calBenchCost+" NOT equal to the Actual Bench Cost is :"+totalBenchCost);
					    }
					 
					 
					 count++;
	
					break;
				}
				else 
				{
				fail= "Not found";
				}
			  if(count>0)
			  {
				break;
			  }
			}
			
		}
		if(count>0)
		{
		break;
		}
	   }		
		
	 }
			
	}
	else
	{
		 logger.info(empname+": record not found in AgileLabs Bench Tab in Bench Report Module...!!" );
		fail= "Not found";
	}	
	return fail;
}



public String servicedeliveryserchField(String empname){
	Waitfor(2);
	sdserchField.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
	Waitfor(1);
	String fail="";
	Actions action = new Actions(driver);
	int count = 0;
	String coltext = "Name";							 
	List<WebElement> page = driver.findElements(By.xpath("//*[@id='ServiceDelivery_view_paginate']/span/a"));
	if (page.size() > 0) {
	for (int i = 1; i <=page.size(); i++) 
	{
		if(i>=1)
		{	
		driver.findElement(By.xpath("//div[@id='ServiceDelivery_view_paginate']/span/a[" + (i) + "]")).click();
		Waitfor(1);
		}  
	WebElement table = driver.findElement(By.xpath("//table[@id='ServiceDelivery_view']/thead/tr"));
	List<WebElement> heading = table.findElements(By.tagName("th"));
	for (int h = 0; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (coltext.equalsIgnoreCase(text)) {
			int col = h;
			WebElement rowtable = driver.findElement(By.xpath("//table[@id='ServiceDelivery_view']/tbody"));
			List<WebElement> rows = rowtable.findElements(By.tagName("tr"));

			for(int c = 1; c <= rows.size(); c++) {
				
				String cellValue = driver
						.findElement(By.xpath("//table[@id='ServiceDelivery_view']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
						.getText();
				Waitfor(1);
				
				if (cellValue.equalsIgnoreCase(empname)) {
					
					WebElement employee= driver.findElement(By.xpath("//table[@id='ServiceDelivery_view']/tbody/tr[" + c + "]/td[2]"));
					action.click(employee).build().perform();
					String curProject=driver.findElement(By.xpath("//*[@id='ServiceDelivery_view']/tbody/tr[1]/td[10]")).getText();
					 logger.info(empname+": record found in Service Delivery Bench Tab in Bench Report Module and employee's Current Project :"+curProject);
					
					 String rollonDate=driver.findElement(By.xpath("//*[@id='ServiceDelivery_view']/tbody/tr[1]/td[8]")).getText();
						String[] parts = rollonDate.split("-");
					    String year = parts[0]; 
					    String month = parts[1]; 
					    String date=parts[2];
						String previousDate=date+"-"+month+"-"+year;
						 logger.info("In Service Delivery Department The Employee RollOn Date is :"+previousDate);
						
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date datea = new Date();
						String curentDates=dateFormat.format(datea);
						 logger.info("The Current Date Month Year is "+curentDates);
						LocalDate d1 = LocalDate.parse(previousDate, DateTimeFormatter.ISO_LOCAL_DATE);
						LocalDate d2 = LocalDate.parse(curentDates, DateTimeFormatter.ISO_LOCAL_DATE);
						Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
						long diffDays = diff.toDays();
					    long totalDays=diffDays+1;
					    logger.info("The Calculated Number of Bench Days is :"+totalDays);
						
					    
					    //Total Number of Bench Days Validation.
					    String benchDaysLan=driver.findElement(By.xpath("//*[@id='ServiceDelivery_view']/tbody/tr[1]/td[11]")).getText();
					    long benchDays= Integer.parseInt(benchDaysLan);
					    if (totalDays==benchDays) {
							
					    	logger.info("In Service Delivery Department The Calculated Bench Days :"+totalDays+" is Equal to the Landing page Captured Bench Days: "+benchDays);
						} else {
					    	logger.info("In Service Delivery Department The Calculated Bench Days :"+totalDays+" is NOT Equal to the Landing page Captured Bench Days: "+benchDays);
						} 
					    String monthlyctcVar=driver.findElement(By.xpath("//*[@id='ServiceDelivery_view']/tbody/tr[1]/td[5]")).getText();
					    String ctc[]=monthlyctcVar.split("₹", 0);
					    String actualctc[]=ctc[1].split(",",0);
					    long monthlyCTC= Integer.parseInt(actualctc[0]+actualctc[1]);
					     logger.info("In Service Delivery Department MonthlyCTC for the employee is :"+monthlyCTC);
					    long calBenchCost=(monthlyCTC/30)*totalDays;
					     logger.info("In Service Delivery Department The Calculated Bench Cost for the employee is :"+calBenchCost);
					    
					    //Bench Cost In Landing page
					    String benchCost=driver.findElement(By.xpath("//*[@id='ServiceDelivery_view']/tbody/tr/td[6]")).getText();
					    String benchCotsis[]=benchCost.split("₹", 0);
					    String calbenchCost[]=benchCotsis[1].split(",",0);
					    long totalBenchCost= Integer.parseInt(calbenchCost[0]+calbenchCost[1]);
					    
					    if(calBenchCost==totalBenchCost)
					    {
					    	 logger.info("In Service Delivery Department The Calculated Bench Cost is :"+calBenchCost+" equal to the Actual Bench Cost is :"+totalBenchCost);
					    }else
					    {
					    	 logger.info("In Service Delivery Department The Calculated Bench Cost is :"+calBenchCost+" NOT equal to the Actual Bench Cost is :"+totalBenchCost);
					    }
						
					 
					 
					 count++;
	
					break;
				}
				else 
				{
				fail= "Not found";
				}
			  if(count>0)
			  {
				break;
			  }
			}
			
		}
		if(count>0)
		{
		break;
		}
	   }		
		
	 }
			
	}
	else
	{
		 logger.info(empname+": record not found in Service Delivery Bench Tab in Bench Report Module...!!" );
		fail= "Not found";
	}	
	return fail;
}




public void downloadreport(){
		Waitfor(2);
		internalReport.click();
		Waitfor(2);
			boolean sts=selectAllCheckBox.isSelected();
			if (sts==bTrue) {
				Waitfor(2);
				downloadButton.click();
				 logger.info("To Download the report All Reports are Selected...!!");
				Waitfor(2);
			} else {
				Waitfor(2);
				agileBenchReport.click();
				Waitfor(3);
				/*agileSoftLockReport.click();*/
				Waitfor(2);
				globalbenchReport.click();
				Waitfor(2);
				downloadButton.click();
				Waitfor(2);
				 logger.info("The Download Report button is clicked and downloaded Successfully...!!!");
			}
		
	}
	
 public void allReportDownload(){
	    Waitfor(2);
		internalReport.click();
		Waitfor(2);
			boolean sts=selectAllCheckBox.isSelected();
			if (sts==bFalse) {
				Waitfor(2);
				downloadButton.click();
				 logger.info("To Download the report All Reports are Selected...!!");
				Waitfor(2);
				selectAllCheckBox.click();
				Waitfor(2);
				downloadButton.click();
				Waitfor(2);
				 logger.info("The Select All CheckBox Report is Selected to Download Bench Report....!!!");
			} else {
				Waitfor(2);
				agileBenchReport.click();
				Waitfor(3);
				globalbenchReport.click();
				Waitfor(2);
				downloadButton.click();
				Waitfor(2);
				 logger.info("The Download Report button is clicked and downloaded Successfully...!!!");
			}
 	}
	
  public void reportsGraphicalweekly(String selStartYearWeekly, String selstartMonthWeekly, String selStartDateWeekly, String selEndYearWeekly, String selEndMonthWeekly, String selEndDateWeekly ){
	  Waitfor(4);
	  boolean reportsStatus=reports.isDisplayed();
	  if (reportsStatus==bTrue) {
		 reports.click();
		 Waitfor(2);
		 weeklyReport.click();
		 Waitfor(2);
		 logger.info("Weekly and Monthly Report Button is Enabled and clicked successfully..!!");
		 weeklyStartDate.click();
		 Waitfor(2);
		 Select osel=new Select(yearDropdown);
		 osel.selectByValue(selStartYearWeekly);
		 Waitfor(2);
		 Select oselect=new Select(monthDropDown);
		 oselect.selectByVisibleText(selstartMonthWeekly);
		 Waitfor(2);
		 List<WebElement> dates1 = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td"));
		 int totalnodes1 = dates1.size();
		 for (int i = 0; i < totalnodes1; i++){
		 String date1 = dates1.get(i).getText();
		 int abc=Integer.parseInt(selStartDateWeekly);
		 if (date1.equals(Integer.toString(abc))){
		 dates1.get(i).click();
		 logger.info("Selected Start date month and Year For Weekly Report is: "+ selStartDateWeekly+":"+selstartMonthWeekly+":"+selStartYearWeekly);
		 break;
		 }
	   }
		 
		 weeklyEndDate.click();
		 Waitfor(2);
		 Select oselend=new Select(yearDropdown);
		 oselend.selectByValue(selEndYearWeekly);
		 Waitfor(2);
		 Select oselendmon=new Select(monthDropDown);
		 oselendmon.selectByVisibleText(selEndMonthWeekly);
		 Waitfor(2);
		 List<WebElement> dates = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td"));
		 int totalnodes = dates.size();
		 for (int i = 0; i < totalnodes; i++){
		 String date = dates.get(i).getText();
		 int selectDate=Integer.parseInt(selEndDateWeekly);
		 if (date.equals(Integer.toString(selectDate))){
		 dates.get(i).click();
		 logger.info("Selected End date month and Year For Weekly Report is: "+ selEndDateWeekly+":"+selEndMonthWeekly+":"+selEndYearWeekly);
		 Waitfor(6);
		 boolean costStatus=benchCostweekly.isDisplayed();
		 if (costStatus==bTrue) {
			
			 String benchCost=benchCostweekly.getText();
			 String totalBenchCost[]=benchCost.split(":");
			 logger.info("The Total Bench Cost for the select Weekly Report is :"+totalBenchCost[1]);
			 
		} else {
              logger.info("The Total Bench Cost is Not Displayed......!!!");
		}
		 
		 break;
		 }
	   }
	  } else {
		  logger.info("Weekly and Monthly Report Button is Not Enabled and Failed to Click Report Button..!!");

	}
	 
  }
  public void agileWeeklyTotalBenchCost(){//Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='AgileLabs_view']/tbody/tr")).size();
	  logger.info("In Agile Lab for weekly Number Of Employee's In Highest Paid DataTable = "+rowcount);
	  

	  int colcount = driver.findElements(By.xpath("//*[@id='AgileLabs_view']/tbody/tr[1]/td[6]")).size();
	
	  String firstpart= "//*[@id='AgileLabs_view']/tbody/tr[";
	  String secondpart= "]/td[6]";
	  for (int i=1; i<=rowcount; i++){

	   String finalxpath =firstpart+i+secondpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Agile Lab for weekly Employees Name with Highest Monthly CTC are--0"+i+":"+tableData);  
	   String remvRupi[]=tableData.split("₹");
	   String value=remvRupi[0];
	   long abc=Integer.parseInt(value);
	   if (abc==0) {
		
	   } else {

	   }
	  // String comma[]=remvRupi[0].split(",",0);
	   
	   
	   logger.info("In Agile Lab for weekly Employees Name with Highest Monthly CTC are--0"+i+":"+value);   
	  
	  } 
	  Waitfor(2);
	  closeButton.click();
	  Waitfor(4);
}

  
public void agileWeeklyEmpMostCTC(){//Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='AgileLabs_Weekely_view_highest_paid']/tbody/tr")).size();
	  logger.info("In Agile Lab for weekly Number Of Employee's In Highest Paid DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='AgileLabs_Weekely_view_highest_paid']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='AgileLabs_Weekely_view_highest_paid']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
		  String finalxpathctc =firstpart+i+secondpart+5+thirdpart;
		  String monthlyctc = driver.findElement(By.xpath(finalxpathctc)).getText();
	  //Used for loop for number of columns.
	   for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Agile Lab for weekly Employees Name with Highest Monthly CTC are--0"+i+"--"+tableData+":"+monthlyctc);   
	  }	 
	  } 
	  Waitfor(2);
	  closeButton.click();
	  Waitfor(4);
}
	

public void agileWeeklyEmpBenchDays(){//Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='AgileLabs_Weekely_view_oldest_empls']/tbody/tr")).size();
	  logger.info("In Agile Lab for Weekly Number Of Employee's In Highest Days Emp DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='AgileLabs_Weekely_view_oldest_empls']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='AgileLabs_Weekely_view_oldest_empls']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
	  //Used for loop for number of columns.
	  for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Agile Lab for Weekly Employees with Highest Days--0"+i+":"+tableData);   
	   }
	  // logger.info("");
	   //logger.info("");  
	  } 
	  Waitfor(3);
	    
}


public void reportsGraphicalMonthly(String selStartYearWeekly, String selstartMonthWeekly, String selStartDateWeekly, String selEndYearWeekly, String selEndMonthWeekly, String selEndDateWeekly ){
	  Waitfor(3);
	  boolean reportsStatus=reports.isDisplayed();
	  if (reportsStatus==bTrue) {
		 reports.click();
		 Waitfor(2);
		 monthlyReport.click();
		 Waitfor(2);
		 logger.info("Weekly and Monthly Report Button is Enabled and clicked successfully..!!");
		 monthlyStartDate.click();
		 Waitfor(2);
		 Select osel=new Select(yearDropdown);
		 osel.selectByValue(selStartYearWeekly);
		 Waitfor(2);
		 Select oselect=new Select(monthDropDown);
		 oselect.selectByVisibleText(selstartMonthWeekly);
		 Waitfor(2);
		 List<WebElement> dates1 = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td"));
		 int totalnodes1 = dates1.size();
		 for (int i = 0; i < totalnodes1; i++){
		 String date1 = dates1.get(i).getText();
		 int abc=Integer.parseInt(selStartDateWeekly);
		 if (date1.equals(Integer.toString(abc))){
		 dates1.get(i).click();
		 logger.info("Selected Start date month and Year For Monthly Report is: "+ selStartDateWeekly+":"+selstartMonthWeekly+":"+selStartYearWeekly);
		 break;
		 }
	   }
		 
		 monthlyEndDate.click();
		 Waitfor(2);
		 Select oselend=new Select(yearDropdown);
		 oselend.selectByValue(selEndYearWeekly);
		 Waitfor(2);
		 Select oselendmon=new Select(monthDropDown);
		 oselendmon.selectByVisibleText(selEndMonthWeekly);
		 Waitfor(2);
		 List<WebElement> dates = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td"));
		 int totalnodes = dates.size();
		 for (int i = 0; i < totalnodes; i++){
		 String date = dates.get(i).getText();
		 int selectDate=Integer.parseInt(selEndDateWeekly);
		 if (date.equals(Integer.toString(selectDate))){
		 dates.get(i).click();
		 logger.info("Selected End date month and Year For Monthly Report is: "+ selEndDateWeekly+":"+selEndMonthWeekly+":"+selEndYearWeekly);
		 Waitfor(6);
		
		 boolean costStatus=benchCostmonthly.isDisplayed();
		 if (costStatus==bTrue) {
			
			 String benchCost=benchCostmonthly.getText();
			 String totalBenchCost[]=benchCost.split(":");
			 logger.info("The Total Bench Cost for the select Monthly Report is :"+totalBenchCost[1]);
			 
		} else {
            logger.info("The Total Bench Cost is Not Displayed......!!!");
		}
		 
		 break;
		 }
	   }
	  } else {
		  logger.info("Weekly and Monthly Report Button is Not Enabled and Failed to Click Report Button..!!");

	}
	 
}



public void agileMonthlyEmpMostCTC(){//Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='AgileLabs_Monthly_view_highest_paid']/tbody/tr")).size();
	  logger.info("In Agile Lab Number Of Employee's In Highest Monthly CTC DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='AgileLabs_Monthly_view_highest_paid']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='AgileLabs_Monthly_view_highest_paid']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
		  
		  String finalxpathctc =firstpart+i+secondpart+5+thirdpart;
		  String monthlyctc = driver.findElement(By.xpath(finalxpathctc)).getText();
		  
	  //Used for loop for number of columns.
	  for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Agile Lab Employees for Monthly Employee Name with Highest Monthly CTC are--0"+i+":"+tableData+"-"+monthlyctc);   
	   }
	  } 
	  
	  Waitfor(2);
	  closeButton.click();
	  Waitfor(2);
}
	

public void agileMonthlyEmpBenchDays(){//Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='AgileLabs_Monthly_view_oldest_empls']/tbody/tr")).size();
	  logger.info("In Agile Lab Number Of Employee's Monthly Highest Days DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='AgileLabs_Monthly_view_oldest_empls']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='AgileLabs_Monthly_view_oldest_empls']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
	  //Used for loop for number of columns.
	  for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Agile Lab Employees for Monthly Employees Name with Highest Days--0"+i+":"+tableData);   
	   }
	  } 
	  Waitfor(3);
	  
	  
}

//***************************Consulting Department*************************************//

public void conWeeklyEmpMostCTC(){//Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='Consulting_Weekely_view_highest_paid']/tbody/tr")).size();
	  logger.info("In Consulting Bench Number Of Employee's In Monthly Highest Monthly CTC DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='Consulting_Weekely_view_highest_paid']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='Consulting_Weekely_view_highest_paid']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
	  //Used for loop for number of columns.
		  
	  String finalxpathctc =firstpart+i+secondpart+5+thirdpart;
	  String monthlyctc = driver.findElement(By.xpath(finalxpathctc)).getText();
		  
	  for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Consulting Bench Weekly Employees Name with Highest Monthly CTC are--0"+i+":"+tableData+"-"+monthlyctc);   
	   }
	  } 
	  Waitfor(2);
	  closeButton.click();
	  Waitfor(4);
}
	

public void conWeeklyEmpBenchDays(){//Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='Consulting_Weekely_view_oldest_empls']/tbody/tr")).size();
	  logger.info("In Consulting Bench Number Of Employee's In Weekly Highest Bench Days In DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='Consulting_Weekely_view_oldest_empls']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='Consulting_Weekely_view_oldest_empls']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
	  //Used for loop for number of columns.
	  for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Consulting Bench For Weekly Employees with Highest Days--0"+i+":"+tableData);   
	   }
	  } 
	  Waitfor(3);
	    
}


/*
public void conMonthlyEmpMostCTC(){//Get number of rows In table.
	  Waitfor(2);
	  int rowcount = driver.findElements(By.xpath("//*[@id='Consulting_Monthly_view_highest_paid']/tbody/tr")).size();
	  logger.info("In Consulting Bench Number Of Employee's In Monthly Highest Monthly CTC DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='Consulting_Monthly_view_highest_paid']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='Consulting_Monthly_view_highest_paid']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  Waitfor(2);
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
	  //Used for loop for number of columns.
	  for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Consulting Bench Monthly Employees Name with Highest Monthly CTC are--0"+i+":"+tableData);   
	   }
	  } 
	  
}

*/


public void conMonthlyEmpMostCTC(){
	
	   //Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='Consulting_Monthly_view_highest_paid']/tbody/tr")).size();
	  logger.info("In Consulting Bench Number Of Employee's In Monthly Highest Monthly CTC DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='Consulting_Monthly_view_highest_paid']/tbody/tr[1]/td[1]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='Consulting_Monthly_view_highest_paid']/tbody/tr[";
	  String secondpart=  "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
		  
	  String finalxpathctc =firstpart+i+secondpart+5+thirdpart;
	  String monthlyctc = driver.findElement(By.xpath(finalxpathctc)).getText();
	  
		  for(int j=1; j<=colcount; j++) {
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Consulting Bench Monthly Employees Name with Highest Monthly CTC are--0"+i+":"+tableData+"-"+monthlyctc);   
		  }
	  } 
	  
	  Waitfor(2);
	  closeButton.click();
	  Waitfor(2);
	
	
	
	
}
	

public void conMonthlyEmpBenchDays(){//Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='Consulting_Monthly_view_oldest_empls']/tbody/tr")).size();
	  logger.info("In Consulting Bench Number Of Employee's In Monthly Highest Days DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='Consulting_Monthly_view_oldest_empls']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='Consulting_Monthly_view_oldest_empls']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
	  //Used for loop for number of columns.
	  for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Consulting Bench For Monthly Employees Name with Highest Days--0"+i+":"+tableData);   
	   }
	  } 
	  Waitfor(3);
	  
}


//***************************Service Delivery Department*************************************//

public void sdWeeklyEmpMostCTC(){//Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='ServiceDelivery_Weekely_view_highest_paid']/tbody/tr")).size();
	  logger.info("In Service Delivery Number Of Employee's In Weekly Highest Monthly CTC DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='ServiceDelivery_Weekely_view_highest_paid']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='ServiceDelivery_Weekely_view_highest_paid']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
		  
	  String finalxpathctc =firstpart+i+secondpart+5+thirdpart;
	  String monthlyctc = driver.findElement(By.xpath(finalxpathctc)).getText();
			  
	  //Used for loop for number of columns.
	  for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Service delivery for Weekly Employees Name with Highest Monthly CTC are--0"+i+":"+tableData+"-"+monthlyctc);   
	   } 
	  } 
	  Waitfor(2);
	  closeButton.click();
	  Waitfor(4);
}
	

public void sdWeeklyEmpBenchDays(){//Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='ServiceDelivery_Weekely_view_oldest_empls']/tbody/tr")).size();
	  logger.info("In Service Delivery Number Of Employee's In Weekly Highest Bench Days DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='ServiceDelivery_Weekely_view_oldest_empls']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='ServiceDelivery_Weekely_view_oldest_empls']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
	  //Used for loop for number of columns.
	  for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Service Delivery for Weekly Employees Name with Highest Days--0"+i+":"+tableData);   
	   }
	  } 
	  Waitfor(3);
	    
}



public void sdMonthlyEmpMostCTC(){
	  //Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='ServiceDelivery_Monthly_view_highest_paid']/tbody/tr")).size();
	  logger.info("In Service Delivery Number Of Employee's In Monthly Highest Monthly CTC DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='ServiceDelivery_Monthly_view_highest_paid']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='ServiceDelivery_Monthly_view_highest_paid']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
		  
	   String finalxpathctc =firstpart+i+secondpart+5+thirdpart;
	   String monthlyctc = driver.findElement(By.xpath(finalxpathctc)).getText();  
	  //Used for loop for number of columns.
	  for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Service Delivery for Monthly Employees Name with Highest Monthly CTC are--0"+i+":"+tableData+"-"+monthlyctc);  
	    }
	  } 
	  Waitfor(2);
	  closeButton.click();
	  Waitfor(4);
	  
}
	

public void sdMonthlyEmpBenchDays(){//Get number of rows In table.
	  int rowcount = driver.findElements(By.xpath("//*[@id='ServiceDelivery_Monthly_view_oldest_empls']/tbody/tr")).size();
	  logger.info("In Service Delivery Number Of Employee's Monthly In Highest Bench Days DataTable = "+rowcount);
	  
	  //Get number of columns In table.
	  int colcount = driver.findElements(By.xpath("//*[@id='ServiceDelivery_Monthly_view_oldest_empls']/tbody/tr[1]/td[6]")).size();
	  //divided xpath In three parts to pass Row_count and Col_count values.
	  String firstpart= "//*[@id='ServiceDelivery_Monthly_view_oldest_empls']/tbody/tr[";
	  String secondpart= "]/td[";
	  String thirdpart= "]";
	  
	  //Used for loop for number of rows.
	  for (int i=1; i<=rowcount; i++){
	  //Used for loop for number of columns.
	  for(int j=1; j<=colcount; j++){
	   String finalxpath =firstpart+i+secondpart+j+thirdpart;
	   String tableData = driver.findElement(By.xpath(finalxpath)).getText();
	   logger.info("In Service Delivery for Monthly Employees with Highest Days--0"+i+":"+tableData);   
	   }
	  } 
	  Waitfor(3);
	  
	  
}




	// Bench Report For Consulting 
	
public void consultingBenchTab(){
		Waitfor(2);
		consultingTab.click();
		Waitfor(2);
	}
	
public void globalBenchTab(){
		Waitfor(1);
		globalBenchtab.click();
		Waitfor(2);
	}
	
public void allTabView(){
		Waitfor(2);
		allReportTab.click();
		Waitfor(4);
		
	}
	// Bench Report For Service Delivery
	
public void agileLabTab(){
		Waitfor(2);
		agileLabsTab.click();
		Waitfor(2);
	}
public void serviceDeliveryTab(){
		Waitfor(1);
		serviceDeliveryTab.click();
		Waitfor(2);
	}
	
}
