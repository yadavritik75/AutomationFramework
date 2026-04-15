package AutomationFramework.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponents {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//tbody//td[2]//a")
	List<WebElement> CartProducts;
	
	@FindBy(xpath="//*[starts-with(@class,'btn btn-default ')]")
	WebElement checkout;
	
	
	@FindBy(xpath="//a[contains(@class,'btn btn-default check_out')]")
	WebElement PlaceOrder;
	
	public boolean showCart(String ProductName)
	{
		boolean match = CartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}

	public void ProceedToChecout()
	{
		checkout.click();
	}
	
	public void OrderToPlace()
	{
		VisibilityofELements(PlaceOrder);
		PlaceOrder.click();
	}
}
