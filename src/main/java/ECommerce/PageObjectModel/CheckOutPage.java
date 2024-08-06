package ECommerce.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ECommerce.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement fieldCountry;
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement countryIndia;
	
	@FindBy(css=".btnn")
	WebElement placeOrderButton;
	
	By waitTillElementVisible=By.cssSelector(".ta-results");
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement waitTillInvisibilityOf;

	
	public ConfirmationPage fillInCheckOutDetails() throws InterruptedException {
		fieldCountry.sendKeys("India");
		waitUntilElementVisible(waitTillElementVisible);
		countryIndia.click();
		scrollDownPage();
		waitUntilElementInvisible(waitTillInvisibilityOf);
		placeOrder();
		return new ConfirmationPage(driver);
	}
	
	public void placeOrder() {
		placeOrderButton.click();
		
	}
}
