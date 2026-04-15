package AutomationFramework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedConfirmation extends AbstractComponents {
	WebDriver driver;
	public AccountCreatedConfirmation(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(tagName="b")
	WebElement ConfirmationText;
	
	
	By ToContinue=By.xpath("//a[text()='Continue']");
	
	public String ConfirmText()
	{
		return ConfirmationText.getText();
	}
	
	public void ToContinue()
	{
		ElemetToBeClick(ToContinue);
		 driver.findElement(ToContinue).click();
		
	}

}
