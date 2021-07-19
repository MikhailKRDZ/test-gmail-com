package com.epam.misp.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class NewLetterPage extends AbstractPage{

    @FindBy(xpath = "//div/textarea[@name='to']")
    private WebElement whomFieldInput;

    @FindBy(xpath = "//div/input[@name='subjectbox']")
    private WebElement topicFieldInput;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement textFieldInput;

    @FindBy(xpath = "//div[@class='dC']/div[1]")
    private WebElement sendButton;

    protected NewLetterPage(WebDriver driver) {
        super(driver);
    }

    public NewLetterPage feelWhomField(String term) {
        whomFieldInput.sendKeys(term);
        return this;
    }

    public NewLetterPage feelTopicField(String term) {
        topicFieldInput.sendKeys(term);
        return this;
    }

    public NewLetterPage feelTextField(String term) {
        textFieldInput.sendKeys(term);
        return this;
    }

    public PostServicePage clickSendButton() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(sendButton)).click();
        return new PostServicePage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }

}
