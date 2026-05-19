package Testcases;

import org.testng.annotations.Test;

import base.baseTest;
import pageRepository.ProductsPage;

public class ProductspageTest extends baseTest
{

	public ProductsPage Prpage;        
	
	@Test(priority = 3)
	public void cart()
	{
		try {
			System.out.println("before addcarts");
			Prpage= new ProductsPage();
		Prpage.Product_Addtocart();
		System.out.println("after addcarts");
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("CONFLICT TEST FOR GIT");
		}

	}
}
