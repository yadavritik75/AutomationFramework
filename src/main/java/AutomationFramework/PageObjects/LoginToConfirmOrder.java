package AutomationFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToConfirmOrder extends AbstractComponents {
	public LoginToConfirmOrder(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//input[contains(@placeholder,'Email Address')])[1]")
	WebElement EnterEmail;
	
	@FindBy(xpath="//input[contains(@data-qa,'login-p')]")
	WebElement EnterPassword;
	
	@FindBy(xpath="//button[contains(@data-qa,'login-b')]")
	WebElement Login;
	
	@FindBy(xpath = "//*[starts-with(text(),'Your email')]")
	WebElement errorMessage;

	
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}
	
	public void LoginToConfirm(String email,String password)
	{
		VisibilityofELements(EnterEmail);
		EnterEmail.sendKeys(email);
		EnterPassword.sendKeys(password);
		Login.click();
		
	}
	
	
}
