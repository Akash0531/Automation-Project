package com.dikshatech.tst.objectrepository;

import java.text.DateFormat;
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
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;

public class PerdiemReconciliationObjects extends TestBase {

	String report_id= "";
	
	@Test
	public PerdiemReconciliationObjects(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	//Perdiem_Reconciliation page elements repository
	@FindBy(xpath = "//li[@id='perdiem-menu']/span") WebElement Perdiem_Reconciliation_Submodule;
	@FindBy(xpath = "//button[@id='perdiemHistory']") WebElement PerdiemHistory_Button;
	@FindBy(xpath = "//button[@id='downloadReport']") WebElement DownloadInternalReport_Button;
	@FindBy(xpath = "//button[@id='hdfc']") WebElement HDFCBank_Report;
	@FindBy(xpath = "//button[@id='other']") WebElement OtherBank_Report;
	@FindBy(xpath = "//span[@class='process']") WebElement GenericToastMsg;
	@FindBy(xpath = "//a[@id='perdiemView_next']") WebElement NextTable_Button;
	@FindBy(xpath = "//a[@id='perdiemView_previous']") WebElement PreviousTable_Button;
	@FindBy(xpath = "//div[@id='perdiem_home_filter']/label/input") WebElement PerdiemReport_Searchbox;
	@FindBy(xpath = "//div[@id='perdiemView_filter']/label/input") WebElement Perdiemview_SearchInput;
	@FindBy(xpath = "//div[@id='tblFiles_filter']/label/input") WebElement AddedSearch_Input;
	@FindBy(xpath = "//div[@id='perdiemViewApprove_filter']/label/input") WebElement ApprovedSearch_Input;
	@FindBy(xpath = "//div[@id='perdiemViewRejected_filter']/label/input") WebElement RejectedSearch_Input;
	@FindBy(xpath = "//div[@id='perdiemViewModified_filter']/label/input") WebElement ModifiedSearch_Input;
	@FindBy(xpath = "//div[@id='perdiemHoldView_filter']/label/input") WebElement HoldSearch_Input;
	@FindBy(xpath = "//div[@id='perdiemDeleteView_filter']/label/input") WebElement DeletedSearch_Input;
	
	//Perdiem initiate locators
	@FindBy(xpath = "//button[@id='initiatePerdiem']") WebElement Initiate_Perdiem;
	@FindBy(xpath = "//button[@id='yes1']") WebElement Initiate_Confirmationmsg_Yes;
	@FindBy(xpath = "//button[@id='no']") WebElement Initiate_Confirmationmsg_No;
	@FindBy(xpath = "//button[@id='yes2']") WebElement Re_Initiate_Confirmationmsg_Yes;
	@FindBy(xpath = "//button[@id='no']") WebElement Re_Initiate_Confirmationmsg_No;
	@FindBy(xpath = "//div[@id='toaster']") WebElement PerdiemInitiate_ToastMsg;
	@FindBy(xpath = "//span[@class='toast-close']") WebElement PerdiemInitiate_Toastclose;
	
	//Set Currency page
	@FindBy(xpath = "//*[@id='action_currencyChange']/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]") WebElement Add_Currency;
	@FindBy(xpath = "//select[@class='curency-info']") WebElement Select_Currency;
	@FindBy(xpath = "//tbody[@id='currencyTypeTbody']/tr/td[2]/input") WebElement Currency_Input_Box;
	@FindBy(xpath = "//div[@class='remove_field']") WebElement CurrencyRemove_Row;
	@FindBy(xpath = "//button[@onclick='saveCurrencyTypes()']") WebElement CurrencySave_Button;
	@FindBy(xpath = "//div[@id='action_currencyChange']/div/div/div[4]/button[2]") WebElement CurrencyClose_Button;
	
	//Different Perdiem Landing Page table section
	@FindBy(xpath = "//button[@id='approve']") WebElement PerdiemApprove_Button;
	@FindBy(xpath = "//button[@Class='btn btn-primary back-btn']") WebElement Back_Button;
	@FindBy(xpath = "//div[@id='perdiemView_filter']/label/input") WebElement Search_InputBox;
	@FindBy(xpath = "//select[@name='perdiemView_length']") WebElement PerdiemTable_Dropdown;
	@FindBy(xpath = "//a[text()='PerDiem View']") WebElement PerDiem_View_Table;
	@FindBy(xpath = "//a[@id='added']") WebElement Added_Table;
	@FindBy(xpath = "//a[text()='Approved']") WebElement Approved_Table;
	@FindBy(xpath = "//a[text()='Rejected']") WebElement Rejected_Table;
	@FindBy(xpath = "//a[text()='Modified']") WebElement Modified_Table;
	@FindBy(xpath = "//a[text()='On-Hold']") WebElement OnHold_Table;
	@FindBy(xpath = "//a[text()='Deleted']") WebElement Deleted_Table;
	
	//Perdiem Details landing page webelements with all the buttons and table
	@FindBy(xpath = "//span[@id='display_month']") WebElement Perdiem_Month;
	@FindBy(xpath = "//span[@id='totalAmount']") WebElement PerdiemTotal_Amount;
	@FindBy(xpath = "//span[@id='totalappAmount']") WebElement PerdiemApproved_Amount;
	@FindBy(xpath = "//span[@id='totalregAmount']") WebElement PerdiemDeleted_Amount;
	@FindBy(xpath = "//span[@id='totalonholdAmount']") WebElement PerdiemHold_Amount;
	@FindBy(xpath = "//span[@id='totalpaidAmount']") WebElement PerdiemPaid_Amount;
	@FindBy(xpath = "//button[@id='add_employee']") WebElement PerdiemAdd_EmployeeButton;

	@FindBy(xpath = "//button[@id='editper']") WebElement PerdiemEdit_Button;
	@FindBy(xpath = "//div[@id='perdiemEditPopupHeading']/h4") WebElement Edit_EmployeeName;
	@FindBy(xpath = "//table[@id='edit_perdiem_details']/tbody/tr[1]/td[2]") WebElement EditRollOn;
	@FindBy(xpath = "//table[@id='edit_perdiem_details']/tbody/tr[1]/td[4]") WebElement Edit_Separationdate;
	@FindBy(xpath = "//select[@id='perdiem_cycle']") WebElement Edit_perdiemCycle;
	@FindBy(xpath = "//input[@id='perdiem']") WebElement Edit_PerdiemInput;
	@FindBy(xpath = "//select[@id='perdiemCurrencyType']") WebElement Edit_CurrencyType;
	@FindBy(xpath = "//input[@id='payableDaysperdiem']") WebElement Edit_PayableDays;
	@FindBy(xpath = "//div[@id='totalPerdiemAmount']") WebElement Edit_PerdiemTotalAmount;
	@FindBy(xpath = "//div[@id='LeavestotalAmount']") WebElement Edit_PaidLeaveTotalAmount;
	@FindBy(xpath = "//div[@id='grandTotal']") WebElement Edit_TotalAmount;
	@FindBy(xpath = "//div[@id='payableAmount']") WebElement Edit_PayableAmount;
	@FindBy(xpath = "//table[@id='edit_perdiem_details']/tbody/tr[2]/td[6]") WebElement Edit_LWPValue;
	@FindBy(xpath = "//div[@id='deductionsTotal']") WebElement Edit_Deductions_AmountINR_Value;
	@FindBy(xpath = "//div[@id='leaveDeductionsTotal']") WebElement Edit_Leave_AmountINR_Value;
	@FindBy(xpath = "//button[@id='deleteRow']") WebElement Edit_RowDeleteYes;
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button[2]") WebElement EditRowDeleteNo;
	
	@FindBy(xpath = "//textarea[@id='editPerComment']") WebElement Edit_CommentBox;
	@FindBy(xpath = "//button[@onclick='perdiemEditSave()']") WebElement Edit_Submitbutton;
	@FindBy(xpath = "//div[@id='edit-popup']/div/div/div[3]/button[2]") WebElement Edit_Closebutton;
	
	@FindBy(xpath = "//button[@id='pApprove']") WebElement Approve_Button;
	@FindBy(xpath = "//textarea[@id='a_comments']") WebElement Approvecommentbox;
	@FindBy(xpath = "//button[@id='approve']") WebElement Approvepopup_ApproveButton;
	@FindBy(xpath = "//div[@id='approve_action']/div/div/div[3]/button[2]") WebElement ApproveCancelButton;
	
	@FindBy(xpath = "//button[@id='preject']") WebElement PerdiemReject_Button;
	@FindBy(xpath = "//textarea[@id='r_comments']") WebElement RejectComment_Box;
	@FindBy(xpath = "//button[@onclick='rejectMEmp()']") WebElement Rejectpopup_Rejectbutton;
	@FindBy(xpath = "//div[@id='preject_action']/div/div/div[3]/button[2]") WebElement Rejectpopup_CancelButton;
	
	@FindBy(xpath = "//button[@id='holdper']") WebElement PerdiemHold_Button;
	@FindBy(xpath = "//textarea[@id='h_comments']") WebElement HoldComment_Box;
	@FindBy(xpath = "//button[@onclick='handleHold()']") WebElement Holdpopup_button;
	@FindBy(xpath = "//div[@id='hold_action']/div/div/div[3]/button[2]") WebElement Holdpopup_CancelButton;
	
	@FindBy(xpath = "//button[@id='deleteper']") WebElement PerdiemDelete_Button;
	@FindBy(xpath = "//textarea[@id='d_comments']") WebElement DeleteComment_Box;
	@FindBy(xpath = "//button[@onclick='handleDelete()']") WebElement Deletepopup_Deletebutton;
	@FindBy(xpath = "//div[@id='delete_action']/div/div/div[3]/button[2]") WebElement Deletepopup_CancelButton;
	
	//View Page elements repository
	@FindBy(xpath = "//div[@id='perdieminfoPopupHeading']/h4") WebElement View_Employee_Name;
	@FindBy(xpath = "//button[@id='salAction']") WebElement View_Details_Button;
	@FindBy(xpath = "//span[@id='perdiemAmount']") WebElement View_Perdiem_Amount;
	@FindBy(xpath = "//span[@id='payableDays']") WebElement View_Payable_Days;
	@FindBy(xpath = "//span[@id='currencyType']") WebElement View_CurrencyType;
	@FindBy(xpath = "//span[@id='amount']") WebElement View_Total_Amount;
	@FindBy(xpath = "//span[@id='amountInr']") WebElement View_Net_Amount;
	@FindBy(xpath = "//span[@id='amountInr']") WebElement View_Addition_INRamount;
	@FindBy(xpath = "//span[@id='amountInr']") WebElement View_Deduction_INRamount;
	
	@FindBy(xpath = "//span[@id='comment']") WebElement View_Comments;
	@FindBy(xpath = "//button[text()='Close'][@id='btnReset']") WebElement View_Close_Button;
	
	@FindBy(xpath = "//button[@id='complete']") WebElement Complete_Perdiem;
	@FindBy(xpath = "//textarea[@id='c_comments']") WebElement Complete_Comments;
	@FindBy(xpath = "//button[@onclick='completePerdiem()']") WebElement Complete_Submit_Button;
	@FindBy(xpath = ".//*[@id='complete_action']/div/div/div[3]/button[2]") WebElement Complete_Close_Button;
	@FindBy(xpath = "//button[@id='salAction']") WebElement Complete_Cross_Button;
	
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_month;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_Company;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_Region;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_Department;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFCBank_Report_Button;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_PayButton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_Pay_MsgokayButton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_UploadButton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_Close_Button;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_Cross_Button;
	@FindBy(xpath = "//button[@id='salAction']") WebElement UploadHDFC_BrowseButton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement UploadHDFC_Filedescription;
	@FindBy(xpath = "//button[@id='salAction']") WebElement UploadHDFC_uploadbutton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement UploadHDFC_cancelbutton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement UploadHDFC_BigfileErrormsg;
	@FindBy(xpath = "//button[@id='salAction']") WebElement UploadHDFC_mandaErrormsg;
	@FindBy(xpath = "//button[@id='salAction']") WebElement UploadHDFC_okayMSG;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_Comments;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_Submit_Button;
	@FindBy(xpath = "//button[@id='salAction']") WebElement UploadHDFC_uploadstatus;
	
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBank_month;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBank_Company;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBank_Region;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBank_Department;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBankBank_Report_Button;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBank_PayButton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBank_Pay_MsgokayButton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBank_UploadButton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBank_Close_Button;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBank_Cross_Button;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBankupload_BrowseButton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBankupload_Filedescription;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBankupload_uploadbutton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBankupload_cancelbutton;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBankupload_BigfileErrormsg;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBankupload_mandaErrormsg;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBankupload_okayMSG;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBankupload_uploadstatus;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBank_Comments;
	@FindBy(xpath = "//button[@id='salAction']") WebElement OtherBank_Submit_Button;
	
	
	public void perdiemsubmodule()
	{
		Perdiem_Reconciliation_Submodule.click();
		Waitfor(1);
	}
	
	public void initiateperdiem()
	{
		boolean init_button= Initiate_Perdiem.isDisplayed();
		if(init_button==true)
		{
		   boolean initiate_button=Initiate_Perdiem.isEnabled();
		   if(initiate_button==true)
		   {	   
			   Initiate_Perdiem.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Initiate Perdiem button is not enabled");
		}
	   	else
		   logger.info("The Initiate Perdiem button is not displayed");
	}
	
	public void initiateperdiem_MsgYes()
	{
		boolean yes_status= Initiate_Confirmationmsg_Yes.isDisplayed();
		if(yes_status==true)
		{
		   boolean yes_button=Initiate_Confirmationmsg_Yes.isEnabled();
		   if(yes_button==true)
		   {	 
			   Initiate_Confirmationmsg_Yes.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Yes button is not enabled");
		}
	   	else
		   logger.info("The Yes button is not displayed");	 
	}

	public void initiateperdiem_MsgNo()
	{
		boolean no_status= Initiate_Confirmationmsg_No.isDisplayed();
		if(no_status==true)
		{
		   boolean no_button=Initiate_Confirmationmsg_No.isEnabled();
		   if(no_button==true)
		   {	 
			   Initiate_Confirmationmsg_No.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The NO button is not enabled");
		}
	   	else
		   logger.info("The No button is not displayed");	  
	}
	public void re_initiateperdiemMsgYes()
	{
		boolean reyes_status= Re_Initiate_Confirmationmsg_Yes.isDisplayed();
		if(reyes_status==true)
		{
		   boolean reyes_button=Re_Initiate_Confirmationmsg_Yes.isEnabled();
		   if(reyes_button==true)
		   {	 
			   Re_Initiate_Confirmationmsg_Yes.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Re-Yes button is not enabled");
		}
	   	else
		   logger.info("The Re-Yes button is not displayed");	
	}

	public void re_initiateperdiem_MsgNo()
	{
		boolean reno_status= Re_Initiate_Confirmationmsg_No.isDisplayed();
		if(reno_status==true)
		{
		   boolean reno_button=Re_Initiate_Confirmationmsg_No.isEnabled();
		   if(reno_button==true)
		   {	 
			   Re_Initiate_Confirmationmsg_No.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Re-NO button is not enabled");
		}
	   	else
		   logger.info("The Re-No button is not displayed");
	}
	
	public void add_currencybutton()
	{
		boolean addcurr_status= Add_Currency.isDisplayed();
		if(addcurr_status==true)
		{
		   boolean addcurr_button=Add_Currency.isEnabled();
		   if(addcurr_button==true)
		   {	 
			   Add_Currency.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Add Currency button is not enabled");
		}
	   	else
		   logger.info("The Add Currency button is not displayed");
	}
	
	public void save_currencybutton()
	{
		boolean save_status= CurrencySave_Button.isDisplayed();
		if(save_status==true)
		{
		   boolean save_button=CurrencySave_Button.isEnabled();
		   if(save_button==true)
		   {	 
			   CurrencySave_Button.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Save button is not enabled");
		}
	   	else
		   logger.info("The Save button is not displayed");
	}
	
	public void close_currencybutton()
	{
		CurrencyClose_Button.click();
		Waitfor(1);
	}
	
	public void setCurrency(String currency_type, String inr_value)
	{
		String add_curr= Add_Currency.getText();
		if(add_curr.equalsIgnoreCase("Add Currency"))
		{
			add_currencybutton();
			Select dropdown = new Select(Select_Currency);
			dropdown.selectByVisibleText(currency_type);
			Waitfor(1);
			Currency_Input_Box.sendKeys(Keys.chord(Keys.CONTROL, "a"), inr_value);
			Waitfor(1);
			save_currencybutton();
		}
		else
			logger.info("No Currency Rate window popped up");
	}
	
	public void perdiemhistory_button()
	{
		boolean perhistory_status= PerdiemHistory_Button.isDisplayed();
		if(perhistory_status==true)
		{
		   boolean perhistory_button=PerdiemHistory_Button.isEnabled();
		   if(perhistory_button==true)
		   {	 
			   PerdiemHistory_Button.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Perdiem History button is not enabled");
		}
	   	else
		   logger.info("The Perdiem History button is not displayed");
	}
	
	public void downloadinternalreport_button()
	{
		boolean intreport_status= DownloadInternalReport_Button.isDisplayed();
		if(intreport_status==true)
		{
		   boolean intreport_button=DownloadInternalReport_Button.isEnabled();
		   if(intreport_button==true)
		   {	 
			   DownloadInternalReport_Button.click();
			   Waitfor(2);
		   }
		   else
			   logger.info("The Download Internal Report button is not enabled");
		}
	   	else
		   logger.info("The Download Internal Report button is not displayed");
	}
	
	public void hdfcbankreportbutton()
	{
		boolean hdfcbank_status= HDFCBank_Report.isDisplayed();
		if(hdfcbank_status==true)
		{
		   boolean hdfcbank_button=HDFCBank_Report.isEnabled();
		   if(hdfcbank_button==true)
		   {	 
			   HDFCBank_Report.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The HDFC bank button is not enabled");
		}
	   	else
		   logger.info("The HDFC bank button is not displayed");
	}
	
	public void otherbankreport_button()
	{
		boolean otherbank_status= OtherBank_Report.isDisplayed();
		if(otherbank_status==true)
		{
		   boolean otherbank_button=OtherBank_Report.isEnabled();
		   if(otherbank_button==true)
		   {	 
			   OtherBank_Report.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Other bank button is not enabled");
		}
	   	else
		   logger.info("The Other bank button is not displayed");
	}
	
	public void perdiem_FinalApprove() 
	{
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)", "");
		boolean perApprove_status= PerdiemApprove_Button.isDisplayed();
		if(perApprove_status==true)
		{
		   boolean perApprove_button=PerdiemApprove_Button.isEnabled();
		   if(perApprove_button==true)
		   {	 
			   PerdiemApprove_Button.click();
			   Waitfor(3);
			   String approvetoastmsg= GenericToastMsg.getText();
			   boolean perdiemhistory_status= PerdiemHistory_Button.isEnabled();
			   if(approvetoastmsg.equalsIgnoreCase("Perdiem Approved Sucessfully") && perdiemhistory_status==false)
			   {
				   logger.info("Perdiem Approve button has proper validation along with the toast message");
			   }
			   else
				   logger.info("Perdiem Approve button toast message is either not proper or not displayed");
		   }
		   else
			   logger.info("The Perdiem Approve button is not enabled");
		}
	   	else
		   logger.info("The Perdiem button is not displayed");
	}
	
	public void approveIcon()
	{
		boolean approveicon_status= Approve_Button.isDisplayed();
		if(approveicon_status==true)
		{
		   boolean approveicon=Approve_Button.isEnabled();
		   if(approveicon==true)
		   {	 
			   Approve_Button.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Approve button is not enabled");
		}
	   	else
		   logger.info("The Approve button is not displayed");
	}
	
	public void perdiem_Approve()
	{
		Waitfor(3);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)", "");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)", "");
		   Waitfor(2);
		boolean aaprove_status= Approvepopup_ApproveButton.isDisplayed();
		if(aaprove_status==true)
		{
			   Waitfor(2);
		   boolean approve_button=Approvepopup_ApproveButton.isEnabled();
		   if(approve_button==true)
		   {	 
			   Approvepopup_ApproveButton.click();
			   Waitfor(1);
			   String approvetoastmsg= GenericToastMsg.getText();
			   if(approvetoastmsg.equalsIgnoreCase("Perdiem Approved Succesfully"))
			   {
				   logger.info("Approve button has proper validation along with the toast message");
			   }
			   else
				   logger.info("Approve button toast message is either not proper or not displayed");
		   }
		   else
			   logger.info("The Approve button is not enabled");
		}
	   	else
		   logger.info("The Approve button is not displayed");
	}
	
	public void rejectIcon() 
	{
		boolean perReject_status= PerdiemReject_Button.isDisplayed();
		if(perReject_status==true)
		{
		   boolean perReject_button=PerdiemReject_Button.isEnabled();
		   if(perReject_button==true)
		   {	 
			   PerdiemReject_Button.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Re-NO button is not enabled");
		}
	   	else
		   logger.info("The Re-No button is not displayed");
	}
	
	public void perdiem_Reject() 
	{
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)", "");
		   Waitfor(2);
		boolean perReject_status= Rejectpopup_Rejectbutton.isDisplayed();
		if(perReject_status==true)
		{  
			Waitfor(1);
		   boolean perReject_button=Rejectpopup_Rejectbutton.isEnabled();
		   if(perReject_button==true)
		   {	 
			   Rejectpopup_Rejectbutton.click();
			   Waitfor(1);
			   String rejecttoastmsg= GenericToastMsg.getText();
			   boolean rejecticon_status= PerdiemReject_Button.isEnabled();
			   if(rejecttoastmsg.equalsIgnoreCase("perdiem Rejected Succesfully") && rejecticon_status==false)
			   {
				   logger.info("Reject functionality has been perfectly validated with proper toast message");
			   }
			   else
				   logger.info("Reject functionality has not been validated properly");
		   }
		   else
			   logger.info("The Re-NO button is not enabled");
		}
	   	else
		   logger.info("The Re-No button is not displayed");
	}
	
	public void editIcon()
	{
		boolean reno_status= PerdiemEdit_Button.isDisplayed();
		if(reno_status==true)
		{
		   boolean reno_button=Approve_Button.isEnabled();
		   if(reno_button==true)
		   {	 
			   Approve_Button.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Approve button is not enabled");
		}
	   	else
		   logger.info("The Approve button is not displayed");
	}
	
	//Edit Perdiem validation with comments
	public void edit_perdiemvalidation()
	{

	}
	
	public void holdIcon()
	{
		boolean approveicon_status= PerdiemHold_Button.isDisplayed();
		if(approveicon_status==true)
		{
		   boolean approveicon=PerdiemHold_Button.isEnabled();
		   if(approveicon==true)
		   {	 
			   PerdiemHold_Button.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Hold button is not enabled");
		}
	   	else
		   logger.info("The Hold button is not displayed");
	}
	
	public void perdiem_hold()
	{
		boolean aaprove_status= Holdpopup_button.isDisplayed();
		if(aaprove_status==true)
		{
		   boolean approve_button=Holdpopup_button.isEnabled();
		   if(approve_button==true)
		   {	 
			   Holdpopup_button.click();
			   Waitfor(1);
			   String approvetoastmsg= GenericToastMsg.getText();
			   boolean approveicon_status= PerdiemApprove_Button.isEnabled();
			   if(approvetoastmsg.equalsIgnoreCase("Perdiem Hold Sucessfully") && approveicon_status==false)
			   {
				   logger.info("Hold button has proper validation along with the toast message");
			   }
			   else
				   logger.info("Hold button toast message is either not proper or not displayed");
		   }
		   else
			   logger.info("The Hold button is not enabled");
		}
	   	else
		   logger.info("The Hold button is not displayed");
	}
	
	public void deletedIcon()
	{
		boolean approveicon_status= PerdiemDelete_Button.isDisplayed();
		if(approveicon_status==true)
		{
		   boolean approveicon=PerdiemDelete_Button.isEnabled();
		   if(approveicon==true)
		   {	 
			   PerdiemDelete_Button.click();
			   Waitfor(1);
		   }
		   else
			   logger.info("The Deleted button is not enabled");
		}
	   	else
		   logger.info("The Deleted button is not displayed");
	}
	
	public void perdiem_deleted()
	{
		boolean aaprove_status= Deletepopup_Deletebutton.isDisplayed();
		if(aaprove_status==true)
		{
		   boolean approve_button=Deletepopup_Deletebutton.isEnabled();
		   if(approve_button==true)
		   {	 
			   Deletepopup_Deletebutton.click();
			   Waitfor(1);
			   String approvetoastmsg= GenericToastMsg.getText();
			   boolean approveicon_status= PerdiemApprove_Button.isEnabled();
			   if(approvetoastmsg.equalsIgnoreCase("Perdiem Deleted Sucessfully") && approveicon_status==false)
			   {
				   logger.info("Delete button has proper validation along with the toast message");
			   }
			   else
				   logger.info("Delete button toast message is either not proper or not displayed");
		   }
		   else
			   logger.info("The Delete button is not enabled");
		}
	   	else
		   logger.info("The Delete button is not displayed");
	}
	
	public void next_Table() {
		boolean status = NextTable_Button.isEnabled();
		if (status == true) {
			NextTable_Button.click();
			Waitfor(1);
		} else {
			logger.info("Next button is not enabled");
		}
	}

	public void previous_Table() {
		boolean status = PreviousTable_Button.isEnabled();
		if (status == true) {
			PreviousTable_Button.click();
			Waitfor(1);
		} else {
			logger.info("Previous button is not enabled");
		}
	}

	public void perdiemview_pagination() 
	{
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiemView_paginate']/span/a"));
		String text1;
		String text2;
		if (page.size() > 0) {
			for (int i = 0; i < page.size(); i++) {
				text1 = "//div[@id='perdiemView_paginate']/span/a[";
				text2 = "";
				driver.findElement(By.xpath("//div[@id='perdiemView_paginate']/span/a[" + (i + 1) + "]")).click();
				Waitfor(2);
			}
			for (int j = page.size(); j >= 0; j--) 
			{
				driver.findElement(By.xpath("//div[@id='perdiemView_paginate']/span/a[" + (j) + "]")).click();
				Waitfor(2);
			}
			
		} else 
			logger.info("There is no Pagination number present");
	}
	
	public String perdiemreport_table(String statusname, String curr_type, String inramnt)
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat1 = new SimpleDateFormat("MMMM");

		String y_m_d= dateFormat.format(date);
		String month= dateFormat1.format(date);
		String monthname= month+" "+y_m_d;
		
		Actions action = new Actions(driver);
		PerdiemReport_Searchbox.sendKeys(Keys.chord(Keys.CONTROL, "a"),monthname);
		Waitfor(1);
		String reportID="";
		String col_text = "Status";
		int count = 0;
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiem_home_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='perdiem_home_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='perdiem_home']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h <= heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiem_home']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiem_home']/tbody/tr[" + c + "]/th[" + (col+1) + "]"))
							.getText();
					Waitfor(2);
					String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
					if (cell_Value.equalsIgnoreCase(statusname)) {
						
						WebElement report= driver.findElement(By.xpath("//table[@id='perdiem_home']/tbody/tr[" + c + "]/th[5]"));
						Waitfor(1);
						action.click(report).build().perform();
						logger.info("perdiem Report record found with "+statusname+" status" );
						reportID= driver.findElement(By.xpath("//table[@id='perdiem_home']/tbody/tr[" + c + "]/th[1]")).getText();
						logger.info("The newly created Report ID is: "+reportID);
						Waitfor(2);
						action.doubleClick(report).build().perform();
						Waitfor(2);
						if(Add_Currency.isDisplayed())
						{
						 setCurrency(curr_type, inramnt);
						}
						else
						{
						 logger.info("No Set Currency Window popped up");	
						}
					Waitfor(3);
					// Edit button validation
					String perdiemmonth= Perdiem_Month.getText();
					if (month.equalsIgnoreCase(perdiemmonth)) {
						logger.info("Perdiem month is matching and month is :" + perdiemmonth);
						Waitfor(2);
					} else {
						logger.info("Perdiem month is not matching and month is :" + perdiemmonth);
					}
					logger.info("The report status is "+cell_Value);
					count++;
					break;
				}
				else 
				{
				 logger.info("No Perdiem Report record found with "+statusname+" status" );
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
	
	//Validating the the other process flow with the respective report_ID
	public void statuscheck(String reportId, String status)
	{
		Date date = new Date();
		DateFormat dateFormat1 = new SimpleDateFormat("MMMM");
		String month= dateFormat1.format(date);
		
		Actions action = new Actions(driver);
		String col_text = "ID";
		int count = 0;
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiem_home_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 0; i <= page.size(); i++) 
		{
			if(i>0)
			{	
			driver.findElement(By.xpath("//div[@id='perdiem_home_paginate']/span/a[" + (i+1) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='perdiem_home']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h <= heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiem_home']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				for (int c = 1; c < rows.size(); c++) {
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiem_home']/tbody/tr[" + c + "]/th[" + (h+1) + "]"))
							.getText();
					Waitfor(2);
					String array[] = { "Report Generated", "Approved", "Rejected", "Completed", "Submitted" };
					if (cell_Value.equalsIgnoreCase(reportId)) {
						WebElement report= driver.findElement(By.xpath("//table[@id='perdiem_home']/tbody/tr[" + c + "]/th[7]"));
						String reportstatus= report.getText();
							if(reportstatus.equalsIgnoreCase(status))
							{
							action.doubleClick(report).build().perform();
							Waitfor(2);
							}
							else
								logger.info("The Report status is not matching with the passed status");
							String perdiemmonth= Perdiem_Month.getText();
							if (month.equalsIgnoreCase(perdiemmonth)) {
								logger.info("Perdiem month is matching and month is :" + perdiemmonth);
								Waitfor(2);
							} else {
								logger.info("Perdiem month is not matching and month is :" + perdiemmonth);
							}
							logger.info("The report status is "+cell_Value);
							count++;
							break;
					}
					else 
					{
					 logger.info("No Perdiem Report record found with "+reportId+" Report ID" );
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
	}
	
	public String perdiem_viewtable(String empname, String perdiemtype)
	{
		PerDiem_View_Table.click();
		Waitfor(1);
		Perdiemview_SearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
		Waitfor(1);
		
		Actions action = new Actions(driver);
		String fail= "";
		int count = 0;
		String col_text = "Emp Name";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiemView_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='perdiemView_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='perdiemView']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiemView']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiemView']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(1);
					if (cell_Value.equalsIgnoreCase(empname)) {
						WebElement employee= driver.findElement(By.xpath("//table[@id='perdiemView']/tbody/tr[" + c + "]/td[8]"));
						String perdiem_type= employee.getText();
						 if(perdiem_type.equalsIgnoreCase(perdiemtype))
						 {
						  action.click(employee).build().perform();
						  logger.info(empname+" record found in Perdiem View Table" );
						  count++;
						  break;
						 }
					}
					else 
					{
					logger.info(empname+" record not found in Perdiem View Table" );
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
			fail= "Not found";
		return fail;
	}
	
	//To-Do
	public String perdiem_addedtable(String empname)
	{
		Added_Table.click();
		Waitfor(1);
		AddedSearch_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
		Waitfor(1);
		
		Actions action = new Actions(driver);
		String fail= "";
		int count = 0;
		String col_text = "Emp Name";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiemmodifiedview_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='perdiemmodifiedview_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='perdiemmodifiedview']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiemmodifiedview']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiemmodifiedview']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(1);
					
					if (cell_Value.equalsIgnoreCase(empname)) {
						
						WebElement employee= driver.findElement(By.xpath("//table[@id='perdiemmodifiedview']/tbody/tr[" + c + "]/td[2]"));
						action.click(employee).build().perform();
						logger.info(empname+" record found in Modified Table" );
						count++;
						break;
					}
					else 
					{
					logger.info(empname+" record not found in Modified Table" );
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
			fail= "Not found";
		return fail;
	}
	
	public String perdiem_approvedtable(String empname)
	{
		Approved_Table.click();
		Waitfor(1);
		ApprovedSearch_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
		Waitfor(1);
		
		Actions action = new Actions(driver);
		String fail= "";
		int count = 0;
		String col_text = "Emp Name";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiemViewApprove_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='perdiemViewApprove_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='perdiemViewApprove']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h <= heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiemViewApprove']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiemViewApprove']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(1);
					if (cell_Value.equalsIgnoreCase(empname)) {
						WebElement employee= driver.findElement(By.xpath("//table[@id='perdiemViewApprove']/tbody/tr[" + c + "]/td[2]"));
						action.click(employee).build().perform();
						logger.info(empname+" record found in Approved Table" );
						count++;
						break;
					}
					else 
					{
					logger.info(empname+" record not found in Approved Table" );
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
			fail= "Not found";
		return fail;
	}
	
	public String  perdiem_rejectedtable(String empname)
	{
		Rejected_Table.click();
		Waitfor(1);
		RejectedSearch_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
		Waitfor(1);
	
		Actions action = new Actions(driver);
		String fail= "";
		int count = 0;
		String col_text = "Emp Name";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiemViewRejected_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='perdiemViewRejected_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='perdiemViewRejected']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h <= heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiemViewRejected']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiemViewRejected']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(1);
					
					if (cell_Value.equalsIgnoreCase(empname)) {
						
						WebElement employee= driver.findElement(By.xpath("//table[@id='perdiemViewRejected']/tbody/tr[" + c + "]/td[2]"));
						action.click(employee).build().perform();
						logger.info(empname+" record found in Rejected Table" );
						count++;
		
						break;
					}
					else 
					{
					logger.info(empname+" record not found in Rejected Table" );
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
			fail= "Not found";
		return fail;
	}
	
	public String perdiem_modifiedtable(String empname)
	{
		Modified_Table.click();
		Waitfor(1);
		ModifiedSearch_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
		Waitfor(1);
		
		Actions action = new Actions(driver);
		String fail= "";
		int count = 0;
		String col_text = "Emp Name";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiemViewModified_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='perdiemViewModified_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='perdiemViewModified']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiemViewModified']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiemViewModified']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(1);
					
					if (cell_Value.equalsIgnoreCase(empname)) {
						
						WebElement employee= driver.findElement(By.xpath("//table[@id='perdiemViewModified']/tbody/tr[" + c + "]/td[2]"));
						action.click(employee).build().perform();
						logger.info(empname+" record found in Modified Table" );
						count++;
						break;
					}
					else 
					{
					logger.info(empname+" record not found in Modified Table" );
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
			fail= "Not found";
		return fail;
	}
	
	public String perdiem_holdtable(String empname)
	{
		OnHold_Table.click();
		Waitfor(1);
		HoldSearch_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
		Waitfor(1);
		
		Actions action = new Actions(driver);
		String fail= "";
		int count = 0;
		String col_text = "Emp Name";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiemmodifiedview_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='perdiemmodifiedview_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='perdiemmodifiedview']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiemmodifiedview']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiemmodifiedview']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(1);
					
					if (cell_Value.equalsIgnoreCase(empname)) {
						
						WebElement employee= driver.findElement(By.xpath("//table[@id='perdiemmodifiedview']/tbody/tr[" + c + "]/td[2]"));
						action.click(employee).build().perform();
						logger.info(empname+" record found in Modified Table" );
						count++;
		
						break;
					}
					else 
					{
					logger.info(empname+" record not found in Modified Table" );
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
			fail= "Not found";
		return fail;
	}
	
	public String  perdiem_deletedtable(String empname)
	{
		Deleted_Table.click();
		Waitfor(1);
		DeletedSearch_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),empname);
		Waitfor(1);
	
		Actions action = new Actions(driver);
		String fail= "";
		int count = 0;
		String col_text = "Emp Name";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiemholdview_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='perdiemholdview_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='perdiemholdview']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiemholdview']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiemholdview']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(1);
					
					if (cell_Value.equalsIgnoreCase(empname)) {
						
						WebElement employee= driver.findElement(By.xpath("//table[@id='perdiemholdview']/tbody/tr[" + c + "]/td[2]"));
						action.click(employee).build().perform();
						logger.info(empname+" record found in HOLD Table" );
						count++;
		
						break;
					}
					else 
					{
					logger.info(empname+" record not found in Modified Table" );
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
			fail= "Not found";
		return fail;
	}

	public void edit_button()
	{
		PerdiemEdit_Button.click();
		Waitfor(1);
	}
	
	public void edit_comments(String comments)
	{
		Edit_CommentBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), comments);
		Waitfor(1);
	}
	
	public void edit_Submitvalidation(String editcomment)
	{
		boolean completebutton=Edit_Submitbutton.isDisplayed();
		if(completebutton==true)
		{
		  Edit_Submitbutton.click();
		  String commnttoastmsg=GenericToastMsg.getText();
		  boolean comp_submit= Edit_Submitbutton.isEnabled();
		  if(comp_submit==true && commnttoastmsg.equalsIgnoreCase("Enter comments!!!!"))
		  {
			edit_comments(editcomment);
			Waitfor(1);
			Edit_Submitbutton.click();
			String compsubmittoastmsg= GenericToastMsg.getText();
			if(compsubmittoastmsg.equalsIgnoreCase("PerDiem Details Saved Succesfully"))
			{
				logger.info("Perdiem details modified successfully with proper toast message");
			}
			else
				logger.info("Perdiem details modified toast message is not displayed");
		  }
		  else
			  logger.info("Edit Perdiem Submit button is not enabled/Visible");
		}
		else
			logger.info("Edit Perdiem button is not present");
	}
	
	public float totaldeductions_calculation(int rownum)
	{
		int month_days= 31;
		String employee=  excelreaddata().getData("Perdiem", rownum, 0);
		String emp_name= Edit_EmployeeName.getText();
		String ename[]=emp_name.trim().split("\\s+");
		String employeename= ename[3]+" "+ename[4];
		String sal_advance= excelreaddata().getData("Perdiem", rownum, 3);
		String travel_advance= excelreaddata().getData("Perdiem", rownum, 4);
		String accomodation= excelreaddata().getData("Perdiem", rownum, 5);
		if(employee.equalsIgnoreCase(employeename))
		{
			logger.info("The Employee name is matching with the excel data");
			
		}
		else
			logger.info("The Employee name is not matching with the excel");
		
		String l_W_P= excelreaddata().getData("Perdiem", rownum, 1);
		float l = (Float.valueOf(l_W_P)).floatValue();
		
		String perdiem= excelreaddata().getData("Perdiem", rownum, 3);
		float perdiemamount = (Float.valueOf(perdiem)).floatValue();
		
		/*
		Per day perdiem calculation
		*/
		double perdiem_Amount= (month_days-l)*perdiemamount;
		double perday_basic= perdiem_Amount/month_days;
		
		String pay_days= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('payableDaysperdiem').value");
		float payable_days= (Float.valueOf(pay_days)).floatValue();
		
		float lwp= (Float.valueOf(Edit_LWPValue.getText())).floatValue(); 
		
		double actperdiem = 0;
		if(l==lwp)
		{
			float paydays= month_days-lwp;
			if(paydays==payable_days)
			{
				logger.info("The payable days is correct");
				actperdiem= perday_basic*payable_days;
				String perdiemamnt = driver.findElement(By.xpath("//table[@id='edit_perdiem_earnings']/tbody/tr[1]/td[3]/input")).getAttribute("value");
				double exp_perdiemamnt= (Float.valueOf(perdiemamnt)).floatValue(); 
				if(actperdiem==exp_perdiemamnt)
				{
					logger.info("Perdiem is calculated perfectly");
				}
				else
					logger.info("Perdiem has some worng calculation");
			}
			else
				logger.info("The payable days is incorrect");
		}	
		else
			logger.info("The LWP value is wrong please verify it");
		
		float t_deduction= (Float.valueOf( Edit_Deductions_AmountINR_Value.getText())).floatValue();
		
		String value[]= new String[10];
		String array[] = {"perdiem in Advance", "Travel in Advance", "Accomodation"};
		WebElement row_table = driver.findElement(By.xpath("//table[@id='edit_perdiem_deductions']/tbody"));
		List<WebElement> rows = row_table.findElements(By.tagName("tr"));
		for (int c = 1; c <= rows.size(); c++) 
		{	
			String cell_Value = driver
					.findElement(By.xpath("//table[@id='edit_perdiem_deductions']/tbody/tr[" + c + "]/td[1]/input"))
					.getAttribute("value");
			
			if(cell_Value.equalsIgnoreCase(array[0]))
			{
				value[0]=driver
				.findElement(By.xpath("//table[@id='edit_perdiem_deductions']/tbody/tr[" + c + "]/td[4]/input"))
				.getAttribute("value");
				String salamountINR= driver.findElement(By.xpath("//table[@id='edit_perdiem_deductions']/tbody/tr[" + c + "]/td[8]"))
						          .getAttribute("value");
				if(value[0].equalsIgnoreCase(salamountINR) && value[0].equalsIgnoreCase(sal_advance))
				{
					logger.info("perdiem In Advance is properly calculated and verified");
				}
				else
					logger.info("perdiem In Advance data is wrong");
				}
			else if(cell_Value.equalsIgnoreCase(array[1]))
			{
				value[1]=driver
				.findElement(By.xpath("//table[@id='edit_perdiem_deductions']/tbody/tr[" + c + "]/td[4]/input"))
				.getAttribute("value");
				String travelamountINR= driver.findElement(By.xpath("//table[@id='edit_perdiem_deductions']/tbody/tr[" + c + "]/td[8]"))
				          .getAttribute("value");
				if(value[1].equalsIgnoreCase(travelamountINR) && value[1].equalsIgnoreCase(travel_advance))
				{
					logger.info("Travel In Advance is properly calculated and verified ");
				}
				else
					logger.info("Travel In Advance has some wrong data");
			}
			else if(cell_Value.equalsIgnoreCase(array[2]))
			{
				value[2]=driver
				.findElement(By.xpath("//table[@id='edit_perdiem_deductions']/tbody/tr[" + c + "]/td[4]/input"))
				.getAttribute("value"); 
				String accomodamountINR= driver.findElement(By.xpath("//table[@id='edit_perdiem_deductions']/tbody/tr[" + c + "]/td[8]"))
		          .getAttribute("value");
				if(value[1].equalsIgnoreCase(accomodamountINR) && value[1].equalsIgnoreCase(accomodation))
				{
					logger.info("Accomodation is properly calculated and verified ");
				}
				else
					logger.info("Accomodation has some wrong data");
			}
			else
			{
				logger.info("The extra deduction component is : " +cell_Value);
				value[c-1]=driver
						.findElement(By.xpath("//table[@id='edit_perdiem_deductions']/tbody/tr[" + c + "]/td[4]/input"))
						.getAttribute("value");
			}
			
		}
		float totaldeducted_amount= 0;
		for(int i = 0; i < value.length; i++)
		{
			if(!(value[i]==null))
			{
				totaldeducted_amount=((Float.valueOf(totaldeducted_amount)).floatValue())+((Float.valueOf(value[i])).floatValue());
				
			}
		}
		
		if(totaldeducted_amount==t_deduction)
		{
			logger.info("The Total deductions calculation is based on the provided components is correct");
		}
		else
			logger.info("The Total deductions calculation is based on the provided components is not correct, please verify it manually once");

		return totaldeducted_amount;
	}		
		
	public void net_perdiemearnings(int rownum)
	{
		String perdiem_value= Edit_PayableAmount.getText();
		float payableperdiem= (Float.valueOf(perdiem_value)).floatValue(); 
		
		float leavededuction_amount= 0;
		float deduction_amount= totaldeductions_calculation(rownum);
		
		float netincome= leavededuction_amount-deduction_amount;
		
		if(netincome==payableperdiem)
		{
			logger.info("Payable Perdiem is correct");
		}
		else
			logger.info("Payable Perdiem is not correct");
	}

	public void edit_close()
	{
		Edit_Closebutton.click();
		Waitfor(1);
	}
	
	public void view_close()
	{
		View_Close_Button.click();
		Waitfor(1);
	}
	
	
	public void deductions_removerow()
	{
		Edit_RowDeleteYes.click();
	}
	
	//Hold Perdiem Functionality 
	public void hold()
	{
		PerdiemHold_Button.click();
	}
	
	public void hold_perdiem(String comments)
	{
		hold();
		HoldComment_Box.sendKeys(Keys.chord(Keys.CONTROL, "a"), comments);
		Waitfor(2);
		Holdpopup_button.click();
	}
	public void hold_cancel()
	{
		Holdpopup_CancelButton.click();
	}
	
	//Release Perdiem functionality
		
	//Perdiem Calculation in View Page
	public void view_perdiemcalculation(String emp_Name)
	{
		int count=0;
		String col_text = "Emp Name";
		WebElement table = driver.findElement(By.xpath("//table[@id='perdiemView']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 1; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				logger.info("Text"+ text);
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiemView']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				for (int c = 1; c < rows.size(); c++) {
					logger.info("Emp Name column is present in the heading");
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiemView']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(2);
					logger.info("empname"+ cell_Value);
					if (cell_Value.equalsIgnoreCase(emp_Name)) {
						driver.findElement(By.xpath("//table[@id='perdiemView']/tbody/tr[" + c + "]/td[" + (col+1) + "]")).click();
						Waitfor(2);
						edit_button();
						count++;
						break;
						}
				}
			}
			if(count>0)
			{
			break;
			}
		}
		
		float p_days= 30.0f;
		Waitfor(1);
		String perdiemvalue= View_Perdiem_Amount.getText();
		float perdiem= floatconversion(perdiemvalue);
		logger.info(View_CurrencyType.getText());
		String paydays=View_Payable_Days.getText();
		float days= floatconversion(paydays);
		String amnt= View_Total_Amount.getText();
		float amount= floatconversion(amnt);
		String lwp= Edit_LWPValue.getText();
		float lwp_value= floatconversion(lwp);
		String addition_amount=View_Addition_INRamount.getText();
		float additionINR_amount=floatconversion(addition_amount);
		String deduction_amount=View_Deduction_INRamount.getText();
		float deductionINR_amount=floatconversion(deduction_amount);
			
		float total_days= p_days-lwp_value;
		String t_days= String.valueOf(total_days);
		if(t_days.equals(paydays))
		{
			float total_amount= total_days*perdiem;	
			float net_amount= total_amount+additionINR_amount-deductionINR_amount;
			logger.info("The Net amount is: "+net_amount);
			Waitfor(1);
		}
		else
		{
			logger.info("Payable days is not matching as total days is: "+t_days);
		}	
		
	}	
	
	//View Perdiem validation
	public void view_perdiemvalidation()
	{
	//Validating the Additions/Deductions net_amount with different-2 addition/deductions.
	String col_text = "Amount";
	WebElement table = driver.findElement(By.xpath("//table[@id='deductions_table']/thead/tr"));
	List<WebElement> heading = table.findElements(By.tagName("th"));
	for (int h = 1; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (col_text.equalsIgnoreCase(text)) {
			int col = h;
			WebElement row_table = driver.findElement(By.xpath("//table[@id='deductions_table']/tbody"));
			List<WebElement> rows = row_table.findElements(By.tagName("tr"));
			logger.info(rows.size());
			for (int c = 1; c < rows.size(); c++) {
				// logger.info("Column Country is present in the heading");
				logger.info(c);
				String cell_Value = driver
						.findElement(By.xpath("//table[@id='leavehome']/tbody/tr[" + c + "]/td[" + (col + 1) + "]"))
						.getText();
				Waitfor(2);
				if (cell_Value.equalsIgnoreCase("Amount")) {
					driver.findElement(By.xpath("//table[@id='leavehome']/tbody/tr[" + c + "]/td[1]")).click();
					Waitfor(2);
					}
			}
		}
	}
	//Validating the Additions/Deductions net_amount with different-2 addition/deductions.
	String col_text1 = "Amount";
	WebElement table1 = driver.findElement(By.xpath("//table[@id='deductions_table']/thead/tr"));
	List<WebElement> heading1 = table1.findElements(By.tagName("th"));
	for (int h = 1; h < heading1.size(); h++) {
		String text = heading1.get(h).getText();
		if (col_text1.equalsIgnoreCase(text)) {
			int col = h;
			WebElement row_table = driver.findElement(By.xpath("//table[@id='deductions_table']/tbody"));
			List<WebElement> rows = row_table.findElements(By.tagName("tr"));
			logger.info(rows.size());
			for (int c = 1; c < rows.size(); c++) {
				// logger.info("Column Country is present in the heading");
				logger.info(c);
				String cell_Value = driver
						.findElement(By.xpath("//table[@id='leavehome']/tbody/tr[" + c + "]/td[" + (col + 1) + "]"))
						.getText();
				Waitfor(2);
				if (cell_Value.equalsIgnoreCase("Amount")) {
					driver.findElement(By.xpath("//table[@id='leavehome']/tbody/tr[" + c + "]/td[1]")).click();
					Waitfor(2);
					}
			}
		}
	}
	
	logger.info(View_Comments.getText());
	
	
   }
		
	public void complete_perdiem(String comments)
	{

		Waitfor(3);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)", "");
		Complete_Perdiem.click();
		Waitfor(2);
		Complete_Comments.sendKeys(Keys.chord(Keys.CONTROL, "a"), comments);
		Waitfor(2);
		Complete_Submit_Button.click();
		Waitfor(2);
	}
	
	public void complete_closeperdiem() 	
	{
		Complete_Close_Button.click();
		Waitfor(1);
	}
	
	public String systemgenerate_report(String monthname, String statusname, String curr_type, String INRvalue)
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MMMM-EEEE-HH-mm-a");
		String subdate[]=dateFormat.format(date).split("-");
		
		Date date1 = new Date();
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		String y_m_d[]= dateFormat1.format(date1).split("-");
		
		String month= y_m_d[1];
		
		String month_name= subdate[0];
		String day= subdate[1];
		String hour= subdate[2];
		String minute= subdate[3];
		String period= subdate[4];
		
		Actions action = new Actions(driver);
		int t=12;
		String col_text = "Submitted Date";
		String id=null;
		int count = 0;
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiem_home_paginate']/span/a"));
		int i;
		for (i = 0; i <= page.size(); i++) 
		{
			if(i>0)
			{	
			driver.findElement(By.xpath("//div[@id='perdiem_home_paginate']/span/a[" + (i+1) + "]")).click();
			Waitfor(1);
			}
			WebElement table = driver.findElement(By.xpath("//table[@id='perdiem_home']/thead/tr"));
			List<WebElement> heading = table.findElements(By.tagName("th"));
			headingloop :
			for (int h = 1; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiem_home']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c < rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiem_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]"))
							.getText().toString();
					Waitfor(1);
					String gen_date[]=cell_Value.split("-");
					String generated_day= gen_date[2];
					
					if(String.valueOf(t).equalsIgnoreCase(generated_day) && String.valueOf(t)==(generated_day))
						if(month.equalsIgnoreCase(cell_Value))
					{
						logger.info("The report generated on : "+cell_Value);
						WebElement report= driver.findElement(By.xpath("//table[@id='perdiem_home']/tbody/th[" + c + "]/th[5]"));
						id= driver.findElement(By.xpath("//table[@id='perdiem_home']/tbody/tr[" + c + "]/th[1]")).getText();
						action.doubleClick(report).build().perform();
						Waitfor(1);
						if(Add_Currency.isDisplayed())
						{
						setCurrency(curr_type, INRvalue);
						}
						else
						{
						logger.info("No Change Currency Window popped up");	
						}
						Waitfor(1);
						
						// Edit button validation
						boolean approve_button = PerdiemApprove_Button.isDisplayed();
						if (approve_button == true) {
							logger.info("Approve button is displayed and status is :" + approve_button);
							Waitfor(2);
							
						} else {
							logger.info("Approve button is not present in Perdiem Edit page and status is :" + approve_button);
						}
						logger.info("The request status is "+cell_Value);
						count++;
						break;
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
		if(i>=page.size())	
		{
			
		}
		return id;			
}
		
		
	
	public String manual_perdiem_report(String monthname, String statusname, String curr_type, String INRvalue)
	{
		DateFormat dateFormat = new SimpleDateFormat("MMMM-EEEE-HH-mm-a");
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Date date1 = new Date();
		String y_m_d= dateFormat1.format(date1);
		String subdate[]=dateFormat.format(date).split("-");
		
		String month= subdate[0];
		String day= subdate[1];
		String hour= subdate[2];
		String minute= subdate[3];
		String period= subdate[4];
		
		Actions action = new Actions(driver);
		int t=15;
		String col_text = "Submitted Date";
		String id=null;
		int count = 0;
		int elsecount=0;
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='perdiem_home_paginate']/span/a"));
	
		for (int i = 0; i <= page.size(); i++) 
		{
			if(i>0)
			{	
			driver.findElement(By.xpath("//div[@id='perdiem_home_paginate']/span/a[" + (i+1) + "]")).click();
			Waitfor(1);
			}
			WebElement table = driver.findElement(By.xpath("//table[@id='perdiem_home']/thead/tr"));
			List<WebElement> heading = table.findElements(By.tagName("th"));
			for (int h = 1; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiem_home']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c < rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='perdiem_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]"))
							.getText().toString();
					Waitfor(1);
					if (cell_Value.equalsIgnoreCase(y_m_d)) {
						logger.info("The report generated on : "+cell_Value);
						WebElement report= driver.findElement(By.xpath("//table[@id='perdiem_home']/tbody/th[" + c + "]/th[5]"));
						id= driver.findElement(By.xpath("//table[@id='perdiem_home']/tbody/tr[" + c + "]/th[1]")).getText();
						action.doubleClick(report).build().perform();
						Waitfor(1);
						if(Add_Currency.isDisplayed())
						{
						setCurrency(curr_type, INRvalue);
						}
						else
						{
						logger.info("No Change Currency Window popped up");	
						}
						Waitfor(1);
						
						// Edit button validation
						boolean approve_button = PerdiemApprove_Button.isDisplayed();
						if (approve_button == true) {
							logger.info("Approve button is displayed and status is :" + approve_button);
							Waitfor(2);
							
						} else {
							logger.info("Approve button is not present in Perdiem Edit page and status is :" + approve_button);
						}
						logger.info("The request status is "+cell_Value);
						count++;
						break;
					}
					else 
						
						{
						logger.info("There is no record matched with the passsed status");
						elsecount++;
						break;
						}

				
				}
				
			}
			if(elsecount>0)
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
		
		return id;			
		}
	
	public void hdfcbankreport(String company, String Region, String Department)
	{
		//Company dropdown selection
		Select dropdown0 = new Select(DownloadHDFC_Company);
		dropdown0.selectByVisibleText(company);
		Waitfor(1);
		//Region dropdown selection
		Select dropdown1 = new Select(DownloadHDFC_Company);
		dropdown1.selectByVisibleText(Region);
		Waitfor(1);
		//Department dropdown selection
		Select dropdown2 = new Select(DownloadHDFC_Company);
		dropdown2.selectByVisibleText(Department);
		Waitfor(1);
		
		//Traversing in the webtable to select paid/unpaid employees
		String col_text1 = "Pay Status";
		WebElement table1 = driver.findElement(By.xpath("//table[@id='leavehome']/thead/tr"));
		List<WebElement> heading1 = table1.findElements(By.tagName("th"));
		for (int h1 = 1; h1 < heading1.size(); h1++) {
			String text1 = heading1.get(h1).getText();
			if (col_text1.equalsIgnoreCase(text1)) {
				int col1 = h1;
				WebElement row_table1 = driver.findElement(By.xpath("//table[@id='leavehome']/tbody"));
				List<WebElement> rows1 = row_table1.findElements(By.tagName("tr"));
				logger.info(rows1.size());
				for (int c1 = 1; c1 < rows1.size(); c1++) {
					// logger.info("Column Country is present in the heading");
					logger.info(c1);
					String cell_Value1 = driver
							.findElement(By.xpath("//table[@id='leavehome']/tbody/tr[" + c1 + "]/td[" + (col1 + 1) + "]"))
							.getText();
					Waitfor(2);
					if (cell_Value1.equalsIgnoreCase("Amount")) {
						driver.findElement(By.xpath("//table[@id='leavehome']/tbody/tr[" + c1 + "]/td[1]")).click();
						Waitfor(2);
						}
				}
			}
		
	}
}
	public void downloadHDFCreport()
	{
		DownloadHDFCBank_Report_Button.click();
	}
	
	public void payHDFCreport()
	{
		DownloadHDFC_PayButton.click();
		Waitfor(1);
		DownloadHDFC_Pay_MsgokayButton.click();
		
	}
	
	public void uploadHDFCreport(String file_description)
	{
		DownloadHDFC_UploadButton.click();
		
		boolean status= UploadHDFC_uploadbutton.isEnabled();
		String upload_status= UploadHDFC_uploadstatus.getAttribute("inner html");
		logger.info("Upload file status is - "+upload_status);
		if(status==false)
		{
			UploadHDFC_BrowseButton.click();
			//Autoit functionality has to be implemented here...!!
			
		}
		else
		{
			logger.info("Upload Button is enabled, It's a bug");
		}
		String fileuploaded_status= UploadHDFC_uploadstatus.getAttribute("inner html");
		logger.info("Upload file status is - "+fileuploaded_status);
		//To check whether File Upload input field is editable or not
	  	WebElement fieldName = driver.findElement(By.id("enter_id"));
	    fieldName.sendKeys("Testing it now");
	    String fieldNameVal = fieldName.getAttribute("value");
	    if(fieldNameVal.contentEquals("Testing it now")){
	    logger.info("Field is editable");
	    }
	    else
	    {
	    logger.info("Field is non editable" + fieldNameVal);
	    }
	    Waitfor(2);
	    boolean status1= UploadHDFC_uploadbutton.isEnabled();
	    if(status1==true)
		{
			 UploadHDFC_uploadbutton.click();
			 Waitfor(1);
			 UploadHDFC_mandaErrormsg.click();
			
		}
		else
		{
			logger.info("Upload Button is disable");
		}
	    
	    Waitfor(2);
	    UploadHDFC_Filedescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), file_description);
	    Waitfor(1);
	    UploadHDFC_uploadbutton.click();
	    Waitfor(1);
	    UploadHDFC_okayMSG.click();
	    
	    
	}
	public void upload_Cancelbutton()
	{
		UploadHDFC_cancelbutton.click();
	}
	public void downloadhdfc_Closebutton()
	{
		DownloadHDFC_Close_Button.click();
	}
	
	//Other Bank report 
	

	public void other_Bankreport(String company, String Region, String Department)
	{
		//Company dropdown selection
		Select dropdown0 = new Select(OtherBank_Company);
		dropdown0.selectByVisibleText(company);
		Waitfor(1);
		//Region dropdown selection
		Select dropdown1 = new Select(OtherBank_Region);
		dropdown1.selectByVisibleText(Region);
		Waitfor(1);
		//Department dropdown selection
		Select dropdown2 = new Select(OtherBank_Department);
		dropdown2.selectByVisibleText(Department);
		Waitfor(1);
		
		//Traversing in the webtable to select paid/unpaid employees
		String col_text1 = "Pay Status";
		WebElement table1 = driver.findElement(By.xpath("//table[@id='leavehome']/thead/tr"));
		List<WebElement> heading1 = table1.findElements(By.tagName("th"));
		for (int h1 = 1; h1 < heading1.size(); h1++) {
			String text1 = heading1.get(h1).getText();
			if (col_text1.equalsIgnoreCase(text1)) {
				int col1 = h1;
				WebElement row_table1 = driver.findElement(By.xpath("//table[@id='leavehome']/tbody"));
				List<WebElement> rows1 = row_table1.findElements(By.tagName("tr"));
				logger.info(rows1.size());
				for (int c1 = 1; c1 < rows1.size(); c1++) {
					// logger.info("Column Country is present in the heading");
					logger.info(c1);
					String cell_Value1 = driver
							.findElement(By.xpath("//table[@id='leavehome']/tbody/tr[" + c1 + "]/td[" + (col1 + 1) + "]"))
							.getText();
					Waitfor(2);
					if (cell_Value1.equalsIgnoreCase("Amount")) {
						driver.findElement(By.xpath("//table[@id='leavehome']/tbody/tr[" + c1 + "]/td[1]")).click();
						Waitfor(2);
						}
				}
			}
		
	}
}
	public void downloadother_Bankreport()
	{
		OtherBankBank_Report_Button.click();
	}
	
	public void payother_Bankreport()
	{
		OtherBank_PayButton.click();
		Waitfor(1);
		OtherBank_Pay_MsgokayButton.click();
		
	}
	
	public void uploadother_Bankreport(String file_description)
	{
		OtherBank_UploadButton.click();
		
		boolean status= OtherBankupload_uploadbutton.isEnabled();
		String upload_status= OtherBankupload_uploadstatus.getAttribute("inner html");
		logger.info("Upload file status is - "+upload_status);
		if(status==false)
		{
			OtherBankupload_BrowseButton.click();
			//Autoit functionality has to be implemented here...!!
			
		}
		else
		{
			logger.info("Upload Button is enabled, It's a bug");
		}
		String fileuploaded_status= OtherBankupload_uploadstatus.getAttribute("inner html");
		logger.info("Upload file status is - "+fileuploaded_status);
		//To check whether File Upload input field is editable or not
	  	WebElement fieldName = driver.findElement(By.id("enter_id"));
	    fieldName.sendKeys("Testing it now");
	    String fieldNameVal = fieldName.getAttribute("value");
	    if(fieldNameVal.contentEquals("Testing it now")){
	    logger.info("Field is editable");
	    }
	    else
	    {
	    logger.info("Field is non editable" + fieldNameVal);
	    }
	    Waitfor(2);
	    boolean status1= OtherBankupload_uploadbutton.isEnabled();
	    if(status1==true)
		{
			 OtherBankupload_uploadbutton.click();
			 Waitfor(1);
			 OtherBankupload_mandaErrormsg.click();
			
		}
		else
		{
			logger.info("Upload Button is disable");
		}
	    
	    Waitfor(2);
	    OtherBankupload_Filedescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), file_description);
	    Waitfor(1);
	    OtherBankupload_uploadbutton.click();
	    Waitfor(1);
	    OtherBankupload_okayMSG.click();
	    
	    
	}
	public void other_Bankupload_Cancelbutton()
	{
		OtherBankupload_cancelbutton.click();
	}
	public void downloadother_Bank_Closebutton()
	{
		OtherBank_Close_Button.click();
	}
	
	public void object_init_creation()
	{
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.leaves(driver);
		ObjectInitClass.reimbursement(driver);
		ObjectInitClass.timesheet(driver);
		ObjectInitClass.roll_On(driver);
	}
	
	public void specialist_rmz_login()
	{
		// Repository object creation.
				object_init_creation();
				
				// Read Excel object creation to pass the sheet parameter.
				String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
				Waitfor(1);
				String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
				Waitfor(1);
				//Login with Speacilalist RMZ for initiating the Perdiem.
				ObjectInitClass.LP.signIn(username, password);
				Waitfor(3);
				
				ObjectInitClass.HP.My_Lynx();
				perdiemsubmodule();
				
				Waitfor(2);
	}
	
	public void specialist_RMZ_Initiate()
	{
		// Repository object creation.
		object_init_creation();
		
		// Read Excel object creation to pass the sheet parameter.
		String username= excelreaddata().getData("Login_Credentials", 14, 0 ); //Reading Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 14, 1 ); //Reading Password from excel
		Waitfor(1);
		//Login with Speacilalist RMZ for initiating the Perdiem.
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);
		
		ObjectInitClass.HP.My_Lynx();
		perdiemsubmodule();
		
		Waitfor(2);
		//Initiating the perdiem manually by specialist RMZ
		initiateperdiem();
		Waitfor(3);
		initiateperdiem_MsgYes();
		Waitfor(3);
		re_initiateperdiemMsgYes();
		Waitfor(3);
		
		//
		Waitfor(3);
		report_id= perdiemreport_table("Report Generated", "USD", "77");
		logger.info("Current Perdiem generated Report ID is : "+report_id);
		Waitfor(2);
		
	}
	
	public void Lead_RMZ()
	{
		// Repository object creation.
		object_init_creation();
	
		// Read Excel object creation to pass the sheet parameter.
		String username1= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		Waitfor(1);
		String password1= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		Waitfor(1
				);
		//Login with Lead RMZ for initiating the Perdiem.
		ObjectInitClass.LP.signIn(username1, password1);
		Waitfor(3);
		
		// Validating perdiem module page URL
		ObjectInitClass.HP.My_Lynx();
		Waitfor(2);
		perdiemsubmodule();
		Waitfor(2);
		
		perdiemreport_table("Submitted", "USD", "77");
		Waitfor(2);
	}
	
	public void Finance_Analyst()
	{
		// Repository object creation.
		object_init_creation();
		// Read Excel object creation to pass the sheet parameter.
				String username2= excelreaddata().getData("Login_Credentials", 5, 0 ); //Reading Username from excel
				Waitfor(1);
				String password2= excelreaddata().getData("Login_Credentials", 5, 1 ); //Reading Password from excel
				Waitfor(1);
						
				//Login with Financial Analyst for initiating the Perdiem.
				ObjectInitClass.LP.signIn(username2, password2);
				Waitfor(4);
				
				// Validating perdiem module page URL
				ObjectInitClass.HP.My_Lynx();
				Waitfor(2);
				perdiemsubmodule();
				Waitfor(2);
				perdiemreport_table("Reviewed and Submitted", "USD", "77");
				Waitfor(1);
	}
	
	public void Finance_Manager()
	{
		// Repository object creation.
		object_init_creation();
		
		// Read Excel object creation to pass the sheet parameter.
		String username3= excelreaddata().getData("Login_Credentials", 6, 0 ); //Reading Username from excel
		Waitfor(1);
		String password3= excelreaddata().getData("Login_Credentials", 6, 1 ); //Reading Password from excel
		Waitfor(1);
		//Login with Finance Manager for initiating the Perdiem.
		ObjectInitClass.LP.signIn(username3, password3);
		Waitfor(2);
		
		// Validating perdiem module page URL
		ObjectInitClass.HP.My_Lynx();
		ObjectInitClass.per.perdiemsubmodule();
		Waitfor(2);
		ObjectInitClass.per.perdiemreport_table("Reviewed and Approved", "USD", "77");
		Waitfor(2);
	}
	
	public void CEO()
	{
		// Repository object creation.
		object_init_creation();
		
		// Read Excel object creation to pass the sheet parameter.
		String username4= excelreaddata().getData("Login_Credentials", 7, 0 ); //Reading Username from excel
		Waitfor(1);
		String password4= excelreaddata().getData("Login_Credentials", 7, 1 ); //Reading Password from excel
		Waitfor(1
				);
		//Login with Financial Analyst for initiating the Perdiem.
		ObjectInitClass.LP.signIn(username4, password4);
		Waitfor(2);
		
		// Validating perdiem module page URL
		ObjectInitClass.HP.My_Lynx();
		perdiemsubmodule();
		Waitfor(1);
		perdiemreport_table("Accepted", "USD", "77");
		Waitfor(2);				
	}				
	

	public void Finance_Manager_complete()
	{
		// Repository object creation.
		object_init_creation();
		
		// Read Excel object creation to pass the sheet parameter.
		String username3= excelreaddata().getData("Login_Credentials", 6, 0 ); //Reading Username from excel
		Waitfor(1);
		String password3= excelreaddata().getData("Login_Credentials", 6, 1 ); //Reading Password from excel
		Waitfor(1);
		//Login with Finance Manager for initiating the Perdiem.
		ObjectInitClass.LP.signIn(username3, password3);
		Waitfor(2);
		
		// Validating perdiem module page URL
		ObjectInitClass.HP.My_Lynx();
		ObjectInitClass.per.perdiemsubmodule();
		Waitfor(2);
		ObjectInitClass.per.perdiemreport_table("Approved", "USD", "77");
		Waitfor(2);
	}
}