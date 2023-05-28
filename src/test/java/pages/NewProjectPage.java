package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewProjectPage extends BasePage {

    public static final By PROJECT_NAME = By.id("project-name");
    public static final By PROJECT_CODE = By.id("project-code");
    public static final By DESCRIPTION = By.id("description-area");
    public static final By PUBLIC_RADIOBUTTON = By.xpath("//*[text()='Public']");
    public static final By CREATE_BUTTON = By.xpath("//*[text()='Create project']");


    public NewProjectPage(WebDriver driver) {
        super(driver);
    }


    @Step("Create new project")
    public void createProject(String name, String code, String description) {
        driver.findElement(PROJECT_NAME).sendKeys(name);
        driver.findElement(PROJECT_CODE).clear();
        driver.findElement(PROJECT_CODE).sendKeys(code);
        driver.findElement(DESCRIPTION).sendKeys(description);
        driver.findElement(PUBLIC_RADIOBUTTON).click();
        driver.findElement(CREATE_BUTTON).click();
    }
}
