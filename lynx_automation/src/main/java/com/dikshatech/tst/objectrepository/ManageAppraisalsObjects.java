package com.dikshatech.tst.objectrepository;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class ManageAppraisalsObjects extends TestBase {
	
    JavascriptExecutor jse= (JavascriptExecutor)driver;
	   
		@Test
		public ManageAppraisalsObjects (WebDriver driver)
		{
			this.driver = driver;		
			
		}
		
		//Manage Appraisal Object Repository(RMG User)
		
		@FindBy(xpath="//a[contains(.,'RMG')]")                                WebElement RMG;
		@FindBy(xpath="//span[contains(.,'Manage Appraisals')]")               WebElement Manage_Appraisals_Submenu;
		@FindBy(xpath="//button[@id='newmanageapp']")                          WebElement New_Appraisals_Button;
		@FindBy(xpath="//button[@id='editmanageapp']")                         WebElement Edit_Appraisals_Button;
		@FindBy(xpath="//button[@id='delmanageapp']")                          WebElement Delete_Appraisals_Button;
		@FindBy(xpath="//button[@id='manageAppRmgFeedBackReport']")            WebElement Download_RMG_Feedback_Report;
		@FindBy(xpath="//button[@id='manageAppReport']")                       WebElement Appraisal_Report;
		@FindBy(xpath="//button[@id='manageAppRmgFeedBackReport']")            WebElement View_RMG_Feedback_Report;
		@FindBy(xpath="//button[@id='manageAppReport']")                       WebElement View_RMG_Report;
		@FindBy(xpath="//button[@onclick='manageAppProjectsUploadPopUp()']")   WebElement Upload_Projects;
		@FindBy(xpath="//button[@onclick='manageAppBillDaysUploadPopUp()']")   WebElement Upload_BillableDays;
		@FindBy(xpath="//select[@id='manageAppraisalYear']")                   WebElement Appraises_Year;
		@FindBy(xpath=".//*[@id='manageAppraisalTerm']")                       WebElement Appraises_Term;
		@FindBy(xpath="//select[@id='manageAppraisalHandler']")                WebElement Appraises_Handler;
		@FindBy(xpath="//select[@id='manageAppraisalCompany']")                WebElement Appraises_Company;
		@FindBy(xpath="//select[@id='manageAppraisalRegion']")                 WebElement Appraises_Region;
		@FindBy(xpath="//select[@id='manageAppraisalDepartment']")             WebElement Appraises_Department;
		@FindBy(xpath="//select[@id='manageAppraisalDivision']")               WebElement Appraises_Category;
		@FindBy(xpath="//input[@id='manageAppraisalStDate']")                  WebElement Appraises_StartDate;
		@FindBy(xpath="//input[@id='manageAppAppraiseeDueDate']")              WebElement Appraisee_DueDate;
		@FindBy(xpath="//input[@id='manageAppAppraiserDueDate']")              WebElement Appraiser_DueDate;
		@FindBy(xpath="//button[@onclick='AddNewAppraiser()']")                WebElement AddAppraiser_Button;
		@FindBy(xpath="//select[@id='manageAppraisalAppraiser1']")             WebElement select_Appraiser_DD;
		@FindBy(xpath="//input[contains(@aria-controls,'appraisallist')]")     WebElement search_employee;
		@FindBy(xpath="//input[@aria-controls='manageAppraisal_home']")        WebElement search_appraisee;
		@FindBy(xpath="//select[@id='tobeapprised2type4']")                    WebElement AppraisalType_DD;
		@FindBy(xpath="//td[contains(.,'Manjunatha M')]")                      WebElement Sourse_Location;
		@FindBy(xpath=".//*[@id='tobeapprised1']/thead/tr/th[3]")              WebElement Destination_Location;
		@FindBy(xpath="//button[@onclick='onManageAppraisalSave()']")          WebElement Save_Button;
		@FindBy(xpath="//button[@class='btn btn-primary back-btn']")           WebElement Cancel_Button;
		@FindBy(xpath="//span[@class='process']")                              WebElement successful_msg;
		@FindBy(xpath="//button[@id='edit_appraisal_save']")                   WebElement update_appraisee;
		@FindBy(xpath="//a[contains(.,'Appraiser and Employee')]")             WebElement apraiseeandemployees;
		@FindBy(xpath="//a[contains(.,'Grid View')]")                          WebElement gridview;
		@FindBy(xpath=".//*[@id='main_Content']/div/div[1]/div[1]/h4")         WebElement view_apraisee;
		@FindBy(xpath="//button[@id='manageAppRmgFeedBackReportView']")        WebElement _RMG_Feedback_Report;
		@FindBy(xpath="//button[@id='manageAppReportView']")                   WebElement _RMG_Report;
		@FindBy(xpath="//input[@id='uploadfileName']") 				           WebElement upload_browse;
		@FindBy(xpath="//button[@id='manageAppProjectsUpload']") 		       WebElement upload_project;
		@FindBy(xpath="//button[@id='manageAppBillDaysUpload']") 		       WebElement upload_billable;
		@FindBy(xpath="//button[@id='manageAppDeleteFinal']") 		           WebElement delete_button;
		


		
		
		public void rmg_module()
		{
			RMG.click();
			Waitfor(2);
		}
		public void click_ManageAppraisal_submenu()
		{
			Manage_Appraisals_Submenu.click();
			Waitfor(2);
		}
		public void addingnewAppraises(String Year,String Term,String Handler, String Company,String Region,String Department
			,int appraisee_date,int appraiser_date, int T_Date , String Appriaser ,String candname)
		{
			
			New_Appraisals_Button.click();
			Waitfor(2);
			Select YearDD = new Select(Appraises_Year);
			Waitfor(2);
			logger.info("Selected Year is "+ Year);
			YearDD.selectByVisibleText(Year);
			Waitfor(2);
			Select TermDD = new Select(Appraises_Term);
			logger.info("Selected month is "+ Term);
			TermDD.selectByVisibleText(Term);
			Waitfor(2);
			Select HandlerDD = new Select(Appraises_Handler);
			logger.info("Selected handler is "+ Handler);
			HandlerDD.selectByVisibleText(Handler);
			Waitfor(4);
			Select CompanyDD = new Select(Appraises_Company);
			logger.info("Selected Company is "+ Company);
			CompanyDD.selectByVisibleText(Company);
			Waitfor(2);
			Select RegionDD = new Select(Appraises_Region);
			logger.info("Selected Region is "+ Region);
			RegionDD.selectByVisibleText(Region);
			Waitfor(2);
			Select DepartmentDD = new Select(Appraises_Department);
			logger.info("Selected department  is "+ Department);
			DepartmentDD.selectByVisibleText(Department);
			Waitfor(2);
			
			Appraises_StartDate.click();
			
			List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

			int total_nodes = dates.size();
			logger.info("Calendar Date size is : " + total_nodes);
			for (int i = 0; i < total_nodes; i++) {
				String date = dates.get(i).getText();
				
				if (date.equals(Integer.toString(T_Date)))
				{
					dates.get(i).click();
					logger.info("Selected date is: " + date);
					break;

				}
			}
			Waitfor(2);

			Appraisee_DueDate.click();
			
			List<WebElement> dates1 = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

			int total_nodes1 = dates1.size();
			logger.info("Calendar Date size is : " + total_nodes1);
			for (int i = 0; i < total_nodes1; i++) {
				String date1 = dates1.get(i).getText();
				
				if (date1.equals(Integer.toString(appraiser_date)))
				{
					dates1.get(i).click();
					logger.info("Selected date is: " + date1);
					break;

				}
			}
			Waitfor(2);
			Appraiser_DueDate.click();
			
			List<WebElement> dates2= driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

			int total_nodes2 = dates2.size();
			logger.info("Calendar Date size is : " + total_nodes2);
			for (int i = 0; i < total_nodes2; i++) {
				String date2 = dates2.get(i).getText();
				
				if (date2.equals(Integer.toString(appraisee_date)))
				{
					dates2.get(i).click();
					logger.info("Selected date is: " + date2);
					break;
				}	
		}
			Waitfor(2);			
			AddAppraiser_Button.click();
			Waitfor(2);
			Select AppriaserDD = new Select(select_Appraiser_DD);
			logger.info("Selected appraiser is "+ Appriaser);
			AppriaserDD.selectByVisibleText(Appriaser);
			Waitfor(2);
					search_employee.sendKeys(Keys.chord(Keys.CONTROL, "a"),candname);
					Waitfor(1);
					Actions action = new Actions(driver);
					int count = 0;
					String candidateID= "";
					String col_text = "Employee ID";
					List<WebElement> page = driver.findElements(By.xpath("//div[@id='appraisallist_paginate']/span/a"));
					if (page.size() > 0) {
					for (int i = 1; i <=page.size(); i++) 
					{
						if(i>1)
						{	
						driver.findElement(By.xpath("//div[@id='appraisallist_paginate']/span/a[" + (i) + "]")).click();
						Waitfor(1);
						}
					WebElement table = driver.findElement(By.xpath("//table[@id='appraisallist']/thead/tr"));
					List<WebElement> heading = table.findElements(By.tagName("th"));
					for (int h = 0; h < heading.size(); h++) {
						String text = heading.get(h).getText();
						if (col_text.equalsIgnoreCase(text)) {
							int col = h;
							WebElement row_table = driver.findElement(By.xpath("//table[@id='appraisallist']/tbody"));
							List<WebElement> rows = row_table.findElements(By.tagName("tr"));
							logger.info(rows.size());
							for (int c = 1; c <= rows.size(); c++) {
								
								String cell_Value = driver
										.findElement(By.xpath("//table[@id='appraisallist']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
										.getText();
								Waitfor(2);
								
								if (cell_Value.equalsIgnoreCase(candname)) {
									
									WebElement report= driver.findElement(By.xpath("//table[@id='appraisallist']/tbody/tr[" + c + "]/td[1]"));
									action.click(report).build().perform();
									Waitfor(2);
									candidateID= report.getText();
									logger.info("The newly created Candidate ID is: "+candidateID);
									boolean select =report.isSelected();
									if(select == true)
									{
								
									logger.info("  employee is displayed under Leave page and status is :"  );
									Waitfor(2);						
									}
									else
									{
									logger.info("employee button is not present in Leave page and status is :");
									}
									count++;
									
								action.dragAndDrop(report, Destination_Location).build().perform();
							    Waitfor(2);
							    Save_Button.click();					
								}
								else 
								{
								logger.info("No candidate record found with "+candname+ "name" );
								}
							}
							if(count>0)
							{
							break;
							}
						}
						else 
							{
							logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");	
							}
					    }		
						if(count>0)
						{
						break;
						}
						}
							
					}
					
					
				}		
		public String EditingApprisals(String Term)
		{
			search_appraisee.sendKeys(Keys.chord(Keys.CONTROL, "a"),Term);
			Waitfor(1);
			Actions action = new Actions(driver);
			int count = 0;
			String fail= "";
			String col_text = "Appraisal Term";
			List<WebElement> page = driver.findElements(By.xpath("//div[@id='manageAppraisal_home_paginate']/span/a"));
			if (page.size() > 0) {
			for (int i = 1; i <=page.size(); i++) 
			{
				if(i>1)
				{	
				driver.findElement(By.xpath("//div[@id='manageAppraisal_home_paginate']/span/a[" + (i) + "]")).click();
				Waitfor(1);
				}
			WebElement table = driver.findElement(By.xpath("//table[@id='manageAppraisal_home']/thead/tr"));
			List<WebElement> heading = table.findElements(By.tagName("th"));
			for (int h = 0; h < heading.size(); h++) {
				String text = heading.get(h).getText();
				if (col_text.equalsIgnoreCase(text)) {
					int col = h;
					WebElement row_table = driver.findElement(By.xpath("//table[@id='manageAppraisal_home']/tbody"));
					List<WebElement> rows = row_table.findElements(By.tagName("tr"));
					logger.info(rows.size());
					for (int c = 1; c <= rows.size(); c++) {
						
						String cell_Value = driver
								.findElement(By.xpath("//table[@id='manageAppraisal_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
								.getText();
						Waitfor(2);
							
						if (cell_Value.equalsIgnoreCase(Term)) {
							
							WebElement report= driver.findElement(By.xpath("//table[@id='manageAppraisal_home']/tbody/tr[" + c + "]/td[1]"));
							action.click(report).build().perform();
							Waitfor(2);
						String term= report.getText();
						logger.info("selected term is " + term);
				// Edit button validation
				boolean editbutton= Edit_Appraisals_Button.isDisplayed();
				if (editbutton == true) 
				{
			
				logger.info(" edit button is displayed under employee page and status is :" + editbutton);
				Waitfor(2);						
				}
				else
				{
				logger.info("edit button is not present in candidate page and status is :" + editbutton);
				}
				
				count++;
						}
						else 
						{
						logger.info("No candidate record found with "+Term+ "name" );
						}
					}
					if(count>0)
					{
					break;
					}
				}
				else 
					{
					logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");	
					}
			    }		
				if(count>0)
				{
				break;
				}
				}
					
			}
			return fail ;
			
			
		}

			
			
		

		public void click_on_update_button()
		{
			Edit_Appraisals_Button.click();
			Waitfor(2);
			Select TermDD = new Select(Appraises_Term);
			logger.info("Selected month is  November");
			TermDD.selectByVisibleText("November");
			Waitfor(2);
			update_appraisee.click();
		}
		

		public void download_RMGFeedback()
		{
			Actions action = new Actions(driver);
			Waitfor(1);

			action.keyDown(Keys.LEFT_CONTROL).click(Download_RMG_Feedback_Report).keyUp(Keys.LEFT_CONTROL).build().perform();
			Waitfor(1);

		}
		public void view_RMGFeedback()
		{
			View_RMG_Feedback_Report.click();
			Waitfor(1);
		}
		public void download_RMGReport()
		{
			Actions action = new Actions(driver);
			Waitfor(1);

			action.keyDown(Keys.LEFT_CONTROL).click(Appraisal_Report).keyUp(Keys.LEFT_CONTROL).build().perform();
			Waitfor(1);
			
		}
		public void view_RMGReport()
		{
			View_RMG_Report.click();
			Waitfor(1);
		}
		public void projectsupload()
		{
			Upload_Projects.click();
			  Waitfor(2);
				upload_browse.sendKeys("/home/nfshome/sumalatha.pattem/Downloads/2018_January.xls");
				logger.info("Upload Button is not enabled");
			upload_project.click();
		    Waitfor(2);
			
			
		}
		public void billabledaysupload()
		{
			Upload_BillableDays.click();
			Waitfor(1);
			upload_browse.sendKeys("/home/nfshome/sumalatha.pattem/Downloads/02018_January.xls");
			Waitfor(1);
			upload_billable.click();
		    Waitfor(2);
		}
		public void deleteAppraisals()
		{
			
			Delete_Appraisals_Button.click();
			Waitfor(2);
			driver.findElement(By.xpath("//input[@id='select_all']")).click();
			Waitfor(2);
			delete_button.click();
			Waitfor(1);
			driver.findElement(By.xpath("//button[@id='deleteConfirmManageAppraisal']")).click();
			
		}
		

}