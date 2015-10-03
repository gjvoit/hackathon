package hackathonGroup.hackathonID.helperFunctions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.Logger;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import jline.internal.Log;

public class SelectDriver {
	private WebDriver driver;
	
	public WebDriver getDriver (String platform, String browser, String version) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		
		
		if(platform.equalsIgnoreCase("Windows")){
//			log.info("You're using platform: Windows");
			caps.setPlatform(org.openqa.selenium.Platform.
		  WINDOWS);
		}
		if(platform.equalsIgnoreCase("MAC")){
//			log.info("You're using platform: Mac");
			caps.setPlatform(org.openqa.selenium.Platform.MAC);
		}
		if(browser.equalsIgnoreCase("Internet Explorer")){
//			log.info("You're using browser: Internet Explorer");
			
			caps = DesiredCapabilities.internetExplorer();
			
			// this way it doesn't matter about all the security zones being at the same level
//			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
			
			
			// didn't work
//			Proxy proxy = new Proxy();
//			proxy.setProxyType(ProxyType.MANUAL);
//			proxy.setSslProxy("trustAllSSLCertificates");
//			caps.setCapability(CapabilityType.PROXY, proxy);
			
			
			// didn't work
			 caps.setCapability("acceptSslCerts", "true");
			
			// didn't work
			// caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);    
		}
		if(browser.equalsIgnoreCase("Firefox")){
			
//			log.info("You're using browser: Firefox");
			caps = DesiredCapabilities.firefox();
		}
		if(browser.equalsIgnoreCase("Chrome")){
//			log.info("You're using browser: Chrome");
			caps = DesiredCapabilities.chrome();
			caps.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));

		}
		//Version
		caps.setVersion(version);
//		log.info("You're using version: " + version);
		
		//Pointing to automated Selenium grid on the test server
		driver = new RemoteWebDriver(new URL("http://10.200.64.70:4444/wd/hub"), caps);
		
		return driver;
	}
	
}
