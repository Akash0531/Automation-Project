package com.dikshatech.tst.objectrepository;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class FestivalWishesObjects extends TestBase

{  
	@Test
	public FestivalWishesObjects (WebDriver driver)
	{
		this.driver = driver;		
		
	}
	
	@FindBy(xpath="//*[@id='rmg-menu']/a") 								WebElement RMGModule;
	@FindBy(xpath="//span[text()='Festival Wishes']") 					WebElement FestivalWishesTab;
	@FindBy(xpath="//*[@id='main_Content']/div/div[1]/h4/text()") 		WebElement FestivalWishesHeading;
	@FindBy(xpath="//*[@id='newFestivalWish']") 						WebElement NewFWishes;
	@FindBy(xpath="//*[@id='festival_region']") 						WebElement SelectRegion;
	@FindBy(xpath="//table/tbody/tr[1]/td[4]/i[@class='fa fa-plus-circle']") WebElement AddFestival;
	@FindBy(xpath="//button[@id='festival_wish_new_edit_modal_save']")  WebElement SaveButton;
	@FindBy(xpath="//*[@id='festivalWish_th_home']/tbody/tr[1]") 		WebElement SelectCalender;
	@FindBy(xpath="//*[@id='editFestivalWish']") 						WebElement EditButton;
	@FindBy(xpath="//*[@id='deleteFestivalWish']") 						WebElement DeleteButton;
	
	
	@FindBy(xpath="//*[@id='main_Content']/div/div[4]/button") 			WebElement BackButton;
	@FindBy(xpath="//*[@id='festival_region_span']") 					WebElement Region;
	@FindBy(xpath="//*[@id='festival_year_span']") 						WebElement Year;
	
	
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div/a[2]") 				WebElement SelectNextMonth;
	
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_day0']") 	WebElement WishesOne;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_day1']") 	WebElement WishesTwo;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_day2']") 	WebElement WishesThree;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_day3']") 	WebElement WishesFour;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_day4']") 	WebElement WishesFive;
	
	
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_occasion0']") WebElement OccasionOne;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_occasion1']") WebElement OccasionTwo;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_occasion2']") WebElement OccasionThree;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_occasion3']") WebElement OccasionFour;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_occasion4']") WebElement OccasionFive;
	
	
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_message0']") WebElement MessageOne;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_message1']") WebElement MessageTwo;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_message2']") WebElement MessageThree;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_message3']") WebElement MessageFour;
	@FindBy(xpath="//table/tbody/tr/td/input[@id='festival_message4']") WebElement MessageFive;
	
	@FindBy(xpath="//*[@id='festivalWishOnDeleteCalendarYesoId']")		 WebElement YesDelete;
	@FindBy(xpath="//*[@id='mySidenav']/li[3]/a/span") 						WebElement HomePage;
	
	@FindBy(xpath="//*[@id='fest_wishes']") 								WebElement WishesDisplay;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[2]/a") WebElement Day;
	@FindBy(xpath="//*[@id='festival_wish_new_edit_modal_update']") 		WebElement UpdateButton;
	
	
	@FindBy(xpath="//*[@id='wishtr1']/td[4]/button/i")					 WebElement Remove2;
	@FindBy(xpath="//*[@id='festivalWishOnDeleteOccasionRowYesoId']")	 WebElement Remove2Alert;
	
	public void RMGTab()
	{
		RMGModule.click();
		Waitfor(1);
		
	}
	
	public void festivalwishesTab()
	{
		FestivalWishesTab.click();
		Waitfor(1);
		
	}
	
	// Create and save wishes and Delete wishes.
	
	public void createNewWishesone(String WishDay, String OccasionnOne, String MessageOnee)
	{
		NewFWishes.click();
		Waitfor(2);
		Select oselect=new Select(SelectRegion);
		oselect.selectByVisibleText("India");
		WishesOne.click();
		Waitfor(2);
		 
		    Waitfor(1);
			//NextMonth();
			List<WebElement> dates1 = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

			int total_nodes1 = dates1.size();
			//logger.info("Calendar Date size is : " + total_nodes1);
			for (int i = 0; i < total_nodes1; i++)
			
			{
			String date1 = dates1.get(i).getText();
			// dates.get(i).click();
			// logger.info("Selected date is: "+date);
			int abc=Integer.valueOf(WishDay);
			
			if (date1.equals(Integer.toString(abc)))
			
			{
			dates1.get(i).click();
			logger.info("Selected date for wishes one is: " + date1);
			break;
			}
			
			}
		
		OccasionOne.sendKeys(OccasionnOne );
		Waitfor(2);
		MessageOne.sendKeys(MessageOnee);
		
	}
	
	public void saveWishes()
	{
		SaveButton.click();
		Waitfor(2);
		logger.info("The Festival wishes is Created and Saved Successfully");
	}
	
	//View page 
	public void viewWishes()
	{
		SelectCalender.click();
		Waitfor(2);
		Actions oaction=new Actions(driver);
		oaction.doubleClick(SelectCalender).build().perform();
		Waitfor(2);
		
		String StrRegion=Region.getText();
		logger.info("The Region In View Page is "+StrRegion);
		Waitfor(2);
		
		
		String StrYear=Year.getText();
		logger.info("The Calender Year In View Page is : "+StrYear);
		Waitfor(1);
		BackButton.click();
		
		
	}
	
	// Edit Wishes and delet wishes
		public void EditWishes(String WishDayTwo ,  String OccasionnTwo, String MessageeTwo)
		
		{
			Waitfor(2);
			EditButton.click();
			Waitfor(2);
			Select oselect=new Select(SelectRegion);
			oselect.selectByVisibleText("Australia");
			Waitfor(2);
			AddFestival.click();
			Waitfor(2);
			WishesTwo.click();
			Waitfor(1);
			
			//NextMonth();
			List<WebElement> dates2 = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

			int total_nodes2 = dates2.size();
			for (int i = 0; i < total_nodes2; i++)
				
			{
			String date1 = dates2.get(i).getText();
		
			int abc=Integer.valueOf(WishDayTwo);
			
			if (date1.equals(Integer.toString(abc)))
			
			{
			dates2.get(i).click();
			logger.info("Selected date for wishes two is : " + date1);
			break;
			}
			
			}
			
			Waitfor(2);
			OccasionTwo.sendKeys(OccasionnTwo);
			Waitfor(2);
			MessageTwo.sendKeys(MessageeTwo);
			Waitfor(2);
			Remove2.click();
			Waitfor(2);
			Remove2Alert.click();
			Waitfor(2);
			UpdateButton.click();
			Waitfor(2);
			logger.info("The Festival wishes is Edited and Updated Successfully");
			
			
		}
		
	
	
	public void deleteWishes()
	{
		
		DeleteButton.click();
		Waitfor(2);
		YesDelete.click();
		Waitfor(2);
		logger.info("The Festival wishes Deleted Suceesfully");
	}
	
	
	public void selectcalender()
	{
		
		SelectCalender.click();	
		
	}
	
	
	
	// Create, save wishes and display in Home page
	public void createNewWishes(String WishDayOne, String OccasionnOne , String MessageOnee,String WishDayTwo ,  String OccasionnTwo, String MessageeTwo )
	{
		NewFWishes.click();
		Waitfor(1);
		Waitfor(1);
		Select oselect=new Select(SelectRegion);
		oselect.selectByVisibleText("India");
		
		WishesOne.click();
		Waitfor(1);
		 
			//PreviousMonth();

			//NextMonth();
			List<WebElement> dates1 = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

			int total_nodes1 = dates1.size();
			//logger.info("Calendar Date size is : " + total_nodes1);
			for (int i = 0; i < total_nodes1; i++)
			
			{
			String date1 = dates1.get(i).getText();
			// dates.get(i).click();
			// logger.info("Selected date is: "+date);
			int abc=Integer.valueOf(WishDayOne);
			
			if (date1.equals(Integer.toString(abc)))
			
			{
			dates1.get(i).click();
			logger.info("Selected date for wishes one is: " + date1);
			break;
			}
			
			}
			
		Waitfor(2);
		OccasionOne.sendKeys(OccasionnOne);
		Waitfor(2);
		MessageOne.sendKeys(MessageOnee);
		Waitfor(2);
		AddFestival.click();
		Waitfor(2);
		WishesTwo.click();
		Waitfor(1);
		
		//NextMonth();
		List<WebElement> dates2 = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_nodes2 = dates2.size();
		for (int i = 0; i < total_nodes2; i++)
		
		{
		String date1 = dates2.get(i).getText();
	
		int abc=Integer.valueOf(WishDayTwo);
		
		if (date1.equals(Integer.toString(abc)))
		
		{
		dates2.get(i).click();
		logger.info("Selected date for wishes two is: " + date1);
		break;
		}
		
		}
		
		Waitfor(2);
		OccasionTwo.sendKeys(OccasionnTwo);
		Waitfor(2);
		MessageTwo.sendKeys(MessageeTwo);
		Waitfor(2);
		
	}
	
	
	  
	public void checkWishesHomePage()
	{
		HomePage.click();
		
		Boolean status=WishesDisplay.isDisplayed();
		if(status==true) 
		{
			
			String str=WishesDisplay.getText();
			logger.info("Festival Wishes is Displayed In Home Page wishes is:"+str);
			
			
		}
		else 
		{
			logger.info("The Festival wishes is Not displayed For this Date....!!!");
			
		}
		
		
		
		
	}
	
}
