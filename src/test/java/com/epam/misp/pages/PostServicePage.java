package com.epam.misp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class PostServicePage extends AbstractPage{

    private String postServiceButtonLocator = "//div/a[contains(@aria-label,'%s')]";
    private  String inboxLetterWithNumberLocator = "//span/a[contains(@href,'#inbox')][contains(@aria-label,'%s')]";

    @FindBy(xpath = "//div[@class='z0']/div[@role='button']")
    private WebElement newLetterButton;

    @FindBy(xpath = "//body[@data-awr-sg-installed='true']")
    private WebElement pageLoadButton;

    @FindBy(xpath = "//div[@class='UI']//tr[@class][1]")
    private WebElement userInterfaceFirst;

    @FindBy(xpath = "//a[contains(@href,'#inbox')]/parent::span/following::div[1]")
    private WebElement inboxTabCounter;

    @FindBy(xpath = "//a[contains(@href,'#inbox')]/parent::span")
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

    public PostServicePage waitForPageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(pageLoadButton));
        return this;
    }

    public boolean isPostServiceMainPage() {
        return inboxTab.isDisplayed();
    }

    public String userInterfaceFirstGetText() {
        return userInterfaceFirst.getText();
    }

    public int inboxTabGetText() {
        String text = inboxTabCounter.getText();
        if (!text.equals("")) {
            return Integer.parseInt(text);
        }
        return 0;
    }

    public PostServicePage waitNewLetterForPostService(String number) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(elementToBeClickable(driver.findElement(By.xpath(String.format(inboxLetterWithNumberLocator, number)))));
        return this;
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }
}
