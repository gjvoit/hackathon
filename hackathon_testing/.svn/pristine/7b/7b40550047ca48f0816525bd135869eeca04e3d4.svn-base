package atlasGroup.atlasID.tests;

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

import atlasGroup.atlasID.helperFunctions.BrowserInfo;
import atlasGroup.atlasID.helperFunctions.CallAfterTest;
import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;
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
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);
	Reporter.log("- Started AddEditPrerequisite_26 on " + browserInfo.getBrowserShorthand() + "<br>");
	browserName = browserInfo.getBrowserShorthand();

    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/desktop/courseAdministration/SelectCourse.jsp?a=ap");
    
    driver.findElement(By.name("key")).sendKeys("ACQ000 clg 004");
    Reporter.log("- Selected course ACQ 000 clg 004 <br>");
    
    driver.findElement(By.name("prerequisites")).sendKeys("ACQ001 ACQ 101 Course");
    Reporter.log("- Selected course ACQ001 ACQ 101 Course as a prerequisite <br>");
    
    driver.findElement(By.id("add prerequisite")).click();
    driver.findElement(By.id("add prerequisites to course")).click();
    Reporter.log("- Clicked Add Prerequisite <br>");
    
    Assert.assertTrue(driver.findElement(By.xpath("html/body/table[5]/tbody/tr[3]/td")).getText().contains("The following is the  updated prerequisite list"));
    Reporter.log("- Prerequisite successfully added <br>");
    
    driver.findElement(By.id("go back")).click();
    try{
    	driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/ul/li/a")).click();
    } catch(Exception e){
    	driver.findElement(By.linkText("[Remove Prerequisite]")).click();
    }
    Reporter.log("- Clicked Remove Prerequisite link <br>");
    
    driver.findElement(By.id("remove prerequisites from course")).click();
    Assert.assertTrue(driver.findElement(By.xpath("html/body/table[5]/tbody/tr[3]/td")).getText().contains("No prerequisites are associated with ACQ000"));
    Reporter.log("- Prerequisite successfully removed <br>");
    
    Reporter.log("- [SUCCESS] completed AddEditPrerequisite_65!");
  }
  
  @AfterMethod
  public void tearDown(ITestResult testResult) throws Exception {
	  CallAfterTest callDone = new CallAfterTest();
	  callDone.callAfterTest(driver, testResult, browserName);
  }


}
