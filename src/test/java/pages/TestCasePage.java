package pages;

import dto.TestCase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;

public class TestCasePage extends BasePage{
    public static final By SAVE_BUTTON = By.id("save-case");

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling in test case's form")
    public TestCasePage fillIn(TestCase testCase) {
        new Input(driver, "Title").write(testCase.getTitle());
        new Input(driver, "Description").write(testCase.getDescription());
        new Input(driver, "Pre-conditions").write(testCase.getPreConditions());
        new Input(driver, "Post-conditions").write(testCase.getPostConditions());
        return this;
    }

    public TestCasePage editTitle(TestCase testCase) {
        new Input(driver, "Title").clear();
        new Input(driver, "Title").write(testCase.getTitle());
        return this;
    }

    @Step("Saving new test case")
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
