package com.dikshatech.tst.objectrepository;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReferAFriendObjects extends TestBase 
{
  
	@Test
	
	public ReferAFriendObjects(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	@FindBy(xpath="//span[contains(.,'My References')]")             WebElement my_reference_tab;
	@FindBy(xpath="//li[@id='referafriend']")                        WebElement referafriend_module;
	@FindBy(xpath="//input[@id='referFriendRefereeName']")           WebElement  Referee_Name;
	@FindBy(xpath="//input[@id='referFriendDepartment']")            WebElement  Refree_Department;
	@FindBy(xpath="//select[@id='referFriendExperienceLevel']")      WebElement  Refree_Experience_Level;
	@FindBy(xpath="//select[@id='referFriendJobTitle']")             WebElement  Refree_Job_Title;
	@FindBy(xpath="//textarea[@id='referee_comments']")              WebElement  Refree_comments;
	@FindBy(xpath="//button[@id='btnReferFriendUpload']")            WebElement  Refree_profile_upload ;
	@FindBy(xpath="//button[@onclick='onReferFriendSubmit()']")      WebElement submit_button;
	@FindBy(xpath="//input[@id='uploadfileName']")                   WebElement file_browse_button;
	@FindBy(xpath="//textarea[@id='upload_comment']")                WebElement uploadinfile_comments ;
	@FindBy(xpath="//button[@id='referFriendUpload']")               WebElement referFriendUpload ;
	@FindBy(xpath="//div[contains(.,'XFile uploaded successfully')]")WebElement fileuploaded_status ;
	@FindBy(xpath="//div[contains(.,'XProfile Submitted Successfully.')]")WebElement submiteed_status ;
	

	//employee filling refer_a_friend_module form
	
	public void my_reference_tab()
	{
		my_reference_tab.click();
	}
	public void Referee_module()
	{
		referafriend_module.click();
	}
	public void referee_enter_details(String name,String departments,String experiencelevel,String Job_Title,String comments)
	{
		Referee_Name.sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
		Waitfor(1);
		
		logger.info("name of the candidate is : "+ name);
		
		Refree_Department.sendKeys(Keys.chord(Keys.CONTROL, "a"),departments);
		Waitfor(1);
		
		logger.info("The candidate department is : "+ departments);
		Select EXPL = new Select(Refree_Experience_Level);
		
		EXPL.selectByVisibleText(experiencelevel);
		
		
		logger.info("The experienc elevel  is : "+experiencelevel);
		
		List<WebElement> length = EXPL.getOptions();
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
	

	Select S = new Select(Refree_Job_Title);
	Waitfor(2);
	S.selectByVisibleText(Job_Title);
	Waitfor(2);
	
	
	logger.info("the selected job title is : "+Job_Title);
	Refree_comments.clear();
	Waitfor(2);
	Refree_comments.sendKeys(comments);
	Waitfor(2);
	
	}
	
	public void uploadprofile(String file_description )
	{
		Refree_profile_upload.click();
		
		boolean status= file_browse_button.isDisplayed();
	
		if(status==false)
		{
			file_browse_button.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadPDF")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is enabled, It's a bug");
		}
		
		//To check whether File Upload input field 
		
	    uploadinfile_comments.sendKeys(Keys.chord(Keys.CONTROL, "a"), file_description);
	    Waitfor(1);
	    referFriendUpload.click();
	    Waitfor(1);
	    String upload_sucessfull_msg= fileuploaded_status.getText();
		logger.info("Upload file status is - "+upload_sucessfull_msg);
	}
	public void  referfriend_submit_button()
	{
		submit_button.click();
		String status=submiteed_status.getText();
		logger.info(" reffer status is "+ status );
	}
}



