package AutomationExercise.AutomationFramework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AutomationFramework.PageObjects.AccountCreatedConfirmation;
import AutomationFramework.PageObjects.AccountDeleted;
import AutomationFramework.PageObjects.CardDetails;
import AutomationFramework.PageObjects.CartPage;
import AutomationFramework.PageObjects.LoginToConfirmOrder;
import AutomationFramework.PageObjects.OrderConfirmation;
import AutomationFramework.PageObjects.ProductDetails;
import AutomationFramework.PageObjects.Register;
import ritik.testComponents.BaseTest;
import automationframework.data.DataReader;

public class StandAlone2 extends BaseTest{
	@Test(dataProvider = "getData")
	public void RegisterUserDetails(HashMap<String, String> input) throws IOException, InterruptedException {
		String ProductName = input.get("productName");
		land.SignIn(input.get("name"), input.get("email"));
		Register r = new Register(driver);
		r.selectCategory();
		r.passkey(input.get("passkey"));
		r.jscriptExecutors();
		r.selectDays(input.get("day"));
		r.selectMonths(input.get("month"));
		r.selectYears(input.get("year"));
		r.News();
		r.FillDetails(input.get("firstName"), input.get("lastName"), input.get("company"), input.get("address"));
		r.jscriptExecutors();
		r.selectCountry(Integer.parseInt(input.get("countryIndex")));
		r.HomeTown(input.get("city"), input.get("state"), input.get("zipcode"), input.get("mobile"));
		AccountCreatedConfirmation confirm = new AccountCreatedConfirmation(driver);

		String ConfirmationText = confirm.ConfirmText();
		Assert.assertEquals(ConfirmationText, "ACCOUNT CREATED!");
		confirm.ToContinue();
		confirm.DeleteAccount();

		AccountDeleted Delete = new AccountDeleted(driver);
		String DeleteAccText = Delete.DconfirmText();
		Assert.assertEquals(DeleteAccText, "ACCOUNT DELETED!");

		Delete.AfterDeleteContinue();

		ProductDetails product = new ProductDetails(driver);
		product.getProductList();
		product.getProductByName(ProductName);
		product.AddToCart(ProductName);
		product.ViewTheCart();

		CartPage cart = new CartPage(driver);
		boolean match = cart.showCart(ProductName);
		Assert.assertTrue(match);

		cart.ProceedToChecout();
		cart.RegisterAccount();

		LoginToConfirmOrder logged = new LoginToConfirmOrder(driver);
		logged.LoginToConfirm(input.get("email"), input.get("loginPassword"));

		logged.carticon();

		cart.ProceedToChecout();
		cart.OrderToPlace();
		
		CardDetails Card=new CardDetails(driver);
		Card.EnterCardDetails("Steve Maclin", "8847484638", "9090", "05", "2030");

		OrderConfirmation order=new OrderConfirmation(driver);
		String OrderConfirmation= order.OrderConfirmed();
		
		Assert.assertEquals(OrderConfirmation, "Congratulations! Your order has been confirmed!");
		order.DownloadBill();

	}
	@Test(dependsOnMethods="RegisterUserDetails")
	public void VerifyOrderDisplay()
	{
		LoginToConfirmOrder logged = new LoginToConfirmOrder(driver);
		logged.LoginToConfirm("honeyritikjob75@gmail.com", "123456");

		logged.carticon();
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		DataReader dr = new DataReader();
		 List<HashMap<String, String>> data = dr.getJSONDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\automationframework\\data\\registerData.json");
		return new Object[][] {{data.get(0)}};
	}
	
	








}