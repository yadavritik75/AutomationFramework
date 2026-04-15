package AutomationFramework.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()=\" Signup / Login\"]")
	WebElement Signin;

	@FindBy(xpath = "//input[starts-with(@name,'name')]")
	WebElement inputField;

	@FindBy(xpath = "(//input[starts-with(@name,'email')])[2]")
	WebElement EmailField;

	public String getValidationMessage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return arguments[0].validationMessage;", EmailField);
	}

	@FindBy(xpath = "//button[starts-with(@data-qa,'signup')]")
	WebElement SigninButton;
	
	public void clickToSignINIcon()
	{
		Signin.click();
	}

	public void SignIn(String name, String Email) {
		VisibilityofELements(inputField);
		inputField.sendKeys(name); // Ritik
		EmailField.sendKeys(Email); // yadav75@gmail.com
		SigninButton.click();

	}

	public void goTo() {
		driver.get("https://automationexercise.com");
	}

}
