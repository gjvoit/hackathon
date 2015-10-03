package atlasGroup.atlasID.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atlasGroup.atlasID.helperFunctions.BrowserInfo;
import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.TestManagement_62;
import atlasGroup.atlasID.helperFunctions.Login_0;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class RefMaintTable_79_test {
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
    	  { new BrowserInfo("internet explorer", "11") }
	  };
  }
  
  @Test(dataProvider = "dp")
  public void RefMaintTable_79(BrowserInfo browserInfo) throws Exception {
	SelectDriver selector = new SelectDriver();
	driver = selector.getDriver(browserInfo.getPlatformName(), browserInfo.getBrowserName(), browserInfo.getVersionNumber());
	baseUrl = browserInfo.getBaseURL();
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	
	Reporter.log("- started RefMaintTable_79 on " + browserInfo.getBrowserShorthand() + "<br>");

	driver.get(baseUrl + "html/utilities/admin/reference/ReferenceTableNames.jsp");
    driver.findElement(By.linkText("Activity Table")).click();
    
    Reporter.log("- entered Activity Table <br>");
    
    driver.findElement(By.name("activity_name")).clear();
    driver.findElement(By.name("activity_name")).sendKeys("Add Course - test change");
    driver.findElement(By.name("activity_description")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
    driver.findElement(By.name("activity_description")).sendKeys("User has the ability to add a new course.  - test change");
    driver.findElement(By.name("submit2")).click();
    Assert.assertEquals("Activity has been updated", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    driver.findElement(By.xpath("//input[@value='Activity List']")).click();
    driver.findElement(By.name("activity_name")).clear();
    driver.findElement(By.name("activity_name")).sendKeys("Add Course");
    driver.findElement(By.name("activity_description")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
    driver.findElement(By.name("activity_description")).sendKeys("User has the ability to add a new course.");
    driver.findElement(By.name("submit2")).click();
    Assert.assertEquals("Activity has been updated", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    
    Reporter.log("- updated 'Add Course' and changed it back <br>");
    
    driver.findElement(By.xpath("//input[@value='Activity List']")).click();
    driver.findElement(By.name("submit1")).click();
    driver.findElement(By.name("activity_name")).clear();
    
    driver.findElement(By.name("activity_name")).sendKeys("z Creating Test Activity for Deletion");
    driver.findElement(By.name("activity_group_id")).sendKeys("Enrollment Management");
    driver.findElement(By.name("activity_group_id")).sendKeys("CollaborativeTools Management");
    driver.findElement(By.name("activity_group_id")).sendKeys("Course Management");
    driver.findElement(By.name("activity_description")).clear();
    driver.findElement(By.name("activity_description")).sendKeys("fake description");
    driver.findElement(By.name("submit1")).click();
    
    Thread.sleep(2000);
    
    Reporter.log("- created activity 'Test Activity for Deletion' in Activity List <br>");
    List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Activity has been added')]"));
    Assert.assertTrue("Activity has been added!", list.size() > 0);
    Reporter.log("- successfully added new activity in Activity List <br>");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value='Activity List']")).click();
    
    driver.findElement(By.name("courseprefix")).sendKeys("z Creating Test Activity for Deletion");
    driver.findElement(By.name("submit3")).click();
    list = driver.findElements(By.xpath("//*[contains(text(),'Activity has been deleted')]"));
    Assert.assertTrue("Activity has been deleted!", list.size() > 0);
    Reporter.log("- successfully deleted new activity in Activity List <br>");
    
    driver.findElement(By.xpath("//input[@value='Desktop']")).click();
    driver.get(baseUrl + "html/utilities/admin/reference/ReferenceTableNames.jsp");
    driver.findElement(By.linkText("Course Prefix Table")).click();
    
    Reporter.log("- entered Course Prefix Table <br>");
    
    driver.findElement(By.name("courseprefix")).sendKeys("TST");
    Thread.sleep(1000);
    driver.findElement(By.name("courseprefix_name")).clear();
    driver.findElement(By.name("courseprefix_name")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
    Thread.sleep(1000);
    driver.findElement(By.name("courseprefix_name")).sendKeys("Test and Evaluation - test change");
    Thread.sleep(1000);
    driver.findElement(By.name("submit2")).click();
    Assert.assertEquals("Prefix has been updated", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    
    Reporter.log("- updated a prefix description in Course Prefix <br>");
    
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    driver.findElement(By.name("courseprefix")).sendKeys("TST");
    driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")).clear();
    driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
    driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")).sendKeys("Test and Evaluation");
    driver.findElement(By.name("submit2")).click();
    Assert.assertEquals("Prefix has been updated", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    
    Reporter.log("- reverted back the changes to prefix description in Course Prefix <br>");
    
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    driver.findElement(By.name("submit4")).click();
    driver.findElement(By.linkText("Report Table")).click();
    
    Reporter.log("- entered Report Table <br>");
    
    log.info("huur 1");
    driver.findElement(By.name("role")).sendKeys("Management");
    log.info("huur 2");
    Thread.sleep(1000);
    driver.findElement(By.name("role")).sendKeys("Course Manager");
    log.info("huur 3");
    Thread.sleep(1000);
    driver.findElement(By.name("role")).sendKeys("Course Manager Regional Rep");
    log.info("huur 4");
    Thread.sleep(1000);
    
    int var = 0;
    log.info(" : " + Integer.toString(var)); var = var + 1;
    
    Reporter.log("- navigated prefixes in Report Table <br>");
    
    log.info(" : " + Integer.toString(var)); var = var + 1;
    
    //2
    driver.findElement(By.name("availableItems")).sendKeys("Average Waitlist Time");
    log.info(" : " + Integer.toString(var)); var = var + 1;
    driver.findElement(By.name("Add")).click();
    log.info(" : " + Integer.toString(var)); var = var + 1;
    driver.findElement(By.name("selectedItems")).sendKeys("Average Waitlist Time");
    log.info(" : " + Integer.toString(var)); var = var + 1;
    driver.findElement(By.name("Remove")).click();
    log.info(" : " + Integer.toString(var)); var = var + 1;
    
    Reporter.log("- added and removed 'Average Waitlist Time' from Course Manager Regional Rep <br>");
    //6
    log.info(" : " + Integer.toString(var)); var = var + 1;
    
    Thread.sleep(3000);
    driver.navigate().refresh();
    driver.findElement(By.name("role")).sendKeys("General User");
    //7
    log.info(" : " + Integer.toString(var)); var = var + 1;
    Thread.sleep(3000);
    
    driver.findElement(By.name("availableItems")).sendKeys("Activity Audit");
    log.info(" : " + Integer.toString(var)); var = var + 1;
    driver.findElement(By.name("Add")).click();
    log.info(" : " + Integer.toString(var)); var = var + 1;
    driver.findElement(By.name("selectedItems")).sendKeys("Activity Audit");
    log.info(" : " + Integer.toString(var)); var = var + 1;
    driver.findElement(By.name("Remove")).click();
    log.info(" : " + Integer.toString(var)); var = var + 1;
    
    Reporter.log("- added and removed 'Activity Audit' from General User <br>");

    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/utilities/admin/reference/ReferenceTableNames.jsp");
    driver.findElement(By.linkText("School Table")).click();
    
    Reporter.log("- entered into School Table <br>");
    
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("240 Web, Columbus, OH");
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("231C Web, Boston, MA");
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("231B Web, Huntsville, AL");
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("504C DAU Training Center, Sterling Heights, MI");
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("705 ICAF, Washington, DC");
    
    Reporter.log("- navigated prefixes in School Table <br>");
    
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("TEST CHANGE");
    driver.findElement(By.name("submit2")).click();
    Assert.assertEquals("School has been updated", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    
    Reporter.log("- updated description of 705 ICAF, Washington, DC <br>");
    
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("705 ICAF, Washington, DC");
    Assert.assertEquals("TEST CHANGE", driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]/textarea")).getText());
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("none");
    driver.findElement(By.name("submit2")).click();
    Assert.assertEquals("School has been updated", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    
    Reporter.log("- reverted back the change <br>");
    
    driver.findElement(By.xpath("//input[@value='Desktop']")).click();
    
    Reporter.log("- [SUCCESS] completed RefMaintTable_79! <br>");
    
    driver.quit();
  }
}
