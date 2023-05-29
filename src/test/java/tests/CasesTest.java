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
        testCasePage
                .fillIn(randomTest)
                .save();
        assertEquals(repositoryPage.getNumberOfTestCases(randomTest.getTitle()), 1,
                "Test case is not created");
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Edit test case")
    public void editTestCase() {
        Project project = ProjectFactory.getRandom();
        TestCase randomTest = TestCaseFactory.getRandom();
        TestCase randomTest1 = TestCaseFactory.getRandom();
        projectAdapter.create(project);
        caseAdapter.create(project.getCode(), randomTest.getTitle());
        loginPage
                .open()
                .login(user, password);
        assertTrue(projectListPage.isOpened(), "Login is not successful");
        repositoryPage
                .open(project.getCode())
                .editTestCase(randomTest.getTitle());
        testCasePage
                .editTitle(randomTest1)
                .save();
        assertEquals(repositoryPage.getNumberOfTestCases(randomTest1.getTitle()), 1,
                "Test case wasn't changed");
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Delete test case")
    public void deleteTestCase() {
        Project project = ProjectFactory.getRandom();
        TestCase randomTest = TestCaseFactory.getRandom();
        projectAdapter.create(project);
        caseAdapter.create(project.getCode(), randomTest.getTitle());
        loginPage
                .open()
                .login(user, password);
        assertTrue(projectListPage.isOpened(), "Login is not successful");
        projectListPage.openProject(project.getTitle());
        assertTrue(repositoryPage.isOpened(project.getCode()), "Repository page is not opened");
        repositoryPage.deleteTestCase(randomTest.getTitle());
        assertEquals(repositoryPage.getNumberOfTestCases(randomTest.getTitle()), 0,
                "Test case is not deleted");
        projectAdapter.delete(project.getCode());
    }
}