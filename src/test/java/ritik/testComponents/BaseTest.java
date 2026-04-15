package ritik.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import AutomationFramework.PageObjects.LandingPage;

public class BaseTest {
	public static WebDriver driver;
	public LandingPage land;
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\main\\java\\ritik\\resources\\GlobalData.Properties"));
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public String getScreenshot(String testCasename,WebDriver driver) throws IOException
	{
	
		TakesScreenshot ts =((TakesScreenshot)driver);
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//reports//"+testCasename+".png");
		FileUtils.copyFile(source, dest);
		return System.getProperty("user.dir")+"//reports//"+testCasename+".png";
	}
	
	
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		land=new LandingPage(driver);
		land.goTo();
		land.clickToSignINIcon();
		return land;
	}
	@AfterMethod(alwaysRun=true)
	public void TearDown()
	{
		driver.quit();
	}
}