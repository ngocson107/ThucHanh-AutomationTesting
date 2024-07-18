package testcases;



import Testing.com.ConfigData;
import common.BaseSetup;
import org.testng.annotations.Test;
import page.CustomerPage;
import page.DashboardPage;
import page.LoginPage;

import static Testing.com.WebUI.driver;

public class DashboardTest extends BaseSetup {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage(){
        //Login
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        //Click menu Customer
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyHeaderCustomerPage();

    }

    @Test
    public void testAdminRole(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyMenuReportDisplay();
    }

    @Test
    public void testProjectRole(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("project@example.com", "123456");
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyMenuReportNotDisplay();
    }

}
