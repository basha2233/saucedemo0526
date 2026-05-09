package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.baseTest;




public class Utils extends baseTest
{
	
	public boolean Explicity_Wait(WebElement element)
	{
		 WebDriverWait wait= new WebDriverWait(baseTest.driver,Duration.ofSeconds(40));
		if(wait.until(ExpectedConditions.elementToBeClickable(element)) != null)
		 return true;
		else
			return false;
	}
	
	public String takeScreenshot(String fileName)
	{
	    TakesScreenshot ts =
	            (TakesScreenshot) driver;

	    File source =
	            ts.getScreenshotAs(OutputType.FILE);

	    String destinationPath =
	            System.getProperty("user.dir")
	            + "/screenshots/"
	            + fileName
	            + ".png";

	    File destination =
	            new File(destinationPath);

	    try
	    {
	        FileUtils.copyFile(source, destination);

	        System.out.println(
	                "Screenshot saved: "
	                + destination.getAbsolutePath());
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }

	    return destinationPath;
	}

}
