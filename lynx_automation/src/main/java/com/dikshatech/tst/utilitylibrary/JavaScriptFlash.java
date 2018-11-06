package com.dikshatech.tst.utilitylibrary;


import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//@RunWith(Cucumber.class)

public class JavaScriptFlash {
	public void highlight(WebElement element, WebDriver driver) {
		String bgcolour = element.getCssValue("backgroundColor");
		for (int i = 0; i < 5; i++) {
			changecolor("rgb(0, 455, 0)", element, driver);
			changecolor(bgcolour, element, driver);
		}
	}
	/*To change the element default bckg color to identify the control during runtime*/
	public void changecolor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
	}
	
	/*To highlight the bugs in the active page during runtime by marking the partivular element*/
	public void bugsHighlighter(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", ele);
	}
	
	/*To generate an Alert message whenever any element or function doesn't work
*/	public void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
}