package com.dikshatech.tst.utilitylibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scrolling {
    
	
    WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public Scrolling(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  void Scroll_Up()
	{
		 
		js.executeScript("window.scrollBy(0,-600)");
	}
	
	public  void Scroll_down()
	{
		js.executeScript("scroll(0,600)");
	}
	
	public  void Scrollintoview(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public  void Window_Location(String url)
	{
		js.executeScript("window.location = 'url'");		
	}
	public  void scrollingToBottomofAPage() {
         js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}