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

public class Newsobjects extends TestBase 
{
    @Test
	public Newsobjects(WebDriver driver)
	{
		this.driver = driver;
	}
    
    @FindBy(xpath="//li[@id='news-menu']") 					                                    WebElement news_module;
	@FindBy(xpath="//button[@title='New']") 					                                WebElement add_news_button;
	@FindBy(xpath="//button[@title='Edit']") 					                                WebElement Edit_news;
	@FindBy(xpath="//button[@title='Delete']") 					                                WebElement Delete_news;
	@FindBy(xpath="//html[@lang='en']") 					                                    WebElement Category_Mandatory;
	@FindBy(xpath="//input[@name='news_rms_file']") 					                        WebElement upload_news;
	@FindBy(xpath="//button[@onclick='savenewsdata()']") 					                    WebElement save_news;
	@FindBy(xpath="//span[contains(.,'News Updated successfully')]") 					        WebElement news_updated;
	@FindBy(xpath="//div[contains(.,'XNews saved successfully')]") 					            WebElement news_saved_msg;
		
}
