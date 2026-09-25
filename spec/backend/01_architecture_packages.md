# Spec Backend 01: Arquitectura de Software y Paquetes Java

## 1. Stack Tecnológico Backend
- **Lenguaje:** Java 17 LTS
- **Framework:** Spring Boot 3.2.x
- **Persistencia:** Spring Data JPA + Driver PostgreSQL (Supabase)
- **Caché:** Spring Cache (`@EnableCaching`)
- **Cliente HTTP:** RestTemplate / WebClient para API de Clima
- **Documentación:** Springdoc OpenAPI / Swagger (`/swagger-ui.html`)

---

## 2. Estructura de Paquetes (`com.tingomaria.touristforecast`)

```
src/main/java/com/tingomaria/touristforecast/
├── config/
│   ├── AppConfig.java          # RestTemplate Bean, CorsFilter, CacheConfig
│   ├── SupabaseConfig.java     # Configuración de DataSource PostgreSQL Supabase
│   └── OpenAPIConfig.java      # Documentación Swagger
├── controller/
│   ├── ForecastController.java # Endpoint GET /api/v1/predictions/forecast
│   └── HistoryController.java  # Endpoint GET /api/v1/history
├── service/
│   ├── ForecastService.java    # Lógica de cálculo de afluencia
│   ├── WeatherService.java     # Consumo de API externa de clima
│   └── HistoryService.java     # Consulta a Supabase DB
├── repository/
│   ├── HistoricalAttendanceRepository.java # JpaRepository para Supabase
│   └── PredictionLogRepository.java         # Log de predicciones
├── client/
│   ├── WeatherApiClient.java   # Integración con OpenWeatherMap/WeatherAPI
│   └── dto/                    # Mapping DTOs de la API climática externa
├── model/
│   ├── HistoricalAttendance.java # Entidad JPA mapeada a tabla historical_attendance
│   └── PredictionLog.java        # Entidad JPA mapeada a tabla prediction_logs
├── dto/
│   ├── ForecastResponseDTO.java
│   ├── WeatherDTO.java
│   ├── PredictionDetailsDTO.java
│   └── HistoricalDataDTO.java
└── exception/
    ├── GlobalExceptionHandler.java
    └── WeatherApiException.java
```
