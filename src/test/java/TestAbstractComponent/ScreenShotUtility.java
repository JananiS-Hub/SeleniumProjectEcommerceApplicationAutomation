package TestAbstractComponent;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotUtility {
	public String screenshotUtility(String methodName,WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File sourceFile=ts.getScreenshotAs(OutputType.FILE);
	File destinationFile= new File(System.getProperty("user.dir")+"//reports//"+methodName+".png");
	FileUtils.copyFile(sourceFile, destinationFile);
return System.getProperty("user.dir")+"//reports//"+methodName+".png";
}
}
