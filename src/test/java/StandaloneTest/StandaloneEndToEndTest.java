package StandaloneTest;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneEndToEndTest {

	public static void main(String[] args) throws InterruptedException {
		String productName= "ZARA COAT 3";
		String productName2= "LAPTOP";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client/");
		
		driver.findElement(By.id("userEmail")).sendKeys("jananisivaraj1@gmail.com");
		
		driver.findElement(By.id("userPassword")).sendKeys("Zuzu@7155");
		
		driver.findElement(By.id("login")).click();
		
		/*
		 * Thread.sleep(1000); driver.findElement(By.xpath("//b[text()='"+productName+
		 * "']/parent::h5/following-sibling::button[2]")).click();
		 */
		
		/* using streams and implicit wait */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait explicitWait= new WebDriverWait(driver,Duration.ofSeconds(10));
		List<WebElement> listOfProducts= driver.findElements(By.cssSelector(".col-lg-4"));
		WebElement productContainer= listOfProducts.stream().filter(exactProduct->
									 exactProduct.findElement(By.cssSelector("b")).
									 getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		
		productContainer.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//invisibilityOf is faster than visibilityOfElementLocated
		explicitWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> ProductListedInCart = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean isProductPresentInCart=ProductListedInCart.stream().anyMatch(ExactProduct->ExactProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(isProductPresentInCart, "Product is not added to cart");
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//button[contains(@class,'ta-item')])[2]")));
		driver.findElement(By.cssSelector(".btnn")).click();
		
		String OrderPlacedConfirmationMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(OrderPlacedConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER.")) ;
		driver.close();
		
	}

}
