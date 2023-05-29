package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectSettingsPage extends BasePage{
    public static final By PROJECT_NAME = By.id("project-name");
    public static final By PROJECT_CODE = By.id("project-code");
    public static final By DESCRIPTION = By.id("description-area");
    public static final By PRIVATE_RADIOBUTTON = By.cssSelector("input[value=private]");
    public static final By UPDATE_BUTTON = By.cssSelector("button[type=submit]");


    public ProjectSettingsPage (WebDriver driver) {
        super(driver);
    }


    @Step("Update project")
    public void updateProject(String name, String code, String description) {
        driver.findElement(PROJECT_NAME).clear();
        driver.findElement(PROJECT_NAME).sendKeys(name);
        driver.findElement(PROJECT_CODE).clear();
        driver.findElement(PROJECT_CODE).sendKeys(code);
        driver.findElement(DESCRIPTION).clear();
        driver.findElement(DESCRIPTION).sendKeys(description);
        driver.findElement(PRIVATE_RADIOBUTTON).click();
        driver.findElement(UPDATE_BUTTON).click();
    }
}
