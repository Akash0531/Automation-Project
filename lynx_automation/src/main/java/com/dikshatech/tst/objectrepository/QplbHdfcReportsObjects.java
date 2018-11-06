package com.dikshatech.tst.objectrepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;

public class QplbHdfcReportsObjects extends TestBase 
{

	@Test
	public QplbHdfcReportsObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//th[contains(.,'IN-MR-46')]") WebElement PerdiemReport_Row;
	@FindBy(xpath = "//button[@id='hdfc']") WebElement HDFC_Button;
	@FindBy(xpath = ".//*[@id='company']") WebElement Company_Dropdown;
	@FindBy(xpath = ".//*[@id='region']") WebElement Region_Dropdown;
	@FindBy(xpath = ".//*[@id='department']") WebElement Department_Dropdown;
	@FindBy(xpath = ".//*[@id='hdfccategory']") WebElement Category_Dropdwon;
	@FindBy(xpath = "//input[@id='select_all']") WebElement Employees_Checkbox;
	@FindBy(xpath = ".//*[@id='download_hdfc_bank_report']") WebElement Download_HDFC_Bank_Report;
	@FindBy(xpath = ".//*[@id='pay_perdiem']") WebElement Pay_Button;
	@FindBy(xpath = ".//*[@id='hdfc_download']/div/div/div[4]/button[2]") WebElement Upload_Button;
	@FindBy(xpath = ".//*[@id='hdfc_download']/div/div/div[4]/button[3]") WebElement Close_Button;
	@FindBy(xpath = "//a[@href='javascript:unpaid(23,'unpaid')']") WebElement Un_Paid_Link;
	@FindBy(xpath = "//input[@id='p_reason']") WebElement NonPayment_Reason;
	@FindBy(xpath = "//input[@class='hasDatepicker']") WebElement NonPayment_Date;
	@FindBy(xpath="//button[@onclick='unpayment()']") WebElement NonPayment_SaveButton;
	
	
	public void click_PerdiemReport_Row()
	{
		PerdiemReport_Row.click();
	}
	
	public void Click_Hdfc_button()
	{
		HDFC_Button.click();
		Waitfor(2);
		Set<String>set= driver.getWindowHandles();
		logger.info(set.size());
		Iterator<String> It=set.iterator();
		String parentpage=It.next();
		String childpage =It.next();
		driver.switchTo().window(childpage);
	}
	
	
	public void Select_Company(String Company_Name )
	{
		Select CompanyDD = new Select(Company_Dropdown);
		logger.info("The Selected Company Name is "+Company_Name);
		Waitfor(1);	
		CompanyDD.selectByVisibleText(Company_Name);
	}
	
	public void Select_Region(String Region_Name)
	{
	Select RegionDD = new Select(Region_Dropdown);
	logger.info("The Selected Region is "+Region_Name);
	Waitfor(1);	
	RegionDD.selectByVisibleText(Region_Name);
	}
	public void Select_Department(String Department_Name)
	{
	Select RegionDD = new Select(Region_Dropdown);
	logger.info("The Selected Region is "+Department_Name);
	Waitfor(1);	
	RegionDD.selectByVisibleText(Department_Name);
	}
	public void Select_Category(String Category_Name)
	{
		Select CategoryDD = new Select(Category_Dropdwon);
		logger.info("The Selected Category is "+Category_Name);
		Waitfor(1);	
		CategoryDD.selectByVisibleText(Category_Name);
	}
	
	
	public void Select_Employeescheckbox()
	{
		Employees_Checkbox.click();
	}
	public void DownloadHDFC_Bank_Report()
	{
		Download_HDFC_Bank_Report.click();
	}
	public void Pay_HDFCBANK()
	{
		Pay_Button.click();
	}
	public void Upload_HDFC()
	{
		Upload_Button.click();
	}
	public void Click_unpaidlink()
	{
		Un_Paid_Link.click();
	}
	public void Enter_Nonpayment_Reason()
	{
		NonPayment_Reason.sendKeys("Pay Later");
		
	}
	public void Enter_Nonpayment_Date()
	{
		NonPayment_Date.sendKeys("02/02/2018");
		
	}
	public void Click_Nonpaymentreason_Savebutton()
	{
		NonPayment_SaveButton.click();
	}
	
	public void objectrepository()
	{
		// Repository object creation.
		ObjectInitClass.homepage(driver);
		ObjectInitClass.loginpage(driver);
		ObjectInitClass.leaves(driver);
		ObjectInitClass.reimbursement(driver);
		ObjectInitClass.timesheet(driver);
		ObjectInitClass.perdiempage(driver);
		
	}
		
	
	
	
	
}
