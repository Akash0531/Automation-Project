package com.dikshatech.tst.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class LoginPageObjects extends TestBase {
	
	@Test
	public LoginPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
   
	@FindBy(xpath="//h1[@class='text-center login-title']") 		WebElement SignIn_Icon;
	@FindBy(xpath="//img[@alt='LYNX | Diksha']")					WebElement Diksha_Logo;
	@FindBy(xpath="//input[@id='uname']")							WebElement Username_Input;
	@FindBy(xpath="//input[@id='pass']") 							WebElement Password_Input;
	@FindBy(xpath="//input[@id='rememberMe']") 						WebElement Remember_Me;
	@FindBy(xpath="//button[text()='Login']") 					    WebElement SignIn_Button;
	@FindBy(xpath="//button[@onclick='forgotPassPopupFn()']") 		WebElement Forgot_Password;
	@FindBy(xpath="//h4[@id='myModalLabel']") 						WebElement ForgotPassword_WindowHeading;
	@FindBy(xpath="//input[@id='verEmail']") 						WebElement Password_ResetBox;
	@FindBy(xpath="//button[@class='close']") 						WebElement Window_Close;
	@FindBy(xpath="//button[@id='btnReset']") 						WebElement Reset_Button;
	@FindBy(xpath="//div[@class='modal-body']/div/p/b") 			WebElement Note_Msg;
	@FindBy(xpath="//span[@id='dynamic_username']") 				WebElement Account_Info;
	@FindBy(xpath="//a[@href='javascript:logout();']") 				WebElement Logout; 	
	
	
	public void diksha_logo()
	{
		WebElement image = driver.findElement(By.xpath("//h1[@class='text-center login-title']"));
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
	public void signIn(String username, String password) 
	{
		Username_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),username);
		Waitfor(1);
		Password_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),password);
		Waitfor(1);
		SignIn_Button.click();
		Waitfor(2);
		logger.info("Login is Successfull....!!!!");
	} 
	public void input_text()
	{
		
	}
	public void remember_Me()
	{
	 boolean enable=	Remember_Me.isSelected();
	 if(enable==false)
	 {
		 Remember_Me.click();
	 }
	 else
	 {
		 logger.info("Remember Me checkbox is already enable");
	 }
	} 
	public void Forgot_Password_Button()
	{
		Forgot_Password.click();	
	}		
	public void Reset_mail_id(String Email_Id)
	{
      
      Password_ResetBox.sendKeys(Keys.chord(Keys.CONTROL, "a"),Email_Id);
    }
	public boolean Green_Icon()
	{
		return driver.findElement(By.xpath("//i[@style='display: block;']")).isDisplayed();
		
	}
	public String Error_Message()
	{
		String msg= driver.findElement(By.xpath("//small[@style='display: block;']")).getAttribute("innerText");
		logger.info(msg);
		return msg;
	}
	public void Close_Reset_Window()
	{
		Window_Close.click();
	}
	public void Reset_Password_Button()
	{
		Reset_Button.click();
	}
	public String SignIn_Button_Color()
	{
		
		String color = SignIn_Button.getCssValue("color");
	   
		logger.info(color);
		return color;
	}
	public boolean Login_Page()
	{
	    boolean SignIN_Icon= driver.findElement(By.xpath("//h1[@class='text-center login-title']")).isDisplayed();
		return SignIN_Icon;

	}
	public boolean Home_Page()
	{
	    boolean Home_Button= driver.findElement(By.xpath("//ul[@id='side-menu']/li[1]/a")).isDisplayed();

		return Home_Button;
		
	}
    public void Log_Out()
    {
      Actions action= new Actions(driver);
      action.moveToElement(Account_Info).click().build().perform();
      Waitfor(1);
      action.moveToElement(Logout).click().build().perform();	
    }
    public void SignIn_Button() 
    {
    	SignIn_Button.click();
    }
    
	
}