package com.epam.misp.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AccountManagementPage extends AbstractPage{

    @FindBy(xpath = "//div[@class='gb_nb']/following::div/a[@target='_top']")
    private WebElement postServiceButton;

    protected AccountManagementPage(WebDriver driver) {
        super(driver);
    }

    public AuthorizationPage outButtonClick() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(postServiceButton)).click();
        return new AuthorizationPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }
}
