package testcases;

import Testing.com.ConfigData;
import common.BaseSetup;
import org.testng.annotations.Test;
import page.CustomerPage;
import page.DashboardPage;
import page.LoginPage;

public class CustomerTest extends BaseSetup {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyHeaderCustomerPage();

        customerPage.clickButtonAddNew();

        String CUSTOMER_NAME = "FPT Software A6";
        customerPage.inputFormData(CUSTOMER_NAME); //Add new and Save
        customerPage.searchAndVerifyCustomer(CUSTOMER_NAME); //Search and Verify on table
        customerPage.verifyCustomerDetail(CUSTOMER_NAME); //Verify Detail

    }
}

