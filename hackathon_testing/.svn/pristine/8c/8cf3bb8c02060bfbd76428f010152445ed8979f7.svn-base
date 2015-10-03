package atlasGroup.atlasID.pages;

import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class CourseCertificate_21 {
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
  
  @Test(description="Course Certificate")
  public void test21CourseCertificate() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	log.info("got into edit account");
	Thread.sleep(2000);  
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "/html/course/certificate/CourseCertificateMap.jsp");
    driver.findElement(By.xpath("(//input[@name='1210936'])[2]")).click();
    driver.findElement(By.name("1210936")).click();
    new Select(driver.findElement(By.id("_1210936"))).selectByVisibleText("ETMDS Cert");
    new Select(driver.findElement(By.id("_1210936"))).selectByVisibleText("JKDDC-JCC Cert");
    new Select(driver.findElement(By.id("_1210936"))).selectByVisibleText("System Default");
    driver.findElement(By.cssSelector("input[name=\"map\"]")).click();
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText().contains("No changes have been made!"));
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "/html/course/certificate/CourseCertificateMap.jsp");
    driver.findElement(By.xpath("(//input[@name='1209755'])[2]")).click();
    driver.findElement(By.cssSelector("input[name=\"map\"]")).click();
    Assert.assertTrue(driver.findElement(By.xpath("//td[@class='textBlue']")).getText().contains("The following courses will not track certificates anymore"));
    driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr[2]/td/input[2]")).click();
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText().contains("Course Map has been updated successfully"));
    driver.findElement(By.xpath("html/body/table[5]/tbody/tr[3]/td/input")).click();
    driver.get(baseUrl + "/html/course/certificate/CourseCertificateMap.jsp");
    driver.findElement(By.xpath("(//input[@name='1209755'])[2]")).click();
    driver.findElement(By.name("1209755")).click();
    driver.findElement(By.cssSelector("input[name=\"map\"]")).click();
    Assert.assertTrue(driver.findElement(By.xpath("//td[@class='textBlue']")).getText().contains("The following courses will track certificates"));
    driver.findElement(By.xpath("html/body/table[5]/tbody/tr[2]/td/table/tbody/tr[2]/td/input[2]")).click();
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText().contains("Course Map has been updated successfully"));
    driver.findElement(By.xpath("html/body/table[5]/tbody/tr[3]/td/input")).click();
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
