package atlasGroup.atlasID.helperFunctions;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.*;

public class LoginAsCRMM {
  private WebDriver driver;
  private String baseUrl;
  
  public void LoginAsOtherUser(WebDriver passedDriver) throws Exception {
	driver = passedDriver;
    driver.get(baseUrl + "html/desktop/SystemAdministratorDesktop.jsp");
    driver.get(baseUrl + "html/login/LoginAsAnotherUser.jsp");
    driver.findElement(By.id("username that you want to login as")).clear();
    // feel free to replace the user you want to use for CRMM.  Doesn't have to be MIKEI1
    // Name: Admin, Mike (MIKEI1)
    driver.findElement(By.id("username that you want to login as")).sendKeys("MIKEI1");
    driver.findElement(By.name("submit")).click();
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td")).getText().contains("Are you sure you want to login as this user?"));
    driver.findElement(By.name("submit")).click();
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
  }
}
