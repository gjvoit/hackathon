package atlasGroup.atlasID.pages;

import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.junit.Assert;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class ManageSISAdmins_57 {
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

  @Test(description="ManageSISAdmins_57")
  public void test21CourseCertificate() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	log.info("started ManageSISAdmins_57");
	Thread.sleep(2000);  
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/atrrs/admin/ATRRSAdmins.jsp");

    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Booz");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Allen");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("ataas_dau_id");
    new Select(driver.findElement(By.name("fRoleId"))).selectByVisibleText("Tech Administrator");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.name("admin_0")).click();
    driver.findElement(By.name("submit")).click();
    
    log.info("started ManageSISAdmins_57 -- 1");
    
    List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'\"ALLEN, BOOZ\"')]"));
    Assert.assertTrue("\"ALLEN, BOOZ\"", list.size() > 0);
    
    log.info("completed ManageSISAdmins_57!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
