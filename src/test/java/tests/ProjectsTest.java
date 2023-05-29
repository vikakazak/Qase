package tests;

import dto.Project;
import dto.ProjectFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectsTest extends BaseTest {
    @Test(description = "Create project")
    public void createNewProject() {
        Project project = ProjectFactory.getRandom();
        loginPage
                .open()
                .login(user, password);
        assertTrue(projectListPage.isOpened(), "Login is not successful");
        projectListPage.clickCreate();
        newProjectPage.createProject(project.getTitle(), project.getCode(), project.getDescription());;
        projectListPage.open();
        assertEquals(projectListPage.getNumberOfProjects(project.getTitle()), 1,
                "Project isn't displayed in the list");
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Update project")
    public void updateProject() {
        Project project = ProjectFactory.getRandom();
        Project project1 = ProjectFactory.getRandom();
        projectAdapter.create(project);
        loginPage
                .open()
                .login(user, password);
        assertTrue(projectListPage.isOpened(), "Login is not successful");
        projectListPage.openSettings(project.getTitle());
        projectSettingsPage.updateProject(project1.getTitle(), project1.getCode(), project1.getDescription());
        projectListPage.open();
        assertEquals(projectListPage.getNumberOfProjects(project1.getTitle()), 1,
                "Project isn't displayed in the list");
        projectAdapter.delete(project1.getCode());
    }

    @Test(description = "Delete project")
    public void deleteProject() {
        Project project = ProjectFactory.getRandom();
        projectAdapter.create(project);
        loginPage
                .open()
                .login(user, password);
        assertTrue(projectListPage.isOpened(), "Login is not successful");
        projectListPage.deleteProject(project.getTitle());
        assertEquals(projectListPage.getNumberOfProjects(project.getTitle()), 0,
                "Project wasn't deleted");
    }
}
