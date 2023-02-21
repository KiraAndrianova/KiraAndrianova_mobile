package scenarios;

import org.testng.annotations.*;
import utils.*;
import pages.BudgetActivityPage;
import pages.GooglePage;
import pages.RegistrationPage;
import pages.SignInPage;

public class BaseTest {

    static AppiumDriverSetup appiumDriverSetup;

    static RegistrationPage registrationPage;
    static SignInPage signInPage;
    static BudgetActivityPage budgetActivityPage;
    static GooglePage googlePage;

    @Parameters({"platformName", "appType", "deviceName", "browserName", "app"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName, String appType, String deviceName, @Optional("") String browserName, @Optional("") String app) throws Exception {
        System.out.println("Before: app type - " + appType);

        appiumDriverSetup = new AppiumDriverSetup();
        appiumDriverSetup.setAppiumDriver(platformName, deviceName, browserName, app);

        registrationPage = new RegistrationPage(appiumDriverSetup.getDriver());
        signInPage = new SignInPage(appiumDriverSetup.getDriver());
        budgetActivityPage = new BudgetActivityPage(appiumDriverSetup.getDriver());
        googlePage = new GooglePage(appiumDriverSetup.getDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After");
        appiumDriverSetup.getDriver().closeApp();
    }

}
