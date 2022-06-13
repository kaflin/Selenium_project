package testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {

        logger.info("URL is opened");

        LoginPage lp = new LoginPage(driver);
        lp.setEmail(email);
        logger.info("Entered Email");
        lp.setPassword(password);
        logger.info("Entered password");
        lp.clickSubmit();

        if (driver.getTitle().equals("Facebook")) {
            captureScreen(driver,"loginTestPassed");
            Assert.assertTrue(true);
            logger.info("Logging Test passed");
        } else {
            captureScreen(driver,"loginTestFailed");
            Assert.assertFalse(false);
            logger.info("Logging Test failed");
        }
    }
}
