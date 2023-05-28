package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;

abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public static final String BASE_URL = PropertyReader.getProperty("base.url");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}