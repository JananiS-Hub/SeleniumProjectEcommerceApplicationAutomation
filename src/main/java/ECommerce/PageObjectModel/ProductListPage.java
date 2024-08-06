package ECommerce.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ECommerce.AbstractComponents.AbstractComponents;

public class ProductListPage extends AbstractComponents {
	WebDriver driver;
	//constructor
	public ProductListPage(WebDriver driver) {
		//to send the driver knowledge to parent class
		super(driver);
		//assigning this class driver with driver knowledge
		this.driver=driver;
		//initialization of @FindBy
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".col-lg-4")
	List<WebElement> listOfProducts;
	By waitUntilLoad1= By.cssSelector(".col-lg-4");
	By addToCartButton= By.cssSelector(".card-body button:last-of-type");
	By waitTillToasterContainerMessage= By.cssSelector("#toast-container");
	@FindBy(css=".ng-animating")
	WebElement waitTillAnimationDisappear;
	
	
	
	public List<WebElement> getListOfProduct()
	{
		waitUntilElementVisible(waitUntilLoad1);
		return listOfProducts;
	}
	
		
	public WebElement selectProductByName(String productName) {
		WebElement productContainer= getListOfProduct().stream().filter(exactProduct->
		 exactProduct.findElement(By.cssSelector("b")).
		 getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return productContainer;
		
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		
		selectProductByName(productName).findElement(addToCartButton).click();
		waitUntilElementVisible(waitTillToasterContainerMessage);
		waitUntilElementInvisible(waitTillAnimationDisappear);
		
	}
	
	public CartPage clickOnCartButton() {
		clickCartButton();
		return new CartPage(driver);
	}

	public OrdersPage clickOnOrdersButton() {
		clickOrdersButton();
		return new OrdersPage(driver);
	}
}
