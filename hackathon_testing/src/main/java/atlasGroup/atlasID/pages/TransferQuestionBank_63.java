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

public class TransferQuestionBank_63 {
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
  
  @Test(description="TransferQuestionBank_63")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started TransferQuestionBank_63");
	driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/testengine/TransferQuestionBank.jsp");

    Assert.assertEquals("Transfer Question Bank", driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]")).getText());
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    new Select(driver.findElement(By.name("target_course_id"))).selectByVisibleText("ACQ001");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    new Select(driver.findElement(By.name("target_course_id"))).selectByVisibleText("ACQ101W");
    new Select(driver.findElement(By.name("source_course_id"))).selectByVisibleText("ACQ11081007");
    new Select(driver.findElement(By.name("source_course_id"))).selectByVisibleText("ACQ101");
    driver.findElement(By.xpath("//input[@value='Transfer Question Bank']")).click();
    log.info("completed TransferQuestionBank_63!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}
