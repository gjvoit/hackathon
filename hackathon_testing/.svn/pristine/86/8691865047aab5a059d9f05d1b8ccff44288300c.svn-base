package atlasGroup.atlasID.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atlasGroup.atlasID.helperFunctions.BrowserInfo;
import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class AddSections_28_test {
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
  public void AddSections_28(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);

	Reporter.log("- Started AddSections_28 on " + browserInfo.getBrowserShorthand() + "<br>");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/desktop/GetCourses.jsp?fy=2015&prefix=ACQ&key=ACQ000*1210936&prefix=ACQ%09");

    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CLG");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CLM");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("AUD");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ACQ");

    driver.findElement(By.name("key")).sendKeys("ACQ1002 MJTst1002Scorm2004");
    Reporter.log("- Selected course ACQ1002 MJTst1002Scorm2004");

    List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'ACQ1002 MJTst1002Scorm2004')]"));
    Assert.assertTrue("ACQ1002 MJTst1002Scorm2004", list.size() > 0);
    Reporter.log("- Course successfully loaded");

    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CAR");
    driver.findElement(By.name("key")).sendKeys("CAR805 Contemporary Approaches to Acquisition Reform");
    Reporter.log("- Selected course CAR805 Contemporary Approaches to Acquisition Reform");
    
    list = driver.findElements(By.xpath("//*[contains(text(),'CAR805 Contemporary Approaches to Acquisition Reform')]"));
    Assert.assertTrue("CAR805 Contemporary Approaches to Acquisition Reform", list.size() > 0);
    Reporter.log("- Course successfully loaded");

    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ACQ");
    driver.findElement(By.name("key")).sendKeys("ACQ001 ACQ 101 Course");
    Reporter.log("- Selected course ACQ001 ACQ 101 Course");

    list = driver.findElements(By.xpath("//*[contains(text(),'ACQ001 ACQ 101 Course')]"));
    Assert.assertTrue("ACQ001 ACQ 101 Course", list.size() > 0);
    Reporter.log("- Course successfully loaded");

    // click 'Add Section'
    driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/th/a[4]")).click();
    Reporter.log("- Clicked the Add Section link");

    // fill in section attributes
    new Select(driver.findElement(By.name("enrollmentFlag"))).selectByVisibleText("No");
    new Select(driver.findElement(By.name("enrollmentFlag"))).selectByVisibleText("Yes");
    new Select(driver.findElement(By.id("month-fieldmonthdayyear"))).selectByVisibleText("August");
    new Select(driver.findElement(By.id("day-fieldmonthdayyear"))).selectByVisibleText("16");
    driver.findElement(By.id("year-fieldmonthdayyear")).clear();
    driver.findElement(By.id("year-fieldmonthdayyear")).sendKeys("2015");
    new Select(driver.findElement(By.id("day-fieldmonthdayyear"))).selectByVisibleText("17");
    driver.findElement(By.cssSelector("option[value=\"17\"]")).click();
    new Select(driver.findElement(By.id("month-fieldmonth1day1year1"))).selectByVisibleText("August");
    new Select(driver.findElement(By.id("month-fieldmonth1day1year1"))).selectByVisibleText("January");
    new Select(driver.findElement(By.id("day-fieldmonth1day1year1"))).selectByVisibleText("3");
    driver.findElement(By.id("year-fieldmonth1day1year1")).clear();
    driver.findElement(By.id("year-fieldmonth1day1year1")).sendKeys("2020");
    driver.findElement(By.name("maxSize")).clear();
    driver.findElement(By.name("maxSize")).sendKeys("100");
    driver.findElement(By.name("minSize")).clear();
    driver.findElement(By.name("minSize")).sendKeys("1");
    driver.findElement(By.name("sectionNumber")).clear();
    driver.findElement(By.name("sectionNumber")).sendKeys("123641234");
    driver.findElement(By.id("add section")).click();
    Reporter.log("- Added section attributes");

    driver.findElement(By.cssSelector("input[name=\"add\"]")).click();
    Reporter.log("- Clicked Add Section button");

    list = driver.findElements(By.xpath("//*[contains(text(),'SECTION HAS BEEN SUCCESSFULLY CREATED!')]"));
    Assert.assertTrue("SECTION HAS BEEN SUCCESSFULLY CREATED!", list.size() > 0);
    Reporter.log("- Successfully added section to ACQ001 ACQ 101 Course");
    
    driver.findElement(By.id("back")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Section Info')])[2]")).click();
    Reporter.log("- Returned to Section Info page");

    driver.findElement(By.name("Delete")).click();
    Reporter.log("- Clicked the Delete button");

    list = driver.findElements(By.xpath("//*[contains(text(),'ARE YOU SURE YOU WANT TO DELETE THIS SECTION?')]"));
    Assert.assertTrue("ARE YOU SURE YOU WANT TO DELETE THIS SECTION?", list.size() > 0);
    driver.findElement(By.name("Back")).click();
    Reporter.log("- Confirmed section deletion");

    list = driver.findElements(By.xpath("//*[contains(text(),'SECTION HAS BEEN SUCCESSFULLY REMOVED!')]"));
    Assert.assertTrue("SECTION HAS BEEN SUCCESSFULLY REMOVED!", list.size() > 0);
    Reporter.log("- Successfully deleted section from ACQ001 ACQ 101 Course");

    driver.findElement(By.name("Back")).click();
    Reporter.log("- [SUCCESS] Completed AddSections_28!");
  }
  
  @AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
  }

}
