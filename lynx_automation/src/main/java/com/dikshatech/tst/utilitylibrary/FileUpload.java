package com.dikshatech.tst.utilitylibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;

public class FileUpload extends TestBase{

	
	Robot robot;
	
	@Test
	public void fileupload()
	{
		 
		try {
			robot = new Robot();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 Waitfor(2);
//		
//		robot.keyPress(KeyEvent.VK_SHIFT);
//		robot.keyPress(KeyEvent.VK_TAB);
//		
//		robot.keyPress(KeyEvent.VK_SHIFT);
//		robot.keyPress(KeyEvent.VK_TAB);
//		
//		robot.keyPress(KeyEvent.VK_SHIFT);
//		robot.keyPress(KeyEvent.VK_TAB);
		
		 
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		
		 Waitfor(2);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public WebDriver driver;
//	
//	@Test
//	
//	{
//		public void UploadFileUsingJacobDll()
//				throws InterruptedException {
//
//			String workingDir = System.getProperty("user.dir");
//
//			final String jacobdllarch = System.getProperty("sun.arch.data.model")
//					.contains("32") ? "jacob-1.18-x86.dll" : "jacob-1.18-x64.dll";
//			String jacobdllpath = workingDir + "\\" + jacobdllarch;
//
//			File filejacob = new File(jacobdllpath);
//			System.setProperty(LibraryLoader.JACOB_DLL_PATH,
//					filejacob.getAbsolutePath());
//			AutoItX uploadWindow = new AutoItX();
//
//			driver = new ChromeDriver();
//			String filepath = workingDir + "\\SeleniumWebdriverUploadFile.html";
//			driver.get(filepath);
//
//			Thread.sleep(1000);
//
//			driver.findElement(By.id("uploadfile")).click();
//
//			Thread.sleep(1000);
//
//			if (uploadWindow.winWaitActive("File Upload", "", 5)) {
//				if (uploadWindow.winExists("File Upload")) {
//					uploadWindow.sleep(100);
//					uploadWindow.send(filepath);
//					uploadWindow.controlClick("File Upload", "", "&Open");
//
//				}
//			}
//		}
//	}
//
//}
//
//import java.awt.datatransfer.StringSelection;
//import java.awt.event.KeyEvent;
//import java.awt.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Test;
//
//public class FileUpload {
// 
//@Test
//public void Fileupload() throws AWTException, InterruptedException{
// 
//
//// Start browser
// WebDriver driver = new FirefoxDriver();
//
//// maximize browser
// driver.manage().window().maximize();
//        
//  // Specify the file location with extension
// StringSelection sel = new StringSelection("C:\\Users\\Desktop\\1.doc");
//
//   // Copy to clipboard
// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
// System.out.println("selection" +sel);
// 
//
//// Open Monster.com
// driver.get("http://my.monsterindia.com/create_account.html");
// Thread.sleep(2000);
//
// // This will scroll down the page 
// JavascriptExecutor js = (JavascriptExecutor)driver;
// js.executeScript("scroll(0,350)");
//
//// Wait for 5 seconds
// Thread.sleep(5000);
//
//// This will click on Browse button
// driver.findElement(By.id("wordresume")).click();
//
//
//
// System.out.println("Browse button clicked");
//
// // Create object of Robot class
// Robot robot = new Robot();
// Thread.sleep(1000);
//      
//  // Press Enter
// robot.keyPress(KeyEvent.VK_ENTER);
//
//// Release Enter
// robot.keyRelease(KeyEvent.VK_ENTER);
//
//  // Press CTRL+V
// robot.keyPress(KeyEvent.VK_CONTROL);
// robot.keyPress(KeyEvent.VK_V);
//
//// Release CTRL+V
// robot.keyRelease(KeyEvent.VK_CONTROL);
// robot.keyRelease(KeyEvent.VK_V);
// Thread.sleep(1000);
//        
//         Press Enter 
// robot.keyPress(KeyEvent.VK_ENTER);
// robot.keyRelease(KeyEvent.VK_ENTER);
//
//}
//
//}
//
//
	
}	
