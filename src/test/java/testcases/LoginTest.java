package testcases;

import Testing.com.WebUI;
import common.BaseSetup;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.DashboardPage;
import page.LoginPage;

import static Testing.com.WebUI.driver;
import static Testing.com.WebUI.waitForPageLoaded;

public class LoginTest extends BaseSetup {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    @Parameters({"email", "password"})
    public void testLoginSuccess(String email, String password) {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(email, password);
        waitForPageLoaded();
        loginPage.verifyLoginSuccess();
        WebUI.captureScreenImage("testLoginSuccess");
        dashboardPage.logOut();
    }

    @Test
    public void testLoginWithEmailInvalid() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin123@example.com", "123456");
        waitForPageLoaded();
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithEmailInvalid");
    }

    @Test
    public void testLoginWithPasswordInvalid() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123");
        waitForPageLoaded();
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithPasswordInvalid");
    }
}

