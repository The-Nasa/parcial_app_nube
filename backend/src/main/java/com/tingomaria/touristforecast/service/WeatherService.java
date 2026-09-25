package com.tingomaria.touristforecast.service;

import com.tingomaria.touristforecast.dto.WeatherDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Map;

@Service
public class WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    private final RestTemplate restTemplate;

    @Value("${weather.api.key:mock_key}")
    private String apiKey;

    @Value("${weather.api.url:https://api.weatherapi.com/v1/forecast.json}")
    private String apiUrl;

    @Value("${weather.api.location:Tingo Maria}")
    private String location;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "weatherCache", key = "#date.toString() + '_' + (#locationParam != null ? #locationParam : 'default')")
    public WeatherDTO getWeatherForecast(LocalDate date, String locationParam) {
        String queryLocation = (locationParam != null && !locationParam.isBlank()) ? locationParam : location;
        log.info("Buscando pronostico de clima para la ubicacion: {} en la fecha: {}", queryLocation, date);

        if ("mock_key".equalsIgnoreCase(apiKey)) {
            log.warn("Usando API Key Mock. Generando clima para {}", queryLocation);
            return generateMockWeather(date);
        }

        try {
            String url = String.format("%s?key=%s&q=%s&dt=%s", apiUrl, apiKey, queryLocation, date);
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            return parseWeatherResponse(response);
        } catch (Exception e) {
            log.error("Error al consultar API externa de clima para {}: {}. Aplicando Fallback.", queryLocation, e.getMessage());
            return generateMockWeather(date);
        }
    }

    private WeatherDTO parseWeatherResponse(Map<String, Object> response) {
        try {
            double tempC = 25.0;
            double precipitationMm = 0.0;
            double humidity = 70.0;
            double windKmH = 10.0;
            String conditionText = "Soleado";
            String icon = "//cdn.weatherapi.com/weather/64x64/day/113.png";
            double rainProb = 10.0;

            if (response.containsKey("current")) {
                Map<String, Object> current = (Map<String, Object>) response.get("current");
                if (current.containsKey("temp_c")) tempC = Double.parseDouble(current.get("temp_c").toString());
                if (current.containsKey("precip_mm")) precipitationMm = Double.parseDouble(current.get("precip_mm").toString());
                if (current.containsKey("humidity")) humidity = Double.parseDouble(current.get("humidity").toString());
                if (current.containsKey("wind_kph")) windKmH = Double.parseDouble(current.get("wind_kph").toString());
                if (current.containsKey("condition")) {
                    Map<String, Object> conditionMap = (Map<String, Object>) current.get("condition");
                    if (conditionMap.containsKey("text")) conditionText = conditionMap.get("text").toString();
                    if (conditionMap.containsKey("icon")) icon = conditionMap.get("icon").toString();
                }
            }

            if (response.containsKey("forecast")) {
                Map<String, Object> forecast = (Map<String, Object>) response.get("forecast");
                if (forecast.containsKey("forecastday")) {
                    java.util.List<Map<String, Object>> forecastday = (java.util.List<Map<String, Object>>) forecast.get("forecastday");
                    if (!forecastday.isEmpty()) {
                        Map<String, Object> dayObj = (Map<String, Object>) forecastday.get(0).get("day");
                        if (dayObj != null) {
                            if (dayObj.containsKey("daily_chance_of_rain")) {
                                rainProb = Double.parseDouble(dayObj.get("daily_chance_of_rain").toString());
                            }
                            if (dayObj.containsKey("totalprecip_mm")) {
                                precipitationMm = Double.parseDouble(dayObj.get("totalprecip_mm").toString());
                            }
                        }
                    }
                }
            }

            log.info("Clima obtenido exitosamente de WeatherAPI -> Temp: {}°C, Condicion: '{}', Lluvia: {}mm", tempC, conditionText, precipitationMm);
            return new WeatherDTO(tempC, conditionText, icon, rainProb, precipitationMm, humidity, windKmH);
        } catch (Exception e) {
            log.error("Error parseando respuesta de clima WeatherAPI: {}", e.getMessage(), e);
            return generateMockWeather(LocalDate.now());
        }
    }

    private WeatherDTO generateMockWeather(LocalDate date) {
        int dayHash = Math.abs(date.hashCode());
        double tempC = 26.0 + (dayHash % 6);
        double rainMm = (dayHash % 10 < 3) ? (dayHash % 15) * 1.5 : 0.0;
        String condition = rainMm > 15 ? "Lluvia Torrencial" : (rainMm > 0 ? "Lluvia Ligera" : "Soleado");
        String icon = rainMm > 0 ? "rain" : "sun";
        double rainProb = rainMm > 0 ? 80.0 : 15.0;

        return new WeatherDTO(tempC, condition, icon, rainProb, rainMm, 75.0, 10.0);
    }
}
