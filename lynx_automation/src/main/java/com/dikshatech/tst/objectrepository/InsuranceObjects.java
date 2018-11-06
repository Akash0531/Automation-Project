package com.dikshatech.tst.objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class InsuranceObjects extends TestBase
{
	String report_id= null;
	
	@Test
	public  InsuranceObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@id='myfinancials-link']/a") 				WebElement My_Finacials;
	@FindBy(xpath="//*[@id='myfinancials-link']/ul/a[3]/li") 		WebElement InsurancePolicy;
	@FindBy(xpath="//*[@id='added']") 					 			WebElement ToHandleTab;
	@FindBy(xpath="//*[@id='ass_lea']") 					    	WebElement AssignIcon;
	
	//Employee Level Insurance Submission
	
	@FindBy(xpath="//*[@id='home']/div[1]/button[1]") 			 WebElement NewAvailInsuRequest;
	@FindBy(xpath="//button[@onclick='addEmployeeInsuranceInfo()']") WebElement AddInsurance;
	@FindBy(xpath="//*[@id='home']/div[1]/button[2]") 				 WebElement editinsurance;
	@FindBy(xpath="//*[@id='name']") 								 WebElement InsuredPersionName;
	@FindBy(xpath="//*[@id='relationship']") 						 WebElement RelationShip;
	@FindBy(xpath="//input[@id='datepickerinsurancedob']") 			 WebElement InsuredDOB;
	@FindBy(xpath="//select[@id='gender']") 						 WebElement SelectGender;
	@FindBy(xpath="//select[@id='policyType']") 					 WebElement SelectPolicy;
	@FindBy(xpath="//input[@id='insuranceCoverage']") 				 WebElement InsuranceCoverageAmt;
	@FindBy(xpath="//input[@id='from1']") 							 WebElement CoverageDateFrom;
	@FindBy(xpath="//input[@id='to1']") 							 WebElement CoverageDateTo;
	@FindBy(xpath="//textarea[@id='deliveryAddress']") 				 WebElement Address;
	@FindBy(xpath="//*[@id='insurancesubmit_new']") 				 WebElement ClickSubmit;
	
	
	//SPOC Assign and Approve Functionality
	@FindBy(xpath="//*[@id='ass_lea']") 							WebElement SelectAction;
	@FindBy(xpath="//*[@id='insurance_assign_comments']") 			WebElement Comments;
	@FindBy(xpath="//*[@id='insuranceassign_assign']") 				WebElement ClickSubmitt;
	
	@FindBy(xpath="//*[@id='policy_number_assign_isurance']") 		WebElement policyNumassign;
	@FindBy(xpath="//*[@id='insurance_card_id']") 					WebElement Cardid;
	@FindBy(xpath="//*[@id='insurance_basic_premium']") 			WebElement BasicAmt;
	@FindBy(xpath="//*[@id='insurance_service_tax']")				WebElement ServiceeTax;
	@FindBy(xpath="//*[@id='insurance_total_premium']") 			WebElement TotalAmt;
	@FindBy(xpath="//*[@id='insuranceassign_assign_doctype']") 		WebElement submitDuringApprove;
	
	@FindBy(xpath="//*[@id='insurance_select_action']") 			WebElement apprejetassignDrpdwn;
	@FindBy(xpath="//*[@id='insurance_comments']")				    WebElement rejectComments;
	@FindBy(xpath="//*[@id='insuranceassign_assign_doctype']") 		WebElement submitDuringReject;
	@FindBy(xpath="//*[@id='reimbursement_to_handle']/thead/tr/th[8]") WebElement statusSpocLevel;
	
	
	// Provide Insurance Functionality
	
	@FindBy(xpath="//*[@id='to_handle']/div[1]/button[1]")   WebElement ProvideInsuIcon;
	@FindBy(xpath="//*[@id='insurance_provide_to']")		 WebElement SelectEmp;
	@FindBy(xpath="//*[@id='Policy_number']") 				 WebElement PolicyNum;
	@FindBy(xpath="//*[@id='Insurance_Coverage1']") 		 WebElement InsuCoverage1;
	@FindBy(xpath="//*[@id='Coverage_Period_From1']") 		 WebElement InsuCoverageFrom1;
	@FindBy(xpath="//*[@id='Coverage_Period_To1']") 		 WebElement InsuCoverageTo1;
	@FindBy(xpath="//*[@id='Card_Id1']")			 		 WebElement CardID1;
	@FindBy(xpath="//*[@id='Basic_Premium1']") 				 WebElement BasicAmt1;
	@FindBy(xpath="//*[@id='Service_Tax1']") 				 WebElement ServTax1;
	@FindBy(xpath="//*[@id='Total_Premium1']")				 WebElement TotalPremiumTax1;
	
	@FindBy(xpath="//*[@id='Insurance_Coverage2']") 		 WebElement InsuCoverage2;
	@FindBy(xpath="//*[@id='Coverage_Period_From2']") 		 WebElement InsuCoverageFrom2;
	@FindBy(xpath="//*[@id='Coverage_Period_To2']") 		 WebElement InsuCoverageTo2;
	@FindBy(xpath="//*[@id='Card_Id2']")					 WebElement CardID2;
	@FindBy(xpath="//*[@id='Basic_Premium2']")	 			 WebElement BasicAmt2;
	@FindBy(xpath="//*[@id='Service_Tax2']")		 		 WebElement ServTax2;
	@FindBy(xpath="//*[@id='Total_Premium2']") 				 WebElement TotalPrmiumTax1;
	@FindBy(xpath="//*[@id='insurancesubmit_provide']")      WebElement ClickSubmitProvideInsu;
	
	
	
	
	public void MyFinacialTab()
	{
		
		My_Finacials.click();
		Waitfor(1);
	}
	
	public void InsuranceTab()
	{
		InsurancePolicy.click();
		Waitfor(1);
		
	}
	
	
	// Employee level Raise Insurance Request.
	public void NewInsuranceRequest(String PersionName, String RelationshipName, String Selectgender, String Selectpolicy, String InsuCoverageAmt, String address)
	{
		
		NewAvailInsuRequest.click();
		InsuredPersionName.sendKeys(PersionName);
		
		Select oselect=new Select(RelationShip);
		oselect.selectByVisibleText(RelationshipName);
		

		WebElement DOBtable= driver.findElement(By.xpath("//table[@id='avail_insurance_table1']/tbody"));
	    List<WebElement> DOBrows  = DOBtable.findElements(By.tagName("tr"));
		logger.info("No. of rows in expense table are: "+DOBrows.size());
		for(int r=1; r<DOBrows.size(); r++)
		{	
			   
			Actions action= new Actions(driver);
			
			 WebElement col =driver.findElement(By.xpath("//table[@id='avail_insurance_table1']/tbody/tr[" +(r+1)+ "]/td[1]"));
			   col.click();
			   
			   
			   List<WebElement> date = driver.findElements(By.xpath("//div[@id='datepickerinsurancedob']/table/tbody/tr/td"));
				
				int Total_nodes= date.size();
				logger.info("Calendar Date size is : "+Total_nodes);
				 for(int i=0; i<Total_nodes; i++)
				 {
					 String date1= date.get(i).getText();
//					 dates.get(i).click();
//					 logger.info("Selected date is: "+date);
					 if(date.equals(Integer.toString(i+1)))
					 {
						date.get(i).click();
						logger.info("Selected date is: "+date1);
						break;
						
					 }
				  }
		}
		
		
		Select select=new Select(SelectGender);
		select.selectByVisibleText(Selectgender);
		
		
		Select sel=new Select(SelectPolicy);
		sel.selectByVisibleText(Selectpolicy);
		
		
		InsuranceCoverageAmt.sendKeys(InsuCoverageAmt);
		
		
		
		
		WebElement CPF= driver.findElement(By.xpath("//table[@id='avail_insurance_table2']/tbody"));
	    List<WebElement> CPFrows1  = CPF.findElements(By.tagName("tr"));
		logger.info("No. of rows in expense table are: "+CPFrows1.size());
		for(int r=1; r<CPFrows1.size(); r++)
		{	
			   
			Actions action= new Actions(driver);
			
			 WebElement col1 =driver.findElement(By.xpath("//table[@id='avail_insurance_table2']/tbody/tr[" +(r+1)+ "]/td[1]"));
			   col1.click();
			   
			   
			   List<WebElement> dates = driver.findElements(By.xpath("//div[@id='from1']/table/tbody/tr/td"));
				
				int total_nodes= dates.size();
				logger.info("Calendar Date size is : "+total_nodes);
				 for(int i=0; i<total_nodes; i++)
				 {
					 String date= dates.get(i).getText();
//					 dates.get(i).click();
//					 logger.info("Selected date is: "+date);
					 if(date.equals(Integer.toString(i+1)))
					 {
						dates.get(i).click();
						logger.info("Selected date is: "+date);
						break;
						
					 }
				  }
		}
		
		
		
		
		WebElement CPTtable1= driver.findElement(By.xpath("//table[@id='avail_insurance_table2']/tbody"));
	    List<WebElement> CPTrows1  = CPTtable1.findElements(By.tagName("tr"));
		logger.info("No. of rows in expense table are: "+CPTrows1.size());
		for(int r=1; r<CPTrows1.size(); r++)
		{	
			   
			Actions action= new Actions(driver);
			
			 WebElement col2 =driver.findElement(By.xpath("//table[@id='avail_insurance_table2']/tbody/tr[" +(r+1)+ "]/td[1]"));
			   col2.click();
			   
			   
			   List<WebElement> dates = driver.findElements(By.xpath("//div[@id='to1']/table/tbody/tr/td"));
				
				int total_nodes= dates.size();
				logger.info("Calendar Date size is : "+total_nodes);
				 for(int i=0; i<total_nodes; i++)
				 {
					 String date= dates.get(i).getText();
//					 dates.get(i).click();
//					 logger.info("Selected date is: "+date);
					 if(date.equals(Integer.toString(i+1)))
					 {
						dates.get(i).click();
						logger.info("Selected date is: "+date);
						break;
						
					 }
				  }
		}
		
		Address.sendKeys(address);
		ClickSubmit.click();
		
	}
	
	
	// SPOC Level Assign  Self
	
	
	public void SPOCAssignLevel()
	{
		My_Finacials.click();
		Waitfor(1);
		
		InsurancePolicy.click();
		Waitfor(1);
		
	}
	
	public void ClickToHandle()
	{
		ToHandleTab.click();
		
	}
	
	public void Pagination() 
	
	{
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
	
	
	// Assign Spurthi SB xYZZZZZZ
	public void ClickAssign(String SelectActionToDo, String Commentss )
	{
		
		AssignIcon.click();
		
		Select Se=new Select(SelectAction);
		Se.selectByVisibleText(SelectActionToDo);
		
		
		//Select Sel=new Select(AssignedName);
		//Sel.selectByVisibleText(AssignName);
		
		Comments.sendKeys(Commentss);
		ClickSubmitt.click();
		
	}
	

	
	//Approve Level
	public void ClickToHandleAtApprove()
	{
		ToHandleTab.click();
		
	}
	
	public void PaginationAtApprove() 
	
	{
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
	
	public void AprroveFunctionality(String ActionToDo, String CardID, String BasicPremium, String SerTax, String TotalAmount )
	{
		AssignIcon.click();
		Waitfor(1);
		Select Se=new Select(SelectAction);
		Se.selectByVisibleText(ActionToDo);
		Waitfor(1);
		
		Cardid.sendKeys(CardID);
		Waitfor(1);
		BasicAmt.sendKeys(BasicPremium);
		Waitfor(1);ServiceeTax.sendKeys(SerTax);
		TotalAmt.sendKeys(TotalAmount);
		ClickSubmitt.click();
	}
	
	// Provide Insurance Functionality
	
	
	
	
	
	
}
