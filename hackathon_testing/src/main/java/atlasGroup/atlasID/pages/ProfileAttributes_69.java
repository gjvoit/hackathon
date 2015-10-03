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

public class ProfileAttributes_69 {
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
  
  @Test(description="ProfileAttributes_69")
  public void testActivate_Deactivate_65() throws Exception {
	Login_0 login = new Login_0();
	login.testLogin0(driver);
	Thread.sleep(2000);  
	log.info("Started ProfileAttributes_69");
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/utilities/admin/reference/AllOwnerValues.jsp");
//    
//    new Select(driver.findElement(By.name("ownerid"))).selectByVisibleText("Navy (NAVY)");
//    new Select(driver.findElement(By.name("ownerid"))).selectByVisibleText("DAU (DAU)");
    driver.findElement(By.name("FAX-33")).click();
    driver.findElement(By.name("submit2")).click();
    
    // now see if it changed in edit account
//     driver.get(baseUrl + "html/user/user1/EditUserInformation.jsp?");
    // url doesn't work
    
    //open menu for edit user
    driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
    
    try{
    	log.info("Started ProfileAttributes_69 -- 0.1");
    	driver.findElement(By.xpath("(.//*[@class='aSmall'][contains(text(),'Edit Account')])")).click();    	
    } catch (Exception e){
    	try{
    		log.info("Started ProfileAttributes_69 -- 0.2");
    		driver.findElement(By.xpath("/html/body/div[16]/div/table/tbody/tr[1]/td/div/div[1]/span/a")).click();
    	} catch (Exception f) {
    		try{
    			log.info("Started ProfileAttributes_69 -- 0.3");
    			driver.findElement(By.xpath("/html/body/div[16]/div/table/tbody/tr[1]/td/div/div[1]/span/a")).click();
    		} catch (Exception g){
    			try{
    				log.info("Started ProfileAttributes_69 -- 0.4");
    				driver.findElement(By.xpath("/html/body/div[17]/table/tbody/tr[1]/td/div/div[1]/span/a")).click();	
    			} catch (Exception h){
    				log.info("Started ProfileAttributes_69 -- 0.5");
	    			driver.get(baseUrl + "html/user/user1/EditUserInformation.jsp?pageSource=null");
    			}
    		}
    	}
    }
    
    log.info("Started ProfileAttributes_69 -- 1");
    
//    assertEquals("Fax :", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[6]/td/table/tbody/tr[3]/td[1]/label")).getText());
    Thread.sleep(3000);
    try{
    	Assert.assertTrue(driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[6]/td/table/tbody/tr[3]/td[1]/label")).getText().contains("Fax :"));
    } catch (Exception e){
    	log.info("Started ProfileAttributes_69 -- 1a");
    	List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Fax :')]"));
        Assert.assertTrue("Fax :", list.size() > 0);
    }
    
    log.info("Started ProfileAttributes_69 -- 2");
    driver.get(baseUrl + "html/utilities/admin/reference/AllOwnerValues.jsp");
    // turn off fax
    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/table/tbody/tr[19]/td[3]/input")).click();
    
    driver.findElement(By.name("submit2")).click();
    driver.findElement(By.xpath("(.//*[@class='aSmall'][contains(text(),'Edit Account')])")).click();
    // Warning: assertTextNotPresent may require manual changes
//    assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*xpath=html/body/table\\[5\\]/tbody/tr\\[6\\]/td/table/tbody/tr\\[3\\]/td\\[1\\]/label[\\s\\S]*$"));
//    try{
//    	Assert.assertFalse(driver.findElement(By.xpath("/html/body/table[5]/tbody/tr[6]/td/table/tbody/tr[3]/td[1]/label")).getText().contains("Fax :"));
//    } catch (Exception e){
    	List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Fax :')]"));
    	Assert.assertFalse("Fax :", list.size() > 0);
//    }
    log.info("completed ProfileAttributes_69!");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}
