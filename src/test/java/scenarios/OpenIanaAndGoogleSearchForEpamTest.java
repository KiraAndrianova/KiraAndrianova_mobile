package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static testdata.TestData.*;

public class OpenIanaAndGoogleSearchForEpamTest extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest() throws InterruptedException {
        appiumDriverSetup.getDriver().get(ianaSiteUrl); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(appiumDriverSetup.getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript(returnDocReadyState).equals(completedState)
        );

        // Check IANA homepage title
        assert ((WebDriver) appiumDriverSetup.getDriver()).getTitle().equals(assignedNumbersAuthority) : errorResult;

        // Log that test finished
        System.out.println("Site opening done");
    }


    @Test(groups = {"web"}, description = "Search for EPAM")
    public void searchEpam() {
        appiumDriverSetup.getDriver().get(googleUrl); //open google.com

        //Send search value = EPAM
        googlePage.getSearchBox().sendKeys(searchValue);
        googlePage.getSearchBox().sendKeys(Keys.ENTER);

        //Verify that page title starts with EPAM
        Assert.assertTrue(appiumDriverSetup.getDriver().getTitle().startsWith(searchValue));
    }
}
