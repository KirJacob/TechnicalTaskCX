package explorers;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import users.BaseUser;

public class BaseExplorer {

    String apiKey;

    public BaseExplorer(BaseUser user) {
        this.apiKey = user.getApiKey();
    }

    protected RequestSpecification baseRequest(){
        RestAssured.baseURI = "https://api.openweathermap.org/data";
        RestAssured.basePath = "/2.5/";
        return RestAssured
                .given()
                .log()
                .uri()
                .header("Content-Type", "application/json")
                .param("APPID", apiKey);
    }
}
