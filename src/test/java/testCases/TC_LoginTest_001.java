package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException, InterruptedException {
        logger.info("URL is opened");
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(email);
        logger.info("Entered Email");
        lp.setPassword(password);
        logger.info("Entered password");
        lp.clickSubmit();
        Thread.sleep(2000);
        if (driver.getTitle().equals("Facebook")) {
            captureScreen(driver, "loginTestPassed");
            Assert.assertTrue(true);
            logger.info("Logging Test passed");
        } else {
            captureScreen(driver, "loginTestFailed");
            Assert.assertTrue(false);
            logger.info("Logging Test failed");
        }
    }
}
