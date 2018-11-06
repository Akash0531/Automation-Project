package com.dikshatech.tst.objectrepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;

public class ITAssetsObjects extends TestBase{
	
    JavascriptExecutor jse= (JavascriptExecutor)driver;
    String selected_reportingdate="";
    String selected_dateofissue="";
    String star="∗";
    String usnLynx= "";
    String pwdLynx="";
    
	@Test
	public ITAssetsObjects(WebDriver driver)
	
	{
		this.driver=driver;
	}
	

	//IT Assets module
	
	@FindBy(xpath="//span[text()='My Lynx']")        			   		 WebElement MYRequests_Module;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement ITAsset_Module;	
	
	//Bench Manager Objects
	
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement NewAsset_Button_Bench;	
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_Allocation_Yes_radio;	
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_Allocation_No_radio;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_Employee_ID;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_Employee_Name;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_Type;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Accessories;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Operating_System;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Apps_Tools;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_save_Buttom;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_submit_Buttom;
		
	//IT Admin Objects
	
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement ITAsset_ToApprovetab;	
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Select_ITAsset_row;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_Accept_Button;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_Forward_Button;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_Reject_Button;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_ITAdmin_Reject_Comments;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_Stockcheck_Button;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_Stockcheck_Yesbutton;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Asset_Stockcheck_Nobutton;
	
	
	//COO Objects
	
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement COO_SelectAssets_row;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement COO_Accept_button;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement COO_Reject_button;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement COO_Reject_Reason_comments;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement COO_Reject_submit_button;
	
	
	
	public void Click_Myrequests()
	{
		MYRequests_Module.click();
		Waitfor(2);
	}
	public void Click_IT_Assetstab()
	{
		ITAsset_Module.click();
		Waitfor(2);
	}
	
	
	
}
