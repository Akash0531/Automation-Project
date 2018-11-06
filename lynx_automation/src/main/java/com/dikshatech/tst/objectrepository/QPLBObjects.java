package com.dikshatech.tst.objectrepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class QPLBObjects  extends TestBase 
{
@Test

public QPLBObjects(WebDriver driver)
		{
			this.driver = driver;
			
		}
			
//RM VALIDATION//

		@FindBy(xpath = "//span[contains(.,'Bonus Reconciliation')]") WebElement Bonus_reconcilation;
		@FindBy(xpath = "//th[contains(.,'ID')]") WebElement Id;
		@FindBy(xpath = "//th[contains(.,'Term')]") WebElement TERM;
		@FindBy(xpath = "//th[contains(.,'Month')]") WebElement MONTH;
		@FindBy(xpath = "//th[contains(.,'Year')]") WebElement YEAR;
		@FindBy(xpath = "//th[contains(.,'Submitted Date')]") WebElement SUBMITTED_DATE;
		@FindBy(xpath = "//th[contains(.,'Status')]") WebElement Status;
		@FindBy(xpath = "//button[@id='salAction']") WebElement double_clcickon_employee;
		@FindBy(xpath = "//button[@id='salAction']") WebElement rmview_table;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Employee_Id;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Employee_Name;
		@FindBy(xpath = "//button[@id='salAction']") WebElement QPLB_Amount;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Designation;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Percentage;
		@FindBy(xpath = "//button[@id='salAction']") WebElement enter_Percentage;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Comments;
		@FindBy(xpath = "//button[@id='salAction']") WebElement RM_Status_view;
		 @FindBy(xpath = "//button[@id='salAction']") WebElement Approve_button;
		 @FindBy(xpath = "//button[@id='salAction']") WebElement Back_Button;
		@FindBy(xpath = "//button[@id='salAction']") WebElement save;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Edit;
	
		@FindBy(xpath = "//button[@id='salAction']") WebElement close_button;
		
		
		@FindBy(xpath = "//button[@id='salAction']") WebElement RM_STASTUS;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Enter_comment;
		
		@FindBy(xpath = "//button[@id='salAction']") WebElement details_icon;
		@FindBy(xpath = "//button[@id='salAction']") WebElement view_QPLBdetails ;
		@FindBy(xpath = "//button[@id='salAction']") WebElement LWP;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Project_Rollon_details;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Leave_details;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Appraisal_detailsANDsalaryrevision_details;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Employee_Dateof_Joining;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Employee_Dateof_exit;
		@FindBy(xpath = "//button[@id='salAction']") WebElement QPLB_No_OfDays;
		@FindBy(xpath = "//button[@id='salAction']") WebElement close;
		@FindBy(xpath = "//button[@id='salAction']") WebElement NextTable_Button;
		@FindBy(xpath = "//button[@id='salAction']") WebElement PreviousTable_Button;
	    
	    //Specialist rmg validation//
		@FindBy(xpath = "//button[@id='salAction']") WebElement rmgview_table;
	    @FindBy(xpath = "//button[@id='salAction']") WebElement Managername;
	    
	    @FindBy(xpath = "//button[@id='salAction']") WebElement Categeory;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Recommended_QPLB;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Corp;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Consulting;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Agile_Labs;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Service_Delivery;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Busines; 
		@FindBy(xpath = "//button[@id='salAction']") WebElement RMG;
		@FindBy(xpath = "//button[@id='salAction']") WebElement TAT;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Finance;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Status_view;
		@FindBy(xpath = "//button[@id='salAction']") WebElement RMs_name ;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Approved_;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Pending;
		@FindBy(xpath = "//button[@id='salAction']") WebElement REJECT;
		
		// Old stackup_salary//
		
		@FindBy(xpath = "//button[@id='salAction']") WebElement RMG_module;
		@FindBy(xpath = "//button[@id='salAction']") WebElement employees;
		@FindBy(xpath = "//button[@id='salAction']") WebElement select_employee;
		@FindBy(xpath = "//button[@id='salAction']") WebElement edit_employee;
		@FindBy(xpath = "//button[@id='salAction']") WebElement financialinfo;
		
		@FindBy(xpath = "//button[@id='salAction']") WebElement Salary_stackup;
		
		@FindBy(xpath = "//button[@id='salAction']") WebElement old_stackup;

		@FindBy(xpath = "//button[@id='salAction']") WebElement new_stackup;
		
		@FindBy(xpath = "//button[@id='salAction']") WebElement Current_CTC;
		
		@FindBy(xpath = "//button[@id='salAction']") WebElement Effected_from;
		
		@FindBy(xpath = "//button[@id='salAction']") WebElement Totalperformance_linkedbonus;
		@FindBy(xpath = "//button[@id='salAction']") WebElement QPLB1;
		@FindBy(xpath = "//button[@id='salAction']") WebElement APLB;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Esic;		
		@FindBy(xpath = "//button[@id='salAction']") WebElement Auto_calculate;

		@FindBy(xpath = "//button[@id='salAction']") WebElement Total_bonus_amount;
		
		@FindBy(xpath = "//button[@id='salAction']") WebElement Total_QPLBAmount_perQuarter;
		@FindBy(xpath = "//button[@id='salAction']") WebElement Total_QPLB_Amount;
		
		
		@FindBy(xpath = "//button[@id='salAction']") WebElement QPLB_calculated_no_ofdays;
		@FindBy(xpath = "//button[@id='salAction']") WebElement no_of_days_per_quarter;
		@FindBy(xpath = "//button[@id='salAction']") WebElement no_ofdays_worked;
		@FindBy(xpath = "//button[@id='salAction']") WebElement  employees_DOJ;
		@FindBy(xpath="//buton[@id='salAction']")WebElement Appraisals;
		@FindBy(xpath="//buton[@id='salAction']")WebElement RETENSION_BONUS;
		@FindBy(xpath="//buton[@id='salAction']")WebElement AUTOCALCULATE;
		@FindBy(xpath="//buton[@id='salAction']")WebElement Retention_Bonus_installments;
		@FindBy(xpath="//buton[@id='salAction']")WebElement Count_Dropdown;
		@FindBy(xpath="//buton[@id='salAction']")WebElement effected_from;
		
		
		//Intiate QPLB Report
		
				@FindBy(xpath = "//button[@id='salAction']") WebElement Initiate_Qplb;
				
				// Check complted 45 Days
				
				@FindBy(xpath = "//button[@id='salAction']") WebElement DateJoining;
				
				
				//edit and Modify QPLB
				@FindBy(xpath = "//button[@id='salAction']") WebElement editQPLB;
				@FindBy(xpath = "//button[@id='salAction']") WebElement modifyQPLB;
				@FindBy(xpath = "//button[@id='salAction']") WebElement holdQPLB;
				@FindBy(xpath = "//button[@id='salAction']") WebElement deletQPLB;
				
				//Validate Approve
				@FindBy(xpath = "//button[@id='salAction']") WebElement Approved;
				
				
				
				//QPLB amount should capture form financial info module
				@FindBy(xpath = "//button[@id='salAction']") WebElement QPLBFinacial;
				@FindBy(xpath = "//button[@id='salAction']") WebElement empModleQPLB;
				
				@FindBy(xpath = "//button[@id='salAction']") WebElement	QPLB_Days;
				
				//RMG/Lead RMG should able to view the list of employees in the following categories
				@FindBy(xpath = "//button[@id='salAction']") WebElement qplbCorp;
				@FindBy(xpath = "//button[@id='salAction']") WebElement consolting;
				@FindBy(xpath = "//button[@id='salAction']") WebElement agileLabs;
				@FindBy(xpath = "//button[@id='salAction']") WebElement ServiceDelivery;
				@FindBy(xpath = "//button[@id='salAction']") WebElement business;
				@FindBy(xpath = "//button[@id='salAction']") WebElement BenchEmp;
				@FindBy(xpath = "//button[@id='salAction']") WebElement resigned;
				@FindBy(xpath = "//button[@id='salAction']") WebElement ViewCorp;
				@FindBy(xpath = "//button[@id='salAction']") WebElement ViwCosltng;
				@FindBy(xpath = "//button[@id='salAction']") WebElement ViewAglLab;
				@FindBy(xpath = "//button[@id='salAction']") WebElement ViwDelvey;
				@FindBy(xpath = "//button[@id='salAction']") WebElement Viwbusines;
				@FindBy(xpath = "//button[@id='salAction']") WebElement Viewbench;
				@FindBy(xpath = "//button[@id='salAction']") WebElement Viewresgn;

		
		
				
		public void object_init_creation()
		{
			ObjectInitClass.homepage(driver);
			ObjectInitClass.loginpage(driver);
			ObjectInitClass.leaves(driver);
			ObjectInitClass.reimbursement(driver);
			ObjectInitClass.timesheet(driver);
		}
		
		
		//RM//
		
		public void My_Lynx()
	    {
	    	WebElement lynx= driver.findElement(By.xpath("//a[@id='collapseexample']"));
	    	lynx.click();
	    	Waitfor(2);
	    }
	    
		
	    public void RM_userlogin()
		{
	    	
	    	
	    	Bonus_reconcilation.click();
	    	Waitfor(2);
		}
	    
	    //Bonus Reconciliation homepage validation
	    
	    public void Bonus_Reconciliation_homepage()
	    {
	    	
			  WebElement Table = driver.findElement(By.id("QPLB"));
			   List<WebElement> rowVals = Table.findElements(By.tagName("tr"));
			   logger.info(rowVals);

			   int colNum = driver.findElements(By.xpath("//table[@id='QPLBView']/tbody/tr[2]/td")).size();
			   int rowNum = driver.findElements(By.xpath("//table[@id='QPLBView']/tbody/tr")).size();
			   logger.info("Total number of ro~~~~~~~~~~ws = " + rowNum);
			   logger.info("Total number of columns = " + colNum);
			   List<WebElement> colHeader = rowVals.get(0).findElements(By.tagName("th"));
			   //Loop through the header values and print them to console
			   logger.info("Header values:");
			   for(int i=0; i<colHeader.size(); i++){
			     logger.info(colHeader.get(i).getText());
			   }
			   logger.info("---------------");
			   //Loop through the remaining rows
			   for(int i=1; i<rowNum; i++){
			     //Get each row's column values by tag name
			     List<WebElement> colVals = rowVals.get(i).findElements(By.tagName("td"));
			     //Loop through each column
			     for(int j=0; j<colNum; j++){
			       //Print the coulumn values to console
			       logger.info(colVals.get(j).getText());
			       
			     }
			   }
	    }
	    public String qplb_table1(String id, String status)
		{
			Actions action = new Actions(driver);
			String col_text = "ID";
			logger.info("kya hai "+id);
			int count = 0;
			List<WebElement> page = driver.findElements(By.xpath("//div[@id='QPLB_home_paginate']/span/a"));
			
			for (int i = 0; i <= page.size(); i++) 
			{
				if(i>0)
				{	
				driver.findElement(By.xpath("//div[@id='QPLB_home_paginate']/span/a[" + (i+1) + "]")).click();
				Waitfor(1);
				}
			WebElement table = driver.findElement(By.xpath("//table[@id='QPLB_home']/thead/tr"));
			List<WebElement> heading = table.findElements(By.tagName("th"));
			for (int h = 0; h < heading.size(); h++) {
				String text = heading.get(h).getText();
				logger.info("Okay"+text);
				if (col_text.equalsIgnoreCase(text)) {
					WebElement row_table = driver.findElement(By.xpath("//table[@id='QPLB_home']/tbody"));
					List<WebElement> rows = row_table.findElements(By.tagName("tr"));
					logger.info("Dekho"+rows.size());
					for (int c = 1; c < rows.size(); c++) {
						
						String cell_Value = driver
								.findElement(By.xpath("//table[@id='QPLB_home']/tbody/tr[" + c + "]/th[" + (h+1) + "]"))
								.getText();
						Waitfor(2);
						logger.info("Should come"+cell_Value);
						String array[] = { "Report Generated", "Approved", "Rejected", "Completed", "Submitted" };
						
						if (cell_Value.equalsIgnoreCase(id)) {
							
							WebElement report= driver.findElement(By.xpath("//table[@id='QPLB_home']/tbody/tr[" + c + "]/th[1]"));
							
							action.doubleClick(report).build().perform();
							Waitfor(2);
							
							// Edit button validation
							boolean approve_button = Approve_button.isDisplayed();
							if (approve_button == true) {
								logger.info("Approve button is displayed and status is :" + approve_button);
								Waitfor(2);
								
							} else {
								logger.info("Approve button is not present in QPLB Edit page and status is :" + approve_button);
							}
							logger.info("The request status is "+cell_Value);
							count++;
							break;
						}
						else 
							
							{
								logger.info("There is no record matched with the passsed status");
								
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
			return col_text;
	}
				public void status_check (String report_ID, String Status)
				{
					Actions action = new Actions(driver);
					int count = 0;
					String id=null;
					String col_text = "Status";
					List<WebElement> page = driver.findElements(By.xpath("//div[@id='QPLB_home_paginate']/span/a"));
					if (page.size() > 0) {
					for (int i = 1; i < page.size(); i++) 
					{
					if(i>1)
					{	
					driver.findElement(By.xpath("//div[@id='QPLB_home_paginate']/span/a[" + (i+1) + "]")).click();
					Waitfor(1);
					}
					WebElement table = driver.findElement(By.xpath("//table[@id='QPLB_home']/thead/tr"));
					List<WebElement> heading = table.findElements(By.tagName("th"));
					for (int h = 1; h < heading.size(); h++) {
						String text = heading.get(h).getText();
						if (col_text.equalsIgnoreCase(text)) {
							int col = h;
							WebElement row_table = driver.findElement(By.xpath("//table[@id='QPLB_home']/tbody"));
							List<WebElement> rows = row_table.findElements(By.tagName("tr"));
							logger.info(rows.size());
							for (int c = 1; c < rows.size(); c++) {
								
								String cell_Value = driver
										.findElement(By.xpath("//table[@id='QPLB_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]"))
										.getText();
								Waitfor(2);
								String array[] = { "Report Generated", "Approved", "Rejected", "Completed", "Submitted" };
								
								if (cell_Value.equalsIgnoreCase(report_ID)) {
									
									WebElement report= driver.findElement(By.xpath("//table[@id='QPLB_home']/tbody/tr[" + c + "]/th[1]"));
									action.click(report).build().perform();
									Waitfor(2);
									String  s= driver.findElement(By.xpath("//table[@id='QPLB_home']/tbody/tr[" + c + "]/th[7]")).getText();
									if(s.equalsIgnoreCase(Status))
									{
									logger.info("Status is matching with the passed status & Status is "+s);
									action.doubleClick(report).build().perform();
									Waitfor(2);
									
									// Edit button validation
									boolean approve_button = Approve_button.isDisplayed();
										if (approve_button == true) {
											logger.info("Button is displayed and status is :" + approve_button);
											Waitfor(2);
											
										}
										else
										{
											logger.info("Button is not present in QPLB page and status is :" + approve_button);
										}
										logger.info("The request status is "+cell_Value);
										count++;
										
										Back_Button.click();
										break;
									}
									else 
									{
									logger.info("Status passed is not matching & the status is : "+s);
									}
				
									
								}
								else 
									
									{
									logger.info("There is no record matched with the passsed & status Report-ID");

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
				}
				
	    public void Pagination() {
			List<WebElement> page = driver.findElements(By.xpath("//div[@id='qplb_home_paginate']/span/a"));
			String text1;
			String text2;
			if (page.size() > 0) {
				for (int i = 0; i < page.size(); i++) {
					text1 = "//div[@id='qplb_home_paginate']/span/a[";
					text2 = "";
					driver.findElement(By.xpath("//div[@id='qplb_home_paginate']/span/a[" + (i + 1) + "]")).click();
					Waitfor(2);
				}
				for (int j = page.size(); j >= 0; j--) 
				{
					driver.findElement(By.xpath("//div[@id='qplb_home_paginate']/span/a[" + (j) + "]")).click();
					Waitfor(2);
				}
				
			} else {
				logger.info("There is no Pagination number present");
			}
		}
	    public void Next_Table() {
			boolean status = NextTable_Button.isEnabled();
			logger.info("Kya hai Status_Next-->" + status);
			if (status == true) {
				NextTable_Button.click();
			} else {
				logger.info("Next button is not enabled");
			}
		}

		public void Previous_Table() {
			boolean status = PreviousTable_Button.isEnabled();
			logger.info("Kya hai Status_Pre-->" + status);
			if (status == true) {
				PreviousTable_Button.click();
			} else {
				logger.info("Previous button is not enabled");
			}
		}
		

public void QPLB_Amount_capturing()

{
	
	String amount= QPLB_Amount.getText();
	float qplb= floatconversion(amount);

	String  Total_Amount=  Total_QPLB_Amount.getText();
	float tot_amnt= floatconversion(Total_Amount);

	String total_bonus_amount=Total_bonus_amount.getText();
	float qplb_bonus_amnt= floatconversion(total_bonus_amount);
    String   amount_per_quarter=Total_QPLBAmount_perQuarter.getText();
    float qplb_per_quarter= floatconversion(amount_per_quarter);
    
    float tot_amnt1 = (75/100)*qplb_bonus_amnt;
  
    float  qplb_per_quarter1 =  tot_amnt1/4;

		if(amount==amount_per_quarter)
		{
		logger.info("QPLB Amount is "+  amount);
		}
		else
		{
			logger.info("QPLB Amount is not displayed");
		}
}
	   
public void enter_percentage_rm(String percentage)
{
String percentage1 =Percentage.getText(); 

	if (percentage1.equalsIgnoreCase ("Percentage"))
	{
		enter_Percentage.sendKeys(Keys.chord(Keys.CONTROL, "a"),percentage);
		
	}
	else
	{
		logger.info("percentage is not present");
		
	}
}
			
 public void enter_comments_rm(String comments )
 
	    {
	    	boolean comments_field =Comments.isDisplayed();
			if (comments_field == true)
	    	{
				Comments.sendKeys(Keys.chord(Keys.CONTROL, "a"), comments);
	    	
	    	}
			else
			{
				logger.info("system not found comments");
			}
			}
	public void RM_status(String status_type) 
	{
		boolean enter_status=RM_STASTUS.isDisplayed();
		
		if(enter_status==true)
		{
			Select dropdown = (Select) (driver.findElement(By.xpath("RM_STASTUS")));
			dropdown.selectByVisibleText(status_type);
			Waitfor(1);
		}
		
	}
	   
	   
	    public void save_details_rm()
	    {
	    	save.click();
	    }
	    
//Specialist RMG 
	    
	    
public void SPECIALISTRMG_login()
{
	object_init_creation();
	
	// Read Excel object creation to pass the sheet parameter.
	String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
	Waitfor(1);
	String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
	Waitfor(1);
	//Login with Speacilalist RMZ for initiating the QPLB.
	ObjectInitClass.LP.signIn(username, password);
	Waitfor(3);
	
	ObjectInitClass.HP.My_Lynx();
	Bonus_reconcilation.click();

	Waitfor(2);	
	
	String report_id= qplb_table1("29","Report Generated");
	logger.info("Current QPLB generated Report ID is : "+report_id);
	Waitfor(2);
	enter_percentage_rm("50");
	enter_comments_rm("good");
	RM_status("approved");
	save_details_rm();
}

	public void RM_name_RMGVIEW()
	{
		
		boolean status_view1 =RMs_name.isDisplayed();
		if (status_view1 == true)
		{
			String  RMsname= RMs_name.getText();
		}
		else
		{
			logger.info("RM name is not found");
		}
	
	
}


			
			
		//CEO//
			
			
			
public void CEO_userlogin()
{
	object_init_creation();
	
	String username4= excelreaddata().getData("Login_Credentials", 5, 0 ); //Reading Username from excel
	Waitfor(1);
	String password4= excelreaddata().getData("Login_Credentials", 5, 1 ); //Reading Password from excel
	Waitfor(1);
	
	ObjectInitClass.LP.signIn(username4, password4);
	Waitfor(2);
	ObjectInitClass.HP.My_Lynx();
	Bonus_reconcilation.click();
	Waitfor(2);
	String report_id= qplb_table1("29","Report Generated");
	Waitfor(2);
	save_details_rm();

	
	
}




//dinesh code//

// QPLB Initiate codes...... (Reference Dinesha ) 
public void validate_Report(int T, int expHoliday, int actHoliday)
{
	//int T=30;// payment_date
	int Res=T-10;

	
	if(Res==20)
	{
		logger.info("The report is generated  on T-10 Days"+Res);
		Initiate_Qplb.click();
	}
	
	if(expHoliday==actHoliday)
	{
	   int prvosday=expHoliday-1;
		
	
			logger.info("Payment date is shifted to holidya date-1"+prvosday);
			Initiate_Qplb.click();
		
	}else
	{
		logger.info("Payment date is 25 only");
		Initiate_Qplb.click();
	}
}
	


public void Complteduration()
{
	
	 String JoinDate=DateJoining.getText();
	 
	 StringBuffer abc=new StringBuffer(JoinDate);
	 StringBuffer strBuf=abc.append(" 10:31:48");
	 String dateStart=strBuf.toString();
	
	 
	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	 Date date = new Date();
	 String datestop=dateFormat.format(date);
	   
	
	   
	 Date d1 = null;
	 Date d2 = null;
	   
	 try
	 {
	   d1 = dateFormat.parse(dateStart);
	   d2 = dateFormat.parse(datestop);
	   
	   long diff = d2.getTime() - d1.getTime();
	   
	   long diffSeconds = diff / 1000 % 60;
	   long diffMinutes = diff / (60 * 1000) % 60;
	   long diffHours = diff / (60 * 60 * 1000) % 24;
	   long diffDays = diff / (24 * 60 * 60 * 1000);
	   
	   long numOfDays=diffDays;
	   
	   if(numOfDays>=45)
	   {
		   logger.info("He is Eligable for QPLB and Working Dyas is:"+numOfDays);
	   }else
	   {
		   logger.info("He is NOT Eligable for QPLB because working days is:"+numOfDays);
	   }
	 
	   
	   
	 }
	 catch(Exception e)
	 {
		e.printStackTrace(); 
	 }
	 
	 
}


public void EmpDetails(String EMPDetails )
{
	
	//String Emp_id="1192";
	//String Empname="Arun";
	//String Desg="Test Engineer";
	//String Projct="Agile Lpbs";
	//String QPLBaMT="5000";
	//String perctage="60%";
	//String cmmts="average";
	
	List<WebElement> rowCollection =driver.findElements(By.tagName("tr"));

	int i_RowNum=1;
for(WebElement rowElement:rowCollection)
{
      List<WebElement> colCollection=rowElement.findElements(By.xpath("td"));
      int i_ColNum=1;
      for(WebElement colElement:colCollection)
      {
    	  String tabledata=colElement.getText();
    	  
    	  if(EMPDetails.equalsIgnoreCase(tabledata))
    	  {
    		  logger.info("Employee Details is Preasent"); 
    		  
    	  }else
    	  {
    		  
    		  logger.info("Employee Details is NOT  ViwCorpPreasent"); 
    		  
    	  }
    	  
           logger.info("Row "+i_RowNum+" Column "+i_ColNum+" Data "+colElement.getText());
          
           i_ColNum=i_ColNum+1;
       }
    i_RowNum=i_RowNum+1;
 }
	
}	




    //QPLB amount should capture form financial info module

	public void QPLBFinacial()
	{
		
		String EmpMdQplb=empModleQPLB.getText();
		boolean str=QPLBFinacial.isDisplayed();
		if(str==true)
		{
			String strQPLBfina=QPLBFinacial.getText();
				
		   if(strQPLBfina.equalsIgnoreCase(EmpMdQplb))
		   {
			   logger.info("QPLB Amount from Financial Info:"+strQPLBfina); 
		   }
			
		}else 
		{
			logger.info("QPLB Amount is not displayed from info module ");
		}
	
	}

	
	//Verify that, System should calculate QPLB on No.of days
	
	/*public void LWP( int Workngdays, int totalQPLB,int no_work_prjt)
	{
		//int Workngdays;
	    //int totalQPLB;
		int QPLB_per_Quarter= totalQPLB/4;
		//int no_work_prjt;
		int QPLBcalculated_no_ofdays=QPLB_per_Quarter/(QPLB_per_Quarter *no_work_prjt);
	

		if(QPLBcalculated_no_ofdays>0)
		{
			logger.info("System calculated for no of Days:"+QPLBcalculated_no_ofdays);
		}else
		{ViwCorp
			logger.info("System not calculated for even single Days also");
		}
		
	}*/
	
	
	public void QPLB_NoDays()
	{
		
		boolean QPLBDay=QPLB_Days.isDisplayed();
		String qplpDyas=QPLB_Days.getText();
		if(QPLBDay==true)
		{
			logger.info("System calculated for QPLB no of Days:"+qplpDyas);
		}else
		{
			logger.info("QPLB is NOT Calculated ");
		}
		
	}
	
	// Edit button validation
	public void EditQPLB()
	{
		boolean edit_qplb=editQPLB.isDisplayed();
		if(edit_qplb==true)
		{
			editQPLB.click();
			logger.info("Edit button was displayed");	
		}else
		{
			logger.info("Edit button was not displayed");
		}
		
	}

	
	//modify button Validation
	public void ModifyQPLB()
	{
		boolean mod_QPLB=modifyQPLB.isDisplayed();
		if(mod_QPLB==true)
		{
		modifyQPLB.click();
		logger.info("Modify button is displayed");
		}else
		{
			logger.info("Modify button was noelementt displayed");
		}
	}
	
	//Hold button Validation
	public void HoldQPLB()
	{
		boolean HQplb=holdQPLB.isDisplayed();
		if(HQplb==true)
		{
			holdQPLB.click();
			logger.info("Hold button is displayed");
		}else
		{
			
			logger.info("Hold button is NOT displayed");
		}
	}
	
	//Delete button Validation
	public void DeleteQPLB()
	{
		boolean HQplb=deletQPLB.isDisplayed();
		if(HQplb==true)
		{
			deletQPLB.click();
			logger.info("Delete button is displayed");
		}else
		{
			
			logger.info("Delete button is NOT displayed");
		}
		
	}
	
	//Lead RMG should able to Approve the QPLB report
	
	public void ValidateAprrove()
	{
	
		boolean Apvd=Approved.isDisplayed();
		
		if(Apvd==true)
		{
			
			Approved.click();
			logger.info("RMG is can make Approve for QPLB");
		}else
		{
			
			logger.info("RMG is can make Approve for QPLB");
			
		}
		

	}
	
	
	//Specialist RMG/Lead RMG should able to view the list of employees in the following categories:
	
	// Pass emp name: Abhishek Catgry: Corp or bench or agilelabs and categeory and check    
	
	public void categrycheck(String empName, String Categry)
	{
		Actions action = new Actions(driver);
		int count = 0;
		String id=null;
		String col_text = "Categeory";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='qplb_home_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i < page.size(); i++) 
		{
		if(i>1)
		{	
		driver.findElement(By.xpath("//div[@id='qplb_home_paginate']/span/a[" + (i+1) + "]")).click();
		Waitfor(1);
		}
		WebElement table = driver.findElement(By.xpath("//table[@id='qplb_home']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 1; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='qplb_home']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c < rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='qplb_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]"))
							.getText();
					Waitfor(2);
					
					if (cell_Value.equalsIgnoreCase(empName)) {
						
						WebElement report= driver.findElement(By.xpath("//table[@id='qplb_home']/tbody/tr[" + c + "]/th[1]"));
						action.click(report).build().perform();
						Waitfor(2);
						String  empc= driver.findElement(By.xpath("//table[@id='qplb_home']/tbody/tr[" + c + "]/th[9]")).getText();
						if(empc.equalsIgnoreCase(Categry))
						{
						    logger.info("Categeory is matching with the passed Categeory & Categeory is "+empc);
						    Waitfor(2);
							logger.info("The request employee name is "+cell_Value);
							count++;
							Back_Button.click();
							break;
						}
						else 
						{
						logger.info("Categeory passed is not matching & the Categeory is : "+empc);
						}
	
						
					}
					else 
						
						{
						logger.info("There is no record matched with the passsed & Categeory Emp Name");

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
	}






}

	



	




	    
	    
	    
	    
	    
	    
	    
		
		


