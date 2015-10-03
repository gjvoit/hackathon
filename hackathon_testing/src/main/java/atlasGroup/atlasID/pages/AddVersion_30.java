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

public class AddVersion_30 {
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
  
  @Test(description="AddVersion_30")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started AddVersion_30");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/course/ChangeVersion.jsp?option=1");
    
    new Select(driver.findElement(By.name("course_type_id"))).selectByVisibleText("SCORM2004 Version 3");
    new Select(driver.findElement(By.name("course_type_id"))).selectByVisibleText("SCORM 1.1");
    new Select(driver.findElement(By.name("course_type_id"))).selectByVisibleText("SCORM 1.2");
    driver.findElement(By.name("Submit")).click();
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ATD");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ACQ");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CLE");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ATD");
    
    log.info("Started AddVersion_30 -- 1");
    
    Select select = new Select(driver.findElement(By.name("key")));
    select.selectByVisibleText("ATD100 JohnP SCORM 2004 V3 Course");
    
    log.info("Started AddVersion_30 -- 2");
    select.deselectAll();
    select.selectByVisibleText("ATD101 ACTD Boot Camp");
    select.deselectAll();
    select.selectByVisibleText("ATD102 JohnP SCORM 2004 V3 Course Test FireAnt");
    select.deselectAll();
    select.selectByVisibleText("ATD100 JohnP SCORM 2004 V3 Course");
    select.deselectAll();
    
    log.info("Started AddVersion_30 -- 3");
    
    // got a stale element exception, so I'm going to refresh here to be safe
    Thread.sleep(2000);
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("AUD");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ACQ");
    
    log.info("Started AddVersion_30 -- 4");
    select = new Select(driver.findElement(By.name("key")));
    select.selectByVisibleText("ACQ000 clg 004");

    log.info("Started AddVersion_30 -- 4.5");
    
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.name("Submit")).click();
    
    log.info("Started AddVersion_30 -- 5");
    
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    
    driver.findElement(By.name("Submit")).click();
    
    select = new Select(driver.findElement(By.name("Instructor")));
    select.deselectAll();
    select.selectByVisibleText("ALLEN, BOOZ");
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | name=Instructor | label=None]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=Instructor | label=ALLEN, BOOZ]]
    
    log.info("Started AddVersion_30 -- 6");
    
    new Select(driver.findElement(By.name("primary"))).selectByVisibleText("LAST NAME 1436, FIRST NAME");
    new Select(driver.findElement(By.name("primary"))).selectByVisibleText("ALLEN, BOOZ");
    driver.findElement(By.name("Submit")).click();
    
    log.info("Started AddVersion_30 -- 7");
    driver.findElement(By.xpath("(//input[@name='Submit'])[2]")).click();
    driver.findElement(By.linkText("View courses")).click();
    
    log.info("Started AddVersion_30 -- 8");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("AUD");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ATD");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ACQ");
    
    log.info("Started AddVersion_30 -- 9");
    
    select = new Select(driver.findElement(By.name("key")));
    select.selectByVisibleText("ACQ000 clg 004");
    
    log.info("Started AddVersion_30 -- 10");
 
	List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'ACQ000 clg 004')]"));
    Assert.assertTrue("ACQ001 ACQ 101 Course", list.size() > 0);
    
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=key | label=ACQ000 clg 004]]
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=dark]]
    
    log.info("completed AddVersion_30!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}
