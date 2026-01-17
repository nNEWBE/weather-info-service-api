package com.example.weather_info_service.model;

public class WeatherDto {
    private Double latitude;
    private Double longitude;
    private Double temperature;
    private Double wind;
    private Integer humidity;

    public WeatherDto() {
    }

    public WeatherDto(Double latitude, Double longitude, Double temperature, Double wind, Integer humidity) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWind() {
        return wind;
    }

    public void setWind(Double wind) {
        this.wind = wind;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Double latitude;
        private Double longitude;
        private Double temperature;
        private Double wind;
        private Integer humidity;

        public Builder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder wind(Double wind) {
            this.wind = wind;
            return this;
        }

        public Builder humidity(Integer humidity) {
            this.humidity = humidity;
            return this;
        }

        public WeatherDto build() {
            return new WeatherDto(latitude, longitude, temperature, wind, humidity);
        }
    }
}
