# Spec Backend 02: Integración con API Externa de Clima

## 1. Configuración de API de Clima
- **Proveedor:** WeatherAPI (o OpenWeatherMap API).
- **Parámetros de Entrada:**
  - Coordenadas Tingo María: `lat=-9.2942`, `lon=-76.0003` o query `Tingo Maria`.
  - Días de Pronóstico: Hasta 7 días.
- **Variables de Entorno Backend:**
  - `WEATHER_API_KEY`: Clave secreta obtenida del proveedor de clima.
  - `WEATHER_API_URL`: `https://api.weatherapi.com/v1/forecast.json`.

---

## 2. Estrategia de Caché y Resiliencia
- **Caché Spring (`@Cacheable("weatherCache")`):** Retiene el objeto `WeatherDTO` por 30 minutos por fecha para minimizar consumo de cuota de la API externa.
- **Fallback Resiliente:** En caso de caída de la API externa de clima (HTTP 5xx o Timeout > 3s), el servicio captura la excepción mediante `GlobalExceptionHandler` o `WeatherServiceFallback` y retorna estimaciones basadas en los promedios climatológicos de la base de datos Supabase para ese mes.
