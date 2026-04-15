package AutomationExercise.AutomationFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StandAlone {
	@Test
	public void RegisterUser() {
		String ProductName = "Blue Top";
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationexercise.com/log");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()=\" Signup / Login\"]")).click();
		driver.findElement(By.xpath("//input[starts-with(@name,'name')]")).sendKeys("Ritik");
		driver.findElement(By.xpath("(//input[starts-with(@name,'email')])[2]")).sendKeys("yadav75@gmail.com");
		driver.findElement(By.xpath("//button[starts-with(@data-qa,'signup')]")).click();
		driver.findElement(By.xpath("(//div[@class='radio'])[1]")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("9899712");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		WebElement days = driver.findElement(By.id("days"));
		WebElement months = driver.findElement(By.id("months"));
		WebElement Year = driver.findElement(By.id("years"));

		Select day = new Select(days);
		day.selectByValue("5"); // Example: 5th day

		Select month = new Select(months);
		month.selectByVisibleText("January"); // Select January

		Select year = new Select(Year);
		year.selectByVisibleText("2019"); // Select 2019

		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("first_name")).sendKeys("Ritik");
		driver.findElement(By.id("last_name")).sendKeys("Yadav");
		driver.findElement(By.id("company")).sendKeys("Source InfoTech Pvt Ltd");
		driver.findElement(By.id("address1")).sendKeys("Sector 67 Noida");
		js.executeScript("window.scrollBy(0,600)");

		WebElement city = driver.findElement(By.id("country"));
		Select country = new Select(city);

		country.selectByIndex(1);

		driver.findElement(By.id("state")).sendKeys("New York");
		driver.findElement(By.id("city")).sendKeys("BrownVille");
		driver.findElement(By.id("zipcode")).sendKeys("12309");
		driver.findElement(By.id("mobile_number")).sendKeys("987654321");
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();

		String ConfirmationText = driver.findElement(By.tagName("b")).getText();
		Assert.assertEquals(ConfirmationText, "ACCOUNT CREATED!");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ContinueButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Continue']")));
		ContinueButton.click();

		WebElement DeleteAccButton = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()=' Delete Account']"))));
		DeleteAccButton.click();

		String DeleteAccText = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
		Assert.assertEquals(DeleteAccText, "ACCOUNT DELETED!");
		WebElement ContinueButton2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Continue']")));
		ContinueButton2.click();

		js.executeScript("window.scrollBy(0,500)");
		List<WebElement> Productlist = driver.findElements(By.cssSelector(".productinfo.text-center"));
		WebElement prod = Productlist.stream()
				.filter(product -> product.findElement(By.cssSelector("p")).getText().equals(ProductName)).findFirst()
				.orElseThrow(null);
		prod.findElement(By.cssSelector(".btn.btn-default.add-to-cart")).click();
		WebElement viewCart = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//u[text()='View Cart']"))));
		viewCart.click();

		List<WebElement> CartProducts = driver.findElements(By.xpath("//tbody//td[2]//a"));

		boolean match = CartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(match);

		driver.findElement(By.xpath("//*[starts-with(@class,'btn btn-default ')]")).click();
		WebElement Register = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//u[text()='Register / Login']"))));
		Register.click();

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("(//input[contains(@placeholder,'Email Address')])[1]"))))
				.sendKeys("honeyritikjob75@gmail.com");
		driver.findElement(By.xpath("//input[contains(@data-qa,'login-p')]")).sendKeys("123456");
		driver.findElement(By.xpath("//button[contains(@data-qa,'login-b')]")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()=' Cart']")))).click();

		driver.findElement(By.xpath("//*[starts-with(@class,'btn btn-default ')]")).click();

		js.executeScript("window.scrollBy(0,500)");

		// Wait for any checkout modal overlay (#checkoutModal) to disappear before clicking the checkout button.
		// This prevents ElementClickInterceptedException where the modal (class 'modal show') blocks the click.
		By checkoutBtn = By.xpath("//a[contains(@class,'btn btn-default check_out')]");
		// wait for modal to be invisible (if present) and for the button to be clickable, then click
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkoutModal")));
		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();

		WebElement CardDetail = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name_on_card']")));

		CardDetail.sendKeys("Steve Macleen");

		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("123456789");

		driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("9090");

		driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("05");

		driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2030");

		driver.findElement(By.xpath("//button[@id='submit']")).click();

		String OrderConfirmation = driver
				.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")).getText();

		Assert.assertEquals(OrderConfirmation, "Congratulations! Your order has been confirmed!");
		driver.findElement(By.xpath("//a[text()='Download Invoice']")).click();

	}
}