package atlasGroup.atlasID.tests;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
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

public class CLCResend_55_test {
  private WebDriver driver;
  private String baseUrl;

  
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
  public void CLCResend_55(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	Reporter.log("- Started CLCResend_55 <br>");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/clc/resend/SearchStudent.jsp");
    
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Booz");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Allen");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("temp_dau_id4");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.name("userEmailData")).click();
    driver.findElement(By.name("submit")).click();
    Reporter.log("- Searched for Booz Allen with id of temp_dau_id4 <br>");
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    driver.findElement(By.name("resendFlag")).click();
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    Assert.assertEquals("Resend Confirmation...", driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]")).getText());
    driver.findElement(By.name("continue")).click();
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("Booz");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("Allen");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("booz");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("allen");
    new Select(driver.findElement(By.name("course"))).selectByVisibleText("ACQasfasfas2fasfasfasf - ACQ-ASFASFAS2");
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    driver.findElement(By.linkText("Course Utilities")).click();
    driver.findElement(By.linkText("System Utilities")).click();
    driver.findElement(By.linkText("Course Utilities")).click();
  }
  
  @AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
  }
}
