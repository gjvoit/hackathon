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

public class LoginNewTestUser_98 {
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

  @Test(description="LoginNewTestUser_98")
  public void test21CourseCertificate() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	log.info("started LoginNewTestUser_98");
	Thread.sleep(2000);  
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    
    driver.findElement(By.xpath("(//a[contains(text(),'Login as Other User')])[2]")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("temp_dau_id");
    driver.findElement(By.name("submit")).click();
    
    try{
    	Assert.assertTrue(driver.findElement(By.xpath("//*[@id='login as another user']/table/tbody/tr[2]/td/table/tbody/tr[1]/td")).getText().contains("Are you sure you want to login as this user?"));
    } catch (Exception e){
    	List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Are you sure you want to login as this user?')]"));
        Assert.assertTrue("Are you sure you want to login as this user?", list.size() > 0);
    }
    driver.findElement(By.name("submit")).click();
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    
    driver.findElement(By.xpath("(//a[contains(text(),'Login as Other User')])[2]")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("bad_id");
    driver.findElement(By.name("submit")).click();
    
    try{
    	Assert.assertTrue(driver.findElement(By.xpath("//*[@id='login as another user']/table/tbody/tr[2]/td/table/tbody/tr/td")).getText().contains("No user with that username exists in the system"));
    } catch (Exception e){
    	List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'No user with that username exists in the system.')]"));
        Assert.assertTrue("No user with that username exists in the system.", list.size() > 0);
    }
    
    log.info("completed LoginNewTestUser_98!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
