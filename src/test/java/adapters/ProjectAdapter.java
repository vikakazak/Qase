package adapters;

import dto.Project;

import static io.restassured.RestAssured.*;

public class ProjectAdapter extends BaseAdapter{
    public static final String POSTFIX = "/v1/project/";

    public void create(Project project) {
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
