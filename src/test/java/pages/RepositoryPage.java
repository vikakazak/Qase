package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RepositoryPage extends BasePage {
    String REPOSITORY_NAME = "//h1[contains(text() , '%s')]";
    String TEST_CASE_NAME = "//*[text()='%s']";
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
        driver.get(BASE_URL + "/project/"+code);
        return this;
    }
    @Step("Check if repository page is opened")
    public boolean isOpened(String title) {
        return driver.findElement(By.xpath(String.format(REPOSITORY_NAME, title))).isDisplayed();
    }

    @Step("Open 'new test case' form")
    public void clickCaseButton() {
        driver.findElement(CASE_BUTTON).click();
    }

    public int getNumberOfTestCases(String title) {
        return driver.findElements(By.xpath(String.format(TEST_CASE_NAME, title))).size();
    }

    public void editTestCase(String title) {
        driver.findElement(By.xpath(String.format(TEST_CASE_NAME, title))).click();
        driver.findElement(EDIT_BUTTON).click();
    }

    public void deleteTestCase(String title) {
        driver.findElement(By.xpath(String.format(TEST_CASE_CHECKBOX, title))).click();
        driver.findElement(DELETE_BUTTON).click();
        driver.findElement(DELETE_INPUT).sendKeys("CONFIRM");
        driver.findElement(DELETE_CONFIRM_BUTTON).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(DELETE_MODAL));
    }
}

