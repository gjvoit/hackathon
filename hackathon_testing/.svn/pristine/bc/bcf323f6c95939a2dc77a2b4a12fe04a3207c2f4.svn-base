package atlasGroup.atlasID.pages;

import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class SurveyList_44 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private final static Logger log = Logger.getLogger(SurveyList_44.class.getName());

  @Parameters({ "platform","browser","version", "url" })
  @BeforeTest(alwaysRun=true)
  public void setUp(String platform, String browser, String version, String url) throws Exception {
	  SelectDriver selector = new SelectDriver();
	  driver = selector.getDriver(platform, browser, version);
	  baseUrl = url;
  }

  @Test(description="SurveyList_44")
  public void SurveyList() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/survey/EditSurvey.jsp");
    Thread.sleep(2000);
    log.info("Started SurveyList_44");
    new Select(driver.findElement(By.cssSelector("select[name=\"survey\"]"))).selectByVisibleText("something something something something dark side");
    log.info("Started SurveyList_44 -- 1");
    
    driver.findElement(By.name("sumbit")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("something something something something dark side  ... lol");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=message]]
    driver.findElement(By.xpath("//input[@value='Back to Survey List']")).click();
    log.info("Started SurveyList_44 -- 2");
    new Select(driver.findElement(By.cssSelector("select[name=\"survey\"]"))).selectByVisibleText("something something something something dark side ... lol");
    driver.findElement(By.name("sumbit")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("something something something something dark side");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    log.info("Started SurveyList_44 -- 3");
    Assert.assertTrue(driver.findElement(By.xpath("html/body/table[2]/tbody/tr[2]/td/table/tbody/tr/td")).getText().contains("Survey has been successfully updated!"));

    driver.findElement(By.xpath("//input[@value='Back to Survey List']")).click();
    driver.findElement(By.name("not")).click();
    log.info("Started SurveyList_44 -- 4 - should now be in Survey creation");
    Thread.sleep(1000);
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Creating test survey");
    
    driver.findElement(By.name("sumbit")).click();
    driver.findElement(By.name("dim_name")).clear();
    log.info("Started SurveyList_44 -- 5 - should now be in Add Survey Category");
    Thread.sleep(1000);
    driver.findElement(By.name("dim_name")).sendKeys("Test Category");
    log.info("Started SurveyList_44 -- 6 - before changing clicking on surveys");
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("input[name=\"survey\"]")).click();
    driver.findElement(By.name("dim_name")).clear();
    driver.findElement(By.name("dim_name")).sendKeys("Test Category");
    driver.findElement(By.name("category_header")).clear();
    driver.findElement(By.name("category_header")).sendKeys("hmm");
    driver.findElement(By.cssSelector("input[name=\"survey\"]")).click();
    driver.findElement(By.name("dim_name")).clear();
    driver.findElement(By.name("dim_name")).sendKeys("Test Category");
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.name("text")).clear();
    driver.findElement(By.name("text")).sendKeys("Nahh");
    driver.findElement(By.xpath("//input[@value='Survey Details']")).click();
    log.info("Started SurveyList_44 -- 7 - before selecting survey that you will delete");
    driver.findElement(By.xpath("(//input[@name='view'])[2]")).click();
    
    // Sleeping for IE 11
    Thread.sleep(2000);
    
    new Select(driver.findElement(By.cssSelector("select[name=\"survey\"]"))).selectByVisibleText("Creating test survey");
    // delete newly created survey
   
    log.info("Started SurveyList_44 -- 8 - before deleting survey");
//    /html/body/form/table/tbody/tr[6]/td/input[5]
    
    Thread.sleep(2000);
    driver.navigate().refresh();
    try{
    	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/input[@value='Delete Survey']")).click();
    } catch (Exception e){
    	log.info("Started SurveyList_44 -- 8.5 - had an error clicking delete survey");
    	driver.navigate().refresh();
    	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/input[@value='Delete Survey']")).click();

    }
    log.info("Started SurveyList_44 -- 9 - after getting into delete survey");
    driver.findElement(By.name("submit")).click();
    // Assert it was successfully deleted
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText().contains("Survey has been successfully deleted!"));
    driver.findElement(By.xpath("//input[@value='Back to Desktop']")).click();
    
    log.info("completed SurveyList_44!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}
