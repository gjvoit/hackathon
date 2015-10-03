package atlasGroup.atlasID.pages;

import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class ViewProperties_52 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private final static Logger log = Logger.getLogger(ViewProperties_52.class.getName());

  @Parameters({ "platform","browser","version", "url" })
  @BeforeTest(alwaysRun=true)
  public void setUp(String platform, String browser, String version, String url) throws Exception {
	  SelectDriver selector = new SelectDriver();
	  driver = selector.getDriver(platform, browser, version);
	  baseUrl = url;
  }

  @Test(description="View Properties")
  public void ViewProperties52() throws Exception {
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/utilities/admin/DisplayProperties.jsp");
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=textBlue]]
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}

