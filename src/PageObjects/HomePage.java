package PageObjects;

/*
 * HomePage Written in Java Lang
 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		driver.manage().window().maximize();
	}

	By FlyoutMenu_Home = By.className("topnav-cookware");
	By Shop_by_Category = By.linkText("Cookware Sets");
	By SEARCH = By.id("search-field");
	By SEARCH_BUTTON = By.id("btnSearch");

	public void Home()				
	{
		 driver.findElement(FlyoutMenu_Home).click();					// HomePage Flyout Menu is Clicked
		 WebElement Element1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Cookware Sets")));
		 driver.findElement(Shop_by_Category).click();						// "Cookware Sets" is Selected from Shop by Category Menu
	}
	
	public void Home_Search()
	{
		driver.findElement(SEARCH).sendKeys("fry pan"); 						// "fry pan" is given as input in Search Box 
		driver.findElement(SEARCH_BUTTON).click();								//  Search Button is Clicked.
	}
		
}