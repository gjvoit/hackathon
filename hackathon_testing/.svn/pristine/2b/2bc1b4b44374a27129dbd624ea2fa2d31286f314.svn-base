package atlasGroup.atlasID.pages;

import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class Activate_Deactivate_65 {
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
  
  @Test(description="Activate_Deactivate_65")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started Activate_Deactivate_65");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/user/ActivateDeactivateUser.jsp");
    
    log.info("Activate_Deactivate_65 -- 1");
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Booz");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Allen");
    driver.findElement(By.id("username")).clear();
    log.info("Activate_Deactivate_65 -- 2");
    driver.findElement(By.id("username")).sendKeys("temp_dau_id4");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.linkText("[Deactivate]")).click();
    log.info("Activate_Deactivate_65 -- 3");
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=message]]
    driver.findElement(By.xpath("(//input[@name='Submit'])[2]")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Booz");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Allen");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("temp_dau_id4");
    log.info("Activate_Deactivate_65 -- 4");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.linkText("[Reactivate]")).click();
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=message]]
    log.info("Completed Activate_Deactivate_65");
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
