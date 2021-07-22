package com.epam.misp;

import com.epam.misp.framework.AuthorizationPage;
import com.epam.misp.framework.PostServicePage;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import service.UserCreator;
import util.IConstants;
import util.RandomUtil;

public class WebDriverSeleniumTest {
    private WebDriver driver;

    User testUser = UserCreator.withCredentialsFromProperty();
    PostServicePage postServicePage;

    @BeforeMethod(alwaysRun = true)
    public void login() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        postServicePage = new AuthorizationPage(driver)
                .openPage()
                .feelLoginField(testUser.getLogin())
                .feelPasswordField(testUser.getPassword())
                .nextButtonClick()
                .waitForPageToLoad();
    }

    @Test(description = "Just first test, JIRA binding can be here")
    public void loginGmailTest() {
        Assert.assertTrue(postServicePage.isPostServiceMainPage(), IConstants.not("Main Page"));
    }

    @Test(description = "Just first test, JIRA binding can be here")
    public void logoutGmailTest() {
        AuthorizationPage authorizationPage = postServicePage.postServiceButtonClick(testUser.getLogin())
                .outButtonClick();
        Assert.assertTrue(authorizationPage.isAuthorizationPage(), IConstants.not("Authorization Page"));
    }

    @Test(description = "Just first test, JIRA binding can be here")
    public void writeMailTest() {
        String mailsTopic = RandomUtil.getMailsTopic();
        String mailsBody = RandomUtil.getMailsBody();

        String inboxTabNextIndex = String.valueOf(postServicePage.inboxTabGetText() + 1);
        postServicePage = postServicePage
                .newLetterButtonClick()
                .feelWhomField(testUser.getLogin())
                .feelTopicField(mailsTopic)
                .feelTextField(mailsBody)
                .clickSendButton()
                .waitNewLetterForPostService(inboxTabNextIndex);
        Assert.assertTrue(postServicePage.userInterfaceFirstGetText().contains(mailsTopic)
                && postServicePage.userInterfaceFirstGetText().contains(mailsBody), IConstants.notReceived);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
