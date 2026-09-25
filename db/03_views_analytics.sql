-- ====================================================================
-- VISTAS ANALÍTICAS PARA SUPABASE DASHBOARD / INSIGHTS DE TURISMO
-- ====================================================================

-- 1. Vista: Resumen Mensual de Visitas y Clima Promedio
CREATE OR REPLACE VIEW v_monthly_tourist_summary AS
SELECT 
    TO_CHAR(record_date, 'YYYY-MM') AS month_year,
    COUNT(*) AS recorded_days,
    SUM(actual_visitors) AS total_visitors,
    ROUND(AVG(actual_visitors), 1) AS avg_daily_visitors,
    ROUND(AVG(temp_celsius)::numeric, 1) AS avg_temperature_c,
    ROUND(SUM(precipitation_mm)::numeric, 1) AS total_rain_mm
FROM historical_attendance
GROUP BY TO_CHAR(record_date, 'YYYY-MM')
ORDER BY month_year DESC;

-- 2. Vista: Impacto del Clima en la Concurrencia a Catarata Derrepente
CREATE OR REPLACE VIEW v_weather_impact_analysis AS
SELECT 
    weather_condition,
    COUNT(*) AS days_count,
    ROUND(AVG(actual_visitors), 1) AS avg_visitors,
    ROUND(AVG(precipitation_mm)::numeric, 1) AS avg_rain_mm
FROM historical_attendance
GROUP BY weather_condition
ORDER BY avg_visitors DESC;

-- 3. Vista: Predicciones Recientes vs Clima Solicitado
CREATE OR REPLACE VIEW v_recent_predictions_summary AS
SELECT 
    id,
    requested_date,
    estimated_visitors,
    crowd_level,
    safety_status,
    forecast_temp,
    forecast_rain_mm,
    query_timestamp
FROM prediction_logs
ORDER BY query_timestamp DESC
LIMIT 50;
