package com.tingomaria.touristforecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TouristForecastApplication {

    public static void main(String[] args) {
        SpringApplication.run(TouristForecastApplication.class, args);
    }
}
