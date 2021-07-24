package com.epam.misp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class AuthorizationPage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://mail.google.com/";

    @FindBy(xpath = "//div[@class='cRiDhf']")
    private WebElement withoutAccount;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//button/ancestor::div[@jsname='k77Iif']")
    private WebElement nextButton;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public AuthorizationPage openPage() {
        driver.get(HOMEPAGE_URL);

        driver.manage().timeouts().pageLoadTimeout(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }

    public ElementPasswordPage feelLoginField(String login) {
        loginInput.sendKeys(login);
        nextButton.click();
        return new ElementPasswordPage(driver);
    }

    public boolean isAuthorizationPage() {
        return withoutAccount.isDisplayed();
    }

}