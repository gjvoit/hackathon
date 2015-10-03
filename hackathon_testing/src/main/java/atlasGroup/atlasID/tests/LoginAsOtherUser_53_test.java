package atlasGroup.atlasID.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.BrowserInfo;
import atlasGroup.atlasID.helperFunctions.CallAfterTest;
import atlasGroup.atlasID.helperFunctions.SelectDriver;
import jline.internal.Log;
import atlasGroup.atlasID.helperFunctions.Login_0;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;

public class LoginAsOtherUser_53_test {
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
    	  { new BrowserInfo("internet explorer", "11") }
      };
  }
  
  @Test(dataProvider = "dp")
  public void LoginAsOtherUser_53(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	browserName = browserInfo.getBrowserShorthand();
	
	driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/login/LoginAsAnotherUser.jsp");
    
	Reporter.log("- Started LoginAsOtherUser_53 on " + browserInfo.getBrowserShorthand() + "<br>"); 
    
    driver.findElement(By.id("username that you want to login as")).clear();
    driver.findElement(By.id("username that you want to login as")).sendKeys("temp_dau_id4");
    driver.findElement(By.name("submit")).click();
    Reporter.log("- Try to sign in as temp_dau_id4 <br>"); 
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td")).getText().contains("Are you sure you want to login as this user?"));
    driver.findElement(By.name("submit")).click();
    Reporter.log("- Asserted that I want to sign in as temp_dau_id4 <br>");
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[4]/td/table/tbody/tr/td[2]/a")).getText().contains("Enroll in a new Certification Program"));
    Reporter.log("- [SUCCESS] Completed LoginAsOtherUser_53!");
  }

  @AfterMethod
  public void tearDown(ITestResult testResult) throws Exception {
	  CallAfterTest callDone = new CallAfterTest();
	  callDone.callAfterTest(driver, testResult, browserName);
  }
}
