package Testcases;

import static org.testng.Assert.fail;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import base.baseTest;
import pageRepository.HomePage;

public class HomepageTest extends baseTest
{

public HomePage page;
Assertion assertion1 = new Assertion();
	
@BeforeClass
public void loadBrowser()
{
	loadbrowser();
}

@Test(priority = 1)
public void Title()
{
	 page = new HomePage();
	 page.Verify_Title();	 
	 assertion1.fail();
}
@Test(priority = 2)
public void login()
{
	page.Verify_Login();
	System.out.println("login test");
	//System.out.println("login test");
	//System.out.println("login test");
	//System.out.println("login test");
	//System.out.println("login test");
}



@AfterClass
public void quitdriver()
{
	closedriver();
}

}
