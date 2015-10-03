package hackathonGroup.hackathonID.helperFunctions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import jline.internal.Log;

public class CallAfterTest {
	private WebDriver driver;
	private String baseUrl;

	public void callAfterTest(WebDriver passedDriver, ITestResult testResult, String browserName) throws Exception {
		Log.info("inside callAfterTest");
		if (testResult.getStatus() == ITestResult.FAILURE) {
			Log.info("inside failure of callAfterTest");
			File scrFile = ((TakesScreenshot) passedDriver).getScreenshotAs(OutputType.FILE);
			if (System.getProperty("os.name").equals("Mac OS X")) {
				Log.info("inside MAC failure of callAfterTest");
				File saveDir = new File(System.getProperty("user.dir") + "/target/surefire-reports/failureScreenShots/");
				if (!saveDir.exists()) {
					saveDir.mkdirs();
				}
				Log.info(" - [FAILURE] Screenshot taken and stored in " + saveDir);
				Reporter.log("Screenshot taken and stored in " + saveDir);
				FileUtils.copyFile(scrFile,
						new File(saveDir + "/screenShot-" + testResult.getName() + "-" + browserName + ".jpg"));
				Log.info("finished MAC failure of callAfterTest");
			} else {
				File saveDir = new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\failureScreenShots\\");
				if (!saveDir.exists()) {
					saveDir.mkdirs();
				}
				Log.info(" - [FAILURE] Screenshot taken and stored in " + saveDir);
				Reporter.log("Screenshot taken and stored in " + saveDir);
				FileUtils.copyFile(scrFile,
						new File(saveDir + "\\screenShot-" + testResult.getName() + "-" + browserName + ".jpg"));
			}
			Log.info("end of failure of callAfterTest");
		}
		Log.info("right before quit");
		passedDriver.quit();
		Log.info("should have quit by now");
	}

}
