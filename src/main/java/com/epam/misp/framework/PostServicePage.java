package com.epam.misp.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class PostServicePage extends AbstractPage{

    private String postServiceButtonLocator = "//div/a[contains(@aria-label,'%s')]";

    @FindBy(xpath = "//div[@class='z0']/div[@role='button']")
    private WebElement newLetterButton;

    @FindBy(xpath = "//span/a[contains(@href,'#inbox')]")
    private WebElement incomingButton;

    @FindBy(xpath = "//div[@class='aim ain']//a[contains(@href,'#inbox')]")
    private WebElement inboxTab;

    protected PostServicePage(WebDriver driver) {
        super(driver);
    }

    public AccountManagementPage postServiceButtonClick(String mail) {
        driver.findElement(By.xpath(String.format(postServiceButtonLocator, mail))).click();
        return new AccountManagementPage(driver);
    }

    public NewLetterPage newLetterButtonClick() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(newLetterButton)).click();
        return new NewLetterPage(driver);
    }

    public IncomingMessagesPage incomingButtonClick() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return new IncomingMessagesPage(driver);
    }

    public PostServicePage waitForPageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(incomingButton));
        return this;
    }

    public boolean isPostServiceMainPage() {
        return inboxTab.isDisplayed();
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }

}
