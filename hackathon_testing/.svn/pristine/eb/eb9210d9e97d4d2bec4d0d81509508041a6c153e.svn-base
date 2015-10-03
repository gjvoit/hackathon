package atlasGroup.atlasID.pages;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class AtlasReports_86 {
  private WebDriver driver;
  private String baseUrl;
  private final static Logger log = Logger.getLogger(TestManagement_62.class.getName());

  @Parameters({ "platform","browser","version", "url" })
  @BeforeTest(alwaysRun=true)
  public void setUp(String platform, String browser, String version, String url) throws Exception {
	  SelectDriver selector = new SelectDriver();
	  driver = selector.getDriver(platform, browser, version);
	  baseUrl = url;
  }
  
  @Test(description="AtlasReports_86")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started AtlasReports_86");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/reports/ReportList.jsp");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Activity Audit')]"));
    Assert.assertTrue("Activity Audit", list.size() > 0);
    
    list = driver.findElements(By.xpath("//*[contains(text(),'Student Status Report')]"));
    Assert.assertTrue("Student Status Report", list.size() > 0);
    log.info("completed AtlasReports_86!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
