Feature: Weather Forecasts for Cities
  Get weather forecast for city with different parameters

  Scenario: Verify that GET by cityName returns 200
    When I get forecast by CityName "San Mateo"
    Then I should receive status "200"

  Scenario: Verify that GET by cityId returns 200
    When I get forecast by CityId "5392423"
    Then I should receive status "200"

  Scenario: Verify that GET by city coordinates returns 200
    When I get forecast by City coordinates
    | Longitude  | Latitude |
    | -122.3067  | 37.544   |
    Then I should receive status "200"

  Scenario: Verify that GET by city zipCode returns 200
    When I get forecast by CityZipCode "94497"
    Then I should receive status "200"

  Scenario: Verify that different GET city results returns same ID for city
    When I get forecast by CityName "San Mateo"
    And I get forecast by CityId "5392423"
    Then I should have same cityId as in first request
    When I get forecast by City coordinates
      | Longitude  | Latitude |
      | -122.3067  | 37.544   |
    Then I should have same cityId as in first request