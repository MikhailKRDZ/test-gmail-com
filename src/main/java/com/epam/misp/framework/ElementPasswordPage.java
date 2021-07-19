package com.epam.misp.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ElementPasswordPage extends AbstractPage {

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button/ancestor::div[@id='passwordNext']")
    private WebElement nextButton;

    protected ElementPasswordPage(WebDriver driver) {
        super(driver);
    }

    public PostServicePage nextButtonClick() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(nextButton)).click();
        return new PostServicePage(driver);
    }

    public ElementPasswordPage feelPasswordField(String term) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(passwordInput)).sendKeys(term);
        return this;
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }

}
