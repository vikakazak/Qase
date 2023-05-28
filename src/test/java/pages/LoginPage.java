package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final By EMAIL_INPUT = By.id("inputEmail");
    public static final By PASSWORD_INPUT = By.id("inputPassword");
    public static final By LOGIN_BUTTON = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening login page")
    public LoginPage open() {
        driver.get(BASE_URL + "/login");
        return this;
    }

    @Step("Login by user '{user}'")
    public void login(String user, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
}