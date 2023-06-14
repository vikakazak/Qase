package pages;

import dto.Project;
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
    public void createProject(Project project) {
        driver.findElement(PROJECT_NAME).sendKeys(project.getTitle());
        driver.findElement(PROJECT_CODE).clear();
        driver.findElement(PROJECT_CODE).sendKeys(project.getCode());
        driver.findElement(DESCRIPTION).sendKeys(project.getDescription());
        driver.findElement(PUBLIC_RADIOBUTTON).click();
        driver.findElement(CREATE_BUTTON).click();
    }
}
