package atlasGroup.atlasID.pages;

import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class ServerSession_80_82 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private final static Logger log = Logger.getLogger(ServerSession_80_82.class.getName());

  @Parameters({ "platform","browser","version", "url" })
  @BeforeTest(alwaysRun=true)
  public void setUp(String platform, String browser, String version, String url) throws Exception {
	  SelectDriver selector = new SelectDriver();
	  driver = selector.getDriver(platform, browser, version);
	  baseUrl = url;
  }

  @Test(description="Reset Server Session")
  public void test8082ServerSession() throws Exception {
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    driver.findElement(By.xpath("(.//*[@class='aMenu1'][contains(text(),'Server Session')])")).click();
    driver.get(baseUrl + "/html/desktop/links/LinkMenu.jsp?id=sub347");
    driver.findElement(By.xpath("(//a[contains(text(),'Reset Server Session')])[2]")).click();
    driver.findElement(By.xpath("(//input[@id='search'])[2]")).click();
    driver.findElement(By.id("search")).click();
    driver.get(baseUrl + "/html/desktop/links/LinkMenu.jsp?id=sub347");
    driver.findElement(By.xpath("(//a[contains(text(),'Reset Scorm Objects')])[2]")).click();
    driver.findElement(By.xpath("(//input[@id='search'])[2]")).click();
    driver.findElement(By.id("search")).click();
    driver.get(baseUrl + "/html/desktop/links/LinkMenu.jsp?id=sub347");
    driver.findElement(By.xpath("(//a[contains(text(),'Reset Translation Objects')])[2]")).click();
    driver.findElement(By.id("search")).click();
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}
