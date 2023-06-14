package adapters;

import dto.Project;
import lombok.extern.log4j.Log4j2;

import static io.restassured.RestAssured.*;

@Log4j2
public class ProjectAdapter extends BaseAdapter{
    public static final String POSTFIX = "/v1/project/";

    public void create(Project project) {
        log.info("Create project by api: {}", project);
        requestSpecification.
                body(project).
                log().body().
        when().
                post(BASE_URL+POSTFIX).
        then().
                log().body().
                statusCode(200);
    }

    public void delete(String code) {
        requestSpecification.
        when().
                delete(BASE_URL+POSTFIX+code).
        then().
                log().body().
                statusCode(200);
    }
}
