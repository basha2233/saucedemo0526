package pageRepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.baseTest;
import dev.failsafe.internal.util.Assert;
import utils.Utils;

public class HomePage extends baseTest

{
	@FindBy(xpath = "//input[@id=\'user-name\']")
	public WebElement username;
	
	@FindBy(xpath = "//input[@id=\'password\']")
	public WebElement password;
	
	@FindBy(xpath = "//input[@id=\'login-button\']")
	public WebElement loginbtn;
	
	
	
	public HomePage() {
		PageFactory.initElements(baseTest.driver, this);
	}
	
	
	public void Verify_Title()
	{
		System.out.println(driver.getTitle());
		
	}
	
	
		/*
		 * public void Verify_Login() { try { username.sendKeys("standard_user");
		 * password.sendKeys("secret_sauce"); loginbtn.click(); } catch (Exception e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * }
		 */
	
	
}
