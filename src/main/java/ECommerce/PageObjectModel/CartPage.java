package ECommerce.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import ECommerce.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".cartSection h3")
	List<WebElement> ProductListedInCart;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutButton;
	
	

	
	
	public List<WebElement> getProductListInCart() {
		return ProductListedInCart;
	}
	
	public Boolean checkProductPresentInCart(String productName) {
		Boolean isProductPresentInCart=getProductListInCart().stream().
				anyMatch(ExactProduct->ExactProduct.getText().equalsIgnoreCase(productName));
		return isProductPresentInCart;
	}
	
	public CheckOutPage clickOnCheckOutButton() {
		checkOutButton.click();
		return new CheckOutPage(driver);
	}

}
