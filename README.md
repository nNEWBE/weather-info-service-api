# Weather Information Service API

A backend-only Spring Boot application that provides current weather information for a specified city.

## Features

- Fetches real-time weather data from [WeatherAPI](https://www.weatherapi.com/).
- Returns structured JSON response with essential weather details.
- Secure API key storage configuration.
- Global exception handling and validation.

## Prerequisites

- Java 17 or higher (Project configured for Java 25 compatibility)
- API Key from WeatherAPI (Required for external calls)

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/nNEWBE/weather-info-service-api.git
cd weather-info-service-api
```

### 2. Configuration
The application uses `src/main/resources/application.yaml` for configuration. The API Key is pre-configured, but for production, use environment variables.

```yaml
weather-api:
  key: ${WEATHER_API_KEY:cf7faa9e0f3b4893bc4145151261701}
  url: http://api.weatherapi.com/v1
```

### 3. Run the Application
You can run the application using Gradle:

```bash
./gradlew bootRun
```

The server will start at `http://localhost:8080`.

## API Documentation

### Get Weather Information

Retrieves current weather data for a given city.

- **Endpoint**: `GET /api/weather`
- **Query Parameter**: 
  - `city` (string, required): The name of the city to get weather for.

#### Request Example

```http
GET /api/weather?city=Dhaka
```

#### Successful Response (200 OK)

```json
{
  "latitude": 23.7,
  "longitude": 90.38,
  "temperature": 32.0,
  "wind": 15.0,
  "humidity": 60
}
```

#### Fields Description
- `latitude`: Geographic latitude of the city.
- `longitude`: Geographic longitude of the city.
- `temperature`: Current temperature in degrees Celsius.
- `wind`: Wind speed in kilometers per hour (kph).
- `humidity`: Humidity percentage.

#### Error Responses

- **400 Bad Request**: If `city` parameter is missing or empty.
  ```json
  {
    "error": "City name is required"
  }
  ```
- **400 Bad Request**: If the city is invalid or not found (from upstream).
  ```json
  {
      "error": "Invalid city name or bad request to upstream service"
  }
  ```
- **500 Internal Server Error**: If an unexpected error occurs.

## Security

- The API Key is stored in `application.yaml`. In a production environment, it is recommended to pass this as an environment variable or use a secret management service.
- The default configuration permits public access to the `/api/weather` endpoint.

## Project Structure

- **Controller**: Handles HTTP requests.
- **Service**: Business logic and external API communication.
- **Model**: DTOs for client response and external API mapping.
- **Exception**: Global exception handling.

