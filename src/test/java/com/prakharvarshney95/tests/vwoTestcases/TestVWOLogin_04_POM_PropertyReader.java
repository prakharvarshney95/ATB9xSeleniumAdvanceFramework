package com.prakharvarshney95.tests.vwoTestcases;

import com.prakharvarshney95.pages.pageObjectModel.vwo.normal.DashBoardPage;
import com.prakharvarshney95.pages.pageObjectModel.vwo.normal.LoginPage;
import com.prakharvarshney95.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestVWOLogin_04_POM_PropertyReader {

    @Owner("PRAMOD")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {
        WebDriver driver = new EdgeDriver();

        LoginPage loginPage_VWO = new LoginPage(driver);
        String error_msg = loginPage_VWO.loginToVWOLoginInvalidCreds(PropertyReader.readKey("invalid_username"),PropertyReader.readKey("invalid_password"));

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertyReader.readKey("error_message"));


    }

    @Owner("PRAMOD")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {
        WebDriver driver = new EdgeDriver();

        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginValidCreds(PropertyReader.readKey("username"),PropertyReader.readKey("password"));
        DashBoardPage dashBoardPage  = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertyReader.readKey("expected_username"));

    }

    }
