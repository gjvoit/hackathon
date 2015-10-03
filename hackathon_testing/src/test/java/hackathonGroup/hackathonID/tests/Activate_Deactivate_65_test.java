package hackathonGroup.hackathonID.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import hackathonGroup.hackathonID.helperFunctions.BrowserInfo;
import hackathonGroup.hackathonID.helperFunctions.CallAfterTest;
import hackathonGroup.hackathonID.helperFunctions.SelectDriver;
import jline.internal.Log;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class Activate_Deactivate_65_test {
  private WebDriver driver;
  private String baseUrl;
  private String browserName;

  @DataProvider
  public Object[][] dp() {
      return new Object[][] { 
    	  { new BrowserInfo("Chrome", "ANY") }, 
    	  { new BrowserInfo("Firefox", "ANY") }};
  }
  
  @Test(dataProvider = "dp")
  public void Activate_Deactivate_65(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Thread.sleep(2000);  
	Reporter.log("Started Activate_Deactivate_65 on " + browserInfo.getBrowserShorthand() + "<br>");
	browserName = browserInfo.getBrowserShorthand();
	
    driver.get(baseUrl + "");

    Reporter.log("- It worked! <br>");
  }

  @AfterMethod
  public void tearDown(ITestResult testResult) throws Exception {
	  CallAfterTest callDone = new CallAfterTest();
	  callDone.callAfterTest(driver, testResult, browserName);
  }

}
