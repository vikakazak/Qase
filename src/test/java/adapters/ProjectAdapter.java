package adapters;

import dto.Project;
import lombok.Data;
import utils.PropertyReader;

import static io.restassured.RestAssured.*;

@Data
public class ProjectAdapter{
    public static final String BASE_URL = PropertyReader.getProperty("base.api");
    public static final String POSTFIX = "/v1/project/";
    public ProjectAdapter() {
        requestSpecification = given().
                header("content-type", "application/json").
                header("Token", System.getProperty("token", PropertyReader.getProperty("token")));
    }

    public void create(Project project) {
        requestSpecification.
                body(project).
                when().
                post(BASE_URL+POSTFIX).
                then().
                log().all().
                statusCode(200);
    }

    public void delete(String code) {
        requestSpecification.
                when().
                delete(BASE_URL+POSTFIX+code).
                then().
                log().all().
                statusCode(200);
    }
}
