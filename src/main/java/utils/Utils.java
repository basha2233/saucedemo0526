package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	
	 public static Object[][] getLoginData(String filePath, String sheetName) {

	        Object[][] data = null;

	        try {
	            FileInputStream fis = new FileInputStream(filePath);

	            Workbook workbook = new XSSFWorkbook(fis);
	            Sheet sheet = workbook.getSheet(sheetName);

	            int rowCount = sheet.getPhysicalNumberOfRows();
	            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	            data = new Object[rowCount - 1][colCount];

	            for (int i = 1; i < rowCount; i++) {

	                Row row = sheet.getRow(i);

	                for (int j = 0; j < colCount; j++) {

	                    Cell cell = row.getCell(j);

	                    data[i - 1][j] = cell.toString();
	                }
	            }

	            workbook.close();
	            fis.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return data;
	    }

}
