package AutomationFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation extends AbstractComponents {
	WebDriver driver;

	public OrderConfirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//p[text()='Congratulations! Your order has been confirmed!']")
	WebElement OrderconfirmText;
	
	@FindBy(xpath="//a[text()='Download Invoice']")
	WebElement Invoice;
	
	public String OrderConfirmed()
	{
		return OrderconfirmText.getText();
	}
	
	public void DownloadBill()
	{
		Invoice.click();
	}
}
