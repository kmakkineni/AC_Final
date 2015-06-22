package TestCases;
/*
 * TestCases Realted to Feature "See a Product on Quick Look Overlay" Written End to End.
 * Written in Java Executed Using testNG
 */
import java.util.concurrent.TimeUnit;
import PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.ShopPage;

/*
 * Test Scenario
 * 1.Go to HomePage
 * 2.Enter "Fry Pan" on Search Box
 * 3.Click on Search Button for Products to Display
 * 4.Store the Text of Product Selected
 * 5.Store the Price of Product Selected
 * 6.Compare the Text of Product to Expected Product, Matches click on Quicklook of the Product
 * 7.Store the text of Product on Overlay
 * 8.Store the Price of Product on Overlay
 * 9.Comparing the Values of Text's & Prices of the ShopPage & Product Overlay Page Using Assertions.
 */

public class QuickLookOverlay {

	@Test
	public void homePage()
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://secure.williams-sonoma.com/");
		
		ShopPage object=new ShopPage(driver);
		
		object.Home_Search();			// Method to give Input in Search Box & Search
		
		WebElement Element1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Calphalon Elite Nonstick Fry Pan Set")));
		
		 object.Select_Product2();		// Method to to Store & Compare values of Product on Display & Overlay
		
		Assert.assertEquals(ShopPage.Text_2,ShopPage.Text_1);		// Returns true When ShopPage Text of Product matches with Product Overlay Page Text
		
		Assert.assertEquals(ShopPage.Price_2,ShopPage.Price_1);	// Returns true When ShopPage Price of Product matches with Product Overlay Page Price
		
		driver.close();
	
	}
}

