package com.example.weather_info_service.service;

import com.example.weather_info_service.model.WeatherDto;
import com.example.weather_info_service.model.external.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${weather-api.url}")
    private String apiUrl;

    @Value("${weather-api.key}")
    private String apiKey;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherDto getWeather(String city) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .path("/current.json")
                .queryParam("key", apiKey)
                .queryParam("q", city)
                .toUriString();

        WeatherApiResponse response = restTemplate.getForObject(url, WeatherApiResponse.class);

        if (response == null || response.getLocation() == null || response.getCurrent() == null) {
            throw new RuntimeException("Failed to fetch weather data");
        }

        return WeatherDto.builder()
                .latitude(response.getLocation().getLat())
                .longitude(response.getLocation().getLon())
                .temperature(response.getCurrent().getTempC())
                .wind(response.getCurrent().getWindKph())
                .humidity(response.getCurrent().getHumidity())
                .build();
    }
}
