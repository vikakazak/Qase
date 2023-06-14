package adapters;

import static io.restassured.RestAssured.requestSpecification;

public class CaseAdapter extends BaseAdapter {

    public void create(String code, String title) {
        requestSpecification.
                body("{\"title\":\""+title+"\"}").
                when().
                post(BASE_URL+"/v1/case/"+code).
                then().
                log().body().
                statusCode(200);
    }
}
