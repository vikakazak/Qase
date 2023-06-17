package adapters;

import utils.PropertyReader;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class BaseAdapter {
    public static final String BASE_URL = PropertyReader.getProperty("base.api");
    public BaseAdapter() {
        requestSpecification = given().
                header("content-type", "application/json").
                header("Token", System.getProperty("token", PropertyReader.getProperty("token")));
    }
}
