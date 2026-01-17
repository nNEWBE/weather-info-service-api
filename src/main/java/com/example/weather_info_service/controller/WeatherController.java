package com.example.weather_info_service.controller;

import com.example.weather_info_service.model.WeatherDto;
import com.example.weather_info_service.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/weather")
@Validated
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<WeatherDto> getWeather(
            @RequestParam @NotBlank(message = "City name is required") String city) {
        return ResponseEntity.ok(weatherService.getWeather(city));
    }
}
