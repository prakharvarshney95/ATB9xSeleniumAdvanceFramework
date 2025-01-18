package com.prakharvarshney95.tests.vwoTestcases;

import com.prakharvarshney95.base.BaseTest;
import com.prakharvarshney95.driver.DriverManager;
import com.prakharvarshney95.pages.pageObjectModel.vwo.normal.DashBoardPage;
import com.prakharvarshney95.pages.pageObjectModel.vwo.normal.LoginPage;
import com.prakharvarshney95.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestVWOLogin_05_POM_PropertyReader_DriverManager extends BaseTest {

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {

        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage_VWO.loginToVWOLoginInvalidCreds(PropertyReader.readKey("invalid_username"),PropertyReader.readKey("invalid_password"));

        // Assertion AssertJ
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();

        // Assertion TestNG
        Assert.assertEquals(error_msg,PropertyReader.readKey("error_message"));


    }

    @Owner("PRAMOD")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertyReader.readKey("username"),PropertyReader.readKey("password"));
        DashBoardPage dashBoardPage  = new DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertyReader.readKey("expected_username"));

    }

    }
