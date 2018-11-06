package com.dikshatech.tst.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class ClientsObjects extends TestBase {


	
	@Test
	public ClientsObjects(WebDriver driver) 
	{
		this.driver = driver;
				
	}
	@FindBy(xpath="//a[contains(.,'My Projects ')]")             WebElement my_projects;
	@FindBy(xpath="//li[@id='clients']")                           WebElement client_module;
	@FindBy(xpath="//button[@id='newprojects']")                   WebElement New_Client;
	@FindBy(xpath="//select[@id='client_region']")                 WebElement Region_dropdown;
	@FindBy(xpath="//select[@id='client_dept']")                   WebElement Department_dropdown;
	@FindBy(xpath="//input[@data-divisionname='RMG']")             WebElement Category_checkbox;
	@FindBy(xpath="//input[@id='client_name']")                    WebElement Name_entertext;
	@FindBy(xpath="//textarea[@id='client_desc']")                 WebElement enter_description;
	@FindBy(xpath="//button[@class='btn btn-primary back-btn']")   WebElement back_button;
	@FindBy(xpath="//button[@id='editclients']")                   WebElement Edit_clients;
	@FindBy(xpath="//button[@onclick='saveClient()']")             WebElement save_button;
	@FindBy(xpath="//div[@class='toast-message hide show']")       WebElement Sucessfully_msg;
	@FindBy(xpath="//span[@class='process']")                      WebElement Sucessfully_updated;
	@FindBy(xpath="//td[contains(.,'1')]")                        WebElement search_box;
	@FindBy(xpath="//span[@id='client_region_view']")              WebElement Region_capture;
	@FindBy(xpath="//span[@id='client_dept_view']")                WebElement Department_capture;
	@FindBy(xpath="//span[@id='client_name_view']")                WebElement name_capture;

	public void clickon_clients_module()
	{
		my_projects.click();
		Waitfor(2);
		client_module.click();
	}
	public void clickon_new_clients()
	{
		New_Client.click();
	}
	public void  clientdeatils(String region,String department,String cetegeory,String name, String Description)
	{
		
		Select r = new Select(Region_dropdown);
		logger.info("Selected region is "+ region);
		Waitfor(2);
		r.selectByVisibleText(region);
		Waitfor(2);
		Department_dropdown.click();
		Waitfor(2);
		Select d= new Select(Department_dropdown);
		logger.info("Selected region is "+ department);
		Waitfor(2);
		d.selectByVisibleText(department);
		Category_checkbox.click();
		Waitfor(2);
		logger.info("Selected region is "+ cetegeory);
		Waitfor(2);
		Name_entertext.sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
		Waitfor(2);
		enter_description.sendKeys(Keys.chord(Keys.CONTROL, "a"),Description);
		Waitfor(3);
		save_button.click();
		Waitfor(2);
		String msg=Sucessfully_msg.getText();	
		logger.info(msg);
		}
	public void editclient(String region,String department,String cetegeory,String name, String Description)
	{
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(name);
		Waitfor(2);
		search_box.click();
		Waitfor(2);
		Edit_clients.click();
		Waitfor(5);
		Select r = new Select(Region_dropdown);
		logger.info("Selected region is "+ region);
		r.selectByVisibleText(region);
		Waitfor(2);
		Select d= new Select(Department_dropdown);
		logger.info("Selected region is "+ department);
		d.selectByVisibleText(department);
		Waitfor(3);
		Category_checkbox.click();
		Waitfor(2);
		Name_entertext.sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
		Waitfor(3);
		enter_description.sendKeys(Keys.chord(Keys.CONTROL, "a"),Description);	
		Waitfor(3);
		driver.findElement(By.xpath("//button[@onclick='saveClientEdit()']")).click();
		Waitfor(2);
		String msg1=Sucessfully_updated.getText();	
		logger.info(msg1);
	}
public void viewpage(String name)	
{
	
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(name);
	Waitfor(2);
	search_box.click();
	Waitfor(2);
	search_box.click();
	Waitfor(2);
    Actions a =new Actions(driver);
	a.doubleClick(search_box);	
	Waitfor(2);
	 String region=excelreaddata().getData("Clients_sheet", 1, 0 );
	 softassert().assertEquals(region, Region_capture.getText());
	 logger.info(region);
	 Waitfor(2);
	 String  department=excelreaddata().getData("Clients_sheet", 1,1);
	 softassert().assertEquals(department, Department_capture.getText());
	 logger.info(department);
	 Waitfor(2);
	 String Description=excelreaddata().getData("Clients_sheet", 1,4);
	 softassert().assertEquals(name, name_capture.getText());
	 logger.info(name);
	 Waitfor(2);
	 
}
public void save_button()
{
	save_button.click();
	 Sucessfully_updated.getText();
	
}


}


