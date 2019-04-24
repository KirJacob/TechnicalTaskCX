package scenarios;

import enums.CityData;
import explorers.ForecastExplorer;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.BaseUser;
import users.MainUser;

@Slf4j
public class ForeCastTest {

    ForecastExplorer forecastExplorer;
    BaseUser mainUser = new MainUser();

    @BeforeClass
    public void before(){
        forecastExplorer = new ForecastExplorer(mainUser);
    }

    @AfterMethod
    public void after() throws InterruptedException {
        Thread.sleep(5000);//to see complete info in logs
    }

    @Test(priority = 1, enabled = true)
    public void testCityByName200(){
        log.info("TEST> verify that GET by cityName returns 200");
        Response response = forecastExplorer.getForecastByCityName(CityData.SAN_MATEO_US.getCityName());
        Assert.assertEquals(response.statusCode(), 200);
        String result = response.asString();
        log.info("result={}", result);
    }

    @Test(priority = 2, enabled = true)
    public void testCityByCityId200(){
        log.info("TEST> verify that GET by cityId returns 200");
        Response response = forecastExplorer.getForecastByCityId("5392423");
        String result = response.asString();
        log.info("result={}", result);
    }

    @Test(priority = 3, enabled = true)
    public void testCityByCityCoord200(){
        log.info("TEST> verify that GET by city coordinates returns 200");
        Response response = forecastExplorer.getForecastByCityCoordinates("-122.3067", "37.544");
        String result = response.asString();
        log.info("result={}", result);
    }

    @Test(priority = 4, enabled = true)
    public void testCityByCityZipCode200(){
        log.info("TEST> verify that GET by city zipCode returns 200");
        Response response = forecastExplorer.getForecastByZipCode("94497");
        String result = response.asString();
        log.info("result={}", result);
    }

    @Test(priority = 5, enabled = true)
    public void testThatDifferentGetByCityReturnsSame(){
        log.info("TEST> verify that different GET city results returns same ID for city");

        Response responseById = forecastExplorer.getForecastByCityId("5392423");
        int idById = new JSONObject(responseById.asString()).getJSONObject("city").getInt("id");

        Response responseByName = forecastExplorer.getForecastByCityName(CityData.SAN_MATEO_US.getCityName());
        int idByName = new JSONObject(responseByName.asString()).getJSONObject("city").getInt("id");
        Assert.assertEquals(idByName, idById, "get city by name doesn't return correct id");

        Response responseByCoord = forecastExplorer.getForecastByCityCoordinates("-122.3067", "37.544");
        int idByCoord = new JSONObject(responseByCoord.asString()).getJSONObject("city").getInt("id");
        Assert.assertEquals(idByCoord, idById, "get city by Coord doesn't return correct id");

        //For zip code it returns different city id somehow
    }

    //other possible stories which are not covered
    //cast response ro model and compare that all data are the same for different get result
    //verify that there is a fields like temperature, humidity etc in response, validate that they are within some range
    //validate that not correct response return 400, empty parameter or something
}
