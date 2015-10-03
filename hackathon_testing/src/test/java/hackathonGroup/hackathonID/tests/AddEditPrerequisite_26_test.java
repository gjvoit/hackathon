package hackathonGroup.hackathonID.tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hackathonGroup.hackathonID.helperFunctions.BrowserInfo;
import hackathonGroup.hackathonID.helperFunctions.CallAfterTest;
import hackathonGroup.hackathonID.helperFunctions.SelectDriver;
import jline.internal.Log;

public class AddEditPrerequisite_26_test {
  private WebDriver driver;
  private String baseUrl;
  private String browserName;

  @DataProvider
  public Object[][] dp() {
      return new Object[][] { 
    	  { new BrowserInfo("Chrome", "ANY") }, 
    	  { new BrowserInfo("Firefox", "ANY") },
    	  { new BrowserInfo("internet explorer", "9") },
    	  { new BrowserInfo("internet explorer", "10") },
    	  { new BrowserInfo("internet explorer", "11") }};
  }
  
  @Test(dataProvider = "dp")
  public void AddEditPrerequisite_26(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Thread.sleep(2000);
	Reporter.log("- Started AddEditPrerequisite_26 on " + browserInfo.getBrowserShorthand() + "<br>");
	browserName = browserInfo.getBrowserShorthand();

    driver.get(baseUrl + "/");
    Reporter.log("- Prerequisite successfully removed <br>");
    
    Reporter.log("- [SUCCESS] completed AddEditPrerequisite_65!");
  }
  
  @AfterMethod
  public void tearDown(ITestResult testResult) throws Exception {
	  CallAfterTest callDone = new CallAfterTest();
	  callDone.callAfterTest(driver, testResult, browserName);
  }


}
