package com.tingomaria.touristforecast.controller;

import com.tingomaria.touristforecast.dto.HistoricalDataDTO;
import com.tingomaria.touristforecast.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
@Tag(name = "History", description = "Endpoints para datos historicos de afluencia en Supabase")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    @Operation(summary = "Obtener historial reciente de afluencia y clima pasado")
    public ResponseEntity<List<HistoricalDataDTO>> getHistory() {
        List<HistoricalDataDTO> history = historyService.getRecentHistory();
        return ResponseEntity.ok(history);
    }
}
