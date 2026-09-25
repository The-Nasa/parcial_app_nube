package com.tingomaria.touristforecast.service;

import com.tingomaria.touristforecast.dto.ForecastResponseDTO;
import com.tingomaria.touristforecast.dto.PredictionDetailsDTO;
import com.tingomaria.touristforecast.dto.WeatherDTO;
import com.tingomaria.touristforecast.model.PredictionLog;
import com.tingomaria.touristforecast.repository.PredictionLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

@Service
public class ForecastService {

    private static final Logger log = LoggerFactory.getLogger(ForecastService.class);

    private final WeatherService weatherService;
    private final PredictionLogRepository predictionLogRepository;

    public ForecastService(WeatherService weatherService, PredictionLogRepository predictionLogRepository) {
        this.weatherService = weatherService;
        this.predictionLogRepository = predictionLogRepository;
    }

    public ForecastResponseDTO predictAttendance(LocalDate date, String locationParam) {
        LocalDate targetDate = (date != null) ? date : LocalDate.now();
        String targetLocation = (locationParam != null && !locationParam.isBlank()) ? locationParam : "Catarata Derrepente, Tingo María";
        WeatherDTO weather = weatherService.getWeatherForecast(targetDate, locationParam);

        // Algoritmo de Ponderación
        double baseVisitors = 50.0;
        double weatherFactor = calculateWeatherFactor(weather.precipitationMm(), weather.tempCelsius());
        double dayFactor = calculateDayFactor(targetDate.getDayOfWeek());
        double seasonFactor = calculateSeasonFactor(targetDate.getMonth());
        double holidayFactor = calculateHolidayFactor(targetDate);

        int estimatedVisitors = (int) Math.round(baseVisitors * weatherFactor * dayFactor * seasonFactor * holidayFactor);
        String crowdLevel = determineCrowdLevel(estimatedVisitors);
        String season = (seasonFactor > 1.0) ? "TEMPORADA_SECA" : "TEMPORADA_LLUVIAS";
        boolean isWeekend = targetDate.getDayOfWeek() == DayOfWeek.SATURDAY || targetDate.getDayOfWeek() == DayOfWeek.SUNDAY;
        boolean isHoliday = holidayFactor > 1.0;

        String safetyStatus;
        String recommendation;

        if (weather.precipitationMm() > 20.0) {
            safetyStatus = "ALERTA_PELIGRO";
            recommendation = "¡ATENCIÓN! Lluvia torrencial prevista en Tingo María. El caudal de la Catarata Derrepente puede aumentar repentinamente. Acceso no recomendado.";
        } else if (weather.precipitationMm() > 8.0) {
            safetyStatus = "PRECAUCION";
            recommendation = "Lluvia moderada. Se aconseja precaución en los senderos y usar calzado impermeable antideslizante.";
        } else {
            safetyStatus = "SEGURO";
            recommendation = "Día favorable para visitar la Catarata Derrepente. Disfruta del paisaje tropical y las aguas cristalinas.";
        }

        PredictionDetailsDTO predictionDetails = new PredictionDetailsDTO(
                estimatedVisitors,
                88,
                crowdLevel,
                season,
                isWeekend,
                isHoliday,
                safetyStatus,
                recommendation
        );

        // Registrar log en Supabase / H2 DB
        try {
            PredictionLog predictionLog = new PredictionLog(
                    targetDate,
                    estimatedVisitors,
                    crowdLevel,
                    safetyStatus,
                    weather.tempCelsius(),
                    weather.precipitationMm()
            );
            predictionLogRepository.save(predictionLog);
        } catch (Exception e) {
            log.warn("No se pudo guardar el log de prediccion en la BD: {}", e.getMessage());
        }

        return new ForecastResponseDTO(
                targetLocation,
                targetDate,
                weather,
                predictionDetails
        );
    }

    private double calculateWeatherFactor(double rainMm, double tempC) {
        if (rainMm > 20.0) return 0.05;
        if (rainMm > 8.0) return 0.25;
        if (rainMm > 2.0) return 0.55;
        if (rainMm > 0.0) return 1.10;
        return (tempC >= 26.0) ? 1.45 : 1.20;
    }

    private double calculateDayFactor(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case FRIDAY -> 1.30;
            case SATURDAY -> 2.25;
            case SUNDAY -> 2.65;
            default -> 1.00;
        };
    }

    private double calculateSeasonFactor(Month month) {
        // Temporada seca en Tingo María: Mayo a Octubre
        int m = month.getValue();
        return (m >= 5 && m <= 10) ? 1.35 : 0.65;
    }

    private double calculateHolidayFactor(LocalDate date) {
        // Fiesta de San Juan en Tingo Maria: 24 de Junio
        if (date.getMonth() == Month.JUNE && date.getDayOfMonth() == 24) return 2.80;
        // Fiestas Patrias: 28 y 29 de Julio
        if (date.getMonth() == Month.JULY && (date.getDayOfMonth() == 28 || date.getDayOfMonth() == 29)) return 2.80;
        return 1.00;
    }

    private String determineCrowdLevel(int visitors) {
        if (visitors < 60) return "BAJA";
        if (visitors <= 150) return "MODERADA";
        if (visitors <= 250) return "ALTA";
        return "MUY_ALTA";
    }
}
