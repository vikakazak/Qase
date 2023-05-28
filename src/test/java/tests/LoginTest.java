package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.TestListener;

import static org.testng.Assert.assertTrue;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(description = "Login with correct data")
    public void successfulLogin() {
        loginPage
                .open()
                .login(user, password);
        assertTrue(projectListPage.isOpened(), "Login is not successful");
    }
}
