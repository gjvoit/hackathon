package atlasGroup.atlasID.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atlasGroup.atlasID.helperFunctions.BrowserInfo;
import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.helperFunctions.Login_0;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.Reporter;

public class AddSurvey_43_test2 {
  private WebDriver driver;
  private String baseUrl;
  
  @DataProvider
  public Object[][] dp() {
      return new Object[][] { 
    	  { new BrowserInfo("Chrome", "ANY") },
    	  { new BrowserInfo("Firefox", "ANY") },
    	  { new BrowserInfo("internet explorer", "9") },
    	  { new BrowserInfo("internet explorer", "10") },
    	  { new BrowserInfo("internet explorer", "11") }
      };
  }
  
  @Test(dataProvider = "dp")
  public void AddSurvey_43_2(BrowserInfo browserInfo) throws Exception {
	try{
		Reporter.log("- beginning AddSurvey_43_2 on " + browserInfo.getBrowserShorthand() + "<br>");

		SelectDriver selector = new SelectDriver();
		driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
		baseUrl = browserInfo.getBaseURL();
		Login_0 login = new Login_0();
		login.testLogin0(driver);
		Thread.sleep(2000);  
		
	    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
	    driver.get(baseUrl + "html/survey/AddSurveyWizard.jsp");
	
	    Reporter.log("- Started AddSurvey_43 on " + browserInfo.getBrowserShorthand() + "<br>");
	    Reporter.log("- Try creating new survey <br>");
	    
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
	    driver.findElement(By.name("dim_name")).sendKeys("Fake Category");
	   
	    driver.findElement(By.id("continue")).click();
	    driver.findElement(By.name("text")).clear();
	    driver.findElement(By.name("text")).sendKeys("Fake question");
	    
	    Reporter.log("- Created new test survey with category and questions <br>");
	    Reporter.log("- Check that new survey is in database <br>");
	
	    driver.findElement(By.cssSelector("input[name=\"survey\"]")).click();
	
	    //submit question
	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td/input[2]")).click();
	    //choose recently created survey from list to delete
	    Reporter.log("- Ensured test is in the database by selecting it from the survey list. <br>");
	    Reporter.log("- Try to delete test from database <br>");
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
	    
	    Reporter.log("- Deleted survey <br>");
	    Reporter.log("- Try and assert that survey was deleted <br>");
	
	    Assert.assertEquals("Survey has been successfully deleted!", driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText());
	    
	    
	    
	    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
	    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
	    Reporter.log("- Successfully asserted that survey was deleted <br>");
	    Reporter.log("- [SUCCESS] completed AddSurvey_43! <br>");
	    
	    driver.quit();
	} catch(Exception e){
		Reporter.log("- [FAILED] ");
		Assert.assertTrue(e.toString(), false);
		
	}
  }

}
