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

public class ReferenceTables_94 {
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
  
  @Test(description="ReferenceTables_94")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started ReferenceTables_94");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
//    driver.get(baseUrl + "html/utilities/admin/reference/AllOwnerValues.jsp");
    driver.findElement(By.linkText("Reference Tables")).click();
    driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/a")).click();
    driver.findElement(By.name("activity_name")).clear();
    driver.findElement(By.name("activity_name")).sendKeys("Add Course - test change");
    driver.findElement(By.name("activity_description")).clear();
    driver.findElement(By.name("activity_description")).sendKeys("User has the ability to add a new course.  - test change");
    driver.findElement(By.name("submit2")).click();
    log.info("Started ReferenceTables_94 -- 1");
    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=message]]
    driver.findElement(By.xpath("//input[@value='Activity List']")).click();
    driver.findElement(By.name("activity_name")).clear();
    driver.findElement(By.name("activity_name")).sendKeys("Add Course");
    driver.findElement(By.name("activity_description")).clear();
    driver.findElement(By.name("activity_description")).sendKeys("User has the ability to add a new course.");
    driver.findElement(By.name("submit2")).click();
    driver.findElement(By.xpath("//input[@value='Activity List']")).click();
    driver.findElement(By.name("submit4")).click();
    log.info("Started ReferenceTables_94 -- 2");
    driver.findElement(By.linkText("Course Prefix Table")).click();
    
    try{
    	log.info("Started ReferenceTables_94 -- 2 - sending keys 1");
    	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/select")).sendKeys("TST");
    } catch (Exception e){
    	try{
    		log.info("Started ReferenceTables_94 -- 2 - sending keys 2");
    		driver.findElement(By.name("courseprefix")).sendKeys("TST");
    	} catch (Exception f){
    		log.info("Started ReferenceTables_94 -- 2.1 - trying to get past regex");
        	new Select(driver.findElement(By.name("courseprefix"))).selectByVisibleText("regexp:*TST*");
            log.info("Started ReferenceTables_94 -- 2.2 - got past regex");
        }
    }
    	
    log.info("Started ReferenceTables_94 -- 2.3 - got past!");
    driver.findElement(By.name("courseprefix_name")).clear();
    driver.findElement(By.name("courseprefix_name")).sendKeys("Test and Evaluation - test change");
    driver.findElement(By.name("submit2")).click();
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    log.info("Started ReferenceTables_94 -- 3");
	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/select")).sendKeys("TST");
    
    log.info("Started ReferenceTables_94 -- 4");
    driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")).clear();
    driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")).sendKeys("value = Test and Evaluation");
    driver.findElement(By.name("submit2")).click();
    
    log.info("Started ReferenceTables_94 -- 5");
//    assertEquals("Prefix has been updated", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    driver.findElement(By.name("submit4")).click();
    driver.findElement(By.linkText("Report Table")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.name("role")).sendKeys("Management");
    driver.findElement(By.name("role")).sendKeys("Course Manager");
    driver.findElement(By.name("role")).sendKeys("Course Manager Regional Rep");
    log.info("Started ReferenceTables_94 -- 6");
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=availableItems | label=Average Waitlist Time]]
    try{
    	log.info("Started ReferenceTables_94 -- 6.2");
    	Select select = new Select(driver.findElement(By.name("availableItems")));
    	select.selectByVisibleText("Average Waitlist Time");
    } catch (Exception e){
    	log.info("Started ReferenceTables_94 -- 6.25");
    	driver.findElement(By.name("availableItems")).sendKeys("Average Waitlist Time");
    }
    
    log.info("Started ReferenceTables_94 -- 6.3");
    driver.findElement(By.name("Add")).click();
    
    driver.findElement(By.name("selectedItems")).sendKeys("Average Waitlist Time");
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=selectedItems | label=Average Waitlist Time]]
    
    driver.findElement(By.name("Remove")).click();
    driver.findElement(By.name("role")).sendKeys("General User");
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=availableItems | label=Activity Audit]]
    
    //add to the right
    try{
    	log.info("Started ReferenceTables_94 -- 6.4");
    	Select select = new Select(driver.findElement(By.name("availableItems")));
    	select.selectByVisibleText("Activity Audit");
    } catch (Exception e){
    	log.info("Started ReferenceTables_94 -- 6.45");
    	driver.findElement(By.name("availableItems")).sendKeys("Activity Audit");
    }
    
    //do it again because now it needs to be brought to the top
    try{
    	log.info("Started ReferenceTables_94 -- 6.4545");
    	Select select = new Select(driver.findElement(By.name("availableItems")));
    	select.selectByVisibleText("Activity Audit");
    } catch (Exception e){
    	log.info("Started ReferenceTables_94 -- 6.4546");
    	driver.findElement(By.name("availableItems")).sendKeys("Activity Audit");
    }
    log.info("Started ReferenceTables_94 -- before clicking add");
    Thread.sleep(5000);
    driver.findElement(By.name("Add")).click();
    
    log.info("Started ReferenceTables_94 -- after clicking add");
    Thread.sleep(5000);
    //take off from the right
    try{
    	log.info("Started ReferenceTables_94 -- 6.5");
    	new Select(driver.findElement(By.name("selectedItems"))).selectByVisibleText("Activity Audit");
    } catch (Exception e){
    	log.info("Started ReferenceTables_94 -- 6.55");
    	driver.findElement(By.name("selectedItems")).sendKeys("Activity Audit");
    }
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=selectedItems | label=Activity Audit]]
    
    driver.findElement(By.name("Remove")).click();
    driver.findElement(By.name("role")).sendKeys("Course Manager");
    
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    
    log.info("Started ReferenceTables_94 -- 7");
    
    driver.get(baseUrl + "html/utilities/admin/reference/ReferenceTableNames.jsp");
    
    driver.findElement(By.linkText("School Table")).click();
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("240 Web, Columbus, OH");
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("231C Web, Boston, MA");
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("231B Web, Huntsville, AL");
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("504C DAU Training Center, Sterling Heights, MI");
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("705 ICAF, Washington, DC");
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("TEST CHANGE");
    driver.findElement(By.name("submit2")).click();
    log.info("Started ReferenceTables_94 -- 8");
//    assertEquals("School has been updated", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    new Select(driver.findElement(By.name("school_info"))).selectByVisibleText("705 ICAF, Washington, DC");
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("none");
    driver.findElement(By.name("submit2")).click();
//    assertEquals("School has been updated", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    driver.findElement(By.xpath("//input[@value='Desktop']")).click();
    log.info("completed ReferenceTables_94!");
    
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
