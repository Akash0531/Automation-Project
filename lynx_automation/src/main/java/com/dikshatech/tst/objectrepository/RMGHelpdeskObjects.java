package com.dikshatech.tst.objectrepository;

import java.util.List;

import org.openqa.selenium.By;
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

public class RMGHelpdeskObjects extends TestBase
{
	
    JavascriptExecutor jse= (JavascriptExecutor)driver;
    @Test
	public void Employee_Onboarding_Objects(WebDriver driver)
	{
		this.driver = driver;
	}
    //Employee level
    
	@FindBy(xpath="//span[text()='My Lynx']")        			   		 WebElement MYLynx_Module;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement RMG_helpdesk_tab;	
	@FindBy(xpath="//span[text()='My Lynx']")        			   		 WebElement New_case_button;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement FAQ_button;
	@FindBy(xpath="//span[text()='My Lynx']")        			   		 WebElement search_Box;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement send_button;	
	@FindBy(xpath="//span[text()='My Lynx']")        			   		 WebElement cancel_button;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement yes_option;	
	@FindBy(xpath="//span[text()='My Lynx']")        			   		 WebElement No_option;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement dropdown_select;	
	@FindBy(xpath="//span[text()='My Lynx']")        			   		 WebElement Describe_Query_text;
	@FindBy(xpath="//span[text()='My Lynx']")        			   		 WebElement notification;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement searchButtonInline;
	
	
	
	public void RMG_Helpdesk_module()
	{
		RMG_helpdesk_tab.click();
		Waitfor(1);
		
	}
	public void create_new_case()
	{
		  New_case_button.click();
		  Waitfor(1);
		  search_Box.sendKeys("query");	
		  List <WebElement> listItems = driver.findElements(By.xpath("//div[@class='query']//li"));
		 for (int q = 0; q < listItems.size(); q++) 
			{
			logger.info(listItems.get(0).getText()); 
			listItems.get(0).click();
			Waitfor(2);
		    searchButtonInline.click();
			}
	}
	
	public void FAQ_button_click()
	{
		FAQ_button.click();
	}
	
	public void send_button_click()
	{
		send_button.click();
	}
	
	public void cancel_button_click()
	{
		cancel_button.click();
	}
	public void yes_button_click()
	{
		Boolean helpfuloption = yes_option.isDisplayed();
		if(helpfuloption==true)
		{
		yes_option.click();
	}
		if(helpfuloption==false)
		{
		
	}
	}
		
	



	
	
	
	

	
	
	
}

