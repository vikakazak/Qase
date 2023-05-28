package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoryPage extends BasePage {
    String REPOSITORY_NAME = "//h1[contains(text() , '%s')]";
    String TEST_CASE_NAME = "//*[text()='%s']";
    public static final By CASE_BUTTON = By.id("create-case-button");

    public RepositoryPage(WebDriver driver) {
        super(driver);
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
}

