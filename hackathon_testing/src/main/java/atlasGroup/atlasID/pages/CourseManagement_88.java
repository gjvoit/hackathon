package atlasGroup.atlasID.pages;

import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import atlasGroup.atlasID.helperFunctions.SelectDriver;
import atlasGroup.atlasID.pages.Login_0;

public class CourseManagement_88 {
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

  @Test(description="CourseManagement_88")
  public void test21CourseCertificate() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	log.info("started CourseManagement_88");
	Thread.sleep(2000);  
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    
    driver.findElement(By.linkText("Course Management Wizard")).click();
    new Select(driver.findElement(By.name("course_type_id"))).selectByVisibleText("SCORM 2004 - Repository");
    new Select(driver.findElement(By.name("course_type_id"))).selectByVisibleText("SCORM 2004");
    new Select(driver.findElement(By.name("course_type_id"))).selectByVisibleText("MOVE");
    new Select(driver.findElement(By.name("course_type_id"))).selectByVisibleText("Blackboard");
    new Select(driver.findElement(By.name("course_type_id"))).selectByVisibleText("SCORM 1.2");
    driver.findElement(By.cssSelector("p > input[name=\"add_what\"]")).click();
    driver.findElement(By.name("add_what")).click();
    driver.findElement(By.name("Submit")).click();
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CLM");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("CLB");
    new Select(driver.findElement(By.name("prefix"))).selectByVisibleText("ACQ");
    driver.findElement(By.name("courseNumber")).clear();
    driver.findElement(By.name("courseNumber")).sendKeys("12348");
    driver.findElement(By.name("suffix")).clear();
    driver.findElement(By.name("suffix")).sendKeys("M");
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Nat");
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Test Course");
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("this is a test course");
    new Select(driver.findElement(By.name("milCareerFieldId"))).selectByVisibleText("23-CONContracting");
    new Select(driver.findElement(By.name("requestApprovalTypeId"))).selectByVisibleText("Manager Approval");
    new Select(driver.findElement(By.name("certificate"))).selectByVisibleText("No");
    new Select(driver.findElement(By.name("certificate"))).selectByVisibleText("Yes");
    driver.findElement(By.name("clc")).clear();
    driver.findElement(By.name("clc")).sendKeys("nonsense");
    new Select(driver.findElement(By.id("pre course material"))).selectByVisibleText("Yes");
    driver.findElement(By.id("days")).clear();
    driver.findElement(By.id("days")).sendKeys("3");
    driver.findElement(By.id("daysAfter")).clear();
    driver.findElement(By.id("daysAfter")).sendKeys("5");
    driver.findElement(By.id("BrowseEnabledFlag")).click();
    driver.findElement(By.id("courseHours")).clear();
    driver.findElement(By.id("courseHours")).sendKeys("1000");
    driver.findElement(By.name("objective1")).clear();
    driver.findElement(By.name("objective1")).sendKeys("Become the best!");
    driver.findElement(By.name("Submit")).click();
    
    log.info("started CourseManagement_88 -- 2");
    Select select = new Select(driver.findElement(By.name("modes")));
    select.selectByVisibleText("CLC");
    
//    select.deselectAll();
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=modes | label=CLC]]
    driver.findElement(By.name("Submit")).click();
    
    select = new Select(driver.findElement(By.name("CourseAdministrator")));
    select.selectByVisibleText("CLC");
    
//    select.deselectAll();
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=CourseAdministrator | label=Last name 3363, First name]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=CourseAdministrator | label=Chi, Ras]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | name=CourseAdministrator | label=Last name 3363, First name]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | name=CourseAdministrator | label=Chi, Ras]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=CourseAdministrator | label=Chi, Ras]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=CourseReviewers | label=Etmds, Course reviewer]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | name=CourseReviewers | label=Etmds, Course reviewer]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=CourseReviewers | label=Klein, Sean]]
    driver.findElement(By.name("Submit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=schools | label=904 - DAUNorfolk- 904 Web, Norfolk, VA]]
    driver.findElement(By.name("Submit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | name=prerequisiteCourses | label=NO PREREQUISITE]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=prerequisiteCourses | label=ACQ001 - ACQ 101 Course]]
    driver.findElement(By.name("Submit")).click();
    new Select(driver.findElement(By.name("survey"))).selectByVisibleText("Gabes1104 1351");
    new Select(driver.findElement(By.name("flag"))).selectByVisibleText("No");
    new Select(driver.findElement(By.name("flag"))).selectByVisibleText("Yes");
    driver.findElement(By.name("note")).clear();
    driver.findElement(By.name("note")).sendKeys("Test survey");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.name("ceu")).clear();
    driver.findElement(By.name("ceu")).sendKeys("24");
    new Select(driver.findElement(By.id("month-fieldmonthdayyear"))).selectByVisibleText("February");
    new Select(driver.findElement(By.id("day-fieldmonthdayyear"))).selectByVisibleText("8");
    driver.findElement(By.id("year-fieldmonthdayyear")).clear();
    driver.findElement(By.id("year-fieldmonthdayyear")).sendKeys("2016");
    driver.findElement(By.name("Submit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=pds | label=BDQ - DAU CON101 FUNDAMENTALS OF CONTRACTING]]
    driver.findElement(By.name("Submit")).click();
    new Select(driver.findElement(By.name("waitlist_process_type_id"))).selectByVisibleText("First Come, First Serve");
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("10");
    new Select(driver.findElement(By.name("delivery_mode"))).selectByVisibleText("Self paced");
    driver.findElement(By.name("passwordDescription")).clear();
    driver.findElement(By.name("passwordDescription")).sendKeys("asdf");
    driver.findElement(By.name("passwordDescription")).clear();
    driver.findElement(By.name("passwordDescription")).sendKeys("test");
    driver.findElement(By.name("enrollmentPassword")).clear();
    driver.findElement(By.name("enrollmentPassword")).sendKeys("test");
    driver.findElement(By.name("who_attend")).clear();
    driver.findElement(By.name("who_attend")).sendKeys("Everyone welcome to the great test");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.name("section_number")).clear();
    driver.findElement(By.name("section_number")).sendKeys("asfd1");
    new Select(driver.findElement(By.id("month-fieldmonthdayyear"))).selectByVisibleText("March");
    new Select(driver.findElement(By.id("day-fieldmonthdayyear"))).selectByVisibleText("5");
    driver.findElement(By.name("section_status_id")).click();
    driver.findElement(By.id("year-fieldmonthdayyear")).clear();
    driver.findElement(By.id("year-fieldmonthdayyear")).sendKeys("2016");
    new Select(driver.findElement(By.id("month-fieldmonth1day1year1"))).selectByVisibleText("December");
    new Select(driver.findElement(By.id("day-fieldmonth1day1year1"))).selectByVisibleText("7");
    driver.findElement(By.id("year-fieldmonth1day1year1")).clear();
    driver.findElement(By.id("year-fieldmonth1day1year1")).sendKeys("2016");
    driver.findElement(By.name("disable_auto_fail_flag")).click();
    driver.findElement(By.name("disable_auto_fail_flag")).click();
    driver.findElement(By.name("max_size")).clear();
    driver.findElement(By.name("max_size")).sendKeys("1000");
    driver.findElement(By.name("min_size")).clear();
    driver.findElement(By.name("min_size")).sendKeys("15");
    driver.findElement(By.name("Submit")).click();
    new Select(driver.findElement(By.name("primary"))).selectByVisibleText("ALLEN, BOOZ");
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | name=Instructor | label=None]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=Instructor | label=1111, FIRST NAME]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | name=Instructor | label=1111, FIRST NAME]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=Instructor | label=ALLEN, BOOZ]]
    driver.findElement(By.name("Submit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | name=Instructor | label=None]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=Instructor | label=BAH, TECHADMIN125]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | name=Instructor | label=ALLEN, BOOZ]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | name=Instructor | label=BAH, TECHADMIN125]]
    driver.findElement(By.name("Submit")).click();
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
