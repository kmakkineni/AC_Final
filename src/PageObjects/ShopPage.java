package PageObjects;
/*
 * This is a ShopPage In which Methods are Defined Related to Shopping Page 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage extends HomePage{
	
	public static String Text_1,Price_1,Text_2,Price_2;
	public static boolean result1,result2;

	public ShopPage(WebDriver driver)
	{
		super(driver);
    }
	
	By Shop_Product=By.linkText("New Arrivals");
	By Select_Product1=By.linkText("Finex Cast-Iron Fry Pan with Lid");
	By Select_Product2=By.linkText("Calphalon Elite Nonstick Fry Pan Set");
	By Select_Product2_Price=By.xpath("//span[@class='price-state price-special']");
	By Quicklook=By.xpath("//span[@class='quicklook-link']");
	By Select_Product2overlay_text=By.xpath("//h1[@itemprop='name']");
	By Select_Product2overlay_price=By.xpath(".//*[@id='itemselection']/div/section/section/div/div/div/div[2]/span/span[2]");
	By Quicklook_Overlay=By.xpath(".//*[@id='quicklookOverlay']");
	
	public void Shop() 
	{
		 driver.findElement(Shop_Product).click();						// New Arrival Products are displayed in ShopPage 
		 driver.findElement(Select_Product1).click();					// Product "Finex Cast-Iron Fry Pan with Lid" is Choosen from Displayed List
	}
	
	public void Select_Product2()					
	{
		Text_1=driver.findElement(Select_Product2).getText();						//Stored Text Value of Product Selected
		Price_1=driver.findElement(Select_Product2_Price).getText();		//Stored Price Value of Product Selected
		if(Text_1.equals("Calphalon Elite Nonstick Fry Pan Set"))					//if Text equals Expected Text Enter Loop(Bcoz all products has same Quicklook id)
		{
		result1=driver.findElement(Quicklook).isDisplayed();						//Quick Look Button is displayed on Product's image is Stored
		driver.findElement(Quicklook).click();													//Click on Quickloop for Product Overlay to PopUp
		}
		WebElement Element2 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='quicklookOverlay']")));	
		result2=driver.findElement(Quicklook_Overlay).isDisplayed();					//value of  Product Overlay is Displayed or not is Stored
		Text_2=driver.findElement(Select_Product2overlay_text).getText();			// Stored Text Value of Product on Overlay
		Price_2=driver.findElement(Select_Product2overlay_price).getText();		// Stored Price Value of Product on Overlay
	}
	
}

