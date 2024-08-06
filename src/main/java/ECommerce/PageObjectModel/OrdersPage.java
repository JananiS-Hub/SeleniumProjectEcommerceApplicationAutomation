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

public class OrdersPage extends AbstractComponents {
	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ProductListedInOrders;
	
	
	
	public List<WebElement> getProductListInOrderPage() {
		return ProductListedInOrders;
	}
	
	public Boolean checkProductPresentInCart(String productName) {
		Boolean isProductPresentInOrderPage=getProductListInOrderPage().stream().
				anyMatch(ExactProduct->ExactProduct.getText().equalsIgnoreCase(productName));
		return isProductPresentInOrderPage;
	}
	


}
