package enums;

public enum CityData {
    SAN_MATEO_US("San Mateo", "us", "5392423", "-122.3067", "37.544", "94497"),
    HURZUF_UA("", "", "707860", "", "", ""),
    SOME_OTHER_COORD("", "", "", "139", "35", ""),
    SOME_OTHER_ZIP("", "", "", "", "", "94040");

    private String cityName;
    private String countryName;
    private String cityID;
    private String longtitude;
    private String latitude;
    private String zipCode;

    CityData(String cityName, String countryName, String cityID, String longtitude, String latitude, String zipCode) {
        this.countryName = countryName;
        this.cityName = cityName;
        this.cityID = cityID;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.zipCode = zipCode;
    }

    public String getCityName(){
        return this.cityName + "," + this.countryName;
    }

    public String getCityID() {
        return this.cityID;
    }

    public String getLongtitude() {
        return this.longtitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getZipCodeWithCountryCode() {
        return this.zipCode + "," + this.countryName;
    }
}
