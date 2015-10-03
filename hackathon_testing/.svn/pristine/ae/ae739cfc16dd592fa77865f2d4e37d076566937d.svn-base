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


public class SendAllUnsent_56_test {
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
	
	Reporter.log("- started SendAllUnsent_56 on " + browserInfo.getBrowserShorthand() + "<br>");

	driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/clc/resend/SendFiles.jsp");
    Assert.assertEquals("You are about to send unsent files to clc. Click send if you want to continue.", driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td")).getText());
    driver.findElement(By.cssSelector("input.orangeDefaultSize")).click();
    Assert.assertEquals("Result", driver.findElement(By.xpath("html/body/table[5]/tbody/tr[1]/td")).getText());
    log.info("completed SendAllUnsent_56!");
    driver.quit();
  }

}
