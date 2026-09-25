package com.tingomaria.touristforecast.controller;

import com.tingomaria.touristforecast.dto.ForecastResponseDTO;
import com.tingomaria.touristforecast.service.ForecastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/predictions")
@CrossOrigin(origins = "*")
@Tag(name = "Predictions", description = "Endpoints para estimacion de afluencia turistica y clima")
public class ForecastController {

    private final ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/forecast")
    @Operation(summary = "Obtener estimacion de visitantes y clima para Catarata Derrepente o cualquier otra ciudad")
    public ResponseEntity<ForecastResponseDTO> getForecast(
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        ForecastResponseDTO response = forecastService.predictAttendance(date, location);
        return ResponseEntity.ok(response);
    }
}
