package com.tingomaria.touristforecast.dto;

import java.time.LocalDate;

public record HistoricalDataDTO(
    LocalDate date,
    int actualVisitors,
    double tempCelsius,
    double rainMm,
    String condition,
    String dayOfWeek
) {}
