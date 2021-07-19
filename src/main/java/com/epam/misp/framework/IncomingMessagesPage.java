package com.epam.misp.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IncomingMessagesPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='UI']//tr[@class][1]")
    private WebElement userInterfaceFirst;

    protected IncomingMessagesPage(WebDriver driver) {
        super(driver);
    }

    public String userInterfaceFirstGetText() {
        return userInterfaceFirst.getText();
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }
}
