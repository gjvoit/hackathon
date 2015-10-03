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

public class MergeAccounts_68 {
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
  
  @Test(description="MergeAccounts_68")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started MergeAccounts_68");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/user/FindStudentMerge.jsp");
    
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Booz");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Allen");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("temp_dau_id4");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.name("userradio")).click();
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Booz");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Allen");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("temp_dau_id4");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.name("seconduserradio")).click();
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.name("primary")).click();
    driver.findElement(By.name("Logout")).click();
    
    List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Roster records for the following individuals have been merged')]"));
    Assert.assertTrue("Roster records for the following individuals have been merged", list.size() > 0);
    
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    log.info("completed MergeAccounts_68");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}