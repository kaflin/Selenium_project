package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;

import java.io.IOException;
import java.time.Duration;

public class TC_LoginDDT_002 extends BaseClass{
    @Test(dataProvider="LoginData")
    public void loginDDT(String email, String pwd) throws InterruptedException
    {
           loginCredentials(email,pwd);
           logger.info("Login passed");
           Assert.assertTrue(true);
           Thread.sleep(5000);
            WebElement svgObj = driver.findElement(By.cssSelector("svg.i8zpp7h3"));
            Actions actionBuilder = new Actions(driver);
            actionBuilder.click(svgObj).build().perform();
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Log Out')]"))).click();
    }
    public void loginCredentials(String email,String pwd) throws InterruptedException {
        LoginPage lp=new LoginPage(driver);
        lp.setEmail(email);
        logger.info("email provided");
        lp.setPassword(pwd);
        logger.info("password provided");
        lp.clickSubmit();

    }
    public boolean isAlertPresent() //user defined method created to check alert is present or not
    {
        try {
            driver.switchTo().alert();
            return true;
        } catch(NoAlertPresentException e) {
            return false;
        }
    }
    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException{
        String path=System.getProperty("user.dir")+"/src/test/java/testData/data.xlsx";
        int rownum= XLUtils.getRowCount(path, "Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
            }

        }
        return logindata;
    }

}
