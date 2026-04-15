package AutomationFramework.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()=' Delete Account']")
	WebElement DeleteAccButton;
	
	@FindBy(xpath="//u[text()='Register / Login']")
	WebElement ToRegister;
	
	@FindBy(xpath="//a[text()=' Cart']")
	WebElement cartIcon;
	
	public void jscriptExecutors()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
	}
	
	public void scrollIntoView(WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	
	public void ElemetToBeClick(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
		
	}
	
	
	public void VisibilityofELements(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void DeleteAccount()
	{
		VisibilityofELements(DeleteAccButton);
		DeleteAccButton.click();
	}
	
	
	public void RegisterAccount()
	{
		VisibilityofELements(ToRegister);
		ToRegister.click();
	}
	
	
	
	
	public void carticon()
	{
		VisibilityofELements(cartIcon);
		cartIcon.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
