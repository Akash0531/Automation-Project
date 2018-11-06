package com.dikshatech.tst.objectrepository;

import java.io.File;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.relevantcodes.extentreports.LogStatus;


public class VendorManagement  extends TestBase 
{
	String reportID= "";
	String star="∗";
	@Test
	public VendorManagement (WebDriver driver)
	{
		this.driver = driver;			
	}
	 //Vendor_Management page elements repository
	
	@FindBy(xpath = "//span[contains(.,'Vendor Payment')]")                         WebElement VendorManagement_Submodule; 
    @FindBy(xpath ="//button[@class='btn btn-primary back-btn']")                   WebElement BackButton;
    @FindBy(xpath ="//button[@id='refresh']")                                       WebElement Hard_Refresh;
	@FindBy(xpath = "//a[contains(.,'Generated')]")                                 WebElement Generated_Table;
	@FindBy(xpath = ".//*[@id='Vendor-payment']/a/span[1]")                         WebElement vendor; 
	@FindBy(xpath = "//a[@href='#ven_report']")                                     WebElement Reportgenerated;
	@FindBy(xpath = "//a[contains(.,'Vendor List')]")                               WebElement vendorlist_table;
	  //Initiate Vendor Management repository
		
	@FindBy(xpath = "//button[@id='initiate_vendor_payment']")                    WebElement Initiate_Vendors;
	@FindBy(xpath = "//button[@id='vendorpaymentintiate']")                       WebElement Initiate_VendorsConfirmationmsg_Yes;
	@FindBy(xpath = ".//*[@id='genericModal-buttons']/button[2]")                 WebElement Initiate_VendorsConfirmationmsg_No;
	@FindBy(xpath = "//div[contains(.,'XVendor Payment Initiated Succesfully.')]")WebElement VendorsInitiate_SuccessMsg_Ok;
	@FindBy(xpath = "//a[@id='vendor_payment_home_next']")                        WebElement NextTable_Button;
	@FindBy(xpath = "//a[@id='vendor_payment_home_previous']")                    WebElement PreviousTable_Button;
	@FindBy(xpath = "//input[@aria-controls='vendor_payment_Report_home']")       WebElement VendorsReport_Searchbox;	
	@FindBy(xpath = "//input[@aria-controls='vendor_payment_home']")              WebElement Vendorslist_Searchbox;	
	//Vendors screen landing page Objects
	@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[1]/td[10]/select") WebElement Vendor_Status;
	@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[1]/td[7]/input")   WebElement Vendor_Amount;
	
	@FindBy(xpath = "//button[@id='ven_payment']")                            WebElement Vendor_Paybutton;
	@FindBy(xpath = "//button[@id='finance_approve']")                        WebElement vendor_Approve;
	@FindBy(xpath = ".//*[@id='vendor_payment_Report_home']/tbody/tr[1]/td[1]")  WebElement vendor_Id;
	@FindBy(xpath = "//button[@id='ven_approve']")                              WebElement ceo_Approve;
	
	
		//Add New Vendor Landing page
		
		@FindBy(xpath = "//button[@id='add_new_vendor']")                            WebElement AddVendor_Button;
		@FindBy(xpath = "//input[@id='vendor_code']")                                WebElement Vendor_Code;
		@FindBy(xpath = "//input[@id='vendor_name']")                                WebElement Vendor_name;
		@FindBy(xpath = "//input[@id='ven_ifsc']")                                   WebElement Vendor_Ifsccode;
		@FindBy(xpath = "//input[@id='vendor_pan']")                                 WebElement Vendor_PAN;
		@FindBy(xpath = "//select[@id='statesnames']")                               WebElement Vendor_State;
		@FindBy(xpath = "//input[@id='Vendor_address']")                             WebElement Vendor_Address;
		@FindBy(xpath = "//input[@id='account_no']")                                 WebElement Vendor_Account_number;
		@FindBy(xpath = "//select[@id='countrynames']")                              WebElement Vendor_country;
		@FindBy(xpath = "//button[@id='submit_new_vendor']")                         WebElement Vendor_Submit;
		@FindBy(xpath = "//input[@id='Vendor_bank']")                                WebElement Vendor_bankname;
		@FindBy(xpath = "//input[@id='vendor_gst']")                                 WebElement Vendor_Gstnumber;
		
		//Add invoice for Vendor Landing page
		@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[1]/td[9]/div/i")WebElement Add_Invoce;
		@FindBy(xpath = "//input[@id='ven_invoice_no']")                          WebElement Vendor_Invoicenumber;
		@FindBy(xpath = "//input[@id='invoice_date']")                            WebElement Vendor_Invoicedate;
		@FindBy(xpath = "//input[@id='ven_amount']")                              WebElement Vendor_Invoiceamount;
		@FindBy(xpath = "//input[@id='remarks']")                                 WebElement Vendor_Invoiceremarks;
		@FindBy(xpath = "//input[@id='no_days']")                                 WebElement Vendor_numberofdays;
		
		@FindBy(xpath = "//button[@id='dymanic_add']")                                 WebElement save_invoice;
		@FindBy(xpath = "//input[@value='hgh']")                              WebElement EditVendor_Invoicenumber;
		@FindBy(xpath = "//button[@id='submit_new_vendor']")                         WebElement EditVendor_Invoicedate;
		@FindBy(xpath = "//input[@id='Vendor_bank']")                                WebElement EditVendor_Invoiceamount;
		@FindBy(xpath = "//input[@id='vendor_gst']")                                 WebElement EditVendor_Invoiceremarks;
		//Edit vendor details
		@FindBy(xpath = "//button[@id='edit_vendor']")                           WebElement Select_editvendor;
		@FindBy(xpath = "//input[@id='vendor_name']")                            WebElement Edit_Vendor_name;
		@FindBy(xpath = "//input[@id='vendor_code']")                            WebElement Edit_Vendor_Code;
		@FindBy(xpath = "//input[@id='Vendor_address']")                         WebElement Edit_Vendor_Address;
		@FindBy(xpath = "//input[@id='Vendor_bank']")                            WebElement Edit_Vendor_bankname;
		@FindBy(xpath = "//input[@id='ven_ifsc']")                               WebElement Edit_Vendor_Ifsccode;
		@FindBy(xpath = "//input[@id='account_no']")                             WebElement Edit_Account_number;
		@FindBy(xpath = "//input[@id='vendor_pan']")                             WebElement Edit_Vendor_PAN;
		@FindBy(xpath = "//select[@id='statesnames']")                           WebElement Edit_Vendor_State;
		@FindBy(xpath = "//button[@id='update_vendor']")                         WebElement Vendor_update;
		@FindBy(xpath = "//select[@id='countrynames']")                          WebElement Edit_Vendor_country;
		@FindBy(xpath = "//input[@id='vendor_gst']")                             WebElement Edit_Vendor_Gstnumber;

		//Finance manager 
		@FindBy(xpath = "//button[@onclick='submitvendorPayment()']")           WebElement VendorSubmit_Button;
		@FindBy(xpath = "//button[@id='ven_approve']")                          WebElement VendorApprove_Button;
		@FindBy(xpath = "//button[@id='ven_complete']")                            WebElement Complete_Vendorpayament_Button;
		@FindBy(xpath = "//textarea[@id='v_comment']") WebElement Complete_PaymentComments;
		@FindBy(xpath = "//button[@id='complete_vendor_payment']") WebElement Complete_paymentSubmit_Button;
		@FindBy(xpath = "//div[@id='genericModal-buttons']/button[2]") WebElement Complete_paymentClose_Button;
		@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[1]/td[10]/select")WebElement Vendor_Status_fa;
		@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[1]/td[7]/input")WebElement Vendor_Amount_fa;
		@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[2]/td[10]/select")WebElement Vendor_Status1;
		@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[2]/td[7]/input")WebElement Vendor_Amount1;
		@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[3]/td[10]/select")WebElement Vendor_Status2;
		@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[3]/td[7]/input")WebElement Vendor_Amount2;
		@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[4]/td[10]/select")WebElement Vendor_Status3;
		@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[4]/td[7]/input")WebElement Vendor_Amount3;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[1]/div[1]/label/span") WebElement name_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[2]/div[1]/label/span") WebElement code_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[3]/div[1]/label/span") WebElement Address_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[4]/div[1]/label/span") WebElement bankname_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[5]/div[1]/label/span") WebElement accountnuber_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[6]/div[1]/label/span") WebElement ifsccode_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[9]/div[1]/label/span") WebElement country_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[10]/div[1]/label/span") WebElement state_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[3]/div[1]/label/span") WebElement invoicenumber_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[4]/div[1]/label/span") WebElement invoicedate_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[5]/div[1]/label/span") WebElement invoiceremarks_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[6]/div[1]/label/span") WebElement invoiceamount_validation;
		@FindBy(xpath =".//*[@id='genericModal-body']/div/div/div[7]/div[1]/label/span") WebElement invoiceno_of_days_validation;
		//CEO
		@FindBy(xpath = "//button[@id='sal_approve']")           WebElement Vendorpayment_Accept_Button;
		@FindBy(xpath = "//button[@id='hold_vendor']")           WebElement hold_vendor;
		@FindBy(xpath = "//button[@id='release_vendor']']")      WebElement relese_vendor;
		@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[1]/td[1]")     WebElement selectinvoice1;
		@FindBy(xpath = ".//*[@id='vendor_payment_home']/tbody/tr[3]/td[2]")      WebElement selectinvoice2;
				

		//HDFC Bank Reports Objects Repository
	
		@FindBy(xpath = "//button[@id='hdfc']")                                       WebElement HDFCBank_Report;
		@FindBy(xpath = "//button[@id='other']")                                      WebElement OtherBank_Report;
		@FindBy(xpath = "//span[@class='process']")                                   WebElement GenericToastMsg;
		@FindBy(xpath = "//button[@id='vendor_hdfc_bank']")                           WebElement DownloadHDFC_Icon;
		@FindBy(xpath = "//button[@id='hdfcvendorDownloadId']") WebElement DownldHDFCReport_Button;
		@FindBy(xpath = "//button[@id='hdfcvendorPayId']") WebElement DownloadHDFC_PayButton;
		@FindBy(xpath = "//button[@id='hdfcvendorUploadId']") WebElement DownloadHDFC_UploadButton;
		@FindBy(xpath = "//div[@id='genericModal-buttons']/button[3]") WebElement DownloadHDFC_Close_Button;
		@FindBy(xpath = "//input[@id='uploadfileName']") WebElement UploadHDFC_BrowseButton;
		@FindBy(xpath = "//textarea[@id='upload_comment']") WebElement UploadHDFC_Filedescription;
		@FindBy(xpath = "//button[@id='hdfcvendorUploadId1']") WebElement UploadHDFC_uploadbutton;
		@FindBy(xpath = ".//*[@id='genericModal-buttons']/button[2]") WebElement UploadHDFC_Closebutton;
		@FindBy(xpath = "//input[@aria-controls='vendor_hdfc_report']") WebElement HDFC_SearchBox;
		@FindBy(xpath = "//input[@id='ven_select_all']") WebElement HDFC_SelectAll;
		@FindBy(xpath = ".//*[@id='genericModal-buttons']/button[3]") WebElement HDFC_CloseButton;	
		@FindBy(xpath = "//span[@id='ven_totalAmount']")             WebElement Total_amount;	
	     
     
		// Other Bank Reports
		
		@FindBy(xpath = "//button[@id='vendor_other_bank']") WebElement OtherBank_Icon;
		@FindBy(xpath = "//button[@id='hdfcvendorothrDownloadId']") WebElement DownldOther_ReportButton;
		@FindBy(xpath = "//button[@id='otherBankvendorPayId']") WebElement OtherBank_PayButton;
		@FindBy(xpath = "//button[@id='hdfcvendorothrUploadId']") WebElement OtherBank_UploadButton;
		@FindBy(xpath = "//div[@id='genericModal-buttons']/button[3]") WebElement OtherBank_Close_Button;
		@FindBy(xpath = "//input[@id='uploadfileName']") WebElement OtherBankupload_BrowseButton;
		@FindBy(xpath = "//textarea[@id='upload_comment']") WebElement OtherBankupload_comments;
		@FindBy(xpath = "//button[@id='otherBankvenodrUploadId1']") WebElement OtherBankupload_uploadbutton;
		@FindBy(xpath = "//div[@id='genericModal-buttons']/button[2]") WebElement OtherBankupload_closebutton;
		@FindBy(xpath = "//input[@aria-controls='vendor_otrbank_report']") WebElement Other_SearchBox;
		@FindBy(xpath = "//input[@id='ven_otr_select_all']") WebElement Other_SelectAll;
		
		
		public void Vendormgmnt_module()
		{
			Waitfor(3);
			vendor.click();
			Waitfor(3);
			VendorManagement_Submodule.click();
			Waitfor(5);	
		}
		
		public void initiateVendors()
		{
		    boolean init_button= Initiate_Vendors.isDisplayed();
			if(init_button==true)
			{
			   boolean initiate_button=Initiate_Vendors.isEnabled();
			   if(initiate_button==true)
			   {	   
				   Initiate_Vendors.click();
				   Waitfor(1);
			   }
			   else
				   logger.info("The Initiate vendor button is not enabled");
			}
		   	else
		   	{
			   logger.info("The Initiate vendor button is not displayed");
		   	}
		}
		public void vendorinitiate()
		{	
//	    vendorlist_mastertable(5);
//	    Waitfor(2);
	    vendorlist_mastertable(6);
	    Waitfor(2);
	    addinvoicedetails(11);
//	    vendorlist_mastertable(7);
//	    Waitfor(2);
//	    vendorlist_mastertable(8);
//	    Waitfor(2);
	    select_invoicedetails();
	    Waitfor(2);
		initiateVendors();
		Waitfor(2);
		initiateVendors_MsgYes();
		Waitfor(3);
		}
	
		public void initiateVendors_MsgYes()
		{
			boolean yes_status= Initiate_VendorsConfirmationmsg_Yes.isDisplayed();
			if(yes_status==true)
			{
			   boolean yes_button=Initiate_VendorsConfirmationmsg_Yes.isEnabled();
			   if(yes_button==true)
			   {	 
				   Initiate_VendorsConfirmationmsg_Yes.click();
				   Waitfor(1);
			   }
			   else
				   logger.info("The Yes button is not enabled");
			}
		   	else
		   	{
			   logger.info("The Yes button is not displayed");	   			   
		}
		}

		public void initiateVendors_MsgNo()
		{
			boolean no_status= Initiate_VendorsConfirmationmsg_No.isDisplayed();
			if(no_status==true)
			{
			   boolean no_button=Initiate_VendorsConfirmationmsg_No.isEnabled();
			   if(no_button==true)
			   {	 
				   Initiate_VendorsConfirmationmsg_No.click();
				   Waitfor(1);
			   }
			   else
				   logger.info("The NO button is not enabled");
			}
		   	else
		   	{
			   logger.info("The No button is not displayed");	   			   
		}
		}
		public void savingamount(int row_num )
		{
			 String amount=excelreaddata().getData("Vendor_Management", row_num, 10 ); 
			 Vendor_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"),amount);
			 Waitfor(2);
		  	String ven_code=Vendor_Amount.getText();
			if(ven_code.equalsIgnoreCase(amount))
			{
				logger.info("  vendor amount is matching with the passed data");
			}
			else
			{
				logger.info(" vendor amount is not matching with the passed data");
			}
			 String Status=excelreaddata().getData("Vendor_Management", row_num,11);
			 Select s = new Select(Vendor_Status);
			 Waitfor(2);
			 s.selectByVisibleText(Status);
			Waitfor(2);
			logger.info("Selected region is "+ Status);
			Waitfor(2);
			String satus=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('vendor_status').options[document.getElementById('vendor_status').selectedIndex].text");
			if(satus.equalsIgnoreCase(Status))
			{
				logger.info("The status name is selected and matching with the passed data");
			}
			else
			{
				logger.info("The status  name is not selected or matching with the passed data");
			}
			
			boolean edit_status= Vendor_Paybutton.isDisplayed();
			if(edit_status==true)
			{ 
				Vendor_Paybutton.click();
				Waitfor(2);
			   }   
		   	else
		   	{
			   logger.info("The Edit button is not displayed");
		}
			
		}
		public void vendoredit_Save(int row_num)
		{ 
	     Select_editvendor.click();
	     Waitfor(2);
	     Edit_Vendor_name.clear();
	     editvendor_validation(row_num);
		 Waitfor(2);
		 Edit_Vendor_Code.clear();
		 vendorcode_edit(row_num);
		 Waitfor(2);
		 Edit_Vendor_Address.clear();
		 vendoradress_edit(row_num);
		 Waitfor(2);
		 Edit_Vendor_bankname.clear();
		 editbankname_validation(row_num);
		 Waitfor(2);
		 Edit_Account_number.clear();
		 vendorAccount_edit(row_num);
		 Waitfor(2);
		 Edit_Vendor_Ifsccode.clear();
		 vendorifsc_edit(row_num);
		 Waitfor(2);
		 country_editvalidation(row_num);
		 Waitfor(2);
		 edit_Statename(row_num);
		 Waitfor(2);
		 String Edit_Gst=excelreaddata().getData("Vendor_Management", 5,7);
		 String Edit_pan=excelreaddata().getData("Vendor_Management", 5,6);
		 Edit_Vendor_PAN.sendKeys(Keys.chord(Keys.CONTROL, "a"),Edit_pan);
		 Waitfor(2);
		 Edit_Vendor_Gstnumber.sendKeys(Keys.chord(Keys.CONTROL, "a"),Edit_Gst);		
		 Waitfor(2);
		updatevendor();
		}
		public String updatevendor()
		{
		boolean save_status= Vendor_update.isDisplayed();
		Waitfor(2);
			if(save_status==true)
			{
			   boolean save_button=Vendor_update.isEnabled();
			   if(save_button==true)
			   {	 
				   Vendor_update.click();
				   Waitfor(3);
				   String updatedmsg= GenericToastMsg.getText();
				   if(updatedmsg.equalsIgnoreCase("Vendor Details updated Succesfully."))
				   {
					   logger.info(updatedmsg);
				   }
			   else
				   logger.info("The update button is enabled");
			}
		   	else
		   	{
			   logger.info("The update button is not displayed");
		   	}
			
		}
			   String updatedmsg= GenericToastMsg.getText();
			return updatedmsg;
		}

		public String vendorlist_mastertable(int rownum)
		{
			String name=excelreaddata().getData("Vendor_Management", rownum, 0);
			vendorlist_table.click();
			Waitfor(1);
			Vendorslist_Searchbox.sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
			Waitfor(1);
			String fail="";
			Actions action = new Actions(driver);
			int count = 0;
			String col_text = "Beneficiary Name";
			List<WebElement> page = driver.findElements(By.xpath("//div[@id='vendor_payment_home_paginate']/span/a"));
			if (page.size() > 0) {
			for (int i = 1; i <=page.size(); i++) 
			{
				if(i>1)
				{	
				driver.findElement(By.xpath("//div[@id='vendor_payment_home_paginate']/span/a[" + (i) + "]")).click();
				Waitfor(1);
				}
			WebElement table = driver.findElement(By.xpath("//table[@id='vendor_payment_home']/thead/tr"));
			List<WebElement> heading = table.findElements(By.tagName("th"));
			for (int h = 0; h < heading.size(); h++) {
				String text = heading.get(h).getText();
				if (col_text.equalsIgnoreCase(text)) {
					int col = h;
					WebElement row_table = driver.findElement(By.xpath("//table[@id='vendor_payment_home']/tbody"));
					List<WebElement> rows = row_table.findElements(By.tagName("tr"));
		
					for(int c = 1; c <= rows.size(); c++) 
					{
						
				String cell_Value = driver.findElement(By.xpath("//table[@id='vendor_payment_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
								.getText();
						Waitfor(1);
						
						if (cell_Value.equalsIgnoreCase(name)) {
							
							WebElement employee= driver.findElement(By.xpath("//table[@id='vendor_payment_home']/tbody/tr[" + c + "]/td[1]"));
							action.click(employee).build().perform();
							logger.info(name+" record found in Generated Table" );
							count++;	
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
				logger.info(name+" record not found in Generated Table" );
				fail= "Not found";
			}	
			return fail;
		}
           public void select_invoicedetails()
 {
        	   Vendorslist_Searchbox.clear();
        	   Waitfor(2);
        	   
        	   selectinvoice1.click();
        	   Waitfor(2);
        	   selectinvoice2.click();
        	   Waitfor(2);
 }
		public String vendor_generatedtable(int rownum)
		{
			String name=excelreaddata().getData("Vendor_Management", rownum, 0);
			vendorlist_table.click();
			Waitfor(1);
			Vendorslist_Searchbox.sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
			

			String fail="";
			Actions action = new Actions(driver);
			int count = 0;
			String col_text = "Beneficiary Name";
			List<WebElement> page = driver.findElements(By.xpath("//div[@id='vendor_payment_view_home_paginate']/span/a"));
			if (page.size() > 0) {
			for (int i = 1; i <=page.size(); i++) 
			{
				if(i>1)
				{	
				driver.findElement(By.xpath("//div[@id='vendor_payment_view_home_paginate']/span/a[" + (i) + "]")).click();
				Waitfor(1);
				}
			WebElement table = driver.findElement(By.xpath("//table[@id='vendor_payment_view_home']/thead/tr"));
			List<WebElement> heading = table.findElements(By.tagName("th"));
			for (int h = 0; h < heading.size(); h++) {
				String text = heading.get(h).getText();
				if (col_text.equalsIgnoreCase(text)) {
					int col = h;
					WebElement row_table = driver.findElement(By.xpath("//table[@id='vendor_payment_view_home']/tbody"));
					List<WebElement> rows = row_table.findElements(By.tagName("tr"));
		
					for(int c = 1; c <= rows.size(); c++) 
					{
						
				String cell_Value = driver.findElement(By.xpath("//table[@id='vendor_payment_view_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
								.getText();
						Waitfor(1);
						
						if (cell_Value.equalsIgnoreCase(name)) {
							
							WebElement employee= driver.findElement(By.xpath("//table[@id='vendor_payment_view_home']/tbody/tr[" + c + "]/td[1]"));
							action.click(employee).build().perform();
							logger.info(name+" record found in Generated Table" );
							count++;	
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
				logger.info(name+" record not found in Generated Table" );
				fail= "Not found";
			}	
			return fail;
		}
	
		public void vendor_submit_finance()
		{
		  String Totalamount= Total_amount.getText();
		  Waitfor(1);
		  String amount =excelreaddata().getData("Vendor_Management", 1,10);
		  Waitfor(1);
		  softassert().assertEquals(amount,Totalamount);
		  Waitfor(1);
		  logger.info(Totalamount);
			Waitfor(3);
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)", "");
			boolean approve_status= VendorSubmit_Button.isDisplayed();
			if(approve_status==true)
			{
			   Waitfor(1);
			   boolean approve_button=VendorSubmit_Button.isEnabled();
			   if(approve_button==true)
			   {  
				   Waitfor(3);
				   VendorSubmit_Button.click();
				
				   String approvetoastmsg= GenericToastMsg.getText();
				   if(approvetoastmsg.equalsIgnoreCase("Vendor payment Submitted sucessfully."))
				   {
					   logger.info("Approve button has proper validation along with the toast message");
				   }
				   else
					   logger.info("Approve button toast meesage is either not proper or not displayed");
			   }
			   else
				   logger.info("The Approve button is not enabled");
			}
		   	else
			   logger.info("The Approve button is not displayed");
			
		}
		public void vendor_Approve() 
		{
			Waitfor(3);
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)", "");
			boolean approve_status= vendor_Approve.isDisplayed();
			if(approve_status==true)
			{
			   Waitfor(1);
			   boolean approve_button=vendor_Approve.isEnabled();
			   if(approve_button==true)
			   {
				   vendor_Approve.click();
				   Waitfor(3);
				   String approvetoastmsg= GenericToastMsg.getText();
				   if(approvetoastmsg.equalsIgnoreCase("Vendor payment approved sucessfully."))
				   {
					   logger.info("Approve button has proper validation along with the toast message");
				   }
				   else
					   logger.info("Approve button toast meesage is either not proper or not displayed");
			   }
			   else
				   logger.info("The Approve button is not enabled");
			}
		   	else
			   logger.info("The Approve button is not displayed");
			
		}

		
		public void Finance_Analyst()
		{
			
			// Read Excel object creation to pass the sheet parameter.
			String username2= excelreaddata().getData("Login_Credentials", 5, 0 ); //Reading Username from excel
			Waitfor(1);
			String password2= excelreaddata().getData("Login_Credentials", 5, 1 ); //Reading Password from excel
			Waitfor(1);
					
			//Login with Financial Analyst for initiating the Perdiem.
			ObjectInitClass.LP.signIn(username2, password2);
			Waitfor(2);		
			vendor.click();
			Vendormgmnt_module();
			Waitfor(2);
		}
		public String vendor_reportstatus(String statusname) 
		{
			Reportgenerated.click();
			Waitfor(2);
			String ID =vendor_Id.getText();
			VendorsReport_Searchbox.sendKeys(Keys.chord(Keys.CONTROL, "a"),ID);
			Waitfor(1);
			Actions action = new Actions(driver);
			int count = 0;
			String col_text = "status";
			List<WebElement> page = driver.findElements(By.xpath("//div[@id='vendor_payment_Report_home_paginate']/span/a"));
			if (page.size() > 0) {
			for (int i = 1; i <=page.size(); i++) 
			{
				if(i>1)
				{	
				driver.findElement(By.xpath("//div[@id='vendor_payment_Report_home_paginate']/span/a[" + (i) + "]")).click();
				Waitfor(1);
				}
			WebElement table = driver.findElement(By.xpath("//table[@id='vendor_payment_Report_home']/thead/tr"));
			List<WebElement> heading = table.findElements(By.tagName("th"));
			for (int h = 0; h <= heading.size(); h++) {
				String text = heading.get(h).getText();
				if (col_text.equalsIgnoreCase(text)) {
					int col = h;
					WebElement row_table = driver.findElement(By.xpath("//table[@id='vendor_payment_Report_home']/tbody"));
					List<WebElement> rows = row_table.findElements(By.tagName("tr"));
					logger.info(rows.size());
					for (int c = 1; c <= rows.size(); c++) {
						
						String cell_Value = driver
								.findElement(By.xpath("//table[@id='vendor_payment_Report_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
								.getText();
					
						Waitfor(2);
						if (cell_Value.equalsIgnoreCase(statusname)) {
							
							WebElement report= driver.findElement(By.xpath("//table[@id='vendor_payment_Report_home']/tbody/tr[" + c + "]/td[5]"));
							Waitfor(1);
							action.click(report).build().perform();
							logger.info("vendor Report record found with "+statusname+" status" );
							reportID= driver.findElement(By.xpath("//table[@id='vendor_payment_Report_home']/tbody/tr[" + c + "]/td[1]")).getText();
							logger.info("The newly created Report ID is: "+reportID);
							Waitfor(1);
							action.doubleClick(report).build().perform();
							Waitfor(2);
							count++;
						}
						else 
						{
						logger.info("No vendor Report record found with "+statusname+" status" );
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
			return reportID;
		}
		public void Finance_Manager()
		{
			// Read Excel object creation to pass the sheet parameter.
			String username3= excelreaddata().getData("Login_Credentials", 6, 0 ); //Reading Username from excel
			Waitfor(1);
			String password3= excelreaddata().getData("Login_Credentials", 6, 1 ); //Reading Password from excel
			Waitfor(1);
			//Login with Finance Manager for initiating the Perdiem.
			ObjectInitClass.LP.signIn(username3, password3);
			Waitfor(4);
			Vendormgmnt_module();
			Waitfor(2);
		
		}
		public void CEO()
		{
			// Read Excel object creation to pass the sheet parameter.
			String username4= excelreaddata().getData("Login_Credentials", 7, 0 ); //Reading Username from excel
			Waitfor(1);
			String password4= excelreaddata().getData("Login_Credentials", 7, 1 ); //Reading Password from excel
			Waitfor(1
					);
			//Login with Financial Analyst for initiating the Perdiem.
			ObjectInitClass.LP.signIn(username4, password4);
			Waitfor(2);
			Vendormgmnt_module();
			Waitfor(2);
														
		}
		public void complete_vendor(String comments)
		{
			
			Waitfor(3);
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)", "");
			Waitfor(1);
			boolean completebutton=Complete_Vendorpayament_Button.isDisplayed();
			if(completebutton==true)
			{
				Complete_Vendorpayament_Button.click();
			  Waitfor(1);
			  boolean comp_submit= Complete_paymentSubmit_Button.isEnabled();
			  if(comp_submit==true)
			  {
				  Complete_PaymentComments.sendKeys(Keys.chord(Keys.CONTROL, "a"), comments);
				Waitfor(1);
				Complete_paymentSubmit_Button.click();
				String compsubmittoastmsg= GenericToastMsg.getText();
				if(compsubmittoastmsg.equalsIgnoreCase("Vendor payment completed sucessfully."))
				{
					logger.info("vendor process is completed successfully with proper toast message");
				}
				else
					logger.info("vendor process toast message is not displayed");
			  }
			  else
				  logger.info("Complete Submit button is not enabled/Visible");
			}
			else
				logger.info("Complete button is not present");
		}
		

		public void complete_closevendor() 	
		{
			Complete_paymentClose_Button.click();
			Waitfor(1);
		}
		public void hdfcbankreportbutton()
		
		{
			HDFCBank_Report.click();
			Waitfor(1);
		}
		public void otherbankreport_button()
		{
			OtherBank_Report.click();
			Waitfor(1);
		}
		public void next_Table() 
		{
			boolean status = NextTable_Button.isEnabled();
			if (status == true) {
				NextTable_Button.click();
			} 
			else 
				logger.info("Next button is not enabled");
		}
		
		public void previous_Table() 
		{
			boolean status = PreviousTable_Button.isEnabled();
			if (status == true) {
				PreviousTable_Button.click();
			} 
			else 
				logger.info("Previous button is not enabled");
		}

		
		public void hdfcbankreport(int rownum ,String paystatus)
		{
			String vendor_name=excelreaddata().getData("Vendor_Management", rownum, 0 );
			int count=0;
			HDFC_SearchBox.sendKeys(Keys.chord(Keys.CONTROL, "a"),vendor_name);
			String col_text1 = "Emp Name";
			WebElement table1 = driver.findElement(By.xpath("//table[@id='vendor_hdfc_report']/thead/tr"));
			List<WebElement> heading1 = table1.findElements(By.tagName("th"));
			for (int h1 = 0; h1 < heading1.size(); h1++) {
				String text1 = heading1.get(h1).getText();
				if (col_text1.equalsIgnoreCase(text1)) {
					int col = h1;
					WebElement row_table1 = driver.findElement(By.xpath("//table[@id='vendor_hdfc_report']/tbody"));
					List<WebElement> rows1 = row_table1.findElements(By.tagName("tr"));
					for (int c = 1; c <= rows1.size(); c++) {
						String cell_Value1 = driver
								.findElement(By.xpath("//table[@id='vendor_hdfc_report']/tbody/tr[" + c + "]/td[" + (col + 1) + "]"))
								.getText();
						Waitfor(2);
						if (cell_Value1.equalsIgnoreCase(vendor_name)) 
						{
							count++;
							String  s= driver.findElement(By.xpath("//table[@id='vendor_hdfc_report']/tbody/tr[" + c + "]/td[8]")).getText();
							if(s.equalsIgnoreCase(paystatus))
							{
							logger.info("Status is matching with the passed status & Status is "+s);
							driver.findElement(By.xpath("//table[@id='vendor_hdfc_report']/tbody/tr[" + c + "]/td[9]/input")).click();
							Waitfor(2);
							HDFC_SearchBox.clear();
							count++;
							}
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
		public void hdfcselectAll()
		{
			HDFC_SelectAll.click();
			Waitfor(1);
		}
		
		public void downloadHDFCreport()
		{
			DownldHDFCReport_Button.click();
			Waitfor(2);
		}
		public void uploadHDFCreport(String file_description)
		{
			DownloadHDFC_UploadButton.click();
			Waitfor(1);
			boolean status= UploadHDFC_uploadbutton.isEnabled();
			if(status==true)
			{
				UploadHDFC_uploadbutton.click();
				Waitfor(2);
				String file_toastmsg= GenericToastMsg.getText(); 
				if(file_toastmsg.equalsIgnoreCase("Choose valid xls file !!!!"))
				UploadHDFC_BrowseButton.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadxls")).getAbsolutePath());		
			}
			else
			{
				logger.info("Upload Button is not enabled, It's a bug");
			}
			UploadHDFC_Filedescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), file_description);
		    String filedescription = UploadHDFC_Filedescription.getAttribute("value");
		    if(filedescription.equalsIgnoreCase(file_description))
		    {
		    logger.info("Comment Field is editable");
		    }
		    else
		    	logger.info("Field is non editable" + filedescription);
		    Waitfor(2);
		    boolean status1= UploadHDFC_uploadbutton.isEnabled();
		    if(status1==true)
			{
				 UploadHDFC_uploadbutton.click();
				 Waitfor(1);			
			}
			else
			{
				logger.info("Upload Button is disable");
			}  
		    Waitfor(2);
		    DownloadHDFC_Close_Button.click();
		}
		public void otherbankicon()
		{
			OtherBank_Icon.click();
			Waitfor(1);
		}
		public void hdfcbankicon()
		{
			DownloadHDFC_Icon.click();
			Waitfor(1);
		}
		public void other_Bankreport(int rownum ,String paystatus)
		{
		 String emp_name=excelreaddata().getData("Vendor_Management", rownum, 0 );
			int count=0;
			
			Other_SearchBox.sendKeys(Keys.chord(Keys.CONTROL, "a"),emp_name);
			String col_text1 = "Emp Name";
			WebElement table1 = driver.findElement(By.xpath("//table[@id='vendor_otrbank_report']/thead/tr"));
			List<WebElement> heading1 = table1.findElements(By.tagName("th"));
			for (int h1 = 0; h1 < heading1.size(); h1++) {
				String text1 = heading1.get(h1).getText();
				if (col_text1.equalsIgnoreCase(text1)) {
					int col = h1;
					WebElement row_table1 = driver.findElement(By.xpath("//table[@id='vendor_otrbank_report']/tbody"));
					List<WebElement> rows1 = row_table1.findElements(By.tagName("tr"));
					for (int c = 1; c <= rows1.size(); c++) {
						String cell_Value1 = driver
								.findElement(By.xpath("//table[@id='vendor_otrbank_report']/tbody/tr[" + c + "]/td[" + (col + 1) + "]"))
								.getText();
						Waitfor(2);
						if (cell_Value1.equalsIgnoreCase(emp_name)) {
							count++;
							String  s= driver.findElement(By.xpath("//table[@id='vendor_otrbank_report']/tbody/tr[" + c + "]/td[8]")).getText();
							if(s.equalsIgnoreCase(paystatus))
							{
							logger.info("Status is matching with the passed status & Status is "+s);
							driver.findElement(By.xpath("//table[@id='vendor_otrbank_report']/tbody/tr[" + c + "]/td[9]/input")).click();
							Waitfor(2);
							count++;
							}
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
		public void otherbankselectAll()
		{
			Other_SelectAll.click();
			Waitfor(1);
		}

		public void downloadother_Bankreport()
		{
			DownldOther_ReportButton.click();
			Waitfor(1);		
		}
		public void uploadother_Bankreport(String file_description)
		{
			OtherBank_UploadButton.click();
			Waitfor(1);
			boolean status= OtherBankupload_uploadbutton.isEnabled();
			if(status==true)
			{
				OtherBankupload_uploadbutton.click();
				Waitfor(1);
				String file_toastmsg= GenericToastMsg.getText(); 
				if(file_toastmsg.equalsIgnoreCase("Choose valid xls file !!!!"))
				OtherBankupload_BrowseButton.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadxls")).getAbsolutePath());
			}
			else
			{
				logger.info("Upload Button is enabled, It's a bug");
			}
			
			OtherBankupload_comments.sendKeys(Keys.chord(Keys.CONTROL, "a"), file_description);
		    String filedescription = OtherBankupload_comments.getAttribute("value");
		    if(filedescription.equalsIgnoreCase(file_description))
		    {
		       logger.info("Comment Field is editable");
		    }
		    else
		    	logger.info("Field is non editable" + filedescription);
		    Waitfor(1);
		    boolean status1= OtherBankupload_uploadbutton.isEnabled();
		    if(status1==true)
			{
				 OtherBankupload_uploadbutton.click();
				 Waitfor(2);
			}
			else
			{
				logger.info("Upload Button is disable");
			}
			 Waitfor(2);
			 OtherBank_Close_Button.click();
		}
		public void downloadother_Bank_Closebutton()
		{
			OtherBank_Close_Button.click();
		}
		public void backbutton()
		{
			BackButton.click();
			Waitfor(3);
		}
		
		public void add_vendor(int row_num)
		{ 
			 AddVendor_Button.click();
			 Waitfor(2);
			 addvendor_validation(row_num);
			 Waitfor(2);
			 vendorcode_validation(row_num);
			 Waitfor(2);
			 vendoradress_validation(row_num);
			 Waitfor(2);
			 vendorbankname_validation(row_num);
			 Waitfor(2);
			 vendorAccount_validation(row_num);
			 Waitfor(2);
			 vendorifsc_validation(row_num);
			 Waitfor(2);
			 vendorcountry_validation(row_num);
			 Waitfor(2);
			 vendorstate_validation(row_num);
			 Waitfor(2);
			 
			 String Gst=excelreaddata().getData("Vendor_Management", 1,7);
			 String pan=excelreaddata().getData("Vendor_Management", 1,6);
			 Edit_Vendor_PAN.sendKeys(Keys.chord(Keys.CONTROL, "a"),pan);
			 Waitfor(2);
			 Edit_Vendor_Gstnumber.sendKeys(Keys.chord(Keys.CONTROL, "a"),Gst);		
			 Waitfor(2);
			 savebutton_vendor();
		}
			 public void savebutton_vendor()
			 {
			boolean save_status= Vendor_Submit.isDisplayed();
			Waitfor(2);
		    if(save_status==true)
				{
				   boolean save_button=Vendor_Submit.isEnabled();
				   if(save_button==true)
				   {	 
					   Vendor_Submit.click();
					   Waitfor(2);
					   String updatedmsg= GenericToastMsg.getText();
					   if(updatedmsg.equalsIgnoreCase("New Vendor Added Succesfully."))
					   {
						   logger.info(updatedmsg);
					   }
				   else
					   logger.info("The submit button is not enabled");
				}
			   	else
				   logger.info("The submit button is not displayed");
				
			}
			}
		

		public String vendor_reportstatus_complete(String statusname) 
		{
			String ID= vendor_Id.getText();
			VendorsReport_Searchbox.sendKeys(Keys.chord(Keys.CONTROL, "a"),ID);
			Waitfor(1);
			Actions action = new Actions(driver);
			int count = 0;
			String col_text = "status";
			List<WebElement> page = driver.findElements(By.xpath("//div[@id='vendor_payment_Report_home_paginate']/span/a"));
			if (page.size() > 0) {
			for (int i = 1; i <=page.size(); i++) 
			{
				if(i>1)
				{	
				driver.findElement(By.xpath("//div[@id='vendor_payment_Report_home_paginate']/span/a[" + (i) + "]")).click();
				Waitfor(1);
				}
			WebElement table = driver.findElement(By.xpath("//table[@id='vendor_payment_Report_home']/thead/tr"));
			List<WebElement> heading = table.findElements(By.tagName("th"));
			for (int h = 0; h <= heading.size(); h++) {
				String text = heading.get(h).getText();
				if (col_text.equalsIgnoreCase(text)) {
					int col = h;
					WebElement row_table = driver.findElement(By.xpath("//table[@id='vendor_payment_Report_home']/tbody"));
					List<WebElement> rows = row_table.findElements(By.tagName("tr"));
					logger.info(rows.size());
					for (int c = 1; c <= rows.size(); c++) {
						
						String cell_Value = driver
								.findElement(By.xpath("//table[@id='vendor_payment_Report_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
								.getText();
					
						Waitfor(2);
					
						if (cell_Value.equalsIgnoreCase(statusname)) {
							
							WebElement report= driver.findElement(By.xpath("//table[@id='vendor_payment_Report_home']/tbody/tr[" + c + "]/td[5]"));
							Waitfor(1);
							action.click(report).build().perform();
							logger.info("vendor Report record found with "+statusname+" status" );
							reportID= driver.findElement(By.xpath("//table[@id='vendor_payment_Report_home']/tbody/tr[" + c + "]/td[1]")).getText();
							logger.info("The newly created Report ID is: "+reportID);
							Waitfor(1);
						//	action.doubleClick(report).build().perform();
							Waitfor(2);
							count++;
		
						}
						else 
						{
						logger.info("No vendor Report record found with "+statusname+" status" );
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
			return reportID;
		}
		public void vendor_Approve_ceo() 
		{
			Waitfor(3);
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)", "");
			boolean approve_status= ceo_Approve.isDisplayed();
			if(approve_status==true)
			{
			   Waitfor(1);
			   boolean approve_button=ceo_Approve.isEnabled();
			   if(approve_button==true)
			   {
				   ceo_Approve.click();
				   Waitfor(3);
				   String approvetoastmsg= GenericToastMsg.getText();
				   if(approvetoastmsg.equalsIgnoreCase("Vendor payment approved sucessfully."))
				   {
					   logger.info("Approve button has proper validation along with the toast message");
				   }
				   else
					   logger.info("Approve button toast meesage is either not proper or not displayed");
			   }
			   else
				   logger.info("The Approve button is not enabled");
			}
		   	else
			   logger.info("The Approve button is not displayed");
			
		}
		public String getemp_ID() 
		{
			return reportID;
		}
		public void checking_modified_Vendor() 
		{
			Select_editvendor.click();
		    Waitfor(2);
			String Edit_name=excelreaddata().getData("Vendor_Management", 5, 0 );
			softassert().assertEquals(Edit_name, Edit_Vendor_name.getText());
			logger.info(Edit_Vendor_name.getText());
			Waitfor(2);
			String Edit_code=excelreaddata().getData("Vendor_Management", 5, 1 );
			softassert().assertEquals(Edit_name, Edit_Vendor_Code.getText());
			logger.info(Edit_Vendor_Code.getText());
			Waitfor(2);
			String Edit_address=excelreaddata().getData("Vendor_Management", 5,2);
			softassert().assertEquals(Edit_name, Edit_Vendor_Address.getText());
			logger.info(Edit_Vendor_Address.getText());
			Waitfor(2);
			String Edit_bankname= excelreaddata().getData("Vendor_Management", 5,3);
			softassert().assertEquals(Edit_name,Edit_Vendor_bankname.getText());
			logger.info(Edit_Vendor_bankname.getText());
			Waitfor(2);
			String Edit_Ifsccode=excelreaddata().getData("Vendor_Management", 5,5);
			softassert().assertEquals(Edit_name, Edit_Vendor_Ifsccode.getText());
			logger.info( Edit_Vendor_Ifsccode.getText());
			Waitfor(2);
			String Account_number=excelreaddata().getData("Vendor_Management", 5,4);
			softassert().assertEquals(Edit_name, Edit_Account_number.getText());
			logger.info(Edit_Account_number.getText());
			Waitfor(2);
			String Edit_State=excelreaddata().getData("Vendor_Management", 5,8);
			softassert().assertEquals(Edit_name, Edit_Vendor_State.getText());
			logger.info(Edit_Vendor_State.getText());
			Waitfor(2);
			String Edit_Country=excelreaddata().getData("Vendor_Management", 5,9);
			softassert().assertEquals(Edit_name, Edit_Vendor_country.getText());
			logger.info(Edit_Vendor_country.getText());
			Waitfor(2);
			Vendor_update.click();
			Waitfor(2);	
}
		public void adding_amount_FM(String amount,String Status)
		{
			
		  String Totalamount= Total_amount.getText();
		  Waitfor(1);
		  String amount1 =excelreaddata().getData("Vendor_Management", 1,10);
		  Waitfor(1);
		  softassert().assertEquals(amount,Totalamount);
		  Waitfor(1);
		  logger.info(Totalamount);
		  Waitfor(3);
		    Vendor_Amount_fa.sendKeys(Keys.chord(Keys.CONTROL, "a"),amount);
		    Waitfor(2);
		    Select s = new Select(Vendor_Status_fa);
		    Waitfor(2);
			s.selectByVisibleText(Status);
			Waitfor(2);
			logger.info("Selected status is "+ Status);
			Waitfor(2);
			Vendor_Amount1.sendKeys(Keys.chord(Keys.CONTROL, "a"),amount);
			Waitfor(2);
			Select s1 = new Select(Vendor_Status1);
			Waitfor(2);
			s.selectByVisibleText(Status);
			Waitfor(2);
			logger.info("Selected status is "+ Status);
			Waitfor(2);
			Vendor_Amount2.sendKeys(Keys.chord(Keys.CONTROL, "a"),amount);
			Waitfor(2);
			 Select s2 = new Select(Vendor_Status2);
			Waitfor(2);
			s.selectByVisibleText(Status);
			Waitfor(2);
			logger.info("Selected status is "+ Status);
			Waitfor(2);
			Vendor_Amount3.sendKeys(Keys.chord(Keys.CONTROL, "a"),amount);
			 Waitfor(2);
			 Select s3 = new Select(Vendor_Status3);
			Waitfor(2);
			s.selectByVisibleText(Status);
			Waitfor(2);
			logger.info("Selected status is "+ Status);
			Waitfor(2);
						
}
	public void totalamountcapturing()
	{
		  String Totalamount= Total_amount.getText();
		  Waitfor(1);
		  logger.info(Totalamount);
	}
	public void totalamountcapturing_hdfc()
	{
    String hdfc_amount =driver.findElement(By.xpath("//span[@id='totvendorHdfc']")).getText();
    logger.info(hdfc_amount);
}
	public void totalamountcapturing_other()
	{
    String other_amount =driver.findElement(By.xpath("//span[@id='totvendor']")).getText();
    logger.info(other_amount);
}
	
	public String vendor_FAsave()
	{
		Vendor_Submit.click();
		String savetoastmsg= GenericToastMsg.getText();
		return savetoastmsg;
	}
	public void addvendor_validation(int row_num)
	{
	
		String datetoastmsg= vendor_FAsave();
		String vend_mand= name_validation.getText();
		 Waitfor(2);
		if(datetoastmsg.equalsIgnoreCase("Please Enter Vendor Name.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The name field is perfectly validated");
			vendo_name(row_num);
		}
		else
		{
			logger.info("The name field validation has not been done");
		}
	}
	public void vendo_name(int row_num)
	{
		String name=excelreaddata().getData("Vendor_Management", row_num, 0 ); //Reading contact_person from excel
		Edit_Vendor_name.sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
		 Waitfor(2);
	  	String ven_name=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('vendor_name').value");
		if(ven_name.equalsIgnoreCase(name))
		{
			logger.info("  name is matching with the passed data");
		}
		else
		{
			logger.info(" name is not matching with the passed data");
		}
	}
	
	public void vendorcode_validation(int row_num)
	{
	
		String datetoastmsg1= vendor_FAsave();
		String vend_mand= code_validation.getText();
		 Waitfor(2);
		if(datetoastmsg1.equalsIgnoreCase("Please Enter Vendor code.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The vendor code field is perfectly validated");
			 Waitfor(2);
			 vendo_code(row_num);
		}
		else
		{
			logger.info("The vendor code field validation has not been done");
		}
	}
	public void vendo_code(int row_num)
	{
		 String code=excelreaddata().getData("Vendor_Management", row_num, 1 ); 
		 Edit_Vendor_Code.sendKeys(Keys.chord(Keys.CONTROL, "a"),code);
		 Waitfor(2);
	  	String ven_code=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('vendor_code').value");
		if(ven_code.equalsIgnoreCase(code))
		{
			logger.info("  vendor code is matching with the passed data");
		}
		else
		{
			logger.info(" vendor code is not matching with the passed data");
		}
	}
	public void vendoradress_validation(int row_num)
	{
	
		String datetoastmsg1= vendor_FAsave();
		String vend_mand= Address_validation.getText();
		 Waitfor(2);
		if(datetoastmsg1.equalsIgnoreCase("Please Enter Address.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The vendor address field is perfectly validated");
			 Waitfor(2);
			 vendo_adress(row_num);
		}
		else
		{
			logger.info("The vendor address field validation has not been done");
		}
	}
	public void vendo_adress(int row_num)
	{
		 String address=excelreaddata().getData("Vendor_Management", row_num, 2);
		 Edit_Vendor_Address.sendKeys(Keys.chord(Keys.CONTROL, "a"),address);
		 Waitfor(2);
	  	String ven_adress=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('Vendor_address').value");
		if(ven_adress.equalsIgnoreCase(address))
		{
			logger.info("  vendor address is matching with the passed data");
		}
		else
		{
			logger.info(" vendor address is not matching with the passed data");
		}
	}
	
	public void vendorbankname_validation(int row_num)
	{
	
		String datetoastmsg1= vendor_FAsave();
		String vend_mand= bankname_validation.getText();
		 Waitfor(2);
		if(datetoastmsg1.equalsIgnoreCase("Please Enter Bank Name.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The vendor address field is perfectly validated");
			 Waitfor(2);
			 vendo_bankname(row_num);
		}
		else
		{
			logger.info("The vendor address field validation has not been done");
		}
	}
	public void vendo_bankname(int row_num)
	{
		 String bankname=excelreaddata().getData("Vendor_Management", row_num,3); 
		 Edit_Vendor_bankname.sendKeys(Keys.chord(Keys.CONTROL, "a"),bankname);
		 Waitfor(2);
	  	String ven_bank=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('Vendor_bank').value");
		if(ven_bank.equalsIgnoreCase(bankname))
		{
			logger.info("  vendor bank name is matching with the passed data");
		}
		else
		{
			logger.info(" vendor bank name is not matching with the passed data");
		}
	}
	public void vendorAccount_validation(int row_num)
	{
	
		String datetoastmsg1= vendor_FAsave();
		String vend_mand= accountnuber_validation.getText();
		 Waitfor(2);
		if(datetoastmsg1.equalsIgnoreCase("Please Enter Account No.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The vendor Account number field is perfectly validated");
			 Waitfor(2);
			 vendo_Account(row_num);
		}
		else
		{
			logger.info("The vendor Account number field validation has not been done");
		}
	}
	public void vendo_Account(int row_num)
	{
		 String Account_number=excelreaddata().getData("Vendor_Management",row_num,4); 
		 Edit_Account_number.sendKeys(Keys.chord(Keys.CONTROL, "a"),Account_number);
		 Waitfor(2);
	  	String ven_account=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('account_no').value");
		if(ven_account.equalsIgnoreCase(Account_number))
		{
			logger.info("vendor Account number is matching with the passed data");
		}
		else
		{
			logger.info("vendor Account number is not matching with the passed data");
		}
	}
	public void vendorifsc_validation(int row_num)
	{
	
		String datetoastmsg1= vendor_FAsave();
		String vend_mand= ifsccode_validation.getText();
		 Waitfor(2);
		if(datetoastmsg1.equalsIgnoreCase("Please Enter Ifsc Code.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The vendor Ifsc Code field is perfectly validated");
			 Waitfor(2);
			 vendo_ifsc(row_num);
		}
		else
		{
			logger.info("The vendor Ifsc Code field validation has not been done");
		}
	}
	public void vendo_ifsc(int row_num)
	{
		 String Ifsc_number=excelreaddata().getData("Vendor_Management",row_num,5);
		 Edit_Vendor_Ifsccode.sendKeys(Keys.chord(Keys.CONTROL, "a"),Ifsc_number);
		 Waitfor(2);
	  	String ven_Ifsc=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('ven_ifsc').value");
		if(ven_Ifsc.equalsIgnoreCase(Ifsc_number))
		{
			logger.info("vendor Ifsc Code is matching with the passed data");
		}
		else
		{
			logger.info("vendor Ifsc Code is not matching with the passed data");
		}
	}
	
	public void vendorcountry_validation(int row_num)
	{
	
		String datetoastmsg1= vendor_FAsave();
		String vend_mand= country_validation.getText();
		 Waitfor(2);
		
		if(datetoastmsg1.equalsIgnoreCase("Please select Country.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The Country field is perfectly validated");
			countryname_validation(row_num);
		}
		else
		{
			logger.info("The Country field validation has not been done");
		}
	}
	public void countryname_validation(int row)
	{
		 String Country=excelreaddata().getData("Vendor_Management",row,8); 
		 Select c = new Select(Edit_Vendor_country);
		 Waitfor(2);
		c.selectByVisibleText(Country);
		Waitfor(2);
		String sel_countryname=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('countrynames').options[document.getElementById('countrynames').selectedIndex].text");
		if(sel_countryname.equalsIgnoreCase(Country))
		{
			logger.info("The Country name is selected and matching with the passed data");
		}
		else
		{
			logger.info("The Country  name is not selected or matching with the passed data");
		}
	}
	public void vendorstate_validation(int row_num)
	{
	
		String datetoastmsg1= vendor_FAsave();
		String vend_mand= state_validation.getText();
		 Waitfor(2);
		
		if(datetoastmsg1.equalsIgnoreCase("Please select State.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The state field is perfectly validated");
			stateName_validation(row_num);
		}
		else
		{
			logger.info("The state field validation has not been done");
		}
	}
	public void stateName_validation(int row)
	{
		 String State=excelreaddata().getData("Vendor_Management", row,9); //Reading clienttiming from excel
		 Select s = new Select(Edit_Vendor_State);
		 Waitfor(2);
		s.selectByVisibleText(State);
		Waitfor(2);
		String sel_state= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('statesnames').options[document.getElementById('statesnames').selectedIndex].text");
		if(sel_state.equalsIgnoreCase(State))
		{
			logger.info("The Country State is selected and matching with the passed data");
		}
		else
		{
			logger.info("The Country State is not selected or matching with the passed data");
		}
	}
	public void editvendor_validation(int row_num)
	{
	
		String datetoastmsg=  updatevendor();
		String vend_mand= name_validation.getText();
		 Waitfor(2);
		if(datetoastmsg.equalsIgnoreCase("Please Enter Vendor Name.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The name field is perfectly validated");
			vendo_name(row_num);
		}
		else
		{
			logger.info("The name field validation has not been done");
		}
	}
	
	public void vendorcode_edit(int row_num)
	{
	
		String datetoastmsg1= updatevendor();
		String vend_mand= code_validation.getText();
		 Waitfor(2);
		if(datetoastmsg1.equalsIgnoreCase("Please Enter Vendor code.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The vendor code field is perfectly validated");
			 Waitfor(2);
			 vendo_code(row_num);
		}
		else
		{
			logger.info("The vendor code field validation has not been done");
		}
	}
	
	public void vendoradress_edit(int row_num)
	{
	
		String datetoastmsg1=  updatevendor();
		String vend_mand= Address_validation.getText();
		 Waitfor(2);
		if(datetoastmsg1.equalsIgnoreCase("Please Enter Address.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The vendor address field is perfectly validated");
			 Waitfor(2);
			 vendo_adress(row_num);
		}
		else
		{
			logger.info("The vendor address field validation has not been done");
		}
	}
	public void editbankname_validation(int row_num)
	{
	
		String datetoastmsg1= updatevendor();
		String vend_mand= bankname_validation.getText();
		 Waitfor(2);
		if(datetoastmsg1.equalsIgnoreCase("Please Enter Bank Name.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The vendor address field is perfectly validated");
			 Waitfor(2);
			 vendo_bankname(row_num);
		}
		else
		{
			logger.info("The vendor address field validation has not been done");
		}
	}
	
	public void vendorAccount_edit(int row_num)
	{
		String datetoastmsg1=  updatevendor();
		String vend_mand= accountnuber_validation.getText();
		 Waitfor(2);
		if(datetoastmsg1.equalsIgnoreCase("Please Enter Account No.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The vendor Account number field is perfectly validated");
			 Waitfor(2);
			 vendo_Account(row_num);
		}
		else
		{
			logger.info("The vendor Account number field validation has not been done");
		}
	}
	public void vendorifsc_edit(int row_num)
	{
	
		String datetoastmsg1=  updatevendor();
		String vend_mand= ifsccode_validation.getText();
		 Waitfor(2);
		if(datetoastmsg1.equalsIgnoreCase("Please Enter Ifsc Code.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The vendor Ifsc Code field is perfectly validated");
			 Waitfor(2);
			 vendo_ifsc(row_num);
		}
		else
		{
			logger.info("The vendor Ifsc Code field validation has not been done");
		}
	}
	
	public void edit_Statename(int row)
	{
		 String State=excelreaddata().getData("Vendor_Management", row,9); //Reading clienttiming from excel
		 Select s = new Select(Edit_Vendor_State);
		 Waitfor(2);
		s.selectByVisibleText(State);
		Waitfor(2);
		String sel_state= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('statesnames').options[document.getElementById('statesnames').selectedIndex].text");
		if(sel_state.equalsIgnoreCase(State))
		{
			logger.info("The Country State is selected and matching with the passed data");
		}
		else
		{
			logger.info("The Country State is not selected or matching with the passed data");
		}
	}
	public void country_editvalidation (int row)
	{
		 String Country=excelreaddata().getData("Vendor_Management",row,8); 
		 Select c = new Select(Edit_Vendor_country);
		 Waitfor(2);
		c.selectByVisibleText(Country);
		Waitfor(2);
		String sel_countryname=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('countrynames').options[document.getElementById('countrynames').selectedIndex].text");
		if(sel_countryname.equalsIgnoreCase(Country))
		{
			logger.info("The Country name is selected and matching with the passed data");
		}
		else
		{
			logger.info("The Country  name is not selected or matching with the passed data");
		}
	}
	public String vendor_invoicesave()
	{
		save_invoice.click();
		String savetoastmsg= GenericToastMsg.getText();
		return savetoastmsg;
	}
    public void addinvoicedetails(int row_num)
     {
    	Add_Invoce.click();
    	Waitfor(2);
    	addinvocenumber_validation(row_num);
    	Waitfor(2);
    	addinvoicedate_validation(row_num);
    	Waitfor(2);
    	addinvoiceremarks_validation(row_num);
    	Waitfor(2);
    	addinvoiceamount_validation(row_num);
    	Waitfor(2);
    	noofdays_validation( row_num);
    	Waitfor(2);
    	save_invoice.click();
     }
    	public void addinvocenumber_validation(int row_num)
    	{
    		String datetoastmsg= vendor_invoicesave();
    		String vend_mand= invoicenumber_validation.getText();
    		 Waitfor(2);
    		if(datetoastmsg.equalsIgnoreCase("Please Enter Invoice No.") && vend_mand.equalsIgnoreCase(star))
    		{
    			logger.info("The NUMBER field is perfectly validated");
    			vendo_invoicenumber(row_num);
    		}
    		else
    		{
    			logger.info("The NUMBER field validation has not been done");
    		}
    	}
    public void vendo_invoicenumber(int row_num)
	{
		String number=excelreaddata().getData("Vendor_Management", row_num, 0 ); //Reading contact_person from excel
		Vendor_Invoicenumber.sendKeys(Keys.chord(Keys.CONTROL, "a"),number);
		 Waitfor(2);
	  	String ven_name=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('ven_invoice_no').value");
		if(ven_name.equalsIgnoreCase(number))
		{
			logger.info(" NUMBER is matching with the passed data");
		}
		else
		{
			logger.info("NUMBER is not matching with the passed data");
		}
	}
    public void addinvoicedate_validation(int row_num)
	{
		String datetoastmsg= vendor_invoicesave();
		String vend_mand= invoicedate_validation.getText();
		 Waitfor(2);
		if(datetoastmsg.equalsIgnoreCase("Please Select Invoice Date.") && vend_mand.equalsIgnoreCase(star))
		{
			logger.info("The DATE field is perfectly validated");
			vendo_invoicedate(row_num);
		}
		else
		{
			logger.info("The DATE field validation has not been done");
		}
	}
public void vendo_invoicedate(int row_num)
{
	String date=excelreaddata().getData("Vendor_Management", row_num, 1); //Reading contact_person from excel
	Vendor_Invoicedate.sendKeys(Keys.chord(Keys.CONTROL, "a"),date);
	 Waitfor(2);
  	String ven_name=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('invoice_date').value");
	if(ven_name.equalsIgnoreCase(date))
	{
		logger.info(" DATE is matching with the passed data");
	}
	else
	{
		logger.info(" DATE is not matching with the passed data");
	}
}
public void addinvoiceamount_validation(int row_num)
{
	String datetoastmsg= vendor_invoicesave();
	String vend_mand= invoiceamount_validation.getText();
	 Waitfor(2);
	if(datetoastmsg.equalsIgnoreCase("Please Enter Amount.") && vend_mand.equalsIgnoreCase(star))
	{
		logger.info("The AMOUNT field is perfectly validated");
		vendo_invoiceamount(row_num);
	}
	else
	{
		logger.info("The AMOUNT field validation has not been done");
	}
}
        public void vendo_invoiceamount(int row_num)
{
       String amount=excelreaddata().getData("Vendor_Management", row_num, 2 ); //Reading contact_person from excel
       Vendor_Invoiceamount.sendKeys(Keys.chord(Keys.CONTROL, "a"),amount);
             Waitfor(2);
	          String ven_name=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('ven_amount').value");
             if(ven_name.equalsIgnoreCase(amount))
       {
	logger.info("  name is matching with the passed data");
      }
        else
       {
	logger.info(" name is not matching with the passed data");
         }
}
        
public void addinvoiceremarks_validation(int row_num)
{
	String datetoastmsg= vendor_invoicesave();
	String vend_mand= invoiceremarks_validation.getText();
	 Waitfor(2);
	if(datetoastmsg.equalsIgnoreCase("Please Enter Remarks.") && vend_mand.equalsIgnoreCase(star))
	{
		logger.info("The remarks field is perfectly validated");
		 vendo_invoiceremarks(row_num);
	}
	else
	{
		logger.info("The remarks field validation has not been done");
	}
}
      public void vendo_invoiceremarks(int row_num)
       {
          String remarks=excelreaddata().getData("Vendor_Management", row_num, 3); //Reading contact_person from excel
           Vendor_Invoiceremarks.sendKeys(Keys.chord(Keys.CONTROL, "a"),remarks);
            Waitfor(2);
	                String remark=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('remarks').value");
                 if(remark.equalsIgnoreCase(remarks))
           {
	         logger.info(" remarks is matching with the passed data");
          }
           else
              {
	 logger.info("remarks is not matching with the passed data");
}               
}
      public void noofdays_validation(int row_num)
      {
      	String datetoastmsg= vendor_invoicesave();
      	String vend_mand= invoiceno_of_days_validation.getText();
      	 Waitfor(2);
      	if(datetoastmsg.equalsIgnoreCase("Please Enter days.") && vend_mand.equalsIgnoreCase(star))
      	{
      		logger.info("The no_days field is perfectly validated");
      		numberofdays_invoice(row_num);
      	}
      	else
      	{
      		logger.info("The no_days field validation has not been done");
      	}
      }
            public void numberofdays_invoice(int row_num)
             {
                String nofdays=excelreaddata().getData("Vendor_Management", row_num, 4); //Reading contact_person from excel
                Vendor_numberofdays.sendKeys(Keys.chord(Keys.CONTROL, "a"),nofdays);
                  Waitfor(2);
      	                String numberofdays=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('no_days').value");
                       if(numberofdays.equalsIgnoreCase(nofdays))
                 {
      	         logger.info(" no_days is matching with the passed data");
                }
                 else
                    {
      	 logger.info("no_days is not matching with the passed data");
      }               
      }
        public void editinvoicedetails(int row_num)
        {
    	               Select_editvendor.click();
     	               Waitfor(2);
     	               addinvocenumber_validation(row_num);
     	               Waitfor(2);
     	               addinvoicedate_validation(row_num);
     	               Waitfor(2);
     	               addinvoiceamount_validation(row_num);
     	               Waitfor(2);
                       addinvoiceremarks_validation(row_num);
     	               Waitfor(2);
     	               save_invoice.click();
           }
        
      public void active_vendorschecking()
     {
    	    vendorlist_mastertable(5);
	    	Waitfor(2);
	        savingamount(5);
	    	Waitfor(2);
		    vendorlist_mastertable(6);
	    	Waitfor(2);
	    	savingamount(5);
	    	Waitfor(2);
	        vendorlist_mastertable(7);
	      	Waitfor(2);
	    	savingamount(5);
	    	Waitfor(2);
	        vendorlist_mastertable(8);
	    	Waitfor(2);
	    	savingamount(5);
	    	Waitfor(2);
	    	vendorlist_mastertable(9);
	    	Waitfor(2);
	    	savingamount(5);
	    	Waitfor(2);
	    	vendorinitiate();
	    	Waitfor(2);
	    	vendor_reportstatus("Generated");
	    	Waitfor(2);
	       String gen_status = vendor_generatedtable(6);
	       Waitfor(2);
	      	if(!gen_status.equalsIgnoreCase("No matching records found"))
	      	{
	      		logger.info("The modified record still present in Generated Table ");
	      	}
	      	else
	      	{
	      		logger.info("The modified record is not present in Generated Table ");  
	      	}
     }
      public void inactive_vendorschecking()
      {
       vendorlist_mastertable(1);
	   Waitfor(2);  
       savingamount(1);
       Waitfor(2);
       vendorinitiate();
       Waitfor(2);
      vendor_reportstatus("Generated");
       Waitfor(2);
    String gen_status=vendor_generatedtable(1);
      Waitfor(2);
  	 if(!gen_status.equalsIgnoreCase("No matching records found"))
  	 {
  	       logger.info("The modified record still present in Generated Table ");
  	 }
  	else
  		logger.info("The modified record is not present in Generated Table ");  
    }
    public void selected_vendorschecking()  
    {
    	    vendorinitiate();
    	    Waitfor(2);
    	    vendor_reportstatus("Generated");
            Waitfor(2);
	    	String gen_status=vendor_generatedtable(5);
	        Waitfor(2);
	    	 if(!gen_status.equalsIgnoreCase("No matching records found"))
	    	 {
	    	       logger.info("The modified record still present in Generated Table ");
	    	 }
	    	else
	    		logger.info("The modified record is not present in Generated Table ");  
	       }
    public void unselected_vendorschecking()  
    {         
    	
    	      vendorinitiate();
    	      Waitfor(2);
    	      vendor_reportstatus("Generated");
            Waitfor(2);
	    	String gen_status=vendor_generatedtable(6);
	        Waitfor(2);
	    	 if(!gen_status.equalsIgnoreCase("No matching records found"))
	    	 {
	    	       logger.info("The modified record still present in Generated Table ");
	    	 }
	    	else
	    		logger.info("The modified record is not present in Generated Table ");  
	       }
	
    
}	      

