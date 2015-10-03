package atlasGroup.atlasID.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atlasGroup.atlasID.helperFunctions.BrowserInfo;
import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;

public class AtlasProperties_50_test {
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
  public void AtlasProperties_50(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	
	Reporter.log("- Started AtlasProperties_50 on " + browserInfo.getBrowserShorthand() + "<br>");
	
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/utilities/admin/Properties.jsp");
    
    // Perform the click operation that opens new window
//    String winHandleBefore = driver.getWindowHandle();
    
//    driver.findElement(By.xpath("/html/body/div[2]/div[5]")).click();
//    
//    try{
//    	driver.findElement(By.xpath("/html/body/div[17]/div/table/tbody/tr[1]/td/div/div[2]/span/ul/ul[1]/li[1]/a"));
//    } catch (Exception e){
//    	Reporter.log("Started AtlasProperties_50 -- 1.5");
//    	driver.findElement(By.xpath("/html/body/div[17]/table/tbody/tr[1]/td/div/div[2]/span/ul/ul[1]/li[1]/a")).click();
//    }
//	Reporter.log("Started AtlasProperties_50 -- 2");
//	// Switch to new window opened
//    for(String winHandle : driver.getWindowHandles()){
//    	driver.switchTo().window(winHandle);
//	}

    try{
    	List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Application Property Id')]"));
	    Assert.assertTrue("Application Property Id", list.size() > 0);
    } catch (Exception e){
    	Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[1]/th[1]")).getText().contains("Application Property Id"));
    	Reporter.log("- Confirmed the presence of Application Propery Id");
    }
    Reporter.log("- [SUCCESS] Completed AtlasProperties_50!");
  }
  
  @AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
  }

}
