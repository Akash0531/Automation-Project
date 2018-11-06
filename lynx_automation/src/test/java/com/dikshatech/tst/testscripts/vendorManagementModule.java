package com.dikshatech.tst.testscripts;

import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.LogStatus;

public class vendorManagementModule extends TestBase
{
		 String generatedreport_id= "";
	
		//Login the Lynx application
		@Test(priority=0, enabled=true,description= "**Login Page**")
		public void Financiallogin() throws Exception
		{
			// Repository object creation.
			ObjectInitClass.homepage(driver);
			ObjectInitClass.loginpage(driver);
			ObjectInitClass.vendormanagement(driver);

			// Read Excel object creation to pass the sheet parameter.
			String username= excelreaddata().getData("Login_Credentials", 5, 0 ); //Reading Username from excel
	        Waitfor(1);
		    String password= excelreaddata().getData("Login_Credentials", 5, 1 ); //Reading Password from excel
			Waitfor(1);
			//Login with Financial Analyst.
			ObjectInitClass.LP.signIn(username, password);
			Waitfor(3);
	       ObjectInitClass.VM.Vendormgmnt_module();
			
		}
		   @Test(priority=1, enabled=true,description= "**Validation of VMary Initiation**")
			public void vendor_initiate()
			{	
			 //Scenario 1:Initiating VENDOR As A FA
			ObjectInitClass.VM. vendorinitiate();
		    Waitfor(3);
			exlogger.log(LogStatus.PASS, "VMary initiated & verified", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "IT_Details")));
			 //Scenario 2:Checking the generated report
			generatedreport_id= ObjectInitClass.VM.vendor_reportstatus("Generated");
					
			}
		   @Test(priority=2, enabled=true,description="Validation of vendor calculation") 
		    public void Editvendordetails()
		    {
			  //Scenario 3:Add a Vendor
		    	Waitfor(2);
		    	ObjectInitClass.VM.add_vendor(1);
		    	Waitfor(2);
		    	//search added vendor  in table
		    	ObjectInitClass.VM.vendorlist_mastertable(1);
		    	Waitfor(2);
		    	//Scenario 4:paying amount to a same Vendor
		    	ObjectInitClass.VM.savingamount(1);
		    	Waitfor(2);
		    	//search added vendor  in table
		    	ObjectInitClass.VM.vendorlist_mastertable(1);
		    	Waitfor(3);
		   	   //Scenario 5:Edit a vendor a Vendor
		     	ObjectInitClass.VM.vendoredit_Save(5);
		    	Waitfor(5);
		   	    //Scenario 6:Update a Vendor
				exlogger.log(LogStatus.INFO, "edit vendor", exlogger.addScreenCapture(ScreenshotCapture.GetScreenshot(driver, "Vendor_edit")));
			    //Scenario 7:Finance Analyst Approve functionality
				ObjectInitClass.VM.vendorlist_mastertable(5);
				Waitfor(2);
				 //Scenario 8:checking modified data functionality
			    ObjectInitClass.VM.checking_modified_Vendor(); 
			    Waitfor(2);
				ObjectInitClass.VM.vendor_submit_finance(); 
				Waitfor(6);
				ObjectInitClass.HP.Log_Out();
				Waitfor(1);
				//Scenario 9:(Finance Manager Approve functionality)

				ObjectInitClass.VM.Finance_Manager();
				Waitfor(2);
				ObjectInitClass.VM.vendor_reportstatus("Submitted");
				Waitfor(2);
				ObjectInitClass.VM.vendor_Approve(); 
				Waitfor(6);
				ObjectInitClass.HP.Log_Out();
				Waitfor(1);
				//Scenario 10:(CEO  Approve functionality)
				ObjectInitClass.VM.CEO();
				Waitfor(2);
				ObjectInitClass.VM.vendor_reportstatus("Accepted");
				Waitfor(2);
				ObjectInitClass.VM.vendorlist_mastertable(5);
		    	Waitfor(2);
		    	ObjectInitClass.VM.totalamountcapturing();
		    	Waitfor(2);
				ObjectInitClass.VM.vendor_Approve_ceo();
				Waitfor(6);
				ObjectInitClass.HP.Log_Out();
				Waitfor(1);
				//Scenario 11:(Finance Manager Complete functionality)
				ObjectInitClass.VM.Finance_Manager();
				Waitfor(2);
				ObjectInitClass.VM.vendor_reportstatus("Approved");
				Waitfor(2);
				ObjectInitClass.VM.vendorlist_mastertable(5);
		    	Waitfor(2);
		    	ObjectInitClass.VM.totalamountcapturing();
		    	Waitfor(2);
				ObjectInitClass.VM.complete_vendor("Completing vendor payment Process");
				Waitfor(6);
				ObjectInitClass.HP.Log_Out();
				Waitfor(1);
			}
		   
		    @Test(priority=3, enabled=true,description="Validation of vendor hdfc Flow") 
			public void hdfcbankreport() throws Exception
			{
		    	//Scenario 12:hdfc reports
		    	ObjectInitClass.VM.Finance_Manager();
				Waitfor(2);  
		    	ObjectInitClass.VM.vendor_reportstatus_complete("Completed");
		    	Waitfor(2);
		    	ObjectInitClass.VM.hdfcbankicon();
		    	Waitfor(2);
		    	ObjectInitClass.VM.totalamountcapturing_hdfc();
		    	Waitfor(1);
				ObjectInitClass.VM.hdfcbankreport(1,"Un-paid");
				Waitfor(1);
				ObjectInitClass.VM.hdfcselectAll();
				//Scenario 13:hdfc download the rep[orts
				ObjectInitClass.VM.downloadHDFCreport();
				Waitfor(2);
				//Scenario 14:hdfc upload the rep[orts
				ObjectInitClass.VM.uploadHDFCreport("Uploading the valid xls file");
				Waitfor(2);
				ObjectInitClass.HP.Log_Out();
				Waitfor(2);
			}
				  @Test(priority=4, enabled=true,description="Validation of vendor other reports flow") 
					public void otherbankreport() throws Exception
					{
			  //Scenario 15:othebank  reports
				ObjectInitClass.VM.Finance_Manager();
				Waitfor(2);  
				ObjectInitClass.VM.vendor_reportstatus_complete("Completed");
				Waitfor(2);  
				ObjectInitClass.VM.otherbankicon();
				Waitfor(2);
				ObjectInitClass.VM.totalamountcapturing_other();
				Waitfor(1);
				ObjectInitClass.VM.other_Bankreport(1,"Un-paid");
				Waitfor(2);
				ObjectInitClass.VM.otherbankselectAll();
				Waitfor(2);
				//Scenario 16:otherbank  download reports
				ObjectInitClass.VM.downloadother_Bankreport();
				Waitfor(2);
				//Scenario 17:otherbank  upload reports
				ObjectInitClass.VM.uploadother_Bankreport("Uploading the valid xls file");
				Waitfor(2);
				ObjectInitClass.HP.Log_Out();
				Waitfor(2);
			}
		    
		    }
		   
		   
		    
		    
		

