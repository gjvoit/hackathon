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

public class ManageSubBrands_72 {
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
  
  @Test(description="ManageSubBrands_72")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started ManageSubBrands_72");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/user/Brand.jsp?type=Sub-Brand");
    
    List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Available Sub-Brand(s)')]"));
    Assert.assertTrue("Available Sub-Brand(s)", list.size() > 0);
    
    driver.findElement(By.name("submit1")).click();
    driver.findElement(By.id("code")).clear();
    driver.findElement(By.id("code")).sendKeys("test");
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("This is a test");
    driver.findElement(By.id("description")).clear();
    driver.findElement(By.id("description")).sendKeys("This is a test");
    driver.findElement(By.id("addbrand")).click();
    
    list = driver.findElements(By.xpath("//*[contains(text(),'This is a test')]"));
    Assert.assertTrue("This is a test", list.size() > 0);
    driver.findElement(By.xpath("(//a[contains(text(),'X')])[5]")).click();
    
    log.info("completed ManageSubBrands_72!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}