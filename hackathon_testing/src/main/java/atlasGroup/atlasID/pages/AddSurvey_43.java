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

public class AddSurvey_43 {
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
  
  @Test(description="AddSurvey_43")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started AddSurvey_43");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/survey/AddSurveyWizard.jsp");

    //setup survey
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Here's a new test survey");
    driver.findElement(By.name("header")).clear();
    driver.findElement(By.name("header")).sendKeys("Fake header");
    driver.findElement(By.name("footer")).clear();
    driver.findElement(By.name("footer")).sendKeys("Fake footer");
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("Fake description");
    driver.findElement(By.name("sumbit")).click();
    driver.findElement(By.xpath("(//input[@type='button'])[96]")).click();
    driver.findElement(By.xpath("(//input[@type='button'])[200]")).click();
    driver.findElement(By.name("dim_name")).clear();
    driver.findElement(By.name("dim_name")).sendKeys("Fake Categoru");
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.name("text")).clear();
    driver.findElement(By.name("text")).sendKeys("Fake question");

    driver.findElement(By.cssSelector("input[name=\"survey\"]")).click();

    //submit question
    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td/input[2]")).click();
    //choose recently created survey from list to delete
    new Select(driver.findElement(By.cssSelector("select[name=\"survey\"]"))).selectByVisibleText("Here's a new test survey");
    
    // Delete the survey
    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/input[5]")).click();

    Thread.sleep(3000);
    
    try{
    	Assert.assertTrue(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td")).getText().contains("Are you sure you want to delete this survey"));
    } catch (Exception e){
    	List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Are you sure you want to delete this survey?')]"));
        Assert.assertTrue("Are you sure you want to delete this survey?", list.size() > 0);
    }
    driver.findElement(By.name("submit")).click();
    
    try{
    	Assert.assertTrue(driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText().contains("Survey has been successfully deleted!"));
    } catch (Exception f){
    	List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Survey has been successfully deleted!')]"));
        Assert.assertTrue("Are you sure you want to delete this survey?", list.size() > 0);
    }

//    Assert.assertEquals("Survey has been successfully deleted!", driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    log.info("completed AddSurvey_43! ");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}
