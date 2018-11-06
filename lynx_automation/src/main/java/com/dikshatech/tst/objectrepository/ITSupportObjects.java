package com.dikshatech.tst.objectrepository;

import java.awt.Desktop.Action;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.pageFatory.TestBase;

public class ITSupportObjects extends TestBase 

{
  
	@Test
	public ITSupportObjects (WebDriver driver)
	{
		this.driver = driver;		
		
	}
	
	String requestnum="";
	
	// Tab and Subtab
	@FindBy(xpath = "//span[contains(.,'My Requests')]") 		WebElement MyRequest;
	@FindBy(xpath = "//span[contains(.,'IT Support')]") 		WebElement ITSupport;
	@FindBy(xpath = "//button[@id='EditItrequest']") 			WebElement editRequest;
	@FindBy(xpath = "//button[@id='DeleteItrequest']") 			WebElement DeleteRequest;
	@FindBy(xpath = "//button[@id='CancelItrequest']") 			WebElement cancelRequest;
	@FindBy(xpath = "//button[@id='CloseItrequest']") 			WebElement closeRequest;
	@FindBy(xpath = "//*[@id='ReopenItrequest1']") 				WebElement Reopnn;
	@FindBy(xpath = "//*[@id='itrequest_home_filter']/label/input") WebElement searchField;
	@FindBy(xpath = "//*[@id='attachment']") 					WebElement UploadButton;
	@FindBy(xpath = "//*[@id='view_attachment']") 				WebElement Downloadfile;

	// To Create a new IT Service Request
	@FindBy(xpath = "//button[@id='NewItrequest']") 			WebElement NewITRequest;
	@FindBy(xpath = "//*[@id='category']")   		   			WebElement SelectCategory;
	@FindBy(xpath = "//input[@id='summary']")       			WebElement Summryy;
	@FindBy(xpath = "//*[@id='description']") 					WebElement Descption; 
	@FindBy(xpath = "//input[@id='attachment']")      			WebElement upload;
	@FindBy(xpath = "//*[@id='comments']") 						WebElement commentss;
	@FindBy(xpath = "//*[@id='applysubmit']") 					WebElement Submit;
	@FindBy(xpath = "//*[text()='Save']") 						WebElement saveRequest;
	@FindBy(xpath = "//*[@id='editupdate']") 					WebElement UpdateButton;
	@FindBy(xpath = "//*[@id='edit_description']") 					WebElement EditDescption;
	@FindBy(xpath = "//*[@id='edit_comments']") 					WebElement EditComments;
	// To search 
	@FindBy(xpath = "//*[@id='itrequest_home_filter']/label/input") WebElement SearchText;
	@FindBy(xpath = "//*[@id='added']") 							WebElement Employee_Name;
	@FindBy(xpath = "//*[@id='added']") 						    WebElement RequestTab;
	@FindBy(xpath = "//*[@id='appr_lea']") 							WebElement AssignClick;
	
	// Details and status view page  
	@FindBy(xpath = "//*[@id='view_status']") 						WebElement ViewStatus;
	@FindBy(xpath = "//*[@id='view_req']") 							WebElement RequestedOn;
	@FindBy(xpath = "//*[@id='main_Content']/div/div[1]/div[2]/button")	WebElement BackButton;
	
	// Admin to Assign Level 
	@FindBy(xpath = "//*[@id='itrequest_assign']/tbody/tr[1]")  	WebElement SelectEmpRequestTab;
	@FindBy(xpath = "//select[@id='assign_to']") 					WebElement DropDownAssgn1stTime;
	@FindBy(xpath = "//select[@id='status_list']") 					WebElement DropDownStatus1stTime;
	@FindBy(xpath = "//*[@id='itrequestremarks']") 					WebElement Remarks;
	@FindBy(xpath = "//*[@id='main_Content']/div/div[3]/div/button")		WebElement Submitt;
	
	// Admin Close In-progress and Resolved 
	@FindBy(xpath = "//select[@id='assign_to']") 						WebElement DrpDownAssgn2nd;
	@FindBy(xpath = "//select[@id='status_list']") 						WebElement DrpDownStatus2nd;
	@FindBy(xpath = "//*[@id='itrequestremarks']") 				    	WebElement RemarksFrmCloser;
	@FindBy(xpath = "//*[@id='defaultForm']/table[2]/tbody/tr[9]/td[3]/button")		WebElement Submitt_Finally;
	@FindBy(xpath = "//*[@id='empName']") 					            WebElement EmpName;
	@FindBy(xpath = "//*[@id='empId']") 					           WebElement EmployeeID;
	
     // Re-Open From Employee
	@FindBy(xpath = "//*[@id='itrequest_home']/tbody/tr[1]") 			WebElement SelectEmpAtHomePage;
	@FindBy(xpath = "//*[@id='remark']") 								WebElement ReopenComments;
	@FindBy(xpath = "//*[@id='reopenItrequest']") 						WebElement ReopenSubmit;
	
	@FindBy(xpath = "//*[@id='itrequest_home']/tbody/tr[1]/td[1]") 		WebElement requestid;
	@FindBy(xpath = "//*[@id='itrequest_assign_filter']/label/input") 		WebElement searchrequest;
	
	
	
	// Employee Level To Create Request
	public void clickMyRequest()
	{
		MyRequest.click();
		Waitfor(1);	
		
	}
	
	public void itSupport()
	{
		
		ITSupport.click();
		Waitfor(3);	
		
	}
	
	public void newRequest()
	{
		Waitfor(2);
		NewITRequest.click();
		
		
	}
	
	public void searchfield(String searchCandidate)
	{
		Waitfor(2);
		searchField.sendKeys(searchCandidate);
		Waitfor(1);
	}
	
	public void uploadFile()
	{
		Waitfor(2);
		UploadButton.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadPDF")).getAbsolutePath());
		Waitfor(2);
		
	}
	
	
	// Request Support name: SVN, SOftware, Hardware 
	
	public void raise_Request(String RequestingSupport,String summry, String Description, String comments )
	{
	
		Waitfor(2);
		Select Catgry = new Select(SelectCategory);
		Waitfor(2);	
		//Catgry.selectByIndex(a);
		Catgry.selectByVisibleText(RequestingSupport);
		Waitfor(2);
		Summryy.sendKeys(summry);
		Waitfor(3);
		UploadButton.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadPDF")).getAbsolutePath());
		Waitfor(2);
		Descption.sendKeys(Description);
		Waitfor(2);	
		commentss.sendKeys(comments);
		Waitfor(2);
	}
	
	public void saveRequest()
	{
		saveRequest.click();
		Waitfor(3);	
		logger.info("Request is Saved Successfully");
	}
	
	public void deleteRequest()
	{
		boolean status=DeleteRequest.isEnabled();
		if(status==true)
		{
			DeleteRequest.click();
			Waitfor(3);	
			logger.info("Request is Deleted Successfully");
		}else
		{
			logger.info("Delete is not enabled ");
		}		
		
	}
	
	public void submit()
	{
		
			Submit.click();
			logger.info("New Service Request is Created and Submitted Succesfull");
			Waitfor(3);	
	}
	
	  
	
	public void editRequest()
	{
		boolean status=editRequest.isEnabled();
		if(status==true)
		{
			editRequest.click();
			Waitfor(3);	
			EditDescption.clear();
			Waitfor(2);
			EditDescption.sendKeys("Old Data Is Cleared and New data is added");
			Waitfor(2);
			EditComments.clear();
			Waitfor(2);
			EditComments.sendKeys("Edit is SuccessFull");
			Waitfor(2);
			logger.info("Request is Edited Successfully");
			UpdateButton.click();
			Waitfor(3);
			logger.info("Request is Updated Sucessfully");
		}else
		{
			logger.info("Edit is not enabled ");
		}
			
		
	}
	
	
	public void checkStatusByEmp()
	{
		Waitfor(1);
		SelectEmpAtHomePage.click();
		Waitfor(1);
		Actions oactions=new Actions(driver);
		oactions.doubleClick(SelectEmpAtHomePage).build().perform();
		
		Waitfor(2);
		String viewstr=ViewStatus.getText();
		logger.info("The Status is At Employee Level:"+viewstr);
		Waitfor(2);
		Downloadfile.click();
		Waitfor(2);
		String requestOn=RequestedOn.getText();
		logger.info("The requested date and Time is at Employee Level :"+requestOn);
		Waitfor(2);
		BackButton.click();
		Waitfor(2);
		
		
	}
	
	public String requestID()
	{
		
		requestnum=requestid.getText();
		return requestnum;
		
	}
	
	public void searchmethod(String Requestid)
	{
		Waitfor(1);
		searchrequest.sendKeys(Requestid);
		Waitfor(2);
		
	}
	
	public void checkStatusAtAdmin()
	{
		SelectEmpRequestTab.click();
		
		Actions oactions=new Actions(driver);
		oactions.doubleClick(SelectEmpRequestTab).build().perform();
		Waitfor(2);
		String viewstr=ViewStatus.getText();
		Waitfor(2);
		logger.info("The Status is in Admin Level :"+viewstr);
		Downloadfile.click();
		Waitfor(2);
		String requestOn=RequestedOn.getText();
		logger.info("The requested date and Time is at Admin Level :"+requestOn);
		Waitfor(2);
		BackButton.click();
		Waitfor(2);
	}
	
	
	
	
	public void cancelFunction()
	{
		boolean status=cancelRequest.isEnabled();
		if(status==true)
		{
			cancelRequest.click();
		}else
		{
			logger.info("Cancel is not enabled ");
		}
			
		
	}
	
	public void closeFunction()
	{
		boolean status=closeRequest.isEnabled();
		if(status==true)
		{
			closeRequest.click();
		}else
		{
			logger.info("Close is not enabled ");
		}
			
		
	}
	
	
	// Admin Level To Assigned Functionality
	
	public void requestTab()
	{
		Waitfor(2);
		RequestTab.click();
		Waitfor(1);
	}
	
	public void selectEmployeeRequestTab()
	{
		
		SelectEmpRequestTab.click();
		Waitfor(1);
	}
	
	
	
	public void clickAssign()
	{
		AssignClick.click();
		Waitfor(1);
		//logger.info("Assign is Clicked successful");
		
	}

	
	
	public void adminAssignLevel()
	{		

		    Waitfor(1);
		    Select StatusName=new Select(DropDownStatus1stTime);
		    StatusName.selectByVisibleText("Assigned");
		    Waitfor(2);
		    Remarks.sendKeys("This is during assigned Level....");
		    Waitfor(1);
		   
	}
	
	public void submitDuringAssign()
	{
		Submitt.click();
		 Waitfor(3);
		 logger.info("The Request is Assigned Successfully...!!!");
	}
	
	
	// Admin To Close or In-progress and Resolved 
	
	public void adminLevel(String Statusname, String Rmarkss )
	{
			
		String EmployeeName=EmpName.getText();
		logger.info("The Request is Raised By Employee is :"+EmployeeName);
		
		String EmpID=EmployeeID.getText();
		logger.info("The Employee ID is :"+EmpID);
		Waitfor(2);
		
	    Select Status=new Select(DrpDownStatus2nd);
	    Status.selectByVisibleText(Statusname);
	    Waitfor(2);
	    
	    Remarks.sendKeys(Rmarkss);	
	    Waitfor(2);
	
	}
	

	public void submitatResolveLevel()
	{
		
		Submitt.click();
		Waitfor(3);
		logger.info("The Request Is Resolved Successfully");
	}
	
	
	public void selectEmpHomePage()
	{
		
		SelectEmpAtHomePage.click();
		Waitfor(1);
	}
	
	public void reopenIcon()
	{
		
		Waitfor(1);
		Reopnn.click();
		Waitfor(2);
			
		
	}
	
	public void reopenRequest()
	{
		ReopenComments.sendKeys("The Request is not Resolved So Now am Reopening");
		Waitfor(2);
		ReopenSubmit.click();
		Waitfor(3);
		logger.info("The Request is Re-Opened Successfully");
	}

	public void closeBrowser()
	{
		Waitfor(1);
		driver.close();
		Waitfor(2);
		logger.info("Browser is Closed Succefully....!!!");
	}
	
}
