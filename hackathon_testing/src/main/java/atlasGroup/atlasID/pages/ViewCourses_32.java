package atlasGroup.atlasID.pages;

import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class ViewCourses_32 {
  private WebDriver driver;
  private String baseUrl;
  private final static Logger log = Logger.getLogger(ViewCourses_32.class.getName());

  @Parameters({ "platform","browser","version", "url" })
  @BeforeTest(alwaysRun=true)
  public void setUp(String platform, String browser, String version, String url) throws Exception {
	  SelectDriver selector = new SelectDriver();
	  driver = selector.getDriver(platform, browser, version);
	  baseUrl = url;
  }

  @Test(description="View Courses")
  public void viewCourses_32() throws Exception {
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
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
  
}
