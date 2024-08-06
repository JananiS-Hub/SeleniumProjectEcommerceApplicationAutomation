package ECommerce.TestCases;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import ECommerce.Data.JsonUtility;
import TestAbstractComponent.TestCasesAbstractComponents;
import TestAbstractComponent.RetryAnalyser;

public class ErrorValidation extends TestCasesAbstractComponents {
	
	@Test(groups= {"ErrorValidation"},dataProvider="dataProvider",retryAnalyzer=RetryAnalyser.class)
	//@Test(dataProvider="dataProvider")
	public void IncorrectPasswordErrorValidation(HashMap<String,String> input) throws InterruptedException {
	LoginPageObject.LoginToApplication(input.get("email"), input.get("password"));
	//Thread.sleep(1000);
	Assert.assertEquals("Incorrect email or password.", LoginPageObject.loginPageErrorValidation());
	

}
	
	
	

 @Test public void IncorrectEmailErrorValidation() {
 LoginPageObject.LoginToApplication("jananisivaraj1@gmail.com", "Zuzu@71555");
 Assert.assertEquals("Incorrect email or password.",
 LoginPageObject.loginPageErrorValidation()); 
 }
 
	
	
 @DataProvider(name = "dataProvider")
	public Object[][] DataProvider() throws IOException {
		JsonUtility  JsonUtilityObject= new JsonUtility();
		List<HashMap<String,String>> hashMappedData=JsonUtilityObject.covertJsonDataToHashmap();
		return new Object[][] {{hashMappedData.get(0)},{hashMappedData.get(1)}};
		
	}
 
 
}
