package TestAbstractComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ECommerce.Data.JsonUtility;
import ECommerce.PageObjectModel.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCasesAbstractComponents {
	
	public WebDriver driver;
	public LoginPage LoginPageObject;
	
	
	
	public WebDriver setDriverProperties() throws IOException {
		
		Properties globalProperty=new Properties();
		FileInputStream convertedFileToInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\GlobalProperties\\GlobalProperties.properties");
		globalProperty.load(convertedFileToInputStream);
		String browser=globalProperty.getProperty("driver");
		
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//code to invoke firefox driver.
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplication() throws IOException {
		driver=setDriverProperties();
		LoginPageObject=new LoginPage(driver);
		LoginPageObject.LaunchTheURL();
		return LoginPageObject;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeTheDriver() throws IOException
	{
	driver.close();
	}
	
	
	

}
