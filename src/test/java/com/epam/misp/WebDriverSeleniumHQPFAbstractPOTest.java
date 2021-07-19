package com.epam.misp;

import com.epam.misp.framework.AuthorizationPage;
import com.epam.misp.framework.PostServicePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;

public class WebDriverSeleniumHQPFAbstractPOTest {
    private WebDriver driver;

    String login = "qatest.qatesttask@gmail.com";
    String password = "ghRRKJklo9769%^&*";
    String mailsTopic = "Tests Message " + new Random().nextInt();
    String mailsBody = "Tests Body " + new Random().nextLong();

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Just first test, JIRA binding can be here")
    public void loginGmailTest() {
        final PostServicePage postServicePage = new AuthorizationPage(driver)
                .openPage()
                .feelLoginField(login)
                .feelPasswordField(password)
                .nextButtonClick()
                .waitForPageToLoad();

        Assert.assertTrue(postServicePage.isPostServiceMainPage(), "This is not the main page of the mail service.");
    }

    @Test(description = "Just first test, JIRA binding can be here")
    public void logoutGmailTest() {
        final AuthorizationPage authorizationPage = new AuthorizationPage(driver)
                .openPage()
                .feelLoginField(login)
                .feelPasswordField(password)
                .nextButtonClick()
                .postServiceButtonClick(login)
                .outButtonClick();

        Assert.assertTrue(authorizationPage.isAuthorizationPage(), "This is not the 'authorization page' of the mail service.");
    }

    @Test(description = "Just first test, JIRA binding can be here")
    public void writeMailTest() {
        PostServicePage postServicePage = new AuthorizationPage(driver)
                .openPage()
                .feelLoginField(login)
                .feelPasswordField(password)
                .nextButtonClick()
                .waitForPageToLoad();

        String inboxTabNextIndex = String.valueOf(postServicePage.inboxTabGetText() + 1);

        PostServicePage postServicePageWithNewMail = postServicePage
                .newLetterButtonClick()
                .feelWhomField(login)
                .feelTopicField(mailsTopic)
                .feelTextField(mailsBody)
                .clickSendButton()
                .waitNewLetterForPostService(inboxTabNextIndex);

        Assert.assertTrue(postServicePageWithNewMail.userInterfaceFirstGetText().contains(mailsTopic)
                && postServicePageWithNewMail.userInterfaceFirstGetText().contains(mailsBody), "The letter isn't received.");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
