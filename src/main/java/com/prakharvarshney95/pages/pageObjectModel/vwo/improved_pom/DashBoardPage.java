package com.prakharvarshney95.pages.pageObjectModel.vwo.improved_pom;

import com.prakharvarshney95.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BasePage {

    WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");


    // Page Actions
    public String loggedInUserName(){
        visibilityOfElement(userNameOnDashboard);
        return driver.findElement(userNameOnDashboard).getText();

    }
}
