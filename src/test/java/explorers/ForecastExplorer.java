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
    public Response getForecastByCityName(CityData cityData){
        Response response =  baseRequest()
                .param("q", cityData.getCityName())
                .get(getForecastEndpoint);
        response.then().statusCode(200);
        return response;
    }

//    By city ID
//    api.openweathermap.org/data/2.5/forecast?id={city ID}
//    api.openweathermap.org/data/2.5/forecast?id=707860&APPID={{APIKEY}}
    public Response getForecastByCityId(CityData cityData){
        Response response =  baseRequest()
                .param("id", cityData.getCityID())
                .get(getForecastEndpoint);
        response.then().statusCode(200);
        return response;
    }

//By geographic coordinates
//api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}
//api.openweathermap.org/data/2.5/forecast?lat=35&lon=139&APPID={{APIKEY}}
    public Response getForecastByCityCoordinates(CityData cityData){
        Response response =  baseRequest()
                .param("lat", cityData.getLatitude())
                .param("lon", cityData.getLongtitude())
                .get(getForecastEndpoint);
        response.then().statusCode(200);
        return response;
    }

//By ZIP code
//api.openweathermap.org/data/2.5/forecast?zip={zip code},{country code}
//api.openweathermap.org/data/2.5/forecast?zip=94040,us
public Response getForecastByZipCode(CityData cityData){
    Response response =  baseRequest()
            .param("zip", cityData.getZipCodeWithCountryCode())
            .get(getForecastEndpoint);
    response.then().statusCode(200);
    return response;
}
}
