package com.tingomaria.touristforecast.repository;

import com.tingomaria.touristforecast.model.PredictionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictionLogRepository extends JpaRepository<PredictionLog, Long> {
}
