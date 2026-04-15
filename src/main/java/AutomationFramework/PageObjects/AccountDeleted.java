package AutomationFramework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountDeleted extends AbstractComponents {
	WebDriver driver;

	public AccountDeleted(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//b[text()='Account Deleted!']")
	WebElement DeleteAccText;
	
	By ContinueTo=By.xpath("//a[text()='Continue']");
	
	public String DconfirmText()
	{
		return DeleteAccText.getText();
	}
	
	public void AfterDeleteContinue()
	{
		ElemetToBeClick(ContinueTo);
		driver.findElement(ContinueTo).click();
		jscriptExecutors();
	}
}
