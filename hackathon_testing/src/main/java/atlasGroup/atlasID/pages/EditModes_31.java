package atlasGroup.atlasID.pages;

import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class EditModes_31 {
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

  @Test(description="EditModes_31")
  public void test21CourseCertificate() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	log.info("started EditModes_31");
	Thread.sleep(2000);  
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/desktop/courseAdministration/SelectCourse.jsp?a=um");
    
    Select select = new Select(driver.findElement(By.name("key")));
    select.selectByVisibleText("ACQwww www");
    
    select = new Select(driver.findElement(By.id("modes list")));
    select.selectByVisibleText("Resident");
    
//    driver.findElement(By.xpath("(.//*[@class='aMenu2'][contains(text(),'Edit Modes')])")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=key | label=ACQwww www]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=modes list | label=Resident]]
    driver.findElement(By.name("associate")).click();
    driver.findElement(By.id("add schools to course")).click();
    driver.findElement(By.id("go back")).click();
    driver.findElement(By.linkText("[Disassociate Mode]")).click();
    driver.findElement(By.id("go back")).click();
    driver.findElement(By.linkText("[Disassociate Mode]")).click();
    driver.findElement(By.id("disassociate schools from course")).click();
    driver.findElement(By.id("go back")).click();
    
    log.info("completed EditModes_31!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }


}
