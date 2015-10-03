package atlasGroup.atlasID.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atlasGroup.atlasID.helperFunctions.BrowserInfo;
import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.helperFunctions.Login_0;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;

public class AtlasReports_86_test {
  private WebDriver driver;
  private String baseUrl;

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
  public void AtlasReports_86(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/reports/ReportList.jsp");

    Reporter.log("- Started AtlasReports_86 on " + browserInfo.getBrowserShorthand() + "<br>");
    
    List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Activity Audit')]"));
    Assert.assertTrue("Activity Audit", list.size() > 0);
    Reporter.log("- Found Activity Audit");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'Avg Comp/Grad Rate Time Report')]"));
    Assert.assertTrue("Avg Comp/Grad Rate Time Report", list.size() > 0);
    Reporter.log("- Found Avg Comp/Grad Rate Time Report");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'CLC Graduation Report')]"));
    Assert.assertTrue("CLC Graduation Report", list.size() > 0);
    Reporter.log("- Found CLC Graduation Report");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'Certification Complete Detail Report')]"));
    Assert.assertTrue("Certification Complete Detail Report", list.size() > 0);
    Reporter.log("- Found Certification Complete Detail Report");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'Certification Completion Report [Available in Atlas2]')]"));
    Assert.assertTrue("Certification Completion Report [Available in Atlas2]", list.size() > 0);
    Reporter.log("- Found Certification Completion Report");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'Course Roster Report')]"));
    Assert.assertTrue("Course Roster Report", list.size() > 0);
    Reporter.log("- Found Course Roster Report");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'Email Report')]"));
    Assert.assertTrue("Email Report", list.size() > 0);
    Reporter.log("- Found Email Report");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'New Student Report [Available in Atlas2]')]"));
    Assert.assertTrue("New Student Report [Available in Atlas2]", list.size() > 0);
    Reporter.log("- Found New Student Report");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'Section Detail Report')]"));
    Assert.assertTrue("Section Detail Report", list.size() > 0);
    Reporter.log("- Found Section Detail Report");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'Student Performance Report')]"));
    Assert.assertTrue("Student Performance Report", list.size() > 0);
    Reporter.log("- Found Student Performance Report");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'Test Item Analysis Report')]"));
    Assert.assertTrue("Test Item Analysis Report", list.size() > 0);
    Reporter.log("- Found Test Item Analysis Report");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'Student Status Report')]"));
    Assert.assertTrue("Student Status Report", list.size() > 0);
    Reporter.log("- Found Student Status Report");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'Training Assignment Exception Report [Available in Atlas2]')]"));
    Assert.assertTrue("Training Assignment Exception Report [Available in Atlas2]", list.size() > 0);
    Reporter.log("- Found Training Assignment Exception Report");

    Reporter.log("- Asserted all list items (ie Student Performance Report, Section Detail Report, etc) are present <br>");
    
    Reporter.log("- [SUCCESS] Completed AtlasReports_86!");
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
  }
  
}
