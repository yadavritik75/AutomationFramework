package AutomationFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardDetails extends AbstractComponents {
	public CardDetails(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='name_on_card']")
	WebElement NameOnCard;
	
	@FindBy(xpath="//input[@name='card_number']")
	WebElement cardNo;
	
	@FindBy(xpath="//input[@name='cvc']")
	WebElement cvv;
	
	@FindBy(xpath="//input[@name='expiry_month']")
	WebElement ExpMonth;
	
	@FindBy(xpath="//input[@name='expiry_year']")
	WebElement ExpYear;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement submit;
	
	public void EnterCardDetails(String name,String cardNumber,String CardCv,String EMonth,String EYear) throws InterruptedException 
	{
		jscriptExecutors();
		VisibilityofELements(NameOnCard);
		NameOnCard.sendKeys(name);
		cardNo.sendKeys(cardNumber);
		cvv.sendKeys(CardCv);
		ExpMonth.sendKeys(EMonth);
		ExpYear.sendKeys(EYear);
		jscriptExecutors();
		Thread.sleep(2000);
		scrollIntoView(submit);
		submit.click();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
