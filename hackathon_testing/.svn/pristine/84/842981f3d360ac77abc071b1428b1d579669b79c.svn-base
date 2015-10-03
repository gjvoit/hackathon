package atlasGroup.atlasID.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.BrowserInfo;
import atlasGroup.atlasID.helperFunctions.CallAfterTest;
import atlasGroup.atlasID.helperFunctions.SelectDriver;
import jline.internal.Log;
import atlasGroup.atlasID.helperFunctions.Login_0;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class CampusBanner_74_test {
  private WebDriver driver;
  private String baseUrl;
  private String browserName;

  @DataProvider
  public Object[][] dp() {
      return new Object[][] { 
    	  { new BrowserInfo("Chrome", "ANY") },
    	  { new BrowserInfo("Firefox", "ANY") },
    	  { new BrowserInfo("internet explorer", "9") },
//    	  { new BrowserInfo("internet explorer", "10") },
//    	  { new BrowserInfo("internet explorer", "11") }
	  };
  }
  
  @Test(dataProvider = "dp")
  public void CampusBanner_74(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);
	browserName = browserInfo.getBrowserShorthand().replaceAll("\\s+","");
	
	
	Reporter.log("- Started CampusBanner_74 on " + browserInfo.getBrowserShorthand() + "<br>");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");

    driver.get(baseUrl + "html/login/campusBanner/CampusBanner.jsp");
    driver.findElement(By.xpath("(//a[contains(text(),'[Update]')])[47]")).click();
    Thread.sleep(2000); 
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id='verify new mini survey information']/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/textarea")).getText().contains("This is a test banner only. Adding this to validate an issue that was reported by the client."));
    new Select(driver.findElement(By.name("flag"))).selectByVisibleText("Yes");
    new Select(driver.findElement(By.id("month-fieldmonthdayyear"))).selectByVisibleText("February");
    new Select(driver.findElement(By.id("day-fieldmonthdayyear"))).selectByVisibleText("2");
    new Select(driver.findElement(By.id("month-fieldmonth1day1year1"))).selectByVisibleText("January");
    new Select(driver.findElement(By.id("day-fieldmonth1day1year1"))).selectByVisibleText("9");
    driver.findElement(By.name("sumbit")).click();
	
    Reporter.log("- Activated test banner <br>");

    driver.findElement(By.linkText("[Update]")).click();
    new Select(driver.findElement(By.name("flag"))).selectByVisibleText("No");
    driver.findElement(By.name("sumbit")).click();
    
    Reporter.log("- Deactivated current banner <br>");
    
    driver.get(baseUrl + "html/login/login.jsp");
    switchToWindow("First test");
    
    Reporter.log("- Asserted that banner updated correctly <br>");
    
    driver.get(baseUrl + "html/login/campusBanner/CampusBanner.jsp");
    driver.findElement(By.xpath("(//a[contains(text(),'[Update]')])[47]")).click();
    new Select(driver.findElement(By.name("flag"))).selectByVisibleText("No");
    new Select(driver.findElement(By.id("month-fieldmonthdayyear"))).selectByVisibleText("February");
    new Select(driver.findElement(By.id("day-fieldmonthdayyear"))).selectByVisibleText("2");
    new Select(driver.findElement(By.id("month-fieldmonth1day1year1"))).selectByVisibleText("January");
    new Select(driver.findElement(By.id("day-fieldmonth1day1year1"))).selectByVisibleText("9");
    driver.findElement(By.name("sumbit")).click();
    driver.findElement(By.linkText("[Update]")).click();
    new Select(driver.findElement(By.name("flag"))).selectByVisibleText("Yes");
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id='verify new mini survey information']/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/textarea")).getText().contains("CAMPUS BANNER ATLAS DEV TEST"));
    driver.findElement(By.name("sumbit")).click();
    
    Reporter.log("- Changed the two banners back to original information and configuration <br>");
    
    driver.get(baseUrl + "html/login/login.jsp");
    switchToWindow("Second test");
    
    Reporter.log("- Asserted that banner updated back correctly");
    Reporter.log("- [SUCCESS] completed CampusBanner_74! <br>");
  }
  
  public void switchToWindow(String a) throws Exception{
	  String winHandleBefore = driver.getWindowHandle();
	  for(String winHandle : driver.getWindowHandles()){
	      driver.switchTo().window(winHandle);
	  }
	  if (a.contains("First test")){
		  Assert.assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td")).getText().contains("Description fr Hello!! this is my test banner - RP"));
	  } else {
		  Assert.assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td")).getText().contains("Call Center Closed!!!"));
	  }
	  driver.close();
	  driver.switchTo().window(winHandleBefore);
  }

  
  @AfterMethod
  public void tearDown(ITestResult testResult) throws Exception {
	  CallAfterTest callDone = new CallAfterTest();
	  callDone.callAfterTest(driver, testResult, browserName);
  }

}
