package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class RepositoryPage extends BasePage {
    String REPOSITORY_NAME = "//h1[contains(text() , '%s')]";
    String TEST_CASE_NAME = "//*[text()=\"%s\"]";
    String TEST_CASE_CHECKBOX = "//*[text()='%s']/../div[1]";
    public static final By DELETE_BUTTON = By.xpath("//*[text()=' Delete']");
    public static final By DELETE_INPUT = By.cssSelector("input[name=confirm]");
    public static final By DELETE_CONFIRM_BUTTON = By.cssSelector("button[type=submit]");
    public static final By DELETE_MODAL = By.cssSelector(".ReactModal__Content");
    public static final By EDIT_BUTTON = By.xpath("//*[text()=' Edit']");
    public static final By CASE_BUTTON = By.id("create-case-button");

    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Repository page")
    public RepositoryPage open(String code) {
        log.info("Open Repository page");
        driver.get(BASE_URL + "/project/"+code);
        return this;
    }
    @Step("Check if repository page is opened")
    public boolean isOpened(String title) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(REPOSITORY_NAME, title))));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    @Step("Open 'new test case' form")
    public void clickCaseButton() {
        log.info("Open 'new test case' form");
        driver.findElement(CASE_BUTTON).click();
    }

    @Step("Check how many test cases exist")
    public int getNumberOfTestCases(String title) {
        return driver.findElements(By.xpath(String.format(TEST_CASE_NAME, title))).size();
    }

    @Step("Edit test case")
    public void editTestCase(String title) {
        log.info("CLick on Edit test case: {}", title);
        driver.findElement(By.xpath(String.format(TEST_CASE_NAME, title))).click();
        driver.findElement(EDIT_BUTTON).click();
    }

    @Step("Delete test case")
    public void deleteTestCase(String title) {
        log.info("Delete test case: {}", title);
        driver.findElement(By.xpath(String.format(TEST_CASE_CHECKBOX, title))).click();
        driver.findElement(DELETE_BUTTON).click();
        driver.findElement(DELETE_INPUT).sendKeys("CONFIRM");
        driver.findElement(DELETE_CONFIRM_BUTTON).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(DELETE_MODAL));
    }
}

