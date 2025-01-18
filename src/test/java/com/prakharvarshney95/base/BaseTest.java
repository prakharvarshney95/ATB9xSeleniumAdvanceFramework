package com.prakharvarshney95.base;

import com.prakharvarshney95.driver.DriverManager;
import com.prakharvarshney95.tests.vwoTestcases.TestVWOLogin_06_Improved_POM_PropertyReader_DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }

}
