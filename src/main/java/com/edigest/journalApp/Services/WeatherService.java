package com.edigest.journalApp.Services;

import org.springframework.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edigest.journalApp.api.response.WeatherResponse;
import com.edigest.journalApp.cache.AppCache;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    // private static final String API = "http://api.weatherapi.com/v1/current.json?key=API_KEY&q=CITY&aqi=yes";

    @Autowired
    private AppCache appCache;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        String finalApi = appCache.APP_CACHE.get("weather_api").replace("<city>", city).replace("<apiKey>", apiKey);

        // String requestBody = "{\r\n" + 
        //                 "    \"userName\": \"Shyam\",\r\n" + 
        //                 "    \"password\": \"Shyam\"\r\n" + 
        //                 "}";
        // HttpHeaders httpHeaders = new HttpHeaders();
        // httpHeaders.set("key", "value"); 
        // User user = User.builder().username("Shyam").password("Shyam").build();
        // HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);

        ResponseEntity<WeatherResponse>response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
        // api = "sk_ffc607c3c5d30eb0f2ae0536e9b5329c9e9f17071fb5cfce" 
        // api = "sk_ca2add37e308db202e46de76f3f93c9443cf371c8a76111b"
    }
}
