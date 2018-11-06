package com.dikshatech.tst.objectrepository;

import java.io.File;

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

public class PayslipsObjects extends TestBase 
{
	@Test
	public PayslipsObjects (WebDriver driver)
	{
		this.driver = driver;		
		
	}
	
	@FindBy(xpath="//*[@id='myfinancials-link']/a") 		  	WebElement My_Finacials;
	@FindBy(xpath="//*[@id='payslip']") 					  	WebElement Payslips;
	
	//Finance Manager Level
	@FindBy(xpath="//*[@id='payslips_manage']") 				WebElement ManagePayslipTab;
	@FindBy(xpath="//*[@id='manage_filter']/label/input") 		WebElement SearchBoxManageTab;
	@FindBy(xpath="//a[text()='Pay Slips']") 					WebElement PayslipTab;
	@FindBy(xpath="//*[@id='payslips_manag123e']") 				WebElement uploadIcon;
	@FindBy(xpath="//*[@id='uploadfileName']")					WebElement chooseFileName;
	@FindBy(xpath="//*[@id='upload_comment']") 					WebElement uploadComments;
	@FindBy(xpath="//*[@id='payslipUpload']") 				    WebElement uploadpayslip;
	@FindBy(xpath="//*[@id='search_payslip']") 					WebElement SearchPayslips;
	@FindBy(xpath="//*[@id='genericModal-body']/div/div[1]/div[3]/label/span") 	WebElement YearCheckBox;
	@FindBy(xpath="//*[@id='enterserch_year']") 				WebElement searchYear;
	@FindBy(xpath="//*[@id='genericModal-body']/div/div[3]/div[3]/label/span")WebElement monthChekBox;
	@FindBy(xpath="//*[@id='serch_month_val']") 				WebElement searchMonth;
	@FindBy(xpath="//*[@id='payslipSearch']") 				    WebElement searchButtonClick;
	@FindBy(xpath="//*[@id='itr']/li[1]/a") 					WebElement PayslipsTab;
	@FindBy(xpath="//*[@id='selectElementId']") 				WebElement empYearDropDwnPayslip;
	
	//Employee Level
	@FindBy(xpath="//*[@id='selectElementId']") 				WebElement SelectYear;
	@FindBy(xpath="//*[@id='payslips_home_filter']/label/input") WebElement SearchPayslipBasedonMonth;
	@FindBy(xpath="//*[@id='payslips_home']/tbody/tr") 			WebElement SelectPayslip;
	@FindBy(xpath="//*[@id='downloadpayslip']") 				WebElement Downloadpayslip;
	@FindBy(xpath="//*[@id='payslips_home_filter']/label/input") WebElement searchPayslipsByEmp;
	
	
	
	// Employee Level download payslip
	
	public void myFinanceTab()
	{
		My_Finacials.click();
	}
	
	public void payslipModule()
	{
		
		Payslips.click();
		Waitfor(1);
	}
	
	public void payslipTab()
	{
		
		PayslipsTab.click();
		Waitfor(1);
	}
	
	public void selectYearsearchPayslip(String Year, String Month)
	{
		Waitfor(2);
		SearchPayslips.click();
		Waitfor(2);
		YearCheckBox.click();
		Waitfor(2);
		Select oselect=new Select(searchYear);
		oselect.selectByVisibleText(Year);
		Waitfor(2);
		logger.info("The Selected Year is:"+Year);
		monthChekBox.click();
		Waitfor(1);
		Select select=new Select(searchMonth);
		select.selectByVisibleText(Month);
		Waitfor(2);
		searchButtonClick.click();
	
	}
	
	public void uploadPayslip()
	{
		uploadIcon.click();
		Waitfor(2);
		chooseFileName.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadZIP")).getAbsolutePath());
		Waitfor(2);
		uploadComments.sendKeys("The November Payslips are Selected To Upload...!!!!");
		Waitfor(1);
		uploadpayslip.click();
		logger.info("The Payslips are Selected and Uploaded Successfully...!!!");
	}
	
	
	
	public void SearchpayslipOnMonth(String SerchYear, String searchMonth)
	{
		
		Select select=new Select(empYearDropDwnPayslip);
		select.selectByVisibleText(SerchYear);
		Waitfor(2);
		searchPayslipsByEmp.sendKeys(searchMonth);
		Waitfor(2);
		
	}
	
	
	public void selectPayslip()
	{
		Waitfor(1);
		SelectPayslip.click();
		
	}
	
	public void downloadPayslip()
	
	{
		
		boolean status=Downloadpayslip.isEnabled();
		if (status==true) {
			
			Waitfor(1);
			Downloadpayslip.click();
			Waitfor(2);
			logger.info("Download button is enabled and clicked successfully...!!");
		} else {
			logger.info("Download button is not enabled...!!");
		}
		
	}
	
	
	public void managePayslip()
	{
		ManagePayslipTab.click();
		Waitfor(2);
	}
	
	
	
	
	
	
	
	
}
