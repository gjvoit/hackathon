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

public class NewFeedback_48 {
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
  
  @Test(description="NewFeedback_48")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started NewFeedback_48");
	driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/collaborativetools/Feedback/FeedbackRoot.jsp");
    
    Thread.sleep(4000);
    // make sure you're on the right page
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id='feedbackform']/table/tbody/tr[1]/td")).getText().contains("FEEDBACK"));
    
    // and right user
    Assert.assertEquals("BOOZ2 ALLEN", driver.findElement(By.xpath(".//*[@id='feedbackform']/table/tbody/tr[7]/td/table/tbody/tr[1]/td[2]")).getText());

    log.info("Started NewFeedback_48 -- 1");

    new Select(driver.findElement(By.name("course_prefix"))).selectByVisibleText("TST");
    new Select(driver.findElement(By.name("course_info"))).selectByVisibleText("TST101ATaaS TST 101 ATaaS");
    log.info("Started NewFeedback_48 -- 3");
    driver.findElement(By.name("message")).clear();
    driver.findElement(By.name("message")).sendKeys("Here is your test feedback");
    driver.findElement(By.name("submit1")).click();
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td")).getText().contains("Thank you for your feedback!"));
    
    // no need to click on 'close' button because it's not a new window
    // driver.findElement(By.cssSelector("input.orangeDefaultSize.hideButton")).click();
    // driver.findElement(By.name("subject")).click();
    
    // now let's check to make sure that survey is there and delete it 
    log.info("Started NewFeedback_48 -- 4");
    driver.get(baseUrl + "html/collaborativetools/Feedback/FeedbackSearch.jsp");
    
    driver.findElement(By.name("feedbackFirstName")).clear();
    driver.findElement(By.name("feedbackFirstName")).sendKeys("Booz");
    driver.findElement(By.name("feedbackLastName")).clear();
    driver.findElement(By.name("feedbackLastName")).sendKeys("Allen");
    driver.findElement(By.name("feedbackFromDate")).clear();
    driver.findElement(By.name("feedbackFromDate")).sendKeys("01/01/2015");
    driver.findElement(By.name("feedbackToDate")).clear();
    driver.findElement(By.name("feedbackToDate")).sendKeys("12/12/2025");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    log.info("Started NewFeedback_48 -- 5");
    // click the first delete you see, there should only be one though.
    driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[1]/td/table/tbody/tr[2]/td[5]/a")).click();
    driver.findElement(By.name("submit1")).click();
    log.info("completed NewFeedback_48!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}
