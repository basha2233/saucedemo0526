package Testcases;

import static org.testng.Assert.fail;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import base.baseTest;
import pageRepository.HomePage;
import utils.Utils;

public class HomepageTest extends baseTest {

	public HomePage page;
	Assertion assertion1 = new Assertion();
	Utils util = new Utils();

	@BeforeClass
	public void loadBrowser() {
		loadbrowser();
	}

	@Test(priority = 1)
	public void Title() {
		page = new HomePage();
		page.Verify_Title();
		assertion1.fail();
	}
	
	/*
	 * @Test(priority = 2) public void login() {
	 * 
	 * page.Verify_Login(); System.out.println("login test");
	 * //System.out.println("login test"); //System.out.println("login test");
	 * //System.out.println("login test"); //System.out.println("login test"); }
	 */

	
	@DataProvider(name = "loginData")
    public Object[][] getData() {

        String path = "N:\\Testing\\Selenium\\RestAssured-practise_2022\\SAUCEDEMONOV\\src\\main\\LoginData.xlsx";

        return util.getLoginData(path, "Sheet1");
    }
	 @Test(priority = 2,dataProvider = "loginData")
	    public void Verify_Login(String user, String pass) {

	        try {

	            page.username.sendKeys(user);

	            page.password.sendKeys(pass);
	            System.out.println("Login attempted with: "
	                    + user + " / " + pass);

	            page.loginbtn.click();
	            driver.navigate().to("https://www.saucedemo.com/");

	            

	        } catch (Exception e) {

	            e.printStackTrace();
	        }
	    }
	@AfterClass
	public void quitdriver() {
		closedriver();
	}

}
