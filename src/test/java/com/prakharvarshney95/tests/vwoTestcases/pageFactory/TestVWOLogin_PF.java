package com.prakharvarshney95.tests.vwoTestcases.pageFactory;

import com.prakharvarshney95.base.BaseTest;
import com.prakharvarshney95.driver.DriverManager;
import com.prakharvarshney95.pages.pageFactory.LoginPage_PF;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.prakharvarshney95.utils.PropertyReader;

public class TestVWOLogin_PF extends BaseTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);

    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Testcases Page Factory");
        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertyReader.readKey("url"));
        LoginPage_PF loginPage_PF = new LoginPage_PF(driver);
        String error_msg = loginPage_PF.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg, PropertyReader.readKey("error_message"));
    }

}
