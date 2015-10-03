package atlasGroup.atlasID.pages;

import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class LegacyUsernameMapping_67 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private final static Logger log = Logger.getLogger(LegacyUsernameMapping_67.class.getName());

  @Parameters({ "platform","browser","version", "url" })
  @BeforeTest(alwaysRun=true)
  public void setUp(String platform, String browser, String version, String url) throws Exception {
	  SelectDriver selector = new SelectDriver();
	  driver = selector.getDriver(platform, browser, version);
	  baseUrl = url;
  }

  @Test(description="Legacy Username Mapping")
  public void test67LegacyUsernameMapping() throws Exception {
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "/html/help/userMapping/SearchStudent.jsp");
    
    // assertEquals("User Mapping between Legacy User Name and DAU ID", driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td")).getText());
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("Booz");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("Allen");
    driver.findElement(By.name("dauId")).clear();
    driver.findElement(By.name("dauId")).sendKeys("ataas_dau_id");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    // assertEquals("No records were found that match your search criteria. Please try again.", driver.findElement(By.xpath(".//*[@id='userTable']/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    driver.findElement(By.name("dauId")).clear();
    driver.findElement(By.name("dauId")).sendKeys("");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    // assertEquals("TECHADMIN", driver.findElement(By.xpath("/html/body/form[2]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td[3]")).getText());
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("");
    driver.findElement(By.name("dauId")).clear();
    driver.findElement(By.name("dauId")).sendKeys("temp_dau_id");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}
