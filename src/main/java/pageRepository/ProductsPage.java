package pageRepository;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.baseTest;
import utils.Utils;


public class ProductsPage extends baseTest
{
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	public WebElement backpack_addtocart;
	
	public ProductsPage()
	{
		PageFactory.initElements(baseTest.driver, this);
		
	}
	
	public void Product_Addtocart() 
	{
		try {
			System.out.println("CLICK BEFORE");
			//driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
			Utils util = new Utils();
			util.Explicity_Wait(backpack_addtocart);	
			System.out.println(util.Explicity_Wait(backpack_addtocart));
			backpack_addtocart.click();
			System.out.println("CLICK after");
			 // Take Screenshot After Click
            util.takeScreenshot("Backpack_Added");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
