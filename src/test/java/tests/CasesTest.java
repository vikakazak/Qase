package tests;

import dto.Project;
import dto.ProjectFactory;
import dto.TestCase;
import dto.TestCaseFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CasesTest extends BaseTest {

    @Test(description = "Create test case")
    public void createTestCase() {
        Project project = ProjectFactory.getRandom();
        projectAdapter.create(project);
        loginPage
                .open()
                .login(user, password);
        assertTrue(projectListPage.isOpened(), "Login is not successful");
        projectListPage.openProject(project.getTitle());
        assertTrue(repositoryPage.isOpened(project.getCode()), "Repository page is not opened");
        repositoryPage.clickCaseButton();
        TestCase randomTest = TestCaseFactory.getRandom();
        newTestCasePage
                .fillIn(randomTest)
                .save();
        assertEquals(repositoryPage.getNumberOfTestCases(randomTest.getTitle()), 1,
                "Test case is not created");
        projectAdapter.delete(project.getCode());
    }
}