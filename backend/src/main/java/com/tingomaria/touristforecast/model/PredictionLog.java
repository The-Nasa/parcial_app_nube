package com.tingomaria.touristforecast.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "prediction_logs")
public class PredictionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "requested_date", nullable = false)
    private LocalDate requestedDate;

    @Column(name = "estimated_visitors", nullable = false)
    private Integer estimatedVisitors;

    @Column(name = "crowd_level", nullable = false)
    private String crowdLevel;

    @Column(name = "safety_status", nullable = false)
    private String safetyStatus;

    @Column(name = "forecast_temp", nullable = false)
    private Double forecastTemp;

    @Column(name = "forecast_rain_mm", nullable = false)
    private Double forecastRainMm;

    @Column(name = "query_timestamp")
    private LocalDateTime queryTimestamp = LocalDateTime.now();

    public PredictionLog() {}

    public PredictionLog(LocalDate requestedDate, Integer estimatedVisitors, String crowdLevel,
                         String safetyStatus, Double forecastTemp, Double forecastRainMm) {
        this.requestedDate = requestedDate;
        this.estimatedVisitors = estimatedVisitors;
        this.crowdLevel = crowdLevel;
        this.safetyStatus = safetyStatus;
        this.forecastTemp = forecastTemp;
        this.forecastRainMm = forecastRainMm;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getRequestedDate() { return requestedDate; }
    public void setRequestedDate(LocalDate requestedDate) { this.requestedDate = requestedDate; }

    public Integer getEstimatedVisitors() { return estimatedVisitors; }
    public void setEstimatedVisitors(Integer estimatedVisitors) { this.estimatedVisitors = estimatedVisitors; }

    public String getCrowdLevel() { return crowdLevel; }
    public void setCrowdLevel(String crowdLevel) { this.crowdLevel = crowdLevel; }

    public String getSafetyStatus() { return safetyStatus; }
    public void setSafetyStatus(String safetyStatus) { this.safetyStatus = safetyStatus; }

    public Double getForecastTemp() { return forecastTemp; }
    public void setForecastTemp(Double forecastTemp) { this.forecastTemp = forecastTemp; }

    public Double getForecastRainMm() { return forecastRainMm; }
    public void setForecastRainMm(Double forecastRainMm) { this.forecastRainMm = forecastRainMm; }

    public LocalDateTime getQueryTimestamp() { return queryTimestamp; }
    public void setQueryTimestamp(LocalDateTime queryTimestamp) { this.queryTimestamp = queryTimestamp; }
}
