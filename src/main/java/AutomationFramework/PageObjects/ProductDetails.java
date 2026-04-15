package AutomationFramework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails extends AbstractComponents {
	WebDriver driver;

	public ProductDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".productinfo.text-center")
	List<WebElement> products;
	
	By cartButton=By.cssSelector(".btn.btn-default.add-to-cart");
	
	@FindBy(xpath="//u[text()='View Cart']")
	WebElement viewCart;
			

	public List<WebElement> getProductList() {
		return products;
	}
	
	public WebElement getProductByName(String ProductName )
	{
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("p")).getText().equals(ProductName)).findFirst()
				.orElseThrow(null);
		return prod;
	}
	
	
	public void AddToCart(String ProductName)
	{
		WebElement prod=getProductByName(ProductName);
		prod.findElement(cartButton).click();
		
	}
	public void ViewTheCart()
	{
		VisibilityofELements(viewCart);
		viewCart.click();
		
	}
	
	
	
	

}
