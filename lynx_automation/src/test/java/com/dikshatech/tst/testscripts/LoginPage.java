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
import com.dikshatech.tst.objectrepository.LoginPageObjects;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends TestBase
{

	@Test(priority=1, enabled=true,description= "*****Validation of all the webelement and functionalities composed in Login_Page*****")
	public void VerifyLoginPage() throws Exception
	{
	    //Login page object creation.
		LoginPageObjects LP = PageFactory.initElements(driver, LoginPageObjects.class);
		//Validating the application Url with the current Url.
		String exp_url=  ConfigDataProvider.getProp().getProperty("url");
		String act_url = getCurrentUrl();
		 softassert().assertEquals(act_url, exp_url);
		//logger.log(LogStatus.PASS, "Application Url Verified");
		logger.info(act_url);
		
		//Validating the Login Page Title.
		String title= getTitle();
		 softassert().assertTrue(title.contains("LYNX"), "The Title is not matching");
		//logger.log(LogStatus.PASS, "Page Title Verified");
		
		//Validating "SIGN IN" Icon of Login Page.
		String text= driver.findElement(By.xpath("//h1[@class='text-center login-title']")).getAttribute("innerText");
		 softassert().assertTrue(text.contains("SIGN IN"), "No SIGN IN icon present");
		logger.info(text);
		
    	//Validating "DIKSHA_LOGO" image file.
		//LP.diksha_logo();
		
		//Validating SIGN IN button color.
		String color = driver.findElement(By.xpath("//button[@id='btnSubmit']")).getCssValue("color");
	    logger.info(color);
	    String hex= Color.fromString(color).asHex();
	     softassert().assertEquals(hex, "#ffffff");
	    logger.info(hex);
	    Waitfor(2);
	    
	   
	    
	    
	   //Validating Login functionalities with Invalid Mail-Id & Valid Password.
	    LP.signIn("Roshan."+System.currentTimeMillis()+"@dikshatech.com", "Lynx");
	    boolean result0= LP.Login_Page();
	     softassert().assertTrue(result0, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("vikash.dubey@dikshatech.com", "Lynx");
	    boolean result1= LP.Login_Page();
	     softassert().assertTrue(result1, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("Chinmay.Shaikh@dikshatech.com", "Lynx");
	    boolean result2= LP.Login_Page();
	     softassert().assertTrue(result2, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("Rahul."+System.currentTimeMillis()+"@dikshatech.com", "Lynx");
	    boolean result3= LP.Login_Page();
	     softassert().assertTrue(result3, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("Manjunath.srivastava@dikshatech.com", "Lynx");
	    boolean result4= LP.Login_Page();
	     softassert().assertTrue(result4, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("vijay.bhosale@dikshatech.com", "Lynx");
	    boolean result5= LP.Login_Page();
	     softassert().assertTrue(result5, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    
	    //Validating Login functionalities with Invalid Mail-Id & InValid Password.
	    LP.signIn("Roshan."+System.currentTimeMillis()+"@dikshatech.com", "abc"+System.currentTimeMillis()+"");
	    boolean result6= LP.Login_Page();
	     softassert().assertTrue(result6, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("vikash.alok@dikshatech.com", "123");
	    boolean result7= LP.Login_Page();
	     softassert().assertTrue(result7, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("Chinmay."+System.currentTimeMillis()+"@dikshatech.com", "1&2"+System.currentTimeMillis()+"");
	    boolean result8= LP.Login_Page();
	     softassert().assertTrue(result8, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("Rahul.rao@dikshatech.com", "!@#"+System.currentTimeMillis()+"");
	    boolean result9= LP.Login_Page();
	     softassert().assertTrue(result9, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("Manjunath."+System.currentTimeMillis()+"@dikshatech.com", "     AaBbCc");
	    boolean result10= LP.Login_Page();
	     softassert().assertTrue(result10, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("Vijay.dinatah.chahuan@dikshatech.com", "    ");
	    boolean result11= LP.Login_Page();
	     softassert().assertTrue(result11, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    
	    //Validating Login functionalities with Valid Mail-Id & InValid Password.
	    LP.signIn("manjunatha.m@dikshatech.com", "123ABC"+System.currentTimeMillis()+"");
	    boolean result12= LP.Login_Page();
	     softassert().assertTrue(result12, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("udaya.matta@dikshatech.com", "abc123@#$");
	    boolean result13= LP.Login_Page();
	     softassert().assertTrue(result13, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("pooja.prabhu@dikshatech.com", "abc@123");
	    boolean result14= LP.Login_Page();
	     softassert().assertTrue(result14, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("spurthi.sb@dikshatech.com", "8088838526");
	    boolean result15= LP.Login_Page();
	     softassert().assertTrue(result15, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("shambhavi@dikshatech.com", "shambhavi");
	    boolean result16= LP.Login_Page();
	     softassert().assertTrue(result16, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    LP.signIn("bharat@dikshatech.com", "   "+System.currentTimeMillis()+"");
	    boolean result17= LP.Login_Page();
	     softassert().assertTrue(result17, "Bug in login functionalities, with invalid credential-LogIn Successful");
	    Waitfor(1);
	    
	  //Validating Login functionalities with Valid Mail-Id & Valid Password.
	    Waitfor(1);
	    LP.signIn("manjunatha.m@dikshatech.com", "Lynx");
	    boolean result18= LP.Home_Page();
	    logger.info(result18);
	    Waitfor(1);
	     softassert().assertTrue(result18, "Bug in login functionalities, with Valid credential-LogIn Unsuccessful");
	    LP.Log_Out();
	    Waitfor(1);
	    LP.signIn("udaya.matta@dikshatech.com", "Lynx");
	    boolean result19= LP.Home_Page();
	    Waitfor(1);
	     softassert().assertTrue(result19, "Bug in login functionalities, with Valid credential-LogIn Unsuccessful");
	    LP.Log_Out();
	    Waitfor(1);
	    LP.signIn("pooja.prabhu@dikshatech.com", "Lynx");
	    boolean result20= LP.Home_Page();
	    Waitfor(1);
	     softassert().assertTrue(result20, "Bug in login functionalities, with Valid credential-LogIn Unsuccessful");
	    LP.Log_Out();
	    Waitfor(1);
	    LP.signIn("spurthi.sb@dikshatech.com", "Lynx");
	    boolean result21= LP.Home_Page();
	    Waitfor(1);
	     softassert().assertTrue(result21, "Bug in login functionalities, with Valid credential-LogIn Unsuccessful");
	    LP.Log_Out();
	    Waitfor(1);
	    LP.signIn("shambhavi@dikshatech.com", "Lynx");
	    boolean result22= LP.Home_Page();
	    Waitfor(1);
	     softassert().assertTrue(result22, "Bug in login functionalities, with Valid credential-LogIn Unsuccessful");
	    LP.Log_Out();
	    Waitfor(1);
	    LP.signIn("bharat@dikshatech.com", "Lynx");
	    boolean result23= LP.Home_Page();
	    Waitfor(1);
	     softassert().assertTrue(result23, "Bug in login functionalities, with Valid credential-LogIn Unsuccessful");
	    LP.Log_Out();
	    
	    //Validating the "Remember Me" Function in Login Page.
	    Waitfor(1);
	    LP.remember_Me();
	    LP.signIn("bharat@dikshatech.com", "Lynx");
	    Waitfor(2);
	    boolean result24= LP.Home_Page();
	    Waitfor(1);
	     softassert().assertTrue(result24, "Bug in login functionalities, Remember_Me check box selected with Valid credential-LogIn successful but after Logout existing login credential is not present.");
	    LP.Log_Out();
	    Waitfor(1);
	    LP.SignIn_Button();
	    Waitfor(1);
	    boolean result25= LP.Login_Page();
	    Waitfor(1);
	     softassert().assertTrue(result25, "Bug in login functionalities, Remember_Me check box selected with Valid credential-LogIn successful but after Logout existing login credential is not present.");
	    Waitfor(1);
	    
	    //Validating the "Forgot Password?" function.
	    LP.Forgot_Password_Button();
	    LP.Reset_mail_id("bharat");
	    LP.Reset_Password_Button();
	    Waitfor(2);
	    /*String Email_Error_Msg= LP.Error_Message();
	    String exp= "the email address is invalid";
	     softassert().assertEquals(Email_Error_Msg, exp);
	    Waitfor(1);*/
	    LP.Reset_mail_id("bharat@dikshatech.com");
	    boolean status= LP.Green_Icon();
	     softassert().assertTrue(status, "Either mail is not valid or Green Icon is not displaying");
	    LP.Close_Reset_Window();
//	    String UN_Error_Msg= driver.findElement(By.xpath("//small[@style='']")).getText();
//	    String exp_msg= "User Name is required";
//	     softassert().assertEquals(UN_Error_Msg, exp_msg);
	    
	
	}

	}
