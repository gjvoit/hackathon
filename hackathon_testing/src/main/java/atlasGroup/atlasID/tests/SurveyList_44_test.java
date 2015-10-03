package atlasGroup.atlasID.tests;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atlasGroup.atlasID.helperFunctions.BrowserInfo;
import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;
import atlasGroup.atlasID.pages.TestManagement_62;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class SurveyList_44_test {
  private WebDriver driver;
  private String baseUrl;
  private final static Logger log = Logger.getLogger(TestManagement_62.class.getName());

  
  @DataProvider
  public Object[][] dp() {
      return new Object[][] { 
    	  { new BrowserInfo("Chrome", "ANY") }, 
    	  { new BrowserInfo("Firefox", "ANY") },
    	  { new BrowserInfo("internet explorer", "9") },
    	  { new BrowserInfo("internet explorer", "10") },
    	  { new BrowserInfo("internet explorer", "11") }};
  }
  
  @Test(dataProvider = "dp")
  public void SurveyList_44(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	Reporter.log("- Started SurveyList_44 <br>");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/survey/EditSurvey.jsp");
    Thread.sleep(2000);
    Reporter.log("Started SurveyList_44");
    new Select(driver.findElement(By.cssSelector("select[name=\"survey\"]"))).selectByVisibleText("something something something something dark side");
    Reporter.log("Started SurveyList_44 -- 1");
    
    driver.findElement(By.name("sumbit")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("something something something something dark side  ... lol");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=message]]
    driver.findElement(By.xpath("//input[@value='Back to Survey List']")).click();
    Reporter.log("Started SurveyList_44 -- 2");
    new Select(driver.findElement(By.cssSelector("select[name=\"survey\"]"))).selectByVisibleText("something something something something dark side ... lol");
    driver.findElement(By.name("sumbit")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("something something something something dark side");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    Reporter.log("Started SurveyList_44 -- 3");
    Assert.assertTrue(driver.findElement(By.xpath("html/body/table[2]/tbody/tr[2]/td/table/tbody/tr/td")).getText().contains("Survey has been successfully updated!"));

    driver.findElement(By.xpath("//input[@value='Back to Survey List']")).click();
    driver.findElement(By.name("not")).click();
    Reporter.log("Started SurveyList_44 -- 4 - should now be in Survey creation");
    Thread.sleep(1000);
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Creating test survey");
    
    driver.findElement(By.name("sumbit")).click();
    driver.findElement(By.name("dim_name")).clear();
    Reporter.log("Started SurveyList_44 -- 5 - should now be in Add Survey Category");
    Thread.sleep(1000);
    driver.findElement(By.name("dim_name")).sendKeys("Test Category");
    Reporter.log("Started SurveyList_44 -- 6 - before changing clicking on surveys");
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
    Reporter.log("Started SurveyList_44 -- 7 - before selecting survey that you will delete");
    driver.findElement(By.xpath("(//input[@name='view'])[2]")).click();
    
    // Sleeping for IE 11
    Thread.sleep(2000);
    
    new Select(driver.findElement(By.cssSelector("select[name=\"survey\"]"))).selectByVisibleText("Creating test survey");
    // delete newly created survey
   
    Reporter.log("Started SurveyList_44 -- 8 - before deleting survey");
    // /html/body/form/table/tbody/tr[6]/td/input[5]
    
    Thread.sleep(2000);
    driver.navigate().refresh();
    try{
    	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/input[@value='Delete Survey']")).click();
    } catch (Exception e){
    	Reporter.log("Started SurveyList_44 -- 8.5 - had an error clicking delete survey");
    	driver.navigate().refresh();
    	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/input[@value='Delete Survey']")).click();

    }
    Reporter.log("Started SurveyList_44 -- 9 - after getting into delete survey");
    driver.findElement(By.name("submit")).click();
    // Assert it was successfully deleted
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText().contains("Survey has been successfully deleted!"));
    driver.findElement(By.xpath("//input[@value='Back to Desktop']")).click();
    
    Reporter.log("completed SurveyList_44!");
    driver.quit();
  }

}
