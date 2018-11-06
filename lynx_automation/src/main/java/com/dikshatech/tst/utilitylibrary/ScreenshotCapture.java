
package com.dikshatech.tst.utilitylibrary;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;

public class ScreenshotCapture {

	public static String GetScreenshot(WebDriver driver, String screenshot) {
		try {
			TakesScreenshot scn = (TakesScreenshot) driver;
			File source = scn.getScreenshotAs(OutputType.FILE);
			File dir = new File(ConfigDataProvider.get("errorScreenshots"));
			if (!dir.exists())
				dir.mkdirs();
			String dest = screenshot + ".png";
			File destination = new File(dir, dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot has been captured");
			return dest;
		} catch (Exception e) {
			System.out.println("The Exception occured while taking screenshot is" + e.getMessage());
			return e.getMessage();
		}

	}
}