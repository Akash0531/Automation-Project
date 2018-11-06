package com.dikshatech.tst.objectrepository;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;

public class LoginTesting extends TestBase{

	@Test
	public LoginTesting(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Login method with its required webElement for validaing the link shared to the candidate personal mail ID(Akash.Anand)
	@FindBy(xpath="//input[@id='home-email']")        			    			WebElement Username_Input;
	@FindBy(xpath="//button[@id='copy-button']")        			    		WebElement CopyId_Button;
	@FindBy(xpath="//button[@id='domain-select']")        			    		WebElement Domain_Button;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li/a") 		WebElement Domain_Dropdown_values;
	@FindBy(xpath="//ul[@id='email-list']/li[1]")        			   			WebElement Topmost_Mail;
	@FindBy(xpath="//ul[@id='email-list']/li[1]/a/div/div[2]/p")  				WebElement Mail_Subject;
    @FindBy(xpath=".//*[@id='email-list']/li[1]/div/dl/dd[2]")        			WebElement From_MailID;
    @FindBy(xpath=".//*[@id='email-list']/li[1]/div/dl/dd[3]")        			WebElement WelcomeMail_Subject;
	@FindBy(xpath="//table[@cellspacing='6']/tbody/tr/td/div/p[1]")        		WebElement Candidate_FirstName;
	@FindBy(xpath="//a[@href='#']")        			   							WebElement Lynx_Link;
	
	//Method to redirect to the Fake Inbox for validating the link shared to the candidate mail ID
	public void welcome_mail_validation(String username, String Emp_Firstname, String domain_name) throws Exception
	{
		
		driver.get("http://www.fakemailgenerator.com/");
		Waitfor(2);
		Username_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),username);
		Waitfor(1);
		CopyId_Button.click();
		Waitfor(2);
		Domain_Button.click();

		List<WebElement> rowVals = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a"));
		
		for (WebElement webElement : rowVals) {
			
			String domain= webElement.getText();
		
			
			if(domain.equalsIgnoreCase(domain_name))
			{
				webElement.click();
				
				break;
			}
		}
		
		Waitfor(3);
		Topmost_Mail.click();
		Waitfor(2);
		//Validating the mail Subject content
		String subject= Mail_Subject.getText();
		if(subject.contains("Welcome to Diksha"))
		{
			logger.info("Candidate has received the Diksha Welcome Mail");
		}
		else
		{
			logger.info("Candidate has not received the Diksha Welcome Mail");
		}
		Waitfor(1);
		//Validating the mail From ID
		String from_Id= From_MailID.getText();
		if(from_Id.contains("venkatesh.badiger@dikshatech"))
		{
			logger.info("Diksha Welcome Mail has been sent by RMG department-(noreply@dikshatech.com)");
		}
		else
		{
			logger.info("Diksha Welcome Mail has not been sent by RMG department-(noreply@dikshatech.com)");
		}
		
		//Validating the Candidate first name
//		String cand_firstname= driver.findElement(By.xpath("//table[@cellspacing='6']/tbody/tr/td/div/p[1]")).getText();
//		Waitfor(1);
//		if(cand_firstname.contains(Emp_Firstname))
//		{
//			logger.info("Candidate first name is matching in the Diksha Welcome Mail");
//		}
//		else
//		{
//			logger.info("Candidate first name is not matching in the Diksha Welcome Mail");
//		}
		
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//	    driver.switchTo().window(tabs.get(0));
	    
        Waitfor(2);
        Lynx_Link.click();
        
	}
	
	
}
