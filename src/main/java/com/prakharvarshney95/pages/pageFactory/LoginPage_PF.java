package com.prakharvarshney95.pages.pageFactory;

import com.prakharvarshney95.base.BasePage;
import com.prakharvarshney95.pages.pageObjectModel.KatalonCure.LoginPage;
import com.prakharvarshney95.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends BasePage {

    // Page Locators

    public LoginPage_PF(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;

    // Page Actions

    public String loginToVWOInvalidCreds() {
        enterInput(username, PropertyReader.readKey("invalid_username"));
        enterInput(password, PropertyReader.readKey("invalid_password"));
        clickElement(signButton);
        custom_wait();
        return getText(error_message);


    }
}
