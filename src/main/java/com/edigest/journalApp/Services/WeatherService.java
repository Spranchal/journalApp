package com.edigest.journalApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.edigest.journalApp.api.response.WeatherResponse;

public class WeatherService {
    private static final String apiKey = "8ad995b87e1b4e7e889134610261203";

    private static final String API = "http://api.weatherapi.com/v1/current.json?key=API_KEY&q=CITY&aqi=yes";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        String finalApi = API.replace("CITY", city).replace("API_KEY", apiKey);
        ResponseEntity<WeatherResponse>response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
