package com.tingomaria.touristforecast.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "historical_attendance")
public class HistoricalAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "record_date", nullable = false, unique = true)
    private LocalDate recordDate;

    @Column(name = "actual_visitors", nullable = false)
    private Integer actualVisitors;

    @Column(name = "temp_celsius", nullable = false)
    private Double tempCelsius;

    @Column(name = "precipitation_mm", nullable = false)
    private Double precipitationMm;

    @Column(name = "weather_condition", nullable = false)
    private String weatherCondition;

    @Column(name = "is_weekend", nullable = false)
    private Boolean isWeekend;

    @Column(name = "is_holiday", nullable = false)
    private Boolean isHoliday;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public HistoricalAttendance() {}

    public HistoricalAttendance(LocalDate recordDate, Integer actualVisitors, Double tempCelsius, 
                                Double precipitationMm, String weatherCondition, Boolean isWeekend, Boolean isHoliday) {
        this.recordDate = recordDate;
        this.actualVisitors = actualVisitors;
        this.tempCelsius = tempCelsius;
        this.precipitationMm = precipitationMm;
        this.weatherCondition = weatherCondition;
        this.isWeekend = isWeekend;
        this.isHoliday = isHoliday;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getRecordDate() { return recordDate; }
    public void setRecordDate(LocalDate recordDate) { this.recordDate = recordDate; }

    public Integer getActualVisitors() { return actualVisitors; }
    public void setActualVisitors(Integer actualVisitors) { this.actualVisitors = actualVisitors; }

    public Double getTempCelsius() { return tempCelsius; }
    public void setTempCelsius(Double tempCelsius) { this.tempCelsius = tempCelsius; }

    public Double getPrecipitationMm() { return precipitationMm; }
    public void setPrecipitationMm(Double precipitationMm) { this.precipitationMm = precipitationMm; }

    public String getWeatherCondition() { return weatherCondition; }
    public void setWeatherCondition(String weatherCondition) { this.weatherCondition = weatherCondition; }

    public Boolean getIsWeekend() { return isWeekend; }
    public void setIsWeekend(Boolean isWeekend) { this.isWeekend = isWeekend; }

    public Boolean getIsHoliday() { return isHoliday; }
    public void setIsHoliday(Boolean isHoliday) { this.isHoliday = isHoliday; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
