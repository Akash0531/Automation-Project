package com.dikshatech.tst.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelWriteData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class FestivalWishesModule extends TestBase

{
	 @Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in Festival wishes*****")
		public void VerifySpecialistRMZ() throws Exception
		{
		
			ObjectInitClass.homepage(driver);
			ObjectInitClass.loginpage(driver);
			ObjectInitClass.festivalModule(driver);
			
			
			String Username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Request from excel
		  	Waitfor(2);
		  	String Possword= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Summary from excel
		  	Waitfor(2);
			//Login with RMG 
			ObjectInitClass.LP.signIn(Username, Possword);
			Waitfor(3);
			ObjectInitClass.F_Wishes.RMGTab();
			Waitfor(2);
			ObjectInitClass.F_Wishes.festivalwishesTab();
			Waitfor(2);
			
			//Create Wishes edit and Delete Wishes....
			String Dateone= excelreaddata().getData("ITSuport", 9, 0 ); //Reading Request from excel
		  	Waitfor(1);
		  	String Occasionone= excelreaddata().getData("ITSuport", 9, 1 ); //Reading Summary from excel
		  	Waitfor(1);
		  	String Messageone= excelreaddata().getData("ITSuport", 9, 2 ); //Reading Description from excel
		  	Waitfor(1);
		  
		  	String DateTwo= excelreaddata().getData("ITSuport", 10, 0 ); //Reading Request from excel
		  	Waitfor(1);
		  	String OccasionTwo= excelreaddata().getData("ITSuport", 10, 1 ); //Reading Summary from excel
		  	Waitfor(1);
		  	String MessageTwo= excelreaddata().getData("ITSuport", 10, 2 ); //Reading Description from excel
		  	Waitfor(1);
		  	
		  	
			ObjectInitClass.F_Wishes.createNewWishesone(Dateone, Occasionone, Messageone );
			ObjectInitClass.F_Wishes.saveWishes();
			Waitfor(2);
			ObjectInitClass.F_Wishes.viewWishes();
			Waitfor(2);
			ObjectInitClass.F_Wishes.selectcalender();
			Waitfor(1);
			ObjectInitClass.F_Wishes.EditWishes(DateTwo, OccasionTwo, MessageTwo);
			Waitfor(2);
			ObjectInitClass.F_Wishes.selectcalender();
			Waitfor(2);
			ObjectInitClass.F_Wishes.deleteWishes();
			Waitfor(2);
			
			//create wishes and check wishes in Home page
			ObjectInitClass.F_Wishes.createNewWishes(Dateone, Occasionone, Messageone,DateTwo, OccasionTwo, MessageTwo);
			Waitfor(2);
			ObjectInitClass.F_Wishes.saveWishes();
			Waitfor(2);
			ObjectInitClass.F_Wishes.viewWishes();
			Waitfor(1);
			ObjectInitClass.F_Wishes.checkWishesHomePage();
			Waitfor(2);
		  	ObjectInitClass.HP.Log_Out();
		  	Waitfor(2);
				
		}
	 		
}
