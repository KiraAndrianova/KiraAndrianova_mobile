package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import static testdata.TestData.*;

public class AppRegistrationAndLoginTest extends BaseTest {

    @Test(priority = 1, groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() {
        signInPage.getSignInBtn().click();
        System.out.println("Simplest Android native test done");
    }

    @Test(priority = 2, groups = {"native"})
    public void registerNewAccount() {
        signInPage.getRegisterButton().click();

        registrationPage.getEmail().sendKeys(email);
        registrationPage.getUsername().sendKeys(username);
        registrationPage.getPassword().sendKeys(password);
        registrationPage.getConfirmPassword().sendKeys(password);
        //registrationPage.getCheckboxAgree().click();

        registrationPage.getRegisterNewAccButton().click();
        System.out.println("Register button clicked");
    }

    @Test(priority = 3, groups = {"native"})
    public void signInWithNewAccount() {
        signInPage.getLoginEmail().sendKeys(email);
        signInPage.getLoginPwd().sendKeys(password);
        signInPage.getSignInBtn().click();

        Assert.assertTrue(budgetActivityPage.getExpensesList().isDisplayed());
        System.out.println("Successful login");
    }
}
