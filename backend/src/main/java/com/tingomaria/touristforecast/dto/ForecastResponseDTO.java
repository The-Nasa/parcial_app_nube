package com.tingomaria.touristforecast.dto;

import java.time.LocalDate;

public record ForecastResponseDTO(
    String location,
    LocalDate date,
    WeatherDTO weather,
    PredictionDetailsDTO prediction
) {}
