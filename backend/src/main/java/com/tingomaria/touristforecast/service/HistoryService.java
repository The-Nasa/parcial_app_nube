package com.tingomaria.touristforecast.service;

import com.tingomaria.touristforecast.dto.HistoricalDataDTO;
import com.tingomaria.touristforecast.model.HistoricalAttendance;
import com.tingomaria.touristforecast.repository.HistoricalAttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    private final HistoricalAttendanceRepository repository;

    public HistoryService(HistoricalAttendanceRepository repository) {
        this.repository = repository;
    }

    public List<HistoricalDataDTO> getRecentHistory() {
        List<HistoricalAttendance> records = repository.findTop30ByOrderByRecordDateDesc();
        return records.stream()
                .map(r -> new HistoricalDataDTO(
                        r.getRecordDate(),
                        r.getActualVisitors(),
                        r.getTempCelsius(),
                        r.getPrecipitationMm(),
                        r.getWeatherCondition(),
                        r.getRecordDate().getDayOfWeek().toString()
                ))
                .toList();
    }
}
