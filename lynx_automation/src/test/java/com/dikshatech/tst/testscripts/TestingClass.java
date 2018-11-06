package com.dikshatech.tst.testscripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.dataprovider.ExcelWriteData;
import com.dikshatech.tst.objectrepository.GetterSetter;
import com.dikshatech.tst.objectrepository.HomePageObjects;
import com.dikshatech.tst.objectrepository.LeavesObject;
import com.dikshatech.tst.objectrepository.LoginPageObjects;
import com.dikshatech.tst.objectrepository.LoginTesting;
import com.dikshatech.tst.objectrepository.PerdiemReconciliationObjects;
import com.dikshatech.tst.objectrepository.Pojo;
import com.dikshatech.tst.objectrepository.ReimbursementSubmoduleObjects;
import com.dikshatech.tst.objectrepository.SalesDriveObjects;
import com.dikshatech.tst.objectrepository.TimesheetsSubmoduleObjects;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestingClass extends TestBase{

	@Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in HomePage*****")
	public void VerifyHomePage() throws Exception
	{
//		Login_Testing login = PageFactory.initElements(driver, Login_Testing.class);
//		
//		login.welcome_mail_validation("dikshatechno", "Parthasarathi", "@jourrapide.com");
//		
		
/*		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat1 = new SimpleDateFormat("MMMM");

		String y_m_d= dateFormat.format(date);
		String month= dateFormat1.format(date);*/
		
		
		// Selecting the Expected Close Date from the date picker.
/*		Random random = new Random();
		int minDay = (int) LocalDate.of(2018, 6, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2018, 12, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		int ranDate = 5;//randomBirthDate.getDayOfMonth();
		String expDate = String.valueOf(ranDate);
		int monthDigit= 7;//randomBirthDate.getMonthValue();
		String month= String.valueOf(monthDigit);
		int ranYear = randomBirthDate.getYear();
		String expYear = String.valueOf(ranYear);
		Month ranMonth = randomBirthDate.getMonth();
		String expMonth = String.valueOf(ranMonth);
		String selMonth= expMonth.substring(0,1) + expMonth.substring(1,3).toLowerCase();
		if(ranDate<10) {
			expDate= "0"+expDate;
		}
		if(monthDigit<10) {
			month= "0"+month;
		}
		System.out.println(randomBirthDate);
		System.out.println(expDate);
		System.out.println(expMonth);
		System.out.println(expYear);
		System.out.println(selMonth);
		System.out.println(expDate+"-"+month+"-"+expYear);*/
		ObjectInitClass.pipelineDrive(driver);
				
/*		logger.log(LogStatus.INFO, "On select of customer checkBox, it is disabling the Customer Dropdown");
		ObjectInitClass.pipeLine.custCheckboxfieldsValidation(1);
		ObjectInitClass.pipeLine.contCheckboxfieldsValidation(1);*/
		//ObjectInitClass.pipeLine.addDealValidation(1);
/*		ObjectInitClass.pipeLine.dealDragNDrop("Infosys deal", "Negotiation Stage");
		ObjectInitClass.pipeLine.onwerDDValidation();
		ObjectInitClass.pipeLine.ownerChangepopup("Punitha M");
		ObjectInitClass.pipeLine.stageupdateRemark("Testing it now");
		ObjectInitClass.pipeLine.stageSave();
		ObjectInitClass.pipeLine.updatedOwnerValid("Punitha M", "Infosys deal");*/
		//ObjectInitClass.pipeLine.wonDeallanding("Infosys deal");
		//ObjectInitClass.pipeLine.wonRemarkvalidation("Won remark should store in Notesl");
		//ObjectInitClass.pipeLine.dealDragNDrop( "dealName",  "dealStage");
/*		Date now= new Date();
		String inc= "11-07-2018";
		Date incDate;
		try {
			incDate=new SimpleDateFormat("dd-MM-yyyy").parse(inc);
			int diffInDays = (int) ((now.getTime() - incDate.getTime()) / (1000  60  60 * 24));

			System.out.println(diffInDays);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} */

		ObjectInitClass.pipeLine.editactiveSatge();
		String str= SalesDriveObjects.pojo.getEditactiveStage();
		logger.info(str);
//		Date date = new Date();
//		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-EEEE-HH-mm-a-YYYY");
//		String subdate[]=dateFormat.format(date).split("-");
//		
//		
//		
//		String month= subdate[0];
//		System.out.println(month);
//		String day= subdate[1];
//		System.out.println(day);
//		String hour= subdate[2];
//		System.out.println(hour);
//		String minute= subdate[3];
//		System.out.println(minute);
//		String period= subdate[4];
//		System.out.println(period);
//		System.out.println(subdate[5]);
		
		
	
//		Waitfor(1);
//		logger.log(LogStatus.PASS, "Application Url Verified");
//		Waitfor(1);
//		report.endTest(logger);
//		report.flush();
//		report.close();
//		driver.get("file:///opt/STORAGE/New_Wokspace/perdiem/Execution_Report/testing.html");
		
		
//		driver.findElement(By.id("uploadfile")).click();
//		
//		 Robot robot = new Robot();
//		 Waitfor(2);
//		
//		robot.keyPress(KeyEvent.VK_SHIFT);
//		robot.keyPress(KeyEvent.VK_TAB);
//		
//		robot.keyPress(KeyEvent.VK_SHIFT);
//		robot.keyPress(KeyEvent.VK_TAB);
//		
//		robot.keyPress(KeyEvent.VK_SHIFT);
//		robot.keyPress(KeyEvent.VK_TAB);
//		
//		
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		
//		 Waitfor(2);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);

		// Release Enter
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//		
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_V);
//		Waitfor(2);
//		
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		
//		robot.keyPress(KeyEvent.VK_SHIFT);

		
	}}
//	//Home page object creation.
//	Home_Page_Objects HP = PageFactory.initElements(driver, Home_Page_Objects.class);
//	Login_Page_Objects LP = PageFactory.initElements(driver, Login_Page_Objects.class);
//	Reimbursement_Submodule_Objects RS= PageFactory.initElements(driver, Reimbursement_Submodule_Objects.class);
//	Timesheets_Submodule_Objects TS= PageFactory.initElements(driver, Timesheets_Submodule_Objects.class);
//	Leaves_Object Leaves = PageFactory.initElements(driver, Leaves_Object.class);
//	Perdiem_Reconciliation_Objects per = PageFactory.initElements(driver, Perdiem_Reconciliation_Objects.class);
//	
//	
//	LP.signIn("Spurthi.sb", "Lynx");
//	HP.My_Lynx();
//	Waitfor(1
//			);
//	per.perdiemsubmodule();
//	Waitfor(1);
//	per.perdiem_table("Report Generated", "USD", "77");
//	Waitfor(2);
//	
//		int count=0;
//		String col_text = "Emp Name";
//		WebElement table = driver.findElement(By.xpath("//table[@id='perdiemView']/thead/tr"));
//		List<WebElement> heading = table.findElements(By.tagName("th"));
//		for (int h = 1; h < heading.size(); h++) {
//			String text = heading.get(h).getText();
//			if (col_text.equalsIgnoreCase(text)) {
//				int col = h;
//				System.out.println("Text"+ text);
//				WebElement row_table = driver.findElement(By.xpath("//table[@id='perdiemView']/tbody"));
//				List<WebElement> rows = row_table.findElements(By.tagName("tr"));
//				for (int c = 1; c < rows.size(); c++) {
//					System.out.println("Emp Name column is present in the heading");
//					String cell_Value = driver
//							.findElement(By.xpath("//table[@id='perdiemView']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
//							.getText();
//					Waitfor(2);
//					System.out.println("empname"+ cell_Value);
//					if (cell_Value.equalsIgnoreCase("Abhinesh Vijayakumar")) {
//						driver.findElement(By.xpath("//table[@id='perdiemView']/tbody/tr[" + c + "]/td[" + (col+1) + "]")).click();
//						Waitfor(2);
//						per.edit_button();
//						count++;
//						break;
//						}
//				}
//			}
//			if(count>0)
//			{
//			break;
//			}
//		}
//		
//		
//		int count1=0;
//		float p_days= 30.0f;
//		String cellvalue1[]=new String[40];
//		Waitfor(1);
//		WebElement table1 = driver.findElement(By.xpath("//table[@id='edit_perdiem_details']/tbody"));
//		List<WebElement> heading1 = table1.findElements(By.tagName("tr"));
//		for (int h = 1; h < heading1.size(); h++) {
//				WebElement row_table = driver.findElement(By.xpath("//table[@id='edit_perdiem_details']/tbody/tr"));
//				List<WebElement> rows = row_table.findElements(By.tagName("td"));
//				System.out.println("row size is "+rows.size());
//				for (int c = 1; c <=rows.size(); c++) {
//					if(h<4)
//					{	
//					WebElement cell_Value1 = driver.findElement(By.xpath("//table[@id='edit_perdiem_details']/tbody/tr[" + h + "]/td[" + (c) + "]"));
//					String cell_Value= cell_Value1.getText();
//					
//					System.out.println("Data is : "+cell_Value);
//					System.out.println("Column "+c);
//					System.out.println("Row "+h);
//					cellvalue1[c-1]=cell_Value;
//					Waitfor(2);
//					
//					}	
//					else
//					{
//					cellvalue1[30] =driver.findElement(By.xpath("//table[@id='edit_perdiem_details']/tbody/tr[4]/td[4]")).getText();
//					System.out.println("Total Amount(INR) "+cellvalue1[30]);
//					Waitfor(1);	
//					cellvalue1[31]=driver.findElement(By.xpath("//table[@id='edit_perdiem_details']/tbody/tr[5]/td[4]")).getText();
//					System.out.println("Total Amount "+cellvalue1[31]);
//					count1++;
//					break;
//					}
//			}
//				if(count1>0)
//				{
//					break;
//				}
//				
//		}
//		

		
		
//	Waitfor(2);
//	String s= driver.findElement(By.xpath("//input[@value='Salary in Advance']")).getText();
//	System.out.println("Check now : "+s);

//	}	}

//	LP.signIn("shivaraja.n", "Lynx");
//	
//	Waitfor(2);
	
//	per.systemgenerate_report();
//	
//	Excel_Read_Data read = new Excel_Read_Data("/home/nfshome/akash.anand/workspace/Diksha_AgileLabs/Leave_Sheet.xlsx");
//	
//	HP.My_Lynx();
//	Leaves.Leave();
//	Waitfor(2);
//	Leaves.Applyleave();
//	Leaves.Pagination();
//	Leaves.Leaves_Calculation();
//	Leaves.LeaveHP_Validation();
//	Leaves.Leaves_Status();
//	Leaves.Edit_Page();
//	Leaves.edit_ReadData();
//	Leaves_Object test = new Leaves_Object(driver);x	
//	//EditLeaves editLeaves = new EditLeaves();
//
//	Excel_WriteData write = new Excel_WriteData();
//    write.Write_Data(ConfigDataProvider.prop.getProperty("leavename"),"abc", 9, 4, "Testing it again");
//    EditLeaves editLeaves = Leaves.edit_ReadData();
//    int row =0;
//    String project= editLeaves.getProjectName().trim();
//	write.Write_Data("TestingSheet", "abc", row, 0, project);
//	System.out.println("Lets see "+project.trim());
//	
//	Leaves.CancelRequest();
//	Leaves.CancelSuccessmsg();
//	
//	for(int i=1; i<read.rowCount("Leaves_Sheet"); i++)
//	{
//	Leaves.Applyleave();
//		
//	Waitfor(2);
//		
//	String P= read.getData("Leaves_Sheet", i, 0 ).toString();
//	String C= read.getData("Leaves_Sheet", i, 1).toString();
//	String L= read.getData("Leaves_Sheet", i, 2).toString();
//	String R= read.getData("Leaves_Sheet", i, 5).toString();
//	String F= read.getData("Leaves_Sheet", i, 5).toString();
//	String T= read.getData("Leaves_Sheet", i, 6).toString();
//	String CON= read.getData("Leaves_Sheet", i, 4).toString();
//	System.out.println("Contact number is: "+CON);
//	Leaves.Leave_Form(P, C, L, R, "8575986574",15 ,16);
//	break;
//	}
//	Waitfor(2);
//    Leaves.Apply_Button();
//	
//	Leaves.Message_Ok();
//	Leaves.Leave_Form(P, C, L, R, CON, 10, 20);
	
	
//	TS.Timesheets();
//	RS.Reimbursement();
//	Waitfor(2);
//	RS.Reimbursement_Bkg();
//	RS.Font_Family();
//	RS.Reimbursement_Font_Size();
//	RS.Text_Allignment();
//	RS.New_Bkg();
//	RS.New_Font_Size();
//	RS.Edit_Bkg();
//	RS.Edit_Font_Size();
//	RS.Reimbursement_Icon();
//	Waitfor(1);
//	RS.Entries_Count_Dropdown("10");
//	String count= RS.Count_Selected();
//	RS.Count_Selected();
//	RS.Count_Entry_Display();
//	RS.SearchBox("rr");
//	RS.Next_Table();
//	RS.Previous_Table();
//	RS.New_Reimbursement_Form_Self("Diksha_IPAD", "INR");
//	RS.Expenses_Self_Table("Meals ");
//	Rough.Expenses_Self_Table();
//	TS.New_Tab();
//	Waitfor(2);
//	TS.Expenses_Self_Table("Diksha_IPAD", "Lynx");
//	
	
	
//	
//	
//	WebElement table= driver.findElement(By.xpath("//div[@class='table-responsive']/table//thead[2]"));
//	List<WebElement> list= table.findElements(By.tagName("tr"));
//	int list_size= list.size();
//	System.out.println("Size of the list is "+list_size);
//	for(int i=1; i<=list_size; i++)
//	{
//		List<WebElement> heading= list.get(i).findElements(By.tagName("td"));
//		System.out.println("Total Number of Td tag is : "+heading.size());
//		for(int j= 0; j<heading.size(); j++)
//		{
//			
//		    System.out.println("Kucch Bhi");
//			List<WebElement> column= heading.get(j).findElements(By.tagName("b"));
//			System.out.println("Total Number of B tag is : "+column.size());
//			if(column.size() == 0) 
//			{
//				System.out.println("No B tag is present");
//			}
//			else 
//			{
//				for(int c=0; c<=column.size(); c++)
//			
//			System.out.println(column.get(c).getText());
//			}	
//		}
	
	
//div[@class='table-responsive']
//div[@class='table-responsive']/table/thead[2]/tr

//private enum ElementStatus{
//    VISIBLE,
//    NOTVISIBLE,
//    ENABLED,
//    NOTENABLED,
//    PRESENT,
//    NOTPRESENT
//}
//private ElementStatus isElementVisible(WebDriver driver, By by,ElementStatus getStatus){
//    try{
//        if(getStatus.equals(ElementStatus.ENABLED)){
//            if(driver.findElement(by).isEnabled())
//                return ElementStatus.ENABLED;
//            return ElementStatus.NOTENABLED; 
//        }
//        if(getStatus.equals(ElementStatus.VISIBLE)){
//            if(driver.findElement(by).isDisplayed())
//                return ElementStatus.VISIBLE;
//            return ElementStatus.NOTVISIBLE;
//        }
//        return ElementStatus.PRESENT;
//    }catch(org.openqa.selenium.NoSuchElementException nse){
//        return ElementStatus.NOTPRESENT;
//    }
//}