package stepdefs;

import context.ForecastContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import explorers.ForecastExplorer;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.testng.Assert;
import users.BaseUser;
import users.MainUser;

import java.util.List;
import java.util.Map;

@Slf4j
public class ForeCastDefinitions {

    private ForecastContext testContext = new ForecastContext();
    private BaseUser mainUser = new MainUser();
    private ForecastExplorer forecastExplorer = new ForecastExplorer(mainUser);

    @When("^I get forecast by CityName \"([^\"]*)\"$")
    public void i_get_forecast_by_cityname(String cityName){
        Response response = forecastExplorer.getForecastByCityName(cityName);
        testContext.setResponse(response);
        testContext.setInitialResponse(response);
    }

    @When("^I get forecast by CityId \"([^\"]*)\"$")
    public void iGetForecastByCityId(String cityId) {
        Response response = forecastExplorer.getForecastByCityId(cityId);
        testContext.setResponse(response);
    }

    @When("^I get forecast by CityZipCode \"([^\"]*)\"$")
    public void iGetForecastByCityZipCode(String zipCode) {
        Response response = forecastExplorer.getForecastByZipCode(zipCode);
        testContext.setResponse(response);
    }

    @Then("^I should receive status \"(\\d+)\"$")
    public void should_receive_status(int status){
        Assert.assertEquals(testContext.getResponse().statusCode(), status);
        String result = testContext.getResponse().asString();
        log.info("result={}", result);
    }

    @When("^I get forecast by City coordinates$")
    public void iGetForecastByCityCoordinates(DataTable arg) {
        List<Map<String, String>> list = arg.asMaps(String.class, String.class);
        String longitude = list.get(0).get("Longitude");
        String latitude = list.get(0).get("Latitude");
        Response response = forecastExplorer.getForecastByCityCoordinates(longitude, latitude);
        testContext.setResponse(response);
    }

    @Then("^I should have same cityId as in first request$")
    public void iShouldHaveSameCityIdAsInFirstRequest() {
        Response responseById = testContext.getInitialResponse();
        Response responseToCompare = testContext.getResponse();
        int initialId = new JSONObject(responseById.asString()).getJSONObject("city").getInt("id");
        int otherId = new JSONObject(responseToCompare.asString()).getJSONObject("city").getInt("id");
        Assert.assertEquals(initialId, otherId, "id from request isn't the same as in initial");
    }
}