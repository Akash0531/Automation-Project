package com.dikshatech.tst.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;

public class HomePageObjects extends TestBase {

	@Test
	public HomePageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	@FindBy(xpath="//img[@alt='Diksha | LYNX']") 							WebElement Diksha_Logo;
	@FindBy(xpath="//font[@style='color: #ffca99']") 						WebElement AccountHolder_Name;
	@FindBy(xpath="//span[@class='caret']") 								WebElement Arrow_button;
	@FindBy(xpath="//span[@id='dynamic_username']") 						WebElement Account_Info;
	@FindBy(xpath="//a[@id='rightdropdownu']") 								WebElement My_Profile;
	@FindBy(xpath="//a[@id='changepasswordc']") 							WebElement Change_Password;
	@FindBy(xpath="//a[@href='javascript:logout();']") 						WebElement Logout; 
    @FindBy(xpath="//input[@id='oldPassword']") 							WebElement Old_PWDInput;
	@FindBy(xpath="//input[@id='newPassword']") 							WebElement New_PWDInput;
	@FindBy(xpath="//input[@id='confirmPassword']") 						WebElement Confirm_PWDInput;
	@FindBy(xpath="//button[@onclick='saveChengedPassword()']") 			WebElement Update_PWDButton;
	@FindBy(xpath="//div[@id='changePassword']/div/div/div[3]/button[2]")	WebElement Cancel_Password_Button;
	@FindBy(xpath=".//*[@id='passForm']/div[1]/button") 					WebElement Close_Password_Button;
	@FindBy(xpath="//div[@id='changePassword']/div/div/div[1]/button") 		WebElement Date_Info;
	@FindBy(xpath="//span[@id='previous_news']") 							WebElement Previous_Button;
	@FindBy(xpath="//span[@id='next_news']") 								WebElement Next_Button;
	@FindBy(xpath="//h3[text()='Tasks']") 									WebElement Tasks_Section;
	@FindBy(xpath="//h3[text()='Birthdays']") 								WebElement Birthdays_Section;
	@FindBy(xpath="//div[@id='birthday_Data']/div[2]/div/div/p") 			WebElement Birthday_Date;
	@FindBy(xpath="//div[@id='birthday_Data']/div[2]/div/div[2]/button") 	WebElement Wish_Button;
	@FindBy(xpath="//div[@id='birthday_Data']/div[1]/div/h4") 				WebElement Wish_Name;
	@FindBy(xpath="//textarea[@id='wish_comments']") 						WebElement Message_Box;
	@FindBy(xpath="//button[@id='wishforbirthday']") 						WebElement Birthday_Wish_Button;
	@FindBy(xpath="//div[@id='genericModal-buttons']/button[2]") 			WebElement Close_Button;
	@FindBy(xpath="//span[text()='Home']") 									WebElement Home_Module;
	@FindBy(xpath="//ul[@id='side-menu']/li[2]/a") 							WebElement MyTasks_Module;
	@FindBy(xpath="//ul[@id='side-menu']/li[3]/a") 							WebElement Notifications_Module;
	@FindBy(xpath="//span[@id='testnotify']") 								WebElement Notifications_Count;
	@FindBy(xpath="//span[text()='My Lynx']")       						WebElement MYLynx_Module;
	@FindBy(xpath="//span[text()='My Financials']") 						WebElement MyFinancials_Module;
	@FindBy(xpath="//span[text()='My References']") 						WebElement MyReferences_Module;
	@FindBy(xpath="//span[text()='My Projects']") 							WebElement MyProjects_Module;
	@FindBy(xpath="//span[text()='My Requests']") 							WebElement MyRequests_Module;
	@FindBy(xpath="//span[text()='RMG']") 									WebElement RMG_Module;
	@FindBy(xpath="//section[@id='news']/div/h3") 							WebElement News_Font;
	/*
	New Locators
	*/
	@FindBy(xpath="//h4[@id='currentDateTime']") 							WebElement Date;
	@FindBy(xpath="//button[@id='toggle']") 								WebElement Menu_Shifter;

	
	public void diksha_logo()
	{
		WebElement image = Diksha_Logo;
		boolean ImagePresent = (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);
        if (!ImagePresent)
        {
             logger.info("Image not displayed.");
        }
        else
        {
            logger.info("Image displayed.");
	    }
	}
	public String Font_Size()
	{
		String size = News_Font.getCssValue("font-size");
		logger.info("Font Size -> "+size);
		return size;
		
	}
	//Read font-family property and print It In console.
	public String Font_Family()
	{
		String fontFamily = News_Font.getCssValue("font-family");
		logger.info("Font Family -> "+fontFamily);
		return fontFamily;
	}
	//Read text-align property and print It In console.
	public String Text_Allignment()
	{
		
		String fonttxtAlign = News_Font.getCssValue("text-align");
		logger.info("Font Text Alignment -> "+fonttxtAlign);
		return fonttxtAlign;
	}
	public String Account_Holder_Name()
	{
	    String Account_Holder= driver.findElement(By.xpath("//b[@style='color: #fff']")).getAttribute("innerText");
        logger.info("Account Holder name on Home Page "+Account_Holder);
		return Account_Holder;	
	}
	public String Acc_Hldr_Name()
	{
		String name= Account_Info.getAttribute("innerText");
		logger.info("Account Holder name on Account_Info Section "+name);
		return name;
		
	}
	public void Next_Button()
	{
		Next_Button.click();
		Waitfor(2);
	}
	public void Previous_Button()
	{
		Previous_Button.click();
		Waitfor(2);
	}
	public void arrow_dropdown()
	{
		Arrow_button.click();
		Waitfor(2);
	}
	public void My_Profile()
	{
//		Actions action= new Actions(driver);
//		action.moveToElement(Account_Info).click().build();
//        Waitfor(2);
		My_Profile.click();
		Waitfor(2);
		driver.navigate().back();
		Waitfor(2);
//		try {
//			NavigateBack();
//		} catch (Exception e) {
//			logger.info(e.getMessage());
//		}
	}
	public void Change_Password()
	{   
//		Actions action= new Actions(driver);
//		action.moveToElement(Account_Info).click().build();
//        Waitfor(2);
		Change_Password.click();
		Waitfor(2);
		driver.navigate().back();
		Waitfor(2);
		driver.navigate().forward();
		Waitfor(2);
//		try {
//			NavigateBack();
//			Waitfor(1);
//			navigate_forward();
//		} catch (Exception e) {
//			logger.info(e.getMessage());
//		}
	}
	public void Log_Out()
    {
		Actions action= new Actions(driver);
		WebElement acc= driver.findElement(By.xpath("//a[@id='username']"));
		action.moveToElement(acc).click().build().perform();
		Waitfor(2);
		WebElement log= driver.findElement(By.xpath("//a[@href='javascript:logout();']"));
		action.moveToElement(log).click().build().perform();
		logger.info("The LogOut is Succeefull....!!!");
    }
	
	public void My_Lynx()
    {
		MYLynx_Module.click();
    	Waitfor(2);
    }
    public void Date()
    {
    	String date= Date_Info.getAttribute("innerText");
    	logger.info("Today Date is : "+date);
    }
    public void RMG_Tab()
    {
    	WebElement RMG= driver.findElement(By.xpath("//span[contains(.,'RMG')]"));
    	RMG.click();
    	Waitfor(2);
    }
   
    public void My_Financials()
    {
    	MyFinancials_Module.click();
    	Waitfor(2);
    }
    public void My_References()
    {
    	MyReferences_Module.click();
    	Waitfor(2);
    }
    public void My_Projects()
    {
    	MyProjects_Module.click();
    	Waitfor(2);
    }
    public void My_Requests()
    {
    	MyRequests_Module.click();
    	Waitfor(2);
    }
    
    public void RMG()
    {
    	RMG_Module.click();
    	Waitfor(2);
    }
    public void Employees_Tab()
    {
    	
    }
    public boolean Birthdays_Text()
    {
    	boolean msg= Birthdays_Section.isDisplayed();
    	logger.info("Birthdays text is displaying "+msg);
    	return msg;
    }
    public String Birthdays_Date()
    {
    	String text= driver.findElement(By.xpath("//input[@id='home_birthday_wishes_date0']")).getText();
    	logger.info("Birthday date is "+text);
		return text;
    }
    public boolean Birthday_Wish()
    {
    	boolean button= driver.findElement(By.xpath("//*[@id='home_birthday_wish_button-0']")).isDisplayed();
    	if(button==true)
    	{
		return true;
    	}
		else
		{
	    return false;
        }
    }
    
    
}