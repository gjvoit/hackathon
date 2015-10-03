package atlasGroup.atlasID.pages;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import atlasGroup.atlasID.pages.TestManagement_62;

import java.util.logging.Logger;

import jline.internal.Log;

public class Login_0 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private final static Logger log = Logger.getLogger(TestManagement_62.class.getName());


  public void testLogin0(WebDriver passedDriver) throws Exception {
	driver = passedDriver;
	
	//get capabilities 
	Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
	String browserName = caps.getBrowserName();
	String browserVersion = caps.getVersion();
	
//	log.info("Begin logging in with " + browserName + " and version " + browserVersion);

	baseUrl = "https://atlasdau-upg-stage1.usae.bah.com/";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(baseUrl + "/html/desktop/SystemAdministratorDesktop.jsp");

    // used to bypass certificate error on IE
    bypassCertificate(browserVersion);
    
    // hitting submit to take you in to login page
    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    
    // used to bypass certificate error on IE
    bypassCertificate(browserVersion);
    
    // signing in
    driver.findElement(By.name("UserName")).clear();
    driver.findElement(By.name("UserName")).sendKeys("agopala");
    driver.findElement(By.name("Password")).clear();
    driver.findElement(By.name("Password")).sendKeys("NotWorking123456!@#");
    driver.findElement(By.xpath("//button[@type='submit']")).click();

    // close all the pop-ups that appear on Firefox
    closeExcessFirefoxWindows();

    // atlas asks you 'are you sure you want to continue?'  click yes here for Firefox and IE 11 but NOT 10
	if ((driver.toString().contains("firefox") || driver instanceof FirefoxDriver) || ((driver.toString().contains("internet explorer") || driver instanceof InternetExplorerDriver)
			& browserVersion.contains("11"))){
//		log.info("Logging in anyways");
		try{
			driver.findElement(By.xpath("(.//*[@class='orangeDefaultSize'])")).click();
		} catch (Exception f){
//			log.info("Unable to login first...");
			Thread.sleep(4000);
			driver.findElement(By.xpath("(.//*[@class='orangeDefaultSize'])")).click();
//			log.info("clicked it this time");
		}
	}

  }
  
  
  public void closeExcessFirefoxWindows(){
	  if (driver.toString().contains("firefox") || driver instanceof FirefoxDriver){
		  // Store the current window handle
//		  log.info("closing excess windows");
		  String winHandleBefore = driver.getWindowHandle();
	
		  // Perform the click operation that opens new window
	
		  // Switch to new window opened
		  for(String winHandle : driver.getWindowHandles()){
		      driver.switchTo().window(winHandle);
		  }
	
		  // Perform the actions on new window
		  // Close the new window, if that window no more required
//		  log.info("closing excess window now");
		  driver.close();
	
		  // Switch back to original browser (first window)
		  driver.switchTo().window(winHandleBefore);
	
		  // Continue with original browser (first window)
//		  log.info("closed excess windows");
	  }
  }
  
  public void bypassCertificate(String browserVersion) throws InterruptedException{
//	  log.info("entered bypassCertificate");
	  
	  if (driver.toString().contains("internet explorer") || driver instanceof InternetExplorerDriver){
		  String pageTitle = driver.getTitle();
		  if (pageTitle.equals("Certificate Error: Navigation Blocked")){
	    	if (browserVersion.contains("11")){
//	    		log.info("About to click on 11's overridelink");
	    		driver.findElement(By.id("overridelink")).click();
	    	}
	    	else if (browserVersion.contains("10")){
//    			log.info("About to click on 10's continueToSite");
    			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
	    	}
	    	else {
//	    		log.info("errr click on one of the versions continue");
	    		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
	    	}
//	    	log.info("Bypassed Certificate");
		  }
	  }
  }

}
