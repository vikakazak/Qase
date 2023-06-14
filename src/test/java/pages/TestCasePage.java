package pages;

import dto.TestCase;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;

@Log4j2
public class TestCasePage extends BasePage{
    public static final By SAVE_BUTTON = By.id("save-case");
    public static final By caseTitle = By.xpath("//label[text()='Title']/../div/input");
    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling in test case's form")
    public TestCasePage fillIn(TestCase testCase) {
        log.info("Filling in Title {}", testCase.getTitle());
        driver.findElement(caseTitle).clear();
        driver.findElement(caseTitle).sendKeys(testCase.getTitle());
        log.info("Filling in Description field: {}", testCase.getDescription());
        new Input(driver, "Description").write(testCase.getDescription());
        log.info("Filling in Pre-condition field: {}", testCase.getPreConditions());
        new Input(driver, "Pre-conditions").write(testCase.getPreConditions());
        log.info("Filling in Post-condition field: {}", testCase.getPostConditions());
        new Input(driver, "Post-conditions").write(testCase.getPostConditions());
        return this;
    }

    @Step("Saving new test case")
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
