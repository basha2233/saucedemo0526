package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v128.browser.Browser;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class baseTest
{
	
public static WebDriver driver;
public void loadbrowser ()
{
	try {
	System.setProperty("webdriver.chrome.driver", ".//src//main//chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
    // Disable password manager and breach detection
    Map<String, Object> prefs = new HashMap<String, Object>();
    prefs.put("credentials_enable_service", false);
    prefs.put("profile.password_manager_enabled", false);
    prefs.put("profile.password_manager_leak_detection", false);
    options.setExperimentalOption("prefs", prefs);
    driver = new ChromeDriver(options);

    
	//driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	}
	catch(Exception e)
	{
		System.out.println(e);
		
	}
	
}


public void closedriver()
{
	//Browser.close();
	//driver.close();
}

}
