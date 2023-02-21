package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BudgetActivityPage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/expenses_list")
    WebElement expensesList;

    public WebElement getExpensesList() {
        return expensesList;
    }

    public BudgetActivityPage(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }
}
