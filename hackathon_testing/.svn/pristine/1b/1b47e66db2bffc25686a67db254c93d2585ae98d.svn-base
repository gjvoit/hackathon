package atlasGroup.atlasID.pages;

import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class AddSchool_29 {
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
  
  @Test(description="AddSchool_29")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started AddSchool_29");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/desktop/courseAdministration/SelectCourse.jsp?a=sa");
    
    driver.findElement(By.name("key")).sendKeys("ACQ000 clg 004");
    driver.findElement(By.id("schools")).sendKeys("705 ICAF, Washington, DC");
    driver.findElement(By.id("associate user")).click();
    driver.findElement(By.id("go back")).click();
    
    driver.findElement(By.id("schools")).sendKeys("231B Web, Huntsville, AL");
    driver.findElement(By.id("associate user")).click();
    driver.findElement(By.id("go back")).click();
    
    driver.findElement(By.id("schools")).sendKeys("705 ICAF, Washington, DC");
    driver.findElement(By.id("associate user")).click();
    driver.findElement(By.id("add schools to course")).click();
    driver.findElement(By.id("go back")).click();
    driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td/li[1]/a")).click();
    driver.findElement(By.id("disassociate schools from course")).click();
    driver.findElement(By.id("go back")).click();
    log.info("completed AddSchool_29!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
