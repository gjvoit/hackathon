package atlasGroup.atlasID.pages;

import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class ManageLoginText_77 {
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

  @Test(description="ManageLoginText_77")
  public void test21CourseCertificate() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	log.info("started ManageLoginText_77");
	Thread.sleep(2000);  
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/login/publicSite/LoginText.jsp");
    
    driver.findElement(By.xpath("(//a[contains(text(),'[Update]')])[5]")).click();
    driver.findElement(By.name("text")).clear();
    driver.findElement(By.name("text")).sendKeys("Text");
    driver.findElement(By.name("text")).clear();
    driver.findElement(By.name("text")).sendKeys("Text text change");
    driver.findElement(By.name("sumbit")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'[Update]')])[5]")).click();
    driver.findElement(By.name("text")).clear();
    driver.findElement(By.name("text")).sendKeys("Text");
    driver.findElement(By.name("sumbit")).click();
    driver.findElement(By.name("not")).click();
    
    log.info("completed ManageLoginText_77!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
