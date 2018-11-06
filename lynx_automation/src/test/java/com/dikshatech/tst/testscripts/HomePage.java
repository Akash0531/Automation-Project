package com.dikshatech.tst.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.objectrepository.HomePageObjects;
import com.dikshatech.tst.objectrepository.LoginPageObjects;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends TestBase {
    
	  	
		@Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in HomePage*****")
		public void VerifyHomePage() throws Exception
		{
			//Home page object creation.
			HomePageObjects HP = PageFactory.initElements(driver, HomePageObjects.class);
			LoginPageObjects LP = PageFactory.initElements(driver, LoginPageObjects.class);

			
			
			//Validating the HomePage Url with the current Url.
			LP.signIn("bharat@dikshatech.com", "Lynx");
			Waitfor(1);
			String exp_url=  ConfigDataProvider.getProp().getProperty("url");			
			String act_url = getCurrentUrl();
			softassert().assertEquals(act_url, exp_url);
			//logger.log(LogStatus.PASS, "Application Url Verified");
			logger.info("Application Url is verified");
			logger.info("The current Home Page URL is -: "+act_url);
			
			//Validating the Home Page Title.
			String title= getTitle();
			softassert().assertTrue(title.contains("LYNX"), "The HomePage Title is not matching");
			logger.info("The Home Page title is verified and Title is: "+title);
			//logger.log(LogStatus.PASS, "Page Title Verified");
			
			//Validating Welcome Bar color.
			
			String color = driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[1]/div")).getCssValue("color");
		    logger.info("Heading RGBA colour: "+color);
		    String hex= Color.fromString(color).asHex();
		    softassert().assertEquals("Welcome Bar Hex Value: "+hex, "#333333");
		    logger.info("Welcome Bar Hex Value"+hex);
		    Waitfor(2);
		    
		    //Validating "DIKSHA_LOGO" image file.
			//LP.diksha_logo();
		    
		    //Validating News Heading Font Size & Font Style.
		    String colour = driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[1]/div")).getCssValue("color");
		    logger.info("News Heading RGBA colour: "+colour);
		    String hexa_Value= Color.fromString(color).asHex();
		    softassert().assertEquals(hexa_Value, "#333333");
		    logger.info("News Hex Value: "+hexa_Value);
		    HP.Font_Size();
		    HP.Font_Family();
		    HP.Text_Allignment();
		    
		    //Validating the Account_Holder_Name on Home Page.
		    String act= HP.Account_Holder_Name();
		    String exp= HP.Acc_Hldr_Name();
		    softassert().assertEquals(act, exp,"Account-Holder-Name is not matching");
		    
		    
		    HP.Date();
		    
		    //Validating Next & Previous Button.
		    HP.Next_Button();
		    HP.Next_Button();
		    
		    
		    HP.Previous_Button();
		    HP.Previous_Button();
		    
		    
		    //Validating Account Info section.
		    
		    HP.arrow_dropdown();
		    HP.My_Profile();
		    HP.arrow_dropdown();
		    HP.Change_Password();
		    HP.arrow_dropdown();
		    HP.Log_Out();
		    LP.signIn("bharat@dikshatech.com", "Lynx");
		    Waitfor(3);
		    
		    //Validating module present in Left side, whether it is clickable or not.
		    
		    HP.My_Lynx();
//TODO		    HP.Rreconciliation();
		    HP.My_Financials();
		    HP.My_References();
		    HP.My_Projects();
		    HP.My_Requests();
		  //TODO		    HP.Talent_Acquisition();
		  //TODO HP.RMZ();
		    
		    //Validating Birthday section.
		    HP.Birthdays_Text();
		    String actual= "September-25";
		    String Expected= HP.Birthdays_Date();
		    softassert().assertEquals(actual, Expected);
            boolean wish= HP.Birthday_Wish();
            logger.info("Birthday Wish button is "+wish);
		    softassert().assertTrue(wish, "Wish Button is not Present for the current date");
		    
		   
		}


}


		
