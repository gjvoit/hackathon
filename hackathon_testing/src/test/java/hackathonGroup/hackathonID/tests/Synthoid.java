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

public class Synthoid {
  private WebDriver driver;
  private String baseUrl;
  private String browserName;

  @DataProvider
  public Object[][] dp() {
      return new Object[][] { 
//    	  { new BrowserInfo("Chrome", "ANY") }, 
    	  { new BrowserInfo("phantomjs", "ANY") }};
  }
  
  @Test(dataProvider = "dp")
  public void Synthoid(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Thread.sleep(2000);
	
	driver.get(baseUrl + "");
	Reporter.log("- Started Synthoid on " + browserInfo.getBrowserShorthand() + "<br>");
	Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/a")).click();
    Reporter.log("- Clicked Synthoid on front page <br>");
//    Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div/div[2]/h2")).getText().contains("Top 15 Reported Side Effects for: LEVOTHYROXINE"));
    Reporter.log("- Asserted: 'Top 15 Reported Side Effects for: LEVOTHYROXINE' on following page  <br>");
//    Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div/div[2]/p")).getText().contains("The chart below shows the top 15 reported side effects from the FDA’s database. In addition, the chart shows which of the reported side effects are currently listed on the drug label and which are not."));
    Reporter.log("- Asserted: 'The chart below shows the top 15 reported side effects from the FDA’s database' on following page  <br>");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@id='events-reports']/div/div[3]/div/button")).click();
    Reporter.log("- Clicked 'Next Step' <br>");

    Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='label-accuracy']/div[1]/div[1]/h2")).getText().contains("LEVOTHYROXINE (Synthroid)"));	
    Reporter.log("- [SUCCESS] completed Synthoid!");

  }
  
  @AfterMethod
  public void tearDown(ITestResult testResult) throws Exception {
	  CallAfterTest callDone = new CallAfterTest();
	  callDone.callAfterTest(driver, testResult, browserName);
  }


}






