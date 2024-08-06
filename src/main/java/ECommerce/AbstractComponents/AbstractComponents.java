package ECommerce.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;
	WebDriverWait explicitWait;
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersButton;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		explicitWait= new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public void waitUntilElementVisible(By locator) { 
	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitUntilElementVisible(WebElement locator) { 
		explicitWait.until(ExpectedConditions.visibilityOf(locator));
		}
	
	public void waitUntilElementInvisible(WebElement element) throws InterruptedException {
		
		
		//explicitWait.until(ExpectedConditions.invisibilityOf(element));
		Thread.sleep(1000);
		}

	public void scrollDownPage() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void clickCartButton() {
		cartButton.click();
	}
	
	public void clickOrdersButton() {
		
		ordersButton.click();
	}
}
