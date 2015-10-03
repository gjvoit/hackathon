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

public class AtlasProperties_50 {
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
  
  @Test(description="AtlasProperties_50")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started AtlasProperties_50");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/utilities/admin/Properties.jsp");
    // Perform the click operation that opens new window
    String winHandleBefore = driver.getWindowHandle();
    log.info("Started AtlasProperties_50 -- 1");
//    driver.findElement(By.xpath("/html/body/div[2]/div[5]")).click();
//    
//    try{
//    	driver.findElement(By.xpath("/html/body/div[17]/div/table/tbody/tr[1]/td/div/div[2]/span/ul/ul[1]/li[1]/a"));
//    } catch (Exception e){
//    	log.info("Started AtlasProperties_50 -- 1.5");
//    	driver.findElement(By.xpath("/html/body/div[17]/table/tbody/tr[1]/td/div/div[2]/span/ul/ul[1]/li[1]/a")).click();
//    }
//	log.info("Started AtlasProperties_50 -- 2");
//	// Switch to new window opened
//    for(String winHandle : driver.getWindowHandles()){
//    	driver.switchTo().window(winHandle);
//	}
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try{
    	List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Application Property Id')]"));
	    Assert.assertTrue("Application Property Id", list.size() > 0);
    } catch (Exception e){
    	log.info("Started AtlasProperties_50 -- 1.5");
    	Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[1]/th[1]")).getText().contains("Application Property Id"));
    }
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }

}
