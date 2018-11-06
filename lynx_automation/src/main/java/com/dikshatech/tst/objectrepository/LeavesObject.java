package  com.dikshatech.tst.objectrepository;

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
import com.dikshatech.tst.utilitylibrary.Scrolling;

public class LeavesObject extends TestBase {


    JavascriptExecutor jse= (JavascriptExecutor)driver;

	@Test
	public LeavesObject(WebDriver driver) {
		this.driver = driver;
	}

	// Apply Leave page elements repository
	
	@FindBy(xpath = "//li[@id='leaves']")                                      WebElement Leaves_Submodule;
	@FindBy(xpath = "//button[@id='applyleave']")                              WebElement Apply_Leave;
	@FindBy(xpath = "//button[@id='editleave']")                               WebElement Edit_Leave;
	@FindBy(xpath = "//button[@id='cancelleave']")                             WebElement Cancel_Leave;
	@FindBy(xpath = "//span[@id='leaveAccumalated_save']")                     WebElement Total_Leave;
	@FindBy(xpath = "//span[contains(@id,'leaveBalance_save')]")               WebElement Balance_Leave;
	@FindBy(xpath = "//span[@id='leavesTaken_save']")                          WebElement Availed_Leaves;
    @FindBy(xpath = "//select[@name='leave_home_length']")                     WebElement Count_Dropdown;
	@FindBy(xpath = "//input[@type='search']")                                 WebElement Search_Box_Leaves;
	@FindBy(xpath = "//input[@aria-controls='toApprove_leave_home']")          WebElement Search_Box_ToApprove;
	@FindBy(xpath = "//input[@aria-controls='toHandle_leave_home']")           WebElement Search_Box_ToHandle;
	@FindBy(xpath = "//div[@id='leave_home_info']")                            WebElement TableCount_Info;
	@FindBy(xpath = "//a[contains(@id,'previous')]")                           WebElement PreviousTable_Button;
	@FindBy(xpath = "//a[contains(@id,'next')]")                               WebElement NextTable_Button;
	@FindBy(xpath = "//a[@class='paginate_button current']")                   WebElement Pagination_Number;
	@FindBy(xpath = "//span[@id='total_leave']")                               WebElement T_Leave;
	@FindBy(xpath = "//span[@id='balance_leave']")                             WebElement B_Leave;
	@FindBy(xpath = "//span[@id='availed_leave']")                             WebElement A_Leave;
	@FindBy(xpath = "//h4[contains(.,'Apply Leave')]")                         WebElement Applyleave_Form;
	@FindBy(xpath = "//span[contains(.,'Project Name is required!!!!')]")      WebElement Project_Errormsg;
	@FindBy(xpath = "//span[contains(.,'Charge Code is required!!!!')]")       WebElement Charge_Errormsg;
	@FindBy(xpath = "//span[contains(.,'Leave Type is required!!!!')]")        WebElement Leavetype_Errormsg;
	@FindBy(xpath = "//span[contains(.,'Select From Date!!!!')]")              WebElement Fromdate_Errormsg;
	@FindBy(xpath = "//div[contains(.,'XSelect To Date!!!!')]")                WebElement Todate_Errormsg;
	@FindBy(xpath = "//span[@class='process']")                                WebElement Reason_Errormsg;
	@FindBy(xpath = "//span[contains(.,'Contact No is required!!!!')]")        WebElement Contact_Errormsg1;
	@FindBy(xpath = "//input[@id='fdate']")                                    WebElement From_Input;
	@FindBy(xpath = "//input[@id='todate']")                                   WebElement To_Input;
	@FindBy(xpath = "//input[@max='365']")                                     WebElement Total_Days;
	@FindBy(xpath = ".//textarea[@id='reason']")                               WebElement Reason_Input;                                                                        
	@FindBy(xpath = "//input[@id='contact']")                                  WebElement Contact_Box;
	@FindBy(xpath = "//button[@id='applysubmit']")                             WebElement Apply_Button;
	@FindBy(xpath = "//span[contains(.,'Leave Applied Successfully.')]")       WebElement Applied_leave;
	@FindBy(xpath = "//span[contains(.,'File Description is required!!!!')]")  WebElement FileDescription_Errormsg;
	@FindBy(xpath = "//select[@id='projectNames']")                            WebElement Project_Name;
	@FindBy(xpath = "//select[@id='chargecode']")                              WebElement Charge_Code;
	@FindBy(xpath = "//select[@id='leaveType']")                               WebElement Leaves_Type;
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")      WebElement Prev_Month;
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")      WebElement Next_Month;
	@FindBy(xpath = "//div[@id='toaster']")                                    WebElement MessageBox;
	@FindBy(xpath = "//*[@id='leave_home']/tbody/tr[1]/td[1]")                 WebElement Leaveid;
	@FindBy(xpath= "//*[@id='toApprove_leave_home']/tbody/tr[1]/td[1]")        WebElement Leaveid_request_RM;
	@FindBy(xpath= "//*[@id='toHandle_leave_home']/tbody/tr[1]/td[1]")        WebElement Leaveid_request_FM;
	// Edit Leave page elements repository
	@FindBy(xpath = "//span[@id='leaveAccumalated_edit']")                     WebElement Edit_T_Leave;
	@FindBy(xpath = "//span[@id='leaveBalance_edit']")                         WebElement Edit_B_Leave;
	@FindBy(xpath = "//span[@id='leavesTaken_edit']")                          WebElement Edit_A_Leave;
	@FindBy(xpath = "//select[@id='projectNames']")                            WebElement Edit_Projectname;
	@FindBy(xpath = "//select[@id='chargecode']")                              WebElement Edit_Chargecode;
	@FindBy(xpath = "//select[@id='leaveType']")                               WebElement Edit_Leavetype;
	@FindBy(xpath = "//input[@id='fdate']")                                    WebElement Edit_Fromdate;
	@FindBy(xpath = "//input[@id='todate']")                                   WebElement Edit_Todate;
	@FindBy(xpath = "//input[@id='duration']")                                 WebElement Edit_TotalDays;
    @FindBy(xpath = "//textarea[@id='reason']")                                WebElement Edit_Reason;
	@FindBy(xpath = "//input[@id='contact']")                                  WebElement Edit_Contact;
	@FindBy(xpath ="//span[contains(.,'Leave Updated Successfully.')]")        WebElement updatedmessage;
	@FindBy(xpath = "//input[@name='descriptions']")                           WebElement Edit_Filedescription;
	// Cancel Leave page elements repository
	@FindBy(xpath ="//button[contains(.,'Cancel Request')]")                   WebElement Cancel_RequestButton;
	@FindBy(xpath = "//button[@id='cancelConfirmLeave']")                      WebElement CancelConfimration_Yes;
	@FindBy(xpath = ".//*[@id='genericModal-size']/div/div[1]/button")         WebElement CancelConfimration_No;
	@FindBy(xpath ="//span[contains(.,'Leave cancelled  request submitted successfully.')]") WebElement Cancel_SuccessMsgOK;
	//RM 
	@FindBy(xpath="//a[@id='toApproveIdLeave']")                               WebElement To_approve;
	@FindBy(xpath="//button[@id='approveId']")                                 WebElement approve_Leave;
	@FindBy(xpath="//a[contains(.,'To Approve')]")                             WebElement COMPLETE_BUTTON;
	@FindBy(xpath="//button[@id='rejectId']")                                  WebElement reject;
	@FindBy(xpath="//button[@id='assignId']")                                  WebElement assign;
	@FindBy(xpath="//textarea[@id='remark']")                                  WebElement entercomments;
	@FindBy(xpath="//button[contains(@onclick,'genericSaveOrSubmit(')]")       WebElement submit_button;
	@FindBy(xpath="//button[contains(.,'Close')]")                             WebElement close_button;
	@FindBy(xpath="//button[@onclick='assign()']")                             WebElement assigned_to;
	@FindBy(xpath= "//*[@id='leave_home']/tbody/tr[1]")                        WebElement request_raised;
	@FindBy(xpath= "//*[@id='toApprove_leave_home']/tbody/tr[1]/td[1]")        WebElement select_request_raised;
	@FindBy(xpath= "//textarea[@id='leaves_comments']")                        WebElement assigning_comments;
	//RMG
	@FindBy(xpath= "//a[@id='leaveToHandle']")                                 WebElement to_handle;
	@FindBy(xpath="//button[@id='btnLeaveToHandleAssign']")                    WebElement fm_assign;
	@FindBy(xpath="//button[@id='btnLeaveToHandleComplete']")                  WebElement fm_tocomplete;
	@FindBy(xpath="//textarea[@id='leaveToHandleCompComments']")               WebElement fm_approve_comments;
	@FindBy(xpath="//button[@id='onLeaveToHandleCompleteGen']")                WebElement fm_complete_leave;
	String Leave_ID="IN-LV-2812";
	String candStatus="Request Raised";
	
	public void My_Lynx()
    {
    	WebElement lynx= driver.findElement(By.xpath("//a[contains(.,'My Lynx')]"));
    	lynx.click();
    	Waitfor(2);
    }
    
	public void Leave_Module()
	{
		Leaves_Submodule.click();
		Waitfor(2);
	}

	public void Applyleave() {
		Apply_Leave.click();
		Waitfor(2);
	}
	public void complete_leave()
	{
		COMPLETE_BUTTON.click();
	}

	public void LeaveHP_Validation() {
		// Apply button validation
		boolean Apply_button = Apply_Leave.isDisplayed();
		if (Apply_button == true) {
			logger.info("Apply Leave button is enable and status is :" + Apply_button);
		} else {
			logger.info("Apply Leave button is disable and status is :" + Apply_button);
		}
		// Edit button validation
		boolean Edit_Button = Edit_Leave.isDisplayed();
		if (Edit_Button == true) {
			logger.info("Edit button is enable and status is :" + Edit_Button);
		} else {
			logger.info("Edit button is disable and status is :" + Edit_Button);
		}
		// Cancel button validation
		boolean Cancel_Button = Cancel_Leave.isDisplayed();
		if (Cancel_Button == true) {
			logger.info("Cancel button is enable and status is :" + Cancel_Button);
		} else {
			logger.info("Cancel button is disable and status is :" + Cancel_Button);
		}

	}
	public void Apply_Leave_details()
	{
	
		Apply_Button.click();
		
	}
	public void rm_approve()
	{
		To_approve.click();
	}
	public void approve()
	
	{
		approve_Leave.click();
		Waitfor(2);
		
	}
	public void Enter_comments()
	{
		entercomments.sendKeys("leave request has been approved");
	}
	public void submit_comments()
	{
		submit_button.click();
	}
	public void close_comments()
	{
		close_button.click();
	}
	
	public void Reject_leave()
	{
		
		Waitfor(2);
		reject.click();
	}
	
	public void assign_leave()
	{
		Waitfor(2);
		assign.click();
		Waitfor(1);
	}
	
	public void assigned_to_comments()
	{
		assigning_comments.sendKeys("leave request has been approved");
	}
	
	public void UPDATE_LEAVE(String Edit_projectname, String Edit_chargecode, String Edit_leavetype, String Edit_Reason_Text,
			String Edit_Contact_Number, int Edit_F_Date, int Edit_T_Date)
	{

		Edit_Leave.click();
		Waitfor(3);	
		EditLeaves_Calculation();
		Waitfor(2);
		Select Pro_Dropdown = new Select(Project_Name);
		logger.info("The Entered Project Name is " + Edit_projectname);

		List<WebElement> length = Pro_Dropdown.getOptions();
		int size = length.size();
		logger.info("Total No. of Dropdown values are : " + size);
		String Text = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			Text = length.get(i).getText();
			sb = sb.append(Text).append(",");
			Waitfor(2);
		}
		logger.info("The Projects names are -: " + sb.toString());
		Pro_Dropdown.selectByVisibleText(Edit_projectname);
		Waitfor(1);
		Select Charge_Dropdown = new Select(Charge_Code);
		logger.info("The Entered Project Name is " +  Edit_chargecode);
		Charge_Dropdown.selectByVisibleText( Edit_chargecode);
		List<WebElement> length1 = Charge_Dropdown.getOptions();
		int size1 = length1.size();
		logger.info("Total No. of Dropdown values are : " + size1);
		String Text1 = null;
		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < size1; i++) {
			Text1 = length1.get(i).getText();
			sb1 = sb1.append(Text1).append(",");
			Waitfor(1);
		}
		logger.info("The Projects names are -: " + sb.toString());
		Waitfor(1);
		Select LeaveType_Dropdown = new Select(Leaves_Type);
		logger.info("The Entered Project Name is " +  Edit_leavetype);
		List<WebElement> length2 = LeaveType_Dropdown.getOptions();
		int size2 = length2.size();
		logger.info("Total No. of Dropdown values are : " + size2);
		String Text2 = null;
		StringBuffer sb2 = new StringBuffer();
		for (int i = 0; i < size2; i++) {
			Text2 = length2.get(i).getText();
			sb2 = sb2.append(Text2).append(",");
			Waitfor(1);
		}
		logger.info("The Projects names are -: " + sb2.toString());
		LeaveType_Dropdown.selectByVisibleText( Edit_leavetype);
		Waitfor(1);
		From_Input.click();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//NextMonth();
		List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_nodes = dates.size();
		logger.info("Calendar Date size is : " + total_nodes);
		for (int i = 0; i < total_nodes; i++) {
			String date = dates.get(i).getText();
			// dates.get(i).click();
			// logger.info("Selected date is: "+date);
			if (date.equals(Integer.toString( Edit_F_Date))) {
				dates.get(i).click();
				logger.info("Selected date is: " + date);
				break;

			}
		}
		Waitfor(1);
		To_Input.click();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();

		//NextMonth();
		List<WebElement> dates1 = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_nodes1 = dates1.size();
		logger.info("Calendar Date size is : " + total_nodes1);
		for (int i = 0; i < total_nodes1; i++) {
			String date1 = dates1.get(i).getText();
			// dates.get(i).click();
			// logger.info("Selected date is: "+date);
			if (date1.equals(Integer.toString( Edit_T_Date))) {
				dates1.get(i).click();
				logger.info("Selected date is: " + date1);
				break;

			}
		}

		Waitfor(2);
		Reason_Input.clear();
		Waitfor(1);
		Reason_Input.sendKeys( Edit_Reason_Text);
		Waitfor(1);
		Edit_Contact.clear();
		Waitfor(2);
		Edit_Contact.sendKeys( Edit_Contact_Number);
		
		Apply_Button.click();
	}	
		
	public void updted_sucessfullymsg()
	{
		boolean edit_msg=updatedmessage.isDisplayed();
		if(edit_msg==true)
		{
			String update_msg=updatedmessage.getText();
			logger.info(update_msg);
		}
		
		
	}
		
	
	public void Leaves_Status(String Status) 
	{
		Actions action = new Actions(driver);
		int count = 0;
		String fail= "";
		String col_text = "Status";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='leave_home_paginate']/span/a"));
		if (page.size() > 0)
		{
		for (int i = 1; i <=page.size(); i++) 
		{
			if(i>1)
			{	
			driver.findElement(By.xpath("//div[@id='leave_home_paginate']/span/a[" + (i) + "]")).click();
			Waitfor(1);
			}
		WebElement table = driver.findElement(By.xpath("//table[@id='leave_home']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='leave_home']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c <= rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='leave_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
							.getText();
					Waitfor(2);
					String array[] = { "Request Raised", "Approved", "Rejected", "Pending Approval" };
						
						String  s= driver.findElement(By.xpath("//table[@id='leave_home']/tbody/tr[" + c + "]/td[7]")).getText();
						if (cell_Value.equalsIgnoreCase(Status)) 	
						{
						logger.info("Status is matching with the passed status & Status is "+s);
						
						Waitfor(2);
						
			count++;
			break;
						}
			else 
			{
			logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
		   fail = "No Match found";	
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
			
			

		 

			
		
	

	

	public void edit_ReadData()

	{
	
		String projectname = Edit_Projectname.getText();
		logger.info("It is reading the data "+projectname);
		String chargecode = Edit_Chargecode.getText();
		logger.info("It is reading the charge"+chargecode);
		String Leavetype = Edit_Leavetype.getText();
		logger.info("It is reading the leave"+Leavetype);
		String fromdate = Edit_Fromdate.getText();
		logger.info("It is reading the from"+fromdate);
		String todate = Edit_Todate.getText();
		logger.info("It is reading the to"+todate);
		String Totaldays = Edit_TotalDays.getText();
		logger.info("It is reading the Total"+Totaldays);
		String Reason = Edit_Reason.getText();
		logger.info("It is reading the Reason"+Reason);
		String contactno = String.valueOf(Edit_Contact.getText());
		logger.info("It is reading the contact"+contactno);

		String filedescription = Edit_Filedescription.getText();

		
		
	}
	
		public void Cancel_Page() {
		
		                 request_raised.click();
						boolean Cancel_Button = Cancel_Leave.isEnabled();
						if (Cancel_Button == true) {
							logger.info("Cancel button is enable and status is :" + Cancel_Button);
							Cancel_Leave.click();
							Waitfor(2);
							
						} else {
							logger.info("Cancel button is disable and status is :" + Cancel_Button);
						}
						
	}

	
	public void Entries_Count_Dropdown(String Count) {
		Select Dropdown = new Select(driver.findElement(By.name("leave_home_length")));

		logger.info("The Entered Count is " + Count);

		List<WebElement> length = Dropdown.getOptions();
		int size = length.size();
		logger.info("Total No. of Dropdown values are : " + size);

		String value = null;
		StringBuffer sb = new StringBuffer();
		// for(int i=0; i<size; i++)
		for (WebElement string : length) {
			value = string.getText();

			sb = sb.append(value).append(",");
		}
		logger.info(sb.toString());
		Dropdown.selectByVisibleText(Count);
	}

	public String Count_Selected() {
		String count = Count_Dropdown.getText();
		return count;
	}

	public void SearchBox(String text) {
		Search_Box_Leaves.sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
	}

	public void Count_Entry_Display() {
		String text = TableCount_Info.getText();
		logger.info(text);
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

	public void Pagination() {
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='leave_home_paginate']/span/a"));

		if (page.size() > 0) {
			for (int i = 0; i < page.size(); i++) {
				String text1 = "//div[@id='leave_home_paginate']/span/a[";
				String text2 = "";
				driver.findElement(By.xpath("//div[@id='leave_home_paginate']/span/a[" + (i + 1) + "]")).click();
				Waitfor(3);
				for (int j = page.size(); j > 0; j--) {
					driver.findElement(By.xpath("//div[@id='leave_home_paginate']/span/a[" + (j) + "]")).click();
					Waitfor(2);
				}
			}
		} else {
			logger.info("There is no Pagination number present");
		}
	}

	//1. Leave Home Page Calculation
	
	public void Leaves_Calculation() {
		String s1 = T_Leave.getText();
		float Total1 = Float.parseFloat(s1);
		logger.info("total Leaves are : " +Total1);
		String s2 = B_Leave.getText();
		float Total2 = Float.parseFloat(s2);
		logger.info("Balance Leaves are: " + Total2);
		String s3 = A_Leave.getText();
		float Total3 = Float.parseFloat(s3);
		logger.info("Applied Leaves are: " +Total3);

		float BalanceLeave = Total1 - Total3;
		if (BalanceLeave == Total2) {
			logger.info("Balance Leaves is correct: " + BalanceLeave);
		} else {
			logger.info("Balance Leaves is incorrect: " + BalanceLeave);
		}
	}

	
	
	
	//2. Leave Leaveform Page Calculation
	
	public void Leavesform_Calculation() {
		String s1 = Total_Leave.getText();
		float Total1 = Float.parseFloat(s1);
		logger.info("total Leaves are : " +Total1);
		String s2 = Balance_Leave.getText();
		float Total2 = Float.parseFloat(s2);
		logger.info("Balance Leaves are: " + Total2);
		String s3 = Availed_Leaves.getText();
		float Total3 = Float.parseFloat(s3);
		logger.info("Applied Leaves are: " +Total3);

		float BalanceLeave = Total1 - Total3;
		if (BalanceLeave == Total2) 
		{
			logger.info("Balance Leaves is correct: " + BalanceLeave);
		} else {
			logger.info("Balance Leaves is incorrect: " + BalanceLeave);
		}
	}

	//3. Leave Edit Page Calculation
	public void EditLeaves_Calculation() {
		String s1 = Edit_T_Leave.getText();
		float Total1 = Float.parseFloat(s1);
		logger.info("total Leaves are : " +Total1);
		String s2 = Edit_B_Leave.getText();
		float Total2 = Float.parseFloat(s2);
		logger.info("Balance Leaves are: " + Total2);
		String s3 = Edit_A_Leave.getText();
		float Total3 = Float.parseFloat(s3);
		logger.info("Applied Leaves are: " +Total3);

		float BalanceLeave = Total1 - Total3;
		if (BalanceLeave == Total2) {
			logger.info("Balance Leaves is correct: " + BalanceLeave);
		} else {
			logger.info("Balance Leaves is incorrect: " + BalanceLeave);
		}
	}
	
	
	//3.Filling leave form and raising a request
	public void Leave_Form(String projectname, String chargecode, String leavetype, String Reason_Text,
			String Contact_Number, int F_Date, int T_Date) {
		
		String form = Applyleave_Form.getAttribute("innerText");
		if (form.equalsIgnoreCase("Apply Leave")) {
			logger.info("Leave form is present"+form);
		} else {
			logger.info("Leave form is not present");
		}

		Select Pro_Dropdown = new Select(Project_Name);
		logger.info("The Entered Project Name is " + projectname);
		List<WebElement> length = Pro_Dropdown.getOptions();
		int size = length.size();
		logger.info("Total No. of Dropdown values are : " + size);
		String Text = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			Text = length.get(i).getText();
			sb = sb.append(Text).append(",");	
		}
		logger.info("The Projects names are -: " + sb.toString());
		Pro_Dropdown.selectByVisibleText(projectname);
		Waitfor(1);
		Select Charge_Dropdown = new Select(Charge_Code);
		logger.info("The Entered Project Name is " + chargecode);
		Charge_Dropdown.selectByVisibleText(chargecode);
		List<WebElement> length1 = Charge_Dropdown.getOptions();
		int size1 = length1.size();
		logger.info("Total No. of Dropdown values are : " + size1);
		String Text1 = null;
		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < size1; i++) {
			Text1 = length1.get(i).getText();
			sb1 = sb1.append(Text1).append(",");
			Waitfor(1);
		}
		logger.info("The Projects names are -: " + sb1.toString());
		Select LeaveType_Dropdown = new Select(Leaves_Type);
		logger.info("The Entered Project Name is " + leavetype);
		List<WebElement> length2 = LeaveType_Dropdown.getOptions();
		int size2 = length2.size();
		logger.info("Total No. of Dropdown values are : " + size2);
		String Text2 = null;
		StringBuffer sb2 = new StringBuffer();
		for (int i = 0; i < size2; i++) {
			Text2 = length2.get(i).getText();
			sb2 = sb2.append(Text2).append(",");
		}
		logger.info("The Projects names are -: " + sb2.toString());
		LeaveType_Dropdown.selectByVisibleText(leavetype);
		Waitfor(1);
		From_Input.click();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//NextMonth();
		List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));
		int total_nodes = dates.size();
		logger.info("Calendar Date size is : " + total_nodes);
		for (int i = 0; i < total_nodes; i++) {
			String date = dates.get(i).getText();
			// dates.get(i).click();
			// logger.info("Selected date is: "+date);
			if (date.equals(Integer.toString(F_Date))) {
				dates.get(i).click();
				logger.info("Selected date is: " + date);
				break;
			}
		}

		Waitfor(1);
		To_Input.click();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();
		//PreviousMonth();

		//NextMonth();
		List<WebElement> dates1 = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_nodes1 = dates1.size();
		logger.info("Calendar Date size is : " + total_nodes1);
		for (int i = 0; i < total_nodes1; i++) {
			String date1 = dates1.get(i).getText();
			// dates.get(i).click();
			// logger.info("Selected date is: "+date);
			if (date1.equals(Integer.toString(T_Date))) {
				dates1.get(i).click();
				logger.info("Selected date is: " + date1);
				break;
			}
		}
		String totaldays = Total_Days.getText();
		logger.info("No. of days applied for leave" + totaldays);
		Waitfor(1);
		Reason_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Reason_Text);
		Waitfor(1);
		Contact_Box.sendKeys(Keys.chord(Keys.CONTROL, "a"), Contact_Number);
		logger.info("Contact Number is ...:" + Contact_Number);
	    driver.findElement(By.xpath("//input[@id='uploadfileName']")).sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
	    logger.info("Upload Button is enabled");	
	    driver.findElement(By.xpath("//input[@id='descriptions_for_upload']")).sendKeys("file_uploaded");
	    Waitfor(1);
		Apply_Button();
		Waitfor(2);
		Message_Ok();
		
		
	}

	public void PreviousMonth() {
		Prev_Month.click();
		Waitfor(1);
	}

	public void NextMonth() {
		Next_Month.click();
		Waitfor(1);
	}

	public void Apply_Button() {
		
		Apply_Button.click();
	}

	public void Message_Ok() 
	{
		String sucess_msg= Applied_leave.getText();
		logger.info(sucess_msg);
		
	}

	public void Cancel_Button() {
		 CancelConfimration_Yes.click();
	}
	
	public void CancelRequest()
	{
		Cancel_RequestButton.click();
	}
	public void CancelClose()
	{
		CancelConfimration_No.click();
	}
	public void CancelSuccessmsg()
	{
	String cancel_msg=	Cancel_SuccessMsgOK.getText();
	logger.info(cancel_msg);
	}
	public String editleave( String status)
	{

	    //My_Lynx();
		 Waitfor(2);
		//Leaves_Submodule.click();
		 Waitfor(2);
		 String Leave_ID= Leaveid.getText();
		 Search_Box_Leaves.sendKeys(Keys.chord(Keys.CONTROL, "a"),Leave_ID);
			Waitfor(1);
			Actions action = new Actions(driver);
			int count = 0;
			String fail= "";
			String col_text = "ID";
			List<WebElement> page = driver.findElements(By.xpath("//div[@id='leave_home_paginate']/span/a"));
			if (page.size() > 0) {
			for (int i = 1; i <=page.size(); i++) 
			{
				if(i>1)
				{	
				driver.findElement(By.xpath("//div[@id='leave_home_paginate']/span/a[" + (i) + "]")).click();
				Waitfor(1);
				}
			WebElement table = driver.findElement(By.xpath("//table[@id='leave_home']/thead/tr"));
			List<WebElement> heading = table.findElements(By.tagName("th"));
			for (int h = 0; h < heading.size(); h++) {
				String text = heading.get(h).getText();
				if (col_text.equalsIgnoreCase(text)) {
					int col = h;
					WebElement row_table = driver.findElement(By.xpath("//table[@id='leave_home']/tbody"));
					List<WebElement> rows = row_table.findElements(By.tagName("tr"));
					logger.info(rows.size());
					for (int c = 1; c <= rows.size(); c++) {
						
						String cell_Value = driver
								.findElement(By.xpath("//table[@id='leave_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
								.getText();
						Waitfor(2);
						String array[] = { "Request Raised", "Approved", "Rejected", "Pending Approval" };
						
						if (cell_Value.equalsIgnoreCase(Leave_ID)) {
							
							WebElement report= driver.findElement(By.xpath("//table[@id='leave_home']/tbody/tr[" + c + "]/td[1]"));
							action.click(report).build().perform();
							Waitfor(2);
							String  s= driver.findElement(By.xpath("//table[@id='leave_home']/tbody/tr[" + c + "]/td[7]")).getText();
							if(s.equalsIgnoreCase(status))
							{
							logger.info("Status is matching with the passed status & Status is "+s);
							action.click(report).build().perform();
							Waitfor(2);
				// Edit button validation
				boolean edit_status=Edit_Leave.isEnabled();
				if(edit_status == true)
				{
			
				logger.info(" edit button is displayed under RMG page and status is :" + edit_status);
				Waitfor(2);						
				}
				else
				{
				logger.info("edit button is not present in candidate page and status is :" + edit_status);
				}
				logger.info("The Candidate status is "+status);
				count++;
				break;
				}
				else 
				{
				logger.info("Status passed is not matching & the status is : "+s);
				}
				}
				else 
				{
				logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
			   fail = "No Match found";	
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
				return fail;
				}
	

		public void fm_tohandle()
		{
			to_handle.click();
			Waitfor(2);
		}

			public void fm_assign()
			{
			fm_assign.click();
			Waitfor(2);
			
		}
		public void fm_tocomplete()
		{
	
			fm_tocomplete.click();
			Waitfor(2);
			
		}
		public void fm_complete_leave()
		{
			fm_approve_comments.sendKeys("accepting the leave");
			Waitfor(5);
		   fm_complete_leave.click();
		 Waitfor(2);
		}
		
		public String RM_to_approve_leave(String Leave_ID, String status)
		{

		    //My_Lynx();
			Waitfor(2);
			//Leaves_Submodule.click();
			Waitfor(2);
			String Leave_ID1=Leaveid_request_RM.getText();
			Search_Box_ToApprove.sendKeys(Keys.chord(Keys.CONTROL, "a"),Leave_ID1);
				Waitfor(1);
				Actions action = new Actions(driver);
				int count = 0;
				String fail= "";
				String col_text = "ID";
				List<WebElement> page = driver.findElements(By.xpath("//div[@id='toApprove_leave_home_paginate']/span/a"));
				if (page.size() > 0) {
				for (int i = 1; i <=page.size(); i++) 
				{
					if(i>1)
					{	
					driver.findElement(By.xpath("//div[@id='toApprove_leave_home_paginate']/span/a[" + (i) + "]")).click();
					Waitfor(1);
					}
				WebElement table = driver.findElement(By.xpath("//table[@id='toApprove_leave_home']/thead/tr"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h < heading.size(); h++) {
					String text = heading.get(h).getText();
					if (col_text.equalsIgnoreCase(text)) {
						int col = h;
						WebElement row_table = driver.findElement(By.xpath("//table[@id='toApprove_leave_home']/tbody"));
						List<WebElement> rows = row_table.findElements(By.tagName("tr"));
						logger.info(rows.size());
						for (int c = 1; c <= rows.size(); c++) {
							
							String cell_Value = driver
									.findElement(By.xpath("//table[@id='toApprove_leave_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
									.getText();
							Waitfor(2);
							String array[] = { "Request Raised", "Approved", "Rejected", "Pending Approval" };
							
							if (cell_Value.equalsIgnoreCase(Leave_ID1)) {
								
								WebElement report= driver.findElement(By.xpath("//table[@id='toApprove_leave_home']/tbody/tr[" + c + "]/td[1]"));
								//action.click(report).build().perform();
								Waitfor(2);
								String  s= driver.findElement(By.xpath("//table[@id='toApprove_leave_home']/tbody/tr[" + c + "]/td[8]")).getText();
								if(s.equalsIgnoreCase(status))
								{
								logger.info("Status is matching with the passed status & Status is "+s);
								action.click(report).build().perform();
								Waitfor(2);
					// Edit button validation
					boolean approve_leave =approve_Leave.isEnabled();
					if(approve_leave == true)
					{
				
					logger.info(" approve button is displayed under leave page and status is :" + status);
					Waitfor(2);						
					}
					else
					{
					logger.info("approve button is not present in leave  page and status is :" + status);
					}
					logger.info("The Candidate status is "+status);
					count++;
					break;
					}
					else 
					{
					logger.info("Status passed is not matching & the status is : "+s);
					}
					}
					else 
					{
					logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
				   fail = "No Match found";	
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
					return fail;
					}
		
		
		public String FM_Tohandle_leave(String Leave_ID, String status)
		{

			Waitfor(2);
			String Leave_ID1=Leaveid_request_FM.getText();
			Search_Box_ToHandle.sendKeys(Keys.chord(Keys.CONTROL, "a"),Leave_ID1);
				Waitfor(1);
				Actions action = new Actions(driver);
				int count = 0;
				String fail= "";
				String col_text = "ID";
				List<WebElement> page = driver.findElements(By.xpath("//div[@id='toHandle_leave_home_paginate']/span/a"));
				if (page.size() > 0) {
				for (int i = 1; i <=page.size(); i++) 
				{
					if(i>1)
					{	
					driver.findElement(By.xpath("//div[@id='toHandle_leave_home_paginate']/span/a[" + (i) + "]")).click();
					Waitfor(1);
					}
				WebElement table = driver.findElement(By.xpath("//table[@id='toHandle_leave_home']/thead/tr"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h < heading.size(); h++) {
					String text = heading.get(h).getText();
					if (col_text.equalsIgnoreCase(text)) {
						int col = h;
						WebElement row_table = driver.findElement(By.xpath("//table[@id='toHandle_leave_home']/tbody"));
						List<WebElement> rows = row_table.findElements(By.tagName("tr"));
						logger.info(rows.size());
						for (int c = 1; c <= rows.size(); c++) {
							
							String cell_Value = driver
									.findElement(By.xpath("//table[@id='toHandle_leave_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
									.getText();
							Waitfor(2);
							String array[] = { "Request Raised", "Approved", "Rejected", "Pending Approval" };
							
							if (cell_Value.equalsIgnoreCase(Leave_ID1)) {
								
								WebElement report= driver.findElement(By.xpath("//table[@id='toHandle_leave_home']/tbody/tr[" + c + "]/td[1]"));
								action.click(report).build().perform();
								Waitfor(2);
								String  s= driver.findElement(By.xpath("//table[@id='toHandle_leave_home']/tbody/tr[" + c + "]/td[11]")).getText();
								if(s.equalsIgnoreCase(status))
								{
								logger.info("Status is matching with the passed status & Status is "+s);
								action.click(report).build().perform();
								Waitfor(2);
					// Edit button validation
					boolean assign =fm_assign.isEnabled();
					if(assign == true)
					{
				
					logger.info(" assign button is displayed under Leave page and status is :" + status);
					Waitfor(2);						
					}
					else
					{
					logger.info("assign button is not present in Leave page and status is :" + status);
					}
					logger.info("The Candidate status is "+status);
					count++;
					break;
					}
					else 
					{
					logger.info("Status passed is not matching & the status is : "+s);
					}
					}
					else 
					{
					logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
				   fail = "No Match found";	
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
					return fail;
					}
		public void Employee_login()
		{
			String username= excelreaddata().getData("Login_Credentials", 10, 0 ); //Reading Username from excel
			Waitfor(1);
			String password= excelreaddata().getData("Login_Credentials", 10, 1 ); //Reading Password from excel
			Waitfor(1);
			 ObjectInitClass.LP.signIn(username, password);
			Waitfor(2);
			 My_Lynx();
			Waitfor(2);
			Leaves_Submodule.click();
			Waitfor(2);
			
		}
		
		public void rmg_login()
		{
			String username= excelreaddata().getData("Login_Credentials", 9, 0 ); //Reading Username from excel
			Waitfor(1);
			String password= excelreaddata().getData("Login_Credentials", 9, 1 ); //Reading Password from excel
			Waitfor(1);
		
			 ObjectInitClass.LP.signIn(username, password);
			Waitfor(3);
			 My_Lynx();
			Waitfor(2);
			Leaves_Submodule.click();
			Waitfor(2);

		}
		public void rm_login()
		{
			String username= excelreaddata().getData("Login_Credentials", 1, 0 ); //Reading Username from excel
			Waitfor(1);
			String password= excelreaddata().getData("Login_Credentials", 1, 1 ); //Reading Password from excel
			Waitfor(1);
		
			 ObjectInitClass.LP.signIn(username, password);
			Waitfor(3);
			My_Lynx();
			Waitfor(2);
			Leaves_Submodule.click();
			Waitfor(2);
		}
		public void Fm_login()
		{
			Employee_login();
			Waitfor(3);
			String s1 = T_Leave.getText();
			float Total1 = Float.parseFloat(s1);
			logger.info("total Leaves are : " +Total1);
			String s2 = B_Leave.getText();
			float Total2 = Float.parseFloat(s2);
			logger.info("Balance Leaves are: " + Total2);
			String s3 = A_Leave.getText();
			float Total3 = Float.parseFloat(s3);
			logger.info("Applied Leaves are: " +Total3);
			float BalanceLeave = Total1 - Total3;
			
			if (Total3>Total1)
			{
				logger.info("leave with out pay required");
				 ObjectInitClass.HP.Log_Out();
				Waitfor(3);
				String username= excelreaddata().getData("Login_Credentials", 6, 0 ); //Reading Username from excel
				Waitfor(1);
				String password= excelreaddata().getData("Login_Credentials", 6, 1 ); //Reading Password from excel
				Waitfor(1);
			
				 ObjectInitClass.LP.signIn(username, password);
				Waitfor(3);
				 My_Lynx();
				Waitfor(2);
				Leave_Module();
				Waitfor(2);
				fm_tohandle();
				Waitfor(2);
				FM_Tohandle_leave(Leave_ID,candStatus);
				Waitfor(2);
				fm_assign();
				Waitfor(2);
				assigned_to_comments();
				Waitfor(2);
				submit_comments();
				Waitfor(2);
				FM_Tohandle_leave(Leave_ID,"Docked By Ananda");
				Waitfor(2);
				fm_tocomplete();
				Waitfor(3);
				fm_complete_leave();
				Waitfor(5);
				 ObjectInitClass.HP.Log_Out();
				Waitfor(2);
				Employee_login();
				Waitfor(2);
				Leaves_Status("Completed") ;
				Waitfor(2);
				Waitfor(5);
				 ObjectInitClass.HP.Log_Out();
				Waitfor(2);
					}
			else
			{
				Leaves_Status("Approved") ;
				Waitfor(2);
			}
		
}
		public void stautschecking()
		{
			Employee_login();
			Leaves_Status("Completed") ;
			
		}
		public void uploadedfie_checking()
		{
			request_raised.click();
			Waitfor(2);
			Actions action = new Actions(driver);
			action.doubleClick(request_raised).build().perform();
			Waitfor(1);
			action.keyDown(Keys.LEFT_CONTROL).click(driver.findElement(By.xpath("//a[@id='download_file']"))).keyUp(Keys.LEFT_CONTROL).build().perform();
			logger.info("uploaded filr is present in view page");
			Waitfor(2);
			driver.findElement(By.xpath("//button[@class='btn btn-primary back-btn']")).click();
			
		}
		
		public void uploadedfie_checking_rm()
		{
			
			select_request_raised.click();
			Waitfor(2);
			Actions action = new Actions(driver);
			action.doubleClick(select_request_raised).build().perform();
			Waitfor(1);
			action.keyDown(Keys.LEFT_CONTROL).click(driver.findElement(By.xpath("//a[@id='download_file']"))).keyUp(Keys.LEFT_CONTROL).build().perform();
			logger.info("uploaded filr is present in view page");
			Waitfor(2);
			driver.findElement(By.xpath("//button[@class='btn btn-primary back-btn']")).click();
			
		}
		
	
	
}



