package atlasGroup.atlasID.pages;

import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class TestManagement_62 {
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

  @Test(description="Test Management")
  public void test62TestManagement() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    
	log.info("starting test Management");
    Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	String browsername = cap.getBrowserName();

	//opens up top window correctly
	driver.findElement(By.xpath("/html/body/div[2]/div[5]")).click();
	log.info("Browser is " + browsername);
	
//	login.closeNewWindow();
	driver.findElement(By.xpath("/html/body/div[16]/table/tbody/tr[1]/td/div/div[3]/span/ul/li[1]/a")).click();

    log.info("past try catch");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CLB");
    log.info("Hurrr 0.1");
    driver.findElement(By.cssSelector("option[value=\"CLB\"]")).click();
    new Select(driver.findElement(By.name("course_info"))).selectByVisibleText("CLB001 Business Management Modernization Program");
    log.info("Hurrr 0.2");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("MAN");
    log.info("Hurrr 0.25");
    driver.findElement(By.cssSelector("option[value=\"MAN\"]")).click();
    log.info("Hurrr 0.3");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("TST");
    driver.findElement(By.cssSelector("option[value=\"TST\"]")).click();
    new Select(driver.findElement(By.name("course_info"))).selectByVisibleText("TST001W Wen's 404");
    log.info("Hurrr 0.4");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("TST");
    new Select(driver.findElement(By.name("course_info"))).selectByVisibleText("TST101ATaaS TST 101 ATaaS");
    log.info("Hurrr 0.5");
    driver.findElement(By.linkText("TST101ATaaS TST 101 ATaaS - Version 2 Active")).click();
    driver.findElement(By.linkText("Add a TLO")).click();
    log.info("Hurrr 0.6");
    new Select(driver.findElement(By.name("lesson_id"))).selectByVisibleText("Introduction");
    driver.findElement(By.name("title")).clear();
    log.info("Hurrr 0.7");
    driver.findElement(By.name("title")).sendKeys("Test TLO");
    driver.findElement(By.name("submit1")).click();
    log.info("Hurrr 0.8");
    driver.findElement(By.linkText("Add a ELO")).click();
    log.info("Hurrr 1");
    new Select(driver.findElement(By.name("tlo_id"))).selectByIndex(1);
    log.info("Hurrr 2");
    driver.findElement(By.name("title")).clear();
    driver.findElement(By.name("title")).sendKeys("Test ELO");

    new Select(driver.findElement(By.name("urladd"))).selectByVisibleText("Introduction");
    driver.findElement(By.name("submit1")).click();
    driver.findElement(By.linkText("Add a QUESTION")).click();
    log.info("Hurrr 3");
    new Select(driver.findElement(By.name("elo_id"))).selectByIndex(1);
    log.info("Hurrr 4");
    new Select(driver.findElement(By.name("Question_type"))).selectByVisibleText("True - False");
    driver.findElement(By.name("submit2")).click();
    driver.findElement(By.name("Question")).clear();
    driver.findElement(By.name("Question")).sendKeys("You had a good day.");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    driver.findElement(By.linkText("Test Hierarchy")).click();
    driver.findElement(By.linkText("You had a good day.")).click();
    log.info("Hurrr 5");
    driver.findElement(By.xpath("//input[@value='Delete']")).click();
    log.info("Hurrr 6");
    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/input[2]")).click();
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    driver.findElement(By.linkText("Test Hierarchy")).click();
    log.info("Hurrr 7");
    driver.findElement(By.linkText("1--Test ELO")).click();
    driver.findElement(By.name("submit3")).click();
    log.info("Hurrr 8");
    driver.findElement(By.name("submit2")).click();
    log.info("Hurrr 9");
    driver.findElement(By.linkText("1--Test TLO")).click();
    driver.findElement(By.name("submit3")).click();
    driver.findElement(By.name("submit2")).click();
    log.info("Hurrr 10");
    
    log.info("completed test Management");
    tearDown();
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }
  

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
