package com.dikshatech.tst.objectrepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;	
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;

public class TimesheetsSubmoduleObjects extends TestBase {

	@Test
	public TimesheetsSubmoduleObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//Employee Level..  
	@FindBy(xpath="//*[@id='mylynx']/a") 							WebElement MyLynx;
	@FindBy(xpath="//*[@id='timesheet']") 							WebElement TimeSheets_Submodule;
	@FindBy(xpath="//*[@id='addTimesheet']") 						WebElement newTimesheet;
	@FindBy(xpath="//*[@id='editTimesheet']") 						WebElement EditTimesheet;
	@FindBy(xpath="//*[@id='submitTimesheet']") 					WebElement Submit_Timesheet;
	@FindBy(xpath="//*[@id='timesheet_view_filter']/label/input")   WebElement Search_Input_Box_Timesheet;
	@FindBy(xpath="//*[@id='weekpicker']") 							WebElement selectTimesheet;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div/a[1]") 			WebElement Previous_Button_Timesheet;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div/a[2]")          WebElement Next_Button_Timesheet;
	@FindBy(xpath="//*[@id='weekpicker']") 							WebElement selectDate;
	@FindBy(xpath="//*[@id='addTimeSheetTask']") 					WebElement addTaskButton;
	@FindBy(xpath="//*[@id='removeTimeSheetTask']") 				WebElement removeTaskButton;
	@FindBy(xpath="//*[@id='timesheet_new_projectDropDown_0']") 	WebElement selectProject;
	@FindBy(xpath="//*[@id='timeTextBox_0']") 						WebElement selectTask;
	@FindBy(xpath = "//*[@id='timesheet_view']/tbody/tr[1]") 		WebElement selectTheTimesheet;
	//Monday
	@FindBy(xpath="//*[@id='mon_0']") 								WebElement mondayTime;
	@FindBy(xpath="//*[@id='comment00']") 							WebElement addMondayTask;
	@FindBy(xpath="//*[@id='timesheet_Comment']") 					WebElement AllComments;
	@FindBy(xpath="//*[@id='addCommentForDate']") 					WebElement addComentsButton;
	//TuesDay
	@FindBy(xpath="//*[@id='tue_0']") 								WebElement tuesdayTime;
	@FindBy(xpath="//*[@id='comment01']") 							WebElement addTuesdayTask;
	//Wednesday
	@FindBy(xpath="//*[@id='wed_0']") 								WebElement wednesdayTime;
	@FindBy(xpath="//*[@id='comment02']") 							WebElement addweddayTask;
	//Thursday
	@FindBy(xpath="//*[@id='thu_0']") 								WebElement thursdayTime;
	@FindBy(xpath="//*[@id='comment03']") 							WebElement addthursdayTask;
	//Friday
	@FindBy(xpath="//*[@id='fri_0']") 								WebElement fridayTime;
	@FindBy(xpath="//*[@id='comment04']") 							WebElement addFridaydayTask;
	//Saturday
	@FindBy(xpath="//*[@id='sat_0']") 								WebElement saturdayTime;
	@FindBy(xpath="//*[@id='comment05']") 							WebElement addsaturdayTask;
	@FindBy(xpath="//*[@id='saveTimeSheet']")					    WebElement Save_Button;
	@FindBy(xpath="//*[@id='submitTimeSheet']") 					WebElement Submit_Button;
	@FindBy(xpath="//*[@id='weekATC_0']") 							WebElement TotalATC;
	@FindBy(xpath="//*[@id='weekATC_1']") 							WebElement editedTotalATC;
	@FindBy(xpath="//*[@id='timesheet_view']/tbody/tr/td[2]") 		WebElement 	timesheetPeriod;


	//EditPage
	@FindBy(xpath="//*[@id='timesheet_new_projectDropDown_1']") 	WebElement editselectProject;
	@FindBy(xpath="//*[@id='timeTextBox_1']") 						WebElement editTask;
	@FindBy(xpath="//*[@id='mon_1']") 								WebElement editmondayTime;
	@FindBy(xpath="//*[@id='tue_1']") 								WebElement edittuesdayTime;
	@FindBy(xpath="//*[@id='wed_1']") 								WebElement editwednesdayTime;
	@FindBy(xpath="//*[@id='thu_1']") 								WebElement editthursdayTime;
	@FindBy(xpath="//*[@id='fri_1']") 								WebElement editfridayTime;
	@FindBy(xpath="//*[@id='sat_1']") 								WebElement editsaturdayTime;
	@FindBy(xpath="//*[@id='submitSavedTimeSheet']")			    WebElement editSubmit_Button;
	@FindBy(xpath="//*[@id='updateSavedTimeSheet']") 				WebElement editUpdate_Button;
	@FindBy(xpath="//*[@id='timesheet_view']/tbody/tr[1]/td[5]")    WebElement statusemployee;
	@FindBy(xpath="//*[@id='new_timesheetFor']") 					WebElement empName;
	@FindBy(xpath="//*[@id='weekpicker']") 							WebElement submittedTimePeriod;
	@FindBy(xpath="//*[@id='timesheet_new_row_1']/td[1]")			WebElement empProject;
	@FindBy(xpath="//*[@id='weekATC_1']") 							WebElement totalTime;
	@FindBy(xpath="//*[@id='main_Content']/div/div[1]/div[2]/button")WebElement backButton;
	
	// Reporting manager To_Handle
	@FindBy(xpath="//*[@id='timesheet_view_toApprove_filter']/label/input")	WebElement searchField;
	@FindBy(xpath="//*[@id='rmg_approve']")						 	WebElement approveTab;
	@FindBy(xpath="//*[@id='timesheet_view_toApprove']/tbody/tr[1]")WebElement selectEmpToApprove;
	@FindBy(xpath="//*[@id='timesheet_view_toApprove']/tbody/tr[1]/td[6]") WebElement StatusRMLevel;
	@FindBy(xpath = "//*[@id='timesheetCompOffYes']") 					WebElement compOff;
	@FindBy(xpath = "//*[@id='timesheetCompOffYes']") 					WebElement compOfftext;
	@FindBy(xpath = "//*[@id='approveTimesheet']") 					WebElement ApproveButton;
	@FindBy(xpath = "//*[@id='approveOpenedTimesheet']") 			WebElement ViewTimeshetAproveButtontRM;
	@FindBy(xpath = "//*[@id='timesheet_approve_Comment']") 		WebElement ApproveCommentsFrmRM;
	@FindBy(xpath = "//*[@id='addCommentForApprove']") 				WebElement SubmitButtonFrmRM;
	@FindBy(xpath = "//*[@id='rejectTimesheet']")					WebElement RejectIcon;
	@FindBy(xpath = "//*[@id='RejectOpenedTimesheet']") 			WebElement ViewTimeshetRejectButtnAtRM;
	@FindBy(xpath = "//*[@id='timesheet_reject_Comment']")		    WebElement RejectCommentsFromRM;
	@FindBy(xpath = "//*[@id='addCommentForReject']") 				WebElement SubmitRejectRM;
	@FindBy(xpath = "//*[@id='downloadReportTimesheet']") 			WebElement downloadTimesheet;
	@FindBy(xpath = "//*[@id='timesheetMonthYear']")			    WebElement searchYearMonthDownload;
	@FindBy(xpath = "//*[@id='downloadTimesheetReport']") 			WebElement donloadReport;
	@FindBy(xpath = "//*[@id='holdTimesheet']") 					WebElement holdTimesheetRM;
	
	//Assign Levelavailable
	@FindBy(xpath = "//*[@id='assignTimesheet']") 					WebElement Asgnntimesheet;
	@FindBy(xpath = "//*[@id='timesheet_assign_Comment']") 			WebElement coments;
	@FindBy(xpath = "//*[@id='addCommentForAssign']") 				WebElement SubmitBtn;
	// SPOC To_Handle
	@FindBy(xpath = "//*[@id='mySidenav']/li[4]/a")					WebElement MyTask;
	@FindBy(xpath = "//*[@id='rmg_approve']")						WebElement spocTo_Handle;
	@FindBy(xpath = "//*[@id='myTask_view_filter']/label/input") 	WebElement searchMyTask;
	@FindBy(xpath = "//*[@id='myTask_view']/tbody/tr[1]") 			WebElement selectTimesheetMyTask;
	@FindBy(xpath = "//*[@id='assignMyTask']")						WebElement assignmyTask;
	@FindBy(xpath = "//*[@id='timesheetCompOffYes']")				WebElement approveCompOff;	
	@FindBy(xpath = "//*[@id='timeSheetCompOff']/span")				WebElement compoff;	
	@FindBy(xpath = "//*[@id='viewMyTask']") 						WebElement viewTimesheetMyTask;
	@FindBy(xpath = "//*[@id='myTask_comment']") 					WebElement assignCommentsinMyTask;
	@FindBy(xpath = "//*[@id='myTaskForAssign']") 					WebElement submitCommentsMyTask;
	@FindBy(xpath = "//h4[text()='Comments']")						WebElement assignPopUp;
	@FindBy(xpath = "//*[@id='holdOpenedTimesheet']") 				WebElement holdSpocLevel;
	@FindBy(xpath = "//*[@id='myTask_view']/tbody/tr[1]/td[4]") 	WebElement statusinSpocLevel;
	@FindBy(xpath = "//*[@id='approveOpenedTimesheet']") 			WebElement approveTimesheetspocLevel;
	@FindBy(xpath = "//*[@id='RejectOpenedTimesheet']")				WebElement rejectTimesheetSpocLevel;
	@FindBy(xpath = "//*[@id='timesheet_approve_Comment']") 		WebElement timesheetApproveComments;
	@FindBy(xpath = "//*[@id='addCommentForApprove']") 				WebElement submitApprove;
	@FindBy(xpath = "//*[@id='timesheet_reject_Comment']") 			WebElement timesheetRejectComments;
	@FindBy(xpath = "//*[@id='addCommentForReject']") 				WebElement rejectSubmit;
	@FindBy(xpath = "//*[@id='myTask_view']/tbody/tr[1]/td[4]")			WebElement statusSpoc;
	//@FindBy(xpath = "//*[@id='timesheet_approve_Comment']") 		WebElement timesheetApproveComments;
	//@FindBy(xpath = "//*[@id='addCommentForApprove']") 			WebElement submitApprove;
	
	
	
	
	public void myLynx()
	{
		Waitfor(2);
		MyLynx.click();
		Waitfor(2);
		TimeSheets_Submodule.click();
		Waitfor(3);
		
	}
	
	public void newTimesheet(String selectDate, String projectName, String taskName, String monTime ,String tueTime , String wedTime , String thursTime ,  String friTime , String satTime, String MonTask, String TueTask,  String WedTask, String ThuTask, String FriTask, String SatTask)
	{
		
		try {
			
			boolean newTs=newTimesheet.isEnabled();
			if(newTs==true)
			{
				newTimesheet.click();
				logger.info("The New Timesheet button is enabled and clicked Successfully..!!!");
				Waitfor(2);
				Save_Button.click();
				Waitfor(2);
				Submit_Button.click();
				Waitfor(2);
				selectTimesheet.click();
				Waitfor(1);
				
				//Next_Button_Timesheet.click();
				List<WebElement> dates1 = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td"));

				int total_nodes1 = dates1.size();
				for (int i = 0; i < total_nodes1; i++)
				
				{
				String date1 = dates1.get(i).getText();
				int abc=Integer.valueOf(selectDate);
				
				if (date1.equals(Integer.toString(abc)))
				
				{
				dates1.get(i).click();
				logger.info("Selected date For Timesheet is: " + date1);
				break;
				}
				
				}
				
				Waitfor(2);
				Select oselect=new Select(selectProject);
				oselect.selectByVisibleText(projectName);
				Waitfor(2);
				selectTask.sendKeys(taskName);
				Waitfor(1);
				mondayTime.clear();
				Waitfor(1);
				mondayTime.sendKeys(monTime);
				Waitfor(1);
				addMondayTask.click();
				Waitfor(1);
				AllComments.sendKeys(MonTask);
				Waitfor(1);
				addComentsButton.click();
				Waitfor(1);
				
				tuesdayTime.clear();
				Waitfor(1);
				tuesdayTime.sendKeys(tueTime);
				Waitfor(1);
				addTuesdayTask.click();
				Waitfor(1);
				AllComments.sendKeys(TueTask);
				Waitfor(1);
				addComentsButton.click();
				Waitfor(1);
				
				wednesdayTime.clear();
				Waitfor(1);
				wednesdayTime.sendKeys(wedTime);
				Waitfor(1);
				addweddayTask.click();
				Waitfor(1);
				AllComments.sendKeys(WedTask);
				Waitfor(1);
				addComentsButton.click();
				Waitfor(1);
				
				thursdayTime.clear();
				Waitfor(1);
				thursdayTime.sendKeys(thursTime);
				Waitfor(1);
				addthursdayTask.click();
				Waitfor(1);
				AllComments.sendKeys(ThuTask);
				Waitfor(1);
				addComentsButton.click();
				Waitfor(1);
				
				fridayTime.clear();
				Waitfor(1);
				fridayTime.sendKeys(friTime);
				Waitfor(1);
				addFridaydayTask.click();
				Waitfor(1);
				AllComments.sendKeys(FriTask);
				Waitfor(1);
				addComentsButton.click();
				Waitfor(1);
				
				saturdayTime.clear();
				Waitfor(1);
				saturdayTime.sendKeys(satTime);
				Waitfor(1);
				addsaturdayTask.click();
				Waitfor(1);
				AllComments.sendKeys(SatTask);
				Waitfor(1);
				addComentsButton.click();
				Waitfor(1);
				
				String atcTime=TotalATC.getAttribute("value");
				logger.info("The Total Time From Monday To Friday is : "+atcTime);
				Waitfor(1);
				
				
			}else
			{
				logger.info("Failed to Click on New Timesheet Button..!!!");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void status()
	{
		Waitfor(2);
		String status=statusemployee.getText();
		logger.info("The Status once after Take Action is : "+status);
		Waitfor(2);
	}
	  
	public void saveTimesheet()
	{
		String selectTime=selectTimesheet.getAttribute("value");
		Waitfor(2);
		Save_Button.click();
		logger.info("The Timesheet is saved Successfully for the date of : "+selectTime);
		Waitfor(2);	
	}
	
	public String timesheetPeriod()
	{
	   Waitfor(2);
	   String timePeriod=timesheetPeriod.getText();
	   return timePeriod;
		
	}
	
	public void searchEmpTimesheet(String timeDates)
	{
		Waitfor(1);
		Search_Input_Box_Timesheet.sendKeys(timeDates);
		Waitfor(2);
	}
	
	public void selectTimesheet()
	{
		Waitfor(1);
		selectTheTimesheet.click();
		Waitfor(2);
	}
	
	public void editTimesheet(String editProject, String EditTask, String editMonTime , String editTueTime , String editWedTime , String editFriTime, String editThuTime, String editSatTime  )
	{
		
		try {
			
			boolean sts=EditTimesheet.isEnabled();
			if(sts==true)
			{
			   
			   EditTimesheet.click();
			   Waitfor(2);
		       Select oselect=new Select(editselectProject);
		       oselect.selectByVisibleText(editProject);
			   Waitfor(2);
			   editTask.sendKeys(EditTask);
			   Waitfor(2);
			   editmondayTime.clear();
			   Waitfor(1);
			   editmondayTime.sendKeys(editMonTime);
			   Waitfor(1);
			   edittuesdayTime.clear();
			   Waitfor(1);
			   edittuesdayTime.sendKeys(editTueTime);
			   Waitfor(1);
			   editwednesdayTime.clear();
			   Waitfor(1);
			   editwednesdayTime.sendKeys(editWedTime);
			   Waitfor(1);
			   editthursdayTime.clear();
			   Waitfor(1);
			   editthursdayTime.sendKeys(editThuTime);
			   Waitfor(1);
			   editfridayTime.clear();
			   Waitfor(1);
			   editfridayTime.sendKeys(editFriTime);
			   Waitfor(1);
			   editsaturdayTime.clear();
			   Waitfor(1);
			   editsaturdayTime.sendKeys(editSatTime);
			   Waitfor(1);
			   String editedatcTime=editedTotalATC.getAttribute("value");
			   logger.info("The Total Updated Time From Monday To Friday is : "+editedatcTime);
			   Waitfor(1);
			   
			   
			}else
			{
				logger.info("Failed to Click on Edit Timesheet Button...!!!!!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void updateTimesheet()
	{
		Waitfor(1);
		editUpdate_Button.click();
		Waitfor(2);
		logger.info("The Timesheet is Updated Successfully..!!!");
	}
	
	public void submitTimesheet()
	{
	   Waitfor(1);
	   boolean bln=Submit_Timesheet.isEnabled();
	   if (bln==true) 
	   {
		   Submit_Timesheet.click();
		   Waitfor(2);
		   logger.info("The TimeSheet is Updated Successfully....!!!!");
		   
	   } else 
	   {
          logger.info("Failed to Submit the Timesheet...!!!!");
          
	   }
		
	}
	
	
	public String viewTimesheet()
	{
		Waitfor(2);
		selectTheTimesheet.click();
		Waitfor(1);
		Actions oaction=new Actions(driver);
		oaction.doubleClick(selectTheTimesheet).build().perform();
		Waitfor(3);
	    String eName=empName.getText();
		logger.info("The Employee Name is :" +eName);
		Waitfor(1);
		String time=submittedTimePeriod.getAttribute("value");
		logger.info("The Selected Date For the Submitted Timesheet is : "+time);
		Waitfor(1);
		String project=empProject.getText();
		logger.info("The Employee in the Project of : "+project);
		Waitfor(1);
		String timeis=totalTime.getAttribute("value");
		logger.info("The Total Time from Monday to Friday is : "+timeis);
		Waitfor(1);
		backButton.click();
		
		return eName;
	}
	
	// RM Flow
	
	public void toApproveTab()
	{
		Waitfor(3);
		approveTab.click();
		logger.info("The Approve Tab is Clicked Successfully....!!!!");
		Waitfor(2);
	}
	
	
	public void searchToApproveTab(String timeDates)
	{
		Waitfor(1);
		searchField.sendKeys(timeDates);
		Waitfor(1);
	}
	public void selectEmpToApprove()
	{
		Waitfor(1);
		selectEmpToApprove.click();
		Waitfor(2);
	}
	
	public void statusrmLevel()
	{
		Waitfor(1);
		String sts=StatusRMLevel.getText();
		logger.info("The Status in RM Level Once after Take Action is :"+sts);
		Waitfor(1);	
	}
	
	
	public void assignrmLevel()
	{
		Waitfor(2);
		boolean status=Asgnntimesheet.isEnabled();
        if(status==true)
        {
        	Waitfor(2);
        	Asgnntimesheet.click();
            logger.info("The Assign Button is Enabled and Clicked Successfully....!!!");
            Waitfor(2);
            coments.sendKeys("The Timesheet is Assigned to Self Only....!!!!");
            Waitfor(2);
            SubmitBtn.click();
            Waitfor(2);
            logger.info("The Timesheet is Assigned successfully...!!");
        }else
        {
        	logger.info("Failed to click on Assign button....!!!");
        }
		
	}
	
	public void holdFunction()
	{
	   Waitfor(2);
	   boolean bln=holdTimesheetRM.isEnabled();
		if (bln==true) 
		{
			Waitfor(2);
			holdTimesheetRM.click();
			logger.info("The Timesheet Hold Button is Enabled and Submitted Successfully..!!");
			Waitfor(2);
			Alert oalert=driver.switchTo().alert();
			oalert.accept();
			Waitfor(2);
			logger.info("The Selected Timesheet is On Hold...!!");
		} else {

		}
	}
	
	public void approvermLevel()
	{
		Waitfor(1);
		boolean sts=ApproveButton.isEnabled();
		if(sts==true)
		{
			ApproveButton.click();
			Waitfor(2);
			logger.info("The Approve Button is enabled and Clicked successfully...!!");
			boolean bln=compOfftext.isDisplayed();
			if (bln==true) 
			{
				Waitfor(2);
				compOff.click();
				logger.info("The Comp off is Selected Successfully...!!");
				ViewTimeshetAproveButtontRM.click();
				Waitfor(2);
				ApproveCommentsFrmRM.sendKeys("The Timesheet is Approved by RM....!!! ");
				Waitfor(2);
				SubmitButtonFrmRM.click();
				logger.info("The Timesheet is Approved Successfully...!!! ");
				Waitfor(2);
			  
			} else 
			{
				Waitfor(2);
				logger.info("The Comp off is Not Displayed...!!");
				ViewTimeshetAproveButtontRM.click();
				Waitfor(2);
				ApproveCommentsFrmRM.sendKeys("The Timesheet is Approved by RM....!!! ");
				Waitfor(2);
				SubmitButtonFrmRM.click();
				logger.info("The Timesheet is Approved Successfully...!!! ");
				Waitfor(2);
			}
			
		}else
		{
			logger.info("Failed to Click on Approve Button....!!!");
			
		}
	}
	
	public void downloadTimesheetrmLevel(String SearchMonth, String SearchYear)
	{
		Waitfor(2);
		boolean bln=downloadTimesheet.isEnabled();
		if(bln==true)
		{
			downloadTimesheet.click();
			Waitfor(3);
			searchYearMonthDownload.sendKeys(SearchMonth+SearchYear);
			logger.info("The Selected Month is "+SearchMonth+" and Selected Year "+SearchYear+" To Download the Timesheet." );
			Waitfor(4);
			donloadReport.click();
			Waitfor(3);
			logger.info("The Timesheet is Downloaded Successfully....!!!");
		}else
		{
			logger.info("Failed to Click on Download Timesheet Button....!!!");
		}
		
		
	}
	

	public void resubmitTimesheet()
	{
		
		Waitfor(2);
		Submit_Timesheet.click();
		logger.info("Timesheet is Re-Submitted By Employee..!!!! ");
		Waitfor(2);
		
		
		
	}
	
	
	public void rejectrmLevel()
	{
		Waitfor(1);
		boolean sts=RejectIcon.isEnabled();
		if(sts==true)
		{
			Waitfor(2);
			RejectIcon.click();
			logger.info("The Reject Button is Enabled and Clicked successfully...!!!");
			Waitfor(2);
			ViewTimeshetRejectButtnAtRM.click();
			Waitfor(2);
			SubmitRejectRM.click();
			Waitfor(2);
			RejectCommentsFromRM.sendKeys("This Timesheet is Rejected BY RM.......!!!!");
			Waitfor(2);
			SubmitRejectRM.click();
			logger.info("This Timesheet is Rejected By RM.....!!!");
			Waitfor(2);
		}else
		{
			logger.info("Failed to Click on Reject Button....!!!");
			
		}
		
	}
	
	// SPOC Level 
	
	public void myTask()
	{
		Waitfor(2);
		MyTask.click();
		Waitfor(2);
		
	}
	
	public void searchMyTask(String empName)
	{
		Waitfor(1);
		searchMyTask.sendKeys(empName);
		Waitfor(1);
	}
	
	
	public void assignspocLevel()
	{
		Waitfor(2);
		selectTimesheetMyTask.click();
		Waitfor(3);
		assignmyTask.click();
		Waitfor(2);
		assignCommentsinMyTask.sendKeys("Timesheet is Assigned to Self Only...!!!!!");
		Waitfor(2);
		submitCommentsMyTask.click();
		Waitfor(1);
		
	}
	
	public void statusinSpocLevel()
	{
		
		String status=statusSpoc.getText();
		logger.info("The Status in SPOC Level Once after Take Action is :"+status);
		
	}
	
	public void holdspocLevel()
	{
		selectTimesheetMyTask.click();
		Waitfor(2);
		viewTimesheetMyTask.click();
		Waitfor(2);
		boolean sts=compoff.isDisplayed();
		if (sts==true) 
		{
			approveCompOff.click();
			Waitfor(2);
			holdSpocLevel.click();
			Waitfor(2);
			Alert olert=driver.switchTo().alert();
			olert.accept();
			Waitfor(2);
			logger.info("Compoff is Displayed and clicked successfully...!!");
		} else {
			Waitfor(2);
			logger.info("Compoff is not Displayed..!!!");
			Waitfor(2);
			holdSpocLevel.click();
			Waitfor(2);
			Alert olert=driver.switchTo().alert();
			olert.accept();
			Waitfor(2);
		}
	
	}
	
	public void approvespocLevel()
	{
		
		selectTimesheetMyTask.click();
		Waitfor(2);
		viewTimesheetMyTask.click();
		Waitfor(2);
		boolean sts=compoff.isDisplayed();
		if (sts==true) 
		{
			approveCompOff.click();
			logger.info("The Compoff Approved Successfully...!!!");
			Waitfor(2);
			approveTimesheetspocLevel.click();
			Waitfor(1);
			timesheetApproveComments.sendKeys("The Timesheet is Approved By SPOC Successfully...!!!");
			Waitfor(1);
			submitApprove.click();
			logger.info("The Timesheet is Approved Successfully...!!!!");
			
		} else {
	
			Waitfor(2);
			approveTimesheetspocLevel.click();
			Waitfor(1);
			timesheetApproveComments.sendKeys("The Timesheet is Approved By SPOC Successfully...!!!");
			Waitfor(1);
			submitApprove.click();
			logger.info("The Timesheet is Approved Successfully...!!!!");
			
		}
		
		
	}
	
		
  		
}
