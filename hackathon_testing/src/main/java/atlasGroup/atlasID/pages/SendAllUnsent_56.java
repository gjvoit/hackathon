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

public class SendAllUnsent_56 {
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
  
  @Test(description="SendAllUnsent_56")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started SendAllUnsent_56");
	driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/clc/resend/SendFiles.jsp");
    Assert.assertEquals("You are about to send unsent files to clc. Click send if you want to continue.", driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    Assert.assertEquals("Result", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[1]/td")).getText());
    log.info("completed SendAllUnsent_56!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
