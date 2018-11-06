package com.dikshatech.tst.objectrepository;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;

public class TravelObjects extends TestBase 

{
	@Test
	public TravelObjects (WebDriver driver)
	{
		this.driver = driver;		
		
	}
	
	
	@FindBy(xpath="//*[@id='travel-menu']") 				WebElement TravelSubTab;
	@FindBy(xpath="//*[@id='newtravel']")     				WebElement NewTravel;
	@FindBy(xpath="//*[@id='yesCheck']") 					WebElement SelfTravel;
	@FindBy(xpath="//*[@id='noCheck']") 					WebElement OthersTravel;
	
	
	@FindBy(xpath="//*[@id='deletetravel']")   				WebElement DeleteButtonICON;
	//@FindBy(xpath="//*[@id='yesCheck']") 					WebElement SubmitButtonICON;
	//@FindBy(xpath="//*[@id='noCheck']") 					WebElement CancelICON;
	//Self
	@FindBy(xpath="//*[@id='purposeOfTl']") 				WebElement PurposeTravel;
	@FindBy(xpath="//*[@id='newTravellerComments']") 		WebElement Comments;
	@FindBy(xpath="//*[@id='travelSpouseName']") 			WebElement SpouseNameChkBx;
	@FindBy(xpath="//*[@id='EnterSpousNme']") 				WebElement EnterSpouseName;
	@FindBy(xpath="//*[@id='travelChildren']") 				WebElement TravelChildrenChkBx;
	@FindBy(xpath="//*[@id='travelChildName']/div[3]/button") 	WebElement AddChildren;
	@FindBy(xpath="//*[@id='EnterChildrenNme1']") 			WebElement EnterChildName;
	@FindBy(xpath="//*[@id='modeOfTl']") 					WebElement ModeOfTravel;
	@FindBy(xpath="//*[@id='travelDestination']") 			WebElement TravelFrom;
	@FindBy(xpath="//*[@id='travelDestinationTo']") 		WebElement TravelTo;
	@FindBy(xpath="//*[@id='datetimepicker_travel_self']") 	WebElement PreffereDateTravel; 
	@FindBy(xpath="//*[@id='pre_travel_time']") 			WebElement PrefferedTimeTravel ;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div/a[2]") 	WebElement SelectNextMontha;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[6]/a") WebElement SelectDateSelf;
	@FindBy(xpath="//*[@id='accomdaRequired']") 			WebElement Accomodation;
	@FindBy(xpath="//*[@id='travel_accommodation']") 		WebElement AccomodationType;
	@FindBy(xpath="//*[@id='travelCabReq']") 				WebElement CabRequired;
	@FindBy(xpath="//*[@id='travel_master_new_edit_modal_submit']") WebElement SubmitButton;
	@FindBy(xpath="//*[@id='travel_master_new_edit_modal_save']") WebElement SaveButton;
	@FindBy(xpath="//*[@id='travel_th_home']/tbody/tr[1]") WebElement SelectEmpSPOCLevel;
	
	//others
	@FindBy(xpath="//*[@id='travel_Company']") 				WebElement SelectCompany;
	@FindBy(xpath="//*[@id='travel_Region']") 				WebElement TravelRegion;
	@FindBy(xpath="//*[@id='travel_Department']") 			WebElement TravelDepartment;
	@FindBy(xpath="//*[@id='travelDivision']") 				WebElement TravelDivision;
	@FindBy(xpath="//*[@id='travelerFulName']") 			WebElement TravellerName;
	@FindBy(xpath="//*[@id='purposeOfTlOth']") 				WebElement PursorOfTravelOthersT;
	@FindBy(xpath="//*[@id='newTravellerCommentsOther']") 	WebElement TravelOthersCommentsT;
	@FindBy(xpath="//*[@id='travelSpouseNameOther']") 		WebElement SpouseNameOthersT;
	@FindBy(xpath="//*[@id='EnterSpousNmeOth']") 			WebElement EnterspouseNameOthersT;
	@FindBy(xpath="//*[@id='travelChildrenother']") 		WebElement ChildrenOthersT;
	@FindBy(xpath="//*[@id='travelChildName_other']/div[3]/button") WebElement AddChildrensT;
	@FindBy(xpath="//*[@id='EnterChildrenNmeOth1']") 		WebElement EnterChildrenNameT;
	@FindBy(xpath="//*[@id='travelContactPersonChkBx']") 	WebElement ContactPersonT;
	@FindBy(xpath="//*[@id='travelRelatedRoll']") 			WebElement TravelRelatedRollOnT;
	@FindBy(xpath="//*[@id='travelContactPerson']") 		WebElement TravelContactPersonT;
	@FindBy(xpath="//*[@id='travelPhoneNumber']") 			WebElement TravelPhNumT;
	@FindBy(xpath="//*[@id='travelEmailId']") 				WebElement EmailIDT;
	@FindBy(xpath="//*[@id='travelAddress']") 				WebElement AddressTarvelT;
	@FindBy(xpath="//*[@id='modeOfTlOth']") 				WebElement TravelModeOthersT;	
	@FindBy(xpath="//*[@id='travelDestinationOther']") 		WebElement TravelFromOthersT;
	@FindBy(xpath="//*[@id='travelDestinationToOth']") 		WebElement TravelToOthersT;
	@FindBy(xpath="//*[@id='datetimepicker_travel_others']") WebElement PrefferedDateOfOthersT;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div/a[2]") 	WebElement SelectNextMonthOT;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[5]/a") WebElement SelectDate;
	@FindBy(xpath="//*[@id='pre_travel_time_Other']") 				WebElement TimeTravelOthersT;
	@FindBy(xpath="//*[@id='travelRoundTripOth']") 					WebElement TravelroundTripOthersT;
	@FindBy(xpath="//*[@id='datetimepicker_travel_return_other']") 	WebElement ReturnDateofTravelT;
	@FindBy(xpath="//*[@id='travelReturnTime_other']") 				WebElement ReturnTimeT;
	@FindBy(xpath="//*[@id='accomdaRequiredOther']") 				WebElement AccomodationOthersT;
	@FindBy(xpath="//*[@id='travel_accommodationOther']") 			WebElement EnterAccomodationT;
	@FindBy(xpath="//*[@id='travelCabReqOther']") 					WebElement travelCabRequired;
	@FindBy(xpath="//*[@id='travel_master_new_edit_modal_submit']") WebElement SubmitTravelOthers;
	@FindBy(xpath="//*[@id='travel_master_new_edit_modal_save']") 	WebElement SaveTravelOthers;
	
	// Traveller Details 
	
	@FindBy(xpath="//*[@id='travel_fullname_ID']") 					WebElement EmpName;
	@FindBy(xpath="//*[@id='travel_view_empID']") 					WebElement EmpID;
	@FindBy(xpath="//*[@id='travel_view_mode']") 					WebElement TravelMode;
	@FindBy(xpath="//*[@id='travel_view_travel_from']") 			WebElement FromPlace;
	@FindBy(xpath="//*[@id='travel_view_travel_to']") 				WebElement ToPlace;
	@FindBy(xpath="//*[@id='travel_view_status']") 					WebElement Statuss;
	@FindBy(xpath="//*[@id='travel_view_reqOn']") 					WebElement RequestOn;
	
	
	
	
	
	
	//RM Level
	
	@FindBy(xpath="//*[@id='main_Content']/div/div[1]/div[2]/button") WebElement BackButton;
	@FindBy(xpath="//*[@id='travel_view_status']") 				    WebElement ViewStatus;
	
	
	@FindBy(xpath="//*[@id='travel_ToApprove']") 					WebElement ToApproveTab;
	@FindBy(xpath="//*[@id='torejectId']") 							WebElement ToRejectIcon;
	@FindBy(xpath="//*[@id='toassignId']") 							WebElement ToAssigneIcon;
	@FindBy(xpath="//*[@id='toapproveId']") 						WebElement ToApproveIcon;
	
	@FindBy(xpath="//*[@id='travel_to_approve']/tbody/tr[1]") 		WebElement SelectEmpRMlEVEL;
	@FindBy(xpath="//*[@id='travel_assign_name']") 					WebElement TravellerNameRMLevel;
	//approve
	@FindBy(xpath="//*[@id='travel_approve_remark']") 				WebElement RemarkAtRMToApprove ;
	@FindBy(xpath="//*[@id='travel_master_new_edit_modal_submit']") WebElement ApproveButton;
	//assign  
	@FindBy(xpath="//*[@id='travel_ass_remark']") 					WebElement RemarkatAssigneLevel;
	@FindBy(xpath="//*[@id='travel_master_new_edit_modal_submit']") WebElement AssignButton;
	//Reject     
	@FindBy(xpath="//*[@id='travel_reject_remark']") 				WebElement RemarkatReject;
	@FindBy(xpath="//*[@id='travel_master_new_edit_modal_submit']") WebElement RejectButton;
	
	//To Check Rejected Status 
	
	@FindBy(xpath="//*[@id='travel_fullname_ID']") 				    WebElement TravelrName;
	
	@FindBy(xpath="//*[@id='travel_view_rejBy']") 				    WebElement RejectApproveBy;
	
	//RMG Manager Level
	@FindBy(xpath="//*[@id='travel_ToHandle']") 					WebElement ToHandleTab;
	@FindBy(xpath="//*[@id='travelto_handle']/tbody/tr[1]") 		WebElement SelectEmpRMGLevel;
	@FindBy(xpath="//*[@id='assignId']") 							WebElement ToassignIcon;
	@FindBy(xpath="//*[@id='travel_toassign_name']") 				WebElement TravellerNameRMGlEVEL;
	@FindBy(xpath="//*[@id='travelItems']") 						WebElement ItemNum1;
	@FindBy(xpath="//*[@id='travel_cost_amount']") 					WebElement Itemcost1;
	@FindBy(xpath="//*[@id='costTable']/tbody/tr[1]/td[3]/i") 		WebElement AddCostTrip;
	@FindBy(xpath="//*[@id='travelItems1']") 						WebElement ItemNum2;
	@FindBy(xpath="//*[@id='travel_cost_amount1']") 				WebElement Itemcost2;
	@FindBy(xpath="//*[@id='travelTotal']") 						WebElement TravelTotalCost;
	@FindBy(xpath="//*[@id='traveltoass_remark']") 					WebElement RemarkAtAssign;
	@FindBy(xpath="//*[@id='travelAssignToOtherId']") 				WebElement AssignedTo;
	@FindBy(xpath="//*[@id='travelStatusId']") 						WebElement StatusSelect;
	@FindBy(xpath="//*[@id='travel_master_new_edit_modal_submit']") WebElement SubmitRMGLevel;
	@FindBy(xpath="//*[@id='travel_toassign_name']") 				WebElement TravelerName;
	@FindBy(xpath="//*[@id='traveltoass_remark']") 					WebElement RemarkAtProcessedLevel;
	
	@FindBy(xpath="//*[@id='travel_toassign_name']") 				WebElement status;
	
	

	
	
	public void My_Lynx()
    {
    	WebElement lynx= driver.findElement(By.xpath("//*[@id='mylynx']/a"));
    	lynx.click();
    	Waitfor(2);
    }
    
	public void travelModule()
	{
		
		TravelSubTab.click();
		Waitfor(1);
		
	}
	
	public void newTravelRequest()
	{
		
		NewTravel.click();
		Waitfor(1);
		
	}
	
	public void createSelfTravelRequest(String PurpsoeTravel, String Commentss, String SpouseName, String ChildnName, String ModeTravel, String FromPlace, String ToPlace, String TravelDate)
	{
		PurposeTravel.sendKeys(PurpsoeTravel);
		Waitfor(1);
		Comments.sendKeys(Commentss);
		Waitfor(1);
		SpouseNameChkBx.click();
		EnterSpouseName.sendKeys(SpouseName);
		Waitfor(1);
		TravelChildrenChkBx.click();
		AddChildren.click();
		EnterChildName.sendKeys(ChildnName);
		Waitfor(1);
		Select oselect=new Select(ModeOfTravel);
		oselect.selectByVisibleText(ModeTravel);
		TravelFrom.sendKeys(FromPlace);
		Waitfor(1);
		TravelTo.sendKeys(ToPlace);
		Waitfor(1);
		PreffereDateTravel.click();
		
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[3]/a")).click();
		
		
		
	/*	List<WebElement> dates1 = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody"));

		int total_nodes1 = dates1.size();
		logger.info("Calendar Date size is : " + total_nodes1);
		for (int i = 0; i < total_nodes1; i++)
		
		{
		String date1 = dates1.get(i).getText();
		// dates.get(i).click();
		// logger.info("Selected date is: "+date);
		int abc=Integer.valueOf(TravelDate);
		
		if (date1.equals(Integer.toString(abc)))
		
		{
		dates1.get(i).click();
		logger.info("Selected date is: " + date1);
		break;
		}
		
		}*/
		PrefferedTimeTravel.sendKeys("1000");
		Waitfor(1);
		Accomodation.click();
		AccomodationType.sendKeys("Hotel..!!!!");
	}
	
	public void submitRequest()
	{
		SubmitButton.click();
		Waitfor(2);
	}
	
	public void saveRequest()
	{
		SaveButton.click();
		Waitfor(2);
	}
	
	public void deleteRequest()
	{
		DeleteButtonICON.click();
	}
	
	public void selectEmpAtSPOCLevel()
	{
		SelectEmpSPOCLevel.click();
	}
	
	
	public void createOthersTravelRequest(String Dept, String Division, String TravelerNamesa, String PurposeTravel,String Comments, String spouseName, String ChildName, String TravelMode,String T_From, String T_To, String TravelDate )
	{
		OthersTravel.click();
		Waitfor(2);
		Select oselect=new Select(SelectCompany);
		oselect.selectByVisibleText("Diksha");
		Waitfor(5);
		
		Select select=new Select(TravelRegion);
		select.selectByVisibleText("India");
		Waitfor(5);
		
		Select sel=new Select(TravelDepartment);
		sel.selectByVisibleText(Dept);
		Waitfor(5);
	
		Select selDiv=new Select(TravelDivision);
		selDiv.selectByVisibleText(Division);
		Waitfor(8);
		
		Select selTravName=new Select(TravellerName);
		selTravName.selectByVisibleText(TravelerNamesa);
		Waitfor(8);
		PursorOfTravelOthersT.sendKeys(PurposeTravel);
		Waitfor(2);
		TravelOthersCommentsT.sendKeys(Comments);
		Waitfor(2);
		SpouseNameOthersT.click();
		Waitfor(2);
		EnterspouseNameOthersT.sendKeys(spouseName);
		Waitfor(2);
		ChildrenOthersT.click();
		Waitfor(2);
		AddChildrensT.click();
		Waitfor(3);
		EnterChildrenNameT.sendKeys(ChildName);
		Waitfor(2);
		ContactPersonT.click();
		Waitfor(1);
		TravelRelatedRollOnT.click();
		Waitfor(2);
		TravelContactPersonT.sendKeys("Vijay");
		Waitfor(1);
		TravelPhNumT.sendKeys("9538050814");
		Waitfor(1);
		EmailIDT.sendKeys("abcd@gmail.com");
		Waitfor(1);
		AddressTarvelT.sendKeys("#21 1st Cross JP Nagara Banaglore-78");
		Waitfor(1);
		
		Select TMode=new Select(TravelModeOthersT);
		TMode.selectByVisibleText(TravelMode);
		Waitfor(1);
		TravelFromOthersT.sendKeys(T_From);
		Waitfor(1);
		TravelToOthersT.sendKeys(T_To);
		Waitfor(1);
		PrefferedDateOfOthersT.click();
		Waitfor(2);
		SelectDate.click();
		Waitfor(1);
		TimeTravelOthersT.sendKeys("1010");
		Waitfor(1);
		AccomodationOthersT.click();
		Waitfor(2);
		EnterAccomodationT.sendKeys("Hotel");
		Waitfor(2);
		travelCabRequired.click();
		Waitfor(2);
		Select selTravName1=new Select(TravellerName);
		selTravName1.selectByVisibleText(TravelerNamesa);
	}
	
	public void TravellerDetails()
	{
		SelectEmpSPOCLevel.click();
		
		Actions dbclick=new Actions(driver);
		dbclick.doubleClick(SelectEmpSPOCLevel).perform();
		Waitfor(1);
		
		String Ename=EmpName.getText();
		logger.info("The Traveller Employee Name:"+Ename);
		Waitfor(1);
		String E_ID=EmpID.getText();
		logger.info("The Employee ID is"+E_ID);
		
		String Mode=TravelMode.getText();
		logger.info("The Employee Mode of Travel is:"+Mode);
		Waitfor(1);
		String from=FromPlace.getText();
		logger.info("The Employee Travelling From "+from);

		String to=ToPlace.getText();
		logger.info("The Employee Travelling to "+to);
		
		String strr=Statuss.getText();
		logger.info("The Employee Status is "+strr);
		Waitfor(1);
		String ReqstOn=RequestOn.getText();
		logger.info("The Employee Request on "+ReqstOn);
		BackButton.click();
		
		
	}
	
	public void RejectedstatusatSPOCLevel()
	{
		
		SelectEmpSPOCLevel.click();
		Actions dbclick=new Actions(driver);
		dbclick.doubleClick(SelectEmpSPOCLevel).perform();
		Waitfor(1);
		String name=TravelrName.getText();
		logger.info("The Traveller Name is:"+name);
		
		String strstatus=ViewStatus.getText();
		logger.info("The status is:"+strstatus);
		
		String RejectedByName=RejectApproveBy.getText();
		logger.info("The Rejected By the Reporting manager name is:"+RejectedByName);
		BackButton.click();
	}
	
	
	
	
	
	//RM Level
	public void clickToApproveTab()
	{
		
		ToApproveTab.click();
		Waitfor(1);
		
	}
	
	public void selectEMPToApproveTab()
	
	{
		
		SelectEmpRMlEVEL.click();
		
	}
	
	  
	public void assignFunction()
	{
		
		ToAssigneIcon.click();
		String NameofTraveller=TravellerNameRMLevel.getText();
		Waitfor(1);
		logger.info("Name of Traveller is:"+NameofTraveller);
		RemarkatAssigneLevel.sendKeys("Assigned to self Only.....!!!!");
		AssignButton.click();
		Waitfor(2);
		logger.info("Assigned successfully...!!!!");
		
	}
	
	public void rejectFunction()
	{
		
		ToRejectIcon.click();
		RemarkatReject.sendKeys("Rejected From Reporting Manager");
		RejectButton.click();
		Waitfor(2);
		logger.info("Rejected successfully...!!!!");
	
	}
	
	public void statusCheckRejected()
	{
		
		
		SelectEmpRMlEVEL.click();
		Actions dbclick=new Actions(driver);
		dbclick.doubleClick(SelectEmpRMlEVEL).perform();
		Waitfor(1);
		
		String TraverName=TravelrName.getText();
		logger.info("The Traveller Name is:"+TraverName);
		Waitfor(1);
		
		
		String status=ViewStatus.getText();
		logger.info("The Status is:"+status);
		Waitfor(1);
		
		String RejectedByName=RejectApproveBy.getText();
		logger.info("The Rejected By the Reporting manager name is:"+RejectedByName);
		BackButton.click();
		
	}
	
	
	
	public void approveFunction()
	{
		ToApproveIcon.click(); 
		Waitfor(1);
		RemarkAtRMToApprove.sendKeys("Travel for others is Approved By RM");
		ApproveButton.click();
		Waitfor(2);
		logger.info("Approved successfully...!!!!");
	
	}
	 
    public void statuscheckApproved()
    {
    
    	SelectEmpRMlEVEL.click();
		Actions dbclick=new Actions(driver);
		dbclick.doubleClick(SelectEmpRMlEVEL).perform();
		Waitfor(1);
		
		String TraverName=TravelrName.getText();
		logger.info("The Traveller Name is:"+TraverName);
		Waitfor(1);
		
		
		String statuss=ViewStatus.getText();
		logger.info("The Status is:"+statuss);
		Waitfor(1);
		
		String approvedByName=RejectApproveBy.getText();
		logger.info("The Rejected By the Reporting manager name is:"+approvedByName);
		BackButton.click();
    
    
    }
	
	
	
	
	// RMG Level 
	
	public void toHandleTab()
	{
		ToHandleTab.click();
	}
	
	public void selectEMPToHandle()
	{
		SelectEmpRMGLevel.click();
		Waitfor(1);
		
	}
	
	public void assignClick()
	{
		ToassignIcon.click();
		
	}
	
	public void assignFunctionRMG()
	{
		
		ItemNum1.sendKeys("01");
		Itemcost1.sendKeys("1000");
		AddCostTrip.click();
		ItemNum2.sendKeys("02");
		Itemcost2.sendKeys("1000");
		RemarkAtAssign.sendKeys("Remark at Assign Function");
		Select Tstatus=new Select(StatusSelect);
		Tstatus.selectByVisibleText("Assigned");
		logger.info("Assigned successfully....!!!");
	
	
	}
	
	
	public void processedFunctionRMG()
	{
		RemarkAtProcessedLevel.sendKeys("Remark at  Processed Function Level...!!!!");
		Select status=new Select(StatusSelect);
		status.selectByVisibleText("Processed");
		logger.info("Processed successfully....!!!");
	
	}
	
	
	public void submitRMG()
	{
		SubmitRMGLevel.click();
		
		
	}
	
	public void statuscheck()
	{
		
		Actions oaction=new Actions(driver);
		oaction.doubleClick(SelectEmpRMGLevel).perform();
		String str=status.getText();
		logger.info("The Status From RMG is:"+str);
	}
	
	
	
	
}
