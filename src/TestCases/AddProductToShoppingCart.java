package TestCases;

/*
 * TestCases Realted to Feature "Add a product to cart" Written End to End.
 * Written in Java Executed Using testNG
 */

import java.util.concurrent.TimeUnit;

import PageObjects.*;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.ShoppingCartPage;


/*Test Scenario
 * 1.Go to Homepage select Cookware Menu
 * 2.select Cookware Sets from SubCategory menu 
 * 3.go to newarrivals of ShopPage
 * 4.Select a Product on ShopPage
 * 5.go to Products page of the Selected Product
 * 6.Select the size of Product
 * 7.Add to Cart
 * 8.Checkout
 * 9.Diverted to ShoppingCart Page & Close.
 * 
 */

public class AddProductToShoppingCart {
	

	@Test
	public void homePage()
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://secure.williams-sonoma.com/");	//URL of the WebSite
		
		ShoppingCartPage object = new ShoppingCartPage(driver);
		
		object.Home();					// Method to Select FlyOut Menu by Sub Category
		
		WebElement Element1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("New Arrivals")));
		
		 object.Shop();				  // Method to choose a Product from New Arrivals
		 
		object.ADD_CART();	  // Method to Add the Product to Cart & CheckedOut
		
		Assert.assertTrue(ProductsPage.value1);						// Assures On Product Page "Add To Cart Button" is Shown
		
		Assert.assertTrue(ProductsPage.value2);						// Assures When Clicked on Add To Cart button "Add To Cart Overlay Popup"  Appears
		
		Assert.assertTrue(ProductsPage.value3);						// Assures Checkout Button is  on "Add To Cart Overlay Popup"

		 ShoppingCartPage.Page_Title=driver.getTitle();			// Title of the ShoppingCart Page is Stored
		
		Assert.assertEquals("Shopping Cart | Williams-Sonoma",ShoppingCartPage.Page_Title);	//Assures after clicking on Checkout Shopping Cart Page is shown
		
		object.ShoppingCart_Product();										// Method to Storethe Value of Item Added on Shopping Cart Page
		
		Assert.assertEquals("Item #: 78-8018280", ShoppingCartPage.Product_Added); //Assures Product added to Cart & Product on Shopping Cart page are same"
		
		driver.close();								//Browser Closed.
		
	}

}
