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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Bookofawardsobjects extends TestBase {

	@Test
	public Bookofawardsobjects(WebDriver driver) 
	{
		this.driver = driver;
				
	}
	
	@FindBy(xpath="//a[contains(.,'My References')]")              WebElement my_reference;
	@FindBy(xpath="//span[contains(.,'Book of Awards')]")          WebElement book_of_awards;
	@FindBy(xpath="//a[contains(.,'AntaresAward')]")               WebElement AntaresAward;
	@FindBy(xpath="//a[@href='#Antares_Award']")                   WebElement AntaresAward_winners;
	@FindBy(xpath="//a[@href='#banglore_awards']")                 WebElement bangalore_awards;
	@FindBy(xpath="//a[@href='#gurgaon_awards']")                  WebElement gurgon_awards;
	

}

