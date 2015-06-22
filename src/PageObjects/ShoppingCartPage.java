package PageObjects;
/*
 * This is a ShoppingCartPage In which Methods are Defined Related to ShoppingCart Page 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends ProductsPage{

	public static String Page_Title,Product_Added;
	
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);		
	}
	
	By ShoppingCart_Product=By.xpath("//li[@class='item-number']");
	
	public void ShoppingCart_Product()
	{
		Product_Added=driver.findElement(ShoppingCart_Product).getText(); 			//Text of the Product displayed on ShoppingCart Page is Stored
	}
	
}
