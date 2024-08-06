package ECommerce.PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ECommerce.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="userEmail")
	WebElement eMailID;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(css=".toast-message")
	WebElement errorMessage;

	
	
public void LaunchTheURL() {
	driver.get("https://rahulshettyacademy.com/client/");
}

public ProductListPage LoginToApplication(String email,String password) {
	eMailID.sendKeys(email);
	userPassword.sendKeys(password);
	loginButton.click();
	
	return new ProductListPage(driver);
	
}

public String loginPageErrorValidation() {
	//waitUntilElementVisible(errorMessage);
	return errorMessage.getText();
	
	
}

}
