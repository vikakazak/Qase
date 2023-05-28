package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectListPage extends BasePage {
    public static final By CREATE_BUTTON = By.id("createButton");
    String PROJECT_NAME = "//*[@class='defect-title'][text()='%s']";
    String DROPDOWN_SETTINGS = "//*[text()='%s']/ancestor::tr//a[@class='btn btn-dropdown']";
    String DELETE = "//*[@class='defect-title'][text()='%s']/ancestor::tr//button[text()='Delete']";
    public static final By DELETE_PROJECT_BUTTON = By.xpath("//span[text()='Delete project']");
    public static final By DELETE_MODAL = By.cssSelector(".ReactModal__Content");

    public ProjectListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open 'Project List' page")
    public ProjectListPage open() {
        driver.get(BASE_URL + "/projects");
        return this;
    }

    @Step("Check if projects list page is opened")
    public boolean isOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_BUTTON));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    @Step("Click on Create new project button")
    public void clickCreate() {
        driver.findElement(CREATE_BUTTON).click();
    }

    @Step("Open project")
    public void openProject(String title) {
        driver.findElement(By.xpath(String.format(PROJECT_NAME, title))).click();
    }

    @Step("Delete project")
    public void deleteProject(String title) {
        driver.findElement(By.xpath(String.format(DROPDOWN_SETTINGS, title))).click();
        driver.findElement(By.xpath(String.format(DELETE, title))).click();
        driver.findElement(DELETE_PROJECT_BUTTON).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(DELETE_MODAL));
    }

    public int getNumberOfProjects(String project) {
        return driver.findElements(By.xpath(String.format(PROJECT_NAME, project))).size();
    }
}
