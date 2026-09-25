package com.tingomaria.touristforecast.service;

import com.tingomaria.touristforecast.model.HistoricalAttendance;
import com.tingomaria.touristforecast.repository.HistoricalAttendanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataSeeder.class);

    private final HistoricalAttendanceRepository repository;

    public DataSeeder(HistoricalAttendanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            log.info("Inicializando datos historicos de prueba en la base de datos Supabase / H2...");
            List<HistoricalAttendance> sampleData = new ArrayList<>();
            LocalDate start = LocalDate.now().minusDays(20);

            for (int i = 0; i < 20; i++) {
                LocalDate date = start.plusDays(i);
                boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
                double rain = (i % 4 == 0) ? (i * 1.5) : 0.0;
                double temp = 27.0 + (i % 3);
                int visitors = isWeekend ? (130 + (i * 3)) : (45 + (i * 2));
                if (rain > 10.0) visitors = 25;

                String condition = rain > 10.0 ? "Lluvia Moderada" : (rain > 0 ? "Lluvia Ligera" : "Soleado");

                sampleData.add(new HistoricalAttendance(
                        date,
                        visitors,
                        temp,
                        rain,
                        condition,
                        isWeekend,
                        false
                ));
            }

            repository.saveAll(sampleData);
            log.info("¡Seeder completado! Insertados {} registros historicos.", sampleData.size());
        }
    }
}
