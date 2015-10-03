package atlasGroup.atlasID.pages;

import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class ManageFeedback_49 {
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

  @Test(description="ManageFeedback_49")
  public void test21CourseCertificate() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	log.info("started ManageFeedback_49");
	Thread.sleep(2000);  
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/collaborativetools/Feedback/FeedbackSearch.jsp");
    
    driver.findElement(By.name("feedbackFirstName")).clear();
    driver.findElement(By.name("feedbackFirstName")).sendKeys("Booz");
    driver.findElement(By.name("feedbackLastName")).clear();
    driver.findElement(By.name("feedbackLastName")).sendKeys("Allen");
    driver.findElement(By.name("feedbackFromDate")).clear();
    driver.findElement(By.name("feedbackFromDate")).sendKeys("01/01/2015");
    driver.findElement(By.name("feedbackToDate")).clear();
    driver.findElement(By.name("feedbackToDate")).sendKeys("12/12/2015");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    log.info("completed ManageFeedback_49!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
