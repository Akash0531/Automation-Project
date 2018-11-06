package com.dikshatech.tst.pageFatory;

import java.io.File;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.utilitylibrary.ScreenshotCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static final Logger logger = Logger.getLogger(TestBase.class);
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest exlogger;

	public WebDriver launchbrowser(String browsername) {
		if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ConfigDataProvider.getFirefoxPath());

			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("chrome")) {
			if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") > -1)
				System.setProperty("webdriver.chrome.driver", ConfigDataProvider.getwindowChromePath());
			else {
				System.setProperty("webdriver.chrome.driver", ConfigDataProvider.getlinuxChromePath());
			}
			driver = new ChromeDriver();
		}

		else if (browsername.equalsIgnoreCase("IEpath")) {
			System.setProperty("webdriver.ie.driver", ConfigDataProvider.getIEPath());
			driver = new InternetExplorerDriver();
		} else {
			logger.info("There is no other browser properties set apart from Chrome, Mozilla & Internet Explorer");
		}
		driver.get(ConfigDataProvider.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	@BeforeTest
	public void browserLauncher() {
		report = new ExtentReports(ConfigDataProvider.getProp().getProperty("loggerpath"), true);
		report.addSystemInfo("Host Name", "Lynx").addSystemInfo("Environment", "Automation_Testing")
				.addSystemInfo("User Name", System.getProperty("user.name"));
		exlogger = report.startTest("Diksha_Lynx Validation Report");
		driver = launchbrowser(ConfigDataProvider.getBroswer());
		cookiesdelete();
	}

	@AfterMethod(description = "Capturing the snapshot whenever any Testcase failed with some info")
	public void faliure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.info("Test Case Failed and name of the test case is: " + result.getName());
			String Screenshot_Path = ScreenshotCapture.GetScreenshot(driver, result.getName());

			String Image = exlogger.addScreenCapture(Screenshot_Path);
			exlogger.log(LogStatus.FAIL, result.getName() + " verification is failed.", Image);
		}
	}

	@AfterSuite
	public void extentreport() {
		report.endTest(exlogger);
		report.flush();
		report.close();
		driver.get("file://" + new File(ConfigDataProvider.getProp().getProperty("loggerpath")).getAbsolutePath());
		Waitfor(3);
		quitBrowser();
		logger.info("Broswer is Closed Successfully.....!!!");
	}

	public void Waitfor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (Exception e) {

			logger.info(e.getMessage());
		}
	}

	public void navigateBack() {
		Waitfor(2);
		driver.navigate().back();
		Waitfor(2);
	}

	public void refreshPage() {
		Waitfor(2);
		driver.navigate().refresh();
		Waitfor(3);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		String title = driver.getTitle();
		logger.info(title);
		return title;
	}

	public void getwindowsize(int X_axis, int Y_axis) {
		Dimension dm = new Dimension(X_axis, Y_axis);
		driver.manage().window().setSize(dm);

	}

	public void getactWindowSize() {
		driver.manage().window().getSize();
	}

	public void cookiesdelete() {
		driver.manage().deleteAllCookies();
	}

	public void navigateforward() {
		driver.navigate().forward();
	}

	public void explicitWait(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
	}

	public float floatconversion(String s) {
		String s1 = s;
		return Float.parseFloat(s1);
		 
	}

	public void lynxlogin() {
		driver.get(ConfigDataProvider.getProp().getProperty("url"));
		Waitfor(2);
	}

	// @AfterClass
	public void quitBrowser() {
		driver.quit();
	}

	public ExcelReadData excelreaddata() {
		return new ExcelReadData(ConfigDataProvider.getProp().getProperty("excelname"));
	}

	public SoftAssert softassert() {
		return new SoftAssert();
	}
}
