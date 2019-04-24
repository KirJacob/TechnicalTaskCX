package explorers;

import enums.CityData;
import io.restassured.response.Response;
import users.BaseUser;

public class ForecastExplorer extends BaseExplorer{

    public ForecastExplorer(BaseUser user) {
        super(user);
    }

    String getForecastEndpoint = "forecast";

//    By city name
//    api.openweathermap.org/data/2.5/forecast?q={city name},{country code}
//    api.openweathermap.org/data/2.5/forecast?q=London,uk&APPID={{APIKEY}}
    public Response getForecastByCityName(String cityName){
        Response response =  baseRequest()
                .param("q", cityName)
                .get(getForecastEndpoint);
        return response;
    }

//    By city ID
//    api.openweathermap.org/data/2.5/forecast?id={city ID}
//    api.openweathermap.org/data/2.5/forecast?id=707860&APPID={{APIKEY}}
    public Response getForecastByCityId(String cityId){
        Response response =  baseRequest()
                .param("id", cityId)
                .get(getForecastEndpoint);
        response.then().statusCode(200);
        return response;
    }

//By geographic coordinates
//api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}
//api.openweathermap.org/data/2.5/forecast?lat=35&lon=139&APPID={{APIKEY}}
    public Response getForecastByCityCoordinates(String longitude, String latitude){
        Response response =  baseRequest()
                .param("lat", latitude)
                .param("lon", longitude)
                .get(getForecastEndpoint);
        response.then().statusCode(200);
        return response;
    }

//By ZIP code
//api.openweathermap.org/data/2.5/forecast?zip={zip code},{country code}
//api.openweathermap.org/data/2.5/forecast?zip=94040,us
public Response getForecastByZipCode(String zipCode){
    Response response =  baseRequest()
            .param("zip", zipCode)
            .get(getForecastEndpoint);
    response.then().statusCode(200);
    return response;
}
}
