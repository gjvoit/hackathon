package atlasGroup.atlasID.tests;

import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atlasGroup.atlasID.helperFunctions.BrowserInfo;
import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;
import atlasGroup.atlasID.pages.TestManagement_62;

public class ViewCourses_32_test {
  private WebDriver driver;
  private String baseUrl;
  private final static Logger log = Logger.getLogger(TestManagement_62.class.getName());

  //quick fake change 
  
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
  public void ViewCourses_32(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);
	driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "/html/desktop/ViewCourses.jsp");
    
    log.info("started ViewCourses_32");

    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("BCF");
    log.info("started ViewCourses_32 -- 1");
//    driver.navigate().refresh();
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CLE");
//    driver.navigate().refresh();
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ACQ");
    new Select(driver.findElement(By.name("key"))).selectByVisibleText("ACQ000 clg 004");
    log.info("started ViewCourses_32 -- 2");
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a")).getText().contains("ACQ000 clg 004"));

    log.info("started ViewCourses_32 -- 3");
//    driver.navigate().refresh();
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CLM");
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=key | label=CLM001 Ethics Training for Acquisition Technology and Logistics]]
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=dark]]
    log.info("started ViewCourses_32 -- 4");
    try{
    	new Select(driver.findElement(By.name("key"))).selectByVisibleText("CLM001 Ethics Training for Acquisition Technology and Logistics");
    } catch(Exception e){
    	log.info("started ViewCourses_32 -- 4.5 hmmm ");
    	driver.navigate().refresh();
    	new Select(driver.findElement(By.name("key"))).selectByVisibleText("CLM001 Ethics Training for Acquisition Technology and Logistics");
    }
    log.info("started ViewCourses_32 -- 5");
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a")).getText().contains("CLM001 Ethics Training for Acquisition Technology and Logistics"));
    log.info("completed ViewCourses_32!");
    driver.quit();
  }

}
