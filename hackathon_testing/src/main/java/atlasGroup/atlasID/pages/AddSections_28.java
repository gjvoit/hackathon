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

public class AddSections_28 {
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
  
  @Test(description="AddSections_28")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started AddSections_28");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/desktop/GetCourses.jsp?fy=2015&prefix=ACQ&key=ACQ000*1210936&prefix=ACQ%09");
    
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CLG");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CLM");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("AUD");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ACQ");

    driver.findElement(By.name("key")).sendKeys("ACQ1002 MJTst1002Scorm2004");

    List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'ACQ1002 MJTst1002Scorm2004')]"));
    Assert.assertTrue("ACQ1002 MJTst1002Scorm2004", list.size() > 0);
    
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CAR");

    driver.findElement(By.name("key")).sendKeys("CAR805 Contemporary Approaches to Acquisition Reform");
    
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ACQ");
    
    driver.findElement(By.name("key")).sendKeys("ACQ001 ACQ 101 Course");
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=key | label=ACQ001 ACQ 101 Course]]
    
    
    list = driver.findElements(By.xpath("//*[contains(text(),'ACQ001 ACQ 101 Course')]"));
    Assert.assertTrue("ACQ001 ACQ 101 Course", list.size() > 0);
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=dark]]
    

    //click 'Add Section'
    driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/th/a[4]")).click();
    new Select(driver.findElement(By.name("enrollmentFlag"))).selectByVisibleText("No");
    new Select(driver.findElement(By.name("enrollmentFlag"))).selectByVisibleText("Yes");
    new Select(driver.findElement(By.id("month-fieldmonthdayyear"))).selectByVisibleText("August");
    new Select(driver.findElement(By.id("day-fieldmonthdayyear"))).selectByVisibleText("16");
    driver.findElement(By.id("year-fieldmonthdayyear")).clear();
    driver.findElement(By.id("year-fieldmonthdayyear")).sendKeys("2015");
    new Select(driver.findElement(By.id("day-fieldmonthdayyear"))).selectByVisibleText("17");
    
    driver.findElement(By.cssSelector("option[value=\"17\"]")).click();
    new Select(driver.findElement(By.id("month-fieldmonth1day1year1"))).selectByVisibleText("August");
    new Select(driver.findElement(By.id("month-fieldmonth1day1year1"))).selectByVisibleText("January");
    new Select(driver.findElement(By.id("day-fieldmonth1day1year1"))).selectByVisibleText("3");
    driver.findElement(By.id("year-fieldmonth1day1year1")).clear();
    driver.findElement(By.id("year-fieldmonth1day1year1")).sendKeys("2020");
    driver.findElement(By.name("maxSize")).clear();
    driver.findElement(By.name("maxSize")).sendKeys("100");
    driver.findElement(By.name("minSize")).clear();
    driver.findElement(By.name("minSize")).sendKeys("1");

    driver.findElement(By.name("sectionNumber")).clear();
    driver.findElement(By.name("sectionNumber")).sendKeys("123641234");
    log.info("Started AddSections_28 -- Before clicking to add section");
    driver.findElement(By.id("add section")).click();
    log.info("Started AddSections_28 -- Was able to add section");
    driver.findElement(By.cssSelector("input[name=\"add\"]")).click();
    
    list = driver.findElements(By.xpath("//*[contains(text(),'SECTION HAS BEEN SUCCESSFULLY CREATED!')]"));
    Assert.assertTrue("SECTION HAS BEEN SUCCESSFULLY CREATED!", list.size() > 0);
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=message]]
    driver.findElement(By.id("back")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Section Info')])[2]")).click();
    driver.findElement(By.name("Delete")).click();
    
    list = driver.findElements(By.xpath("//*[contains(text(),'ARE YOU SURE YOU WANT TO DELETE THIS SECTION?')]"));
    Assert.assertTrue("ARE YOU SURE YOU WANT TO DELETE THIS SECTION?", list.size() > 0);
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=message]]
    
    driver.findElement(By.name("Back")).click();
    
    list = driver.findElements(By.xpath("//*[contains(text(),'SECTION HAS BEEN SUCCESSFULLY REMOVED!')]"));
    Assert.assertTrue("SECTION HAS BEEN SUCCESSFULLY REMOVED!", list.size() > 0);
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=MESSAGE]]

    
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.name("Back")).click();
    log.info("completed AddSections_28!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();

  }
}
