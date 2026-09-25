-- ====================================================================
-- SISTEMA DE PREDICCIÓN TURÍSTICA - CATARATA DERREPENTE (TINGO MARÍA)
-- Script DDL de Base de Datos para Supabase (PostgreSQL)
-- ====================================================================

-- 1. EXTENSIONES POSTGRESQL (Para utilidades adicionales)
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- 2. TABLA: LUGARES TURÍSTICOS (Destinos)
CREATE TABLE IF NOT EXISTS tourist_locations (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL UNIQUE,
    region VARCHAR(100) NOT NULL DEFAULT 'Huánuco',
    province VARCHAR(100) NOT NULL DEFAULT 'Leoncio Prado',
    district VARCHAR(100) NOT NULL DEFAULT 'Rupa-Rupa',
    latitude DOUBLE PRECISION NOT NULL DEFAULT -9.2942,
    longitude DOUBLE PRECISION NOT NULL DEFAULT -76.0003,
    description TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Insertar Catarata Derrepente por defecto
INSERT INTO tourist_locations (name, region, province, district, latitude, longitude, description)
VALUES ('Catarata Derrepente', 'Huánuco', 'Leoncio Prado', 'Rupa-Rupa', -9.2942, -76.0003, 'Imponente catarata rodeada de selva alta en el Parque Nacional Tingo María')
ON CONFLICT (name) DO NOTHING;

-- 3. TABLA: REGISTROS HISTÓRICOS DE AFLUENCIA Y CLIMA PASADO
CREATE TABLE IF NOT EXISTS historical_attendance (
    id BIGSERIAL PRIMARY KEY,
    location_id BIGINT REFERENCES tourist_locations(id) ON DELETE CASCADE,
    record_date DATE NOT NULL UNIQUE,
    actual_visitors INTEGER NOT NULL CHECK (actual_visitors >= 0),
    temp_celsius DOUBLE PRECISION NOT NULL,
    precipitation_mm DOUBLE PRECISION NOT NULL CHECK (precipitation_mm >= 0),
    humidity_percentage DOUBLE PRECISION DEFAULT 75.0,
    wind_kmh DOUBLE PRECISION DEFAULT 10.0,
    weather_condition VARCHAR(100) NOT NULL,
    is_weekend BOOLEAN NOT NULL DEFAULT FALSE,
    is_holiday BOOLEAN NOT NULL DEFAULT FALSE,
    season VARCHAR(50) NOT NULL CHECK (season IN ('TEMPORADA_SECA', 'TEMPORADA_LLUVIAS')),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- 4. TABLA: AUDITORÍA Y LOGS DE PREDICCIONES GENERADAS
CREATE TABLE IF NOT EXISTS prediction_logs (
    id BIGSERIAL PRIMARY KEY,
    location_id BIGINT REFERENCES tourist_locations(id) ON DELETE CASCADE,
    requested_date DATE NOT NULL,
    estimated_visitors INTEGER NOT NULL CHECK (estimated_visitors >= 0),
    crowd_level VARCHAR(50) NOT NULL CHECK (crowd_level IN ('BAJA', 'MODERADA', 'ALTA', 'MUY_ALTA')),
    safety_status VARCHAR(50) NOT NULL CHECK (safety_status IN ('SEGURO', 'PRECAUCION', 'ALERTA_PELIGRO')),
    forecast_temp DOUBLE PRECISION NOT NULL,
    forecast_rain_mm DOUBLE PRECISION NOT NULL,
    recommendation TEXT,
    query_timestamp TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- 5. ÍNDICES DE RENDIMIENTO Y OPTIMIZACIÓN
CREATE INDEX IF NOT EXISTS idx_historical_date ON historical_attendance(record_date);
CREATE INDEX IF NOT EXISTS idx_historical_season ON historical_attendance(season);
CREATE INDEX IF NOT EXISTS idx_prediction_logs_date ON prediction_logs(requested_date);
CREATE INDEX IF NOT EXISTS idx_prediction_logs_timestamp ON prediction_logs(query_timestamp DESC);

-- 6. POLÍTICAS DE SEGURIDAD NATIVAS DE SUPABASE (Row Level Security - RLS)
ALTER TABLE tourist_locations ENABLE ROW LEVEL SECURITY;
ALTER TABLE historical_attendance ENABLE ROW LEVEL SECURITY;
ALTER TABLE prediction_logs ENABLE ROW LEVEL SECURITY;

-- Permiso de Lectura Pública (Anon & Authenticated)
CREATE POLICY "Permitir lectura publica a destinos" ON tourist_locations FOR SELECT USING (true);
CREATE POLICY "Permitir lectura publica a historico" ON historical_attendance FOR SELECT USING (true);
CREATE POLICY "Permitir lectura publica a logs" ON prediction_logs FOR SELECT USING (true);

-- Permiso de Inserción para Servicio Backend / Authenticated
CREATE POLICY "Permitir insercion a backend historico" ON historical_attendance FOR INSERT WITH CHECK (true);
CREATE POLICY "Permitir insercion a backend logs" ON prediction_logs FOR INSERT WITH CHECK (true);
