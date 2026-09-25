-- ====================================================================
-- SCRIPT DE DATOS HISTÓRICOS REALISTAS PARA SUPABASE
-- Destino: Catarata Derrepente, Tingo María - Huánuco
-- ====================================================================

-- Asegurar que existe el ID de Catarata Derrepente
DO $$
DECLARE
    loc_id BIGINT;
BEGIN
    SELECT id INTO loc_id FROM tourist_locations WHERE name = 'Catarata Derrepente' LIMIT 1;

    -- Insertar dataset de 30 días representativos
    INSERT INTO historical_attendance (location_id, record_date, actual_visitors, temp_celsius, precipitation_mm, humidity_percentage, wind_kmh, weather_condition, is_weekend, is_holiday, season)
    VALUES
    (loc_id, '2026-08-01', 145, 29.5, 0.0, 70.0, 8.0, 'Soleado', true, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-02', 190, 30.0, 0.0, 68.0, 10.0, 'Soleado', true, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-03', 48, 27.5, 1.2, 75.0, 12.0, 'Parcialmente Nublado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-04', 52, 28.0, 0.0, 72.0, 9.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-05', 50, 27.8, 0.5, 74.0, 11.0, 'Parcialmente Nublado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-06', 58, 28.5, 0.0, 71.0, 10.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-07', 75, 29.0, 0.0, 70.0, 10.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-08', 160, 29.8, 0.0, 69.0, 9.0, 'Soleado', true, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-09', 210, 30.2, 0.0, 67.0, 11.0, 'Soleado', true, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-10', 42, 25.0, 6.5, 85.0, 14.0, 'Lluvia Ligera', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-11', 18, 23.5, 22.0, 92.0, 18.0, 'Lluvia Torrencial', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-12', 35, 24.8, 8.2, 88.0, 15.0, 'Lluvia Moderada', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-13', 55, 27.0, 0.0, 76.0, 10.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-14', 68, 28.2, 0.0, 73.0, 9.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-15', 155, 29.0, 0.0, 71.0, 10.0, 'Soleado', true, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-16', 198, 29.7, 0.0, 68.0, 12.0, 'Soleado', true, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-17', 46, 26.5, 2.0, 80.0, 11.0, 'Parcialmente Nublado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-18', 50, 27.0, 0.0, 77.0, 10.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-19', 53, 27.4, 0.0, 75.0, 9.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-20', 60, 28.0, 0.0, 73.0, 10.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-21', 72, 28.5, 0.0, 72.0, 11.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-22', 150, 29.2, 0.0, 70.0, 9.0, 'Soleado', true, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-23', 185, 29.6, 0.0, 69.0, 10.0, 'Soleado', true, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-24', 44, 26.0, 3.5, 82.0, 13.0, 'Lluvia Ligera', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-25', 49, 27.1, 0.0, 78.0, 10.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-26', 54, 27.5, 0.0, 76.0, 9.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-27', 62, 28.1, 0.0, 74.0, 10.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-28', 78, 28.7, 0.0, 71.0, 11.0, 'Soleado', false, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-29', 165, 29.4, 0.0, 69.0, 10.0, 'Soleado', true, false, 'TEMPORADA_SECA'),
    (loc_id, '2026-08-30', 280, 30.5, 0.0, 65.0, 12.0, 'Soleado', true, true, 'TEMPORADA_SECA') -- Feriado Santa Rosa de Lima
    ON CONFLICT (record_date) DO NOTHING;
END $$;
