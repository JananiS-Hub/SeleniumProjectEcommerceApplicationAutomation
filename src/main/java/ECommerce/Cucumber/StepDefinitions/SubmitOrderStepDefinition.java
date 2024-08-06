package ECommerce.Cucumber.StepDefinitions;

import io.cucumber.java.en.Given;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ECommerce.PageObjectModel.CartPage;
import ECommerce.PageObjectModel.CheckOutPage;
import ECommerce.PageObjectModel.ConfirmationPage;
import ECommerce.PageObjectModel.LoginPage;
import ECommerce.PageObjectModel.ProductListPage;
import TestAbstractComponent.TestCasesAbstractComponents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
public class SubmitOrderStepDefinition extends TestCasesAbstractComponents {

	LoginPage LoginPageObject;
	ProductListPage ProductListPageObject;
	CartPage cartPageObject;
	ConfirmationPage ConfirmationPageObject;
	CheckOutPage CheckOutPageObject;
	WebDriver driver;
	
	
	@Given("Lauch the required URL")
	public void Lauch_the_required_URL() throws IOException {
		
		driver=setDriverProperties();
		LoginPageObject=new LoginPage(driver);
		LoginPageObject.LaunchTheURL();
		
	}
	
	@Given("^Log in to application using (.+) and (.+)$")
	public void Log_in_to_application_using_EmailID_and_Password(String emailID,String password) {
		ProductListPageObject=LoginPageObject.LoginToApplication(emailID, password);
		
	}
	
	@And("^add the (.+) to the cart$")
	public void add_the_product_to_the_cart(String product) throws InterruptedException {
		ProductListPageObject.addProductToCart(product);
		cartPageObject= ProductListPageObject.clickOnCartButton();
		
	}
	
	@When("cart page is loaded, verify the (.+) is present")
	public void In_Cart_Page_Verify_Product_is_present(String product)
	{
		Assert.assertTrue(cartPageObject.checkProductPresentInCart(product), "Product is not added to cart");
	}
	
	@And("go to checkout page and fill the details and continue")
	public void Fillin_CheckoutPage_and_Continue() throws InterruptedException {
		CheckOutPageObject= cartPageObject.clickOnCheckOutButton();
		
		ConfirmationPageObject= CheckOutPageObject.fillInCheckOutDetails();
		
	}
	
	@Then("Verify the order is placed and shows {string}")
	public void verify_Order_is_Placed(String string) {
		
		Assert.assertTrue(ConfirmationPageObject.verifyOrderPlacedConfirmationMessage().equalsIgnoreCase(string)) ;
		
	}
	
	
}
