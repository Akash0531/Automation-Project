package com.dikshatech.tst.objectrepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;

public class ServiceRequestObjects  extends TestBase 

{   
	@Test
	public ServiceRequestObjects (WebDriver driver)
	{
		this.driver = driver;		
		
	}
	
	// My Request Tab and Service Request SubTab 
	@FindBy(xpath="//*[@id='myrequests-link']/a") 				WebElement MyRequestTab;
	@FindBy(xpath="//*[@id='myrequests-link']/ul/a[2]/li") 		WebElement ServiceRequestSubTab;
	@FindBy(xpath="//*[@id='service_request']/tbody/tr[1]") 	WebElement SelectEmpMyRequest;
	@FindBy(xpath="//*[@id='assign_request']/tbody/tr[1]") 		WebElement ToHandleSelectEmp;
	@FindBy(xpath="//button[@id='CancelServiceRequest']") 		WebElement CancelRequest;
	@FindBy(xpath="//button[@id='CloseServiceRequest']") 		WebElement CloseRequest;
	@FindBy(xpath="//button[@id='ServiceReopenItrequest1']") 	WebElement Reopen_Request;
	 // New Request for Employee
	@FindBy(xpath="//button[@id='servicerequest']") 			WebElement NewRequest;
	@FindBy(xpath="//select[@id='issue_servicerequest']") 		WebElement IssueName;
	@FindBy(xpath="//input[@id='Servicereq_summery']") 			WebElement Summry;
	@FindBy(xpath="//textarea[@id='Servicereq_desc']") 			WebElement Descriptionss;
	@FindBy(xpath="//*[@id='dept_on']") 						WebElement dependantaOn;
	@FindBy(xpath="//*[@id='submitreq']") 						WebElement SubmitBttn;
	// View page at Employee  
	@FindBy(xpath="//*[@id='view_service_status']") 			WebElement ViewStatus;
	@FindBy(xpath="//*[@id='view_service_submission']") 		WebElement RequestedOn;
	@FindBy(xpath="//*[@id='main_Content']/div/div[1]/div[2]/button") 	WebElement BackButton;
	// Spoc Level
	@FindBy(xpath="//a[text()='To Handle']") 					WebElement ToHandleTab;
	@FindBy(xpath="//*[@id='assign_request']/tbody/tr[1]")     	WebElement SelectEmployee;
	@FindBy(xpath="//button[@id='service_appr_lea']") 			WebElement AssignIcon;
	@FindBy(xpath="//select[@id='service_assign']") 			WebElement AssignName;
	@FindBy(xpath="//select[@id='service_status']") 			WebElement StatusName;
	@FindBy(xpath="//textarea[@id='service_remarks']") 			WebElement Remarks;
	@FindBy(xpath="//button[text()='Submit']")					WebElement SubmitBttonn;
	@FindBy(xpath="//*[@id='estimate_date']") 					WebElement EstimatedDate;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div/a[2]") 		WebElement NextMonth;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[6]/a") WebElement SelectDate;
	
	//Employee Reopen 
	@FindBy(xpath="//*[@id='remark1']") 						WebElement ReOpenRemarks;
	@FindBy(xpath="//*[text()='Re-open']")	    	    		WebElement ReOpenButton;
	
	// My Request Tab and Service Request SubTab 
	
	public void myrequestTab()
	{
		MyRequestTab.click();
		Waitfor(2);
		
	}
	
	public void servicerequestSubTab()
	{
		ServiceRequestSubTab.click();
		Waitfor(2);
		
	}
	
	
	
	//Create Request From Employee
	public void newRequest()
	{
		NewRequest.click();
		Waitfor(1);
	}
	
	public void createRequest(String Issumename, String Summary, String Description, String Dependanta)
	{
		Waitfor(1);
		IssueName.sendKeys(Issumename);
		Waitfor(1);
		Summry.sendKeys(Summary);
		Waitfor(1);
		dependantaOn.sendKeys(Dependanta);
		Waitfor(1);
		Descriptionss.sendKeys(Description);
		Waitfor(2);
		
	}

	public void clickSubmitEmp()
	{
		SubmitBttn.click();
		Waitfor(2);
		logger.info("The Request is Created and Submitted succesfully...!!");
	}
	
	
	public void selectEmpMyRequestPage()
	{
		
		Waitfor(2);
		SelectEmpMyRequest.click();
		Waitfor(2);
	}
	
	public void statusAtEmp()
	{
		Waitfor(2);
		SelectEmpMyRequest.click();
		Waitfor(2);
		Actions oactions=new Actions(driver);
		oactions.doubleClick(SelectEmpMyRequest).build().perform();
		
		Waitfor(2);
		String viewstr=ViewStatus.getText();
		logger.info("The Status is :"+viewstr);
		Waitfor(2);
		String requestOn=RequestedOn.getText();
		logger.info("The requested date and Time is :"+requestOn);
		Waitfor(2);
		BackButton.click();
		Waitfor(3);
		
	}
	
	
	public void statusAtSpoc()
	{
		
		SelectEmployee.click();
		Waitfor(2);
		Actions oactions=new Actions(driver);
		oactions.doubleClick(SelectEmployee).build().perform();
		
		Waitfor(2);
		String viewstr=ViewStatus.getText();
		logger.info("The Status is :"+viewstr);
		Waitfor(2);
		String requestOn=RequestedOn.getText();
		logger.info("The requested date and Time is :"+requestOn);
		Waitfor(1);
		BackButton.click();
		
	}
	
	
	
	public void selectEmpToHandlePage()
	{
		Waitfor(1);
		ToHandleSelectEmp.click();
		Waitfor(1);
	}

	// SPOC Assign Level 
	
	public void toHandle()
	{
		
		ToHandleTab.click();
		Waitfor(2);
	}
	
	public void toClickAssign()
	{
		
		AssignIcon.click();
		
	}
	
	public void assignTo( String Remarkss)
	{
		
	    Waitfor(1);
	    Select Status=new Select(StatusName);
	    Status.selectByVisibleText("Assigned");
	    Waitfor(1);
	    Remarks.sendKeys(Remarkss);
		Waitfor(2);
		SubmitBttonn.click();
		logger.info("The Request is Assigned Successfully.....!!!!!");
		Waitfor(1);
	}
	
	
	
	public void toClickAssignIcon()
	{
		
		AssignIcon.click();
		
	}
	
	public void SPOCInprogressLevel( String ResolveDate, String Remark)
	{
	
	    Select Status=new Select(StatusName);
	    Status.selectByVisibleText("In-progress");
	    Waitfor(1);
	    EstimatedDate.click();
	    Waitfor(1);
		//PreviousMonth();

		//NextMonth();
		List<WebElement> dates1 = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_nodes1 = dates1.size();
		//logger.info("Calendar Date size is : " + total_nodes1);
		for (int i = 0; i < total_nodes1; i++)
		
		{
		String date1 = dates1.get(i).getText();
		// dates.get(i).click();
		// logger.info("Selected date is: "+date);
		int abc=Integer.valueOf(ResolveDate);
		
		if (date1.equals(Integer.toString(abc)))
		
		{
		dates1.get(i).click();
		logger.info("Selected date For Resolution is: " + date1);
		break;
		}
		
		}
	  
	    Waitfor(1);
	    Remarks.sendKeys(Remark);
		Waitfor(1);
		SubmitBttonn.click();
		Waitfor(2);
		logger.info("The Request is In Progress Level....!!!!");
		
	}
	
	
	public void SPOCResolveLevel(String Remark)
	{
		
	    Waitfor(1);
	    Select Status=new Select(StatusName);
	    Status.selectByVisibleText("Resolved");
	    Waitfor(1);
	    Remarks.sendKeys(Remark);
	    SubmitBttonn.click();
		Waitfor(2);
		logger.info("The Request is Resolved Sucessfulyy....!!!!");
		
	}
	
	//cancel Functionality
	
	public void cancelFunction()
	{
	   Waitfor(2);	
	   CancelRequest.click();
	   Waitfor(2);
	   logger.info("The Request is Cancelled Suceefully...!!!!");
		
	}
	
	//Close Functionality
	public void closeFunction()
	{
			Waitfor(2);
			CloseRequest.click();
			Waitfor(2);
			logger.info("The Request is Closed Succeefully..!!");
			Waitfor(2);
	}
		
		
		// Re Open Functionality From Employee
		public void reOpenFunction()
		{
			Waitfor(2);
			Reopen_Request.click();
			Waitfor(2);
			ReOpenRemarks.sendKeys("This Request is not Resolved so ReOpened Again..!!"); 
			Waitfor(2);
			ReOpenButton.click();
			Waitfor(1);
			logger.info("The Request Is Reopenend Successfully...!!!");
			Waitfor(3);
		}
		
	
	
	
}
