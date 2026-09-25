package com.tingomaria.touristforecast.dto;

public record PredictionDetailsDTO(
    int estimatedVisitors,
    int confidencePercentage,
    String crowdLevel,
    String season,
    boolean isWeekend,
    boolean isHoliday,
    String safetyStatus,
    String recommendation
) {}
