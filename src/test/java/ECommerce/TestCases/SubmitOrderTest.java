package ECommerce.TestCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce.PageObjectModel.CartPage;
import ECommerce.PageObjectModel.CheckOutPage;
import ECommerce.PageObjectModel.ConfirmationPage;
import ECommerce.PageObjectModel.OrdersPage;
import ECommerce.PageObjectModel.ProductListPage;
import TestAbstractComponent.TestCasesAbstractComponents;

public class SubmitOrderTest extends TestCasesAbstractComponents{

	@Test
	public void SubmitOrder() throws IOException, InterruptedException {
		String productName= "ZARA COAT 3";
		
		ProductListPage ProductListPageObject=LoginPageObject.LoginToApplication("jananisivaraj1@gmail.com", "Zuzu@7155");
		
		ProductListPageObject.addProductToCart(productName);
		CartPage cartPageObject= ProductListPageObject.clickOnCartButton();
		
		
		Assert.assertTrue(cartPageObject.checkProductPresentInCart(productName), "Product is not added to cart");
		CheckOutPage CheckOutPageObject= cartPageObject.clickOnCheckOutButton();
		
		ConfirmationPage ConfirmationPageObject= CheckOutPageObject.fillInCheckOutDetails();
		
		Assert.assertTrue(ConfirmationPageObject.verifyOrderPlacedConfirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER.")) ;
		
		
	}
	
	@Test(dependsOnMethods={"SubmitOrder"})
	public void CheckItemPresentInOrdersPage() {
		ProductListPage ProductListPageObject=LoginPageObject.LoginToApplication("jananisivaraj1@gmail.com", "Zuzu@7155");
		OrdersPage OrdersPageObject = ProductListPageObject.clickOnOrdersButton();
		OrdersPageObject.checkProductPresentInCart("ZARA COAT 3");
		
	}

}
