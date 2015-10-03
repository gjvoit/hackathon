package atlasGroup.atlasID.pages;

import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class FindUser_66 {
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

  // quick change 5
  
  @Test(description="Test Management")
  public void test62TestManagement() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	log.info("got into edit account");
	Thread.sleep(2000);  
	driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
	
	log.info("Started FindUser_66");
	//open menu and click Find User
//	driver.findElement(By.xpath("/html/body/div[2]/div[5]")).click();	
	driver.get(baseUrl + "html/user/FindUserInformation.jsp");
    
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Booz");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Allen");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("temp_dau_id3");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.linkText("Edit")).click();
    log.info("Started FindUser_66 -- 1");
    new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("Internal System");
    new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("Instructor");
    driver.findElement(By.name("Submit")).click();
    new Select(driver.findElement(By.name("fRoleId"))).selectByVisibleText("Instructor");
    new Select(driver.findElement(By.name("rowCount"))).selectByVisibleText("20 hits");
    driver.findElement(By.name("Submit")).click();
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=head]]
    Assert.assertTrue(driver.findElement(By.xpath("html/body/form[2]/table/tbody/tr[2]/th")).getText().contains("List of Users    (20 records found)"));
    log.info("completed FindUser_66!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

}
