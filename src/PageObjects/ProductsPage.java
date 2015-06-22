package PageObjects;
/*
 * This is a ProductsPage In which Methods are Defined Related to Products Page 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends ShopPage {
	
	public static boolean value1,value2,value3;
	public static String Product_Added;

	public ProductsPage(WebDriver driver)
	{
		super(driver);
	}
	
	By SELECT_SIZE=By.partialLinkText("12");
	By ADD_TO_CART=By.xpath("//button[@class='btn btn_addtobasket btn_addtobasket_add']");
	By CHECKOUT=By.xpath("//a[@id='anchor-btn-checkout']");
	By ADD_TO_CART_OVERLAY=By.xpath("//div[@id='racOverlay']");	

	public void ADD_CART()
	{
		driver.findElement(SELECT_SIZE).click();											// Size of the Product is Selected
		value1=driver.findElement(ADD_TO_CART).isDisplayed();				// Boolean Value of ADD To Cart Button is Displayed or not is Stored
		driver.findElement(ADD_TO_CART).click();										// Selected Product is Added to Cart
		WebElement Element1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='racOverlay']")));
		value2=driver.findElement(ADD_TO_CART_OVERLAY).isDisplayed();			//Boolean Value of ADD To Cart Overlay is Displayed or not is Stored
		value3=driver.findElement(CHECKOUT).isDisplayed();							//Boolean Value of Checkout Button is Displayed or not is Stored
		driver.findElement(CHECKOUT).click();														// Product Added to Cart is CheckedOut
	}

}
	