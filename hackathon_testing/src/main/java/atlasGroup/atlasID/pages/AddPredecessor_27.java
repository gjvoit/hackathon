package atlasGroup.atlasID.pages;

import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class AddPredecessor_27 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private final static Logger log = Logger.getLogger(TestManagement_62.class.getName());

  @Parameters({ "platform","browser","version", "url" })
  @BeforeTest(alwaysRun=true)
  public void setUp(String platform, String browser, String version, String url) throws Exception {
	  SelectDriver selector = new SelectDriver();
	  driver = selector.getDriver(platform, browser, version);
	  baseUrl = url;
  }
  
  @Test(description="AddPredecessor_27")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started AddPredecessor_27");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/utilities/admin/reference/PredecessorCourseAssociation.jsp");
    
    driver.findElement(By.id("currentCourseID")).sendKeys("ACQ402 Executive Management Course");
    driver.findElement(By.id("predCourseID")).sendKeys("ACQ402 Executive Management Course");
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=currentCourseID | label=ACQ402 Executive Management Course]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=predCourseID | label=ACQ402 Executive Management Course]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=predCourseID | label=ACQ402 Executive Management Course]]
    driver.findElement(By.name("Next")).click();
    driver.findElement(By.linkText("Disassociate")).click();
    log.info("completed AddPredecessor_27!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
