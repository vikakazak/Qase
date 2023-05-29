package adapters;

import lombok.Data;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Data
public class CaseAdapter {
    public static final String BASE_URL = PropertyReader.getProperty("base.api");
    public CaseAdapter() {
        requestSpecification = given().
                header("content-type", "application/json").
                header("Token", System.getProperty("token", PropertyReader.getProperty("token")));
    }

    public void create(String code, String title) {
        requestSpecification.
                body("{\"title\":\""+title+"\"}").
                when().
                post(BASE_URL+"/v1/case/"+code).
                then().
                log().all().
                statusCode(200);
    }
}
