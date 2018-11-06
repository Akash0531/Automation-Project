package com.dikshatech.tst.objectrepository;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ReimbursementSubmoduleObjects extends TestBase {


	@Test
	public ReimbursementSubmoduleObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Reimbursement Landing page elements repository.
	@FindBy(xpath="//span[text()='Reimbursements']") 											WebElement Reimbursement_Submodule;
	@FindBy(xpath="To-DO") 																		WebElement Reimbursement_Background;
	@FindBy(xpath="TO-DO") 																		WebElement Reimbursement_icon;
	@FindBy(xpath="//button[@id='new_reimb']") 													WebElement New_Button;
	@FindBy(xpath="//button[@id='edit_button']") 												WebElement Edit_Button;
	@FindBy(xpath="//button[@id='cancel_button']") 												WebElement Cancel_Button;
	@FindBy(xpath="//select[@name='reimbursement_home1_length']") 								WebElement Entries_Count_Dropdown_Reimbursement;
	@FindBy(xpath="//input[@type='search']") 													WebElement Search_Input_Box_Reimbursement;
	@FindBy(xpath="//div[@id='reimbursement_home1_info']") 										WebElement Table_Info_Count_Reimbursement;
	@FindBy(xpath="//a[@id='reimbursement_home1_previous']") 									WebElement Previous_Button_Reimbursement;
	@FindBy(xpath="//a[@id='reimbursement_home1_next']") 										WebElement Next_Button_Reimbursement;
	@FindBy(xpath="//label[text()='Make Reimbursement request for']") 							WebElement New_Reimbursement_Request;
	
	//Some common element Id's for Approve, reject, view, Cancel & Assign form.
	
	@FindBy(xpath="//span[@id='projectNameDivselfHeading']") 									WebElement DetailsOf_ProjectName;
	@FindBy(xpath="//input[@id='idDiv']") 														WebElement Reimbursement_RequestID_Common;
	@FindBy(xpath="//input[@id='projectNameDiv']") 												WebElement Project_Name_Common;
	@FindBy(xpath="//input[@id='projectCodeDiv']") 												WebElement Project_Code_Common;
	@FindBy(xpath="//input[@id='chargeCodeDiv']") 												WebElement Charge_Code_Common;
	@FindBy(xpath="//input[@id='descriptionDivSelf']") 											WebElement Description_Inputbox_Common;
	@FindBy(xpath="//button[text()='download']") 												WebElement Download_link_Common;
	@FindBy(xpath="//input[@id='totalAmountDiv']") 												WebElement TotalAmount_Common;
	@FindBy(xpath="//input[@id='statusDiv']") 													WebElement Requested_Status_Common;
	@FindBy(xpath="//input[@id='requestedOnDiv']") 												WebElement Requested_OnDate_Common;
	@FindBy(xpath="//input[@id='watch-me']") 													WebElement Reimbursement_Self;
	@FindBy(xpath="//input[@id='see-me']") 														WebElement Reimbursement_Others;
	
	
	//Reimbursement New form for Self elements repository
	@FindBy(xpath="//select[@id='self_projects']") 												WebElement Project_Name_Dropdown;
	@FindBy(xpath="//input[@id='self_projectcode']") 											WebElement Project_Code;
	@FindBy(xpath="//select[@id='self_chargecode']") 											WebElement Charge_Code_Dropdown;
	@FindBy(xpath="//button[@id='newgen']") 													WebElement Add_Expense_Button;
	@FindBy(xpath="//select[@id='self_currency']") 												WebElement Currency_Dropdown;
	@FindBy(xpath="//textarea[@id='self_description']") 										WebElement Description_Input_Box;
	@FindBy(xpath="//input[@id='new_popup_total_amt']") 										WebElement Total_Amount_Inputbox;	
	@FindBy(xpath="//div[7][@class='row']/div/button[1]") 										WebElement Submit_button;
	@FindBy(xpath="//div[7][@class='row']/div/button[2]") 										WebElement Save_Button;
	@FindBy(xpath="//button[@class='btn btn-primary back-btn']") 								WebElement Back_button;
	
	//Reimbursement Edit Page elements Repository
	@FindBy(xpath="//span[@id='reimbEditDataHeaderSpan']") 										WebElement Edit_Reimbursement_Request;
	@FindBy(xpath="//button[@id='newgenEdit_self']") 											WebElement Edit_Add_Expense_Button;
	
	//The Approve Page object repositories
	@FindBy(xpath="//a[@id='reimb_ToApprove']") 												WebElement To_Approve_Tab;
	@FindBy(xpath="//input[@type='search'][@aria-controls='reimbursement_to_approve']") 		WebElement TO_ApproveTab_Search_Input_Box;
	@FindBy(xpath="//button[@id='appr_reimb']") 												WebElement To_Approve_Button;
	@FindBy(xpath="//input[@id='toApproveCommentSelf']") 										WebElement Comments_input_Approve;
	@FindBy(xpath="//button[@id='ToApproveSelf']") 												WebElement Approve_Form_Button;
	
	//The Reject Page object repositories
	@FindBy(xpath="//button[@id='rej_reimb']") 													WebElement Reject_Form_Button;
	@FindBy(xpath="//input[@id='toApproveCommentSelfReject']") 									WebElement Comments_input_Reject;
	@FindBy(xpath="//button[@id='ToApproveSelfReject']") 										WebElement Reject_Button;

	//Reimbursement View Page elements Repository
	
	@FindBy(xpath="//span[@id='projectNameDivselfHeadingNormalView']") 							WebElement DetailsOf_Project_View;

	//Reimbursement Cancel Page elements Repository
	@FindBy(xpath="//input[@id='newReinmCommentSelfCancel']") 									WebElement Cancel_CommentBox;
	@FindBy(xpath="//button[@id='newReimbSelfCancel']") 										WebElement Cancel_Form_Button;
	
	//Reimbursement To Handle Page repositories.
	
	@FindBy(xpath="//button[@id='ass_handle_reimb']") 											WebElement Assign_Button;
	@FindBy(xpath="//button[contains(@onclick,('hdfcBankReport'))]") 							WebElement HDFC_Report_Button;
	@FindBy(xpath="//button[contains(@onclick,('otherBankReport'))]") 							WebElement OtherBank_Report_Button;
	@FindBy(xpath="//input[@id='toHandleCommentSelfCancel']") 									WebElement Comments_Input_Assign;
	@FindBy(xpath="//select[@id='self_AssignTo']") 												WebElement AssignTo_Dropdown;
	@FindBy(xpath="//select[@id='self_ToHandleStatus']") 										WebElement Assigned_Status_Dropdown;
	@FindBy(xpath="//button[@id='toHandleSelfAssign']") 										WebElement AssignForm_Submit_Button;
	
	//Reimbursement Common repositories for New, Edit, View & Assign Others form
	
	@FindBy(xpath="//span[@id='projectNameDivselfHeadingNormalView']") 							WebElement DetailsOf_Project;
	@FindBy(xpath="//input[@id='idDiv']") 														WebElement RequestedId_Others;
	@FindBy(xpath="//select[@id='others_company']") 											WebElement Company_Others;
	@FindBy(xpath="//select[@id='others_region']") 												WebElement Region_Others;
	@FindBy(xpath="//select[@id='others_department']") 											WebElement Department_Others;
	@FindBy(xpath="//select[@id='others_division']") 											WebElement Division_Others;
	@FindBy(xpath="//select[@id='others_rms']") 												WebElement RequestedName_Others;
	@FindBy(xpath="//input[@id='others_employeeId']") 											WebElement EmployeeId_Others;
	@FindBy(xpath="//input[@id='others_designation']") 											WebElement Designation_Others;
	@FindBy(xpath="//select[@id='others_projectName']") 										WebElement ProjectName_Others;
	@FindBy(xpath="//input[@id='others_projectcode']") 											WebElement ProjectCode_Others;
	@FindBy(xpath="//select[@id='others_chargecode']") 											WebElement ChargeCode_Others;
	@FindBy(xpath="//button[@id='newgenOther']") 												WebElement AddExpense_Others;
	@FindBy(xpath="//input[@id='descriptionOthersExp']") 										WebElement Description_Others;
	@FindBy(xpath="//select[@id='others_currency']") 											WebElement CurrencyType_Others;
	@FindBy(xpath="//input[@id='look-me-payment']") 											WebElement Self_Payment;
	@FindBy(xpath="//input[@id='look-me']") 													WebElement Others_Payment;
	@FindBy(xpath="//select[@id='pmEmployeeName']") 											WebElement Employee_Name_Others;
	@FindBy(xpath="//input[@id='pmEmployeeId']") 												WebElement EmployeeIdExpense_Others;
	@FindBy(xpath="//input[@id='totalAmountOthers']") 											WebElement Total_Amount_Others;
	
	//Reimbursement New others form repository.
	
	@FindBy(xpath="//div[@id='others']/div[13]/div/button[1]") 									WebElement Submit_Others_New;
	@FindBy(xpath="//div[@id='others']/div[13]/div/button[2]") 									WebElement Save_Others_New;
	
	//Reimbursement View form for Others elements repository
	@FindBy(xpath="//input[@id='companyNameDivOther']") 										WebElement Company_Others_View;
	@FindBy(xpath="//input[@id='regionNameDivOther']") 											WebElement Region_Others_View;
	@FindBy(xpath="//input[@id='departmentNameDivOther']") 										WebElement Department_Others_View;
	@FindBy(xpath="//input[@id='divisionNameDivOther']") 										WebElement Division_Others_View;
	@FindBy(xpath="//input[@id='rmsNameDivOther']") 											WebElement RequestedName_Others_View;
	@FindBy(xpath="//input[@id='rmsEmpIdDivOther']") 											WebElement EmployeeId_Others_View;
	@FindBy(xpath="//input[@id='designationDivOther']") 										WebElement Designation_Others_View;
	@FindBy(xpath="//input[@id='projectNameDivOther']") 										WebElement ProjectName_Others_View;
	@FindBy(xpath="//input[@id='projectCodeDivOther']") 										WebElement ProjectCode_Others_View;
	@FindBy(xpath="//input[@id='chargeCodeDivOther']") 											WebElement ChargeCode_Others_View;
	@FindBy(xpath="//input[@id='descriptionDivOther']") 										WebElement Description_Others_View;
	@FindBy(xpath="//input[@id='pmEmployeeNameDivOther']") 										WebElement Employee_Name_Others_View;
	@FindBy(xpath="//input[@id='pmEmployeeIdDivOther']") 										WebElement Employee_Id_Others_View;
	@FindBy(xpath="//input[@id='totalAmountDivOther']") 										WebElement Total_Amount_Others_View;
	@FindBy(xpath="//input[@id='statusDivOther']']") 											WebElement Request_Statusothers_View;
	@FindBy(xpath="//div[@id='others']/div[18]/div[3]/div[2]") 									WebElement RequestedOn_Others_View;
	
	
	public void Reimbursement()
	{
		Reimbursement_Submodule.click();
	}
	public String Reimbursement_Bkg()
	{
		String color = Reimbursement_Background.getCssValue("color");
	    logger.info("Heading RGBA colour: "+color);
	    String hex= Color.fromString(color).asHex();
	    logger.info(hex);
		return hex;
	}
	public String Reimbursement_Font_Size()
	{
		String size = Reimbursement_Background.getCssValue("font-size");
		logger.info("My Reimbursement Font Size -> "+size);
		return size;
		
	}
	//Read font-family property and print It In console.
	public String Font_Family()
	{
		String fontFamily = Reimbursement_Background.getCssValue("font-family");
		logger.info("My Reimbursement Font Family -> "+fontFamily);
		return fontFamily;
	}
	//Read text-align property and print It In console.
	public String Text_Allignment()
	{
		String fonttxtAlign = Reimbursement_Background.getCssValue("text-align");
		logger.info("My Reimbursement Font Text Alignment -> "+fonttxtAlign);
		return fonttxtAlign;
	}
	public String New_Bkg()
	{
		String color = New_Button.getCssValue("color");
	    logger.info("New_Tab RGBA colour: "+color);
	    String hex= Color.fromString(color).asHex();
	    logger.info(hex);
		return hex;
	}
	public String New_Font_Size()
	{
		String size = New_Button.getCssValue("font-size");
		logger.info("New_Tab Font Size -> "+size);
		return size;
	}
	public String Edit_Bkg()
	{
		String color = New_Button.getCssValue("color");
	    logger.info("Edit_Tab RGBA colour: "+color);
	    String hex= Color.fromString(color).asHex();
	    logger.info(hex);
		return hex;
	}
	public String Edit_Font_Size()
	{
		String size = Edit_Button.getCssValue("font-size");
		logger.info("Edit_Tab Font Size -> "+size);
		return size;
	}
	public boolean Reimbursement_Icon()
	{
		boolean b= Reimbursement_icon.isDisplayed();
		logger.info("Icon is diplaying "+b);
		return b;
	}
	public void New_Tab()
	{
		New_Button.click();
	}
	public void New_Cancel_Button()
	{
		Cancel_Button.click();
	}
	public void Edit_Tab()
	{
		Edit_Button.click();
	}
	
	public void Entries_Count_Dropdown(String Count)
	{
		Select Dropdown = new Select(driver.findElement(By.name("reimbursement_home1_length")));
		Dropdown.selectByVisibleText(Count);
		logger.info("The Entered Count is "+Count);
		
		List<WebElement> length = Dropdown.getOptions();
		int size= length.size();
		logger.info("Total No. of Dropdown values are : "+size);
		
		String value=null;
		StringBuffer sb=new StringBuffer();
		//for(int i=0; i<size; i++)
		for (WebElement string : length) 
		{
			value = string.getText();
			
            sb = sb.append(value).append(",");
		}	
	    logger.info(sb.toString());
	}
	public String Count_Selected()
	{
		String count= Entries_Count_Dropdown_Reimbursement.getText();
		return count;
	}
	public void SearchBox(String text)
	{
		Search_Input_Box_Reimbursement.sendKeys(Keys.chord(Keys.CONTROL, "a"),text);
	}
	public void Count_Entry_Display()
	{
	   String text= Table_Info_Count_Reimbursement.getText();
	   logger.info(text);
	}
	public void Next_Table()
	{
		boolean status = Next_Button_Reimbursement.isEnabled();
		if(status==true)
		{
			Next_Button_Reimbursement.click();
		}
		else
		{
			logger.info("Next button is not enabled");
		}
	}
	public void Previous_Table()
	{
		boolean status = Previous_Button_Reimbursement.isEnabled();
		if(status==true)
		{
			Previous_Button_Reimbursement.click();
		}
		else
		{
			logger.info("Previous button is not enabled");
		}
	}
	
	public void Pagination() {
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='reimbursement_home1_paginate']/span/a"));
		String text1;
		String text2;
		if (page.size() > 0) {
			for (int i = 0; i < page.size(); i++) {
				text1 = "//div[@id='reimbursement_home1_paginate']/span/a[";
				text2 = "";
				driver.findElement(By.xpath("//div[@id='reimbursement_home1_paginate']/span/a[" + (i + 1) + "]")).click();
				Waitfor(2);
			}
			for (int j = page.size(); j >= 0; j--) 
			{
				driver.findElement(By.xpath("//div[@id='reimbursement_home1_paginate']/span/a[" + (j) + "]")).click();
				Waitfor(2);
			}
			
		} else {
			logger.info("There is no Pagination number present");
		}
	}
	public void New_Reimbursement_Form_Self(String Project_Name, String Currency_Type, String Description)
	{
		New_Button.click();
		Waitfor(1);
		boolean status = Reimbursement_Self.isSelected();
		if(status==false)
		{
			Reimbursement_Self.click();
		}
		else
		{
			logger.info("Self Reimbursement is already selected");
		}
		Select Dropdown = new Select(Project_Name_Dropdown);

		logger.info("The Entered Project Name is "+Project_Name);
		
		List<WebElement> length = Dropdown.getOptions();
		int size= length.size();
		logger.info("Total No. of Dropdown values are : "+size);
		String Text=null;
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<size; i++)
		{   
			//length.get(i).click();
		    Text = length.get(i).getText();
		    sb = sb.append(Text).append(",");
		    Waitfor(1);
		}
		logger.info("The Projects names are -: "+sb.toString());
		
		Dropdown.selectByVisibleText(Project_Name);
		
		Description_Input_Box.clear();
		Description_Input_Box.sendKeys(Description);
		
		Select Curr_Dropdown = new Select(Currency_Dropdown);

		logger.info("The Entered Project Name is "+Currency_Type);
		
		List<WebElement> list = Dropdown.getOptions();
		int DD_size= list.size();
		logger.info("Total No. of Dropdown values are : "+size);
		String currency=null;
		StringBuffer stringb=new StringBuffer();
		for(int i=0; i<DD_size; i++)
		{   //list.get(i).click();
		    currency = list.get(i).getText();
		    stringb = stringb.append(currency).append(",");
		    Waitfor(1);
		}
		logger.info("The Projects names are -: "+stringb.toString());
		
		Curr_Dropdown.selectByVisibleText(Currency_Type);
		
		
		driver.findElement(By.xpath(".//*[@id='summary']")).sendKeys("Testing it now");
		Waitfor(1);
		driver.findElement(By.xpath(".//*[@id='amount']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),"423.55");
		Waitfor(1);
		driver.findElement(By.xpath(".//*[@id='file']")).click();
		Waitfor(1);
		driver.findElement(By.xpath(".//*[@id='descriptions_for_upload0']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),"Testing_File");
		Waitfor(1);
		driver.findElement(By.xpath(".//*[@id='upload_file_btnSelfStatic0']")).click();
		Waitfor(1);
		String total_amount= Total_Amount_Inputbox.getText();
		logger.info("The Total Amount is : "+total_amount);
	}
	public void statuscheck(String report_ID, String Status)
	{
		int count = 0;
		String id=null;
		String col_text = "Status";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='reimbursement_home_paginate']/span/a"));
		if (page.size() > 0) {
		for (int i = 1; i < page.size(); i++) 
		{
		if(i>1)
		{	
		driver.findElement(By.xpath("//div[@id='reimbursement_home_paginate']/span/a[" + (i+1) + "]")).click();
		Waitfor(1);
		}
		WebElement table = driver.findElement(By.xpath("//table[@id='reimbursement_home']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 1; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (col_text.equalsIgnoreCase(text)) {
				int col = h;
				WebElement row_table = driver.findElement(By.xpath("//table[@id='reimbursement_home']/tbody"));
				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int c = 1; c < rows.size(); c++) {
					
					String cell_Value = driver
							.findElement(By.xpath("//table[@id='reimbursement_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]"))
							.getText();
					Waitfor(2);
					String array[] = { "Report Generated", "Approved", "Rejected", "Completed", "Submitted" };
					
					if (cell_Value.equalsIgnoreCase(report_ID)) {
						
						WebElement report= driver.findElement(By.xpath("//table[@id='reimbursement_home']/tbody/tr[" + c + "]/th[1]"));
						Waitfor(1);
						String  s= driver.findElement(By.xpath("//table[@id='reimbursement_home']/tbody/tr[" + c + "]/th[7]")).getText();
						if(s.equalsIgnoreCase(Status))
						{
						logger.info("Status is matching with the passed status & Status is "+s);
						//action.doubleClick(report).build().perform();
						Waitfor(2);
						}
}}}}}}}
	public void view_Reimbursement_Form_Self(String Project_Name, String Currency_Type, String Description, int row_num)
	{
		String S_name= "ReimbursementSelf_Sheet";
		boolean status = Reimbursement_Self.isSelected();
		if(status==false)
		{
			Reimbursement_Self.click();
		}
		else
		{
			logger.info("Self Reimbursement is already selected");
		}
		String req_id= excelreaddata().getData(S_name, row_num, 0);
		softassert().assertEquals(req_id, Reimbursement_RequestID_Common.getText());
		
		String p_name= excelreaddata().getData(S_name, row_num, 1);
		softassert().assertEquals(p_name, Project_Name_Common.getText());
		
		
		String p_code= excelreaddata().getData(S_name, row_num, 2);
		softassert().assertEquals(p_code, Project_Code_Common.getText());
		
		String c_code= excelreaddata().getData(S_name, row_num, 3);
		softassert().assertEquals(c_code, Charge_Code_Common.getText());
		
		String description= excelreaddata().getData(S_name, row_num, 4);
		softassert().assertEquals(description, Description_Inputbox_Common.getText());
		
		String total_amnt= excelreaddata().getData(S_name, row_num, 5);
		softassert().assertEquals(total_amnt, TotalAmount_Common.getText());
		
		
		String view_status= excelreaddata().getData(S_name, row_num, 6);
		softassert().assertEquals(view_status, Requested_Status_Common.getText());
		
		//Reimbursement individual amount Validation from the excel data
		String s= excelreaddata().getData(S_name, row_num, 10);
		String col_text= "Amount";
		WebElement table = driver.findElement(By.xpath("//table[@id='reimbursement_home']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		outerloop:
		for (int h = 1; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (col_text.equalsIgnoreCase(text)) {
			int col = h;
			WebElement row_table = driver.findElement(By.xpath("//table[@id='reimbursement_home']/tbody"));
			List<WebElement> rows = row_table.findElements(By.tagName("tr"));
			logger.info(rows.size());
			for (int c = 1; c < rows.size(); c++) {
				
				String cell_Value = driver
						.findElement(By.xpath("//table[@id='reimbursement_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]"))
						.getText();
				Waitfor(1);
				
				if (cell_Value.equalsIgnoreCase(s)) {
					
					WebElement report= driver.findElement(By.xpath("//table[@id='reimbursement_home']/tbody/tr[" + c + "]/th[7]"));
					//action.doubleClick(report).build().perform();
					Waitfor(1);
		
					if(rows.size()<=1)
					{
						continue;
					}
					else
						break outerloop;
	}}}}
		//Reimbursement Total amount Validation after adding the individual reimbursement amount
		String ind_amount=null;
		String totalamount= TotalAmount_Common.getText();
		WebElement table1 = driver.findElement(By.xpath("//table[@id='reimbursement_home']/thead/tr"));
		List<WebElement> heading1 = table1.findElements(By.tagName("th"));
		outerloop:
		for (int h = 1; h < heading1.size(); h++) {
		String text = heading1.get(h).getText();
		if (col_text.equalsIgnoreCase(text)) {
			int col = h;
			WebElement row_table1 = driver.findElement(By.xpath("//table[@id='reimbursement_home']/tbody"));
			List<WebElement> rows1 = row_table1.findElements(By.tagName("tr"));
			logger.info(rows1.size());
			for (int c = 1; c < rows1.size(); c++) {
				
				String cell_Value1 = driver
						.findElement(By.xpath("//table[@id='reimbursement_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]"))
						.getText();
				Waitfor(1);
				ind_amount=ind_amount+cell_Value1;
				if(c==rows1.size())
				{
					break outerloop;
				}
			}
		}
	}
	if(ind_amount.equalsIgnoreCase(totalamount))
	{
		logger.info("The total reimbursement amount is matching with the summation of all the provided reimbursement amount");
	}
	else
		logger.info("The total reimbursement amount is not matching with the summation of all the provided reimbursement amount");
}			
	public void downloadfiles()
	{
		String col_text= "Receipts";
		WebElement table1 = driver.findElement(By.xpath("//table[@id='reimbursement_home']/thead/tr"));
		List<WebElement> heading1 = table1.findElements(By.tagName("th"));
		outerloop:
		for (int h = 1; h < heading1.size(); h++) {
		String text = heading1.get(h).getText();
		if (col_text.equalsIgnoreCase(text)) {
			int col = h;
			WebElement row_table1 = driver.findElement(By.xpath("//table[@id='reimbursement_home']/tbody"));
			List<WebElement> rows1 = row_table1.findElements(By.tagName("tr"));
			logger.info(rows1.size());
			for (int c = 1; c < rows1.size(); c++) {
				
				driver.findElement(By.xpath("//table[@id='reimbursement_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]")).click();
				Waitfor(2);	
				if(c>1)
				{
					break outerloop;
				}
	}}}}
	
	public void view_Reimbursement_Form_others(String Project_Name, String Currency_Type, String Description, int row_num)
	{
		Actions action = new Actions(driver);
		String S_name= "ReimbursementOther_Sheet";
		boolean status = Reimbursement_Others.isSelected();
		if(status==false)
		{
			Reimbursement_Others.click();
		}
		else
		{
			logger.info("Other Reimbursement is already selected");
		}
		String req_id= excelreaddata().getData(S_name, row_num, 0);
		softassert().assertEquals(req_id, Reimbursement_RequestID_Common.getText());
		
		String company= excelreaddata().getData(S_name, row_num, 1);
		softassert().assertEquals(company, Company_Others_View.getText());
		
		String region= excelreaddata().getData(S_name, row_num, 2);
		softassert().assertEquals(region, Region_Others_View.getText());
		
		String department= excelreaddata().getData(S_name, row_num, 3);
		softassert().assertEquals(department, Department_Others_View.getText());
		
		String divison= excelreaddata().getData(S_name, row_num, 4);
		softassert().assertEquals(divison, Division_Others_View.getText());
		
		String reim_reqfor= excelreaddata().getData(S_name, row_num, 5);
		softassert().assertEquals(reim_reqfor, RequestedName_Others.getText());
		
		String emp_id= excelreaddata().getData(S_name, row_num, 6);
		softassert().assertEquals(emp_id, Employee_Id_Others_View.getText());
		
		String designation= excelreaddata().getData(S_name, row_num, 7);
		softassert().assertEquals(designation, Designation_Others_View.getText());
		
		String p_name= excelreaddata().getData(S_name, row_num, 8);
		softassert().assertEquals(p_name, ProjectName_Others_View.getText());
		
		
		String p_code= excelreaddata().getData(S_name, row_num, 9);
		softassert().assertEquals(p_code, ProjectCode_Others_View.getText());
		
		String c_code= excelreaddata().getData(S_name, row_num, 10);
		softassert().assertEquals(c_code, ChargeCode_Others_View.getText());
		
		String description= excelreaddata().getData(S_name, row_num, 11);
		softassert().assertEquals(description, Description_Others_View.getText());
		
		String total_amnt= excelreaddata().getData(S_name, row_num, 12);
		softassert().assertEquals(total_amnt, Total_Amount_Others_View.getText());
		
		
		String view_status= excelreaddata().getData(S_name, row_num, 13);
		softassert().assertEquals(view_status, Request_Statusothers_View.getText());
		
		//Reimbursement individual amount Validation from the excel data
		String s= excelreaddata().getData(S_name, row_num, 10);
		String col_text= "Amount";
		WebElement table = driver.findElement(By.xpath("//table[@id='reimbursement_home']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		outerloop:
		for (int h = 1; h < heading.size(); h++) {
		String text = heading.get(h).getText();
		if (col_text.equalsIgnoreCase(text)) {
			int col = h;
			WebElement row_table = driver.findElement(By.xpath("//table[@id='reimbursement_home']/tbody"));
			List<WebElement> rows = row_table.findElements(By.tagName("tr"));
			logger.info(rows.size());
			for (int c = 1; c < rows.size(); c++) {
				
				String cell_Value = driver
						.findElement(By.xpath("//table[@id='reimbursement_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]"))
						.getText();
				Waitfor(1);
				
				if (cell_Value.equalsIgnoreCase(s)) {
					
					WebElement report= driver.findElement(By.xpath("//table[@id='reimbursement_home']/tbody/tr[" + c + "]/th[7]"));
					action.doubleClick(report).build().perform();
					Waitfor(1);
		
					if(rows.size()<=1)
					{
						continue;
					}
					else
						break outerloop;
	}}}}}
	
	public void Expenses_Self_Table(String Reimbursement_Type)
	{

		
//		Add_Expense_Button.click();
//		Add_Expense_Button.click();
//		Add_Expense_Button.click();
		
        
		WebElement table= driver.findElement(By.xpath("//table[@id='newtable']/tbody"));
	    List<WebElement> rows  = table.findElements(By.tagName("tr"));
		logger.info("No. of rows in expense table are: "+rows.size());
		for(int r=1; r<rows.size(); r++)
		{
			
			
			

			
			//			List<WebElement> heading = rows.get(r).findElements(By.tagName("th"));
//			   for(int h=0; h<heading.size(); h++)
//			   {
//				 String text = heading.get(h).getText();
//				 logger.info(h);
//			   }
//			   
//			
			 Actions action= new Actions(driver);
			 WebElement col =driver.findElement(By.xpath("//table[@id='newtable']/tbody/tr[" +(r+1)+ "]/td[1]"));
			 col.click();
			   
			   
			   List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));
				
				int total_nodes= dates.size();
				logger.info("Calendar Date size is : "+total_nodes);
				 for(int i=0; i<total_nodes; i++)
				 {
					 String date= dates.get(i).getText();
//					 dates.get(i).click();
//					 logger.info("Selected date is: "+date);
					 if(date.equals(Integer.toString(7)))
					 {
						dates.get(i).click();
						logger.info("Selected date is: "+date);
						break;
						
					 }
				  } 
				 
				   String X1= "//select[@id='type";
			       String X2="']";
			       WebElement drop= driver.findElement(By.xpath(X1+X2));
			
		           Select Dropdown = new Select(drop);
		    
					List<WebElement> length = Dropdown.getOptions();
					int size= length.size();
					
					String Text=null;
					StringBuffer sb=new StringBuffer();
					for(int i=0; i<size; i++)
					{   
					    Text = length.get(i).getText();
					    sb = sb.append(Text).append(",");
					    Waitfor(2);
					    Dropdown.selectByIndex(i);
					}
					Dropdown.selectByVisibleText(Reimbursement_Type);
//				 for(int t=1; t<5 ; t++  )
//					   {
//						   for(int z=0; z<3; z++)
//						   {
							   	      
//				 logger.info("Hello1");
//				 action.moveToElement(col1);
//				 col.sendKeys(Keys.TAB);
//				 logger.info("Hello2");
//				 col.sendKeys("Testing_Karo");
//				 logger.info("Hello3");
//				 col.sendKeys(Keys.chord(Keys.CONTROL, "a"),read.getData("abc", 3, 2));
//				 
//				 sendKeys(Keys.chord(Keys.CONTROL, "a"),read.getData("abc", t, z));
				 
//                 
//						   }
//					   }	   
			   
			   
//		   List<WebElement>	column = rows.get(r).findElements(By.tagName("td"));
//		   for(int c=0; c<column.size(); c++)
//		   {
//			   Date_Picker_Input.click();
//			   List<WebElement> dates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));
//				
//				int total_nodes= dates.size();
//				logger.info("Calendar Date size is : "+total_nodes);
//				 for(int i=0; i<total_nodes; i++)
//				 {
//					 String date= dates.get(i).getText();
////					 dates.get(i).click();
////					 logger.info("Selected date is: "+date);
//					 if(date.equals(Integer.toString(i+1)))
//					 {
//						dates.get(i).click();
//						logger.info("Selected date is: "+date);
//						break;
//						
//					 }
//				 }
//				 
//				
//			}
			 //WebElement cell_Value = driver.findElement(By.xpath(".//*[@id='main']/div[3]/div/table/tbody/tr["+r+ "]/td[3]"));
//			   for(int t=1; t<5 ; t++  )
//			   {
//				   for(int z=0; z<3; z++)
//				   {   
//			 driver.findElement(By.xpath("//table[@id='newtable']/tbody/tr/td[" +c+ "]")).sendKeys(Keys.chord(Keys.CONTROL, "a"),read.getData("abc", t, z));;
//			 String text = column.get(c).getText();
//			 logger.info("Cell value of row number "+r+" and Column number "+c+" is "+text);
//			 logger.info("****************************");
//				   }
//			  }    	   
			}
	    }
    }		   

