package AutomationExercise.AutomationFramework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import AutomationFramework.PageObjects.LoginToConfirmOrder;
import ritik.testComponents.BaseTest;

public class ErrorValidation extends BaseTest{
	@Test(retryAnalyzer = ritik.testComponents.RetryAnalyzer.class)
	public void RegisterUser() throws IOException {
		land.clickToSignINIcon();
		land.SignIn("Ritik", "don75gmail.com");
		String msg = land.getValidationMessage();
		System.out.println(msg);
		Assert.assertTrue(msg.contains("Please include an '@' in the email address. 'don75gmail.com' is missing an '@'."));
	}
	
	@Test
	public void LoginToAccount()
	{
		
		land.clickToSignINIcon();
		LoginToConfirmOrder logged = new LoginToConfirmOrder(driver);
		logged.LoginToConfirm("washinkn@icloud.com", "123456");
		String message=logged.getErrorMessage();
		Assert.assertTrue(message.contains("You email or password is incorrect!"));
		
	}
}
