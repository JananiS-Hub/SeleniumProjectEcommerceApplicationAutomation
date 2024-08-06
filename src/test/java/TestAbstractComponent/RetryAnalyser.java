package TestAbstractComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	private int count=0;
	private int Maximum_try=2;
	@Override
	public boolean retry(ITestResult result) {
		if(Maximum_try>count) {
			this.count++;
			return true;
		}
		return false;
	}

}
