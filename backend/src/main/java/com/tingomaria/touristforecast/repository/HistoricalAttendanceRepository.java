package com.tingomaria.touristforecast.repository;

import com.tingomaria.touristforecast.model.HistoricalAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HistoricalAttendanceRepository extends JpaRepository<HistoricalAttendance, Long> {

    Optional<HistoricalAttendance> findByRecordDate(LocalDate recordDate);

    List<HistoricalAttendance> findTop30ByOrderByRecordDateDesc();
}
