package AutomationFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register extends AbstractComponents {
	public Register(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="(//div[@class='radio'])[1]")
	WebElement Category;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement Passcode;
	
	@FindBy(id="days")
	WebElement DaysDropdown;
	
	@FindBy(id="months")
	WebElement MonthDropDown;
	
	@FindBy(id="years")
	WebElement YearDropDown;
	
	@FindBy(id="newsletter")
	WebElement news;
	
	@FindBy(id="first_name")
	WebElement fName;
	
	@FindBy(id="last_name")
	WebElement lName;
	
	@FindBy(id="company")
	WebElement CompanyField;
	
	@FindBy(id="address1")
	WebElement Address;
	
	@FindBy(id="country")
	WebElement SelectCountry;
	
	@FindBy(id="state")
	WebElement SelectState;
	
	@FindBy(id="city")
	WebElement SelectCity;
	
	@FindBy(id="zipcode")
	WebElement ZipCode;
	
	@FindBy(id="mobile_number")
	WebElement Mobile;
	
	@FindBy(xpath="//button[text()='Create Account']")
	WebElement CreateAccountButton;
	
	
	public void selectCategory()
	{
		Category.click();
	}
	
	public void passkey(String passcode)
	{
		Passcode.sendKeys(passcode);
		jscriptExecutors();
	}
	
	
	public void selectDays(String Value)
	{
		Select day = new Select(DaysDropdown);
		day.selectByValue(Value);
	}
	
	public void selectMonths(String monthname)
	{
		Select month = new Select(MonthDropDown);
		month.selectByVisibleText(monthname);
	}
	
	public void selectYears(String yearvalue)
	{
		Select year = new Select(YearDropDown);
		year.selectByVisibleText(yearvalue);
	}
	
	public void News()
	{
		news.click();
	}
	
	public void FillDetails(String Fname,String Lname,String Cname,String Addrs)
	{
		
		fName.sendKeys(Fname);
		lName.sendKeys(Lname);
		CompanyField.sendKeys(Cname);
		Address.sendKeys(Addrs);
		jscriptExecutors();
		
	}
	public void selectCountry(int cname)
	{
		Select country = new Select(SelectCountry);
		country.selectByIndex(cname);
	}
	
	public void HomeTown(String state,String city,String Zip,String MNo)
	{
		SelectState.sendKeys(state);
		SelectCity.sendKeys(city);
		ZipCode.sendKeys(Zip);
		Mobile.sendKeys(MNo);
		CreateAccountButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
