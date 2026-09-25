package com.tingomaria.touristforecast.dto;

public record WeatherDTO(
    double tempCelsius,
    String condition,
    String icon,
    double rainProbabilityPercentage,
    double precipitationMm,
    double humidityPercentage,
    double windKmH
) {}
