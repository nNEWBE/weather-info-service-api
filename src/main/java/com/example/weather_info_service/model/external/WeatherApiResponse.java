package com.example.weather_info_service.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherApiResponse {
    private Location location;
    private Current current;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public static class Location {
        private Double lat;
        private Double lon;

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }
    }

    public static class Current {
        @JsonProperty("temp_c")
        private Double tempC;

        @JsonProperty("wind_kph")
        private Double windKph;

        private Integer humidity;

        public Double getTempC() {
            return tempC;
        }

        public void setTempC(Double tempC) {
            this.tempC = tempC;
        }

        public Double getWindKph() {
            return windKph;
        }

        public void setWindKph(Double windKph) {
            this.windKph = windKph;
        }

        public Integer getHumidity() {
            return humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }
    }
}
