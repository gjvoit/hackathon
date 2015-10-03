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

public class NexiumContributing {
  private WebDriver driver;
  private String baseUrl;
  private String browserName;

  @DataProvider
  public Object[][] dp() {
      return new Object[][] { 
//    	  { new BrowserInfo("Chrome", "ANY") }, 
    	  { new BrowserInfo("Firefox", "ANY") }};
  }
  
  @Test(dataProvider = "dp")
  public void Synthoid(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Thread.sleep(2000);
	
	driver.get(baseUrl + "/");
	driver.findElement(By.id("searchValue")).clear();
	driver.findElement(By.id("searchValue")).sendKeys("Nexium");
	driver.findElement(By.xpath("//button[@type='button']")).click();
	// ERROR: Caught exception [unknown command [assertTrue]]
	driver.findElement(By.xpath("//div[@id='events-reports']/div/div[3]/div/button")).click();
	driver.findElement(By.id("toolbox-close")).click();
	// ERROR: Caught exception [unknown command [assertTrue]]
	// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
	driver.findElement(By.linkText("YES")).click();
	driver.findElement(By.linkText("NO")).click();
	driver.findElement(By.linkText("YES")).click();
	driver.findElement(By.linkText("NO")).click();
	driver.findElement(By.linkText("YES")).click();
	driver.findElement(By.linkText("NO")).click();
	driver.findElement(By.linkText("YES")).click();
	driver.findElement(By.linkText("NO")).click();
	driver.findElement(By.linkText("YES")).click();
	driver.findElement(By.linkText("NO")).click();
	driver.findElement(By.linkText("YES")).click();
	driver.findElement(By.linkText("YES")).click();
	driver.findElement(By.linkText("NO")).click();
	driver.findElement(By.linkText("YES")).click();
	driver.findElement(By.linkText("NO")).click();
	driver.findElement(By.linkText("YES")).click();
	driver.findElement(By.linkText("NO")).click();
	driver.findElement(By.linkText("YES")).click();
	// ERROR: Caught exception [unknown command [assertTrue]]
	driver.findElement(By.id("firstName")).clear();
	driver.findElement(By.id("firstName")).sendKeys("Nathan Waters");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	// ERROR: Caught exception [unknown command [assertTrue]]
  }
  
  @AfterMethod
  public void tearDown(ITestResult testResult) throws Exception {
	  CallAfterTest callDone = new CallAfterTest();
	  callDone.callAfterTest(driver, testResult, browserName);
  }


}


