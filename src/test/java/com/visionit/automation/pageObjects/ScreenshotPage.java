package com.visionit.automation.pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotPage {
	
	public static void Screenshotcap(WebDriver driver,String ScreenshotFileName) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(
					
					System.getProperty("user.dir")+"\\src\\test\\java\\com\\visionit\\automation\\pageObjects\\ScreenshotFolder\\"+ScreenshotFileName+System.currentTimeMillis()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
